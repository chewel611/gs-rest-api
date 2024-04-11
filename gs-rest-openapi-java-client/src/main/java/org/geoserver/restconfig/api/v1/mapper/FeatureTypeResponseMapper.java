package org.geoserver.restconfig.api.v1.mapper;

import org.geoserver.openapi.model.catalog.DataStoreInfo;
import org.geoserver.openapi.model.catalog.FeatureTypeInfo;
import org.geoserver.openapi.model.catalog.WorkspaceInfo;
import org.geoserver.openapi.v1.model.FeatureType;
import org.geoserver.openapi.v1.model.FeatureTypeResponse;
import org.geoserver.openapi.v1.model.NamedLink;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Map;

@Mapper
public interface FeatureTypeResponseMapper extends ResourceResponseMapper {

    @Mapping(source = "attributes.attribute", target = "attributes")
    FeatureTypeInfo map(FeatureTypeResponse source);

    default DataStoreInfo namedLinkToDataStoreInfo(NamedLink namedLink) {
        if (namedLink == null) {
            return null;
        }

        DataStoreInfo store = new DataStoreInfo();
        String prefixedName = namedLink.getName();
        int i = prefixedName.indexOf(":");
        if (-1 == i) {
            store.setName(prefixedName);
        } else {
            String workspace = prefixedName.substring(0, i);
            String name = prefixedName.substring(i + 1);
            store.setName(name);
            store.setWorkspace(new WorkspaceInfo().name(workspace));
        }
        return store;
    }

    @Mapping(source = "attributes", target = "attributes.attribute")
    @Mapping(
            target = "nativeBoundingBox.crs",
            expression = "java(envelopeInfo.getCrs())"
    )
    @Mapping(
            target = "latLonBoundingBox.crs",
            expression = "java(envelopeInfo.getCrs())"
    )
    @Mapping(
            target = "nativeCRS",
            expression = "java(info.getNativeCRS())"
    )
    FeatureType map(FeatureTypeInfo info);

}
