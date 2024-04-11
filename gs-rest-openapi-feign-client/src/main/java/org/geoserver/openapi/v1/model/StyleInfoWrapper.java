/*
 * GeoServer Styles
 * A style describes how a resource is symbolized or rendered by the Web Map Service.
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * StyleInfoWrapper
 */
@JsonPropertyOrder({
  StyleInfoWrapper.JSON_PROPERTY_STYLE
})

public class StyleInfoWrapper {
  public static final String JSON_PROPERTY_STYLE = "style";
  private org.geoserver.openapi.model.catalog.StyleInfo style;


  public StyleInfoWrapper style(org.geoserver.openapi.model.catalog.StyleInfo style) {
    
    this.style = style;
    return this;
  }

   /**
   * Get style
   * @return style
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STYLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public org.geoserver.openapi.model.catalog.StyleInfo getStyle() {
    return style;
  }


  public void setStyle(org.geoserver.openapi.model.catalog.StyleInfo style) {
    this.style = style;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StyleInfoWrapper styleInfoWrapper = (StyleInfoWrapper) o;
    return Objects.equals(this.style, styleInfoWrapper.style);
  }

  @Override
  public int hashCode() {
    return Objects.hash(style);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StyleInfoWrapper {\n");
    sb.append("    style: ").append(toIndentedString(style)).append("\n");
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

