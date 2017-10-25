package 工厂方法;

/**
 * 不再提供一个统一的工厂类来创建所有的产品对象，
 * 而是针对不同的产品提供不同的工厂，
 * 系统提供一个与产品等级结构对应的工厂等级结构。
 * 工厂类的四个角色:
 * Factory(抽象工厂)、ConcreteFactory(具体工厂)
 * Product(抽象产品角色)、ConcreteProduct(具体产品角色)
 * @author hjy
 * @create 2017/10/25
 **/

//日志记录器接口：抽象产品
interface Logger {
    public void writeLog();
}

//数据库日志记录器：具体产品
class DatabaseLogger implements Logger {
    public void writeLog() {
        System.out.println("数据库日志记录。");
    }
}

//文件日志记录器：具体产品
class FileLogger implements Logger {
    public void writeLog() {
        System.out.println("文件日志记录。");
    }
}

//日志记录器工厂接口：抽象工厂
interface LoggerFactory {
    public Logger createLogger();
}

//数据库日志记录器工厂类：具体工厂
class DatabaseLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        //连接数据库，代码省略
        //创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }
}

//文件日志记录器工厂类：具体工厂
class FileLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        //创建文件日志记录器对象
        Logger logger = new FileLogger();
        //创建文件，代码省略
        return logger;
    }
}

public class Test {


}
