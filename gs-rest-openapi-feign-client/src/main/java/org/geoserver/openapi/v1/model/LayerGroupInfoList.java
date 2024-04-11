package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonPropertyOrder({LayerGroupInfoList.JSON_PROPERTY_LAYER_GROUPS})
public class LayerGroupInfoList {
    public static final String JSON_PROPERTY_LAYER_GROUPS = "layerGroups";
    private LayerGroupReference layerGroups;

    /**
     * Get layers
     *
     * @return layers
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAYER_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public LayerGroupReference getLayerGroups() {
        return layerGroups;
    }
}
