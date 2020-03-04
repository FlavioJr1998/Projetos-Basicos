
package modelo;

public class OS {
    private Integer codigo;
    private String descricao;
    Servico servico = new Servico();
    Funcionario funcionario = new Funcionario();
    Cliente cliente = new Cliente();
    private double custo;
    
    public OS(Integer codigo, String descricao ,Servico servico, Funcionario funcionario, Cliente cliente) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.servico = servico;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.custo = custo;
    }

    public OS() {
        this.codigo = codigo;
        this.descricao = descricao;
        this.servico = servico;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.custo = custo;
    }

    @Override
    public String toString() {
        return descricao ;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
