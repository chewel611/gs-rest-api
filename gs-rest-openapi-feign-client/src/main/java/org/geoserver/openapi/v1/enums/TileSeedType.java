package org.geoserver.openapi.v1.enums;

import cn.hutool.core.util.ObjUtil;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TileSeedType {
    /**
     * 切片
     */
    SEED,
    /**
     * 重新切片
     */
    RESEED,
    /**
     * 清除切片
     */
    TRUNCATE
    ;

    public static TileSeedType of(String value) {
        return Arrays.stream(values())
                .filter(v -> v.name().equalsIgnoreCase(value)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("无效的状态：" + value));
    }
}
