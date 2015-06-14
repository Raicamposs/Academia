package gerenciador.turma;

import gerenciador.alunos.Aluno;
import gerenciador.aula.Aula;

/*
 * @author Evolute
 */

public class Turma {

    private Aluno aluno;
    private Aula aula;
    private DiasSemana semana;
    private String horario;


// Declaração do construtor da classe Turma//
public Turma (Aluno aluno, Aula aula, DiasSemana semana,String horario){

this.aluno = aluno;
this.aula = aula;
this.semana = semana;
this.horario = horario;
}
//Declaração do método horario

    public void sethorario(String horario) {
        this.horario = horario;
        // Altera a variavel horario da classe Funcao para o parametro passado
    }

    //Declaração do método horario 
    public String gethorario() {
        return horario;
        //retorna o Valor da Variavel  horario
    }
}
