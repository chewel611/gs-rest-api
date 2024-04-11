package org.geoserver.openapi.v1.model;

import cn.hutool.core.util.ObjUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geoserver.openapi.primitive.DoubleList;

@JsonPropertyOrder({
        BoundingBoxInfo.JSON_PROPERTY_COORDS
})
@Data
@NoArgsConstructor
public class BoundingBox {
    public static final String JSON_PROPERTY_COORDS = "coords";

    /**
     * 坐标边界(minx, miny, maxx, maxy)
     */
    @JsonProperty(JSON_PROPERTY_COORDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private DoubleList coords = new DoubleList();

    public BoundingBox(double minx, double miny, double maxx, double maxy) {
        if(ObjUtil.isNull(coords)) {
            coords = new DoubleList();
        }
        coords.add(minx);
        coords.add(miny);
        coords.add(maxx);
        coords.add(maxy);
    }

    public BoundingBox(Double[] boundingBox) {
        if(ObjUtil.isNull(coords)) {
            coords = new DoubleList();
        }
        coords.add(boundingBox[0]);
        coords.add(boundingBox[1]);
        coords.add(boundingBox[2]);
        coords.add(boundingBox[3]);
    }

    public BoundingBox(double[] boundingBox) {
        if(ObjUtil.isNull(coords)) {
            coords = new DoubleList();
        }
        coords.add(boundingBox[0]);
        coords.add(boundingBox[1]);
        coords.add(boundingBox[2]);
        coords.add(boundingBox[3]);
    }
}
