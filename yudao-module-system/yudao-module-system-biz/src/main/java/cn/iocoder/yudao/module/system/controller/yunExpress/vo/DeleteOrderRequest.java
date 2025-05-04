package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import lombok.Data;

@Data
public class DeleteOrderRequest {
    
    private String orderNumber;
    
    private String orderType;
}
