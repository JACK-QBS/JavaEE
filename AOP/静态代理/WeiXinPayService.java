package org.example.proxy.proxy;

//微信支付
public class WeiXinPayService implements PayService {
    
    @Override
    public void pay() {
        //支付业务逻辑
        System.out.println("微信支付...");
    }
}