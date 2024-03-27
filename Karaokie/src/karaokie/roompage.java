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
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
//import java.util.ArrayList;
public class roompage extends JPanel implements ActionListener{
    private CardLayout card;
    private JButton room, order, report, edit, cursor, move, add, delete;
    private JPanel tablist, down1, down2, down3, wp, tool, cen, leftcom, func, up, editpa, sandbox;
    private JMenuItem rect1, rect2;
    private JPopupMenu create;
    private JComboBox type;
    private JTextField search;
//    private Point firstp;
    private boolean movin = false;
    private boolean del = false;
    
//    JLabel box1;
    public roompage(){
        
//        firstp = new Point();
        sandbox = new JPanel(new FlowLayout());
        search = new JTextField();
        setLayout(new BorderLayout(0,0));
        leftcom = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        tool = new JPanel();
        func = new JPanel();
        up = new JPanel();
        room = new JButton();
        order = new JButton();
        report = new JButton();
        cen = new JPanel(new GridLayout(3,1));
        String[] roomcat = {"Big", "Small"};
        type = new JComboBox(roomcat);
        down1 = new JPanel();
        down2 = new JPanel();
        down3 = new JPanel();
        card = new CardLayout();
        tablist = new JPanel(card);
        edit = new JButton();
        cursor = new JButton();
        move = new JButton();
        add = new JButton();
        delete = new JButton();
        create = new JPopupMenu();
        rect1 = new JMenuItem("rect1"); rect2 = new JMenuItem("rect2");
        editpa = new JPanel(new FlowLayout(FlowLayout.CENTER,0,5));
        
        
        editpa.add(edit);
        editpa.setBackground(Color.decode("#535870"));
        
        create.add(rect1);
        create.add(rect2);
        create.setPreferredSize(new Dimension(90,60));
        
        wp = new JPanel(new BorderLayout(0,0));
        
        
//      wp.set
        wp.setBackground(Color.decode("#535870"));
        wp.setPreferredSize(new Dimension(850,120));
        
//      workspace add
        wp.add(editpa, BorderLayout.EAST);
        wp.add(sandbox, BorderLayout.CENTER);
        
        //edit button
        edit.setPreferredSize(new Dimension(80,80));
        edit.setBackground(Color.decode("#535870"));
        edit.setBorderPainted(false);
        edit.setFocusPainted(false);
        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 11.png");
        Image img1 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Icon icon1 = new ImageIcon(img1);
        edit.setIcon(icon1);
        
        leftcom.add(tool);
        leftcom.add(func);
        
        
        
        sandbox.setBackground(Color.decode("#535870"));
        sandbox.setLayout(null);
        sandbox.setPreferredSize(new Dimension(700,720));
        
        //add button
        
        
        up.setLayout(new BorderLayout(0,0));
        down1.setLayout(new FlowLayout());
        down2.setLayout(new FlowLayout());
        down3.setLayout(new FlowLayout());
        add(leftcom, BorderLayout.WEST);
        add(wp, BorderLayout.CENTER);
        
        tool.setPreferredSize(new Dimension(50,720));
        tool.setBackground(Color.decode("#171925"));
        tool.setLayout(new FlowLayout(FlowLayout.CENTER));
        tool.add(cursor);
        tool.add(move);
        tool.add(add);
        tool.add(delete);
        tool.setVisible(false);
        
        cursor.setPreferredSize(new Dimension(50,50));
        move.setPreferredSize(new Dimension(50,50));
        add.setPreferredSize(new Dimension(50,50));
        delete.setPreferredSize(new Dimension(50,50));
        
        
        cursor.setBorderPainted(false);
        cursor.setFocusPainted(false);
        move.setBorderPainted(false);
        move.setFocusPainted(false);
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        delete.setBorderPainted(false);
        delete.setFocusPainted(false);
        
        cursor.setBackground(Color.decode("#171925"));
        move.setBackground(Color.decode("#171925"));
        add.setBackground(Color.decode("#171925"));
        delete.setBackground(Color.decode("#171925"));
        
        ImageIcon t1 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/selection.png");
        Image to1 = t1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Icon tool1 = new ImageIcon(to1);
        ImageIcon t2 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/move-selector.png");
        Image to2 = t2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon tool2 = new ImageIcon(to2);
        ImageIcon t3 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/add.png");
        Image to3 = t3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Icon tool3 = new ImageIcon(to3);
        ImageIcon t4 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/delete.png");
        Image to4 = t4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Icon tool4 = new ImageIcon(to4);
        cursor.setIcon(tool1);
        move.setIcon(tool2);
        add.setIcon(tool3);
        delete.setIcon(tool4);

        
        func.setBackground(Color.decode("#282B3A"));
        func.setLayout(new BorderLayout(0,0));
        func.add(up, BorderLayout.NORTH);
        func.add(tablist, BorderLayout.CENTER);
        func.setPreferredSize(new Dimension(370, 720));
        
        //add up
        up.add(search, BorderLayout.NORTH);
        up.add(cen, BorderLayout.CENTER);
        
        //ad select type button
        cen.add(room);
        cen.add(order);
        cen.add(report);
        
        
        down1.setBackground(Color.decode("#593D62"));
        down2.setBackground(Color.decode("#593D62"));
        down3.setBackground(Color.decode("#593D62"));
        cen.setBackground(Color.decode("#1C1E27"));
        
        //set upper func
        up.setPreferredSize(new Dimension(200, 200));
        up.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        up.add(type, BorderLayout.SOUTH);
        up.setBackground(Color.decode("#1C1E27"));
        
        cen.setLayout(new FlowLayout());
        
        //set room order report button img
        ImageIcon b1 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 45.png");
        Image bt1 = b1.getImage().getScaledInstance(110, 90, Image.SCALE_SMOOTH);
        Icon bttn1 = new ImageIcon(bt1);
        ImageIcon b2 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 46 (1).png");
        Image bt2 = b2.getImage().getScaledInstance(110, 90, Image.SCALE_SMOOTH);
        Icon bttn2 = new ImageIcon(bt2);
        ImageIcon b3 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 47.png");
        Image bt3 = b3.getImage().getScaledInstance(110, 90, Image.SCALE_SMOOTH);
        Icon bttn3 = new ImageIcon(bt3);
        room.setIcon(bttn1);
        order.setIcon(bttn2);
        report.setIcon(bttn3);
        room.setBackground(Color.decode("#A6ADCE"));
        order.setBackground(Color.decode("#A6ADCE"));
        report.setBackground(Color.decode("#A6ADCE"));
        
        room.setBorderPainted(false);
        order.setBorderPainted(false);
        report.setBorderPainted(false);
        
        //set button border in out
        
        
        rect1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               if(tool.isVisible()){
               ImageIcon sq = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 63.png");
               Image squ = sq.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
               ImageIcon square = new ImageIcon(squ);
               JLabel box = new JLabel(square);
               box.setVisible(true);
               box.setBounds(250,300,90,90);
               box.setBackground(Color.WHITE);
                sandbox.add(box);               
                sandbox.revalidate();
                sandbox.repaint();
                
               // add room in roompage when create box
               ImageIcon rl = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 35.png");
               Image r = rl.getImage().getScaledInstance(300,100,Image.SCALE_SMOOTH);
               ImageIcon rol = new ImageIcon(r);
               down1.add(new JLabel(rol));
             
               // make box moveable
               box.addMouseMotionListener(new MouseAdapter(){
                   @Override
                   public void mousePressed(MouseEvent e){
                       if(tool.isVisible() && movin){
                           System.out.println("8888");

                       }
                       
                   }
                   @Override
                   public void mouseDragged(MouseEvent e){
                       if(tool.isVisible() && movin){

                       Point newLocation = box.getLocation();
                         newLocation.translate(e.getX()-45, e.getY()-45);
                         box.setLocation(newLocation);
                       }
                   }
                   @Override
                   public void mouseClicked(MouseEvent e){
                       if(tool.isVisible() && del){
                           JOptionPane.showMessageDialog(null, "Clicked ");
                       }
                   }
//                   @Override
//                public void mouseDragged(MouseEvent e){
//                    Point locate = SwingUtilities.convertPoint(box, e.getPoint(), box.getParent());
////                        if(box.getParent().getBounds().contains(locate)){
//                                Point newlocate = box.getLocation();
//                                newlocate.translate(locate.x - firstp.x, locate.y - firstp.y);
//                                newlocate.x = Math.max(newlocate.x, 0);
//                                newlocate.y = Math.max(newlocate.y, 0);
//                                newlocate.x = Math.min(newlocate.x, box.getParent().getWidth()-box.getWidth());
//                                newlocate.y = Math.min(newlocate.y, box.getParent().getHeight()-box.getHeight());
//                                box.setLocation(newlocate);
//                                firstp = locate;
////                            }
//                }
//                @Override
//                public void mousePressed(MouseEvent e) {
//                firstp = SwingUtilities.convertPoint(box, e.getPoint(), box.getParent());
//                    }
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                firstp = null;
//                    }
//              @Override
//                    public void mouseClicked(MouseEvent e) {
//                        JOptionPane.showMessageDialog(null, "Clicked ");
//                    }
            });}
                else{
                   
               }
            }
        });
        
        JButton[] group = {room, order, report,edit, cursor, move, add, delete, add};
        for(JButton button : group){
              button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(e.getSource().equals(room)){
                            button.setBorderPainted(true);
                            button.setBorder(new LineBorder(Color.PINK,5));
                        }
                        else if(e.getSource().equals(order)){
                            button.setBorderPainted(true);
                            button.setBorder(new LineBorder(Color.PINK,5));
                        }
                        else if(e.getSource().equals(report)){
                            button.setBorderPainted(true);
                            button.setBorder(new LineBorder(Color.PINK, 5));
                        }
                       
                        else if(e.getSource().equals(cursor)){
                            ImageIcon hoverIcon = new ImageIcon(t1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(move)){
                            ImageIcon hoverIcon = new ImageIcon(t2.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(add)){
                            ImageIcon hoverIcon = new ImageIcon(t3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                            
                        }
                        else if(e.getSource().equals(delete)){
                            ImageIcon hoverIcon = new ImageIcon(t4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        
                        
                        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                       
                    }
                    @Override
                    public void mouseClicked(MouseEvent e){
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        if(e.getSource().equals(room)){
                            button.setBorderPainted(false);
                        }
                        else if(e.getSource().equals(order)){
                            button.setBorderPainted(false);
                        }
                        else if(e.getSource().equals(report)){
                            button.setBorderPainted(false);
                        }
                        
                        else if(e.getSource().equals(cursor)){
                            button.setIcon(tool1);
                        }
                        else if(e.getSource().equals(move)){
                            button.setIcon(tool2);
                        }
                        else if(e.getSource().equals(add)){
                            button.setIcon(tool3);
                            
                        }
                        else if(e.getSource().equals(delete)){
                            button.setIcon(tool4);
                        }
                    }
                });
        }
        
        // change to room order report
        tablist.add(down1, "tab1");
        tablist.add(down2,"tab2");
        tablist.add(down3,"tab3");
        
        //change
        down1.setLayout(new FlowLayout(FlowLayout.CENTER));
        down2.setLayout(new FlowLayout(FlowLayout.CENTER));
        down3.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        
        room.setPreferredSize(new Dimension(100, 100));
        order.setPreferredSize(new Dimension(100, 100));
        report.setPreferredSize(new Dimension(100, 100));
        type.setPreferredSize(new Dimension(120, 30));
        
        room.addActionListener(this);
        order.addActionListener(this);
        report.addActionListener(this);
        edit.addActionListener(this);
        add.addActionListener(this);
        rect1.addActionListener(this);
        rect2.addActionListener(this);
        move.addActionListener(this);
        cursor.addActionListener(this);
        delete.addActionListener(this);
        
        search.setPreferredSize(new Dimension(180, 30));
        setVisible(true);
        
        
        
        
        
//        pm.add(pg);
//        
//        pm.setVisible(true);
//        pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pm.pack();
//        pm.setSize(1280, 720);
        create.setVisible(false);
        create.setBorderPainted(false);
        create.setBackground(Color.decode("#282B3A"));
        rect1.setBackground(Color.decode("#282B3A"));
        rect2.setBackground(Color.decode("#282B3A"));

}
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(room)){
           card.show(tablist, "tab1");
        }
        else if(e.getSource().equals(order)){
           card.show(tablist, "tab2");
        }
        else if(e.getSource().equals(report)){
           card.show(tablist, "tab3");
        }
        else if(e.getSource().equals(edit)){
            
            if(tool.isVisible()){
            tool.setVisible(false);
            func.setVisible(true);
            ImageIcon i1 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 11.png");
            Image img1 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            Icon icon1 = new ImageIcon(img1);
            edit.setIcon(icon1);
            }
            else{
            tool.setVisible(true);
            func.setVisible(false);
            ImageIcon b = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 12.png");
            Image bc = b.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            Icon back = new ImageIcon(bc);
            edit.setIcon(back);
            }
            
        }
        else if(e.getSource().equals(add)){
            if(create.isVisible()){
                create.setVisible(false);
            }else{
                int x = add.getLocation().x;
                int y = add.getLocation().y;
                create.show(wp,x,y);
                create.setVisible(true);
            }
        }
        else if(e.getSource().equals(move)){
            if(movin){
                
            }
            else{
                movin = true;
                System.out.println(movin);
            }
        }
        else if(e.getSource().equals(cursor)){
            if(movin == true){
                movin = false;
            }
            else if(del == true){
                del = false;
            }
        }
        else if(e.getSource().equals(delete)){
            if(del){
                
            }else{
                del = true;
                System.out.println(del);
            }
        }
