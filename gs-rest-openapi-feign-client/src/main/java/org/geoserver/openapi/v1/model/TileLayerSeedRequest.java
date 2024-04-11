package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        TileLayerSeedRequest.JSON_PROPERTY_SEED_REQUEST
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TileLayerSeedRequest {
    public static final String JSON_PROPERTY_SEED_REQUEST = "seedRequest";

    @JsonProperty(JSON_PROPERTY_SEED_REQUEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private TileLayerSeed seedRequest;
}
