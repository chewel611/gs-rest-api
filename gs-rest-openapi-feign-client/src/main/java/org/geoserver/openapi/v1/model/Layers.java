/*
 * GeoServer Layers
 * A layer is a published resource (feature type or coverage).
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.geoserver.openapi.v1.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.geoserver.openapi.v1.model.LayerReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Layers
 */
@JsonPropertyOrder({
  Layers.JSON_PROPERTY_LAYERS
})

public class Layers {
  public static final String JSON_PROPERTY_LAYERS = "layers";
  private LayerReference layers;


  public Layers layers(LayerReference layers) {
    
    this.layers = layers;
    return this;
  }

   /**
   * Get layers
   * @return layers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LAYERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LayerReference getLayers() {
    return layers;
  }


  public void setLayers(LayerReference layers) {
    this.layers = layers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Layers layers = (Layers) o;
    return Objects.equals(this.layers, layers.layers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(layers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Layers {\n");
    sb.append("    layers: ").append(toIndentedString(layers)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

