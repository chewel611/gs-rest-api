package org.geoserver.openapi.v1.model;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        GridSetInfo.JSON_PROPERTY_NAME,
        GridSetInfo.JSON_PROPERTY_SRS,
        GridSetInfo.JSON_PROPERTY_EXTENT,
        GridSetInfo.JSON_PROPERTY_PIXEL_SIZE,
        GridSetInfo.JSON_PROPERTY_TILE_WIDTH,
        GridSetInfo.JSON_PROPERTY_TILE_HEIGHT,
        GridSetInfo.JSON_PROPERTY_RESOLUTIONS,
        GridSetInfo.JSON_PROPERTY_DESCRIPTION,
        GridSetInfo.JSON_PROPERTY_SCALE_NAMES,
        GridSetInfo.JSON_PROPERTY_METERS_PER_UNIT,
        GridSetInfo.JSON_PROPERTY_Y_COORDINATE_FIRST,
        GridSetInfo.JSON_PROPERTY_SCALE_DENOMINATORS,
})
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GridSet {
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_SRS = "srs";
    public static final String JSON_PROPERTY_EXTENT = "extent";
    public static final String JSON_PROPERTY_PIXEL_SIZE = "pixelSize";
    public static final String JSON_PROPERTY_TILE_WIDTH = "tileWidth";
    public static final String JSON_PROPERTY_TILE_HEIGHT = "tileHeight";
    public static final String JSON_PROPERTY_RESOLUTIONS = "resolutions";
    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    public static final String JSON_PROPERTY_SCALE_NAMES = "scaleNames";
    public static final String JSON_PROPERTY_METERS_PER_UNIT = "metersPerUnit";
    public static final String JSON_PROPERTY_Y_COORDINATE_FIRST = "yCoordinateFirst";
    public static final String JSON_PROPERTY_SCALE_DENOMINATORS = "scaleDenominators";

    /**
     * 网格集名称
     */
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String name;

    /**
     * 网格集的参考系统
     */
    @JsonProperty(JSON_PROPERTY_SRS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private SRS srs;

    /**
     * 切片宽度（以像素为单位）
     */
    @JsonProperty(JSON_PROPERTY_TILE_WIDTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer tileWidth;

    /**
     * 切片g高度（以像素为单位）
     */
    @JsonProperty(JSON_PROPERTY_TILE_HEIGHT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer tileHeight;

    /**
     * 是否将y坐标作为第一个维度
     */
    @JsonProperty(JSON_PROPERTY_Y_COORDINATE_FIRST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Boolean yCoordinateFirst = false;

    /**
     * 每坐标单位的米数
     */
    @JsonProperty(JSON_PROPERTY_METERS_PER_UNIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Double metersPerUnit;

    /**
     * 像素大小，以米为单位
     */
    @JsonProperty(JSON_PROPERTY_PIXEL_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Double pixelSize;

    /**
     * 网格集范围
     */
    @JsonProperty(JSON_PROPERTY_EXTENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private BoundingBox originalExtent;

    /**
     * 分辨率
     */
    @JsonProperty(JSON_PROPERTY_RESOLUTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private DoubleArrayResponse resolutions;

    /**
     *  缩放比例
     */
    @JsonProperty(JSON_PROPERTY_SCALE_DENOMINATORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private DoubleArrayResponse scaleDenominators;

    /**
     * 网格名称列表，必须根分辨率或者比例对应上
     */
    @JsonProperty(JSON_PROPERTY_SCALE_NAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private StringArrayResponse scaleNames = new StringArrayResponse();

    /**
     * 网格集的描述
     */
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String description;

    /**
     * 添加分辨率
     * @param name
     * @param resolution
     */
    public void addResolution(String name, double resolution) {
        if(ObjUtil.isNotNull(scaleDenominators)) {
            throw new IllegalArgumentException("scaleDenominators has been set, can't set resolutions");
        }
        if(CollUtil.contains(scaleNames.getValues(), name)) {
            throw new IllegalArgumentException("scale name has been exists, can't add same scale name");
        }
        if(ObjUtil.isNull(resolutions)) {
            resolutions = new DoubleArrayResponse();
        }
        scaleNames.addItem(name);
        resolutions.addItem(resolution);
    }

    /**
     * 添加比例
     * @param name
     * @param scaleDenominator
     */
    public void addScaleDenominator(String name, double scaleDenominator) {
        if(ObjectUtil.isNotNull(resolutions)) {
            throw new IllegalArgumentException("resolutions has been set, can't set scaleDenominators");
        }
        if(CollUtil.contains(scaleNames.getValues(), name)) {
            throw new IllegalArgumentException("scale name has been exists, can't add same scale name");
        }
        if(ObjectUtil.isNull(scaleDenominators)) {
            scaleDenominators = new DoubleArrayResponse();
        }
        scaleNames.addItem(name);
        scaleDenominators.addItem(scaleDenominator);
    }
}
