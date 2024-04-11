package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.CoverageStoreInfoWrapper;
import org.geoserver.openapi.v1.model.CoverageStoreResponseWrapper;
import org.geoserver.openapi.v1.model.CoverageStoresResponse;
import org.geoserver.openapi.v1.model.PurgeOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface CoveragestoresApi extends ApiClient.Api {


  /**
   * Add a new coverage store
   * Adds a new coverage store entry to the server.
   * @param workspace The name of the worskpace containing the coverage stores. (required)
   * @param coverageStoreInfoWrapper The coverage store body information to upload. (required)
   * @return String
   */
  @RequestLine("POST /rest/workspaces/{workspace}/coveragestores")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  String createCoverageStore(@Param("workspace") String workspace, CoverageStoreInfoWrapper coverageStoreInfoWrapper);

  /**
   * Delete coverage store
   * Deletes a coverage store
   * @param workspace The name of the worskpace containing the coverage stores. (required)
   * @param store The name of the store to be retrieved (required)
   * @param purge The purge parameter specifies if and how the underlying raster data source is deleted. Allowable values for this parameter are \&quot;none\&quot;, \&quot;metadata\&quot;, \&quot;all\&quot;. When set to \&quot;none\&quot; data and auxiliary files are preserved. When set to \&quot;metadata\&quot; delete only auxiliary files and metadata. It’s recommended when data files (such as granules) should not be deleted from disk. Finally, when set to \&quot;all\&quot; both data and auxiliary files are removed. (optional)
   * @param recurse The recurse controls recursive deletion. When set to true all resources contained in the store are also removed. The default value is \&quot;false\&quot;. (optional)
   */
  @RequestLine("DELETE /rest/workspaces/{workspace}/coveragestores/{store}?purge={purge}&recurse={recurse}")
  @Headers({
    "Accept: application/json",
  })
  void deleteCoverageStore(@Param("workspace") String workspace, @Param("store") String store, @Param("purge") PurgeOption purge, @Param("recurse") Boolean recurse);

  /**
   * Delete coverage store
   * Deletes a coverage store
   * Note, this is equivalent to the other <code>deleteCoverageStore</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteCoverageStoreQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace The name of the worskpace containing the coverage stores. (required)
   * @param store The name of the store to be retrieved (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>purge - The purge parameter specifies if and how the underlying raster data source is deleted. Allowable values for this parameter are \&quot;none\&quot;, \&quot;metadata\&quot;, \&quot;all\&quot;. When set to \&quot;none\&quot; data and auxiliary files are preserved. When set to \&quot;metadata\&quot; delete only auxiliary files and metadata. It’s recommended when data files (such as granules) should not be deleted from disk. Finally, when set to \&quot;all\&quot; both data and auxiliary files are removed. (optional)</li>
   *   <li>recurse - The recurse controls recursive deletion. When set to true all resources contained in the store are also removed. The default value is \&quot;false\&quot;. (optional)</li>
   *   </ul>
   */
  @RequestLine("DELETE /rest/workspaces/{workspace}/coveragestores/{store}?purge={purge}&recurse={recurse}")
  @Headers({
  "Accept: application/json",
  })
  void deleteCoverageStore(@Param("workspace") String workspace, @Param("store") String store, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteCoverageStore</code> method in a fluent style.
   */
  public static class DeleteCoverageStoreQueryParams extends HashMap<String, Object> {
    public DeleteCoverageStoreQueryParams purge(final PurgeOption value) {
      put("purge", EncodingUtils.encode(value));
      return this;
    }
    public DeleteCoverageStoreQueryParams recurse(final Boolean value) {
      put("recurse", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get a coverage store named {store} in the {workspace} workspace
   * Displays a representation of the coverage store.
   * @param workspace The name of the worskpace containing the coverage stores. (required)
   * @param store The name of the store to be retrieved (required)
   * @param quietOnNotFound When set to true, avoids to log an Exception when the coverage store is not present. Note that 404 status code will be returned anyway. (optional)
   * @return CoverageStoreResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coveragestores/{store}?quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  CoverageStoreResponseWrapper getCoverageStore(@Param("workspace") String workspace, @Param("store") String store, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * Get a coverage store named {store} in the {workspace} workspace
   * Displays a representation of the coverage store.
   * Note, this is equivalent to the other <code>getCoverageStore</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetCoverageStoreQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace The name of the worskpace containing the coverage stores. (required)
   * @param store The name of the store to be retrieved (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>quietOnNotFound - When set to true, avoids to log an Exception when the coverage store is not present. Note that 404 status code will be returned anyway. (optional)</li>
   *   </ul>
   * @return CoverageStoreResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coveragestores/{store}?quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  CoverageStoreResponseWrapper getCoverageStore(@Param("workspace") String workspace, @Param("store") String store, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getCoverageStore</code> method in a fluent style.
   */
  public static class GetCoverageStoreQueryParams extends HashMap<String, Object> {
    public GetCoverageStoreQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get a list of all coverage stores in {workspace}
   * Displays a list of all styles on the server.
   * @param workspace The name of the worskpace containing the coverage stores. (required)
   * @return CoverageStoresResponse
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coveragestores")
  @Headers({
    "Accept: application/json",
  })
  CoverageStoresResponse getCoverageStores(@Param("workspace") String workspace);

  /**
   * Modify a single coverage store.
   * Modifies a single coverage store.
   * @param workspace The name of the worskpace containing the coverage stores. (required)
   * @param store The name of the store to be retrieved (required)
   * @param coverageStoreInfoWrapper The coverage store body information to upload. (required)
   */
  @RequestLine("PUT /rest/workspaces/{workspace}/coveragestores/{store}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void modifyCoverageStore(@Param("workspace") String workspace, @Param("store") String store, CoverageStoreInfoWrapper coverageStoreInfoWrapper);
}
