package cnxsliu.collections;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * @author cnxsliu
 * @description
 * @date 2020/5/18 11:50
 * @strategy 动态代理
 */

class DynamicProxy {
    public static void main(String[] args) {
        IRegisterService iRegisterService = new RegisterServiceImpl();
        InsertDataHandler insertDataHandler = new InsertDataHandler();
        IRegisterService proxy = (IRegisterService)insertDataHandler.getProxy(iRegisterService);
        proxy.register("RyanLee", "123");
    }
}

class InsertDataHandler implements InvocationHandler {
    private Object obj;

    public Object getProxy(Object obj){
        this.obj = obj;
        // 传入 ClassLoader 和 interfaces，创建动态代理类 Proxy
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(obj, args);
        doAfter();
        return result;
    }
    private void doBefore() {
        System.out.println("[Proxy]一些前置处理");
    }
    private void doAfter() {
        System.out.println("[Proxy]一些后置处理");
    }

}