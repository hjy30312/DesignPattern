package 适配器模式;


        import java.awt.BorderLayout;
        import java.awt.Color;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;

        import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import javax.swing.JScrollPane;
        import javax.swing.JTable;

@SuppressWarnings("serial")
public class SimpleTableDemo extends JPanel {
    private boolean DEBUG = true;

    public SimpleTableDemo() {
        super(new BorderLayout());

        //创建表头
        String[] columnNames = { "First Name", "Last Name" };

        //创建显示数据
        Object[][] data = {
                { "Kathy", "Smith" },
                { "John", "Doe"},
                { "Sue", "Black"},
                { "Jane", "White"},
                { "Joe", "Brown"}
        };

        /*
         * JTable还提供了一个重载的构造方法,传入两个Vector
         * JTable(Vector rowData, Vector columnNames)
         *
         */

        final JTable table = new JTable(data, columnNames);


        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        // Create the scroll pane and add the table to it.
        //这也是官方建议使用的方式，否则表头不会显示，需要单独获取到TableHeader自己手动地添加显示
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);


        JPanel panel2 = new JPanel();
        this.add(panel2,BorderLayout.SOUTH);

    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // 创建并设置窗口
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建并设置内容窗格。
        SimpleTableDemo newContentPane = new SimpleTableDemo();
        frame.setContentPane(newContentPane);

        // 显示
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}