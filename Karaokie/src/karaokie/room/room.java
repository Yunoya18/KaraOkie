
package karaokie.room;

import karaokie.Menu.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public abstract class room extends JInternalFrame implements Available, Serializable, ComponentListener, MouseListener{
    private static final long serialVersionUID = 1L;
    protected final int roomNumber;
//    protected roomMenu roomMenu;
    protected final String Type;
    protected int Price;
    protected boolean Avaliable;
    protected int position_x;
    protected int position_y;
    protected Point position = new Point();
    
    
    public room(){
        this(0, "", 0, false);
    }   

    public room(int roomNumber, String Type, int Price, boolean Avaliable) {
        super("Room" + roomNumber, false ,false ,false ,false);
        this.roomNumber = roomNumber;
        this.Type = Type;
        this.Price = Price;
        this.Avaliable = Avaliable;
        
        
        addComponentListener(this);
        addMouseListener(this);
        System.out.println("check");
//        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }
    
    
    @Override
    public boolean checkAvailable(){
        return Avaliable;
    }
    
    @Override
    public void setAvaliable(boolean b){
        this.Avaliable = b;
    }

    public int getPrice() {
        return Price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvaliable() {
        return Avaliable;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getType() {
        return Type;
    }

    public void setPosition_x(int position_x){
        this.position_x = position_x;
    }
    
    public void setPosition_y(int position_y){
        this.position_y = position_y;
    }
    
    public int getPosition_x(){
        return position_x;
    }
    
    public int getPosition_y(){
        return position_y;
    }
    
    public Point getPosition(){
        return position;
    }
    
    @Override
    public room getRoom(){
        return this;
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        position = this.getLocation();
//        System.out.println(position);
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
        if (e.getClickCount() == 2 && Controller.del){
            System.out.println("Double");
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to Delete this Room?", "Delete", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                Controller.delRoom(roomNumber, this);
            } else {
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
