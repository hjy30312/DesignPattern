package 简单工厂模式;

/**
 * 简单工厂类三个角色：
 * Factory(工厂角色)、Product(抽象产品角色)、ConcreteProduct(具体产品角色)
 * @author hjy
 * @create 2017/10/24
 **/

//抽象图表接口：抽象产品类
interface Chart {
    public void display();
}

//柱状图类：具体产品类
class HistogramChart implements Chart {
    public HistogramChart() {
        System.out.println("创建柱状图！");
    }
    @Override
    public void display() {
        System.out.println("显示柱状图！");
    }
}

//饼状图类：具体产品类
class PieChart implements Chart {
    public PieChart() {
        System.out.println("创建饼状图！");
    }
    @Override
    public void display() {
        System.out.println("显示饼状图！");
    }
}

//图表工厂类：工厂类
class ChartFactory {
    //静态工厂方法
    public static Chart getChart(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图！");
        }
        else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
            System.out.println("初始化设置饼状图！");
        }
        return chart;
    }
}
public class Test {
    public static void main(String args[]) {
        Chart chart;
        chart = ChartFactory.getChart("histogram"); //通过静态工厂方法创建产品
        chart.display();
    }
}
