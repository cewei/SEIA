/*
 * ItemDataManager.java
 *
 * Created on 1 October 2007, 20:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import db.ConnectionManager;

import java.sql.*;
import java.util.*;

/**
 *
 * @author cewei.foo.2006
 */
public class ItemDataManager {
    
    public static Item [] retriveAll(){
        List<Item> result = new ArrayList<Item>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = new ConnectionManager().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT ID, Description, Price FROM ITEMS");
            
            while(rs.next()){
                result.add(new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, stmt, rs);
        }
        return result.toArray(new Item[result.size()]);
    }
    
    public static Item retrieve(int id){
        Item item = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT ID, Description, Price FROM ITEMS WHERE ID="+id);
            while(rs.next()){
                item = new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn,stmt,rs);
        }
        return item;
    }
    
    /** Creates a new instance of ItemDataManager */
    public ItemDataManager() {
    }
    
}
