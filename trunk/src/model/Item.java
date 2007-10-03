/*
 * Item.java
 *
 * Created on 1 October 2007, 20:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author cewei.foo.2006
 */
public class Item {
    
    private int itemID;
    private String itemDescription;
    private double itemPrice;
    
    /** Creates a new instance of Item */
    public Item(int itemID, String itemDescription, double itemPrice) {
        this.itemID = itemID;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
}
