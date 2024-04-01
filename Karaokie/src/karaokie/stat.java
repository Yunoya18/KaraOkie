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
    private JFrame ma;
    private JDesktopPane side;
    private JPanel menu, blank, p1, p2, p3, p4, p5, tab;
    private JButton pg1, pg2, pg3, pg4, pg5;
    private CardLayout cardlayout;
    private JLabel txt1, txt2, txt3, txt4, txt5;
    private RoundedPanel w, m, y;
    private JComboBox<String> dropdown;
    private DefaultCategoryDataset dataset, dataset1, dataset2, dataset3;
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private statData data;
    public stat(){
        //       font
        try{
            Font Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/src/karaokie/font/Montserrat-Regular.ttf")).deriveFont(Font.PLAIN, 12);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Montserrat);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //ma = new JFrame("karaOkie");
        menu = new JPanel();
        cardlayout = new CardLayout();
        tab = new JPanel(cardlayout);
        blank = new JPanel();
        pg2 = new JButton();
        pg3 = new JButton();
        pg4 = new JButton();
        pg5 = new JButton();
        pg1 = new JButton();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        txt1 = new JLabel("page1");
        txt2 = new JLabel("page2");
        txt3 = new JLabel("page3");
        txt4 = new JLabel("page4");
        txt5 = new JLabel("page5");

        data = new statData();

        //set backgroundcolor and foreground color
        p1.setBackground(Color.decode("#535870"));
        p2.setBackground(Color.decode("#535870"));
        p3.setBackground(Color.decode("#535870"));
        p4.setBackground(Color.decode("#535870"));
        p5.setBackground(Color.decode("#535870"));
        tab.setBackground(Color.decode("#535870"));
        menu.setBackground(Color.decode("#282B3A"));
        blank.setBackground(Color.decode("#282B3A"));
        txt1.setForeground(Color.WHITE);
        txt2.setForeground(Color.WHITE);
        txt3.setForeground(Color.WHITE);
        txt4.setForeground(Color.WHITE);
        txt5.setForeground(Color.WHITE);

        //test changing page
        p1.add(txt1);
        p2.add(txt2);
        p3.add(txt3);



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
        dataset2 = new DefaultCategoryDataset();
        ArrayList<Double> monthInfo = data.getCurrentWeek();
        for (int i = 1; i < monthInfo.size()+1; i++) {
            dataset2.addValue(monthInfo.get(i - 1), "Weekly", "Week " + i);
        }
        dataset3 = new DefaultCategoryDataset();
        ArrayList<Double> yearInfo = data.getCurrentWeek();
        for (int i = 1; i < weekInfo.size()+1; i++) {
            dataset3.addValue(yearInfo.get(i - 1), "Weekly", Month.of(i));
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
        // font size 15
        weeklyTotal.setFont(new Font("Montserrat", Font.BOLD, 15));
        weeklyTotal.setForeground(Color.decode("#A6ADCE"));
        weeklyTotal.setAlignmentX(Component.CENTER_ALIGNMENT);


        // panel for monthly total
        m = new RoundedPanel(20, 20, 200, 150, Color.decode("#282B3A"), 1.0f, 10);
        JLabel monthlyTotal = new JLabel("Monthly Total : ");
        // font size 15
        monthlyTotal.setFont(new Font("Montserrat", Font.BOLD, 15));
        monthlyTotal.setForeground(Color.decode("#A6ADCE"));
        monthlyTotal.setAlignmentX(Component.CENTER_ALIGNMENT);

        // panel for yearly total
        y = new RoundedPanel(20, 20, 200, 150, Color.decode("#282B3A"), 1.0f, 10);
        JLabel yearlyTotal = new JLabel("Yearly Total : ");
        // font size 15
        yearlyTotal.setFont(new Font("Montserrat", Font.BOLD, 15));
        yearlyTotal.setForeground(Color.decode("#A6ADCE"));
        yearlyTotal.setAlignmentX(Component.CENTER_ALIGNMENT);

        // background color #535870
        weeklyTotal.setBackground(Color.decode("#535870"));
        w.add(weeklyTotal);
        panelChartPanel.add(w);

        JPanel space1 = new JPanel();
        space1.setBackground(Color.decode("#535870"));
        space1.setPreferredSize(new Dimension(200, 25));
        panelChartPanel.add(space1);

        // background color #535870
        monthlyTotal.setBackground(Color.decode("#535870"));
        m.add(monthlyTotal);
        panelChartPanel.add(m);

        JPanel space2 = new JPanel();
        space2.setBackground(Color.decode("#535870"));
        space2.setPreferredSize(new Dimension(200, 25));
        panelChartPanel.add(space2);

        // background color #535870
        yearlyTotal.setBackground(Color.decode("#535870"));
        y.add(yearlyTotal);
        panelChartPanel.add(y);
        
        // panel for chart
        JPanel panelChart = new JPanel();
        panelChart.setBackground(Color.decode("#535870"));
        panelChart.add(chartPanel);
        panelChart.add(panelChartPanel);

        p5.add(panelChart);

        //set Icon Image
        ImageIcon i1 = new ImageIcon("/Users/sukwankaroon/Desktop/karaokie/src/main/java/KaraOkie/room.png");
        Image img1 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon1 = new ImageIcon(img1);
        ImageIcon i2 = new ImageIcon("");
        Image img2 = i2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon2 = new ImageIcon(img2);
        ImageIcon i3 = new ImageIcon("/Users/sukwankaroon/Desktop/karaokie/src/main/java/KaraOkie/tips-2.png");
        Image img3 = i3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon3 = new ImageIcon(img3);
        ImageIcon i4 = new ImageIcon("/Users/sukwankaroon/Desktop/karaokie/src/main/java/KaraOkie/membership-card.png");
        Image img4 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon4 = new ImageIcon(img4);
        ImageIcon i5 = new ImageIcon("/Users/sukwankaroon/Desktop/karaokie/src/main/java/KaraOkie/bar-chart.png");
        Image img5 = i5.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        Icon icon5 = new ImageIcon(img5);
        pg1.setIcon(icon1);
        pg2.setIcon(icon2);
        pg3.setIcon(icon3);
        pg4.setIcon(icon4);
        pg5.setIcon(icon5);
        
        //set mainframe background
        setLayout(new BorderLayout(0, 0));
        menu.setPreferredSize(new Dimension(50, 190));
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        
        //add components to mainframe
        //add(menu, BorderLayout.WEST);
        add(p5, BorderLayout.CENTER);
        
        //add other
        
        
        //add panel to tab
        //tab.add(pm1 ,"pg1");
        //tab.add(p2, "pg2");
        //tab.add(p3, "pg3");
        //tab.add(p4, "pg4");
        //tab.add(p5, "pg5");
        
        //insert button in menu bar
        menu.add(blank);
        menu.add(pg1);
        menu.add(pg2);
        menu.add(pg3);
        menu.add(pg4);
        menu.add(pg5);
        blank.setPreferredSize(new Dimension(30, 30));
        
        //set button size
        pg1.setPreferredSize(new Dimension(50, 50));
        pg2.setPreferredSize(new Dimension(50, 50));
        pg3.setPreferredSize(new Dimension(50, 50));
        pg4.setPreferredSize(new Dimension(50, 50));
        pg5.setPreferredSize(new Dimension(50, 50));

        
        //delete button border and focus border
        pg1.setBorderPainted(false);
        pg1.setFocusPainted(false);
        pg2.setBorderPainted(false);
        pg2.setFocusPainted(false);
        pg3.setBorderPainted(false);
        pg3.setFocusPainted(false);
        pg4.setBorderPainted(false);
        pg4.setFocusPainted(false);
        pg5.setBorderPainted(false);
        pg5.setFocusPainted(false);
        
        //button array for configured use
        JButton[] group = new JButton[]{pg1, pg2, pg3, pg4, pg5};
        
        //change cursor and make icon bigger when hover
        for(JButton button : group){
              button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(e.getSource().equals(pg1)){
                            ImageIcon hoverIcon = new ImageIcon(i1.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(pg2)){
                            ImageIcon hoverIcon = new ImageIcon(i2.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(pg3)){
                            ImageIcon hoverIcon = new ImageIcon(i3.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(pg4)){
                            ImageIcon hoverIcon = new ImageIcon(i4.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(pg5)){
                            ImageIcon hoverIcon = new ImageIcon(i5.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                       
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        if(e.getSource().equals(pg1)){
                            button.setIcon(icon1);
                        }
                        else if(e.getSource().equals(pg2)){
                            button.setIcon(icon2);
                        }
                        else if(e.getSource().equals(pg3)){
                            button.setIcon(icon3);
                        }
                        else if(e.getSource().equals(pg4)){
                            button.setIcon(icon4);
                        }
                        else if(e.getSource().equals(pg5)){
                            button.setIcon(icon5);
                        }
                    }
                });
        }
        //configured button not to have white filter when pressing
        UIManager.getLookAndFeelDefaults().put("Button.select", new Color(0, 0, 0, 0));
        
        setSize(1280, 720);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //button action
        pg1.addActionListener(this);
        pg2.addActionListener(this);
        pg3.addActionListener(this);
        pg4.addActionListener(this);
        pg5.addActionListener(this);
        
        dropdown.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(pg1)){
           cardlayout.show(tab, "pg1");
        }
        else if(ev.getSource().equals(pg2)){
           cardlayout.show(tab, "pg2");
        }
        else if(ev.getSource().equals(pg3)){
           cardlayout.show(tab, "pg3");
        }
        else if(ev.getSource().equals(pg4)){
           cardlayout.show(tab, "pg4");
        }
        else if(ev.getSource().equals(pg5)){
           cardlayout.show(tab, "pg5");
        }
        else if (ev.getSource().equals(dropdown)) {
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