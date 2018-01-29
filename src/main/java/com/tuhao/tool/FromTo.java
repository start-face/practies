package com.tuhao.tool;

import com.google.common.base.MoreObjects;

/**
 * @author SeanDragon
 *         Create By 2017-05-04 17:39
 */
public class FromTo {
    private String field;
    private String from;
    private String fromPattern;
    private String to;
    private String toPattern;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("field", field)
                .add("from", from)
                .add("fromPattern", fromPattern)
                .add("to", to)
                .add("toPattern", toPattern)
                .toString();
    }

    public String getField() {
        return field;
    }

    public FromTo setField(String field) {
        this.field = field;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public FromTo setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getFromPattern() {
        return fromPattern;
    }

    public FromTo setFromPattern(String fromPattern) {
        this.fromPattern = fromPattern;
        return this;
    }

    public String getTo() {
        return to;
    }

    public FromTo setTo(String to) {
        this.to = to;
        return this;
    }

    public String getToPattern() {
        return toPattern;
    }

    public FromTo setToPattern(String toPattern) {
        this.toPattern = toPattern;
        return this;
    }
}
