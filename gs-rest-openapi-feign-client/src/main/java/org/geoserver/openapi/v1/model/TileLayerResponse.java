package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        TileLayerResponse.JSON_PROPERTY_CACHED_LAYER
})
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TileLayerResponse {
    public static final String JSON_PROPERTY_CACHED_LAYER = "GeoServerLayer";

    @JsonProperty(JSON_PROPERTY_CACHED_LAYER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private TileLayerInfo tileLayerInfo;
}
