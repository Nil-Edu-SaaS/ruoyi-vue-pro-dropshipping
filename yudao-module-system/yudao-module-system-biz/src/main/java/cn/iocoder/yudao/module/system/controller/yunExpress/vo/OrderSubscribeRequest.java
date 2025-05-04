package cn.iocoder.yudao.module.system.controller.yunExpress.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderSubscribeRequest {
    private List<String> wayBillNumber;

    private int displayMode;

    private int queryMode;
}
