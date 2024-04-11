package org.geoserver.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonPropertyOrder({
    PublishedLinkList.JSON_PROPERTY_PUBLISHED,
})
public class PublishedLinkList {
    public static final String JSON_PROPERTY_PUBLISHED = "published";

    public List<PublishedLink> published;

    @JsonProperty(JSON_PROPERTY_PUBLISHED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<PublishedLink> getPublished() {
        return this.published;
    }

    public PublishedLinkList addLayersItem(PublishedLink layersItem) {
        if (this.published == null) {
            this.published = new ArrayList<>();
        }
        this.published.add(layersItem);
        return this;
    }

    public PublishedLinkList removeLayersItem(String layerName) {
        if (this.published != null) {
            this.getPublished().removeIf(item -> Objects.equals(item.getName(), layerName));
        }
        return this;
    }
}
