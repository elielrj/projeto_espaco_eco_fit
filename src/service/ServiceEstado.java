
package service;

import java.util.List;
import model.bo.Estado;
import model.DAO.EstadoDAO;

public class ServiceEstado {

    public static void Incluir(Estado objeto){

        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.Create(objeto);

    }    

    public static void Atualizar(Estado objeto) {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.Update(objeto);  
    }
    
    public static List<Estado> Buscar(){
        EstadoDAO estadoDAO = new EstadoDAO();
        return (estadoDAO.Retrieve());  
    }
    
     public static Estado Buscar(int id){
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.Retrieve(id);  
    }
     
     public static void Deletar(Estado objeto){
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.Delete(objeto);
    }
}
