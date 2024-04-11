package org.geoserver.restconfig.client;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjUtil;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.geoserver.openapi.v1.model.*;
import org.geoserver.restconfig.api.client.LayerGroupsApi;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class LayerGroupsClient {
    private @NonNull GeoServerClient client;

    LayerGroupsApi api() {
        return client.api(LayerGroupsApi.class);
    }

    /**
     * 获取工作空间内的图层组列表
     *
     * @param workspaceName 工作空间名称
     * @return List<NamedLink>
     */
    public List<NamedLink> getLayerGroups(@NonNull String workspaceName) {
        LayerGroupInfoList layerGroups = api().getLayerGroupsByWorkspace(workspaceName);
        if (ObjUtil.isNull(layerGroups) || ObjUtil.isNull(layerGroups.getLayerGroups())) {
            return ListUtil.list(false);
        }
        return layerGroups.getLayerGroups().getLayerGroup();
    }

    /**
     * 获取工作空间内指定的详情
     * @param qualifiedLayerGroupName
     * @return
     */
    public Optional<LayerGroupInfo> getLayerGroup(String qualifiedLayerGroupName) {
        if(qualifiedLayerGroupName.indexOf(":")<=0) {
            throw new IllegalArgumentException("qualifiedLayerGroupName is illegal, eg: workspaceName:layerGroupName");
        }
        try {
            LayerGroupResponse layerGroup = api().getLayerGroup(qualifiedLayerGroupName);
            return Optional.ofNullable(layerGroup.getLayerGroupInfo());
        } catch (ServerException.NotFound nf) {
            return Optional.empty();
        }
    }

    /**
     * 获取工作空间内指定图层组的详情
     *
     * @param workspaceName 工作空间名称
     * @param layerGroupName 图层组名
     * @return Optional<LayerGroup>
     */
    public Optional<LayerGroupInfo> getLayerGroup(
            @NonNull String workspaceName, @NonNull String layerGroupName) {
        try {
            LayerGroupInfo layerGroupInfo =
                    api().getLayerGroupByWorkspace(workspaceName, layerGroupName)
                            .getLayerGroupInfo();
            return Optional.ofNullable(layerGroupInfo);
        } catch (ServerException.NotFound nf) {
            return Optional.empty();
        }
    }

    /**
     * 在具体工作空间上创建图层组
     *
     * @param workspaceName 工作空间名称
     * @param info 图层组信息
     * @return LayerGroup
     */
    public LayerGroupInfo create(@NonNull String workspaceName, @NonNull LayerGroupInfo info) {
        if (ObjUtil.isNull(info.getPublishables())
                || CollUtil.isEmpty(info.getPublishables().getPublished())) {
            throw new IllegalArgumentException("LayerGroup publishables must be not null");
        }
        checkWorkspaceName(workspaceName, info);
        checkLayerAndStyleNumber(workspaceName, info);

        LayerGroupInfoWrapper wrapper = new LayerGroupInfoWrapper().setLayerGroup(info);
        api().createLayerGroupOnWorkspace(workspaceName, wrapper);

        LayerGroupResponse layerGroupByWorkspace =
                api().getLayerGroupByWorkspace(workspaceName, info.getName());
        return layerGroupByWorkspace.getLayerGroupInfo();
    }

    /**
     * 在具体工作空间上更新图层组
     *
     * @param workspaceName 工作空间名称
     * @param currentName 当前图层组信息
     * @param info 图层组信息
     * @return LayerGroup
     */
    public LayerGroupInfo update(
            @NonNull String workspaceName,
            @NonNull String currentName,
            @NonNull LayerGroupInfo info
    ) {
        if (ObjUtil.isNull(info.getPublishables())) {
            throw new IllegalArgumentException("LayerGroup publishables must be not null");
        }
        checkWorkspaceName(workspaceName, info);
        checkLayerAndStyleNumber(workspaceName, info);

        LayerGroupInfoWrapper wrapper = new LayerGroupInfoWrapper().setLayerGroup(info);
        api().updateLayerGroupOnWorkspace(workspaceName, currentName, wrapper);

        LayerGroupResponse layerGroupByWorkspace =
                api().getLayerGroupByWorkspace(workspaceName, currentName);
        return layerGroupByWorkspace.getLayerGroupInfo();
    }

    /**
     * 删除图层组
     *
     * @param workspaceName 工作空间名称
     * @param layerGroupName 图层组名称
     */
    public void delete(@NonNull String workspaceName, @NonNull String layerGroupName) {
        api().deleteLayerGroupOnWorkspace(workspaceName, layerGroupName);
    }

    /**
     * 检查工作空间是否一致
     *
     * @param workspaceName 工作空间
     * @param info 图层组信息
     */
    private static void checkWorkspaceName(String workspaceName, LayerGroupInfo info) {
        if (ObjUtil.isNotNull(info.getWorkspace())
                && ObjUtil.notEqual(workspaceName, info.getWorkspace().getName())) {
            log.info(
                    "Unsetting LayerGroupInfo workspace '{}' to make sure geoserver creates it on the requested workspace '{}'",
                    info.getWorkspace().getName(),
                    workspaceName);
            info.setWorkspace(null);
        }
    }

    /**
     * 检查图层数量和样式数量是否一样
     *
     * @param workspaceName 工作空间
     * @param info 图层组信息
     */
    private static void checkLayerAndStyleNumber(String workspaceName, LayerGroupInfo info) {
        if (ObjUtil.isNotNull(info.getStyles())
                && CollUtil.isNotEmpty(info.getStyles().getStyle())) {
            int layerSize = info.getPublishables().getPublished().size();
            int styleSize = info.getStyles().getStyle().size();

            if (!Objects.equals(layerSize, styleSize)) {
                log.info(
                        "Unsetting LayerGroupInfo style, style number is not equal layer number, layerGroupName: {}, workspace: {}",
                        info.getName(),
                        workspaceName);
                info.setStyles(new LayerStyles());
            }
        }
    }
}
