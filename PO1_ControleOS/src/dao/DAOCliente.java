package dao;

import static dao.Dados.listClientes;
import java.util.List;
import modelo.Cidade;
import modelo.Cliente;
import modelo.Endereco;

public class DAOCliente {

    public DAOCliente() {
    }

    public List<Cliente> getLista() {
        return Dados.listClientes;
    }

    public boolean salvar(Cliente cliente) {
        int i = 0;

        if (cliente.getCodigo() == null) {
            int codigo = Dados.listClientes.size();
            
            while (i < Dados.listClientes.size()) {
                
                if (Dados.listClientes.get(i).getCodigo() == codigo) {
                    codigo++;
                }
                i++;
            }

            cliente.setCodigo(codigo);
            Dados.listClientes.add(cliente);
        }

        return true;
    }

    public boolean remover(Cliente cliente) {
        Dados.listClientes.remove(cliente);
        return true;
    }

    public void popularBancoClientes() {
        Cliente cli1 = new Cliente();
        Endereco end1 = new Endereco();
        Cidade cid1 = new Cidade();

        cli1.setCodigo(1);
        cli1.setNome("João Marciano dos santos");
        end1.setCodigo(1);
        end1.setCep("85990000");
        end1.setRua("Av.Francis peixoto");
        end1.setNumero("138");
        end1.setBairro("Centro");
        cid1.setCodigo(1);
        cid1.setNome("Terra roxa");
        cid1.setEstado("PR");
        end1.setCidade(cid1);
        cli1.setEndereco(end1);
        
        Cliente cli2 = new Cliente();
        Endereco end2 = new Endereco();
        Cidade cid2 = new Cidade();
        
        cli2.setCodigo(2);
        cli2.setNome("Pedro oliveira da silva");
        end2.setCodigo(2);
        end2.setCep("04843425");
        end2.setRua("Viela 16");
        end2.setNumero("450");
        end2.setBairro("Parque São José");
        cid2.setCodigo(2);
        cid2.setNome("São Paulo");
        cid2.setEstado("SP");
        end2.setCidade(cid2);
        cli2.setEndereco(end2);
        
        Cliente cli3 = new Cliente();
        Endereco end3 = new Endereco();
        Cidade cid3 = new Cidade();
        
        cli3.setCodigo(3);
        cli3.setNome("Marco antonio de oliveira");
        end3.setCodigo(3);
        end3.setCep("21351050");
        end3.setRua("Estrada do Portela");
        end3.setNumero("279");
        end3.setBairro("Madureira");
        cid3.setCodigo(3);
        cid3.setNome("Rio de janeiro");
        cid3.setEstado("RJ");
        end3.setCidade(cid3);
        cli3.setEndereco(end3);
        
        listClientes.add(cli1);
        listClientes.add(cli2);
        listClientes.add(cli3);
    }
}
