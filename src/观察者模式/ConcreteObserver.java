package 观察者模式;

import java.util.ArrayList;

public class ConcreteObserver implements Observer {
    
    public void update () {     
        System.out.println("this" + this + "知道了"  );
    }
}







