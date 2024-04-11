package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonPropertyOrder({LayerGroupResponse.JSON_PROPERTY_LAYER_GROUP})
public class LayerGroupResponse {
    public static final String JSON_PROPERTY_LAYER_GROUP = "layerGroup";
    private LayerGroupInfo layerGroupInfo;

    /**
     * Get layerGroup
     *
     * @return layerGroup
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAYER_GROUP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LayerGroupInfo getLayerGroupInfo() {
        return layerGroupInfo;
    }
}
