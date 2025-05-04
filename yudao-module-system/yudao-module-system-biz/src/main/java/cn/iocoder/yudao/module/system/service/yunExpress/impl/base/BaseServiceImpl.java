package cn.iocoder.yudao.module.system.service.yunExpress.impl.base;

import java.util.Base64;

public class BaseServiceImpl {

    public static Double parseDouble(Object obj) {
        double value = 0.0;
        if (obj instanceof String) {
            value = Double.parseDouble((String) obj);
        } else {
            throw new IllegalArgumentException("Object is not a String");
        }
        return value;
    }

    public static String buildToken(String customerId,String apiSecret) {
        String token = customerId + "&" + apiSecret;
        return "Basic " + Base64.getEncoder().encodeToString(token.getBytes());
    }
}
