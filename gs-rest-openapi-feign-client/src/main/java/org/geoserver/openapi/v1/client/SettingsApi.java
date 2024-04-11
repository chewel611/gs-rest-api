package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.ContactInfoWrapper;
import org.geoserver.openapi.v1.model.GeoServerInfoWrapper;
import org.geoserver.openapi.v1.model.SettingsInfoWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface SettingsApi extends ApiClient.Api {


  /**
   * Create workspace-specific settings
   * Create new workspace-specific settings on the server.
   * @param workspace The workspace name (required)
   * @param settingsInfoWrapper The workspace-specific settings information to upload. (required)
   */
  @RequestLine("POST /rest/workspaces/{workspace}/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createLocalSettings(@Param("workspace") String workspace, SettingsInfoWrapper settingsInfoWrapper);

  /**
   * Get the global contact information
   * Displays a list of all global contact settings on the server. This is a subset of what is available at the /settings endpoint.
   * @return ContactInfoWrapper
   */
  @RequestLine("GET /rest/settings/contact")
  @Headers({
    "Accept: application/json",
  })
  ContactInfoWrapper getGlobalContactInfo();

  /**
   * Get workspace-specific settings
   * Displays all workspace-specific settings.
   * @param workspace The workspace name (required)
   * @return SettingsInfoWrapper
   */
  @RequestLine("GET /rest/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  SettingsInfoWrapper getLocalSettings(@Param("workspace") String workspace);

  /**
   * Get geoserver global settings
   * 
   * @return GeoServerInfoWrapper
   */
  @RequestLine("GET /rest/settings")
  @Headers({
    "Accept: application/json",
  })
  GeoServerInfoWrapper getSettings();

  /**
   * Update contact settings
   * Updates global contact settings on the server.
   * @param contactInfoWrapper The contact settings information to upload. (required)
   */
  @RequestLine("PUT /rest/settings/contact")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateGlobalContactInfo(ContactInfoWrapper contactInfoWrapper);

  /**
   * Update workspace-specific settings
   * Updates workspace-specific settings on the server.
   * @param workspace The workspace name (required)
   * @param settingsInfoWrapper The workspace-specific settings information to upload. (required)
   */
  @RequestLine("PUT /rest/workspaces/{workspace}/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateLocalSettings(@Param("workspace") String workspace, SettingsInfoWrapper settingsInfoWrapper);

  /**
   * Update the global configuration
   * Adds a new data store to the workspace.
   * @param geoServerInfoWrapper global settings upload request body (required)
   */
  @RequestLine("PUT /rest/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateSettings(GeoServerInfoWrapper geoServerInfoWrapper);
}
