
package modelo;


public class Cliente {
    private Integer codigo;
    private String nome;
    Endereco endereco = new Endereco();

    public Cliente(Integer codigo, String nome, Endereco endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
       
    }

    @Override
    public String toString() {
        return nome;
    }
    
    public Cliente(){
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
       
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
