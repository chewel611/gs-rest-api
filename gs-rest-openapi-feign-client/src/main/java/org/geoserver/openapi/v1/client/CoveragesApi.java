package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.CoverageInfoWrapper;
import org.geoserver.openapi.v1.model.CoverageResponseWrapper;
import org.geoserver.openapi.v1.model.CoveragesResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface CoveragesApi extends ApiClient.Api {


  /**
   * 
   * Create a new coverage, the underlying data store must exists.
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage data store (required)
   * @param coverageInfoWrapper The body of the coverage to POST (required)
   */
  @RequestLine("POST /rest/workspaces/{workspace}/coveragestores/{store}/coverages")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createCoverageAtStore(@Param("workspace") String workspace, @Param("store") String store, CoverageInfoWrapper coverageInfoWrapper);

  /**
   * 
   * Create a new coverage, the coverage definition needs to reference a store.
   * @param workspace The name of the workspace (required)
   * @param coverageInfoWrapper The body of the coverage to POST (required)
   */
  @RequestLine("POST /rest/workspaces/{workspace}/coverages")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createCoverageAtWorkspace(@Param("workspace") String workspace, CoverageInfoWrapper coverageInfoWrapper);

  /**
   * 
   * Delete a coverage (optionally recursively deleting layers).
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage datastore (required)
   * @param coverage The name of the coverage (required)
   * @param recurse The recurse controls recursive deletion. When set to true all stores containing the resource are also removed. (optional, default to false)
   */
  @RequestLine("DELETE /rest/workspaces/{workspace}/coveragestores/{store}/coverages/{coverage}?recurse={recurse}")
  @Headers({
    "Accept: application/json",
  })
  void deleteCoverage(@Param("workspace") String workspace, @Param("store") String store, @Param("coverage") String coverage, @Param("recurse") Boolean recurse);

  /**
   * 
   * Delete a coverage (optionally recursively deleting layers).
   * Note, this is equivalent to the other <code>deleteCoverage</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteCoverageQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage datastore (required)
   * @param coverage The name of the coverage (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>recurse - The recurse controls recursive deletion. When set to true all stores containing the resource are also removed. (optional, default to false)</li>
   *   </ul>
   */
  @RequestLine("DELETE /rest/workspaces/{workspace}/coveragestores/{store}/coverages/{coverage}?recurse={recurse}")
  @Headers({
  "Accept: application/json",
  })
  void deleteCoverage(@Param("workspace") String workspace, @Param("store") String store, @Param("coverage") String coverage, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteCoverage</code> method in a fluent style.
   */
  public static class DeleteCoverageQueryParams extends HashMap<String, Object> {
    public DeleteCoverageQueryParams recurse(final Boolean value) {
      put("recurse", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Get an individual coverage.
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage datastore (required)
   * @param coverage The name of the coverage (required)
   * @param quietOnNotFound The quietOnNotFound parameter avoids to log an Exception when the coverage is not present. Note that 404 status code will be returned anyway. (optional, default to false)
   * @return CoverageResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coveragestores/{store}/coverages/{coverage}?quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  CoverageResponseWrapper findCoverageByStore(@Param("workspace") String workspace, @Param("store") String store, @Param("coverage") String coverage, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * 
   * Get an individual coverage.
   * Note, this is equivalent to the other <code>findCoverageByStore</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindCoverageByStoreQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage datastore (required)
   * @param coverage The name of the coverage (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>quietOnNotFound - The quietOnNotFound parameter avoids to log an Exception when the coverage is not present. Note that 404 status code will be returned anyway. (optional, default to false)</li>
   *   </ul>
   * @return CoverageResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coveragestores/{store}/coverages/{coverage}?quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  CoverageResponseWrapper findCoverageByStore(@Param("workspace") String workspace, @Param("store") String store, @Param("coverage") String coverage, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findCoverageByStore</code> method in a fluent style.
   */
  public static class FindCoverageByStoreQueryParams extends HashMap<String, Object> {
    public FindCoverageByStoreQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Get the coverages available for the provided workspace and data store.
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage data store (required)
   * @param list If the list parameter value is equal to \&quot;all\&quot; all the coverages available in the data source (even the non published ones) will be returned. (optional)
   * @return CoveragesResponse
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coveragestores/{store}/coverages?list={list}")
  @Headers({
    "Accept: application/json",
  })
  CoveragesResponse findCoveragesByStore(@Param("workspace") String workspace, @Param("store") String store, @Param("list") String list);

  /**
   * 
   * Get the coverages available for the provided workspace and data store.
   * Note, this is equivalent to the other <code>findCoveragesByStore</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindCoveragesByStoreQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage data store (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>list - If the list parameter value is equal to \&quot;all\&quot; all the coverages available in the data source (even the non published ones) will be returned. (optional)</li>
   *   </ul>
   * @return CoveragesResponse
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coveragestores/{store}/coverages?list={list}")
  @Headers({
  "Accept: application/json",
  })
  CoveragesResponse findCoveragesByStore(@Param("workspace") String workspace, @Param("store") String store, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findCoveragesByStore</code> method in a fluent style.
   */
  public static class FindCoveragesByStoreQueryParams extends HashMap<String, Object> {
    public FindCoveragesByStoreQueryParams list(final String value) {
      put("list", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Get the coverages available for the provided workspace.
   * @param workspace The name of the workspace (required)
   * @param list If the list parameter value is equal to \&quot;all\&quot; all the coverages available in the data source (even the non published ones) will be returned. (optional)
   * @return CoveragesResponse
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coverages?list={list}")
  @Headers({
    "Accept: application/json",
  })
  CoveragesResponse findCoveragesByWorkspace(@Param("workspace") String workspace, @Param("list") String list);

  /**
   * 
   * Get the coverages available for the provided workspace.
   * Note, this is equivalent to the other <code>findCoveragesByWorkspace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindCoveragesByWorkspaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace The name of the workspace (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>list - If the list parameter value is equal to \&quot;all\&quot; all the coverages available in the data source (even the non published ones) will be returned. (optional)</li>
   *   </ul>
   * @return CoveragesResponse
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coverages?list={list}")
  @Headers({
  "Accept: application/json",
  })
  CoveragesResponse findCoveragesByWorkspace(@Param("workspace") String workspace, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findCoveragesByWorkspace</code> method in a fluent style.
   */
  public static class FindCoveragesByWorkspaceQueryParams extends HashMap<String, Object> {
    public FindCoveragesByWorkspaceQueryParams list(final String value) {
      put("list", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Get an individual coverage.
   * @param workspace The name of the workspace (required)
   * @param coverage The name of the coverage (required)
   * @param quietOnNotFound The quietOnNotFound parameter avoids to log an Exception when the coverage is not present. Note that 404 status code will be returned anyway. (optional, default to true)
   * @return CoverageResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coverages/{coverage}?quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  CoverageResponseWrapper getCoverageAtWorkspace(@Param("workspace") String workspace, @Param("coverage") String coverage, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * 
   * Get an individual coverage.
   * Note, this is equivalent to the other <code>getCoverageAtWorkspace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetCoverageAtWorkspaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace The name of the workspace (required)
   * @param coverage The name of the coverage (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>quietOnNotFound - The quietOnNotFound parameter avoids to log an Exception when the coverage is not present. Note that 404 status code will be returned anyway. (optional, default to true)</li>
   *   </ul>
   * @return CoverageResponseWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspace}/coverages/{coverage}?quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  CoverageResponseWrapper getCoverageAtWorkspace(@Param("workspace") String workspace, @Param("coverage") String coverage, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getCoverageAtWorkspace</code> method in a fluent style.
   */
  public static class GetCoverageAtWorkspaceQueryParams extends HashMap<String, Object> {
    public GetCoverageAtWorkspaceQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * Update an individual coverage
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage datastore (required)
   * @param coverage The name of the coverage (required)
   * @param coverageInfoWrapper The body of the coverage to POST (required)
   * @param calculate Comma-seperated list of optional fields to calculate. Optional fields include: \&quot;nativebbox\&quot;, \&quot;latlonbbox\&quot;. (optional)
   */
  @RequestLine("PUT /rest/workspaces/{workspace}/coveragestores/{store}/coverages/{coverage}?calculate={calculate}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateCoverage(@Param("workspace") String workspace, @Param("store") String store, @Param("coverage") String coverage, CoverageInfoWrapper coverageInfoWrapper, @Param("calculate") List<String> calculate);

  /**
   * 
   * Update an individual coverage
   * Note, this is equivalent to the other <code>updateCoverage</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link UpdateCoverageQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace The name of the workspace (required)
   * @param store The name of the coverage datastore (required)
   * @param coverage The name of the coverage (required)
   * @param coverageInfoWrapper The body of the coverage to POST (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>calculate - Comma-seperated list of optional fields to calculate. Optional fields include: \&quot;nativebbox\&quot;, \&quot;latlonbbox\&quot;. (optional)</li>
   *   </ul>
   */
  @RequestLine("PUT /rest/workspaces/{workspace}/coveragestores/{store}/coverages/{coverage}?calculate={calculate}")
  @Headers({
  "Content-Type: application/json",
  "Accept: application/json",
  })
  void updateCoverage(@Param("workspace") String workspace, @Param("store") String store, @Param("coverage") String coverage, CoverageInfoWrapper coverageInfoWrapper, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>updateCoverage</code> method in a fluent style.
   */
  public static class UpdateCoverageQueryParams extends HashMap<String, Object> {
    public UpdateCoverageQueryParams calculate(final List<String> value) {
      put("calculate", EncodingUtils.encodeCollection(value, "csv"));
      return this;
    }
  }
}
