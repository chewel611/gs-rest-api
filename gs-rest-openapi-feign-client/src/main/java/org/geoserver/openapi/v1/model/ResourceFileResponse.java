package org.geoserver.openapi.v1.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        ResourceFileResponse.JSON_PROPERTY_RESOURCE_DIRECTORY
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResourceFileResponse {
    public static final String JSON_PROPERTY_RESOURCE_DIRECTORY = "ResourceDirectory";

    @JsonProperty(JSON_PROPERTY_RESOURCE_DIRECTORY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private ResourceFile directory;
}
