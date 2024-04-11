package org.geoserver.restconfig.client;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.geoserver.openapi.v1.model.ResourceFile;
import org.geoserver.openapi.v1.model.ResourceFileMetadata;
import org.geoserver.openapi.v1.model.ResourceFileMetadataResponse;
import org.geoserver.openapi.v1.model.ResourceFileResponse;
import org.geoserver.restconfig.api.client.ResourcesApi;

import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ResourcesClient {
    private final @NonNull GeoServerClient client;

    ResourcesApi api() {
        return client.api(ResourcesApi.class);
    }

    /**
     * 列出资源列表
     * @param pathToDirectory
     * @return
     */
    public ResourceFile listResources(String pathToDirectory) {
        if(StrUtil.isBlank(pathToDirectory)) {
            pathToDirectory = "";
        }
        ResourceFileMetadata metadata = getMetadata(pathToDirectory);
        if(ObjUtil.isNull(metadata)) {
            throw new RuntimeException("Path not found: "+ pathToDirectory);
        }
        if(!metadata.isDirectory()) {
            throw new RuntimeException("Path is not a directory: "+ pathToDirectory);
        }
        ResourceFileResponse resourceFileResponse = api().listResources(pathToDirectory);
        return resourceFileResponse.getDirectory();
    }

    /**
     * 获取资源的元数据
     * @param pathToResource
     * @return
     */
    public ResourceFileMetadata getMetadata(String pathToResource) {
        if(StrUtil.isBlank(pathToResource)) {
            pathToResource = "";
        }
        ResourceFileMetadataResponse response = api().getMetadata(pathToResource);
        if(response.getResourceMetadata().isExists()) {
            return response.getResourceMetadata();
        }
        return null;
    }

    /**
     * 判断资源是否存在
     * @param pathToResource
     * @return
     */
    public boolean exists(String pathToResource) {
        ResourceFileMetadata metadata = getMetadata(pathToResource);
        return ObjUtil.isNotNull(metadata);
    }

    /**
     * 上传资源
     * @param pathToResource
     * @param body
     */
    public void upload(String pathToResource, InputStream body) {
        if(ObjUtil.isNull(body)) {
            throw new RuntimeException("upload resource body is null");
        }
        byte[] bytes = IoUtil.readBytes(body);
        upload(pathToResource, bytes);
    }

    /**
     * 上传资源
     * @param pathToResource
     * @param body
     */
    public void upload(String pathToResource, byte[] body) {
        if(ObjUtil.isNull(body)) {
            throw new RuntimeException("upload resource body is null");
        }
        api().uploadResource(pathToResource, body);
    }

    /**
     * 下载资源
     * @param pathToResource
     * @return
     */
    public byte[] download(String pathToResource) {
        ResourceFileMetadata metadata = getMetadata(pathToResource);
        if(ObjUtil.isNull(metadata)) {
            throw new RuntimeException("resource not exists");
        }
        if(metadata.isDirectory()) {
            throw new RuntimeException("resource is directory");
        }
        return api().downloadFile(pathToResource);
    }
}
