
package karaokie.room;

import karaokie.Menu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public abstract class room extends JInternalFrame implements Available, Serializable{
    private static final long serialVersionUID = 1L;
    protected int roomNumber;
//    protected roomMenu roomMenu;
    protected String Type;
    protected int Price;
    protected boolean Avaliable;
    protected int position_x;
    protected int position_y;
    
    
    public room(){
        this(0, "", 0, false);
    }   

    public room(int roomNumber, String Type, int Price, boolean Avaliable) {
        super("Room" + roomNumber, false ,false ,false ,false);
        this.roomNumber = roomNumber;
        this.Type = Type;
        this.Price = Price;
        this.Avaliable = Avaliable;
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

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setType(String Type) {
        this.Type = Type;
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
}
