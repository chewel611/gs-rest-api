package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.GetWorkspaceResponse;
import org.geoserver.openapi.v1.model.WorkspaceWrapper;
import org.geoserver.openapi.v1.model.WorkspacesResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface WorkspacesApi extends ApiClient.Api {


  /**
   * add a new workspace to GeoServer
   * Adds a new workspace to the server
   * @param workspaceWrapper The Workspace body information to upload. (required)
   * @param _default New workspace will be the used as the default. Allowed values are true or false,  The default value is false. (optional, default to false)
   */
  @RequestLine("POST /rest/workspaces?default={_default}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createWorkspace(WorkspaceWrapper workspaceWrapper, @Param("_default") Boolean _default);

  /**
   * add a new workspace to GeoServer
   * Adds a new workspace to the server
   * Note, this is equivalent to the other <code>createWorkspace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CreateWorkspaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspaceWrapper The Workspace body information to upload. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>_default - New workspace will be the used as the default. Allowed values are true or false,  The default value is false. (optional, default to false)</li>
   *   </ul>
   */
  @RequestLine("POST /rest/workspaces?default={_default}")
  @Headers({
  "Content-Type: application/json",
  "Accept: application/json",
  })
  void createWorkspace(WorkspaceWrapper workspaceWrapper, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>createWorkspace</code> method in a fluent style.
   */
  public static class CreateWorkspaceQueryParams extends HashMap<String, Object> {
    public CreateWorkspaceQueryParams _default(final Boolean value) {
      put("default", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param workspace the name of the workspace to fetch (required)
   * @param recurse delete workspace contents (default false) (optional)
   */
  @RequestLine("DELETE /rest/workspaces/{workspace}?recurse={recurse}")
  @Headers({
    "Accept: application/json",
  })
  void deleteWorkspace(@Param("workspace") String workspace, @Param("recurse") Boolean recurse);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>deleteWorkspace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteWorkspaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace the name of the workspace to fetch (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>recurse - delete workspace contents (default false) (optional)</li>
   *   </ul>
   */
  @RequestLine("DELETE /rest/workspaces/{workspace}?recurse={recurse}")
  @Headers({
  "Accept: application/json",
  })
  void deleteWorkspace(@Param("workspace") String workspace, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteWorkspace</code> method in a fluent style.
   */
  public static class DeleteWorkspaceQueryParams extends HashMap<String, Object> {
    public DeleteWorkspaceQueryParams recurse(final Boolean value) {
      put("recurse", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Retrieve a Workspace
   * Retrieves a single workspace definition.
   * @param workspace the name of the workspace to fetch (required)
   * @param quietOnNotFound  (optional, default to true)
   * @return GetWorkspaceResponse
   */
  @RequestLine("GET /rest/workspaces/{workspace}?quietOnNotFound={quietOnNotFound}")
  @Headers({
    "Accept: application/json",
  })
  GetWorkspaceResponse getWorkspace(@Param("workspace") String workspace, @Param("quietOnNotFound") Boolean quietOnNotFound);

  /**
   * Retrieve a Workspace
   * Retrieves a single workspace definition.
   * Note, this is equivalent to the other <code>getWorkspace</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetWorkspaceQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param workspace the name of the workspace to fetch (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>quietOnNotFound -  (optional, default to true)</li>
   *   </ul>
   * @return GetWorkspaceResponse
   */
  @RequestLine("GET /rest/workspaces/{workspace}?quietOnNotFound={quietOnNotFound}")
  @Headers({
  "Accept: application/json",
  })
  GetWorkspaceResponse getWorkspace(@Param("workspace") String workspace, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getWorkspace</code> method in a fluent style.
   */
  public static class GetWorkspaceQueryParams extends HashMap<String, Object> {
    public GetWorkspaceQueryParams quietOnNotFound(final Boolean value) {
      put("quietOnNotFound", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Get a list of workspaces
   * Displays a list of all workspaces on the server.
   * @return WorkspacesResponse
   */
  @RequestLine("GET /rest/workspaces")
  @Headers({
    "Accept: application/json",
  })
  WorkspacesResponse getWorkspaces();

  /**
   * Update a workspace
   * takes the body of the post and modifies the workspace from it.
   * @param workspace the name of the workspace to fetch (required)
   * @param workspaceWrapper The Workspace body information to upload. (required)
   */
  @RequestLine("PUT /rest/workspaces/{workspace}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void modifyWorkspace(@Param("workspace") String workspace, WorkspaceWrapper workspaceWrapper);
}
