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

  public int calcDiasCorridos() {
    boolean isBissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    int[] diasDosMeses = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int somaMesesAnteriores = 0;
    for (int i = 0; i < mes - 1 - 1; i++) {
      somaMesesAnteriores += diasDosMeses[i];
    }

    double totalDias = ((ano - 1) - 1900) * 365.25 + somaMesesAnteriores + dia;

    if (isBissexto && mes > 2) {
      totalDias += 1;
    }

    return (int) totalDias;
  }

  public int subtrairDatas(Data dataInicial) {
    return this.calcDiasCorridos() - dataInicial.calcDiasCorridos();
  }
}
