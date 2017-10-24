package 深浅拷贝;

/**
 * @author hjy
 * @create 2017/10/22
 **/

class Engine {
    String factory;
    private int power;

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Engine(String factory, int power) {
        this.factory = factory;
        this.power = power;
    }
}

class Car implements Cloneable {
    String BianHao;
    Engine engine;

    public String getBianHao() {
        return BianHao;
    }

    public void setBianHao(String bianHao) {
        BianHao = bianHao;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car(String bianHao, Engine engine) {

        BianHao = bianHao;
        this.engine = engine;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}




public class test {
    public static void main(String args[]) {
        Engine e = new Engine("五菱", 120);
        Car c = new Car("201501560", e);
        try {
            Car CC = (Car)c.clone();
            //浅拷贝无法拷贝对象里的对象
            System.out.println("c地址：" + c + "  编号：" + c.getBianHao() + "  Engine地址：" + c.engine
                    + " 马力" + c.engine.getPower());
            System.out.println("CC地址：" + CC + "  编号：" + CC.getBianHao() + "  Engine地址：" + CC.engine.hashCode()
                    + " 马力" + CC.engine.getPower());
            CC.engine.setPower(135);
            System.out.println("c地址：" + c + "  编号：" + c.getBianHao()  + "  Engine地址：" + c.engine.hashCode()
                    +  " 马力" +  c.engine.getPower());
            System.out.println("CC地址：" + CC + "  编号：" + CC.getBianHao() + "  Engine地址：" + CC.engine
                    +  " 马力" + CC.engine.getPower());

            CC.setBianHao("123");
            System.out.println("c编号：" + c.getBianHao() + "  编号地址：" + c.BianHao.hashCode());
            System.out.println("CC编号：" + CC.getBianHao() +"  编号地址：" +  CC.BianHao.hashCode());

        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }
    }
}