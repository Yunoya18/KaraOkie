/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author Tiraqmisu
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.*;
import karaokie.Menu.Food;
import static karaokie.Menu.Menus.map;
import karaokie.Menu.roomMenu;

public class cartUser extends JPanel implements ActionListener {

    private RoundedPanel out, in;
    private JPanel top, bot, order, blank, blank2;
    private JLabel id, room, lis, epr, etot, total;
    private JTextField count;
    private JButton co;
    private JScrollPane sc;
    private Box mid;
    protected Map<Food, Integer> map;
    Map<Food, Integer> mapfortran;
    private double totalmoney;
    private roomMenu rom; // 0000

    public cartUser() {
        rom = new roomMenu(); // 9999 (moved here cause getRoomFromCart() have to use it)
        map = new HashMap<>();
        mapfortran = new HashMap<>();
        setBackground(Color.decode("#535870"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 27, 27));

//      outside box
        out = new RoundedPanel(20, 20, 1000, 600, Color.decode("#282B3A"), 1.0f, 21);

//      inside box
        in = new RoundedPanel(20, 20, 950, 510, Color.decode("#A6ADCE"), 1.0f, 21);

//      button
        co = new JButton("Confirm Order");

//      top panel
        top = new JPanel();
        top.setPreferredSize(new Dimension(930, 30));
        top.setBackground(Color.decode("#A6ADCE"));

        JPanel topgrid = new JPanel(new GridLayout(1, 2));
        topgrid.setPreferredSize(new Dimension(920, 40));
        topgrid.setBackground(Color.decode("#A6ADCE"));

        id = new JLabel("Order ID : ");
        id.setForeground(Color.decode("#282B3A"));
        id.setBackground(Color.decode("#A6ADCE"));

        JPanel pid = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pid.setBackground(Color.decode("#A6ADCE"));
        JPanel proom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        proom.setBackground(Color.decode("#A6ADCE"));

        room = new JLabel("Room : "+Loginpage.nam);
        room.setForeground(Color.decode("#282B3A"));
        room.setBackground(Color.decode("#A6ADCE"));

        pid.add(id);
        proom.add(room);

        topgrid.add(pid);
        topgrid.add(proom);
        top.add(topgrid);

//      mid panel
//        mid.removeAll();
        mid = Box.createVerticalBox();
        mid.removeAll();
        mid.setBackground(Color.decode("#A6ADCE"));

        sc = new JScrollPane(mid);
        sc.setPreferredSize(new Dimension(930, 370));
        sc.setBorder(BorderFactory.createLineBorder(Color.decode("#A6ADCE")));
        sc.setBackground(Color.decode("#A6ADCE"));
        sc.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.decode("#282B3A")));

        this.loadMap();
        Set<Food> foodSet = map.keySet();
        for (Food food : foodSet) {
            if (food.getName().equals("")) {
                System.out.println("e");
            } else {
                String name = food.getName();
                String price = String.valueOf(food.getPrice());
                String piece = String.valueOf(map.get(food));
                System.out.println(name);
                this.addOrder(name, price, piece);
            }
        }

//      bottom panel
        bot = new JPanel();
        bot.setPreferredSize(new Dimension(930, 50));
        bot.setBackground(Color.decode("#A6ADCE"));
        bot.setLayout(new FlowLayout(FlowLayout.RIGHT));

//        this.retotal();
//        total = new JLabel("Total : "+totalmoney);
//        bot.add(total);
        total = new JLabel();
        bot.add(total);
        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(this::retotal);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

//        new Thread(() -> {
//            while (true) {
//                SwingUtilities.invokeLater(this::remid);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }).start();
        in.add(top);
        in.add(sc);
        in.add(bot);
        out.add(in);
        out.add(co);
        add(out);

        co.addActionListener(this);

        // 0000
//        rom.getroomNumber();
    }

    public void loadMap() {

        File file = new File("ro.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("ro.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();
                System.out.println(map);

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }

        } else {
            map.put(new Food("", null, 0.0, ""), 0);
        }
    }
