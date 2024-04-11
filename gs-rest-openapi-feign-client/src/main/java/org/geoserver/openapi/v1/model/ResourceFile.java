package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        ResourceFile.JSON_PROPERTY_NAME,
        ResourceFile.JSON_PROPERTY_LINK,
        ResourceFile.JSON_PROPERTY_CHILDREN
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResourceFile {
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_LINK = "link";
    public static final String JSON_PROPERTY_CHILDREN = "children";

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String name;

    @JsonProperty(JSON_PROPERTY_LINK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private ResourceFileLink link;

    @JsonProperty(JSON_PROPERTY_CHILDREN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private ResourceFileChildren children;

}
