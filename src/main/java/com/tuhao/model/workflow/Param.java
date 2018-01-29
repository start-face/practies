package com.tuhao.model.workflow;

import com.google.common.base.MoreObjects;
import pro.tools.data.text.ToolJson;

/**
 * @author SeanDragon
 * <p>
 * Create By 2017-08-07 9:36
 */
public class Param implements java.io.Serializable {
    private String key;
    private String value;

    public Param() {
    }

    public Param(String key, Object value) {
        this.key = key;
        this.value = ToolJson.anyToJson(value);
    }

    public String getKey() {
        return key;
    }

    public Param setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Param setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("value", value)
                .toString();
    }
}
