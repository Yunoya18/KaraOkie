/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author mansu
 */
import database.getConnection;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Map;
import javax.swing.table.*;
import karaokie.Menu.Food;
import karaokie.addFood.ImageRenderer;
import karaokie.room.*;

public class transaction extends JPanel implements ActionListener {
    private RoundedPanel panel_left, cash_img, credit_img;
    private JPanel panel_main, panel_right, panel_r_on, panel_r_down, panel_bn_on, panel_bn_down, panel_bn1, panelcal, panelcal2, panel_empty, panel_empty2, panel_empty3, panel_empty4, panel_empty5, panel_empty6, panel_empty7, panel_empty8, panelcal2_on;
    private JLabel panel_minimain, left_pa, cal_img, txt_cash, txt_credit;
//    private JTextField  txt_cash, txt_credit;
    private static JTable table;
    private JComboBox<String> bill_num;
    private JButton button_search, button_member, button_close, button_cancel, button_delete, button_edit, buttonOne, buttonTow, buttonThree, buttonFour,
            buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonTen, buttonX, buttonClear, buttonOk, buttonJud, buttonDel;
    private DefaultTableModel m;
    private JScrollPane sc;
    private String keyRoom;
    private double total;

    public transaction() {
        //Set up
        Controller.ts = this;

        // JTable Setup
        m = new DefaultTableModel(new Object[]{"Name", "Amount", "Price"}, 0) {
            @Override
            public Class<?> getColumnClass(int ci) {
                return ci == 0 ? ImageIcon.class : Object.class;
            }
        };

        table = new JTable(m);

        // Set custom cell renderer for the image column
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());

