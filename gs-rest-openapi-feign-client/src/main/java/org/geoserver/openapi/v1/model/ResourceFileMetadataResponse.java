package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        ResourceFileMetadataResponse.JSON_PROPERTY_RESOURCE_METADATA
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResourceFileMetadataResponse {
    public static final String JSON_PROPERTY_RESOURCE_METADATA = "ResourceMetadata";

    @JsonProperty(JSON_PROPERTY_RESOURCE_METADATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private ResourceFileMetadata resourceMetadata;
}
