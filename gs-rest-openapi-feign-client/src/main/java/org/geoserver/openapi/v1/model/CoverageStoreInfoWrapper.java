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
 * CoverageStoreInfoWrapper
 */
@JsonPropertyOrder({
  CoverageStoreInfoWrapper.JSON_PROPERTY_COVERAGE_STORE
})

public class CoverageStoreInfoWrapper {
  public static final String JSON_PROPERTY_COVERAGE_STORE = "coverageStore";
  private org.geoserver.openapi.model.catalog.CoverageStoreInfo coverageStore;


  public CoverageStoreInfoWrapper coverageStore(org.geoserver.openapi.model.catalog.CoverageStoreInfo coverageStore) {
    
    this.coverageStore = coverageStore;
    return this;
  }

   /**
   * Get coverageStore
   * @return coverageStore
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COVERAGE_STORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public org.geoserver.openapi.model.catalog.CoverageStoreInfo getCoverageStore() {
    return coverageStore;
  }


  public void setCoverageStore(org.geoserver.openapi.model.catalog.CoverageStoreInfo coverageStore) {
    this.coverageStore = coverageStore;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoverageStoreInfoWrapper coverageStoreInfoWrapper = (CoverageStoreInfoWrapper) o;
    return Objects.equals(this.coverageStore, coverageStoreInfoWrapper.coverageStore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coverageStore);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoverageStoreInfoWrapper {\n");
    sb.append("    coverageStore: ").append(toIndentedString(coverageStore)).append("\n");
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

