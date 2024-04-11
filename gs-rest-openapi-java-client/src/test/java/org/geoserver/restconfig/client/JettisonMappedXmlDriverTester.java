package org.geoserver.restconfig.client;

import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.copy.HierarchicalStreamCopier;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringWriter;

public class JettisonMappedXmlDriverTester {
    @Test
    public void testCreateReader() {
        HierarchicalStreamDriver driver = new JettisonMappedXmlDriver();
        HierarchicalStreamReader hsr = driver.createReader(createInputStream());
        StringWriter writer = new StringWriter();
        new HierarchicalStreamCopier().copy(hsr, new PrettyPrintWriter(writer));
        System.out.println(writer.toString());
    }

    public InputStream createInputStream() {
        String body = "{\"featureType\":{\"name\":\"states\",\"nativeName\":\"states\",\"namespace\":{\"prefix\":\"topp\",\"uri\":\"http://127.0.0.1:8080/geoserver/rest/namespaces/topp.json\"},\"title\":\"USA Population\",\"abstract\":\"This is some census data on the states.\",\"enabled\":true,\"keywords\":[{\"value\":\"census\"},{\"value\":\"united\"},{\"value\":\"boundaries\"},{\"value\":\"state\"},{\"value\":\"states\"}],\"latLonBoundingBox\":{\"minx\":-124.731422,\"maxx\":-66.969849,\"miny\":24.955967,\"maxy\":49.371735,\"crs\":\"EPSG:4326\"},\"nativeBoundingBox\":{\"minx\":-124.73142200000001,\"maxx\":-66.969849,\"miny\":24.955967,\"maxy\":49.371735,\"crs\":\"EPSG:4326\"},\"metadata\":{\"entry\":[{\"@key\":\"kml.regionateFeatureLimit\",\"$\":\"10\"},{\"@key\":\"cacheAgeMax\",\"$\":\"3600\"},{\"@key\":\"cachingEnabled\",\"$\":\"true\"},{\"@key\":\"indexingEnabled\",\"$\":\"false\"},{\"@key\":\"dirName\",\"$\":\"states\"}]},\"nativeCRS\":\"GEOGCS[\\\"GCS_WGS_1984\\\", \\n  DATUM[\\\"WGS_1984\\\", \\n    SPHEROID[\\\"WGS_1984\\\", 6378137.0, 298.257223563]], \\n  PRIMEM[\\\"Greenwich\\\", 0.0], \\n  UNIT[\\\"degree\\\", 0.017453292519943295], \\n  AXIS[\\\"Longitude\\\", EAST], \\n  AXIS[\\\"Latitude\\\", NORTH]]\",\"srs\":\"EPSG:4326\",\"projectionPolicy\":\"FORCE_DECLARED\",\"serviceConfiguration\":false,\"store\":{\"name\":\"states_shapefile\",\"enabled\":true,\"workspace\":{\"name\":\"topp\"}},\"maxFeatures\":0,\"numDecimals\":0,\"padWithZeros\":false,\"forcedDecimal\":false,\"overridingServiceSRS\":false,\"skipNumberMatched\":false,\"circularArcPresent\":false,\"attributes\":[{\"name\":\"the_geom\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"org.locationtech.jts.geom.MultiPolygon\"},{\"name\":\"STATE_NAME\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.String\",\"length\":25},{\"name\":\"STATE_FIPS\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.String\",\"length\":2},{\"name\":\"SUB_REGION\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.String\",\"length\":7},{\"name\":\"STATE_ABBR\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.String\",\"length\":2},{\"name\":\"LAND_KM\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"WATER_KM\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"PERSONS\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"FAMILIES\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"HOUSHOLD\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"MALE\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"FEMALE\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"WORKERS\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"DRVALONE\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"CARPOOL\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"PUBTRANS\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"EMPLOYED\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"UNEMPLOY\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"SERVICE\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"MANUAL\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"P_MALE\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"P_FEMALE\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19},{\"name\":\"SAMP_POP\",\"minOccurs\":0,\"maxOccurs\":1,\"nillable\":true,\"binding\":\"java.lang.Double\",\"length\":19}]}}";
        return new ByteArrayInputStream(body.getBytes());
    }
}
