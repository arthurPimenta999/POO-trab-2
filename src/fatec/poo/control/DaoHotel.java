/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nicol
 */
public class DaoHotel {
    private Connection conn;
    
    public DaoHotel(Connection conn) {
         this.conn = conn;
    }  
    public Hotel consultar (int ra) {
        Hotel objHotel = null;         
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("qry");
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return(objHotel);
    }    
     
    public void inserir(Hotel hotel) {
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("qry");
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Hotel hotel) {
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("qry");
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Hotel hotel) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("qry");
            
                      
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
