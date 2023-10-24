
package service;

import java.util.List;
import model.bo.Aluno;
import model.DAO.AlunoDAO;
import model.DAO.EnderecoDAO;
import model.bo.Endereco;

public class ServiceAluno {

    public static void Incluir(Aluno objeto){

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.Create(objeto);
    }    

    public static void Atualizar(Aluno objeto) {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.Update(objeto);  
    }
    
    public static List<Aluno> Buscar(){
        AlunoDAO alunoDAO = new AlunoDAO();
        return (alunoDAO.Retrieve());  
    }
    
     public static Aluno Buscar(int id){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.Retrieve(id);  
    }
     
     public static void Deletar(Aluno objeto){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.Delete(objeto);  
    }
}
