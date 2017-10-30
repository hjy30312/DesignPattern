package 抽象工厂;


/**
 * 某地区的农产品市场分南方市场和北方市场，分别销售南方和北方的农产品。
 * 其中农产品设计水果和素菜两大类，而水果有北方水果（如梨子）和南方水果（如香蕉）之分，
 * 蔬菜有北方素菜（如大蒜）和南方蔬菜（如黄瓜）之分。现有客户购买梨子、香蕉各五十斤，大蒜和黄瓜各二十斤，
 * 请用代码（基于抽象工厂模式）模拟。
 * @author hjy
 * @create 2017/10/26
 **/

//水果：抽象产品
interface Fruit {
    public void display(int i);
}
//南方水果：抽象产品
class SouthFruit implements Fruit {
    @Override
    public void display(int i) {
    }
    public Banana getBanana() {
        return new Banana();
    }
}

//香蕉：南方水果具体产品
class Banana extends SouthFruit {
    @Override
    public void display(int i) {
        System.out.println("购买香蕉" + i + "斤");
    }
}

//北方水果：抽象产品
class NorthFruit implements Fruit {

    public Pears getPears(){
        return new Pears();
    }

    @Override
    public void display(int i) {
    }
}
//梨子：北方水果具体产品
class Pears extends NorthFruit {
    @Override
    public void display(int i) {
        System.out.println("购买梨子" + i + "斤");
    }
}


//蔬菜：抽象产品
interface Vegetables {
    public void display(int i);
}
//南方蔬菜：抽象产品
class SouthVegetables implements Vegetables {

    public Cucumber getCucumber() {
        return new Cucumber();
    }
    @Override
    public void display(int i) {
    }


}
//黄瓜：具体产品
class  Cucumber extends SouthVegetables {

    @Override
    public void display(int i) {
        System.out.println("购买黄瓜" + i + "斤");
    }

}

//北方蔬菜：抽象产品
class NorthVegetables implements Vegetables {

    public Garlic getGarlic(){
        return new Garlic();
    }

    @Override
    public void display(int i) {
    }
}

//大蒜：具体产品
class Garlic extends NorthVegetables {
    @Override
    public void display(int i) {
        System.out.println("购买大蒜" + i + "斤");
    }
}

//市场：抽象工厂
interface MarketFactory {
    public Fruit buyFruit();
    public Vegetables buyVegetables();
}

//南具体市场：具体工厂
class SouthMarketFactory implements MarketFactory {

    @Override
    public SouthFruit buyFruit() {
        return new SouthFruit();
    }

    @Override
    public SouthVegetables buyVegetables() {
        return new SouthVegetables();
    }
}
//北具体市场：具体工厂
class NorthMarketFactory implements MarketFactory {

    @Override
    public NorthFruit buyFruit() {
        return new NorthFruit();
    }

    @Override
    public NorthVegetables buyVegetables() {
        return new NorthVegetables();
    }
}

public class Test2 {
    public static void main(String[] args) {
        SouthMarketFactory southMarketFactory = new SouthMarketFactory();
        NorthMarketFactory northMarketFactory = new NorthMarketFactory();
        SouthFruit southFruit = southMarketFactory.buyFruit();
        NorthFruit northFruit = northMarketFactory.buyFruit();
        NorthVegetables northVegetables = northMarketFactory.buyVegetables();
        SouthVegetables southVegetables = southMarketFactory.buyVegetables();
        Pears pears = northFruit.getPears();
        Banana banana = southFruit.getBanana();
        Garlic garlic = northVegetables.getGarlic();
        Cucumber cucumber = southVegetables.getCucumber();
        pears.display(50);
        banana.display(50);
        garlic.display(20);
        cucumber.display(20);



    }
}
