/*
 * GeoServer Catalog Model
 * GeoServer Catalog Model Objects
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.geoserver.openapi.model.catalog;

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
import org.geoserver.openapi.model.catalog.DataLinkInfo;
import org.geoserver.openapi.model.catalog.EnvelopeInfo;
import org.geoserver.openapi.model.catalog.KeywordInfo;
import org.geoserver.openapi.model.catalog.MetadataLinks;
import org.geoserver.openapi.model.catalog.MetadataMap;
import org.geoserver.openapi.model.catalog.NamespaceInfo;
import org.geoserver.openapi.model.catalog.ProjectionPolicy;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ResourceInfo
 */
@JsonPropertyOrder({
  ResourceInfo.JSON_PROPERTY_NAME,
  ResourceInfo.JSON_PROPERTY_NATIVE_NAME,
  ResourceInfo.JSON_PROPERTY_NAMESPACE,
  ResourceInfo.JSON_PROPERTY_TITLE,
  ResourceInfo.JSON_PROPERTY_ABSTRACT,
  ResourceInfo.JSON_PROPERTY_DESCRIPTION,
  ResourceInfo.JSON_PROPERTY_ENABLED,
  ResourceInfo.JSON_PROPERTY_ALIAS,
  ResourceInfo.JSON_PROPERTY_DATA_LINKS,
  ResourceInfo.JSON_PROPERTY_DISABLED_SERVICES,
  ResourceInfo.JSON_PROPERTY_KEYWORDS,
  ResourceInfo.JSON_PROPERTY_LAT_LON_BOUNDING_BOX,
  ResourceInfo.JSON_PROPERTY_NATIVE_BOUNDING_BOX,
  ResourceInfo.JSON_PROPERTY_METADATA,
  ResourceInfo.JSON_PROPERTY_METADATA_LINKS,
  ResourceInfo.JSON_PROPERTY_NATIVE_C_R_S,
  ResourceInfo.JSON_PROPERTY_SRS,
  ResourceInfo.JSON_PROPERTY_PROJECTION_POLICY,
  ResourceInfo.JSON_PROPERTY_ADVERTISED,
  ResourceInfo.JSON_PROPERTY_SERVICE_CONFIGURATION
})

public class ResourceInfo {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_NATIVE_NAME = "nativeName";
  private String nativeName;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  private NamespaceInfo namespace;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_ABSTRACT = "abstract";
  private String _abstract;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_ENABLED = "enabled";
  private Boolean enabled;

  public static final String JSON_PROPERTY_ALIAS = "alias";
  private List<String> alias = null;

  public static final String JSON_PROPERTY_DATA_LINKS = "dataLinks";
  private List<DataLinkInfo> dataLinks = null;

  public static final String JSON_PROPERTY_DISABLED_SERVICES = "disabledServices";
  private List<String> disabledServices = null;

  public static final String JSON_PROPERTY_KEYWORDS = "keywords";
  private List<KeywordInfo> keywords = null;

  public static final String JSON_PROPERTY_LAT_LON_BOUNDING_BOX = "latLonBoundingBox";
  private EnvelopeInfo latLonBoundingBox;

  public static final String JSON_PROPERTY_NATIVE_BOUNDING_BOX = "nativeBoundingBox";
  private EnvelopeInfo nativeBoundingBox;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private MetadataMap metadata;

  public static final String JSON_PROPERTY_METADATA_LINKS = "metadataLinks";
  private MetadataLinks metadataLinks;

  public static final String JSON_PROPERTY_NATIVE_C_R_S = "nativeCRS";
  private String nativeCRS;

  public static final String JSON_PROPERTY_SRS = "srs";
  private String srs;

  public static final String JSON_PROPERTY_PROJECTION_POLICY = "projectionPolicy";
  private ProjectionPolicy projectionPolicy;

  public static final String JSON_PROPERTY_ADVERTISED = "advertised";
  private Boolean advertised;

  public static final String JSON_PROPERTY_SERVICE_CONFIGURATION = "serviceConfiguration";
  private Boolean serviceConfiguration;


