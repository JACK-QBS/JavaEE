package org.example.proxy.proxy;

//接口的方式实现静态代理：和被代理类实现同一个接口
public class StaticProxyByImplements implements PayService {

    private PayService payService;

    //构造方法中传入被代理的对象
    public StaticProxyByImplements(PayService payService) {
        this.payService = payService;
    }

    @Override
    public void pay() {
        //1.安全检查
        System.out.println("安全检查");
        //2.记录日志
        System.out.println("记录日志");
        //3.时间统计开始
        System.out.println("记录开始时间");

        //支付业务逻辑：其实还是调用传入的被代理类的方法
        payService.pay();

        //4.时间统计结束
        System.out.println("记录结束时间");
    }

    public static void main(String[] args) {
        //使用时，同样是使用代理类：通过被代理类创建代理类
        PayService aliPayService = new StaticProxyByImplements(new AliPayService());
        PayService weiXinPayService = new StaticProxyByImplements(new WeiXinPayService());
        //使用代理类完成支付业务
        aliPayService.pay();
        weiXinPayService.pay();
    }
}