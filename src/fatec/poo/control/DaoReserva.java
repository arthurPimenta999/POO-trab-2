/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public Reserva consultar (int codigo) {
        Reserva objReserva = null;         
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * from tblReserva where Codigo_Res = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
           
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return(objReserva);
    }    
     
    public void inserir(Reserva objReserva) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO tblReserva(Codigo_Hot, Nome_Hot, Endereco_Hot, Telefone_Hot, TotalFaturamento_Hot) VALUES(?,?,?,?,?)");
            
            ps.execute(); //envia a instrução SQL para o SGBD

        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Reserva reserva) {
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("UPDATE tblReserva set Nome_Hot = ?, " +
                                       "Endereco_Hot = ? " +
                                       "Telefone_Hot = ? " + 
                                        "TotalFaturamento_Hot = ? " + 
                                       "where Codigo_Hot = ?");
            
      
           
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Reserva reserva) {
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("DELETE FROM tblReserva where Codigo_Hot = ?");
            
            ps.setInt(1, reserva.getCodigo());
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
