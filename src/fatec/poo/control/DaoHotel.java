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
    public Hotel consultar (int codigo) {
        Hotel objHotel = null;         
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * from tblHotel where Codigo_Hot = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                objHotel = new Hotel(rs.getInt("Codigo_Hot"),rs.getString("Nome_Hot"));
                objHotel.setEndereco("Endereco_Hot");
                objHotel.setTelefone("Telefone_Hot");
                objHotel.setValorDiaria(rs.getDouble("TotalFaturamento_Hot"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return(objHotel);
    }    
     
    public void inserir(Hotel objHotel) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO tblHotel(Codigo_Hot, Nome_Hot, Endereco_Hot, Telefone_Hot, TotalFaturamento_Hot) VALUES(?,?,?,?,?)");
            ps.setInt(1, objHotel.getCodigo());
            ps.setString(2, objHotel.getNome());
            ps.setString(3, objHotel.getEndereco());
            ps.setString(4, objHotel.getTelefone());
            ps.setDouble(4,objHotel.getValorDiaria());
                      
            ps.execute(); //envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Hotel hotel) {
       PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE tblHotel set Nome_Hot = ?, " +
                                       "Endereco_Hot = ? " +
                                       "Telefone_Hot = ? " + 
                                        "TotalFaturamento_Hot = ? " + 
                                       "where Codigo_Hot = ?");
            
            ps.setString(1, hotel.getNome());
            ps.setString(2, hotel.getEndereco());
            ps.setString(3, hotel.getTelefone());
            ps.setDouble(4, hotel.getValorDiaria());
           
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Hotel hotel) {
         PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM tblHotel where Codigo_Hot = ?");
            
            ps.setInt(1, hotel.getCodigo());
                      
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