//    String order, String price, String piece, String total

    public void addOrder(String name, String price, String piece) {
        JButton del = new JButton();
        ImageIcon i = new ImageIcon(System.getProperty("user.dir") + "/src/karaokie/image/minus.png");
        Image im = i.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(im);
        del.setIcon(icon);
        del.setBorderPainted(false);
        del.setFocusPainted(false);
        del.setBackground(Color.decode("#A6ADCE"));

        lis = new JLabel("Name:  " + name);
        lis.setFont(new Font("Montserrat", Font.BOLD, 12));
        lis.setForeground(Color.decode("#282B3A"));
        lis.setBackground(Color.decode("#A6ADCE"));

        blank = new JPanel();
        blank.setPreferredSize(new Dimension(570, 5));
        blank.setBackground(Color.decode("#A6ADCE"));

        epr = new JLabel("Price:  " + price + " x");
        epr.setFont(new Font("Montserrat", Font.BOLD, 12));
        epr.setForeground(Color.decode("#282B3A"));
        epr.setBackground(Color.decode("#A6ADCE"));

//      number of order that can edit
        count = new JTextField();
        count.setFont(new Font("Montserrat", Font.BOLD, 12));
        count.setText(piece);
        count.setPreferredSize(new Dimension(30, 20));
        count.setForeground(Color.decode("#282B3A"));
        count.setBackground(Color.decode("#CFD7FA"));
        count.setBorder(BorderFactory.createLineBorder(Color.decode("#A6ADCE")));

        blank2 = new JPanel();
        blank2.setPreferredSize(new Dimension(40, 5));
        blank2.setBackground(Color.decode("#A6ADCE"));

        etot = new JLabel(" THB");
        etot.setFont(new Font("Montserrat", Font.BOLD, 12));
        etot.setForeground(Color.decode("#282B3A"));
        etot.setBackground(Color.decode("#A6ADCE"));

        order = new JPanel(new FlowLayout(FlowLayout.LEFT));
        order.setBackground(Color.decode("#A6ADCE"));
        order.add(del);
        order.add(lis);
        order.add(blank);
        order.add(epr);
        order.add(count);
        order.add(blank2);
        order.add(etot);
        totalmoney += Double.parseDouble(price) * Integer.parseInt(piece);
        mid.add(order);

        JButton g[] = new JButton[]{del, co};
        for (JButton button : g) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });
        }
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "Are you sure that you want remove?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    Container parent = del.getParent();
                    if (parent instanceof JPanel) {
                        JPanel orderPanel = (JPanel) parent;
                        mid.remove(orderPanel);
                        mid.revalidate();
                        mid.repaint();
                    }
                    mid.getParent().setBackground(Color.decode("#A6ADCE"));
                    map.clear();
                    Component[] components = mid.getComponents();
                    for (Component component : components) {
                        if (component instanceof JPanel) {
                            JPanel orderPanel = (JPanel) component;
                            String name = "";
                            String price = "";
                            String piece = "";

                            for (Component innerComponent : orderPanel.getComponents()) {
                                if (innerComponent instanceof JLabel) {
                                    JLabel label = (JLabel) innerComponent;
                                    if (label.getText().startsWith("Name: ")) {
                                        name = label.getText().substring(7);
                                    } else if (label.getText().startsWith("Price: ")) {
                                        price = label.getText().substring(8);
                                    }
                                } else if (innerComponent instanceof JTextField) {
                                    JTextField countField = (JTextField) innerComponent;
                                    piece = countField.getText();
                                }
                            }
                            //String name, Icon image, double price, String type 
                            String priceText = price;
                            double priceValue = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
                            map.put(new Food(name, null, priceValue, "tran"), Integer.valueOf(piece));
                        }
                    }
                    try (FileOutputStream fout = new FileOutputStream("ro.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

                        oout.writeObject(map);

                    } catch (IOException ex) {

                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(co)) {
            int resp = JOptionPane.showConfirmDialog(this, "Are you sure that you want to Confirm Order", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                setDefaultText<String, String> txt = new setDefaultText<>("Order", Loginpage.nam);
                JOptionPane.showMessageDialog(null, txt);
//               rom = new roomMenu(); // 9999 (moved to default constructor cause getRoomFromCart() have to use it)
                Component[] components = mid.getComponents();
                for (Component component : components) {
                    if (component instanceof JPanel) {
                        JPanel orderPanel = (JPanel) component;
                        String name = "";
                        String price = "";
                        String piece = "";

                        for (Component innerComponent : orderPanel.getComponents()) {
                            if (innerComponent instanceof JLabel) {
                                JLabel label = (JLabel) innerComponent;
                                if (label.getText().startsWith("Name: ")) {
                                    name = label.getText().substring(7);
                                } else if (label.getText().startsWith("Price: ")) {
                                    price = label.getText().substring(8);
                                }
                            } else if (innerComponent instanceof JTextField) {
                                JTextField countField = (JTextField) innerComponent;
                                piece = countField.getText();
                            }
                        }
                        //String name, Icon image, double price, String type 
                        String priceText = price;
                        double priceValue = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
                        mapfortran.put(new Food(name, null, priceValue, "tran"), Integer.valueOf(piece));
                    }

                }
                this.saveTranMap();
                System.out.println(mapfortran);
                rom.tranMap(Loginpage.nam);

                mapfortran.clear();
                map.clear();
                try (FileOutputStream fout = new FileOutputStream("ro.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

                    oout.writeObject(map);

                } catch (IOException ex) {

                    ex.printStackTrace();
                }
                this.saveTranMap();
                mid.removeAll();
//        mid.repaint();
                this.updateCartOrder();

            }
        }

    }

    public void saveTranMap() {
        try (FileOutputStream fout = new FileOutputStream("cardusertran.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

            oout.writeObject(mapfortran);

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    // 0000 wait for final dont delete
    public String getRoomFromCart() {
        return rom.getroomNumber();
    }

    public void updateCartOrder() {
        mid.removeAll();
        this.loadMap();
        Set<Food> foodSet = map.keySet();
        for (Food food : foodSet) {
            if (food.getName().equals("")) {
                System.out.println("e");
            } else {
                String name = food.getName();
                String price = String.valueOf(food.getPrice());
                String piece = String.valueOf(map.get(food));
                addOrder(name, price, piece); // ดูเมธอด addOrder ใน cartOrder ว่ามีการสร้างหรือยัง
            }
        }
        mid.revalidate();
        mid.repaint();
    }

    public void retotal() {
//       bot.removeAll();
        Component[] components = mid.getComponents();
        totalmoney = 0;

        for (Component component : components) {
            if (component instanceof JPanel) {
                JPanel orderPanel = (JPanel) component;
                String name = "";
                String price = "";
                String piece = "";

                for (Component innerComponent : orderPanel.getComponents()) {
                    if (innerComponent instanceof JLabel) {
                        JLabel label = (JLabel) innerComponent;
                        if (label.getText().startsWith("Name: ")) {
                            name = label.getText().substring(7);
                        } else if (label.getText().startsWith("Price: ")) {
                            price = label.getText().substring(8);
                        }
                    } else if (innerComponent instanceof JTextField) {
                        JTextField countField = (JTextField) innerComponent;
                        piece = countField.getText();
                    }
                }
                //String name, Icon image, double price, String type 
                String priceText = price;
                double priceValue = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
                totalmoney += priceValue * Integer.parseInt(piece);
                map.clear();
                map.put(new Food(name, null, priceValue, "tran"), Integer.valueOf(piece));
            }

        }
//        System.out.println(totalmoney);
        total.setText("Total : " + totalmoney);
//        try (FileOutputStream fout = new FileOutputStream("ro.dat");
//            ObjectOutputStream oout = new ObjectOutputStream(fout);){
//            
//            oout.writeObject(map);
//
//        } catch (IOException ex) {
//
//            ex.printStackTrace();
//        }

    }

    public void remid() {
        Component[] components = mid.getComponents();
        totalmoney = 0;

        for (Component component : components) {
            if (component instanceof JPanel) {
                JPanel orderPanel = (JPanel) component;
                String name = "";
                String price = "";
                String piece = "";

                for (Component innerComponent : orderPanel.getComponents()) {
                    if (innerComponent instanceof JLabel) {
                        JLabel label = (JLabel) innerComponent;
                        if (label.getText().startsWith("Name: ")) {
                            name = label.getText().substring(7);
                        } else if (label.getText().startsWith("Price: ")) {
                            price = label.getText().substring(8);
                        }
                    } else if (innerComponent instanceof JTextField) {
                        JTextField countField = (JTextField) innerComponent;
                        piece = countField.getText();
                    }
                }

                //String name, Icon image, double price, String type 
                String priceText = price;
                double priceValue = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
                totalmoney += priceValue * Integer.parseInt(piece);
                map.clear();
                map.put(new Food(name, null, priceValue, "tran"), Integer.valueOf(piece));
            }
        }
        try (FileOutputStream fout = new FileOutputStream("ro.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

            oout.writeObject(map);

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new mainUser();
    }
}