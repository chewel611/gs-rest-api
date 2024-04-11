package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.VersionResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ManifestsApi extends ApiClient.Api {


  /**
   * 
   * This endpoint shows only the details for the high-level components: GeoServer, GeoTools, and GeoWebCache. Use the \&quot;Accept:\&quot; header to specify format or append an extension to the endpoint (example \&quot;/about/manifest.xml\&quot; for XML).
   * @param manifest The manifest parameter is used to filter over resulting resource (manifest) names attribute using Java regular expressions. (optional)
   * @param key Only return manifest entries with this key in their properties. It can be optionally combined with the value parameter. (optional)
   * @param value Only return manifest entries that have this value for the provided key parameter. (optional)
   * @return VersionResponse
   */
  @RequestLine("GET /rest/about/version?manifest={manifest}&key={key}&value={value}")
  @Headers({
    "Accept: application/json",
  })
  VersionResponse getComponentVersions(@Param("manifest") String manifest, @Param("key") String key, @Param("value") String value);

  /**
   * 
   * This endpoint shows only the details for the high-level components: GeoServer, GeoTools, and GeoWebCache. Use the \&quot;Accept:\&quot; header to specify format or append an extension to the endpoint (example \&quot;/about/manifest.xml\&quot; for XML).
   * Note, this is equivalent to the other <code>getComponentVersions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetComponentVersionsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>manifest - The manifest parameter is used to filter over resulting resource (manifest) names attribute using Java regular expressions. (optional)</li>
   *   <li>key - Only return manifest entries with this key in their properties. It can be optionally combined with the value parameter. (optional)</li>
   *   <li>value - Only return manifest entries that have this value for the provided key parameter. (optional)</li>
   *   </ul>
   * @return VersionResponse
   */
  @RequestLine("GET /rest/about/version?manifest={manifest}&key={key}&value={value}")
  @Headers({
  "Accept: application/json",
  })
  VersionResponse getComponentVersions(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getComponentVersions</code> method in a fluent style.
   */
  public static class GetComponentVersionsQueryParams extends HashMap<String, Object> {
    public GetComponentVersionsQueryParams manifest(final String value) {
      put("manifest", EncodingUtils.encode(value));
      return this;
    }
    public GetComponentVersionsQueryParams key(final String value) {
      put("key", EncodingUtils.encode(value));
      return this;
    }
    public GetComponentVersionsQueryParams value(final String value) {
      put("value", EncodingUtils.encode(value));
      return this;
    }
  }
}
