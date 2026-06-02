package fatec.poo.control;

import fatec.poo.model.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoHotel {

  private Connection conn;

  public DaoHotel(Connection conn) {
    this.conn = conn;
  }

  public Hotel consultar(int codigo) {
    Hotel objHotel = null;
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement("SELECT * FROM tblHotel WHERE Codigo_Hot = ?");
      ps.setInt(1, codigo);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        objHotel = new Hotel(rs.getInt("Codigo_Hot"), rs.getString("Nome_Hot"));
        objHotel.setEndereco(rs.getString("Endereco_Hot"));
        objHotel.setTelefone(rs.getString("Telefone_Hot"));
        objHotel.setValorDiaria(rs.getString("ValorDiaria_Hot"));
        objHotel.addValorHospedagem(rs.getDouble("TotalFaturamento_Hot"));
      }
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
    return objHotel;
  }

  public void inserir(Hotel objHotel) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement(
        "INSERT INTO tblHotel(Codigo_Hot, Nome_Hot, Endereco_Hot, Telefone_Hot, ValorDiaria_Hot, TotalFaturamento_Hot) VALUES(?,?,?,?,?,?)"
      );
      ps.setInt(1, objHotel.getCodigo());
      ps.setString(2, objHotel.getNome());
      ps.setString(3, objHotel.getEndereco());
      ps.setString(4, objHotel.getTelefone());
      ps.setString(5, objHotel.getValorDiaria());
      ps.setDouble(6, 0.0);

      ps.execute();
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }

  public void alterar(Hotel hotel) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement(
        "UPDATE tblHotel SET Nome_Hot = ?, " +
          "Endereco_Hot = ?, " +
          "Telefone_Hot = ?, " +
          "ValorDiaria_Hot = ?, " +
          "TotalFaturamento_Hot = ? " +
          "WHERE Codigo_Hot = ?"
      );
      ps.setString(1, hotel.getNome());
      ps.setString(2, hotel.getEndereco());
      ps.setString(3, hotel.getTelefone());
      ps.setString(4, hotel.getValorDiaria());
      ps.setString(5, hotel.getTotalFaturamento());
      ps.setInt(6, hotel.getCodigo());

      ps.execute();
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }

  public void excluir(Hotel hotel) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement("DELETE FROM tblHotel WHERE Codigo_Hot = ?");
      ps.setInt(1, hotel.getCodigo());
      ps.execute();
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }
}
