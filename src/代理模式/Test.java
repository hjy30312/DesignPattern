package 代理模式;

/**
 * @author hjy
 * @create 2017/11/06
 **/

/**
 * 抽象主题类声明了真实主题类和代理类的公共方法，
 * 它可以是接口、抽象类或具体类，客户端针对抽象主题类编程，
 * 一致性地对待真实主题和代理主题
 */
abstract class Subject
{
    public abstract void request();
}

/**
 * 真实主题类继承了抽象主题类，
 * 提供了业务方法的具体实现
 */
class RealSubject extends Subject{

    @Override
    public void request() {
        //业务方法具体实现代码
    }
}

class Proxy extends Subject {
    private RealSubject realSubject = new RealSubject();

    public void preRequest() {

    }

    @Override
    public void request() {
        preRequest();
        //调用真实主题对象的方法
        realSubject.request();
        postRequest();
    }

    public void postRequest() {

    }
}


public class Test {

}
