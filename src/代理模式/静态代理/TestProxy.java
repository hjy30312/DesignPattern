package 代理模式.静态代理;

public class TestProxy
{
   public static void main(String args[])
   {
	   UserService sub = new RealUserServiceProxy();
       sub.doSomething();
	   sub.getTheName(10);
	   System.out.println(sub.getTheAge(10));
   }
}