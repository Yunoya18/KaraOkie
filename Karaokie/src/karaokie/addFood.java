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
import javax.swing.*;
import javax.swing.table.*;

public class addFood extends JPanel implements ActionListener {
    private static JTable t;
    private JScrollPane sc;
    private JTableHeader h;
    private DefaultTableModel m;
    private TableColumn tc;
    private JButton b, b2;
    private JPanel p1, p2;
    public addFood(){
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
        ImageIcon i = new ImageIcon("D:\\work\\OOP\\Project\\KaraOkie\\src\\Icon\\add.png");
        Image im = i.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(im);
        b.setIcon(icon);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setBackground(Color.decode("#535870"));
        b.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                b.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        b.addActionListener(this);
        b2 = new JButton();
        ImageIcon i2 = new ImageIcon("D:\\work\\OOP\\Project\\KaraOkie\\src\\Icon\\delete.png");
        Image im2 = i2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(im2);
        b2.setIcon(icon2);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setBackground(Color.decode("#535870"));
        b2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                b2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        b2.addActionListener(this);
        
        // table
        m = new DefaultTableModel(new Object[]{"Image", "Name", "Categories", "Price"}, 0){
            @Override
            public Class<?> getColumnClass(int ci){
                return ci == 0 ? ImageIcon.class : Object.class;
            }
        };
        t = new JTable(m);
        
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
        sc = new JScrollPane(t);
        sc.setPreferredSize(new Dimension(1000, 600));
        p1.add(b);
        p1.add(b2);
        p2.add(sc);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        setVisible(true);
    }
    public static void addRow(Object[] dataRow){
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.addRow(dataRow);
    }
    class ImageRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            if (value instanceof ImageIcon){
                setIcon((ImageIcon) value);
                setText(null);
            }
            else{
                setText((value == null) ? "" : value.toString());
                setIcon(null);
            }
            return this;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(b)){
            new fillFood();
        }
        else if(e.getSource().equals(b2)){
            DefaultTableModel tm = (DefaultTableModel) t.getModel();
            int ind[] = t.getSelectedRows();
            for (int i=ind.length-1; i>=0; i--){
                tm.removeRow(ind[i]);
            }
        }
    }
    public JTable getT(){
        return this.t;
    }
}
