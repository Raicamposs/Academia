/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author Raiane Campos
 */
public class ValidaCpf {

    public void ExercicioNumero6(String cpf) {
        if (cpfParseString(cpf)) {
            String digitosFinais = "" + calculoDigito(dvCpf(10, cpf)) + calculoDigito(dvCpf(11, cpf));
            if (cpf.endsWith(digitosFinais)) {
                JOptionPane.showMessageDialog(null, "Cpf Valido!");
            } else {
                JOptionPane.showMessageDialog(null, "Cpf Invalido!");
            }

        }
    }

    private boolean cpfParseString(String numCpf) {
        Boolean confere = false;
        while (!confere == true) {

            if (numCpf == null) {
                JOptionPane.showMessageDialog(null, "Cpf é um campo obrigatorio!");
                return false;
            } else {
                numCpf = numCpf.trim();
                if (JSType.isNumber(numCpf) && numCpf.length() == 11) {
                    confere = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Numero de Cpf esta com formato incorreto!");
                    return false;

                }
            }
        }
        return true;
    }

    private int dvCpf(int num, String numCpf) {

        int j = num;
        int soma = 0;

        for (int i = 0; i < (num - 1); i++) {
            String digito = "" + numCpf.charAt(i);
            int digitoCpf = Integer.parseInt(digito);
            soma += (digitoCpf * j);
            j--;
        }

        return soma;

    }

    private int calculoDigito(int sm) {
        return 11 - (sm % 11);
    }
}
