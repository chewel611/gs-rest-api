package org.geoserver.openapi.v1.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TileSeedType {
    SEED("seed","添加切片"),
    RESEED("reseed", "覆盖切片"),
    TRUNCATE("truncate", "删除切片")
    ;

    @JsonValue
    private final String value;
    private final String desc;

    public static TileSeedType of(String value) {
        return Arrays.stream(values())
                .filter(v -> v.getValue().equals(value)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("无效的状态：" + value));
    }
}
