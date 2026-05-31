/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nicol
 */
public class DaoReserva {
    private Connection conn;
    public DaoReserva(Connection conn) {
         this.conn = conn;
    }  
    public void consultar(String s){ 
        return;
    }
    
    public Reserva consultar (int ra) {
        Reserva objReserva = null;         
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("qry");
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return(objReserva);
    }    
     
    public void inserir(Reserva reserva) {
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("qry");
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Reserva reserva) {
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("qry");
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Reserva reserva) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("qry");
            
                      
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
