package 单例模式;

/**
 * @author hjy
 * @create 2017/10/23
 **/


class Server1 {
    /*
     *   私有静态成员变量，存储服务器唯一实例
     */
    private static Server1 instance = new Server1();

    private Server1(){}
    public static Server1 getInstance(){
        return instance;
    }
    public Server1 getServer(){
        return instance;
    }
}
class Client {
    public static void main(String[] args) {
        Server1 server1;
        server1 = Server1.getInstance();
    }
}
public class Test2 {
}
