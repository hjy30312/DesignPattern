package 适配器模式;

/**
 * 对象适配器模式
 * @author hjy
 * @create 2017/11/11
 **/

/**
 * （目标抽象类）：目标抽象类定义客户所需接口，
 * 可以是一个抽象类或接口，也可以是具体类。
 */
interface Target {
    public void request();
}


/**
 * Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配，
 * 适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系。
 */
class Adapter implements Target {

    Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.sprcificRequest();
    }
}

/**
 * Adaptee（适配者类）：适配者即被适配的角色，它定义了一个已经存在的接口，这个接口需要适配，
 * 适配者类一般是一个具体类，包含了客户希望使用的业务方法，在某些情况下可能没有适配者类的源代码。
 */
class Adaptee {
    public void sprcificRequest(){
        System.out.println("sprcificRequest");
    }
}

public class Test {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
