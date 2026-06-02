/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Data;
import fatec.poo.model.Hotel;
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

  public Reserva consultar(int codigo) {
    Reserva objReserva = null;

    PreparedStatement ps;
    try {
      ps = conn.prepareStatement(
        "SELECT * from tblReserva where Codigo_Res = ?"
      );
      ps.setInt(1, codigo);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        String dataEntradaStr = rs.getString("DataEntrada_Res");
        String[] partesData = dataEntradaStr.split("/");
        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);

        // Instancia o objeto Data da model
        Data dataEntrada = new Data(dia, mes, ano);

        objReserva = new Reserva(
          rs.getInt("Codigo_Res"),
          rs.getString("NomeHosp_Res"),
          dataEntrada
        );

        objReserva
          .getHotel()
          .addValorHospedagem(rs.getDouble("ValorHosped_Res"));

        if(rs.getString("DataSaida_Res") != null) {
            String dataSaidaStr = rs.getString("DataSaida_Res");
            String[] partesSaida = dataSaidaStr.split("/");
            Data dataSaida = new Data (
                Integer.parseInt(partesSaida[0]),
                Integer.parseInt(partesSaida[1]),
                Integer.parseInt(partesSaida[2])
            );
            objReserva.setDataSaida (dataSaida)
        }
      }
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
    return (objReserva);
  }

  public void inserir(Reserva objReserva) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement(
        "INSERT INTO tblReserva(Codigo_Hot, Nome_Hot, Endereco_Hot, Telefone_Hot, TotalFaturamento_Hot) VALUES(?,?,?,?,?)"
      );
      ps.setInt(1, objReserva.getHotel().getCodigo());
      ps.setString(2, objReserva.getHotel().getNome());
      ps.setString(3, objReserva.getHotel().getEndereco());
      ps.setString(4, objReserva.getHotel().getTelefone());
      ps.setString(5, objReserva.getHotel().getTotalFaturamento());

      ps.execute(); //envia a instrução SQL para o SGBD
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }

  public void alterar(Reserva objReserva) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement(
        "UPDATE tblReserva set Nome_Hot = ?, " +
          "Endereco_Hot = ? " +
          "Telefone_Hot = ? " +
          "TotalFaturamento_Hot = ? " +
          "where Codigo_Hot = ?"
      );
      ps.setString(1, objReserva.getHotel().getNome());
      ps.setString(2, objReserva.getHotel().getEndereco());
      ps.setString(3, objReserva.getHotel().getTelefone());
      ps.setString(4, objReserva.getHotel().getTotalFaturamento());
      ps.setInt(5, objReserva.getHotel().getCodigo());

      ps.execute(); //Envia a instrução SQL para o SGBD
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }

  public void excluir(Reserva objReserva) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement("DELETE FROM tblReserva where Codigo_Hot = ?");

      ps.setInt(1, objReserva.getCodigo());
      ps.execute(); //Envia a instrução SQL para o SGBD
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }
}
