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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.*;
import karaokie.Menu.Food;
import karaokie.Menu.Menus;

public class addFood extends JPanel implements ActionListener, WindowListener {

    private Map<String, ArrayList<Food>> map;
    private static JTable t;
    private JScrollPane sc;
    private JTableHeader h;
    private DefaultTableModel m;
    private TableColumn tc;
    private JButton b, b2;
    private JPanel p1, p2;
    private Menus menu;

    public addFood() {
        //       font
        try{
            Font Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/src/karaokie/font/Montserrat-Bold.ttf")).deriveFont(Font.PLAIN, 12);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Montserrat);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //menu and food
        menu = new Menus();
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize(); 

        setBackground(Color.decode("#535870"));
        setLayout(new BorderLayout());

        // panel
        p1 = new JPanel();
        p2 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1.setBackground(Color.decode("#535870"));
        p2.setBackground(Color.decode("#535870"));

        // button
        b = new JButton();
        ImageIcon i = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/add.png");
        Image im = i.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(im);
        b.setIcon(icon);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setBackground(Color.decode("#535870"));
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        b.addActionListener(this);
        b2 = new JButton();
        ImageIcon i2 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/delete.png");
        Image im2 = i2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(im2);
        b2.setIcon(icon2);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setBackground(Color.decode("#535870"));
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        b2.addActionListener(this);

        // table
        m = new DefaultTableModel(new Object[]{"Image", "Name", "Categories", "Price"}, 0) {
            @Override
            public Class<?> getColumnClass(int ci) {
                return ci == 0 ? ImageIcon.class : Object.class;
            }
        };
        t = new JTable(m);
        t.setFont(new Font("Montserrat", Font.BOLD, 12));
        
        // Set custom cell renderer for the image column
        t.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());

        // Set row and column size
        t.setRowHeight(100);
        t.getColumnModel().getColumn(0).setPreferredWidth(100);
        t.getColumnModel().getColumn(1).setPreferredWidth(500);
        t.getColumnModel().getColumn(2).setPreferredWidth(200);
        t.getColumnModel().getColumn(3).setPreferredWidth(200);

//        t.setEnabled(false);
        t.getTableHeader().setEnabled(false);
        t.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 12));
        t.getTableHeader().setForeground(Color.decode("#A6ADCE"));
        
        t.setForeground(Color.decode("#535870"));
        t.setGridColor(Color.decode("#E5E5E5"));
        
        int sch = screenSize.height- (screenSize.height/6);
        
        sc = new JScrollPane(t);
        sc.setPreferredSize(new Dimension(1000, sch));
        p1.add(b);
        p1.add(b2);
        p2.add(sc);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        setVisible(true);

    }

    public static void addRow(Object[] dataRow) {
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.addRow(dataRow);
        System.out.println("e");

    }
    
    public void reRow(){
        try {
            DefaultTableModel model = (DefaultTableModel) t.getModel();
            int rowCount = model.getRowCount();
            // Remove rows from the end to avoid index issues
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
        } catch (ClassCastException i){
            i.printStackTrace();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b)) {
            new fillFood();
        } else if (e.getSource().equals(b2)) {
            DefaultTableModel tm = (DefaultTableModel) t.getModel();
            int ind[] = t.getSelectedRows();
            
            //removeMenu
            Icon icon = (Icon) tm.getValueAt(ind[0], 0);
            String name =  (String) tm.getValueAt(ind[0], 1);
            String type =(String) tm.getValueAt(ind[0], 2);
            String price =  (String) tm.getValueAt(ind[0], 3);
            String value = price;
            String[] parts = value.split("\\s+");
            double amount = Double.parseDouble(parts[0]);
            menu.removeMenu(new Food(name, icon, amount, type));
            
            tm.removeRow(ind[0]);
            System.out.println(ind);

        }
    }

    public JTable getT() {
        return this.t;
    }

    //windowevent
    @Override
    public void windowOpened(WindowEvent e) {
        //import menu.dat
        File file = new File("menu.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("menu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();
            } catch (IOException | ClassNotFoundException ex) {

                ex.printStackTrace();
            }
        }

        //addrow from data.dat
        for (String key : map.keySet()) {
            for (int num = 0; num < map.get(key).size(); num++) {
                DefaultTableModel model = (DefaultTableModel) t.getModel();
                //            model.addRow(map.get("Food").get(num).getImage());
                Icon icon5 = map.get(key).get(num).getImage();
                String name = map.get(key).get(num).getName();
                String type = map.get(key).get(num).getType();
                double price = map.get(key).get(num).getPrice();
                model.addRow(new Object[]{icon5, name, type, price + " THB"});
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
