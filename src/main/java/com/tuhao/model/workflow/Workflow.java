//package com.tuhao.model.workflow;
//
//import com.google.common.base.MoreObjects;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @author SeanDragon
// * <p>
// * Create By 2017-08-07 9:34
// */
//@Collection(name = "workflow")
//public class Workflow implements java.io.Serializable {
//    private Long id;
//    private String name;
//    private Integer workflowType;
//    private List<Node> nodeLinkedList;
//    private Boolean haveError;
//    private String errMsg;
//    private Date execDate;
//
//    public Long getId() {
//        return id;
//    }
//
//    public Workflow setId(Long id) {
//        this.id = id;
//        return this;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Workflow setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public List<Node> getNodeLinkedList() {
//        return nodeLinkedList;
//    }
//
//    public Workflow setNodeLinkedList(List<Node> nodeLinkedList) {
//        this.nodeLinkedList = nodeLinkedList;
//        return this;
//    }
//
//    public Boolean getHaveError() {
//        return haveError;
//    }
//
//    public Workflow setHaveError(Boolean haveError) {
//        this.haveError = haveError;
//        return this;
//    }
//
//    public String getErrMsg() {
//        return errMsg;
//    }
//
//    public Workflow setErrMsg(String errMsg) {
//        this.errMsg = errMsg;
//        return this;
//    }
//
//    public Date getExecDate() {
//        return execDate;
//    }
//
//    public Workflow setExecDate(Date execDate) {
//        this.execDate = execDate;
//        return this;
//    }
//
//    public Integer getWorkflowType() {
//        return workflowType;
//    }
//
//    public Workflow setWorkflowType(Integer workflowType) {
//        this.workflowType = workflowType;
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return MoreObjects.toStringHelper(this)
//                .add("id", id)
//                .add("name", name)
//                .add("nodeLinkedList", nodeLinkedList)
//                .add("haveError", haveError)
//                .add("errMsg", errMsg)
//                .add("execDate", execDate)
//                .add("workflowType", workflowType)
//                .toString();
//    }
//}
