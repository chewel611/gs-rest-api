package org.geoserver.openapi.primitive;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@JsonPropertyOrder({
        StringList.JSON_PROPERTY_VALUES,
})
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class StringList extends Primitive<String> {
    public static final String JSON_PROPERTY_VALUES = "string";

    @JsonProperty(JSON_PROPERTY_VALUES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getValues() {
        return values;
    }
}
