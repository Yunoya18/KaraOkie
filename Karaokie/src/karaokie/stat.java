/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;


/**
 *
 * @author sukwankaroon
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class stat extends JPanel implements ActionListener{
    
    private JDesktopPane side;
    private JPanel p5, blank, tab;
    private CardLayout cardlayout;
    private RoundedPanel w, m, y;
    private JComboBox<String> dropdown;
    private DefaultCategoryDataset dataset, dataset1, dataset2, dataset3;
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private statData data;
    private double weekTotal, monthTotal, yearTotal;
    public stat(){
        //       font
        try{
            Font Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/src/karaokie/font/Montserrat-Bold.ttf")).deriveFont(Font.PLAIN, 12);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Montserrat);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //ma = new JFrame("karaOkie");
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        menu = new JPanel();
        cardlayout = new CardLayout();
        tab = new JPanel(cardlayout);
        blank = new JPanel();
        p5 = new JPanel();


        data = new statData();

        //set backgroundcolor and foreground color
        setBackground(Color.decode("#535870"));
        p5.setBackground(Color.decode("#535870"));
        tab.setBackground(Color.decode("#535870"));
//        menu.setBackground(Color.decode("#282B3A"));
        blank.setBackground(Color.decode("#282B3A"));

        //test changing page
   


//        //Page 4
//        String[] column = {"ID", "Name", "Email", "Phone Number"};
//        Object[][] data = new Object[40][4];
//        JTable table = new JTable(data, column);
//        JScrollPane sp = new JScrollPane(table);
//        sp.setPreferredSize(new Dimension(1000, 650));
//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int row = table.rowAtPoint(e.getPoint());
//                int col = table.columnAtPoint(e.getPoint());
//                if (col == 0) {
//                    JPanel panel = new JPanel();
//                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//                    JLabel name = new JLabel("Name");
//                    JLabel email = new JLabel("Email");
//                    JLabel phone = new JLabel("Phone Number");
//                    // textfield name email phone number
//                    JTextField nameField = new JTextField();
//                    JTextField emailField = new JTextField();
//                    JTextField phoneField = new JTextField();
//                    // add label textfield to panel
//                    panel.add(name);
//                    panel.add(nameField);
//                    panel.add(email);
//                    panel.add(emailField);
//                    panel.add(phone);
//                    panel.add(phoneField);
//                    // button done center panel padding 10
//                    JButton done = new JButton("Done");
//                    done.setAlignmentX(Component.CENTER_ALIGNMENT);
//                    done.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//                    panel.add(done);
//                    // dialog not show button close
//                    Dialog dialog = new Dialog(ma);
//                    dialog.add(panel);
//                    dialog.setSize(200, 200);
//                    dialog.setVisible(true);
//                    // click done button
//                    done.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            // set data to table
//                            table.setValueAt(nameField.getText(), row, 1);
//                            table.setValueAt(emailField.getText(), row, 2);
//                            table.setValueAt(phoneField.getText(), row, 3);
//                            // close dialog
//                            dialog.dispose();
//                        }
//                    });
//
//
//                }
//
//            }
//        });
//
//        p4.add(sp);

        //Page 5 background
        p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));

        dropdown = new JComboBox<>();
        dropdown.setFont(new Font("Montserrat", Font.BOLD, 12));
        dropdown.setForeground(Color.decode("#282B3A"));
        dropdown.addItem("Weekly");
        dropdown.addItem("Monthly");
        dropdown.addItem("Yearly");
        dropdown.setAlignmentX(Component.CENTER_ALIGNMENT);


        // panel for dropdown
        JPanel panel = new JPanel();
        // background color #535870
        panel.setBackground(Color.decode("#535870"));
        panel.add(dropdown);
        p5.add(panel);
        
        //dataset
        dataset1 = new DefaultCategoryDataset();
        ArrayList<Double> weekInfo = data.getCurrentWeek();
        for (int i = 1; i < weekInfo.size()+1; i++) {
            dataset1.addValue(weekInfo.get(i - 1), "Weekly", DayOfWeek.of(i));
        }
        for (double num : weekInfo) {
            weekTotal += num;
        }
        dataset2 = new DefaultCategoryDataset();
        ArrayList<Double> monthInfo = data.getCurrentMonth();
        for (int i = 1; i < monthInfo.size()+1; i++) {
            dataset2.addValue(monthInfo.get(i - 1), "Weekly", "Week " + i);
        }
        for (double num : monthInfo) {
            monthTotal += num;
        }
        dataset3 = new DefaultCategoryDataset();
        ArrayList<Double> yearInfo = data.getCurrentYear();
        for (int i = 1; i < yearInfo.size()+1; i++) {
            dataset3.addValue(yearInfo.get(i - 1), "Weekly", Month.of(i));
        }
        for (double num : yearInfo) {
            yearTotal += num;
        }
        
        this.dataset = dataset1;
        // JFreeChart
        chart = ChartFactory.createLineChart("", "dd/mm/yy", "Amount", dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.decode("#535870"));
        chartPanel.setPreferredSize(new Dimension(800, 550));

        // panel in panel chart
        JPanel panelChartPanel = new JPanel();
        panelChartPanel.setBackground(Color.decode("#535870"));
        panelChartPanel.setLayout(new BoxLayout(panelChartPanel, BoxLayout.Y_AXIS));


        // panel weekly total
        w = new RoundedPanel(20, 20, 200, 150, Color.decode("#282B3A"), 1.0f, 10);
        JLabel weeklyTotal = new JLabel("Weekly Total: ");
        JLabel totalW = new JLabel(String.valueOf(weekTotal));
        totalW.setHorizontalAlignment(SwingConstants.CENTER);
        totalW.setFont(new Font("Montserrat", Font.BOLD, 30));
        totalW.setForeground(Color.decode("#A6ADCE"));
        // font size 15
        weeklyTotal.setFont(new Font("Montserrat", Font.BOLD, 15));
        weeklyTotal.setForeground(Color.decode("#A6ADCE"));
        weeklyTotal.setHorizontalAlignment(SwingConstants.CENTER);


        // panel for monthly total
        m = new RoundedPanel(20, 20, 200, 150, Color.decode("#282B3A"), 1.0f, 10);
        JLabel monthlyTotal = new JLabel("Monthly Total : ");
        JLabel totalM = new JLabel(String.valueOf(monthTotal));
        totalM.setHorizontalAlignment(SwingConstants.CENTER);
        totalM.setFont(new Font("Montserrat", Font.BOLD, 30));
        totalM.setForeground(Color.decode("#A6ADCE"));
        
        // font size 15
        monthlyTotal.setFont(new Font("Montserrat", Font.BOLD, 15));
        monthlyTotal.setForeground(Color.decode("#A6ADCE"));
        monthlyTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        monthlyTotal.setHorizontalAlignment(SwingConstants.CENTER);
        

        // panel for yearly total
        y = new RoundedPanel(20, 20, 200, 150, Color.decode("#282B3A"), 1.0f, 10);
        JLabel yearlyTotal = new JLabel("Yearly Total : ");
        JLabel totalY = new JLabel(String.valueOf(yearTotal));
        totalY.setHorizontalAlignment(SwingConstants.CENTER);
        totalY.setFont(new Font("Montserrat", Font.BOLD, 30));
        totalY.setForeground(Color.decode("#A6ADCE"));

        // font size 15
        yearlyTotal.setFont(new Font("Montserrat", Font.BOLD, 15));
        yearlyTotal.setForeground(Color.decode("#A6ADCE"));
        yearlyTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        yearlyTotal.setHorizontalAlignment(SwingConstants.CENTER);

        // background color #535870
        weeklyTotal.setBackground(Color.decode("#535870"));
        w.setLayout(new BorderLayout());
        w.add(weeklyTotal, BorderLayout.NORTH);
        w.add(totalW, BorderLayout.CENTER);
        panelChartPanel.add(w);

        JPanel space1 = new JPanel();
        space1.setBackground(Color.decode("#535870"));
        space1.setPreferredSize(new Dimension(200, 25));
        panelChartPanel.add(space1);

        // background color #535870
        monthlyTotal.setBackground(Color.decode("#535870"));
        m.setLayout(new BorderLayout());
        m.add(monthlyTotal, BorderLayout.NORTH);
        m.add(totalM, BorderLayout.CENTER);
        
        panelChartPanel.add(m);

        JPanel space2 = new JPanel();
        space2.setBackground(Color.decode("#535870"));
        space2.setPreferredSize(new Dimension(200, 25));
        panelChartPanel.add(space2);

        // background color #535870
        yearlyTotal.setBackground(Color.decode("#535870"));
        y.setLayout(new BorderLayout());
        y.add(yearlyTotal, BorderLayout.NORTH);
        y.add(totalY, BorderLayout.CENTER);
        
        panelChartPanel.add(y);
        
        // panel for chart
        JPanel panelChart = new JPanel();
        panelChart.setBackground(Color.decode("#535870"));
        panelChart.add(chartPanel);
        panelChart.add(panelChartPanel);

        p5.add(panelChart);

        //set Icon Image
        
        
        //set mainframe background
        setLayout(new BorderLayout(0, 0));
//   
        //add(menu, BorderLayout.WEST);
        add(p5, BorderLayout.CENTER);
        
        //add other
        
        
    
        blank.setPreferredSize(new Dimension(30, 30));
        

//        
        //button array for configured use
 
        //configured button not to have white filter when pressing
        UIManager.getLookAndFeelDefaults().put("Button.select", new Color(0, 0, 0, 0));
        
//        setSize(1280, 720);
//        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //button action
        
        dropdown.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev){
//        if(ev.getSource().equals(pg1)){
//           cardlayout.show(tab, "pg1");
//        }
//        else if(ev.getSource().equals(pg2)){
//           cardlayout.show(tab, "pg2");
//        }
//        else if(ev.getSource().equals(pg3)){
//           cardlayout.show(tab, "pg3");
//        }
//        else if(ev.getSource().equals(pg4)){
//           cardlayout.show(tab, "pg4");
//        }
//        else if(ev.getSource().equals(pg5)){
//           cardlayout.show(tab, "pg5");
//        }
        if (ev.getSource().equals(dropdown)) {
            DefaultCategoryDataset newDataset = null;
            if (dropdown.getSelectedItem().equals("Weekly")) {
                newDataset = dataset1;
            } else if (dropdown.getSelectedItem().equals("Monthly")) {
                newDataset = dataset2;
            } else if (dropdown.getSelectedItem().equals("Yearly")) {
                newDataset = dataset3;
            }
            this.dataset = newDataset;
            chart.getCategoryPlot().setDataset(newDataset);
            chartPanel.repaint();
        }
    }
    public static void main(String[] args) {
        new stat();
    }
    
    
}