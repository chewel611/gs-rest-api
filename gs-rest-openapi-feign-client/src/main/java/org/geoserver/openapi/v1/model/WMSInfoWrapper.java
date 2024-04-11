/*
 * OWS Services
 * An OWS service refers to any of the OGC services that GeoServer supports, such as WFS, WMS, and WCS. These endpoints controls the settings of these services.
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
 * WMSInfoWrapper
 */
@JsonPropertyOrder({
  WMSInfoWrapper.JSON_PROPERTY_WMS
})

public class WMSInfoWrapper {
  public static final String JSON_PROPERTY_WMS = "wms";
  private org.geoserver.openapi.model.config.WMSInfo wms = null;


  public WMSInfoWrapper wms(org.geoserver.openapi.model.config.WMSInfo wms) {
    
    this.wms = wms;
    return this;
  }

   /**
   * Get wms
   * @return wms
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_WMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public org.geoserver.openapi.model.config.WMSInfo getWms() {
    return wms;
  }


  public void setWms(org.geoserver.openapi.model.config.WMSInfo wms) {
    this.wms = wms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WMSInfoWrapper wmSInfoWrapper = (WMSInfoWrapper) o;
    return Objects.equals(this.wms, wmSInfoWrapper.wms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wms);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WMSInfoWrapper {\n");
    sb.append("    wms: ").append(toIndentedString(wms)).append("\n");
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

