/*
 * GeoServer Config Model
 * GeoServer Config Model Objects
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.geoserver.openapi.model.config;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.geoserver.openapi.model.config.SettingsInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GeoServerInfo
 */
@JsonPropertyOrder({
  GeoServerInfo.JSON_PROPERTY_UPDATE_SEQUENCE,
  GeoServerInfo.JSON_PROPERTY_USE_HEADERS_PROXY_U_R_L,
  GeoServerInfo.JSON_PROPERTY_SETTINGS
})

public class GeoServerInfo {
  public static final String JSON_PROPERTY_UPDATE_SEQUENCE = "updateSequence";
  private Long updateSequence;

  public static final String JSON_PROPERTY_USE_HEADERS_PROXY_U_R_L = "useHeadersProxyURL";
  private Boolean useHeadersProxyURL;

  public static final String JSON_PROPERTY_SETTINGS = "settings";
  private SettingsInfo settings;


  public GeoServerInfo updateSequence(Long updateSequence) {
    
    this.updateSequence = updateSequence;
    return this;
  }

   /**
   * The update sequence. This value is used by various ogc services to track changes to a capabilities document.
   * @return updateSequence
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The update sequence. This value is used by various ogc services to track changes to a capabilities document.")
  @JsonProperty(JSON_PROPERTY_UPDATE_SEQUENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getUpdateSequence() {
    return updateSequence;
  }


  public void setUpdateSequence(Long updateSequence) {
    this.updateSequence = updateSequence;
  }


  public GeoServerInfo useHeadersProxyURL(Boolean useHeadersProxyURL) {
    
    this.useHeadersProxyURL = useHeadersProxyURL;
    return this;
  }

   /**
   * The flag to use request headers for the proxy URL
   * @return useHeadersProxyURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flag to use request headers for the proxy URL")
  @JsonProperty(JSON_PROPERTY_USE_HEADERS_PROXY_U_R_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getUseHeadersProxyURL() {
    return useHeadersProxyURL;
  }


  public void setUseHeadersProxyURL(Boolean useHeadersProxyURL) {
    this.useHeadersProxyURL = useHeadersProxyURL;
  }


  public GeoServerInfo settings(SettingsInfo settings) {
    
    this.settings = settings;
    return this;
  }

   /**
   * Get settings
   * @return settings
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SettingsInfo getSettings() {
    return settings;
  }


  public void setSettings(SettingsInfo settings) {
    this.settings = settings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoServerInfo geoServerInfo = (GeoServerInfo) o;
    return Objects.equals(this.updateSequence, geoServerInfo.updateSequence) &&
        Objects.equals(this.useHeadersProxyURL, geoServerInfo.useHeadersProxyURL) &&
        Objects.equals(this.settings, geoServerInfo.settings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateSequence, useHeadersProxyURL, settings);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoServerInfo {\n");
    sb.append("    updateSequence: ").append(toIndentedString(updateSequence)).append("\n");
    sb.append("    useHeadersProxyURL: ").append(toIndentedString(useHeadersProxyURL)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
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

