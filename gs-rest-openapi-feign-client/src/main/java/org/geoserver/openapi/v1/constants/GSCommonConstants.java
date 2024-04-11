package org.geoserver.openapi.v1.constants;

public interface GSCommonConstants {
    String MAPBOX_VECTOR_TILE = "application/vnd.mapbox-vector-tile";
    String IMAGE_GIF = "image/gif";
    String IMAGE_JPEG = "image/jpeg";
    String IMAGE_PNG = "image/png";
    String TRUNCATE_LAYER = "<truncateLayer><layerName>%s</layerName></truncateLayer>";
    String TRUNCATE_EXTENT = "<truncateExtent><layerName>%s</layerName><gridSetId>%s</gridSetId></truncateExtent>";
}
