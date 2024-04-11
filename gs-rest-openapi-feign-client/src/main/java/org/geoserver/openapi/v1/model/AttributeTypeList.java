package org.geoserver.openapi.v1.model;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geoserver.openapi.model.catalog.AttributeTypeInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@JsonPropertyOrder({
        AttributeTypeList.JSON_PROPERTY_ATTRIBUTES
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeTypeList {
    public static final String JSON_PROPERTY_ATTRIBUTES = "attribute";

    @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private List<AttributeTypeInfo> attribute;

    /**
     * 添加属性
     * @param attributeTypeInfos
     */
    public void addAttributes(AttributeTypeInfo... attributeTypeInfos) {
        if(CollUtil.isEmpty(attribute)) {
            attribute = new ArrayList<>();
        }
        attribute.addAll(Arrays.asList(attributeTypeInfos));
    }
}
