/*
 * LineItem.java
 *
 * Created on 1 October 2007, 23:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author cewei.foo.2006
 */
public class LineItem {
    
    private int lineItemID;
    private Item lineItem;
    private String lineItemSize;
    private int lineItemQuantity;
    
    /** Creates a new instance of LineItem */
    public LineItem() {
        
    }

    public int getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(int lineItemID) {
        this.lineItemID = lineItemID;
    }

    public Item getLineItem() {
        return lineItem;
    }

    public void setLineItem(Item lineItem) {
        this.lineItem = lineItem;
    }

    public String getLineItemSize() {
        return lineItemSize;
    }

    public void setLineItemSize(String lineItemSize) {
        this.lineItemSize = lineItemSize;
    }

    public int getLineItemQuantity() {
        return lineItemQuantity;
    }

    public void setLineItemQuantity(int lineItemQuantity) {
        this.lineItemQuantity = lineItemQuantity;
    }
    
}
