package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
        GridSetRequest.JSON_PROPERTY_GRID_SET
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GridSetRequest {
    public static final String JSON_PROPERTY_GRID_SET = "gridSet";

    @JsonProperty(JSON_PROPERTY_GRID_SET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private GridSet gridSet;
}
