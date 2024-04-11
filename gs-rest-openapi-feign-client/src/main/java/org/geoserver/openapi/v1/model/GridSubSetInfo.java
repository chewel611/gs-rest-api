package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        GridSubSetInfo.JSON_PROPERTY_GRID_SET_NAME,
        GridSubSetInfo.JSON_PROPERTY_ZOOM_START,
        GridSubSetInfo.JSON_PROPERTY_ZOOM_STOP,
        GridSubSetInfo.JSON_PROPERTY_EXTENT,
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GridSubSetInfo {
    public static final String JSON_PROPERTY_GRID_SET_NAME = "gridSetName";
    public static final String JSON_PROPERTY_ZOOM_START = "zoomStart";
    public static final String JSON_PROPERTY_ZOOM_STOP = "zoomStop";
    public static final String JSON_PROPERTY_EXTENT = "extent";

    @JsonProperty(JSON_PROPERTY_GRID_SET_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String gridSetName;

    @JsonProperty(JSON_PROPERTY_ZOOM_START)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer zoomStart;

    @JsonProperty(JSON_PROPERTY_ZOOM_STOP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer zoomStop;

    @JsonProperty(JSON_PROPERTY_EXTENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private BoundingBoxInfo extent;
}
