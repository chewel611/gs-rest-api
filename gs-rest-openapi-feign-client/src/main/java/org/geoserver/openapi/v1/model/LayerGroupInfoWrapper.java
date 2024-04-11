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
@JsonPropertyOrder({LayerGroupInfoWrapper.JSON_PROPERTY_LAYER_GROUP})
public class LayerGroupInfoWrapper {
    public static final String JSON_PROPERTY_LAYER_GROUP = "layerGroup";
    private LayerGroupInfo layerGroup;

    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAYER_GROUP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LayerGroupInfo getLayerGroup() {
        return layerGroup;
    }
}
