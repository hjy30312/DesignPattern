package 代理模式.动态代理;


public class UserServiceImpl implements UserService {
 
    @Override
	public String getTheName(int id) {
         return "小风";  
    }
 
    @Override
    public Integer getTheAge(int id) {
        return 10; 
    }

    @Override
    public void doSomething() {
        System.out.println("call doSomething()");
    }

}