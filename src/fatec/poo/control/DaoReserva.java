package fatec.poo.control;

import fatec.poo.model.Data;
import fatec.poo.model.Hotel;
import fatec.poo.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        "SELECT * FROM tblReserva WHERE Codigo_Res = ?"
      );
      ps.setInt(1, codigo);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        String dataEntradaStr = rs.getString("DataEntrada_Res");
        String[] partesData = dataEntradaStr.split("/");
        Data dataEntrada = new Data(
          Integer.parseInt(partesData[0]),
          Integer.parseInt(partesData[1]),
          Integer.parseInt(partesData[2])
        );

        objReserva = new Reserva(
          rs.getInt("Codigo_Res"),
          rs.getString("NomeHosp_Res"),
          dataEntrada
        );

        int codigoHotel = rs.getInt("Codigo_Hot");
        DaoHotel daoHotel = new DaoHotel(conn);
        Hotel objHotel = daoHotel.consultar(codigoHotel);
        objReserva.setHotel(objHotel);

        double valorHosped = rs.getDouble("ValorHosped_Res");
        if (!rs.wasNull() && objHotel != null) {
          objHotel.addValorHospedagem(valorHosped);
        }

        String dataSaidaStr = rs.getString("DataSaida_Res");
        if (dataSaidaStr != null && !dataSaidaStr.trim().isEmpty()) {
          String[] partesSaida = dataSaidaStr.split("/");
          Data dataSaida = new Data(
            Integer.parseInt(partesSaida[0]),
            Integer.parseInt(partesSaida[1]),
            Integer.parseInt(partesSaida[2])
          );
          objReserva.encerrarReserva(dataSaida);
        }
      }
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
    return objReserva;
  }

  public void inserir(Reserva objReserva) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement(
        "INSERT INTO tblReserva(Codigo_Res, NomeHosp_Res, DataEntrada_Res, Codigo_Hot) VALUES(?,?,?,?)"
      );
      ps.setInt(1, objReserva.getCodigo());
      ps.setString(2, objReserva.getNomeHosp());
      ps.setString(3, objReserva.getDataEntrada().obterData());
      ps.setInt(4, objReserva.getHotel().getCodigo());

      ps.execute();
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }

  public void alterar(Reserva objReserva) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement(
        "UPDATE tblReserva SET DataSaida_Res = ?, ValorHosped_Res = ? WHERE Codigo_Res = ?"
      );

      if (objReserva.getDataSaida() != null) {
        ps.setString(1, objReserva.getDataSaida().obterData());
      } else {
        ps.setNull(1, java.sql.Types.VARCHAR);
      }
      ps.setDouble(2, objReserva.getValorHosped());
      ps.setInt(3, objReserva.getCodigo());

      ps.execute();
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }

  public void excluir(Reserva objReserva) {
    PreparedStatement ps;
    try {
      ps = conn.prepareStatement("DELETE FROM tblReserva WHERE Codigo_Res = ?");
      ps.setInt(1, objReserva.getCodigo());

      ps.execute();
    } catch (SQLException ex) {
      System.out.println(ex.toString());
    }
  }
}
