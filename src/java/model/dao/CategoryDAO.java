/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import utils.ConnectDB;

/**
 *
 * @author thai.ngoc
 */
public class CategoryDAO implements Accessible<Category>{

    @Override
    public int insertRec(Category obj) {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = ConnectDB.getConnection();
            if(con != null){
                String sql = "Insert into categories(categoryName, memo) "
                        + "Values (?, ?)";
                stm = con.prepareStatement(sql);
                stm.setNString(1, obj.getCategoryName());
                stm.setNString(2, obj.getMemo());
                rs = stm.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return rs;
    }

    @Override
    public int updateRec(Category obj) {
          Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = ConnectDB.getConnection();
            if(con != null){


             String sql = "update categories "
                     + "set categoryName=?, memo=? "
                     + "where typeId=?";
             stm = con.prepareStatement(sql);
             stm.setNString(1, obj.getCategoryName());
             stm.setNString(2, obj.getMemo());
             stm.setInt(3, obj.getTypeId());
             rs = stm.executeUpdate();
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectDB.closeConnection(con);
        }
        return rs;
    }

    @Override
    public int deleteRec(Category obj) {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = ConnectDB.getConnection();
            if(con != null){
             String sql = "delete "
                     + "from categories "
                     + "where typeId=? ";
             stm = con.prepareStatement(sql);
             stm.setInt(1, obj.getTypeId());
             rs = stm.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectDB.closeConnection(con);
        }
        return rs;
    }

    @Override
    public Category getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
     public List<Category> categories;

    public List<Category> getAccounts() {
        return categories;
    }

    @Override
    public List<Category> listAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "select typeid, categoryName, memo from Categories";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int typeid = rs.getInt("typeid");
                    String categoryName = rs.getString("categoryName");
                    String memo = rs.getString("memo");
                   Category category = new Category(typeid, categoryName, memo);
                   
                    if(categories == null){
                        this.categories = new ArrayList<>();
                    }
                   this.categories.add(category);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return categories;
      
    }
    
}
