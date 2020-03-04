/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Dados.listEnderecos;
import java.util.List;
import modelo.Endereco;

public class DAOEndereco {

    public DAOEndereco() {

    }

    public List<Endereco> getLista() {
        return Dados.listEnderecos;

    }

    public boolean salvar(Endereco end) {
        int i = 0;

        if (end.getCodigo() == null) {

            Integer codigo = Dados.listEnderecos.size();

            while (i < Dados.listEnderecos.size()) {
                if (Dados.listEnderecos.get(i).getCodigo() == codigo) {
                    codigo++;
                }
                i++;
            }
            end.setCodigo(codigo);
            Dados.listEnderecos.add(end);
        }
        return true;
    }

    public boolean remover(Endereco end) {
        Dados.listEnderecos.remove(end);
        return true;
    }

}
