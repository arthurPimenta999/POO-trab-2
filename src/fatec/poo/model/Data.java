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
public class Data {

  private int dia, mes;
  public int ano;

  // ===== CONSTRUTOR =====

  public Data(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  // ==== GETTERS =====

  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAno() {
    return ano;
  }

  // ===== METODOS =====

  public String obterData() {
    return dia + "/" + mes + "/" + ano;
  }

  public int calcDiasCorridos(Data dataFinal) {
    return (
      (dataFinal.dia - this.dia) +
      (dataFinal.mes - this.mes) * 30 +
      (dataFinal.ano - this.ano) * 365
    );
  }

  public int subtrairDatas(Data dataFinal) {
    int dias1 = this.dia + this.mes * 30 + this.ano * 365;
    int dias2 = dataFinal.dia + dataFinal.mes * 30 + dataFinal.ano * 365;

    return dias1 - dias2;
  }
}
