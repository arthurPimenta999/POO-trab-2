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

  private int dia, mes, ano;

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

  public int subtrairDatas(Data dataFinal) {
    int dias1 = this.dia + this.mes * 30 + this.ano * 365;
    int dias2 = dataFinal.dia + dataFinal.mes * 30 + dataFinal.ano * 365;

    return dias1 - dias2;
  }

  public double calcDiasCorridos(Data data) {
    // !tratamento de exceção pra ano bissexto
    boolean condicao1 = data.ano % 4 == 0;
    boolean condicao2 = data.ano % 100 != 0;
    boolean condicao3 = data.ano % 400 == 0;

    boolean isBissexto = (condicao1 && condicao2) || condicao3;

    double contagemDias = ((data.ano - 1) - 1900) * 365.25 + data.dia;

    // !calculo da data retornada de fato
    int[] numeroDias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    for (int i = 0; i < data.mes - 1; i++) {
      contagemDias += numeroDias[i];
    }

    if (isBissexto && data.mes > 2) {
      contagemDias += 1;
    }

    return contagemDias;
  }
}
