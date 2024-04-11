package org.geoserver.restconfig.api.client;

import feign.Headers;
import feign.RequestLine;
import org.geoserver.openapi.v1.client.DefaultApi;

public interface ExtendedDefaultApi extends DefaultApi {
    /**
     * 重置所有存储、栅格和模式缓存。
     * 此操作用于强制GeoServer删除所有缓存和存储连接，并在下次请求需要它们时重新连接到它们中的每一个
     */
    @RequestLine("POST /rest/reset")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    void resetGeoServer();

    /**
     * 从磁盘重新加载GeoServer目录和配置。
     * 此操作用于外部工具修改磁盘配置的情况。
     * 此操作还将强制GeoServer删除任何内部缓存并重新连接到所有数据存储
     */
    @RequestLine("POST /rest/reload")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    void reloadGeoServer();

    /**
     * 更改配置后重新加载GeoWebCache设置
     * @param body
     */
    @RequestLine("POST /gwc/rest/reload")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    void reloadGeoWebCache(byte[] body);
}
