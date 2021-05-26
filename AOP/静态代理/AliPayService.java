package org.example.proxy.proxy;

//支付宝付款
public class AliPayService implements PayService {
    
    @Override
    public void pay() {
        //支付业务逻辑
        System.out.println("支付宝支付...");
    }
}