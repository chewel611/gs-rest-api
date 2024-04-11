package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Objects;

@JsonPropertyOrder({
        ResourceFileMetadata.JSON_PROPERTY_NAME,
        ResourceFileMetadata.JSON_PROPERTY_TYPE,
        ResourceFileMetadata.JSON_PROPERTY_PARENT
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResourceFileMetadata {
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_TYPE = "type";
    public static final String JSON_PROPERTY_PARENT = "parent";

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String name;

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String type;

    @JsonProperty(JSON_PROPERTY_PARENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private ResourceFileMetadataParent parent;

    /**
     * 是否是目录
     * @return
     */
    public boolean isDirectory() {
        return Objects.equals(type, "directory");
    }

    /**
     * 资源是否存在
     * @return
     */
    public boolean isExists() {
        return !Objects.equals(type, "undefined");
    }
}
