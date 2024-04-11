package org.geoserver.restconfig.client;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.geoserver.openapi.v1.constants.GSCommonConstants;
import org.geoserver.openapi.v1.model.*;
import org.geoserver.restconfig.api.client.TileLayersApi;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class TileLayersClient {
    private @NonNull GeoServerClient client;



    TileLayersApi api() {
        return this.client.api(TileLayersApi.class);
    }

    /**
     * 获取切片图层列表
     * @return
     */
    public List<NamedLink> getList() {
        List<String> list = api().getList();
        if(CollUtil.isNotEmpty(list)) {
            List<NamedLink> namedLinks = list.stream()
                    .map(s -> new NamedLink().name(s).href(createCachedLayerHref(s)))
                    .collect(Collectors.toList());
            return namedLinks;
        }

        return null;
    }


    /**
     * 获取切片图层详情
     * @param cachedLayerName
     * @return
     */
    public TileLayerInfo get(String layerName) {
        if(StrUtil.isBlank(layerName)) {
            throw new IllegalArgumentException("layerName is not blank");
        }
        if(layerName.indexOf(":") <= 0) {
            throw new IllegalArgumentException("layerName can't match, must be contain [workspace name:layer name]");
        }
        try {
            TileLayerResponse tileLayerResponse = api().get(layerName);
            return tileLayerResponse.getTileLayerInfo();
        } catch (ServerException.NotFound nf) {
            log.warn("got tile layer not found: {}", layerName);
            return null;
        }
    }

    /**
     * 创建或更新切片图层
     * @param tileLayerInfo
     * @return
     */
    public void createOrUpdate(TileLayer tileLayer) {
        if(ObjUtil.isNull(tileLayer)) {
            throw new IllegalArgumentException("tileLayer is not blank");
        }
        if(StrUtil.isBlank(tileLayer.getLayerName())) {
            throw new IllegalArgumentException("tileLayer.name is not blank");
        }
        if(StrUtil.indexOf(tileLayer.getLayerName(), ':') <= 0) {
            throw new IllegalArgumentException("tileLayer.name can't match, must be contain [workspace name:layer name]");
        }

        Boolean layerIsExists = true;
        Optional<Layer> layer = client.layers().getLayer(tileLayer.getLayerName());
        if(!layer.isPresent()) {
            layerIsExists = false;
            log.warn("got layer not found: {}", tileLayer.getLayerName());
        }
        if(layerIsExists == false) {
            Optional<LayerGroupInfo> layerGroup = client.layerGroups().getLayerGroup(tileLayer.getLayerName());
            if(!layerGroup.isPresent()) {
                log.warn("got layer group not found: {}", tileLayer.getLayerName());
                throw new IllegalArgumentException("geoserver can not found layer or layer group: "+ tileLayer.getLayerName());
            }
        }

        TileLayerRequest tileLayerRequest = new TileLayerRequest(tileLayer);
        api().createOrUpdate(tileLayer.getLayerName(), tileLayerRequest);
    }

    /**
     * 删除图层切片
     * @param layerName
     */
    public void remove(String layerName) {
        if(StrUtil.isBlank(layerName)) {
            throw new IllegalArgumentException("layerName is not blank");
        }
        if(StrUtil.indexOf(layerName, ':') <= 0) {
            throw new IllegalArgumentException("layerName can't match, must be contain [workspace name:layer name]");
        }
        TileLayerInfo tileLayerInfo = get(layerName);
        if(ObjUtil.isNull(tileLayerInfo)) {
            throw new IllegalArgumentException("tile layer not found: "+ layerName);
        }
        api().remove(layerName);
    }

    /**
     * 执行切片
     * @param tileLayerSeed
     */
    public void seed(TileLayerSeed tileLayerSeed) {
        if(ObjUtil.isNull(tileLayerSeed)) {
            throw new IllegalArgumentException("tileLayerSeed is not null");
        }
        if(StrUtil.isBlank(tileLayerSeed.getLayerName())) {
            throw new IllegalArgumentException("layerName is not blank");
        }
        if(StrUtil.isBlank(tileLayerSeed.getGridSetId())) {
            throw new IllegalArgumentException("gridSetId is not blank");
        }

        GridSetInfo gridSetInfo = client.gridsets().get(tileLayerSeed.getGridSetId());
        if(ObjUtil.isNull(gridSetInfo)) {
            throw new IllegalArgumentException("gridSet not found: "+ tileLayerSeed.getGridSetId());
        }

        if(ObjUtil.isNull(tileLayerSeed.getBounds())) {
            tileLayerSeed.setBounds(new BoundingBox(gridSetInfo.getOriginalExtent().getCoords()));
        }

        TileLayerSeedRequest tileLayerSeedRequest = new TileLayerSeedRequest(tileLayerSeed);
        api().seed(tileLayerSeed.getLayerName(), tileLayerSeedRequest);
    }

    /**
     * 清除图层缓存
     * @param layerName
     */
    public void truncate(String layerName) {
        if(StrUtil.isBlank(layerName)) {
            throw new IllegalArgumentException("layerName is not blank");
        }
        TileLayerInfo tileLayerInfo = get(layerName);
        String truncateLayer = String.format(GSCommonConstants.TRUNCATE_LAYER,layerName);
        api().truncate(truncateLayer.getBytes(StandardCharsets.UTF_8));

        if(CollUtil.isNotEmpty(tileLayerInfo.getGridSubSets())) {
            for (GridSubSetInfo gridSubSet : tileLayerInfo.getGridSubSets()) {
                String truncateExtent = String.format(GSCommonConstants.TRUNCATE_EXTENT,layerName,gridSubSet.getGridSetName());
                api().truncate(truncateExtent.getBytes(StandardCharsets.UTF_8));
            }
        }
    }



    /**
     * 生成切片图层详情的地址
     * @param cachedLayerName
     * @return
     */
    private String createCachedLayerHref(String cachedLayerName) {
        return String.format("%s/gwc/rest/layers/%s.json", client.getBaseURL(), cachedLayerName);
    }
}
