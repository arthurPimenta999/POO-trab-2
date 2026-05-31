/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import java.sql.Connection;

/**
 *
 * @author nicol
 */
public class DaoHotel {
    private Connection conn;
    
    public DaoHotel(Connection conn) {
         this.conn = conn;
    }  
}
