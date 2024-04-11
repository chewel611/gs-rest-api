package org.geoserver.restconfig.client;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.geoserver.openapi.v1.model.GridSet;
import org.geoserver.openapi.v1.model.GridSetInfo;
import org.geoserver.openapi.v1.model.GridSetInfoResponse;
import org.geoserver.openapi.v1.model.GridSetRequest;
import org.geoserver.restconfig.api.client.GridSetsApi;

import java.util.Objects;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class GridSetsClient {
    private @NonNull GeoServerClient client;

    GridSetsApi api() {
        return client.api(GridSetsApi.class);
    }

    /**
     * 获取全部网格集
     * @return 网格集的名称列表
     */
    public Set<String> getList() {
        Set<String> gridSetNames = api().getGridSets();
        return gridSetNames;
    }

    /**
     * 根据网格集名称获取网格集信息
     * @param gridSetName
     * @return
     */
    public GridSetInfo get(String gridSetName) {
        if(StrUtil.isBlank(gridSetName)) {
            throw new IllegalArgumentException("gridSetName can not empty");
        }
        try {
            GridSetInfoResponse response = api().getGridSet(gridSetName);
            return response.getGridSet();
        } catch (ServerException.NotFound nf) {
            log.warn("gridSetName:{} not found", gridSetName);
            return null;
        }
    }

    /**
     * 判断网格集是否存在
     * @param gridSetName
     * @return
     */
    public boolean exists(String gridSetName) {
        return getList().stream().anyMatch(s -> Objects.equals(s, gridSetName));
    }

    /**
     * 删除网格集
     * @param gridSetName
     * @return
     */
    public void delete(String gridSetName) {
        if(exists(gridSetName)) {
            try {
                api().deleteGridSet(gridSetName);
            }
            catch (ServerException.NotFound nf) {
                log.warn("gridSetName:{} not found", gridSetName);
            }
        }
    }

    /**
     * 保存网格集
     * @param gridSet
     */
    public void createOrSave(GridSet gridSet) {
        if(ObjUtil.isNull(gridSet)) {
            throw new IllegalArgumentException("gridSet can not empty");
        }
        if(StrUtil.isBlank(gridSet.getName())) {
            throw new IllegalArgumentException("gridSet name can not empty");
        }
        GridSetRequest wrapper = new GridSetRequest(gridSet);
        api().saveGridSet(gridSet.getName(), wrapper);
    }
}
