package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.annotation.Nullable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonPropertyOrder({
    PublishedLink.JSON_PROPERTY_AT_TYPE,
    PublishedLink.JSON_PROPERTY_NAME,
    PublishedLink.JSON_PROPERTY_HREF,
    PublishedLink.JSON_PROPERTY_LINK
})
public class PublishedLink {
    public static final String JSON_PROPERTY_AT_TYPE = "@type";
    private String atType;
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;
    public static final String JSON_PROPERTY_HREF = "href";
    private String href;
    public static final String JSON_PROPERTY_LINK = "link";
    private String link;

    @Nullable
    @JsonProperty(JSON_PROPERTY_AT_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public String getAtType() {
        return this.atType;
    }

    @Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public String getName() {
        return this.name;
    }

    @Nullable
    @JsonProperty(JSON_PROPERTY_HREF)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public String getHref() {
        return this.href;
    }

    @Nullable
    @JsonProperty(JSON_PROPERTY_LINK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getLink() {
        return link;
    }
}
