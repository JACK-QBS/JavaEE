package org.example.proxy.proxy;

//通过继承的方式实现静态代理类
class AliPayServiceStaticProxyByExtends extends AliPayService {
    @Override
    public void pay() {
        //1.安全检查
        System.out.println("安全检查");
        //2.记录日志
        System.out.println("记录日志");
        //3.时间统计开始
        System.out.println("记录开始时间");

        //支付业务逻辑：实际还是调用父类的业务
        super.pay();

        //4.时间统计结束
        System.out.println("记录结束时间");
    }
}
//通过继承的方式实现静态代理类
class WeiXinServiceStaticProxyByExtends extends WeiXinPayService {
    @Override
    public void pay() {
        //1.安全检查
        System.out.println("安全检查");
        //2.记录日志
        System.out.println("记录日志");
        //3.时间统计开始
        System.out.println("记录开始时间");

        //支付业务逻辑：实际还是调用父类的业务
        super.pay();

        //4.时间统计结束
        System.out.println("记录结束时间");
    }
}
public class StaticProxyByExtends {

    public static void main(String[] args) throws InterruptedException {
        //使用时，不再直接使用原有对象，而是使用代理对象，所以是new代理类
        AliPayService aliPayService = new AliPayServiceStaticProxyByExtends();
        WeiXinPayService weiXinPayService = new WeiXinServiceStaticProxyByExtends();
        //使用：发起支付业务
        aliPayService.pay();
        weiXinPayService.pay();
    }
}