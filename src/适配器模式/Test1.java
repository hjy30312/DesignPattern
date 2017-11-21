package 适配器模式;

/**
 * @author hjy
 * @create 2017/11/11
 **/

interface Cat {
    public void grab();
}

class CatAdapter implements Cat {

    Dog dog = new Dog();

    @Override
    public void grab() {
        dog.glab();
    }
}

class Dog {
    public void call(){}
    public void run(){}
    public void sleep(){}
    public void glab(){
        System.out.println("抓老鼠");
    }
}

public class Test1 {
    public static void main(String[] args) {
        Cat cat = new CatAdapter();
        cat.grab();
    }
}
