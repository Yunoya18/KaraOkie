/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author mansu
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class transaction extends JPanel{
    private JPanel  panel_main, panel_left, panel_right, panel_r_on, panel_r_down, panel_bn_on, panel_bn_down, panel_bn1, panelcal, panelcal2 
                   ,panel_empty, panel_empty2, panel_empty3, panel_empty4, panel_empty5, panel_empty6, panel_empty7, panel_empty8, panel_bill, panel_table
                    ;
    private JLabel panel_minimain, left_pa, txt_bill, bill_num;
    private JTextField  txt_cash, txt_credit;
    private JTable table;
    private JButton button_search, button_member, button_close, button_cancel, button_delete, button_edit, buttonOne, buttonTow, buttonThree, buttonFour,
                    buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonTen, buttonX, buttonClear, buttonOk, buttonJud, buttonDel;
    
    public transaction(){
        
        
        panel_main = new JPanel(new BorderLayout());
        setLayout(new BorderLayout(0,0));
        panel_left = new JPanel(new BorderLayout());
        panel_right = new JPanel(new GridLayout(2,1));
        panel_r_on = new JPanel(new BorderLayout());
        panel_r_down = new JPanel(new BorderLayout());
        panel_bn_on = new JPanel(new BorderLayout());
        panel_bn_down = new JPanel(new GridLayout(2,1));
        panel_bn1 = new JPanel(new GridLayout(2,3));
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
        bill_num = new JLabel("Bill number...");
        
        
        
        
        button_search = new JButton();
        button_member = new JButton();
        button_close = new JButton();
        button_cancel = new JButton();
        button_delete = new JButton();
        button_edit = new JButton();
        panel_bn1.add(button_search);
        panel_bn1.add(button_member);
        panel_bn1.add(button_close);
        panel_bn1.add(button_cancel);
        panel_bn1.add(button_delete);
        panel_bn1.add(button_edit);
        panel_bn_on.add(panel_bn1, BorderLayout.CENTER);
        
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
        
        
        
        
        
        txt_cash = new JTextField("CASH: 0.00");
        txt_credit = new JTextField("CREDIT: 0.00");
        panel_bn_down.add(txt_cash);
        panel_bn_down.add(txt_credit);
        
       
        panel_bill.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel_table.add(table, BorderLayout.CENTER);
        panel_table.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
//        setBorder
//        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
//        miport img
        ImageIcon mini = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 18 (1).png");
        Image min = mini.getImage().getScaledInstance(1150, 650, Image.SCALE_SMOOTH);
        Icon minimain = new ImageIcon(min);
        ImageIcon l = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 29.png");
        Image lef = l.getImage().getScaledInstance(620, 600, Image.SCALE_SMOOTH);
        Icon left = new ImageIcon(lef);
        ImageIcon bl = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 30.png");
        Image bill = bl.getImage().getScaledInstance(560, 40, Image.SCALE_SMOOTH);
        Icon billtxt = new ImageIcon(bill);
        ImageIcon sr = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 13.png");
        Image srch = sr.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon search = new ImageIcon(srch);
        ImageIcon mm = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 19.png");
        Image mem = mm.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon member = new ImageIcon(mem);
        ImageIcon cl = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 21.png");
        Image cls = cl.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon close = new ImageIcon(cls);
        ImageIcon cn = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 22.png");
        Image can = cn.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon cancel = new ImageIcon(can);
        ImageIcon dl = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 24.png");
        Image del = dl.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon delete = new ImageIcon(del);
        ImageIcon ed = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 26.png");
        Image edi = ed.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon edit = new ImageIcon(edi);
        bill_num.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));
        txt_bill = new JLabel(billtxt);
        txt_bill.add(bill_num);
        txt_bill.setLayout(new FlowLayout(FlowLayout.LEFT));
//        txt_bill.setText("Bill number...");
        panel_minimain = new JLabel(minimain);
        panel_minimain.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
        left_pa = new JLabel(left);
        left_pa.setLayout(new BorderLayout());
        add(panel_minimain, BorderLayout.CENTER);
        left_pa.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        
        
        
