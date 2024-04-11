package org.geoserver.openapi.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CRS {
    /**
     * 坐标系名称(EPSG)
     */
    private Integer code;
    /**
     * 坐标系WKT描述值
     */
    private String wkt;

    public static CRS of(String content) {
        int index = content.indexOf("=");
        if(index <=0) {
            throw new IllegalArgumentException("Invalid CRS content: "+ content);
        }
        return new CRS(Integer.parseInt(content.substring(0, index)), content.substring(index+1));
    }

    public String toContent() {
        return code + "=" + wkt;
    }
}
