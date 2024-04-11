package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
        BoundingBoxInfo.JSON_PROPERTY_COORDS
})
@Data
@NoArgsConstructor
public class BoundingBoxInfo {
    public static final String JSON_PROPERTY_COORDS = "coords";

    /**
     * 坐标边界(minx, miny, maxx, maxy)
     */
    @JsonProperty(JSON_PROPERTY_COORDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private double[] coords = new double[4];

    public BoundingBoxInfo(double minx, double miny, double maxx, double maxy) {
        this.coords[0] = minx;
        this.coords[1] = miny;
        this.coords[2] = maxx;
        this.coords[3] = maxy;
    }

    public BoundingBoxInfo(double[] coords) {
        if (coords.length != 4) {
            throw new IllegalArgumentException("coords must be length 4");
        }

        this.coords = coords;
    }
}
