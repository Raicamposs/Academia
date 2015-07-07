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

    private String observacao, dataMatricula;
    private String dataExame, dataAvaliacao, vencimento;
   
    private int estadoMatricula = 1;

    public Aluno() {
 
    }

    public Aluno(String cpf, String rg, String nome,
            String dataNascimento, String email, char sexo) {
        super(cpf, rg, nome, dataNascimento, email, sexo);
       
    }

   

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }

    public String getDataExame() {
        return dataExame;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getVencimento() {
        return vencimento;
    }

   

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setEstadoMatricula(int estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

    public int getEstadoMatricula() {
        return estadoMatricula;
    }

}
