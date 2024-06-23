/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import model.Category;
import model.Product;
import utils.ConnectDB;

/**
 *
 * @author thai.ngoc
 */
@MultipartConfig
public class ProductDAO implements Accessible<Product> {

    private Connection con;
    private ServletContext sc;

    public ProductDAO() {
    }

    public ProductDAO(Connection con, ServletContext sc) {
        this.con = con;
        this.sc = sc;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            con = ConnectDB.getConnection();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }

    @Override
    public int insertRec(Product obj) {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {

                System.out.println("Unit: " + obj.getUnit());
                String sql = "INSERT INTO products(productId,productName,productImage,brief,account,price,discount,typeId,unit) VALUES (?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, obj.getProductId());
                stm.setNString(2, obj.getProductName());
                stm.setString(3, obj.getProductImage());
                stm.setString(4, obj.getBrief());
                stm.setString(5, obj.getAccount());
                stm.setInt(6, obj.getPrice());
                stm.setInt(7, obj.getDiscount());
                stm.setInt(8, obj.getType());
                stm.setNString(9, obj.getUnit());
                rs = stm.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return rs;
    }

    @Override
    public int updateRec(Product obj) {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "update products set productName=?,productImage=?,brief=?,price=?,discount=?,unit=? where productId=?";
                stm = con.prepareStatement(sql);
                stm.setNString(1, obj.getProductName());
                stm.setString(2, obj.getProductImage());
                stm.setNString(3, obj.getBrief());
                stm.setInt(4, obj.getPrice());
                stm.setInt(5, obj.getDiscount());
                stm.setNString(6, obj.getUnit());
                stm.setNString(7, obj.getProductId());
                rs = stm.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return rs;
    }

    @Override
    public int deleteRec(Product obj) {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "delete "
                        + "from  products "
                        + "where productId=? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, obj.getProductId());
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
    public Product getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public List<Product> listAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "select productId, productName, productImage, brief, postedDate, unit, price, discount "
                        + "from products";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String productImage = rs.getString("productImage");
                    String brief = rs.getString("brief");
                    Date postedDate = rs.getDate("postedDate");
                    String unit = rs.getString("unit");
                    int price = rs.getInt("price");
                    int discount = rs.getInt("discount");

                    Product product = new Product(productId, productName, productImage, brief, postedDate, unit, price, discount);
                    if (products == null) {
                        this.products = new ArrayList<>();
                    }
                    this.products.add(product);
                }
            };

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return products;
    }

    public boolean checkExitId(String productId) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.getConnection();
            if(con != null){
                String sql = "Select * from products where productId=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, productId);
                rs = stm.executeQuery();
                if(rs.next()){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return false;
    }

}
