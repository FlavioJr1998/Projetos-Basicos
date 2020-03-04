
package dao;

import java.util.List;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.OS;
import modelo.Servico;

public class DAOOS {
    
    public DAOOS(){
    }
    
     public List<OS> getLista(){
        return Dados.listOS; 
    }
    
    public boolean salvar (OS os){
        int i = 0;
        
        if (os.getCodigo()== null){  
            Integer codigo = Dados.listOS.size();
             while (i < Dados.listOS.size()) {
                 System.out.println(Dados.listOS.get(i).getCliente().getNome());
                if (Dados.listOS.get(i).getCodigo() == codigo) {
                    codigo++;
                }
                i++;
            }
            os.setCodigo(codigo);
            Dados.listOS.add(os);
            
        }
        return true;
    }
    
    public boolean remover (OS os){
        Dados.listOS.remove(os);
        return true;
    }
    
    public void popularBancoOS(){
        OS os1 = new OS();   
        Cliente cli = new Cliente();
        Funcionario func1 = new Funcionario();
        Servico serv1 = new Servico();
        
        os1.setCodigo(0);
        os1.setDescricao("Trocar roteador");
        os1.setCliente(Dados.listClientes.get(0));
        os1.setFuncionario(Dados.listFuncionarios.get(0));
        os1.setServico(Dados.listServicos.get(0));
        os1.setCusto(25);
        
        OS os2 = new OS();
        os2.setCodigo(1);
        os2.setDescricao("Instalação de internet");
        os2.setCliente(Dados.listClientes.get(1));
        os2.setFuncionario(Dados.listFuncionarios.get(1));
        os2.setServico(Dados.listServicos.get(1));
        os2.setCusto(80);
        
        Dados.listOS.add(os1);
        Dados.listOS.add(os2);
    } 
   
}
