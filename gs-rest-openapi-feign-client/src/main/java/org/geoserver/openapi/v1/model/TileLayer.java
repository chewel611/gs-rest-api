package org.geoserver.openapi.v1.model;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        TileLayerInfo.JSON_PROPERTY_ID,
        TileLayerInfo.JSON_PROPERTY_NAME,
        TileLayerInfo.JSON_PROPERTY_GUTTER,
        TileLayerInfo.JSON_PROPERTY_ENABLED,
        TileLayerInfo.JSON_PROPERTY_EXPIRE_CACHE,
        TileLayerInfo.JSON_PROPERTY_MIME_FORMATS,
        TileLayerInfo.JSON_PROPERTY_IN_MEMORY_CACHED,
        TileLayerInfo.JSON_PROPERTY_META_WIDTH_HEIGHT,
        TileLayerInfo.JSON_PROPERTY_EXPIRE_CLIENTS,
        TileLayerInfo.JSON_PROPERTY_GRID_SUBSETS
})
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TileLayer {
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_GUTTER = "gutter";
    public static final String JSON_PROPERTY_ENABLED = "enabled";
    public static final String JSON_PROPERTY_EXPIRE_CACHE = "expireCache";
    public static final String JSON_PROPERTY_MIME_FORMATS = "mimeFormats";
    public static final String JSON_PROPERTY_IN_MEMORY_CACHED = "inMemoryCached";
    public static final String JSON_PROPERTY_META_WIDTH_HEIGHT = "metaWidthHeight";
    public static final String JSON_PROPERTY_EXPIRE_CLIENTS = "expireClients";
    public static final String JSON_PROPERTY_GRID_SUBSETS = "gridSubsets";

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String id;

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String layerName;

    @JsonProperty(JSON_PROPERTY_GUTTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer gutter;

    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Boolean enabled;

    @JsonProperty(JSON_PROPERTY_EXPIRE_CACHE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer expireCache;

    @JsonProperty(JSON_PROPERTY_MIME_FORMATS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private StringArrayResponse mimeFormats;

    @JsonProperty(JSON_PROPERTY_IN_MEMORY_CACHED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Boolean inMemoryCached;

    @JsonProperty(JSON_PROPERTY_META_WIDTH_HEIGHT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private IntegerArrayResponse metaWidthHeight;

    @JsonProperty(JSON_PROPERTY_EXPIRE_CLIENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer expireClients;

    @JsonProperty(JSON_PROPERTY_GRID_SUBSETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private GridSubSetList gridSubSets;

    public void setMetaWidthHeight(Integer width, Integer height) {
        if(ObjUtil.isNull(metaWidthHeight)) {
            metaWidthHeight = new IntegerArrayResponse();
        }
        metaWidthHeight.clear();
        metaWidthHeight.addItem(width);
        metaWidthHeight.addItem(height);
    }

    public void addMimeFormat(String... mimeFormats) {
        if(ObjUtil.isEmpty(this.mimeFormats)) {
            this.mimeFormats = new StringArrayResponse();
        }
        for (String mimeFormat : mimeFormats) {
            this.mimeFormats.addItem(mimeFormat);
        }
    }


    public void addGridSubSet(GridSubSet... gridSubSets) {
        if(ArrayUtil.isEmpty(gridSubSets)) {
            return;
        }
        if(ObjectUtil.isNull(this.gridSubSets)) {
            this.gridSubSets = new GridSubSetList();
        }
        for (GridSubSet gridSubSet : gridSubSets) {
            this.gridSubSets.addGridSubSet(gridSubSet);
        }
    }
}