////        setBackground
//          setBackground(Color.decode("#535870"));
//          panel_right.setBackground(Color.decode("#282B3A"));
////        panel_main.set
//        
////        setBackground
          panel_main.setBackground(Color.decode("#282B3A"));
          setBackground(Color.decode("#535870"));
          panel_right.setBackground(Color.decode("#282B3A"));
          panel_bn_on.setBackground(Color.decode("#282B3A"));
          panel_bn_down.setBackground(Color.decode("#282B3A"));
          panel_bn1.setBackground(Color.decode("#282B3A"));
          panel_bill.setBackground(Color.decode("#171925"));
          panel_table.setBackground(Color.decode("#171925"));
          txt_bill.setBackground(Color.decode("#A6ADCE"));
          button_search.setBackground(Color.decode("#282B3A"));
          button_member.setBackground(Color.decode("#282B3A"));
          button_cancel.setBackground(Color.decode("#282B3A"));
          button_close.setBackground(Color.decode("#282B3A"));
          button_delete.setBackground(Color.decode("#282B3A"));
          button_edit.setBackground(Color.decode("#282B3A"));

          
          
//        panel_main.setIcon(tool1);
//        
//        
//        add(panel_supermain);
//        add(panel_main);
        panel_bill.add(txt_bill, BorderLayout.CENTER);
        panel_left.add(panel_bill, BorderLayout.NORTH);
        panel_left.add(panel_table, BorderLayout.CENTER);
        panel_r_on.add(panel_bn_on, BorderLayout.CENTER);
        panel_r_on.add(panel_bn_down, BorderLayout.SOUTH);
        panel_right.add(panel_r_on);
        panel_right.add(panel_r_down);
        left_pa.add(panel_left, BorderLayout.CENTER);
        panel_main.add(left_pa, BorderLayout.CENTER);
        panel_main.add(panel_right, BorderLayout.EAST);
        panel_r_down.add(panelcal, BorderLayout.CENTER);
        panel_r_down.add(panelcal2, BorderLayout.EAST);
        
        panel_minimain.add(panel_main);
        
        
        
        //button customize border
        button_search.setBorderPainted(false);
        button_search.setFocusPainted(false);
        button_member.setBorderPainted(false);
        button_member.setFocusPainted(false);
        button_cancel.setBorderPainted(false);
        button_cancel.setFocusPainted(false);
        button_close.setBorderPainted(false);
        button_close.setFocusPainted(false);
        button_delete.setBorderPainted(false);
        button_delete.setFocusPainted(false);
        button_edit.setBorderPainted(false);
        button_edit.setFocusPainted(false);
        
        //button add image
        button_search.setIcon(search);
        button_member.setIcon(member);
        button_close.setIcon(close);
        button_cancel.setIcon(cancel);
        button_delete.setIcon(delete);
        button_edit.setIcon(edit);
        
        //add button hover cursor
        JButton[] bttn = new JButton[]{button_search, button_member, button_close, button_cancel, button_delete, button_edit};
        for(JButton button : bttn){
              button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
//                        if(e.getSource().equals(button_search)){
//                            ImageIcon hoverIcon = new ImageIcon(i1.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
//                            button.setIcon(hoverIcon);
//                        }
//                        else if(e.getSource().equals(button_member)){
//                            ImageIcon hoverIcon = new ImageIcon(i2.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
//                            button.setIcon(hoverIcon);
//                        }
//                        else if(e.getSource().equals(button_delete)){
//                            ImageIcon hoverIcon = new ImageIcon(i3.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
//                            button.setIcon(hoverIcon);
//                        }
//                        else if(e.getSource().equals(button_edit)){
//                            ImageIcon hoverIcon = new ImageIcon(i4.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
//                            button.setIcon(hoverIcon);
//                        }
//                        else if(e.getSource().equals( button_cancel)){
//                            ImageIcon hoverIcon = new ImageIcon(i5.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
//                            button.setIcon(hoverIcon);
//                        }
//                        else if(e.getSource().equals( button_close)){
//                            ImageIcon hoverIcon = new ImageIcon(i5.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
//                            button.setIcon(hoverIcon);
//                        }
                        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                       
                    }


                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//                        if(e.getSource().equals(pg1)){
//                            button.setIcon(icon1);
//                        }
//                        else if(e.getSource().equals(pg2)){
//                            button.setIcon(icon2);
//                        }
//                        else if(e.getSource().equals(pg3)){
//                            button.setIcon(icon3);
//                        }
//                        else if(e.getSource().equals(pg4)){
//                            button.setIcon(icon4);
//                        }
//                        else if(e.getSource().equals(pg5)){
//                            button.setIcon(icon5);
//                        }
                    }
                });
    
        }
        
        

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
        panel_bn_down.setPreferredSize(new Dimension(250, 125));
        panel_main.setPreferredSize(new Dimension(1100,600));
        txt_bill.setPreferredSize(new Dimension(600,40));
        setVisible(true);
    }
    public static void main(String[] args){
        new transaction();
    }
}
