
package gerenciador.aula;

/**
 *
 * @author Raiane
 */
public class Aula {

    protected String dia, horaEntrada, horaSaida, professor, turma;

    public Aula(String dia, String horaEntrada, String horaSaida, String professor, String turma) {
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.professor = professor;
        this.turma = turma;
    }

    public String getDia() {
        return dia;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public String getProfessor() {
        return professor;
    }

    public String getTurma() {
        return turma;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

}
