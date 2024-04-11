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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * LayerInfoAllOf
 */
@JsonPropertyOrder({
  LayerInfoAllOf.JSON_PROPERTY_PATH,
  LayerInfoAllOf.JSON_PROPERTY_DEFAULT_STYLE,
  LayerInfoAllOf.JSON_PROPERTY_STYLES,
  LayerInfoAllOf.JSON_PROPERTY_RESOURCE,
  LayerInfoAllOf.JSON_PROPERTY_LEGEND,
  LayerInfoAllOf.JSON_PROPERTY_ENABLED,
  LayerInfoAllOf.JSON_PROPERTY_QUERYABLE,
  LayerInfoAllOf.JSON_PROPERTY_OPAQUE,
  LayerInfoAllOf.JSON_PROPERTY_ADVERTISED,
  LayerInfoAllOf.JSON_PROPERTY_DEFAULT_W_M_S_INTERPOLATION_METHOD
})

public class LayerInfoAllOf {
  public static final String JSON_PROPERTY_PATH = "path";
  private String path;

  public static final String JSON_PROPERTY_DEFAULT_STYLE = "defaultStyle";
  private org.geoserver.openapi.model.catalog.StyleInfo defaultStyle;

  public static final String JSON_PROPERTY_STYLES = "styles";
  private List<org.geoserver.openapi.model.catalog.StyleInfo> styles = null;

  public static final String JSON_PROPERTY_RESOURCE = "resource";
  private org.geoserver.openapi.model.catalog.ResourceInfo resource;

  public static final String JSON_PROPERTY_LEGEND = "legend";
  private org.geoserver.openapi.model.catalog.LegendInfo legend;

  public static final String JSON_PROPERTY_ENABLED = "enabled";
  private Boolean enabled;

  public static final String JSON_PROPERTY_QUERYABLE = "queryable";
  private Boolean queryable;

  public static final String JSON_PROPERTY_OPAQUE = "opaque";
  private Boolean opaque;

  public static final String JSON_PROPERTY_ADVERTISED = "advertised";
  private Boolean advertised = true;

  public static final String JSON_PROPERTY_DEFAULT_W_M_S_INTERPOLATION_METHOD = "defaultWMSInterpolationMethod";
  private org.geoserver.openapi.model.catalog.WMSInterpolation defaultWMSInterpolationMethod;


