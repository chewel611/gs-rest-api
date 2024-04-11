package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.LayerInfoWrapper;
import org.geoserver.openapi.v1.model.LayerResponse;
import org.geoserver.openapi.v1.model.Layers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface LayersApi extends ApiClient.Api {


  /**
   * Delete layer
   * Deletes a layer from the server.
   * @param qualifiedLayerName The name of the layer to retrieve, preferrably including namespace prefix (e.g. \&quot;cite:roads\&quot;) to avoid ambiguities (required)
   * @param recurse Recursively removes the layer from all layer groups which reference it. If this results in an empty layer group, also delete the layer group. Allowed values for this parameter are true or false. The default value is false. A request with &#39;recurse&#x3D;false&#39; will fail if any layer groups reference the layer. (optional, default to false)
   */
  @RequestLine("DELETE /rest/layers/{qualifiedLayerName}?recurse={recurse}")
  @Headers({
    "Accept: application/json",
  })
  void deleteLayer(@Param("qualifiedLayerName") String qualifiedLayerName, @Param("recurse") Boolean recurse);

  /**
   * Delete layer
   * Deletes a layer from the server.
   * Note, this is equivalent to the other <code>deleteLayer</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteLayerQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param qualifiedLayerName The name of the layer to retrieve, preferrably including namespace prefix (e.g. \&quot;cite:roads\&quot;) to avoid ambiguities (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>recurse - Recursively removes the layer from all layer groups which reference it. If this results in an empty layer group, also delete the layer group. Allowed values for this parameter are true or false. The default value is false. A request with &#39;recurse&#x3D;false&#39; will fail if any layer groups reference the layer. (optional, default to false)</li>
   *   </ul>
   */
  @RequestLine("DELETE /rest/layers/{qualifiedLayerName}?recurse={recurse}")
  @Headers({
  "Accept: application/json",
  })
  void deleteLayer(@Param("qualifiedLayerName") String qualifiedLayerName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteLayer</code> method in a fluent style.
   */
  public static class DeleteLayerQueryParams extends HashMap<String, Object> {
    public DeleteLayerQueryParams recurse(final Boolean value) {
      put("recurse", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Delete layer
   * Deletes a layer from the server.
   * @param workspaceName The name of the workspace the layer is in. (required)
   * @param layerName The name of the layer to retrieve, *without* workspace prefix, since it&#39;s given by the workspaceName parameter already. Request will fail otherwise. (required)
   * @param recurse Recursively removes the layer from all layer groups which reference it. If this results in an empty layer group, also delete the layer group. Allowed values for this parameter are true or false. The default value is false. A request with &#39;recurse&#x3D;false&#39; will fail if any layer groups reference the layer. (optional, default to false)
   */
  @RequestLine("DELETE /rest/workspaces/{workspaceName}/layers/{layerName}?recurse={recurse}")
  @Headers({
    "Accept: application/json",
  })
  void deleteLayerByWorkspace(@Param("workspaceName") String workspaceName, @Param("layerName") String layerName, @Param("recurse") Boolean recurse);

  /**
   * Delete layer
   * Deletes a layer from the server.
   * Note, this is equivalent to the other <code>deleteLayerByWorkspace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteLayerByWorkspaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace the layer is in. (required)
   * @param layerName The name of the layer to retrieve, *without* workspace prefix, since it&#39;s given by the workspaceName parameter already. Request will fail otherwise. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>recurse - Recursively removes the layer from all layer groups which reference it. If this results in an empty layer group, also delete the layer group. Allowed values for this parameter are true or false. The default value is false. A request with &#39;recurse&#x3D;false&#39; will fail if any layer groups reference the layer. (optional, default to false)</li>
   *   </ul>
   */
  @RequestLine("DELETE /rest/workspaces/{workspaceName}/layers/{layerName}?recurse={recurse}")
  @Headers({
  "Accept: application/json",
  })
  void deleteLayerByWorkspace(@Param("workspaceName") String workspaceName, @Param("layerName") String layerName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteLayerByWorkspace</code> method in a fluent style.
   */
  public static class DeleteLayerByWorkspaceQueryParams extends HashMap<String, Object> {
    public DeleteLayerByWorkspaceQueryParams recurse(final Boolean value) {
      put("recurse", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Retrieve a layer
   * Retrieves a single layer definition.
   * @param qualifiedLayerName The name of the layer to retrieve, preferrably including namespace prefix (e.g. \&quot;cite:roads\&quot;) to avoid ambiguities (required)
   * @return LayerResponse
   */
  @RequestLine("GET /rest/layers/{qualifiedLayerName}")
  @Headers({
    "Accept: application/json",
  })
  LayerResponse getLayer(@Param("qualifiedLayerName") String qualifiedLayerName);

  /**
   * Retrieve a layer
   * Retrieves a single layer definition.
   * @param workspaceName The name of the workspace the layer is in. (required)
   * @param layerName The name of the layer to retrieve, *without* workspace prefix, since it&#39;s given by the workspaceName parameter already. Request will fail otherwise. (required)
   * @param quietOnNotFound  (optional, default to true)
   * @return LayerResponse
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/layers/{layerName}?quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  LayerResponse getLayerByWorkspace(@Param("workspaceName") String workspaceName, @Param("layerName") String layerName, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * Retrieve a layer
   * Retrieves a single layer definition.
   * Note, this is equivalent to the other <code>getLayerByWorkspace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetLayerByWorkspaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceName The name of the workspace the layer is in. (required)
   * @param layerName The name of the layer to retrieve, *without* workspace prefix, since it&#39;s given by the workspaceName parameter already. Request will fail otherwise. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>quietOnNotFound -  (optional, default to true)</li>
   *   </ul>
   * @return LayerResponse
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/layers/{layerName}?quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  LayerResponse getLayerByWorkspace(@Param("workspaceName") String workspaceName, @Param("layerName") String layerName, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getLayerByWorkspace</code> method in a fluent style.
   */
  public static class GetLayerByWorkspaceQueryParams extends HashMap<String, Object> {
    public GetLayerByWorkspaceQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get a list of layers
   * Displays a list of all layers on the server.
   * @return Layers
   */
  @RequestLine("GET /rest/layers")
  @Headers({
    "Accept: application/json",
  })
  Layers getLayers();

  /**
   * Get a list of layers in a workspace.
   * Displays a list of all layers in the provided workspace.
   * @param workspaceName The name of the workspace to list layers in (required)
   * @return Layers
   */
  @RequestLine("GET /rest/workspaces/{workspaceName}/layers")
  @Headers({
    "Accept: application/json",
  })
  Layers getLayersByWorkspace(@Param("workspaceName") String workspaceName);

  /**
   * Modify a layer.
   * Modifies an existing layer on the server.
   * @param qualifiedLayerName The name of the layer to retrieve, preferrably including namespace prefix (e.g. \&quot;cite:roads\&quot;) to avoid ambiguities (required)
   * @param layerInfoWrapper The updated layer definition. (required)
   */
  @RequestLine("PUT /rest/layers/{qualifiedLayerName}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateLayer(@Param("qualifiedLayerName") String qualifiedLayerName, LayerInfoWrapper layerInfoWrapper);

  /**
   * Modify a layer.
   * Modifies an existing layer on the server.
   * @param workspaceName The name of the workspace the layer is in. (required)
   * @param layerName The name of the layer to retrieve, *without* workspace prefix, since it&#39;s given by the workspaceName parameter already. Request will fail otherwise. (required)
   * @param layerInfoWrapper The updated layer definition. (required)
   */
  @RequestLine("PUT /rest/workspaces/{workspaceName}/layers/{layerName}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateLayerByWorkspace(@Param("workspaceName") String workspaceName, @Param("layerName") String layerName, LayerInfoWrapper layerInfoWrapper);
}
