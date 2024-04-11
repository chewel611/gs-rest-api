package org.geoserver.restconfig.client;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.geoserver.openapi.v1.model.CRS;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class CRSClient {
    private @NonNull GeoServerClient client;

    /**
     * 获取坐标列表
     * @return
     */
    @SneakyThrows
    public Map<Integer, CRS> getList() {
        byte[] body = client.resources().download("user_projections/epsg.properties");
        Map<Integer, CRS> map;
        try (
                StringReader reader = new StringReader(StrUtil.str(body, StandardCharsets.UTF_8));
                BufferedReader bufferedReader = new BufferedReader(reader)
        )
        {
            map = bufferedReader.lines().map(CRS::of).collect(Collectors.toMap(k -> k.getCode(), v -> v));
        }
        return map;
    }

    /**
     * 判断坐标是否已经存在
     * @param crs
     * @return
     */
    public boolean exists(Integer code) {
        return getList().containsKey(code);
    }

    /**
     * 保存坐标系
     * @param crs
     */
    public void createOrSave(List<CRS> crsList) {
        Map<Integer, CRS> map = getList();
        crsList.forEach(info -> map.put(info.getCode(),info));
        write(map);
    }

    /**
     * 删除坐标系
     * @param crs
     */
    public void remove(List<CRS> crsList) {
        Map<Integer, CRS> map = getList();
        int size = map.size();
        crsList.forEach(info->{
            if(map.containsKey(info.getCode())) {
                map.remove(info.getCode());
            }
        });
        if(ObjUtil.notEqual(size, map.size())) {
            write(map);
        }
    }

    /**
     * 写入平台
     * @param map
     */
    @SneakyThrows
    private void write(Map<Integer, CRS> map) {
        try(
                StringWriter writer = new StringWriter();
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            map.values().stream().map(CRS::toContent).forEach(s-> {
                try {
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            bufferedWriter.flush();
            writer.flush();

            byte[] body = writer.toString().getBytes(StandardCharsets.UTF_8);
            client.resources().upload("user_projections/epsg.properties", body);
        }
    }
}
