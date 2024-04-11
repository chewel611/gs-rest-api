package org.geoserver.restconfig.api.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.v1.model.TileLayerRequest;
import org.geoserver.openapi.v1.model.TileLayerResponse;
import org.geoserver.openapi.v1.model.TileLayerSeed;
import org.geoserver.openapi.v1.model.TileLayerSeedRequest;

import java.util.List;

/**
 * 切片图层接口
 */
public interface TileLayersApi extends ApiClient.Api {
    /**
     * 获取切片图层列表
     */
    @RequestLine("GET /gwc/rest/layers")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    List<String> getList();

    /**
     * 获取切片图层详情
     */
    @RequestLine("GET /gwc/rest/layers/{layerName}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    TileLayerResponse get(@Param("layerName") String layerName);

    /**
     * 添加或者更新切片图层
     * @param layerName
     * @param tileLayer
     */
    @RequestLine("PUT /gwc/rest/layers/{layerName}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    void createOrUpdate(@Param("layerName") String layerName, TileLayerRequest tileLayer);

    /**
     * 删除图层切片
     * @param layerName
     */
    @RequestLine("DELETE /gwc/rest/layers/{layerName}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    void remove(@Param("layerName") String layerName);

    /**
     * 发出种子、重新播种或截断任务请求
     * @param layerName
     * @param seedRequest
     */
    @RequestLine("POST /gwc/rest/seed/{layerName}.json")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    void seed(@Param("layerName") String layerName, TileLayerSeedRequest seedRequest);

    /**
     * 清除与命名层关联的所有缓存
     * @param body
     */
    @RequestLine("POST /gwc/rest/masstruncate")
    @Headers({
            "Content-Type: text/xml",
            "Accept: application/json"
    })
    void truncate(byte[] body);
}
