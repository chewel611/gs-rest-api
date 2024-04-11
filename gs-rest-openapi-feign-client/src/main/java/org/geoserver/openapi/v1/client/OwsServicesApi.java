package org.geoserver.openapi.v1.client;

import org.geoserver.openapi.client.internal.ApiClient;
import org.geoserver.openapi.client.internal.EncodingUtils;

import org.geoserver.openapi.v1.model.WCSInfoWrapper;
import org.geoserver.openapi.v1.model.WFSInfoWrapper;
import org.geoserver.openapi.v1.model.WMSInfoWrapper;
import org.geoserver.openapi.v1.model.WMTSInfoWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface OwsServicesApi extends ApiClient.Api {


  /**
   * 
   * Deletes a workspace-specific WCS setting.
   * @param workspace The workspace name (required)
   */
  @RequestLine("DELETE /rest/services/wcs/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  void deleteLocalWCSSettings(@Param("workspace") String workspace);

  /**
   * 
   * Deletes a workspace-specific WFS setting.
   * @param workspace The workspace name (required)
   */
  @RequestLine("DELETE /rest/services/wfs/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  void deleteLocalWFSSettings(@Param("workspace") String workspace);

  /**
   * 
   * Deletes a workspace-specific WMS setting.
   * @param workspace The workspace name (required)
   */
  @RequestLine("DELETE /rest/services/wms/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  void deleteLocalWMSSettings(@Param("workspace") String workspace);

  /**
   * 
   * Deletes a workspace-specific WMTS setting.
   * @param workspace The workspace name (required)
   */
  @RequestLine("DELETE /rest/services/wmts/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  void deleteLocalWMTSSettings(@Param("workspace") String workspace);

  /**
   * 
   * Retrieves Web Coverage Service settings for a given workspace.
   * @param workspace The workspace name (required)
   * @return WCSInfoWrapper
   */
  @RequestLine("GET /rest/services/wcs/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  WCSInfoWrapper getLocalWCSSettings(@Param("workspace") String workspace);

  /**
   * 
   * Retrieves Web Feature Service settings for a given workspace.
   * @param workspace The workspace name (required)
   * @return WFSInfoWrapper
   */
  @RequestLine("GET /rest/services/wfs/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  WFSInfoWrapper getLocalWFSSettings(@Param("workspace") String workspace);

  /**
   * 
   * Retrieves Web Map Service settings for a given workspace.
   * @param workspace The workspace name (required)
   * @return WMSInfoWrapper
   */
  @RequestLine("GET /rest/services/wms/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  WMSInfoWrapper getLocalWMSSettings(@Param("workspace") String workspace);

  /**
   * 
   * Retrieves Web Map Service settings for a given workspace.
   * @param workspace The workspace name (required)
   * @return WMTSInfoWrapper
   */
  @RequestLine("GET /rest/services/wmts/workspaces/{workspace}/settings")
  @Headers({
    "Accept: application/json",
  })
  WMTSInfoWrapper getLocalWMTSSettings(@Param("workspace") String workspace);

  /**
   * 
   * Retrieves Web Coverage Service global settings..
   * @return WCSInfoWrapper
   */
  @RequestLine("GET /rest/services/wcs/settings")
  @Headers({
    "Accept: application/json",
  })
  WCSInfoWrapper getWCSSettings();

  /**
   * 
   * Retrieves Web Feature Service global settings..
   * @return WFSInfoWrapper
   */
  @RequestLine("GET /rest/services/wfs/settings")
  @Headers({
    "Accept: application/json",
  })
  WFSInfoWrapper getWFSSettings();

  /**
   * 
   * Retrieves Web Map Service global settings..
   * @return WMSInfoWrapper
   */
  @RequestLine("GET /rest/services/wms/settings")
  @Headers({
    "Accept: application/json",
  })
  WMSInfoWrapper getWMSSettings();

  /**
   * 
   * Retrieves Web Map Tile Service global settings..
   * @return WMTSInfoWrapper
   */
  @RequestLine("GET /rest/services/wmts/settings")
  @Headers({
    "Accept: application/json",
  })
  WMTSInfoWrapper getWMTSSettings();

  /**
   * 
   * Edits a workspace-specific WCS setting.
   * @param workspace The workspace name (required)
   * @param wcSInfoWrapper Body of the WCS settings (required)
   */
  @RequestLine("PUT /rest/services/wcs/workspaces/{workspace}/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateLocalWCSSettings(@Param("workspace") String workspace, WCSInfoWrapper wcSInfoWrapper);

  /**
   * 
   * Edits a workspace-specific WFS setting.
   * @param workspace The workspace name (required)
   * @param wfSInfoWrapper Body of the WFS settings (required)
   */
  @RequestLine("PUT /rest/services/wfs/workspaces/{workspace}/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateLocalWFSSettings(@Param("workspace") String workspace, WFSInfoWrapper wfSInfoWrapper);

  /**
   * 
   * Edits a workspace-specific WMS setting.
   * @param workspace The workspace name (required)
   * @param wmSInfoWrapper Body of the WMS settings (required)
   */
  @RequestLine("PUT /rest/services/wms/workspaces/{workspace}/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateLocalWMSSettings(@Param("workspace") String workspace, WMSInfoWrapper wmSInfoWrapper);

  /**
   * 
   * Edits a workspace-specific WMTS setting.
   * @param workspace The workspace name (required)
   * @param wmTSInfoWrapper Body of the WMTS settings (required)
   */
  @RequestLine("PUT /rest/services/wmts/workspaces/{workspace}/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateLocalWMTSSettings(@Param("workspace") String workspace, WMTSInfoWrapper wmTSInfoWrapper);

  /**
   * 
   * Edits a global WCS setting.
   * @param wcSInfoWrapper Body of the WCS settings (required)
   */
  @RequestLine("PUT /rest/services/wcs/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateWCSSettings(WCSInfoWrapper wcSInfoWrapper);

  /**
   * 
   * Edits a global WFS setting.
   * @param wfSInfoWrapper Body of the WFS settings (required)
   */
  @RequestLine("PUT /rest/services/wfs/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateWFSSettings(WFSInfoWrapper wfSInfoWrapper);

  /**
   * 
   * Edits a global WMS setting.
   * @param wmSInfoWrapper Body of the WMS settings (required)
   */
  @RequestLine("PUT /rest/services/wms/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateWMSSettings(WMSInfoWrapper wmSInfoWrapper);

  /**
   * 
   * Edits a global WMTS setting.
   * @param wmTSInfoWrapper Body of the WMTS settings (required)
   */
  @RequestLine("PUT /rest/services/wmts/settings")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateWMTSSettings(WMTSInfoWrapper wmTSInfoWrapper);
}
