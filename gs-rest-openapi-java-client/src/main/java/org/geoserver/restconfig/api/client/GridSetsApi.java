package org.geoserver.restconfig.api.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.v1.model.GridSetInfoResponse;
import org.geoserver.openapi.v1.model.GridSetRequest;

import java.util.Set;

public interface GridSetsApi  extends ApiClient.Api{
    /**
     * 获取所有已配置网格集的列表
     * @return
     */
    @RequestLine("GET /gwc/rest/gridsets")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Set<String> getGridSets();

    /**
     * 获取网格集
     * @param gridsetName
     * @return
     */
    @RequestLine("GET /gwc/rest//gridsets/{gridsetName}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    GridSetInfoResponse getGridSet(@Param("gridsetName") String gridsetName);

    /**
     * 删除网格集
     * @param gridsetName
     */
    @RequestLine("DELETE /gwc/rest//gridsets/{gridsetName}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void deleteGridSet(@Param("gridsetName")String gridsetName);

    /**
     * 保存网格集, 存在在更新，不存在则新增
     * @param gridsetName
     * @param gridSet
     */
    @RequestLine("PUT /gwc/rest//gridsets/{gridsetName}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void saveGridSet(@Param("gridsetName") String gridsetName, GridSetRequest gridSet);
}
