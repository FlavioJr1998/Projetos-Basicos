/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Dados.listFuncionarios;
import java.util.List;
import modelo.Funcionario;

public class DAOFuncionario {

    public DAOFuncionario() {

    }

    public List<Funcionario> getLista() {
        return Dados.listFuncionarios;

    }

    public boolean salvar(Funcionario func) {
        int i = 0;

        if (func.getCodigo() == null) {
            Integer codigo = Dados.listFuncionarios.size() + 1;
            while (i < Dados.listClientes.size()) {
                if (Dados.listClientes.get(i).getCodigo() == codigo) {
                    codigo++;
                }
                i++;
            }
            func.setCodigo(codigo);
            Dados.listFuncionarios.add(func);

        }
        return true;
    }

    public boolean remover(Funcionario func) {
        Dados.listFuncionarios.remove(func);
        return true;
    }

    public void popularBancoFuncionario() {
        Funcionario func1 = new Funcionario();
        Funcionario func2 = new Funcionario();

        func1.setCodigo(1);
        func1.setNome("Adalberto gomes");

        func2.setCodigo(2);
        func2.setNome("Miroslav Klose");

        listFuncionarios.add(func1);
        listFuncionarios.add(func2);
    }

}
