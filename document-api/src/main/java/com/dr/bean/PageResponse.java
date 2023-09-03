package com.dr.bean;

/**
 * @description: 分页返回
 * @author: whq
 * @date 2022-12-4 10:31:07
 */
public class PageResponse<T> extends Response<T> {

    // 数量
    private Long count;

    public PageResponse(String code, String msg, T data, Long count) {
        super(code, msg, data);
        this.count = count;
    }

    public static <T> PageResponse<T> ok(T data, Long count) {
        return new PageResponse<>("200", "", data, count);
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
