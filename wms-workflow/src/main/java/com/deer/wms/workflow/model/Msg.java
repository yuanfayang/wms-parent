package com.deer.wms.workflow.model;

import com.deer.wms.project.seed.core.result.CommonCode;

/**
 * Msg
 * 用于操作返回状态
 *
 * @author luxin.yan
 * @date 2018/12/29
 **/
public class Msg<T> {
    public Msg(final String msg, final Boolean sucess) {
        this.message = msg;
        this.success = sucess;
    }


    /**
     * 返回信息
     */
    private String message;
    /**
     * 状态码
     */
    private int code = CommonCode.SUCCESS.getCode();
    private int currentPage;
    private int pageSize;
    private long totalCount;
    /**
     * 操作状态
     */
    private boolean success;
    /**
     * 返回业务内容
     */
    private T data;

    public String getMessage() {
        return message;
    }

    public Msg setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Msg setCode(int code) {
        this.code = code;
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public Msg setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Msg setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public Msg setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Msg setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public Msg setData(T data) {
        this.data = data;
        return this;
    }

    public void setPrototype(int currentPage, int pageSize, long totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
