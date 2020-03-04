package dao;

import static dao.Dados.listServicos;
import java.util.List;
import modelo.Cliente;
import modelo.Servico;

public class DAOServico {

    public DAOServico() {
    }

    public List<Servico> getLista() {
        return Dados.listServicos;
    }

    public boolean salvar(Servico servico) {
        int i = 0;

        if (servico.getCodigo() == null) {
            int codigo = Dados.listServicos.size();
            while (i < Dados.listServicos.size()) {
                if (Dados.listServicos.get(i).getCodigo() == codigo) {
                    codigo++;
                }
                i++;
            }
            servico.setCodigo(codigo);
            Dados.listServicos.add(servico);
        }
        return true;
    }

    public boolean remover(Servico servico) {
        Dados.listServicos.remove(servico);
        return true;
    }

    public void popularBancoServicos() {
        Servico serv1 = new Servico();
        Servico serv2 = new Servico();

        serv1.setCodigo(1);
        serv1.setDescricao("Manutenção");

        serv2.setCodigo(2);
        serv2.setDescricao("Instalação");

        listServicos.add(serv1);
        listServicos.add(serv2);
    }
}
