package cn.iocoder.yudao.module.top.product.enums;// TODO 待办：请将下面的错误码复制到 yudao-module-t-api 模块的 ErrorCodeConstants 类中。注意，请给“TODO 补充编号”设置一个错误码编号！！！
// ========== 商品信息 TODO 补充编号 ==========


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public class ErrorCodeConstants {
    public static final ErrorCode PRODUCT_NOT_EXISTS = new ErrorCode(500, "商品信息不存在");

    public static final ErrorCode PRODUCT_IMG_NOT_EXISTS = new ErrorCode(500, "商品图片不存在");
}