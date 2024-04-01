/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author sonra
 */
public class setDefaultText<T, U> {
    private T firstItem;
    private U  secondItem;
    public setDefaultText(T firstItem, U secondItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }
    public void setFirstItem(T firstItem) {
        this.firstItem = firstItem;
    }
    public T getFirstItem() {
        return this.firstItem;
    }
    public void setSecondItem(U secondItem) {
        this.secondItem = secondItem;
    }
    public U getSecondItem() {
        return this.secondItem;
    }
    @Override
    public String toString() {
        return "Send " + firstItem + " Success, Please Wait : " + secondItem;
    }
}
