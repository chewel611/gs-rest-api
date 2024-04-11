package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.FeatureTypeInfoWrapper;
import org.geoserver.openapi.v1.model.FeatureTypeList;
import org.geoserver.openapi.v1.model.FeatureTypeResponseWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface FeaturetypesApi extends ApiClient.Api {


  /**
   * 
   * Create a new feature type, the feature type definition needs to reference a store. Note -  when creating a new feature type via POST, if no underlying dataset with the specified name exists an attempt will be made to create it. This will work only in cases where the underlying data format supports the creation of new types (such as a database). When creating a feature type in this manner the client should include all attribute information in the feature type representation. 
   * @param workspaceName The name of the workspace (required)
   * @param featureTypeInfoWrapper The body of the feature type to POST (required)
   */
  @RequestLine("POST /rest/workspaces/{workspaceName}/featuretypes")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createFeatureType(@Param("workspaceName") String workspaceName, FeatureTypeInfoWrapper featureTypeInfoWrapper);

  /**
   * 
   * Create a new feature type. Note -  when creating a new feature type via POST, if no underlying dataset with the specified name exists an attempt will be made to create it. This will work only in cases where the underlying data format supports the creation of new types (such as a database). When creating a feature type in this manner the client should include all attribute information in the feature type representation. 
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param featureTypeInfoWrapper The body of the feature type to POST (required)
   */
  @RequestLine("POST /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createFeatureTypeOnStore(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, FeatureTypeInfoWrapper featureTypeInfoWrapper);

  /**
   * 
   * Delete a feature type in the default data store for the workspace (optionally recursively deleting layers).
   * @param workspaceName The name of the workspace (required)
   * @param featureTypeName The name of the feature type (required)
   * @param recurse Recursively deletes all layers referenced by the specified featuretype. Allowed values for this parameter are true or false. The default value is false. A request with &#39;recurse&#x3D;false&#39; will fail if any layers reference the featuretype. (optional, default to false)
   */
  @RequestLine("DELETE /rest/workspaces/{workspaceName}/featuretypes/{featureTypeName}?recurse={recurse}")
  @Headers({
    "Accept: application/json",
  })
  void deleteFeatureType(@Param("workspaceName") String workspaceName, @Param("featureTypeName") String featureTypeName, @Param("recurse") Boolean recurse);

  /**
   * 
   * Delete a feature type in the default data store for the workspace (optionally recursively deleting layers).
   * Note, this is equivalent to the other <code>deleteFeatureType</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteFeatureTypeQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace (required)
   * @param featureTypeName The name of the feature type (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>recurse - Recursively deletes all layers referenced by the specified featuretype. Allowed values for this parameter are true or false. The default value is false. A request with &#39;recurse&#x3D;false&#39; will fail if any layers reference the featuretype. (optional, default to false)</li>
   *   </ul>
   */
  @RequestLine("DELETE /rest/workspaces/{workspaceName}/featuretypes/{featureTypeName}?recurse={recurse}")
  @Headers({
  "Accept: application/json",
  })
  void deleteFeatureType(@Param("workspaceName") String workspaceName, @Param("featureTypeName") String featureTypeName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteFeatureType</code> method in a fluent style.
   */
  public static class DeleteFeatureTypeQueryParams extends HashMap<String, Object> {
    public DeleteFeatureTypeQueryParams recurse(final Boolean value) {
      put("recurse", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Delete a feature type (optionally recursively deleting layers).
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param featureTypeName The name of the feature type (required)
   * @param recurse Recursively deletes all layers referenced by the specified featuretype. Allowed values for this parameter are true or false. The default value is false. A request with &#39;recurse&#x3D;false&#39; will fail if any layers reference the featuretype. (optional, default to false)
   */
  @RequestLine("DELETE /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes/{featureTypeName}?recurse={recurse}")
  @Headers({
    "Accept: application/json",
  })
  void deleteFeatureTypeByStore(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @Param("featureTypeName") String featureTypeName, @Param("recurse") Boolean recurse);

  /**
   * 
   * Delete a feature type (optionally recursively deleting layers).
   * Note, this is equivalent to the other <code>deleteFeatureTypeByStore</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteFeatureTypeByStoreQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param featureTypeName The name of the feature type (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>recurse - Recursively deletes all layers referenced by the specified featuretype. Allowed values for this parameter are true or false. The default value is false. A request with &#39;recurse&#x3D;false&#39; will fail if any layers reference the featuretype. (optional, default to false)</li>
   *   </ul>
   */
  @RequestLine("DELETE /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes/{featureTypeName}?recurse={recurse}")
  @Headers({
  "Accept: application/json",
  })
  void deleteFeatureTypeByStore(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @Param("featureTypeName") String featureTypeName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteFeatureTypeByStore</code> method in a fluent style.
   */
  public static class DeleteFeatureTypeByStoreQueryParams extends HashMap<String, Object> {
    public DeleteFeatureTypeByStoreQueryParams recurse(final Boolean value) {
      put("recurse", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Get an individual feature type
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param featureTypeName The name of the feature type (required)
   * @param quietOnNotFound Prevents logging an Exception when the feature type is not present. Note that 404 status code will be returned anyway. Defaults to \&quot;false\&quot;. (optional, default to false)
   * @return FeatureTypeResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes/{featureTypeName}?quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  FeatureTypeResponseWrapper getFeatureType(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @Param("featureTypeName") String featureTypeName, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * 
   * Get an individual feature type
   * Note, this is equivalent to the other <code>getFeatureType</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetFeatureTypeQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param featureTypeName The name of the feature type (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>quietOnNotFound - Prevents logging an Exception when the feature type is not present. Note that 404 status code will be returned anyway. Defaults to \&quot;false\&quot;. (optional, default to false)</li>
   *   </ul>
   * @return FeatureTypeResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes/{featureTypeName}?quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  FeatureTypeResponseWrapper getFeatureType(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @Param("featureTypeName") String featureTypeName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getFeatureType</code> method in a fluent style.
   */
  public static class GetFeatureTypeQueryParams extends HashMap<String, Object> {
    public GetFeatureTypeQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Get an individual feature type in the default data store for the workspace
   * @param workspaceName The name of the workspace (required)
   * @param featureTypeName The name of the feature type (required)
   * @param quietOnNotFound Prevents logging an Exception when the feature type is not present. Note that 404 status code will be returned anyway. Defaults to \&quot;false\&quot;. (optional, default to false)
   * @return FeatureTypeResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/featuretypes/{featureTypeName}?quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  FeatureTypeResponseWrapper getFeatureTypeByDefaultStore(@Param("workspaceName") String workspaceName, @Param("featureTypeName") String featureTypeName, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * 
   * Get an individual feature type in the default data store for the workspace
   * Note, this is equivalent to the other <code>getFeatureTypeByDefaultStore</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetFeatureTypeByDefaultStoreQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace (required)
   * @param featureTypeName The name of the feature type (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>quietOnNotFound - Prevents logging an Exception when the feature type is not present. Note that 404 status code will be returned anyway. Defaults to \&quot;false\&quot;. (optional, default to false)</li>
   *   </ul>
   * @return FeatureTypeResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/featuretypes/{featureTypeName}?quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  FeatureTypeResponseWrapper getFeatureTypeByDefaultStore(@Param("workspaceName") String workspaceName, @Param("featureTypeName") String featureTypeName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getFeatureTypeByDefaultStore</code> method in a fluent style.
   */
  public static class GetFeatureTypeByDefaultStoreQueryParams extends HashMap<String, Object> {
    public GetFeatureTypeByDefaultStoreQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Get a list of feature types for the workspace and datastore. 
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param list The list parameter is used to control the category of feature types that are returned. Must be one of \&quot;configured\&quot;, \&quot;available\&quot;, \&quot;available_with_geom\&quot;, \&quot;all\&quot;  (optional)
   * @param quietOnNotFound  (optional, default to true)
   * @return FeatureTypeList
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes?list={list}&quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  FeatureTypeList getFeatureTypesByStore(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @Param("list") String list, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * 
   * Get a list of feature types for the workspace and datastore. 
   * Note, this is equivalent to the other <code>getFeatureTypesByStore</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetFeatureTypesByStoreQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>list - The list parameter is used to control the category of feature types that are returned. Must be one of \&quot;configured\&quot;, \&quot;available\&quot;, \&quot;available_with_geom\&quot;, \&quot;all\&quot;  (optional)</li>
   *   <li>quietOnNotFound -  (optional, default to true)</li>
   *   </ul>
   * @return FeatureTypeList
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes?list={list}&quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  FeatureTypeList getFeatureTypesByStore(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getFeatureTypesByStore</code> method in a fluent style.
   */
  public static class GetFeatureTypesByStoreQueryParams extends HashMap<String, Object> {
    public GetFeatureTypesByStoreQueryParams list(final String value) {
      put("list", EncodingUtils.encode(value));
      return this;
    }
    public GetFeatureTypesByStoreQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Get a list of all feature types for all datastors in the workspace. 
   * @param workspaceName The name of the workspace (required)
   * @param list The list parameter is used to control the category of feature types that are returned. Must be one of \&quot;configured\&quot;, \&quot;available\&quot;, \&quot;available_with_geom\&quot;, \&quot;all\&quot;  (optional)
   * @return FeatureTypeList
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/featuretypes?list={list}")
  @Headers({
    "Accept: application/json",
  })
  FeatureTypeList getFeatureTypesByWorkspace(@Param("workspaceName") String workspaceName, @Param("list") String list);

  /**
   * 
   * Get a list of all feature types for all datastors in the workspace. 
   * Note, this is equivalent to the other <code>getFeatureTypesByWorkspace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetFeatureTypesByWorkspaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>list - The list parameter is used to control the category of feature types that are returned. Must be one of \&quot;configured\&quot;, \&quot;available\&quot;, \&quot;available_with_geom\&quot;, \&quot;all\&quot;  (optional)</li>
   *   </ul>
   * @return FeatureTypeList
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/featuretypes?list={list}")
  @Headers({
  "Accept: application/json",
  })
  FeatureTypeList getFeatureTypesByWorkspace(@Param("workspaceName") String workspaceName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getFeatureTypesByWorkspace</code> method in a fluent style.
   */
  public static class GetFeatureTypesByWorkspaceQueryParams extends HashMap<String, Object> {
    public GetFeatureTypesByWorkspaceQueryParams list(final String value) {
      put("list", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Update an individual feature type in the default data store for the workspace
   * @param workspaceName The name of the workspace (required)
   * @param featureTypeName The name of the feature type (required)
   * @param featureTypeInfoWrapper The body of the feature type to POST (required)
   * @param recalculate Specifies whether to recalculate any bounding boxes for a feature type. Some properties of feature types are automatically recalculated when necessary. In particular, the native bounding box is recalculated when the projection or projection policy are changed, and the lat/lon bounding box is recalculated when the native bounding box is recalculated, or when a new native bounding box is explicitly provided in the request. (The native and lat/lon bounding boxes are not automatically recalculated when they are explicitly included in the request.) In addition, the client may explicitly request a fixed set of fields to calculate, by including a comma-separated list of their names in the recalculate parameter.  The empty parameter &#39;recalculate&#x3D;&#39; is useful avoid slow recalculation when operating against large datasets as &#39;recalculate&#x3D;&#39; avoids calculating any fields, regardless of any changes to projection, projection policy, etc. The nativebbox parameter &#39;recalculate&#x3D;nativebbox&#39; is used recalculates the native bounding box, while avoiding recalculating the lat/lon bounding box. Recalculate parameters can be used in together - &#39;recalculate&#x3D;nativebbox,latlonbbox&#39; can be used after a bulk import to  to recalculates both the native bounding box and the lat/lon bounding box. (optional)
   */
  @RequestLine("PUT /rest/workspaces/{workspaceName}/featuretypes/{featureTypeName}?recalculate={recalculate}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void modifyFeatureType(@Param("workspaceName") String workspaceName, @Param("featureTypeName") String featureTypeName, FeatureTypeInfoWrapper featureTypeInfoWrapper, @Param("recalculate") List<String> recalculate);

  /**
   * 
   * Update an individual feature type in the default data store for the workspace
   * Note, this is equivalent to the other <code>modifyFeatureType</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ModifyFeatureTypeQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace (required)
   * @param featureTypeName The name of the feature type (required)
   * @param featureTypeInfoWrapper The body of the feature type to POST (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>recalculate - Specifies whether to recalculate any bounding boxes for a feature type. Some properties of feature types are automatically recalculated when necessary. In particular, the native bounding box is recalculated when the projection or projection policy are changed, and the lat/lon bounding box is recalculated when the native bounding box is recalculated, or when a new native bounding box is explicitly provided in the request. (The native and lat/lon bounding boxes are not automatically recalculated when they are explicitly included in the request.) In addition, the client may explicitly request a fixed set of fields to calculate, by including a comma-separated list of their names in the recalculate parameter.  The empty parameter &#39;recalculate&#x3D;&#39; is useful avoid slow recalculation when operating against large datasets as &#39;recalculate&#x3D;&#39; avoids calculating any fields, regardless of any changes to projection, projection policy, etc. The nativebbox parameter &#39;recalculate&#x3D;nativebbox&#39; is used recalculates the native bounding box, while avoiding recalculating the lat/lon bounding box. Recalculate parameters can be used in together - &#39;recalculate&#x3D;nativebbox,latlonbbox&#39; can be used after a bulk import to  to recalculates both the native bounding box and the lat/lon bounding box. (optional)</li>
   *   </ul>
   */
  @RequestLine("PUT /rest/workspaces/{workspaceName}/featuretypes/{featureTypeName}?recalculate={recalculate}")
  @Headers({
  "Content-Type: application/json",
  "Accept: application/json",
  })
  void modifyFeatureType(@Param("workspaceName") String workspaceName, @Param("featureTypeName") String featureTypeName, FeatureTypeInfoWrapper featureTypeInfoWrapper, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>modifyFeatureType</code> method in a fluent style.
   */
  public static class ModifyFeatureTypeQueryParams extends HashMap<String, Object> {
    public ModifyFeatureTypeQueryParams recalculate(final List<String> value) {
      put("recalculate", EncodingUtils.encodeCollection(value, "csv"));
      return this;
    }
  }

  /**
   * 
   * Update an individual feature type
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param featureTypeName The name of the feature type (required)
   * @param featureTypeInfoWrapper The body of the feature type to POST (required)
   * @param recalculate Specifies whether to recalculate any bounding boxes for a feature type. Some properties of feature types are automatically recalculated when necessary. In particular, the native bounding box is recalculated when the projection or projection policy are changed, and the lat/lon bounding box is recalculated when the native bounding box is recalculated, or when a new native bounding box is explicitly provided in the request. (The native and lat/lon bounding boxes are not automatically recalculated when they are explicitly included in the request.) In addition, the client may explicitly request a fixed set of fields to calculate, by including a comma-separated list of their names in the recalculate parameter.  The empty parameter &#39;recalculate&#x3D;&#39; is useful avoid slow recalculation when operating against large datasets as &#39;recalculate&#x3D;&#39; avoids calculating any fields, regardless of any changes to projection, projection policy, etc. The nativebbox parameter &#39;recalculate&#x3D;nativebbox&#39; is used recalculates the native bounding box, while avoiding recalculating the lat/lon bounding box. Recalculate parameters can be used in together - &#39;recalculate&#x3D;nativebbox,latlonbbox&#39; can be used after a bulk import to  to recalculates both the native bounding box and the lat/lon bounding box. (optional)
   */
  @RequestLine("PUT /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes/{featureTypeName}?recalculate={recalculate}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void modifyFeatureTypeByStore(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @Param("featureTypeName") String featureTypeName, FeatureTypeInfoWrapper featureTypeInfoWrapper, @Param("recalculate") List<String> recalculate);

  /**
   * 
   * Update an individual feature type
   * Note, this is equivalent to the other <code>modifyFeatureTypeByStore</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ModifyFeatureTypeByStoreQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace (required)
   * @param storeName The name of the datastore (required)
   * @param featureTypeName The name of the feature type (required)
   * @param featureTypeInfoWrapper The body of the feature type to POST (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>recalculate - Specifies whether to recalculate any bounding boxes for a feature type. Some properties of feature types are automatically recalculated when necessary. In particular, the native bounding box is recalculated when the projection or projection policy are changed, and the lat/lon bounding box is recalculated when the native bounding box is recalculated, or when a new native bounding box is explicitly provided in the request. (The native and lat/lon bounding boxes are not automatically recalculated when they are explicitly included in the request.) In addition, the client may explicitly request a fixed set of fields to calculate, by including a comma-separated list of their names in the recalculate parameter.  The empty parameter &#39;recalculate&#x3D;&#39; is useful avoid slow recalculation when operating against large datasets as &#39;recalculate&#x3D;&#39; avoids calculating any fields, regardless of any changes to projection, projection policy, etc. The nativebbox parameter &#39;recalculate&#x3D;nativebbox&#39; is used recalculates the native bounding box, while avoiding recalculating the lat/lon bounding box. Recalculate parameters can be used in together - &#39;recalculate&#x3D;nativebbox,latlonbbox&#39; can be used after a bulk import to  to recalculates both the native bounding box and the lat/lon bounding box. (optional)</li>
   *   </ul>
   */
  @RequestLine("PUT /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes/{featureTypeName}?recalculate={recalculate}")
  @Headers({
  "Content-Type: application/json",
  "Accept: application/json",
  })
  void modifyFeatureTypeByStore(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @Param("featureTypeName") String featureTypeName, FeatureTypeInfoWrapper featureTypeInfoWrapper, @QueryMap(encoded=true) Map<String, Object> queryParams);

  @RequestLine("PUT /rest/workspaces/{workspaceName}/datastores/{storeName}/featuretypes/{featureTypeName}/reset")
  @Headers({
          "Content-Type: application/json",
          "Accept: application/json",
  })
  void resetFeatureTypeByStore(@Param("workspaceName") String workspaceName, @Param("storeName") String storeName, @Param("featureTypeName") String featureTypeName);

  /**
   * A convenience class for generating query parameters for the
   * <code>modifyFeatureTypeByStore</code> method in a fluent style.
   */
  public static class ModifyFeatureTypeByStoreQueryParams extends HashMap<String, Object> {
    public ModifyFeatureTypeByStoreQueryParams recalculate(final List<String> value) {
      put("recalculate", EncodingUtils.encodeCollection(value, "csv"));
      return this;
    }
  }
}
