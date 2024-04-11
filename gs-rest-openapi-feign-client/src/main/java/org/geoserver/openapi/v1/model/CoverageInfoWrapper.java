/*
 * GeoServer Coverages
 * A coverage is a raster data set which originates from a coverage store.
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
 * CoverageInfoWrapper
 */
@JsonPropertyOrder({
  CoverageInfoWrapper.JSON_PROPERTY_COVERAGE
})

public class CoverageInfoWrapper {
  public static final String JSON_PROPERTY_COVERAGE = "coverage";
  private org.geoserver.openapi.model.catalog.CoverageInfo coverage = null;


  public CoverageInfoWrapper coverage(org.geoserver.openapi.model.catalog.CoverageInfo coverage) {
    
    this.coverage = coverage;
    return this;
  }

   /**
   * Get coverage
   * @return coverage
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COVERAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public org.geoserver.openapi.model.catalog.CoverageInfo getCoverage() {
    return coverage;
  }


  public void setCoverage(org.geoserver.openapi.model.catalog.CoverageInfo coverage) {
    this.coverage = coverage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoverageInfoWrapper coverageInfoWrapper = (CoverageInfoWrapper) o;
    return Objects.equals(this.coverage, coverageInfoWrapper.coverage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coverage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoverageInfoWrapper {\n");
    sb.append("    coverage: ").append(toIndentedString(coverage)).append("\n");
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

