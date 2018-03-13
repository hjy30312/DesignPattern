package 代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyTest implements InvocationHandler {
	private Object target;   //被代理者
   
    JDKProxyTest(Object target) {
        this.target = target;  
    }  
 
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里就可以进行AOP编程了
        Object result = null;
        if ("getTheName".equals(method.getName()) || "doSomething".equals(method.getName())) {
            //在调用具体函数方法前，执行功能处理
            System.out.println("++++++调用方法之前： " + method.getName() + "++++++");
            result = method.invoke(target, args);
            //在调用具体函数方法后，执行功能处理
            System.out.println("++++++调用方法之后： " + method.getName() + "++++++");
        }
        return result;  
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        InvocationHandler handler=new JDKProxyTest(userService);
        UserService sub=
                 (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);


        sub.doSomething();
        sub.getTheName(10);
        System.out.println(sub.getTheAge(10));
    }
     
}