        // Set row and column size
        table.setRowHeight(100);
        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);

        //t.setEnabled(false);
        table.getTableHeader().setEnabled(false);
        table.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 12));
        table.getTableHeader().setForeground(Color.decode("#A6ADCE"));
        table.setForeground(Color.decode("#535870"));
        table.setGridColor(Color.decode("#E5E5E5"));
        sc = new JScrollPane(table);
        sc.setPreferredSize(new Dimension(700, 560));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        panel_main = new JPanel(new BorderLayout());

        setLayout(new BorderLayout(0, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel_left = new RoundedPanel(20, 20, 700, 500, Color.decode("#282B3A"), 1.0f, 10);
        panel_right = new JPanel(new GridLayout(2, 1));
        panel_r_on = new JPanel(new BorderLayout());
        panel_r_down = new JPanel(new BorderLayout());
        panel_bn_on = new JPanel(new BorderLayout());
        panel_bn_down = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel_bn_down.setPreferredSize(new Dimension(400, 130));
        panel_bn1 = new JPanel(new GridLayout(2, 3));

        panelcal = new JPanel(new GridLayout(4, 3));
        panelcal2 = new JPanel(new GridLayout(2, 1));
        panelcal2_on = new JPanel(new GridLayout(2, 1));
        panel_empty = new JPanel();
        panel_empty2 = new JPanel();
        panel_empty3 = new JPanel();
        panel_empty4 = new JPanel();
        panel_empty5 = new JPanel();
        panel_empty6 = new JPanel();
        panel_empty7 = new JPanel();
        panel_empty8 = new JPanel();
        bill_num = new JComboBox<>();
        bill_num.setFont(new Font("Montserrat", Font.BOLD, 12));

        button_search = new JButton();
        button_member = new JButton();
        button_close = new JButton();
        button_cancel = new JButton();
        button_delete = new JButton();
        button_edit = new JButton();

        panel_bn1.add(button_search);

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

        txt_cash = new JLabel();
        txt_credit = new JLabel();
        txt_cash.setFont(new Font("Montserrat", Font.BOLD, 12));
        txt_credit.setFont(new Font("Montserrat", Font.BOLD, 12));


//        setBorder
//        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
// import local img
        ImageIcon mini = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 18 (1).png");
        Image min = mini.getImage().getScaledInstance(1150, 650, Image.SCALE_SMOOTH);
        Icon minimain = new ImageIcon(min);
        ImageIcon l = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 29.png");
        Image lef = l.getImage().getScaledInstance(680, 600, Image.SCALE_SMOOTH);
        Icon left = new ImageIcon(lef);
        ImageIcon bl = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 30.png");
        Image bill = bl.getImage().getScaledInstance(600, 40, Image.SCALE_SMOOTH);
        Icon billtxt = new ImageIcon(bill);
        ImageIcon sr = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/ComingSoon.png");
        Image srch = sr.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon search = new ImageIcon(srch);
        ImageIcon cl = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 21.png");
        Image cls = cl.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon close = new ImageIcon(cls);
        ImageIcon cn = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/QR.png");
        Image can = cn.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon cancel = new ImageIcon(can);
        ImageIcon dl = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/ComingSoon.png");
        Image del = dl.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon delete = new ImageIcon(del);
        ImageIcon ed = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/ComingSoon.png");
        Image edi = ed.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        Icon edit = new ImageIcon(edi);
        ImageIcon ca = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 61.png");
        Image ch = ca.getImage().getScaledInstance(400, 60, Image.SCALE_SMOOTH);
        Icon cash = new ImageIcon(ch);
        ImageIcon cr = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 61.png");
        Image cd = cr.getImage().getScaledInstance(400, 60, Image.SCALE_SMOOTH);
        Icon credit = new ImageIcon(cd);

        
        int scheight = screenSize.height/2 - 50;

        
        ImageIcon ci = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 34.png");
        Image cim = ci.getImage().getScaledInstance(380, scheight, Image.SCALE_SMOOTH);
        Icon calim = new ImageIcon(cim);

//        import img cal
        ImageIcon ze = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 38.png");
        Image zr = ze.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon zero = new ImageIcon(zr);
        ImageIcon on = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 39.png");
        Image oon = on.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon one = new ImageIcon(oon);
        ImageIcon tt = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 44.png");
        Image tw = tt.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon two = new ImageIcon(tw);
        ImageIcon the = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 35.png");
        Image th = the.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon three = new ImageIcon(th);
        ImageIcon fo = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 40.png");
        Image foo = fo.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon four = new ImageIcon(foo);
        ImageIcon fi = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 43.png");
        Image fii = fi.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon five = new ImageIcon(fii);
        ImageIcon ss = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 34.png");
        Image si = ss.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon six = new ImageIcon(si);
        ImageIcon sv = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 41.png");
        Image se = sv.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon seven = new ImageIcon(se);
        ImageIcon eg = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 42.png");
        Image ei = eg.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon eight = new ImageIcon(ei);
        ImageIcon ni = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 33.png");
        Image ne = ni.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon nine = new ImageIcon(ne);
        ImageIcon jd = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 37.png");
        Image jj = jd.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon judd = new ImageIcon(jj);
        ImageIcon cc = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 36.png");
        Image ccc = cc.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon cccc = new ImageIcon(ccc);
        ImageIcon xx = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 31.png");
        Image xxx = xx.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon xxxx = new ImageIcon(xxx);
        ImageIcon bc = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 29.png");
        Image bac = bc.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
        Icon back = new ImageIcon(bac);
        ImageIcon oo = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 32.png");
        Image kk = oo.getImage().getScaledInstance(70, 130, Image.SCALE_SMOOTH);
        Icon okk = new ImageIcon(kk);

//        miport img
//        ImageIcon mini = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 18 (1).png");
//        Image min = mini.getImage().getScaledInstance(1150, 650, Image.SCALE_SMOOTH);
//        Icon minimain = new ImageIcon(min);
//        ImageIcon l = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 29.png");
//        Image lef = l.getImage().getScaledInstance(680, 600, Image.SCALE_SMOOTH);
//        Icon left = new ImageIcon(lef);
//        ImageIcon bl = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 30.png");
//        Image bill = bl.getImage().getScaledInstance(600, 40, Image.SCALE_SMOOTH);
//        Icon billtxt = new ImageIcon(bill);
//        ImageIcon sr = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 13.png");
//        Image srch = sr.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
//        Icon search = new ImageIcon(srch);
//        ImageIcon mm = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 19.png");
//        Image mem = mm.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
//        Icon member = new ImageIcon(mem);
//        ImageIcon cl = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 21.png");
//        Image cls = cl.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
//        Icon close = new ImageIcon(cls);
//        ImageIcon cn = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 22.png");
//        Image can = cn.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
//        Icon cancel = new ImageIcon(can);
//        ImageIcon dl = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 24.png");
//        Image del = dl.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
//        Icon delete = new ImageIcon(del);
//        ImageIcon ed = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Group 26.png");
//        Image edi = ed.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
//        Icon edit = new ImageIcon(edi);
//        ImageIcon ca = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 61.png");
//        Image ch = ca.getImage().getScaledInstance(400, 60, Image.SCALE_SMOOTH);
//        Icon cash = new ImageIcon(ch);
//        ImageIcon cr = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 61.png");
//        Image cd = cr.getImage().getScaledInstance(400, 60, Image.SCALE_SMOOTH);
//        Icon credit = new ImageIcon(cd);
//        ImageIcon ci = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\karaOkie\\src\\karaokie\\Rectangle 34.png");
//        Image cim = ci.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
//        Icon calim = new ImageIcon(cim);
//        
////        import img cal
//        ImageIcon ze = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 38.png");
//        Image zr = ze.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon zero = new ImageIcon(zr);
//        ImageIcon on = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 39.png");
//        Image oon = on.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon one = new ImageIcon(oon);
//        ImageIcon tt = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 44.png");
//        Image tw = tt.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon two = new ImageIcon(tw);
//        ImageIcon the = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 35.png");
//        Image th = the.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon three = new ImageIcon(th);
//        ImageIcon fo = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 40.png");
//        Image foo = fo.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon four = new ImageIcon(foo);
//        ImageIcon fi = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 43.png");
//        Image fii = fi.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon five = new ImageIcon(fii);
//        ImageIcon ss = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 34.png");
//        Image si = ss.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon six = new ImageIcon(si);
//        ImageIcon sv = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 41.png");
//        Image se = sv.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon seven = new ImageIcon(se);
//        ImageIcon eg = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 42.png");
//        Image ei = eg.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon eight = new ImageIcon(ei);
//        ImageIcon ni = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 33.png");
//        Image ne = ni.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon nine = new ImageIcon(ne);
//        ImageIcon jd = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 37.png");
//        Image jj = jd.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon judd = new ImageIcon(jj);
//        ImageIcon cc = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 36.png");
//        Image ccc = cc.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon cccc = new ImageIcon(ccc);
//        ImageIcon xx = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 31.png");
//        Image xxx =xx.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon xxxx = new ImageIcon(xxx);
//        ImageIcon bc = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 29.png");
//        Image bac = bc.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
//        Icon back = new ImageIcon(bac);
//        ImageIcon oo = new ImageIcon("C:\\Users\\aompp\\OneDrive\\Documents\\NetBeansProjects\\project\\src\\Group 32.png");
//        Image kk = oo.getImage().getScaledInstance(80, 140, Image.SCALE_SMOOTH);
//        Icon okk = new ImageIcon(kk);
//        bill_num.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));
        

        bill_num.setPreferredSize(new Dimension(700, 30));
        panel_minimain = new JLabel(minimain);

        panel_minimain.setLayout(
                new BorderLayout(0,0));
        panel_minimain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        left_pa = new JLabel(left);

        left_pa.setLayout(new BorderLayout());
        
        add(panel_minimain, BorderLayout.CENTER);

        left_pa.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cal_img = new JLabel(calim);

        cal_img.setLayout(new BorderLayout(0, 0));
        cal_img.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cash_img = new RoundedPanel(20, 20, 370, 50, Color.decode("#171925"), 1.0f, 10);
        credit_img = new RoundedPanel(20, 20, 370, 50, Color.decode("#171925"), 1.0f, 10);
        JPanel c2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        JPanel cr2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        c2.setPreferredSize(new Dimension(350, 40));
        cr2.setPreferredSize(new Dimension(350, 40));
        c2.setBackground(Color.decode("#171925"));
        cr2.setBackground(Color.decode("#171925"));
        c2.add(txt_cash);
        cr2.add(txt_credit);
        
        cash_img.add(c2);
        credit_img.add(cr2);

        txt_cash.setBackground(Color.decode("#171925"));
        txt_credit.setBackground(Color.decode("#171925"));
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

        panel_left.add(bill_num);

        panel_left.add(sc);

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
        button_search.setBorderPainted(
                false);
        button_search.setFocusPainted(
                false);
        button_member.setBorderPainted(
                false);
        button_member.setFocusPainted(
                false);
        button_cancel.setBorderPainted(
                false);
        button_cancel.setFocusPainted(
                false);
        button_close.setBorderPainted(
                false);
        button_close.setFocusPainted(
                false);
        button_delete.setBorderPainted(
                false);
        button_delete.setFocusPainted(
                false);
        button_edit.setBorderPainted(
                false);
        button_edit.setFocusPainted(
                false);

        buttonOne.setFocusPainted(
                false);
        buttonTow.setFocusPainted(
                false);
        buttonThree.setFocusPainted(
                false);
        buttonFour.setFocusPainted(
                false);
        buttonFive.setFocusPainted(
                false);
        buttonSix.setFocusPainted(
                false);
        buttonSeven.setFocusPainted(
                false);
        buttonEight.setFocusPainted(
                false);
        buttonNine.setFocusPainted(
                false);
        buttonTen.setFocusPainted(
                false);
        buttonX.setFocusPainted(
                false);
        buttonClear.setFocusPainted(
                false);
        buttonOk.setFocusPainted(
                false);
        buttonJud.setFocusPainted(
                false);
        buttonDel.setFocusPainted(
                false);

        buttonOne.setBorderPainted(
                false);
        buttonTow.setBorderPainted(
                false);
        buttonThree.setBorderPainted(
                false);
        buttonFour.setBorderPainted(
                false);
        buttonFive.setBorderPainted(
                false);
        buttonSix.setBorderPainted(
                false);
        buttonSeven.setBorderPainted(
                false);
        buttonEight.setBorderPainted(
                false);
        buttonNine.setBorderPainted(
                false);
        buttonTen.setBorderPainted(
                false);
        buttonX.setBorderPainted(
                false);
        buttonClear.setBorderPainted(
                false);
        buttonOk.setBorderPainted(
                false);
        buttonJud.setBorderPainted(
                false);
        buttonDel.setBorderPainted(
                false);

        //button add image
        button_search.setIcon(search);

        // close
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

        txt_cash.setForeground(Color.WHITE);

        txt_credit.setForeground(Color.WHITE);

        bill_num.setBackground(Color.decode("#A6ADCE"));
        bill_num.setForeground(Color.decode("#A6ADCE"));

        // button lis
        button_close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Close clicked!"); // For demonstration, print message to console
                getConnection.addAmount(total);

                Map<String, Map<Food, Integer>> roomMenu = Controller.getRoomMenuMap();
                roomMenu.remove(keyRoom);
                Controller.setMenu(null);

                Controller.reCard("tab2", "tab1");
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
            }
        });
        button_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/QRcode.png"));
                JScrollPane scrollPane = new JScrollPane(label);

                JOptionPane.showMessageDialog(null, scrollPane, "QR CODE", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        //add button hover cursor
        JButton[] bttn = new JButton[]{button_search, button_member, button_close, button_cancel, button_delete, button_edit,
            buttonOne, buttonTow, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonTen, buttonDel, buttonX, buttonClear, buttonOk};
        for (JButton button : bttn) {
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
//                            ImageIcon hoverIcon = new ImageIcon(cl.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
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

        buttonOne.addActionListener(
                this);
        buttonTow.addActionListener(
                this);
        buttonThree.addActionListener(
                this);
        buttonFour.addActionListener(
                this);
        buttonFive.addActionListener(
                this);
        buttonSix.addActionListener(
                this);
        buttonSeven.addActionListener(
                this);
        buttonEight.addActionListener(
                this);
        buttonNine.addActionListener(
                this);
        buttonTen.addActionListener(
                this);
        buttonX.addActionListener(
                this);
        buttonClear.addActionListener(
                this);
        buttonOk.addActionListener(
                this);
        buttonJud.addActionListener(
                this);
        buttonDel.addActionListener(
                this);

//        txt_cash.setEditable(false);
//        txt_credit.setEditable(false);
        panel_empty.setPreferredSize(
                new Dimension(100, 50));
        panel_empty2.setPreferredSize(
                new Dimension(100, 50));
        panel_empty3.setPreferredSize(
                new Dimension(100, 50));
        panel_empty4.setPreferredSize(
                new Dimension(100, 50));
        panel_empty5.setPreferredSize(
                new Dimension(100, 30));
        panel_empty6.setPreferredSize(
                new Dimension(100, 80));
        panel_empty7.setPreferredSize(
                new Dimension(70, 50));
        panel_empty8.setPreferredSize(
                new Dimension(70, 50));
        panel_bn_down.setPreferredSize(
                new Dimension(250, 125));
        panel_main.setPreferredSize(
                new Dimension(1100, 600));
        panel_right.setPreferredSize(
                new Dimension(400, 0));
//        panelcal.setPreferredSize(new Dimension(300,0));
        setVisible(true);

        // comboBox Zone
        bill_num.addItemListener(new ItemListener() {
            Map<String, Map<Food, Integer>> temp = Controller.getRoomMenuMap();

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) bill_num.getSelectedItem();

                    // Selected item: Order Room : 2
                    for (String key : temp.keySet()) {
//                        System.out.println("Selected item: Order Room : " + key);
//                        System.out.println(selectedItem);
                        if (("Order Room : " + key).equals(selectedItem)) {
                            keyRoom = key;
                            reRow();
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            Map<Food, Integer> temp2 = (Map<Food, Integer>) temp.get(key);

                            total = 0;
                            for (Food f : temp2.keySet()) {
                                String name = f.getName();
                                String amount = temp2.get(f) + "";
                                double price = f.getPrice();
                                model.addRow(new Object[]{name, amount, price + " THB"});

                                total += price * Integer.parseInt(amount);
                            }
                            txt_credit.setText(total + "");
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new transaction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(buttonOne)) {
            txt_cash.setText(txt_cash.getText() + "1");
        } else if (e.getSource().equals(buttonTow)) {
            txt_cash.setText(txt_cash.getText() + "2");
        } else if (e.getSource().equals(buttonThree)) {
            txt_cash.setText(txt_cash.getText() + "3");
        } else if (e.getSource().equals(buttonFour)) {
            txt_cash.setText(txt_cash.getText() + "4");
        } else if (e.getSource().equals(buttonFive)) {
            txt_cash.setText(txt_cash.getText() + "5");
        } else if (e.getSource().equals(buttonSix)) {
            txt_cash.setText(txt_cash.getText() + "6");
        } else if (e.getSource().equals(buttonSeven)) {
            txt_cash.setText(txt_cash.getText() + "7");
        } else if (e.getSource().equals(buttonEight)) {
            txt_cash.setText(txt_cash.getText() + "8");
        } else if (e.getSource().equals(buttonNine)) {
            txt_cash.setText(txt_cash.getText() + "9");
        } else if (e.getSource().equals(buttonTen)) {
            txt_cash.setText(txt_cash.getText() + "0");
        } else if (e.getSource().equals(buttonX)) {
            txt_cash.setText("");
        } else if (e.getSource().equals(buttonClear)) {
            txt_cash.setText("");
        } else if (e.getSource().equals(buttonDel)) {
            if (!txt_cash.getText().isEmpty()) {
                txt_cash.setText(txt_cash.getText().substring(0, txt_cash.getText().length() - 1));

            }

        } else if (e.getSource().equals(buttonOk)) {
            JOptionPane.showMessageDialog(null, "Change is " + (Integer.parseInt(txt_cash.getText()) - total));
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                setIcon((ImageIcon) value);
                setText(null);
            } else {
                setText((value == null) ? "" : value.toString());
                setIcon(null);
            }
            return this;
        }
    }

    // JTable Zone
    public static void addRow(Object[] dataRow) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(dataRow);
//        System.out.println("e");

    }

    public void reRow() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowCount = model.getRowCount();
            // Remove rows from the end to avoid index issues
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
        } catch (ClassCastException i) {
            i.printStackTrace();
        }

    }

    public void addOrder(String name) {
        boolean f = true;
//        for (int i = 0; i < bill_num.getItemCount(); i++) {
//            System.out.println("do doodo");
//            if (("Order Room : " + name).equals(bill_num.getItemAt(i))){
//                f = false;
//            }
//        }

        if (f) {
            bill_num.addItem("Order Room : " + name);
        }
    }

    public void reOrder() {
        bill_num.removeAllItems();
    }
}
