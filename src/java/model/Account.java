/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author thai.ngoc
 */
public class Account implements Serializable {

    private String account;
    private String pass;
    private String lastName;
    private String firstName;
    private Date birthday;
    private boolean gender;
    private String phone;
    private boolean isUse;
    private int roleInSystem;

    public Account() {
    }

    public Account(String account) {
        this.account = account;
    }



    public Account(String account, String pass, String lastName, String firstName, Date birthday, boolean gender, String phone, boolean isUse, int roleInSystem) {
        this.account = account;
        this.pass = pass;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.isUse = isUse;
        this.roleInSystem = roleInSystem;
    }
    public Account(String account, String pass, String lastName, String firstName, Date birthday, boolean gender, String phone, int roleInSystem) {
        this.account = account;
        this.pass = pass;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
    
        this.roleInSystem = roleInSystem;
    }

 
    public Account(String account, String lastName, String firstName, Date birthday, boolean gender, String phone, int roleInSystem) {
        this.account = account;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.roleInSystem = roleInSystem;
    }
    

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the isUse
     */
    public boolean isIsUse() {
        return isUse;
    }

    /**
     * @param isUse the isUse to set
     */
    public void setIsUse(boolean isUse) {
        this.isUse = isUse;
    }

    /**
     * @return the roleInSystem
     */
    public int getRoleInSystem() {
        return roleInSystem;
    }

    /**
     * @param roleInSystem the roleInSystem to set
     */
    public void setRoleInSystem(int roleInSystem) {
        this.roleInSystem = roleInSystem;
    }

}
