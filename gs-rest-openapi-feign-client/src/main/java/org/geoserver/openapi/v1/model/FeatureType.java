package org.geoserver.openapi.v1.model;

import cn.hutool.core.util.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.geoserver.openapi.model.catalog.MetadataEntry;
import org.geoserver.openapi.model.catalog.MetadataLinkInfo;
import org.geoserver.openapi.model.catalog.MetadataList;
import org.geoserver.openapi.v1.enums.LayerServiceType;


@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FeatureType extends FeatureTypeResponse {

    public void addDisabledServices(LayerServiceType... disabledServices) {
        if(ObjectUtil.isEmpty(this.getDisabledServices())) {
            this.setDisabledServices(new StringArrayResponse());
        }
        for (LayerServiceType disabledService : disabledServices) {
            this.getDisabledServices().addItem(disabledService.name());
        }
    }

    public void addResponseSRS(String... responseSRS) {
        if(ObjectUtil.isEmpty(this.getResponseSRS())){
            this.setResponseSRS(new StringArrayResponse());
        }
        for (String item : responseSRS) {
            this.getResponseSRS().addItem(item);
        }
    }

    public void addMetadataLinks(MetadataLinkInfo... metadataLinks) {
        if(ObjectUtil.isEmpty(this.getMetadataLinks())){
            this.setMetadataLinks(new org.geoserver.openapi.v1.model.MetadataLinks());
        }
        for (MetadataLinkInfo metadataLinkInfo : metadataLinks) {
            this.getMetadataLinks().addMetadataLinkItem(metadataLinkInfo);
        }
    }

//    public void addDataLinks(MetadataLinkInfo... dataLinks) {
//        if(ObjectUtil.isEmpty(this.dataLinks)){
//            this.dataLinks = new MetadataLinks();
//        }
//        for (MetadataLinkInfo metadataLinkInfo : dataLinks) {
//            this.dataLinks.addMetadataLinkItem(metadataLinkInfo);
//        }
//    }

    public void addMetadata(MetadataEntry... metadatas) {
        if(ObjectUtil.isEmpty(this.getMetadata())){
            this.setMetadata(new MetadataList());
        }
        for (MetadataEntry metadataEntry : metadatas) {
            this.getMetadata().addEntryItem(metadataEntry);
        }
    }

    public void setLatLonBoundingBox(Double minx,Double miny, Double maxx,Double maxy, String crs) {
        if (ObjectUtil.isEmpty(getLatLonBoundingBox())) {
            setLatLonBoundingBox(new EnvelopeResponse());
        }
        getLatLonBoundingBox().setMinx(minx);
        getLatLonBoundingBox().setMiny(miny);
        getLatLonBoundingBox().setMaxx(maxx);
        getLatLonBoundingBox().setMaxy(maxy);
        getLatLonBoundingBox().setCrs(crs);
    }

    public void setNativeBoundingBox(Double minx,Double miny, Double maxx,Double maxy, String crs) {
        if(ObjectUtil.isEmpty(getNativeBoundingBox())) {
            setNativeBoundingBox(new EnvelopeResponse());
        }
        getNativeBoundingBox().setMinx(minx);
        getNativeBoundingBox().setMiny(miny);
        getNativeBoundingBox().setMaxx(maxx);
        getNativeBoundingBox().setMaxy(maxy);
        getNativeBoundingBox().setCrs(crs);
    }
}


