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
        String body = "{\"seedRequest\":{\"name\":\"tiger:giant_polygon\",\"bounds\":{\"coords\":{\"double\":[-180.0,-90.0,180.0,90.0]}},\"gridSetId\":\"EPSG:4326\",\"zoomStart\":1,\"zoomStop\":10,\"type\":\"SEED\",\"threadCount\":4}}";
        return new ByteArrayInputStream(body.getBytes());
    }
}
