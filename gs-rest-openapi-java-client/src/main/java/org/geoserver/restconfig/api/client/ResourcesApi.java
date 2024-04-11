package org.geoserver.restconfig.api.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.v1.model.ResourceFileMetadataResponse;
import org.geoserver.openapi.v1.model.ResourceFileResponse;

public interface ResourcesApi extends ApiClient.Api {
    /**
     * 下载资源
     */
    @RequestLine("GET /rest/resource/{pathToResource}?operation=default")
    @Headers({
            "Content-Type: application/json",
            "Accept-Encoding: identity"
    })
    byte[] downloadFile(@Param("pathToResource") String pathToResource);

    /**
     * 列出目录内容
     * @param pathToResource
     */
    @RequestLine("GET /rest/resource/{pathToResource}?operation=default&format=json")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Accept-Encoding: identity"
    })
    ResourceFileResponse listResources(@Param("pathToResource") String pathToResource);

    /**
     * 获取资源的元数据
     * @param pathToResource
     * @return
     */
    @RequestLine("GET /rest/resource/{pathToResource}?operation=metadata&format=json")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Accept-Encoding: identity"
    })
    ResourceFileMetadataResponse getMetadata(@Param("pathToResource") String pathToResource);

    /**
     * 上传资源,如果资源存在会替换
     * @param pathToResource
     * @param body
     */
    @RequestLine("PUT /rest/resource/{pathToResource}?operation=default")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Accept-Encoding: identity"
    })
    void uploadResource(@Param("pathToResource") String pathToResource, byte[] body);
}
