
package modelo;


public class Funcionario {
    private Integer codigo;
    private String nome;


    public Funcionario(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
 
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    public Funcionario(){
        this.codigo = codigo;
        this.nome = nome; 
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
