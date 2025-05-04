package cn.iocoder.yudao.module.system.enums.yunExpress;// TODO 待办：请将下面的错误码复制到 yudao-module-saas-api 模块的 ErrorCodeConstants 类中。注意，请给“TODO 补充编号”设置一个错误码编号！！！

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

// ========== 货品类型 TODO 补充编号 ==========
public interface ErrorCodeConstants {
    ErrorCode GOODS_TYPE_NOT_EXISTS = new ErrorCode(500, "货品类型不存在");

    ErrorCode PRICE_TRIAL_NOT_EXISTS = new ErrorCode(500, "物流价格不存在");
}
