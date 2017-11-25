package 观察者模式;

/**
 *
 * @author Administrator
 */
public class Mian {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();

        subject.attach(observer);
        subject.attach(observer2);

        ((ConcreteSubject)subject).setSbState(123);
    }
}
