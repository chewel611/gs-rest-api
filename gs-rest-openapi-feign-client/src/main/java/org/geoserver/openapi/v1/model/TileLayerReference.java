package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@JsonPropertyOrder({
        TileLayerReference.JSON_PROPERTY_LAYER
})
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TileLayerReference {
    public static final String JSON_PROPERTY_LAYER = "layer";

    @JsonProperty(JSON_PROPERTY_LAYER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private List<NamedLink> layer;
}
