package org.geoserver.openapi.primitive;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 基元泛型类型
 * @param <T>
 */
@Data
public abstract class Primitive<T extends Serializable> {
    protected List<T> values = new ArrayList<>();

    /**
     * 判断是否为空
     * @return
     */
    public boolean empty() {
        return CollUtil.isEmpty(values);
    }

    /**
     * 判断是否存在
     * @param value
     * @return
     */
    public boolean exists(T value) {
        if(CollUtil.isEmpty(values)) {
            return false;
        }
        return values.contains(value);
    }

    /**
     * 新增
     * @param value
     */
    public void add(T value) {
        if(CollUtil.isEmpty(values)) {
            values = new ArrayList<>();
        }
        values.add(value);
    }

    /**
     * 清空
     */
    public void clear() {
        if(ObjUtil.isNotNull(values)) {
            values.clear();
        }
    }
}
