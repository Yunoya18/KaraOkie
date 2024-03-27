package karaokie.Menu;


import java.awt.Image;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Food implements Serializable {
    private String name;
    private Icon image;
    private double price;
    private String type;
    public Food(){
        this.name = "";
        this.image = null;
        this.price = 0.0;
        this.type = "";
    }
    public Food(String name, Icon image, double price, String type){
        this.name = name;
        this.image = image;
        this.price = price;
        this.type = type;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Icon getImage(){
        return image;
    }
    public void setImage(Icon image){
        this.image = image;
        
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getType (){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
}
