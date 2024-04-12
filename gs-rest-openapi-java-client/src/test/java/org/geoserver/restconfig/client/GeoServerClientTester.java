package org.geoserver.restconfig.client;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import org.geoserver.openapi.model.catalog.FeatureTypeInfo;
import org.geoserver.openapi.v1.constants.GSCommonConstants;
import org.geoserver.openapi.v1.enums.LayerServiceType;
import org.geoserver.openapi.v1.enums.TileSeedType;
import org.geoserver.openapi.v1.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GeoServerClientTester {
    private static final String ENDPOINTS = "http://127.0.0.1:8080/geoserver";
    GeoServerClient geoServerClient = new GeoServerClient(ENDPOINTS).setBasicAuth("admin", "NDpUFl0zS9GV");

    @Test
    public void testReset() {
        geoServerClient.reset();
    }

    @Test
    public void testReload() {
        geoServerClient.reload();
    }

    @Test
    public void testCreateFeatureType() {
        Optional<FeatureTypeInfo> featureType = geoServerClient.featureTypes().getFeatureType("topp", "states_shapefile", "states");
        Assert.assertNotNull(featureType);
        System.out.println(featureType);
        FeatureTypeInfo featureTypeInfo = featureType.get();
        featureTypeInfo.setOverridingServiceSRS(true);
        featureTypeInfo.setServiceConfiguration(true);
        featureTypeInfo.addDisabledServicesItem(LayerServiceType.CSW.name());
        featureTypeInfo.addDisabledServicesItem(LayerServiceType.WPS.name());

        featureTypeInfo.addResponseSRSItem("4326");
        featureTypeInfo.addResponseSRSItem("3857");

        geoServerClient.featureTypes().update("topp", featureTypeInfo.getName(), featureTypeInfo);
    }

    @Test
    public void testListResources() {
        ResourceFile resourceFile = geoServerClient.resources().listResources("user_projections");
        Assert.assertNotNull(resourceFile);
        System.out.println(resourceFile);
    }

    @Test
    public void testGetResourceMetadata() {
        ResourceFileMetadata metadata = geoServerClient.resources().getMetadata("");
        Assert.assertNotNull(metadata);
        Assert.assertTrue(metadata.isDirectory());
        System.out.println(metadata);
    }

    @SneakyThrows
    @Test
    public void testUploadResource() {
        InputStream inputStream = Files.newInputStream(Paths.get("E:\\services\\geoserver\\epsg.properties"));
        geoServerClient.resources().upload("user_projections/epsg.properties", inputStream);
    }

    @Test
    public void testDownloadResource() {
        byte[] bytes = geoServerClient.resources().download("user_projections/epsg.properties");
        Assert.assertNotNull(bytes);
        String content = StrUtil.str(bytes, StandardCharsets.UTF_8);
        System.out.println(content);
    }

    @Test
    public void testGetCRSs() {
        Map<Integer, CRS> crSs = geoServerClient.CRS().getList();
        Assert.assertNotNull(crSs);
        System.out.println(crSs);
    }

    @Test
    public void testRemoveCRS() {
        CRS crs = new CRS(350200, "PROJCS[\"xm92_B\",GEOGCS[\"GCS_Beijing_1954\",DATUM[\"D_Beijing_1954\",SPHEROID[\"Krasovsky_1940\",6378245.0,298.3]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],PROJECTION[\"Gauss_Kruger\"],PARAMETER[\"False_Easting\",500000.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"Central_Meridian\",118.5],PARAMETER[\"Scale_Factor\",1.0],PARAMETER[\"Latitude_Of_Origin\",0.0],UNIT[\"Meter\",1.0]]");
        geoServerClient.CRS().remove(ListUtil.of(crs));

        Map<Integer, CRS> crSs = geoServerClient.CRS().getList();
        Assert.assertFalse(crSs.containsKey(crs.getCode()));
    }

    @Test
    public void testSaveCRS() {
        CRS crs = new CRS(350200, "PROJCS[\"xm92_B\",GEOGCS[\"GCS_Beijing_1954\",DATUM[\"D_Beijing_1954\",SPHEROID[\"Krasovsky_1940\",6378245.0,298.3]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],PROJECTION[\"Gauss_Kruger\"],PARAMETER[\"False_Easting\",500000.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"Central_Meridian\",118.5],PARAMETER[\"Scale_Factor\",1.0],PARAMETER[\"Latitude_Of_Origin\",0.0],UNIT[\"Meter\",1.0]]");

        geoServerClient.CRS().createOrSave(ListUtil.of(crs));
        Map<Integer, CRS> crSs = geoServerClient.CRS().getList();
        Assert.assertTrue(crSs.containsKey(crs.getCode()));
    }


    @Test
    public void testGetGridSets() {
        Set<String> gridSets = geoServerClient.gridsets().getList();
        Assert.assertNotNull(gridSets);
        System.out.println(gridSets);
    }

    @Test
    public void testGetGridSet() {
        GridSetInfo test01 = geoServerClient.gridsets().get("TEST_01");
        Assert.assertNotNull(test01);
        System.out.println(test01);
    }

    @Test
    public void testExistsGridSet() {
        boolean test02 = geoServerClient.gridsets().exists("TEST_02");
        Assert.assertTrue(test02);

        boolean test03 = geoServerClient.gridsets().exists("TEST_03");
        Assert.assertFalse(test03);
    }

    @Test
    public void testDeleteGridSet() {
        geoServerClient.gridsets().delete("TEST_02");
        GridSetInfo test02 = geoServerClient.gridsets().get("TEST_02");
        Assert.assertNull(test02);
    }

    @Test
    public void testSaveGridSet() {
        GridSet gridSetInfo = new GridSet();
        gridSetInfo.setName("XM350200");
        gridSetInfo.setDescription("this is test gridset");
        gridSetInfo.setTileHeight(256);
        gridSetInfo.setTileWidth(256);
        gridSetInfo.setMetersPerUnit(1D);
        gridSetInfo.setYCoordinateFirst(false);
        gridSetInfo.setOriginalExtent(new BoundingBox(-2935181.88, -2935181.88, 2935181.88, 2935181.88));
        gridSetInfo.addScaleDenominator("L1", 559082264.028717);
        gridSetInfo.addScaleDenominator("L2", 279541132.014358);
        gridSetInfo.addScaleDenominator("L3", 139770566.007179);
        gridSetInfo.addScaleDenominator("L4", 69885283.0035897);
        gridSetInfo.addScaleDenominator("L5", 34942641.5017948);
        gridSetInfo.addScaleDenominator("L6", 17471320.7508974);
        gridSetInfo.addScaleDenominator("L7", 8735660.37544871);
        gridSetInfo.addScaleDenominator("L8", 4367830.18772435);
        gridSetInfo.addScaleDenominator("L9", 2183915.09386217);
        gridSetInfo.addScaleDenominator("L10", 1091957.54693108);
        gridSetInfo.addScaleDenominator("L11", 545978.773465544);
        gridSetInfo.addScaleDenominator("L12", 272989.386732772);
        gridSetInfo.addScaleDenominator("L13", 136494.693366386);
        gridSetInfo.addScaleDenominator("L14", 68247.346683193);
        gridSetInfo.addScaleDenominator("L15", 34123.6733415964);
        gridSetInfo.addScaleDenominator("L16", 17061.8366707982);
        gridSetInfo.addScaleDenominator("L17", 8530.91833539913);
        gridSetInfo.addScaleDenominator("L18", 4265.45916769956);
        gridSetInfo.addScaleDenominator("L19", 2132.72958384978);
        gridSetInfo.addScaleDenominator("L20", 1066.36479192489);
        gridSetInfo.addScaleDenominator("L21", 533.182395962445);
        gridSetInfo.addScaleDenominator("L22", 266.591197981222);
        gridSetInfo.addScaleDenominator("L23", 133.295598990611);
        gridSetInfo.addScaleDenominator("L24", 66.6477994953056);
        gridSetInfo.addScaleDenominator("L25", 33.3238997476528);
        gridSetInfo.setSrs(new SRS(350200, null));

        geoServerClient.gridsets().createOrSave(gridSetInfo);
    }

    @Test
    public void testGetTileLayers() {
        List<NamedLink> list = geoServerClient.tileLayers().getList();
        Assert.assertNotNull(list);
        System.out.println(list);
    }

    @Test
    public void testGetTileLayer() {
        TileLayerInfo ne = geoServerClient.tileLayers().get("ne:ne");
        Assert.assertNull(ne);

        TileLayerInfo tileLayerInfo = geoServerClient.tileLayers().get("tiger:poi");
        Assert.assertNotNull(tileLayerInfo);
        System.out.println(tileLayerInfo);
    }

    @Test
    public void testCreateOrUpdateTileLayer() {
        TileLayer tileLayer = new TileLayer();
        tileLayer.setLayerName("topp:states");
        tileLayer.setEnabled(true);
        tileLayer.addMimeFormat(GSCommonConstants.MAPBOX_VECTOR_TILE);
        tileLayer.setMetaWidthHeight(4, 4);
        tileLayer.addGridSubSet(new GridSubSet("EPSG:4326", 1, 15, new BoundingBox(-124.73142200000001,24.955967,-66.969849,49.371735)));
        tileLayer.setInMemoryCached(true);
        geoServerClient.tileLayers().createOrUpdate(tileLayer);
    }

    @Test
    public void testRemoveTileLayer() {
        geoServerClient.tileLayers().remove("topp:states");
    }

    @Test
    public void testSeedTileLayer() {
        TileLayerSeed tileLayerSeed = new TileLayerSeed();
        tileLayerSeed.setLayerName("topp:states");
        tileLayerSeed.setSeedType(TileSeedType.SEED);
        tileLayerSeed.setZoomStart(1);
        tileLayerSeed.setZoomStop(8);
        tileLayerSeed.setThreadCount(2);
        tileLayerSeed.setGridSetId("EPSG:4326");
        tileLayerSeed.setBounds(new BoundingBox(-124.73142200000001,24.955967,-66.969849,49.371735));
        tileLayerSeed.setMimeFormat(GSCommonConstants.MAPBOX_VECTOR_TILE);
        geoServerClient.tileLayers().seed(tileLayerSeed);
    }

    @Test
    public void testTruncateTileLayer() {
        geoServerClient.tileLayers().truncate("topp:states");
    }
}
