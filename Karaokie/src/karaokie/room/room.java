
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
    
    
    public room(){
        this(0, "", 0, false);
    }   

    public room(int roomNumber, String Type, int Price, boolean Avaliable) {
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

}
