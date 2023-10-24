
package service;

import java.util.List;
import model.bo.Pais;
import model.DAO.PaisDAO;

public class ServicePais {

    public static void Incluir(Pais objeto){

        PaisDAO paisDAO = new PaisDAO();
        paisDAO.Create(objeto);

    }    

    public static void Atualizar(Pais objeto) {
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.Update(objeto);  
    }
    
    public static List<Pais> Buscar(){
        PaisDAO paisDAO = new PaisDAO();
        return (paisDAO.Retrieve());  
    }
    
     public static Pais Buscar(int id){
        PaisDAO paisDAO = new PaisDAO();
        return paisDAO.Retrieve(id);  
    }
     
     public static void Deletar(Pais objeto){
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.Delete(objeto);  
    }
}
