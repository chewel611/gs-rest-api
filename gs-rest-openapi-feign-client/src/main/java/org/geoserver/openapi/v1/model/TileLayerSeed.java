package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.geoserver.openapi.v1.enums.TileSeedType;

@JsonPropertyOrder({
        TileLayerSeed.JSON_PROPERTY_NAME,
        TileLayerSeed.JSON_PROPERTY_BOUNDS,
        TileLayerSeed.JSON_PROPERTY_GRIDSET_ID,
        TileLayerSeed.JSON_PROPERTY_ZOOM_START,
        TileLayerSeed.JSON_PROPERTY_ZOOM_STOP,
        TileLayerSeed.JSON_PROPERTY_SEED_TYPE,
        TileLayerSeed.JSON_PROPERTY_THREAD_COUNT
})
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TileLayerSeed {
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_BOUNDS = "bounds";
    public static final String JSON_PROPERTY_GRIDSET_ID = "gridSetId";
    public static final String JSON_PROPERTY_ZOOM_START = "zoomStart";
    public static final String JSON_PROPERTY_ZOOM_STOP = "zoomStop";
    public static final String JSON_PROPERTY_SEED_TYPE = "type";
    public static final String JSON_PROPERTY_THREAD_COUNT = "threadCount";
    public static final String JSON_PROPERTY_MIME_FORMAT = "mimeFormat";

    /**
     * 图层名
     */
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String layerName;

    /**
     * 边界
     */
    @JsonProperty(JSON_PROPERTY_BOUNDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private BoundingBox bounds;

    /**
     * 网格集
     */
    @JsonProperty(JSON_PROPERTY_GRIDSET_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String gridSetId;

    /**
     * 开始缩放级别
     */
    @JsonProperty(JSON_PROPERTY_ZOOM_START)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer zoomStart;

    /**
     * 结束缩放级别
     */
    @JsonProperty(JSON_PROPERTY_ZOOM_STOP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer zoomStop;

    /**
     * 执行类型
     */
    @JsonProperty(JSON_PROPERTY_SEED_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private TileSeedType seedType;

    /**
     * 执行线程数
     */
    @JsonProperty(JSON_PROPERTY_THREAD_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer threadCount;

    @JsonProperty(JSON_PROPERTY_MIME_FORMAT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String mimeFormat;

    /**
     * 设置级别
     * @param zoomStart
     * @param zoomStop
     */
    public void setZoom(Integer zoomStart, Integer zoomStop) {
        this.zoomStart = zoomStart;
        this.zoomStop = zoomStop;
    }
}
