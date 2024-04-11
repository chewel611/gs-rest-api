package org.geoserver.restconfig.api.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.v1.model.LayerGroupInfoList;
import org.geoserver.openapi.v1.model.LayerGroupInfoWrapper;
import org.geoserver.openapi.v1.model.LayerGroupResponse;

public interface LayerGroupsApi extends ApiClient.Api {
    @RequestLine("GET /rest/layergroups")
    @Headers({"Accept: application/json"})
    LayerGroupInfoList getLayerGroups();

    @RequestLine("GET /rest/layergroups/{layerGroupName}")
    @Headers({"Accept: application/json"})
    LayerGroupResponse getLayerGroup(@Param("layerGroupName") String layerGroupName);

    @RequestLine("GET /rest/workspaces/{workspaceName}/layergroups")
    @Headers({"Accept: application/json"})
    LayerGroupInfoList getLayerGroupsByWorkspace(@Param("workspaceName") String workspaceName);

    @RequestLine("GET /rest/workspaces/{workspaceName}/layergroups/{layerGroupName}")
    @Headers({"Accept: application/json"})
    LayerGroupResponse getLayerGroupByWorkspace(
            @Param("workspaceName") String workspaceName,
            @Param("layerGroupName") String layerGroupName);

    @RequestLine("POST /rest/layergroups")
    @Headers({
        "Content-Type: application/json",
        "Accept: application/json",
        "Accept-Encoding: gzip"
    })
    void createLayerGroup(LayerGroupInfoWrapper layerGroupInfoWrapper);

    @RequestLine("POST /rest/workspaces/{workspaceName}/layergroups")
    @Headers({
        "Content-Type: application/json",
        "Accept: application/json",
        "Accept-Encoding: identity"
    })
    void createLayerGroupOnWorkspace(
            @Param("workspaceName") String workspaceName,
            LayerGroupInfoWrapper layerGroupInfoWrapper);

    @RequestLine("PUT /rest/layergroups/{layerGroupName}")
    @Headers({
        "Content-Type: application/json",
        "Accept: application/json",
    })
    void updateLayerGroup(
            @Param("layerGroupName") String layerGroupName,
            LayerGroupInfoWrapper layerGroupInfoWrapper);

    @RequestLine("PUT /rest/workspaces/{workspaceName}/layergroups/{layerGroupName}")
    @Headers({
        "Content-Type: application/json",
        "Accept: application/json",
    })
    void updateLayerGroupOnWorkspace(
            @Param("workspaceName") String workspaceName,
            @Param("layerGroupName") String layerGroupName,
            LayerGroupInfoWrapper layerGroupInfoWrapper);

    @RequestLine("DELETE /rest/layergroups/{layerGroupName}")
    @Headers({
        "Accept: application/json",
    })
    void deleteLayerGroup(@Param("layerGroupName") String layerGroupName);

    @RequestLine("DELETE /rest/workspaces/{workspaceName}/layergroups/{layerGroupName}")
    @Headers({
        "Accept: application/json",
    })
    void deleteLayerGroupOnWorkspace(
            @Param("workspaceName") String workspaceName,
            @Param("layerGroupName") String layerGroupName);
}
