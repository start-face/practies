package com.tuhao.model.workflow;

import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * 业务流用节点
 * @author SeanDragon
 * <p>
 * Create By 2017-08-07 9:35
 */
public class Node implements java.io.Serializable{
    private String name;
    private List<Param> param;//input
    private String result;//output

    public Node () {}

    public Node (String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Node setName(String name) {
        this.name = name;
        return this;
    }

    public List<Param> getParam() {
        return param;
    }

    public Node setParam(List<Param> param) {
        this.param = param;
        return this;
    }

    public String getResult() {
        return result;
    }

    public Node setResult(String result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("param", param)
                .add("result", result)
                .toString();
    }
}
