package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface DefaultApi extends ApiClient.Api {


  /**
   * 
   * Delete the settings for this workspace.
   * @param workspace The workspace name (required)
   */
  @RequestLine("DELETE /rest/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  void deleteWorkspaceSettings(@Param("workspace") String workspace);
}
