package org.geoserver.openapi.v1.model;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonPropertyOrder({
        GridSubSetList.JSON_PROPERTY_GRID_SUBSET
})
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GridSubSetList {
    public static final String JSON_PROPERTY_GRID_SUBSET = "gridSubset";

    @JsonProperty(JSON_PROPERTY_GRID_SUBSET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Set<GridSubSet> gridSubSet;

    public GridSubSetList(GridSubSet... gridSubSets) {
        this.gridSubSet = new HashSet<>();
        for (GridSubSet gridSubSet : gridSubSets) {
            this.gridSubSet.add(gridSubSet);
        }
    }

    public void addGridSubSet(GridSubSet gridSubSet) {
        if(CollUtil.isEmpty(this.gridSubSet)) {
            this.gridSubSet = new HashSet<>();
        }
        this.gridSubSet.add(gridSubSet);
    }

    public boolean exists(GridSubSet gridSubSet) {
        if(CollUtil.isNotEmpty(this.gridSubSet)) {
            this.gridSubSet.stream().anyMatch(s->s.getGridSetName().equals(gridSubSet.getGridSetName()));
        }
        return false;
    }
}
