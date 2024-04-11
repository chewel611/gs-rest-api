package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonPropertyOrder({
        ResourceFileLink.JSON_PROPERTY_HREF,
        ResourceFileLink.JSON_PROPERTY_REL,
        ResourceFileLink.JSON_PROPERTY_TYPE
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResourceFileLink {
    public static final String JSON_PROPERTY_HREF = "href";
    public static final String JSON_PROPERTY_REL = "rel";
    public static final String JSON_PROPERTY_TYPE = "type";

    @JsonProperty(JSON_PROPERTY_HREF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String href;

    @JsonProperty(JSON_PROPERTY_REL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String rel;

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    private String type;
}
