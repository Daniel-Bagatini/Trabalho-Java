/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;


public interface DAO<T> {

    void salvar(T obj);

    List<T> buscarTodos();


    T buscarPorId(Object identificador);

}
