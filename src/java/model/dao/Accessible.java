/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;

/**
 *
 * @author thai.ngoc
 */
public interface Accessible<T> {
    int insertRec (T obj);
    int updateRec (T obj);
    int deleteRec (T obj);
    T getObjectById(String id);
    List<T> listAll();
}
