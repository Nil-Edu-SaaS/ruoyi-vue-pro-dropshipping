package cn.iocoder.yudao.module.system.service.yunExpress.impl.body;

import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 运单申请headers模型
 * */


public class BuildBody {

    // 创建运单申请请求体
    public static JSONObject createOrderBody(){

        // 创建请求体
        JSONObject requestBody = new cn.hutool.json.JSONObject();

        // 填充请求体字段
        requestBody.set("CustomerOrderNumber", "G2G20190402001");
        requestBody.set("ShippingMethodCode", "PK0004");
        requestBody.set("TrackingNumber", null);
        requestBody.set("TransactionNumber", null);
        requestBody.set("IossCode", "IOSS0690112210251452600");
        requestBody.set("BrazilianCode", null);
        requestBody.set("SizeUnits", "cm");
        requestBody.set("Height", 1);
        requestBody.set("Length", 1);
        requestBody.set("Width", 1);
        requestBody.set("PackageCount", 1);
        requestBody.set("Weight", 1);
        requestBody.set("ApplicationType", 4);
        requestBody.set("ReturnOption", 0);
        requestBody.set("TariffPrepay", 0);
        requestBody.set("InsuranceOption", 0);
        requestBody.set("SourceCode", "API");

        // 创建 Receiver 对象
        JSONObject receiver = new JSONObject();
        receiver.set("CountryCode", "US");
        receiver.set("FirstName", "xin");
        receiver.set("LastName", "ming");
        receiver.set("Company", "test gs");
        receiver.set("Street", "67700 Lockwood-Jolon Road");
        receiver.set("City", "Lockwood");
        receiver.set("State", "California");
        receiver.set("Zip", "93932");
        receiver.set("Phone", "5869098233");
        receiver.set("HouseNumber", "1");
        receiver.set("Email", "12345@qq.com");
        requestBody.set("Receiver", receiver);

        // 创建 Sender 对象
        JSONObject sender = new JSONObject();
        sender.set("CountryCode", "US");
        sender.set("FirstName", "test");
        sender.set("LastName", "ming");
        sender.set("Company", "test gs");
        sender.set("Street", "207 TELLURIDE DR");
        sender.set("City", "GEORGETOWN");
        sender.set("State", "TX");
        sender.set("Zip", "78626-7163");
        sender.set("Phone", "5869098233");
        sender.set("HouseNumber", "1");
        requestBody.set("Sender", sender);

        // 创建 OrderExtra 对象
        JSONObject orderExtra = new JSONObject();
        orderExtra.set("ExtraCode", "V1");
        orderExtra.set("ExtraName", "云途预缴");
        requestBody.set("OrderExtra", Arrays.asList(orderExtra));

        // 创建 Parcels 对象
        JSONObject parcel = new JSONObject();
        parcel.set("EName", "shangpin1");
        parcel.set("CName", " 商品 1");
        parcel.set("HSCode", null);
        parcel.set("Quantity", 1);
        parcel.set("SKU", "sku1001");
        parcel.set("UnitPrice", 10);
        parcel.set("UnitWeight", 1);
        parcel.set("Remark", " 商品 ");
        parcel.set("InvoiceRemark", "ceshi 1 pcs");
        requestBody.set("Parcels", Arrays.asList(parcel));

        // 创建 ChildOrders 对象
        JSONObject childDetail = new JSONObject();
        childDetail.set("Sku", "sku1001");
        childDetail.set("Quantity", 1);

        JSONObject childOrder = new JSONObject();
        childOrder.set("BoxNumber", "test01");
        childOrder.set("Length", 1);
        childOrder.set("Width", 1);
        childOrder.set("Height", 1);
        childOrder.set("BoxWeight", 1);
        childOrder.set("ChildDetails", Arrays.asList(childDetail));

        requestBody.set("ChildOrders", Arrays.asList(childOrder));

        return requestBody;
    }

    // 创建按单号订阅轨迹请求体
    public static JSONObject getOrderSubscribeBody(){
        // 创建请求体
        JSONObject requestBody = new cn.hutool.json.JSONObject();
        requestBody.set("DisplayMode", 5);
        requestBody.set("QueryMode", 4);
        requestBody.set("shipper_hawbcode", Arrays.asList("YT1907721208007572","YT1907821208001377"));
        return requestBody;
    }

    // 修改订单预报重量请求体
    public static JSONObject updateWeightBody(){
        // 创建请求体
        JSONObject requestBody = new cn.hutool.json.JSONObject();
        requestBody.set("OrderNumber", "G2Gapi20190401001");
        requestBody.set("Weight", "2.88");
        return requestBody;
    }

    // 删除订单
    public static JSONObject deleteOrderBody(){
        // 创建请求体
        JSONObject requestBody = new cn.hutool.json.JSONObject();
        requestBody.set("OrderType", "1");
        requestBody.set("OrderNumber", "G2Gapi20190401001");
        return requestBody;
    }
}
