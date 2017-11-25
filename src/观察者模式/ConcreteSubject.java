package 观察者模式;

/**
 * 具体目标
 * @author Administrator
 */
public class ConcreteSubject extends Subject {

    private int sbState;

    public ConcreteSubject () {
    }

    public Object getSbState() {
        return sbState;
    }

    public void setSbState(int sbState) {
        this.sbState = sbState;
        System.out.println("目标改变状态为："  + sbState);
        this.Notify();
    }



    public void attach (Observer observer) {
        if (observers != null) {
            observers.add(observer);
        }
    }

    public void detach (Observer observer) {
        if (observers != null) {
            observers.remove(observer);
        }
    }

    public void Notify () {
        for (Object obs : observers) {
            //每个观察者对象 相对应的update方法
            ((Observer)obs).update();
        }
    }
}
