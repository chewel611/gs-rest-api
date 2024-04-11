package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.NamespaceWrapper;
import org.geoserver.openapi.v1.model.NamespacesResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface NamespacesApi extends ApiClient.Api {


  /**
   * Add a new namespace to GeoServer
   * Adds a new namespace to the server
   * @param namespaceWrapper The Namespace body information to upload. (required)
   * @return String
   */
  @RequestLine("POST /rest/namespaces")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  String addNamespace(NamespaceWrapper namespaceWrapper);

  /**
   * Delete a namespace
   * 
   * @param namespacePrefix The name of the namespace to fetch, or \&quot;default\&quot; to get the default namespace. (required)
   */
  @RequestLine("DELETE /rest/namespaces/{namespacePrefix}")
  @Headers({
    "Accept: application/json",
  })
  void deleteNamespace(@Param("namespacePrefix") String namespacePrefix);

  /**
   * Retrieve a namespace
   * Retrieves a single namespace definition.
   * @param namespacePrefix The name of the namespace to fetch, or \&quot;default\&quot; to get the default namespace. (required)
   * @param quietOnNotFound  (optional, default to true)
   * @return NamespaceWrapper
   */
  @RequestLine("GET /rest/namespaces/{namespacePrefix}?quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  NamespaceWrapper getNamespace(@Param("namespacePrefix") String namespacePrefix, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * Retrieve a namespace
   * Retrieves a single namespace definition.
   * Note, this is equivalent to the other <code>getNamespace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetNamespaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param namespacePrefix The name of the namespace to fetch, or \&quot;default\&quot; to get the default namespace. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>quietOnNotFound -  (optional, default to true)</li>
   *   </ul>
   * @return NamespaceWrapper
   */
  @RequestLine("GET /rest/namespaces/{namespacePrefix}?quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  NamespaceWrapper getNamespace(@Param("namespacePrefix") String namespacePrefix, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getNamespace</code> method in a fluent style.
   */
  public static class GetNamespaceQueryParams extends HashMap<String, Object> {
    public GetNamespaceQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get a list of namespaces
   * Displays a list of all namespaces on the server.
   * @return NamespacesResponse
   */
  @RequestLine("GET /rest/namespaces")
  @Headers({
    "Accept: application/json",
  })
  NamespacesResponse getNamespaces();

  /**
   * Update a namespace
   * Takes the body of the put and modifies the namespace from it.
   * @param namespacePrefix The name of the namespace to fetch, or \&quot;default\&quot; to get the default namespace. (required)
   * @param namespaceWrapper The Namespace body information to upload. (required)
   */
  @RequestLine("PUT /rest/namespaces/{namespacePrefix}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void modifyNamespace(@Param("namespacePrefix") String namespacePrefix, NamespaceWrapper namespaceWrapper);
}
