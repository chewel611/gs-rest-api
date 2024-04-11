/*
 * GeoServer CoverageStores
 * A coverage store describes how access a raster data source.
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
 * CoverageStoreListItem
 */
@JsonPropertyOrder({
  CoverageStoreListItem.JSON_PROPERTY_NAME,
  CoverageStoreListItem.JSON_PROPERTY_HREF
})

public class CoverageStoreListItem {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_HREF = "href";
  private String href;


  public CoverageStoreListItem name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name of coverage store
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of coverage store")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public CoverageStoreListItem href(String href) {
    
    this.href = href;
    return this;
  }

   /**
   * URL to coverage store definition
   * @return href
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "URL to coverage store definition")
  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getHref() {
    return href;
  }


  public void setHref(String href) {
    this.href = href;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoverageStoreListItem coverageStoreListItem = (CoverageStoreListItem) o;
    return Objects.equals(this.name, coverageStoreListItem.name) &&
        Objects.equals(this.href, coverageStoreListItem.href);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, href);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoverageStoreListItem {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

