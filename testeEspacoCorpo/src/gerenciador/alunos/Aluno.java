/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.alunos;

import gerenciador.pessoa.Pessoa;

/**
 *
 * @author Raiane
 */
public class Aluno extends Pessoa {

    public Aluno(int id, int estadoCivil, String cpf, String rg, String nome,
            String dataNascimento, String email, char sexo) {

        super(id, estadoCivil, cpf, rg, nome, dataNascimento, email, sexo);
    }

// 
}