  public ResourceInfo name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the resource. This name corresponds to the \&quot;published\&quot; name of the resource.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the resource. This name corresponds to the \"published\" name of the resource.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ResourceInfo nativeName(String nativeName) {
    
    this.nativeName = nativeName;
    return this;
  }

   /**
   * The native name of the resource. This name corresponds to the physical resource that feature type is derived from -- a shapefile name, a database table, etc...
   * @return nativeName
  **/
  @ApiModelProperty(required = true, value = "The native name of the resource. This name corresponds to the physical resource that feature type is derived from -- a shapefile name, a database table, etc...")
  @JsonProperty(JSON_PROPERTY_NATIVE_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNativeName() {
    return nativeName;
  }


  public void setNativeName(String nativeName) {
    this.nativeName = nativeName;
  }


  public ResourceInfo namespace(NamespaceInfo namespace) {
    
    this.namespace = namespace;
    return this;
  }

   /**
   * Get namespace
   * @return namespace
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NamespaceInfo getNamespace() {
    return namespace;
  }


  public void setNamespace(NamespaceInfo namespace) {
    this.namespace = namespace;
  }


  public ResourceInfo title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * The title of the resource.
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The title of the resource.")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public ResourceInfo _abstract(String _abstract) {
    
    this._abstract = _abstract;
    return this;
  }

   /**
   * the abstract for the resource.
   * @return _abstract
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the abstract for the resource.")
  @JsonProperty(JSON_PROPERTY_ABSTRACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAbstract() {
    return _abstract;
  }


  public void setAbstract(String _abstract) {
    this._abstract = _abstract;
  }


  public ResourceInfo description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * A description of the resource. This is usually something that is to be displayed in a user interface.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A description of the resource. This is usually something that is to be displayed in a user interface.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public ResourceInfo enabled(Boolean enabled) {
    
    this.enabled = enabled;
    return this;
  }

   /**
   * A flag indicating if the resource is enabled or not.
   * @return enabled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A flag indicating if the resource is enabled or not.")
  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getEnabled() {
    return enabled;
  }


  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }


  public ResourceInfo alias(List<String> alias) {
    
    this.alias = alias;
    return this;
  }

  public ResourceInfo addAliasItem(String aliasItem) {
    if (this.alias == null) {
      this.alias = new ArrayList<>();
    }
    this.alias.add(aliasItem);
    return this;
  }

   /**
   * A set of aliases or alternative names that the resource is also known by.
   * @return alias
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A set of aliases or alternative names that the resource is also known by.")
  @JsonProperty(JSON_PROPERTY_ALIAS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getAlias() {
    return alias;
  }


  public void setAlias(List<String> alias) {
    this.alias = alias;
  }


  public ResourceInfo dataLinks(List<DataLinkInfo> dataLinks) {
    
    this.dataLinks = dataLinks;
    return this;
  }

  public ResourceInfo addDataLinksItem(DataLinkInfo dataLinksItem) {
    if (this.dataLinks == null) {
      this.dataLinks = new ArrayList<>();
    }
    this.dataLinks.add(dataLinksItem);
    return this;
  }

   /**
   * A collection of data links for the resource.
   * @return dataLinks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A collection of data links for the resource.")
  @JsonProperty(JSON_PROPERTY_DATA_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<DataLinkInfo> getDataLinks() {
    return dataLinks;
  }


  public void setDataLinks(List<DataLinkInfo> dataLinks) {
    this.dataLinks = dataLinks;
  }


  public ResourceInfo disabledServices(List<String> disabledServices) {
    
    this.disabledServices = disabledServices;
    return this;
  }

  public ResourceInfo addDisabledServicesItem(String disabledServicesItem) {
    if (this.disabledServices == null) {
      this.disabledServices = new ArrayList<>();
    }
    this.disabledServices.add(disabledServicesItem);
    return this;
  }

   /**
   * a list of disabled services names for this resource (e.g. [WMS, WCS])
   * @return disabledServices
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "a list of disabled services names for this resource (e.g. [WMS, WCS])")
  @JsonProperty(JSON_PROPERTY_DISABLED_SERVICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getDisabledServices() {
    return disabledServices;
  }


  public void setDisabledServices(List<String> disabledServices) {
    this.disabledServices = disabledServices;
  }


  public ResourceInfo keywords(List<KeywordInfo> keywords) {
    
    this.keywords = keywords;
    return this;
  }

  public ResourceInfo addKeywordsItem(KeywordInfo keywordsItem) {
    if (this.keywords == null) {
      this.keywords = new ArrayList<>();
    }
    this.keywords.add(keywordsItem);
    return this;
  }

   /**
   * A collection of keywords associated with the resource.
   * @return keywords
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A collection of keywords associated with the resource.")
  @JsonProperty(JSON_PROPERTY_KEYWORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<KeywordInfo> getKeywords() {
    return keywords;
  }


  public void setKeywords(List<KeywordInfo> keywords) {
    this.keywords = keywords;
  }


  public ResourceInfo latLonBoundingBox(EnvelopeInfo latLonBoundingBox) {
    
    this.latLonBoundingBox = latLonBoundingBox;
    return this;
  }

   /**
   * Get latLonBoundingBox
   * @return latLonBoundingBox
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LAT_LON_BOUNDING_BOX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EnvelopeInfo getLatLonBoundingBox() {
    return latLonBoundingBox;
  }


  public void setLatLonBoundingBox(EnvelopeInfo latLonBoundingBox) {
    this.latLonBoundingBox = latLonBoundingBox;
  }


  public ResourceInfo nativeBoundingBox(EnvelopeInfo nativeBoundingBox) {
    
    this.nativeBoundingBox = nativeBoundingBox;
    return this;
  }

   /**
   * Get nativeBoundingBox
   * @return nativeBoundingBox
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NATIVE_BOUNDING_BOX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EnvelopeInfo getNativeBoundingBox() {
    return nativeBoundingBox;
  }


  public void setNativeBoundingBox(EnvelopeInfo nativeBoundingBox) {
    this.nativeBoundingBox = nativeBoundingBox;
  }


  public ResourceInfo metadata(MetadataMap metadata) {
    
    this.metadata = metadata;
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MetadataMap getMetadata() {
    return metadata;
  }


  public void setMetadata(MetadataMap metadata) {
    this.metadata = metadata;
  }


  public ResourceInfo metadataLinks(MetadataLinks metadataLinks) {
    
    this.metadataLinks = metadataLinks;
    return this;
  }

   /**
   * Get metadataLinks
   * @return metadataLinks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_METADATA_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MetadataLinks getMetadataLinks() {
    return metadataLinks;
  }


  public void setMetadataLinks(MetadataLinks metadataLinks) {
    this.metadataLinks = metadataLinks;
  }


  public ResourceInfo nativeCRS(String nativeCRS) {
    
    this.nativeCRS = nativeCRS;
    return this;
  }

   /**
   * The native coordinate reference system object of the resource, in WKT format
   * @return nativeCRS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The native coordinate reference system object of the resource, in WKT format")
  @JsonProperty(JSON_PROPERTY_NATIVE_C_R_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNativeCRS() {
    return nativeCRS;
  }


  public void setNativeCRS(String nativeCRS) {
    this.nativeCRS = nativeCRS;
  }


  public ResourceInfo srs(String srs) {
    
    this.srs = srs;
    return this;
  }

   /**
   * Returns the identifier of coordinate reference system of the resource.
   * @return srs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns the identifier of coordinate reference system of the resource.")
  @JsonProperty(JSON_PROPERTY_SRS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSrs() {
    return srs;
  }


  public void setSrs(String srs) {
    this.srs = srs;
  }


  public ResourceInfo projectionPolicy(ProjectionPolicy projectionPolicy) {
    
    this.projectionPolicy = projectionPolicy;
    return this;
  }

   /**
   * Get projectionPolicy
   * @return projectionPolicy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PROJECTION_POLICY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ProjectionPolicy getProjectionPolicy() {
    return projectionPolicy;
  }


  public void setProjectionPolicy(ProjectionPolicy projectionPolicy) {
    this.projectionPolicy = projectionPolicy;
  }


  public ResourceInfo advertised(Boolean advertised) {
    
    this.advertised = advertised;
    return this;
  }

   /**
   * true if the resource existence should be advertised (true by default, unless otherwise set)
   * @return advertised
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "true if the resource existence should be advertised (true by default, unless otherwise set)")
  @JsonProperty(JSON_PROPERTY_ADVERTISED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAdvertised() {
    return advertised;
  }


  public void setAdvertised(Boolean advertised) {
    this.advertised = advertised;
  }


  public ResourceInfo serviceConfiguration(Boolean serviceConfiguration) {
    
    this.serviceConfiguration = serviceConfiguration;
    return this;
  }

   /**
   * true if the resource will configure services access, false otherwise
   * @return serviceConfiguration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "true if the resource will configure services access, false otherwise")
  @JsonProperty(JSON_PROPERTY_SERVICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getServiceConfiguration() {
    return serviceConfiguration;
  }


  public void setServiceConfiguration(Boolean serviceConfiguration) {
    this.serviceConfiguration = serviceConfiguration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceInfo resourceInfo = (ResourceInfo) o;
    return Objects.equals(this.name, resourceInfo.name) &&
        Objects.equals(this.nativeName, resourceInfo.nativeName) &&
        Objects.equals(this.namespace, resourceInfo.namespace) &&
        Objects.equals(this.title, resourceInfo.title) &&
        Objects.equals(this._abstract, resourceInfo._abstract) &&
        Objects.equals(this.description, resourceInfo.description) &&
        Objects.equals(this.enabled, resourceInfo.enabled) &&
        Objects.equals(this.alias, resourceInfo.alias) &&
        Objects.equals(this.dataLinks, resourceInfo.dataLinks) &&
        Objects.equals(this.disabledServices, resourceInfo.disabledServices) &&
        Objects.equals(this.keywords, resourceInfo.keywords) &&
        Objects.equals(this.latLonBoundingBox, resourceInfo.latLonBoundingBox) &&
        Objects.equals(this.nativeBoundingBox, resourceInfo.nativeBoundingBox) &&
        Objects.equals(this.metadata, resourceInfo.metadata) &&
        Objects.equals(this.metadataLinks, resourceInfo.metadataLinks) &&
        Objects.equals(this.nativeCRS, resourceInfo.nativeCRS) &&
        Objects.equals(this.srs, resourceInfo.srs) &&
        Objects.equals(this.projectionPolicy, resourceInfo.projectionPolicy) &&
        Objects.equals(this.advertised, resourceInfo.advertised) &&
        Objects.equals(this.serviceConfiguration, resourceInfo.serviceConfiguration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, nativeName, namespace, title, _abstract, description, enabled, alias, dataLinks, disabledServices, keywords, latLonBoundingBox, nativeBoundingBox, metadata, metadataLinks, nativeCRS, srs, projectionPolicy, advertised, serviceConfiguration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceInfo {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nativeName: ").append(toIndentedString(nativeName)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    _abstract: ").append(toIndentedString(_abstract)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    dataLinks: ").append(toIndentedString(dataLinks)).append("\n");
    sb.append("    disabledServices: ").append(toIndentedString(disabledServices)).append("\n");
    sb.append("    keywords: ").append(toIndentedString(keywords)).append("\n");
    sb.append("    latLonBoundingBox: ").append(toIndentedString(latLonBoundingBox)).append("\n");
    sb.append("    nativeBoundingBox: ").append(toIndentedString(nativeBoundingBox)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    metadataLinks: ").append(toIndentedString(metadataLinks)).append("\n");
    sb.append("    nativeCRS: ").append(toIndentedString(nativeCRS)).append("\n");
    sb.append("    srs: ").append(toIndentedString(srs)).append("\n");
    sb.append("    projectionPolicy: ").append(toIndentedString(projectionPolicy)).append("\n");
    sb.append("    advertised: ").append(toIndentedString(advertised)).append("\n");
    sb.append("    serviceConfiguration: ").append(toIndentedString(serviceConfiguration)).append("\n");
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

