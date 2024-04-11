/*
 * GeoServer Feature Types
 * A feature type is a vector based spatial resource or data set that originates from a data store. In some cases, such as with a shapefile, a feature type has a one-to-one relationship with its data store. In other cases, such as PostGIS, the relationship of feature type to data store is many-to-one, feature types corresponding to a table in the database.
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
import org.geoserver.openapi.v1.model.FeatureTypeResponse;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * FeatureTypeResponseWrapper
 */
@JsonPropertyOrder({
  FeatureTypeResponseWrapper.JSON_PROPERTY_FEATURE_TYPE
})

public class FeatureTypeResponseWrapper {
  public static final String JSON_PROPERTY_FEATURE_TYPE = "featureType";
  private FeatureTypeResponse featureType = null;


  public FeatureTypeResponseWrapper featureType(FeatureTypeResponse featureType) {
    
    this.featureType = featureType;
    return this;
  }

   /**
   * Get featureType
   * @return featureType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FEATURE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FeatureTypeResponse getFeatureType() {
    return featureType;
  }


  public void setFeatureType(FeatureTypeResponse featureType) {
    this.featureType = featureType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeatureTypeResponseWrapper featureTypeResponseWrapper = (FeatureTypeResponseWrapper) o;
    return Objects.equals(this.featureType, featureTypeResponseWrapper.featureType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(featureType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeatureTypeResponseWrapper {\n");
    sb.append("    featureType: ").append(toIndentedString(featureType)).append("\n");
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

