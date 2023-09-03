package com.dr.bean;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.DependsOn;

/**
 * @description: 公共返回
 * @author: whq
 * @date 2022-12-3 15:20:41
 */
@Data
@AllArgsConstructor
@DependsOn
public class Response<T> {
    // 响应码，非0 即为异常"
    private final String code;
    // 响应消息
    private final String msg;
    // 响应数据
    private final T data;
    // 请求结果
    private final Boolean success;

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = StrUtil.equals("200", code);
    }

    public static <T> Response<T> ok(T data) {
        return new Response<>("200", "操作成功", data);
    }

    public static <Void> Response<Void> ok() {
        return new Response<Void>("200", "操作成功", null);
    }

    public static <T> Response<T> error(T data) {
        return new Response<>("400", "", data);
    }

    public static <T> Response<T> error(String code, String msg, T data) {
        return new Response<>(code, msg, data);
    }

    public static <T> Response<T> error(String code, String msg) {
        return new Response<>(code, msg, null);
    }
}
