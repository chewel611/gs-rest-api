package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@JsonPropertyOrder({
        SRS.JSON_PROPERTY_NUMBER,
        SRS.JSON_PROPERTY_ALIASES
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SRS {
    public static final String JSON_PROPERTY_NUMBER = "number";
    public static final String JSON_PROPERTY_ALIASES = "aliases";

    @JsonProperty(JSON_PROPERTY_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private Integer number;

    @JsonProperty(JSON_PROPERTY_ALIASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private transient List<Integer> aliases;
}
