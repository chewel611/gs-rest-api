package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonPropertyOrder({LayerGroupReference.JSON_PROPERTY_LAYER_GROUPS})
public class LayerGroupReference {
    public static final String JSON_PROPERTY_LAYER_GROUPS = "layerGroup";

    private List<NamedLink> layerGroup;

    public LayerGroupReference layerGroup(List<NamedLink> layerGroup) {
        this.layerGroup = layerGroup;
        return this;
    }

    public LayerGroupReference addLayerGroupItem(NamedLink layerGroupItem) {
        if (this.layerGroup == null) {
            this.layerGroup = new ArrayList<>();
        }
        this.layerGroup.add(layerGroupItem);
        return this;
    }

    /**
     * Get layer
     *
     * @return layer
     */
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAYER_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<NamedLink> getLayerGroup() {
        return layerGroup;
    }

    @JsonProperty(JSON_PROPERTY_LAYER_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLayerGroup(List<NamedLink> layerGroup) {
        this.layerGroup = layerGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LayerGroupReference layerGroupReference = (LayerGroupReference) o;
        return Objects.equals(this.layerGroup, layerGroupReference.layerGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layerGroup);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LayerGroupReference {\n");
        sb.append("    layerGroup: ").append(toIndentedString(layerGroup)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
