/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author artpl
 */
public class Reserva {

  private int codigo;
  private String nomeHosp;
  private Data dataEntrada;
  private Data dataSaida;
  private double valorHosped;
  private Hotel hotel;

  // ===== CONSTRUTOR =====

  public Reserva(int codigo, String nomeHosp, Data dataEntrada) {
    this.codigo = codigo;
    this.nomeHosp = nomeHosp;
    this.dataEntrada = dataEntrada;
  }

  // ===== GETTERS =====

  public int getCodigo() {
    return codigo;
  }

  public String getNomeHosp() {
    return nomeHosp;
  }

  public Data getDataEntrada() {
    return dataEntrada;
  }

  public Data getDataSaida() {
    return dataSaida;
  }

  public double getValorHosped() {
    return valorHosped;
  }

  // ===== METODOS =====

  public double encerrarReserva(Data dataSaida) {
    return valorHosped;
  }
}
