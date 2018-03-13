package 代理模式.静态代理;


public class RealUserServiceProxy implements UserService {

	UserService userService = new UserServiceImpl();

	@Override
  	public void doSomething() {
		System.out.println("调用前");
		userService.doSomething();
		System.out.println("调用后");
	}

	@Override
	public String getTheName(int id) {
		System.out.println("调用前");
		String str = userService.getTheName(id);
		System.out.println(str);
		System.out.println("调用后");
		return str;
	}

	@Override
	public Integer getTheAge(int id) {
		return userService.getTheAge(id);
	}
}