//        else if(e.getSource().equals(rect1)){
//               
//               box1.addMouseListener(this);
//               box1.addMouseMotionListener(this);
//               ImageIcon sq = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 62.png");
//               Image squ = sq.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
//               ImageIcon square = new ImageIcon(squ);
//               
//               
//               box1 = new JLabel(square);
//               
//               box1.setVisible(true);
//               sandbox.add(box1);
//               box1.setBounds(100,100,250,300);
//               sandbox.revalidate();
//               sandbox.repaint();
//               ImageIcon rl = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 35.png");
//               Image r = rl.getImage().getScaledInstance(200,60,Image.SCALE_SMOOTH);
//               ImageIcon rol = new ImageIcon(r);
//               down1.add(new JLabel(rol));
//        }     
//        else if(e.getSource().equals(rect2)){
//          
//               ImageIcon sq = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 63.png");
//               Image squ = sq.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
//               ImageIcon square = new ImageIcon(squ);
//               
//               JLabel box2 = new JLabel(square);
//               box2.setVisible(true);
//               sandbox.add(box2);
//               box2.setBounds(100,100,250,300);
//               sandbox.revalidate();
//               sandbox.repaint();
//        }
//            
//           
       }


//    @Override
//    public void mouseDragged(MouseEvent e) {
//        Point locate = SwingUtilities.convertPoint(box1, e.getPoint(), box1.getParent());
//        if(box1.getParent().getBounds().contains(locate)){
//        Point newlocate = box1.getLocation();
//        newlocate.translate(locate.x - firstp.x, locate.y - firstp.y);
//        newlocate.x = Math.max(newlocate.x, 0);
//        newlocate.y = Math.max(newlocate.y, 0);
//        newlocate.x = Math.min(newlocate.x, box1.getParent().getWidth()-box1.getWidth());
//        newlocate.y = Math.min(newlocate.y, box1.getParent().getWidth()-box1.getWidth());
//        box1.setLocation(newlocate);
//        firstp = locate;
//    }
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        firstp = SwingUtilities.convertPoint(box1, e.getPoint(), box1.getParent());
//    }
////
////    @Override
////    public void mouseReleased(MouseEvent e) {
////        firstp = null;
////    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        
//    }

    
}

