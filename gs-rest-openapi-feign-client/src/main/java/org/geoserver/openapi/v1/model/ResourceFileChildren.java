package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@JsonPropertyOrder({
        ResourceFileChildren.JSON_PROPERTY_CHILD
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResourceFileChildren {
    public static final String JSON_PROPERTY_CHILD = "child";

    @JsonProperty(JSON_PROPERTY_CHILD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private List<ResourceFile> child;
}
