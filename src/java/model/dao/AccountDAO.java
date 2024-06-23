/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import utils.ConnectDB;

/**
 *
 * @author thai.ngoc
 */
public class AccountDAO implements Accessible<Account>, Serializable {

    @Override
    public int insertRec(Account a) {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "insert into accounts(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem) "
                        + "  values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, a.getAccount());
                stm.setString(2, a.getPass());
                stm.setString(3, a.getLastName());
                stm.setString(4, a.getFirstName());
                stm.setDate(5, a.getBirthday());
                stm.setBoolean(6, a.isGender());
                stm.setString(7, a.getPhone());
                stm.setBoolean(8, a.isIsUse());
                stm.setInt(9, a.getRoleInSystem());
                rs = stm.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return rs;
    }

    @Override
    public int updateRec(Account obj) {
        int rs = 0;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "update accounts "
                        + "set lastname=?, firstname=?,birthday=?, gender=?, phone=?, roleInSystem=? "
                        + "where account=?";
                stm = con.prepareStatement(sql);
//                stm.setString(1, obj.getAccount());

                stm.setString(1, obj.getLastName());
                stm.setString(2, obj.getFirstName());
                stm.setDate(3, obj.getBirthday());
                stm.setBoolean(4, obj.isGender());
                stm.setString(5, obj.getPhone());
                stm.setInt(6, obj.getRoleInSystem());
                stm.setString(7, obj.getAccount());
                rs = stm.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return rs;
    }

    @Override
    public int deleteRec(Account obj) {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "delete from accounts where account = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, obj.getAccount());
                rs = stm.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return rs;
    }

    @Override
    public Account getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public List<Account> listAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "select account, firstName, lastName, birthday, phone, gender, roleInSystem from accounts";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String account = rs.getString("account");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    Date birthday = rs.getDate("birthday");
                    String phone = rs.getString("phone");
                    boolean gender = rs.getBoolean("gender");
                    int roleInSystem = rs.getInt("roleInSystem");
                    Account ac = new Account(account, lastName, firstName, birthday, gender, phone, roleInSystem);
                    if (accounts == null) {
                        this.accounts = new ArrayList<>();
                    }
                    this.accounts.add(ac);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return accounts;

    }

    public boolean checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "select account "
                        + "from accounts "
                        + "where account=? and pass=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                stm.close();
            }
        }
        return false;
    }

    public boolean checkExit(String username) {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM accounts WHERE account=?";
                stm = con.prepareCall(sql);
                stm.setString(1, username);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(con);
        }
        return false;
    }

}
