package karaokie;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
public class page3 extends JPanel {

    private JPanel  panel_main, panel_left, panel_right, panel_r_on, panel_r_down, panel_bn_on, panel_bn_down, panel_bn1, panelcal, panelcal2 
                   ,panel_empty, panel_empty2, panel_empty3, panel_empty4, panel_empty5, panel_empty6, panel_empty7, panel_empty8, panel_bill, panel_table
                    , panelcal2_on;
    private JLabel panel_minimain, left_pa, txt_bill, bill_num, cal_img, cash_img, credit_img;
    private JTextField  txt_cash, txt_credit;
    private JTable table;
    private JButton button_search, button_member, button_close, button_cancel, button_delete, button_edit, buttonOne, buttonTow, buttonThree, buttonFour,
                    buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonTen, buttonX, buttonClear, buttonOk, buttonJud, buttonDel;
  
    public page3(){
        //       font
        try{
            Font Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/src/karaokie/font/Montserrat-Bold.ttf")).deriveFont(Font.PLAIN, 12);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Montserrat);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
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
        panelcal2 = new JPanel(new GridLayout(2,1));
        panelcal2_on = new JPanel(new GridLayout(2,1));
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
        
        buttonOne = new JButton();
        buttonTow = new JButton();
        buttonThree = new JButton();
        buttonFour = new JButton();
        buttonFive = new JButton();
        buttonSix = new JButton();
        buttonSeven = new JButton();
        buttonEight = new JButton();
        buttonNine = new JButton();
        buttonTen = new JButton();
        buttonX = new JButton();
        buttonClear = new JButton();
        buttonOk = new JButton();
        buttonJud = new JButton();
        buttonDel = new JButton();
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
        panelcal2_on.add(buttonDel);
        panelcal2_on.add(buttonX);
        panelcal2.add(panelcal2_on);
        panelcal2.add(buttonOk);
        
        
        
        
        
        txt_cash = new JTextField("CASH: 0.00");
        txt_credit = new JTextField("CREDIT: 0.00");
        
        
       
        panel_bill.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel_table.add(table, BorderLayout.CENTER);
        panel_table.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
//        setBorder
//        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
//        miport img
        ImageIcon mini = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 18.png");
        Image min = mini.getImage().getScaledInstance(1150, 650, Image.SCALE_SMOOTH);
        Icon minimain = new ImageIcon(min);
        ImageIcon l = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 29.png");
        Image lef = l.getImage().getScaledInstance(680, 600, Image.SCALE_SMOOTH);
        Icon left = new ImageIcon(lef);
        ImageIcon bl = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 30.png");
        Image bill = bl.getImage().getScaledInstance(600, 40, Image.SCALE_SMOOTH);
        Icon billtxt = new ImageIcon(bill);
        ImageIcon sr = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 13.png");
        Image srch = sr.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon search = new ImageIcon(srch);
        ImageIcon mm = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 19.png");
        Image mem = mm.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon member = new ImageIcon(mem);
        ImageIcon cl = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 21.png");
        Image cls = cl.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon close = new ImageIcon(cls);
        ImageIcon cn = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 22.png");
        Image can = cn.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon cancel = new ImageIcon(can);
        ImageIcon dl = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 24.png");
        Image del = dl.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon delete = new ImageIcon(del);
        ImageIcon ed = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 26.png");
        Image edi = ed.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon edit = new ImageIcon(edi);
        ImageIcon ca = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 61.png");
        Image ch = ca.getImage().getScaledInstance(400, 60, Image.SCALE_SMOOTH);
        Icon cash = new ImageIcon(ch);
        ImageIcon cr = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 54.png");
        Image cd = cr.getImage().getScaledInstance(400, 60, Image.SCALE_SMOOTH);
        Icon credit = new ImageIcon(cd);
        ImageIcon ci = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 34.png");
        Image cim = ci.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        Icon calim = new ImageIcon(cim);
        
//        import img cal
        ImageIcon ze = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 38.png");
        Image zr = ze.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon zero = new ImageIcon(zr);
        ImageIcon on = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 39.png");
        Image oon = on.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon one = new ImageIcon(oon);
        ImageIcon tt = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 44.png");
        Image tw = tt.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon two = new ImageIcon(tw);
        ImageIcon the = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 35.png");
        Image th = the.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon three = new ImageIcon(th);
        ImageIcon fo = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 40.png");
        Image foo = fo.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon four = new ImageIcon(foo);
        ImageIcon fi = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 43.png");
        Image fii = fi.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon five = new ImageIcon(fii);
        ImageIcon ss = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 34.png");
        Image si = ss.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon six = new ImageIcon(si);
        ImageIcon sv = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 41.png");
        Image se = sv.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon seven = new ImageIcon(se);
        ImageIcon eg = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 42.png");
        Image ei = eg.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon eight = new ImageIcon(ei);
        ImageIcon ni = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 33.png");
        Image ne = ni.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon nine = new ImageIcon(ne);
        ImageIcon jd = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 37.png");
        Image jj = jd.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon judd = new ImageIcon(jj);
        ImageIcon cc = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 36.png");
        Image ccc = cc.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon cccc = new ImageIcon(ccc);
        ImageIcon xx = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 31.png");
        Image xxx =xx.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon xxxx = new ImageIcon(xxx);
        ImageIcon bc = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 29.png");
        Image bac = bc.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        Icon back = new ImageIcon(bac);
        ImageIcon oo = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 32.png");
        Image kk = oo.getImage().getScaledInstance(80, 140, Image.SCALE_SMOOTH);
        Icon okk = new ImageIcon(kk);
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
        cal_img = new JLabel(calim);
        cal_img.setLayout(new BorderLayout(0,0));
        cal_img.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        cash_img = new JLabel(cash);
        cash_img.setLayout(new BorderLayout(0,0));
        cash_img.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        credit_img = new JLabel(credit);
        credit_img.setLayout(new BorderLayout(0,0));
        credit_img.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        cash_img.add(txt_cash);
        credit_img.add(txt_credit);
        txt_cash.setBackground(Color.decode("#1E1E1E"));
        txt_credit.setBackground(Color.decode("#1E1E1E"));
        txt_cash.setBorder(BorderFactory.createEmptyBorder());
        txt_credit.setBorder(BorderFactory.createEmptyBorder());
        
        
        
        
        
        
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
          panel_r_down.setBackground(Color.decode("#282B3A"));

          
          
//        panel_main.setIcon(tool1);
//        
//        
//        add(panel_supermain);
//        add(panel_main);
        panel_bn_down.add(cash_img);
        panel_bn_down.add(credit_img);
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
        cal_img.add(panelcal, BorderLayout.CENTER);
        cal_img.add(panelcal2, BorderLayout.EAST);
        panel_r_down.add(cal_img, BorderLayout.CENTER);
//        panel_r_down.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//        panel_r_down.add(panelcal2, BorderLayout.EAST);
        
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
        
        buttonOne.setFocusPainted(false);
        buttonTow.setFocusPainted(false);
        buttonThree.setFocusPainted(false);
        buttonFour.setFocusPainted(false);
        buttonFive.setFocusPainted(false);
        buttonSix.setFocusPainted(false);
        buttonSeven.setFocusPainted(false);
        buttonEight.setFocusPainted(false);
        buttonNine.setFocusPainted(false);
        buttonTen.setFocusPainted(false);
        buttonX.setFocusPainted(false);
        buttonClear.setFocusPainted(false);
        buttonOk.setFocusPainted(false);
        buttonJud.setFocusPainted(false);
        buttonDel.setFocusPainted(false); 
        
        buttonOne.setBorderPainted(false);
        buttonTow.setBorderPainted(false);
        buttonThree.setBorderPainted(false);
        buttonFour.setBorderPainted(false);
        buttonFive.setBorderPainted(false);
        buttonSix.setBorderPainted(false);
        buttonSeven.setBorderPainted(false);
        buttonEight.setBorderPainted(false);
        buttonNine.setBorderPainted(false);
        buttonTen.setBorderPainted(false);
        buttonX.setBorderPainted(false);
        buttonClear.setBorderPainted(false);
        buttonOk.setBorderPainted(false);
        buttonJud.setBorderPainted(false);
        buttonDel.setBorderPainted(false); 
        
        //button add image
        button_search.setIcon(search);
        button_member.setIcon(member);
        button_close.setIcon(close);
        button_cancel.setIcon(cancel);
        button_delete.setIcon(delete);
        button_edit.setIcon(edit);
       
        buttonOne.setIcon(one);
        buttonTow.setIcon(two);
        buttonThree.setIcon(three);
        buttonFour.setIcon(four);
        buttonFive.setIcon(five);
        buttonSix.setIcon(six);
        buttonSeven.setIcon(seven);
        buttonEight.setIcon(eight);
        buttonNine.setIcon(nine);
        buttonTen.setIcon(zero);
        buttonX.setIcon(xxxx);
        buttonClear.setIcon(cccc);
        buttonOk.setIcon(okk);
        buttonJud.setIcon(judd);
        buttonDel.setIcon(back);
        
        
        //button set bg
        buttonOne.setBackground(Color.decode("#171925"));
        buttonTow.setBackground(Color.decode("#171925"));
        buttonThree.setBackground(Color.decode("#171925"));
        buttonFour.setBackground(Color.decode("#171925"));
        buttonFive.setBackground(Color.decode("#171925"));
        buttonSix.setBackground(Color.decode("#171925"));
        buttonSeven.setBackground(Color.decode("#171925"));
        buttonEight.setBackground(Color.decode("#171925"));
        buttonNine.setBackground(Color.decode("#171925"));
        buttonTen.setBackground(Color.decode("#171925"));
        buttonX.setBackground(Color.decode("#171925"));
        buttonClear.setBackground(Color.decode("#171925"));
        buttonOk.setBackground(Color.decode("#171925"));
        buttonJud.setBackground(Color.decode("#171925"));
        buttonDel.setBackground(Color.decode("#171925"));
        
        
        //add button hover cursor
        JButton[] bttn = new JButton[]{button_search, button_member, button_close, button_cancel, button_delete, button_edit,
        buttonOne,buttonTow, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonTen, buttonDel, buttonX, buttonClear, buttonOk};
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
        panel_right.setPreferredSize(new Dimension(400,0));
//        panelcal.setPreferredSize(new Dimension(300,0));
        txt_bill.setPreferredSize(new Dimension(600,40));
        setVisible(true);
    }
}
