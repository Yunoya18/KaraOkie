
import java.awt.*;
import javax.swing.*;

public class test3 extends JFrame{
    private JPanel panel_supermain, panel_main, panel_left, panel_right, panel_r_on, panel_r_down, panel_bn_on, panel_bn_down, panel_bn1, panel_bn2, panelcal, panelcal2 
                   ,panel_empty, panel_empty2, panel_empty3, panel_empty4, panel_empty5, panel_empty6, panel_empty7, panel_empty8, panel_bill, panel_table
                    ;
    private JLabel panel_minimain;
    private JTextField txt_bill, txt_cash, txt_credit;
    private JTable table;
    private JButton button_search, button_member, button_close, button_cancel, button_delete, button_edit, buttonOne, buttonTow, buttonThree, buttonFour,
                    buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonTen, buttonX, buttonClear, buttonOk, buttonJud, buttonDel;
    
    public test3(){
        panel_supermain = new JPanel(new BorderLayout());
        panel_main = new JPanel(new BorderLayout());

        panel_left = new JPanel(new BorderLayout());
        panel_right = new JPanel(new GridLayout(2,1));
        panel_r_on = new JPanel(new BorderLayout());
        panel_r_down = new JPanel(new BorderLayout());
        panel_bn_on = new JPanel(new GridLayout(2,1));
        panel_bn_down = new JPanel(new GridLayout(2,1));
        panel_bn1 = new JPanel(new FlowLayout());
        panel_bn2 = new JPanel(new FlowLayout());
        table = new JTable();
        panelcal = new JPanel(new GridLayout(4,3));
        panelcal2 = new JPanel(new GridLayout(3,1));
        panel_empty = new JPanel();
        panel_empty2 = new JPanel();
        panel_empty3 = new JPanel();
        panel_empty4 = new JPanel();
        panel_empty5 = new JPanel();
        panel_empty6 = new JPanel();
        panel_empty7= new JPanel();
        panel_empty8 = new JPanel();
        panel_bill = new JPanel(new BorderLayout());
        panel_table = new JPanel(new BorderLayout());
        
        
        
        button_search = new JButton();
        button_member = new JButton();
        button_close = new JButton();
        button_cancel = new JButton();
        button_delete = new JButton();
        button_edit = new JButton();
        panel_bn1.add(button_search);
        panel_bn1.add(button_member);
        panel_bn1.add(button_close);
        panel_bn2.add(button_cancel);
        panel_bn2.add(button_delete);
        panel_bn2.add(button_edit);
        panel_bn_on.add(panel_bn1);
        panel_bn_on.add(panel_bn2);
        
        buttonOne = new JButton("1");
        buttonTow = new JButton("2");
        buttonThree = new JButton("3");
        buttonFour = new JButton("4");
        buttonFive = new JButton("5");
        buttonSix = new JButton("6");
        buttonSeven = new JButton("7");
        buttonEight = new JButton("8");
        buttonNine = new JButton("9");
        buttonTen = new JButton("0");
        buttonX = new JButton("X");
        buttonClear = new JButton("C");
        buttonOk = new JButton("OK");
        buttonJud = new JButton(".");
        buttonDel = new JButton("<--");
        panelcal.add(buttonSeven);
        panelcal.add(buttonEight);
        panelcal.add(buttonNine);
        panelcal.add(buttonFour);
        panelcal.add(buttonFive);
        panelcal.add(buttonSix);
        panelcal.add(buttonOne);
        panelcal.add(buttonTow);
        panelcal.add(buttonThree);
        panelcal.add(buttonTen);
        panelcal.add(buttonJud);
        panelcal.add(buttonClear);
        panelcal2.add(buttonDel);
        panelcal2.add(buttonX);
        panelcal2.add(buttonOk);
        
        
        
        
        txt_bill = new JTextField("Bill number...");
        txt_cash = new JTextField("CASH: 0.00");
        txt_credit = new JTextField("CREDIT: 0.00");
        panel_bn_down.add(txt_cash);
        panel_bn_down.add(txt_credit);
        
        panel_bill.add(txt_bill, BorderLayout.CENTER);
        panel_bill.add(panel_empty, BorderLayout.NORTH);
        panel_bill.add(panel_empty2, BorderLayout.SOUTH);
        panel_bill.add(panel_empty3, BorderLayout.WEST);
        panel_bill.add(panel_empty4, BorderLayout.EAST);
        panel_table.add(table, BorderLayout.CENTER);
        panel_table.add(panel_empty5, BorderLayout.NORTH);
        panel_table.add(panel_empty6, BorderLayout.SOUTH);
        panel_table.add(panel_empty7, BorderLayout.WEST);
        panel_table.add(panel_empty8, BorderLayout.EAST);
        
//        setBorder
        panel_supermain.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        
        
//        miport img
        ImageIcon t1 = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Rectangle 18.png");
        Image to1 = t1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Icon tool1 = new ImageIcon(to1);
        panel_minimain = new JLabel(tool1);
        
//        setBackground
//        panel_supermain.setBackground(Color.decode("#535870"));
//        panel_main.set
//        
////        setBackground
//        panel_supermain.setBackground(Color.decode("#535870"));
//        panel_main.setIcon(tool1);
//        
//        
//        add(panel_supermain);
        panel_supermain.add(panel_main, BorderLayout.CENTER);
        panel_left.add(panel_bill, BorderLayout.NORTH);
        panel_left.add(panel_table, BorderLayout.CENTER);
        panel_r_on.add(panel_bn_on, BorderLayout.CENTER);
        panel_r_on.add(panel_bn_down, BorderLayout.SOUTH);
        panel_right.add(panel_r_on);
        panel_right.add(panel_r_down);
        panel_main.add(panel_left, BorderLayout.CENTER);
        panel_main.add(panel_right, BorderLayout.EAST);
        panel_r_down.add(panelcal, BorderLayout.CENTER);
        panel_r_down.add(panelcal2, BorderLayout.EAST);
        
        txt_bill.setEditable(false);
        txt_cash.setEditable(false);
        txt_credit.setEditable(false);
        panel_empty.setPreferredSize(new Dimension(100, 50));
        panel_empty2.setPreferredSize(new Dimension(100, 50));
        panel_empty3.setPreferredSize(new Dimension(100, 50));
        panel_empty4.setPreferredSize(new Dimension(100, 50));
        panel_empty5.setPreferredSize(new Dimension(100, 30));
        panel_empty6.setPreferredSize(new Dimension(100, 80));
        panel_empty7.setPreferredSize(new Dimension(70, 50));
        panel_empty8.setPreferredSize(new Dimension(70, 50));
        button_search.setPreferredSize(new Dimension(100, 50));
        button_member.setPreferredSize(new Dimension(100, 50));
        button_close.setPreferredSize(new Dimension(100, 50));
        button_cancel.setPreferredSize(new Dimension(100, 50));
        button_delete.setPreferredSize(new Dimension(100, 50));
        button_edit.setPreferredSize(new Dimension(100, 50));
        panel_bn_down.setPreferredSize(new Dimension(250, 125));
        setBounds(0, 0, 1280, 720);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        new test3();
    }
}