  public LayerInfoAllOf path(String path) {
    
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PATH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPath() {
    return path;
  }


  public void setPath(String path) {
    this.path = path;
  }


  public LayerInfoAllOf defaultStyle(org.geoserver.openapi.model.catalog.StyleInfo defaultStyle) {
    
    this.defaultStyle = defaultStyle;
    return this;
  }

   /**
   * Get defaultStyle
   * @return defaultStyle
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DEFAULT_STYLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public org.geoserver.openapi.model.catalog.StyleInfo getDefaultStyle() {
    return defaultStyle;
  }


  public void setDefaultStyle(org.geoserver.openapi.model.catalog.StyleInfo defaultStyle) {
    this.defaultStyle = defaultStyle;
  }


  public LayerInfoAllOf styles(List<org.geoserver.openapi.model.catalog.StyleInfo> styles) {
    
    this.styles = styles;
    return this;
  }

  public LayerInfoAllOf addStylesItem(org.geoserver.openapi.model.catalog.StyleInfo stylesItem) {
    if (this.styles == null) {
      this.styles = new ArrayList<>();
    }
    this.styles.add(stylesItem);
    return this;
  }

   /**
   * Get styles
   * @return styles
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STYLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<org.geoserver.openapi.model.catalog.StyleInfo> getStyles() {
    return styles;
  }


  public void setStyles(List<org.geoserver.openapi.model.catalog.StyleInfo> styles) {
    this.styles = styles;
  }


  public LayerInfoAllOf resource(org.geoserver.openapi.model.catalog.ResourceInfo resource) {
    
    this.resource = resource;
    return this;
  }

   /**
   * Get resource
   * @return resource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public org.geoserver.openapi.model.catalog.ResourceInfo getResource() {
    return resource;
  }


  public void setResource(org.geoserver.openapi.model.catalog.ResourceInfo resource) {
    this.resource = resource;
  }


  public LayerInfoAllOf legend(org.geoserver.openapi.model.catalog.LegendInfo legend) {
    
    this.legend = legend;
    return this;
  }

   /**
   * Get legend
   * @return legend
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LEGEND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public org.geoserver.openapi.model.catalog.LegendInfo getLegend() {
    return legend;
  }


  public void setLegend(org.geoserver.openapi.model.catalog.LegendInfo legend) {
    this.legend = legend;
  }


  public LayerInfoAllOf enabled(Boolean enabled) {
    
    this.enabled = enabled;
    return this;
  }

   /**
   * Get enabled
   * @return enabled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getEnabled() {
    return enabled;
  }


  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }


  public LayerInfoAllOf queryable(Boolean queryable) {
    
    this.queryable = queryable;
    return this;
  }

   /**
   * Get queryable
   * @return queryable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_QUERYABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getQueryable() {
    return queryable;
  }


  public void setQueryable(Boolean queryable) {
    this.queryable = queryable;
  }


  public LayerInfoAllOf opaque(Boolean opaque) {
    
    this.opaque = opaque;
    return this;
  }

   /**
   * Get opaque
   * @return opaque
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OPAQUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getOpaque() {
    return opaque;
  }


  public void setOpaque(Boolean opaque) {
    this.opaque = opaque;
  }


  public LayerInfoAllOf advertised(Boolean advertised) {
    
    this.advertised = advertised;
    return this;
  }

   /**
   * Get advertised
   * @return advertised
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ADVERTISED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAdvertised() {
    return advertised;
  }


  public void setAdvertised(Boolean advertised) {
    this.advertised = advertised;
  }


  public LayerInfoAllOf defaultWMSInterpolationMethod(org.geoserver.openapi.model.catalog.WMSInterpolation defaultWMSInterpolationMethod) {
    
    this.defaultWMSInterpolationMethod = defaultWMSInterpolationMethod;
    return this;
  }

   /**
   * Get defaultWMSInterpolationMethod
   * @return defaultWMSInterpolationMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DEFAULT_W_M_S_INTERPOLATION_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public org.geoserver.openapi.model.catalog.WMSInterpolation getDefaultWMSInterpolationMethod() {
    return defaultWMSInterpolationMethod;
  }


  public void setDefaultWMSInterpolationMethod(org.geoserver.openapi.model.catalog.WMSInterpolation defaultWMSInterpolationMethod) {
    this.defaultWMSInterpolationMethod = defaultWMSInterpolationMethod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LayerInfoAllOf layerInfoAllOf = (LayerInfoAllOf) o;
    return Objects.equals(this.path, layerInfoAllOf.path) &&
        Objects.equals(this.defaultStyle, layerInfoAllOf.defaultStyle) &&
        Objects.equals(this.styles, layerInfoAllOf.styles) &&
        Objects.equals(this.resource, layerInfoAllOf.resource) &&
        Objects.equals(this.legend, layerInfoAllOf.legend) &&
        Objects.equals(this.enabled, layerInfoAllOf.enabled) &&
        Objects.equals(this.queryable, layerInfoAllOf.queryable) &&
        Objects.equals(this.opaque, layerInfoAllOf.opaque) &&
        Objects.equals(this.advertised, layerInfoAllOf.advertised) &&
        Objects.equals(this.defaultWMSInterpolationMethod, layerInfoAllOf.defaultWMSInterpolationMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, defaultStyle, styles, resource, legend, enabled, queryable, opaque, advertised, defaultWMSInterpolationMethod);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LayerInfoAllOf {\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    defaultStyle: ").append(toIndentedString(defaultStyle)).append("\n");
    sb.append("    styles: ").append(toIndentedString(styles)).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    legend: ").append(toIndentedString(legend)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    queryable: ").append(toIndentedString(queryable)).append("\n");
    sb.append("    opaque: ").append(toIndentedString(opaque)).append("\n");
    sb.append("    advertised: ").append(toIndentedString(advertised)).append("\n");
    sb.append("    defaultWMSInterpolationMethod: ").append(toIndentedString(defaultWMSInterpolationMethod)).append("\n");
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

