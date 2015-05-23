package Funcionario;


public class Funcao {

    /**
     * Método construtor. Você deve utiliza-lo para criar o registro de um novo
     * author .
     *
     * @param funcaoId id da Funcao
     * @param funcaoNome nome da Funcao
     * @author 
     */
    private int funcaoId;
    private String funcaoNome;

    // Declaração do construtor da classe funcao//
    public Funcao(int funcaoId, String funcaoNome) {

        this.funcaoId = funcaoId;
        this.funcaoNome = funcaoNome;
    }
// Declaração do construtor da classe funcao//

    public Funcao(String funcaoNome) {

        this.funcaoNome = funcaoNome;
    }

    //Declaração do método funcaoId

    public void setFuncaoId(int funcaoId) {
        this.funcaoId = funcaoId;
        // Altera a variavel funcaoId da classe Funcao para o parametro passado
    }

    //Declaração do método setFuncaoNome

    public void setFuncaoNome(String funcaoNome) {
        this.funcaoNome = funcaoNome;
        // Altera a variavel funcaoNome da classe Funcao para o parametro passado
    }

    //Declaração do método getFuncaoId 

    public int getFuncaoId() {
        return funcaoId;
        //retorna o Valor da Variavel  funcaoId
    }

    //Declaração do método getFuncaoNome

    public String getFuncaoNome() {
        return funcaoNome;
        //retorna o Valor da Variavel  funcaoNome
    }

}
