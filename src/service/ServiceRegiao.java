
package service;

import java.util.List;
import model.bo.Regiao;
import model.DAO.RegiaoDAO;

public class ServiceRegiao {

    public static void Incluir(Regiao objeto){

        RegiaoDAO regiaoDAO = new RegiaoDAO();
        regiaoDAO.Create(objeto);

    }    

    public static void Atualizar(Regiao objeto) {
        RegiaoDAO regiaoDAO = new RegiaoDAO();
        regiaoDAO.Update(objeto);  
    }
    
    public static List<Regiao> Buscar(){
        RegiaoDAO regiaoDAO = new RegiaoDAO();
        return (regiaoDAO.Retrieve());  
    }
    
     public static Regiao Buscar(int id){
        RegiaoDAO regiaoDAO = new RegiaoDAO();
        return regiaoDAO.Retrieve(id);  
    }
     
     public static void Deletar(Regiao objeto){
        RegiaoDAO regiaoDAO = new RegiaoDAO();
        regiaoDAO.Delete(objeto);  
    }
}
