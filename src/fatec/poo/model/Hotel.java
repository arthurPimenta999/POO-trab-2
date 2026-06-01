/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author artpl
 */
public class Hotel {

  private int codigo;
  private String nome, endereco, telefone;
  private double valorDiaria, totalFaturamento;
  private ArrayList<Reserva> reservas;

  // ===== CONSTRUTOR =====

  public Hotel(int codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;

    this.reservas = new ArrayList<Reserva>();
  }

  // ===== GETTERS ====

  public int getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getValorDiaria() {
    return String.valueOf(valorDiaria);
  }

  public String getTotalFaturamento() {
    return String.valueOf(totalFaturamento);
  }

  // ===== SETTERS ====

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public void setValorDiaria(String valorDiaria) {
    this.valorDiaria = Double.parseDouble(valorDiaria);
  }

  // ===== METODOS =====

  public void addValorHospedagem(double valor) {
    this.totalFaturamento += valor;
  }

  public void addReserva(Reserva reserva) {
    this.reservas.add(reserva);
  }
}
