
package model.DAO;

import java.util.List;
import model.bo.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CidadeDAO implements InterfaceDAO<Cidade>{

    @Override
    public void Create(Cidade objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "INSERT INTO cidade(nome,estadoId,status) VALUES(?,?,?)"; 
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.setInt     (2, objeto.getEstado().getId());
            pstm.setBoolean (3, objeto.getStatus());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);
    }
    

    @Override
    public List<Cidade> Retrieve() {
        Connection conexao = ConectionFactory.getConection();
        String sqlExecutar = "SELECT id,nome,estadoId,status FROM cidade ORDER BY nome";  
        PreparedStatement pstm = null;
        ResultSet rs = null;                
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            List<Cidade> cidades = new ArrayList();
            while(rs.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                
                EstadoDAO estadoDAO = new EstadoDAO();
                
                cidade.setEstado(estadoDAO.Retrieve(rs.getInt("estadoId")));
                cidade.setStatus(rs.getBoolean("status"));
                
                cidades.add(cidade);
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return cidades;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public Cidade Retrieve(int id) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "SELECT id,nome,estadoId,status FROM cidade WHERE cidade.id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Cidade cidade = new Cidade();
            while(rs.next()){
                cidade.setId    (rs.getInt("id"));
                cidade.setNome  (rs.getString("nome"));
                EstadoDAO estadoDAO = new EstadoDAO();
                cidade.setEstado(estadoDAO.Retrieve(rs.getInt("estadoId")));
                cidade.setStatus(rs.getBoolean("status"));
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return cidade;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public void Update(Cidade objeto)
    {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "UPDATE cidade SET nome=?,estadoId=?,status=? WHERE id = ?";        
        PreparedStatement pstm = null;   
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.setInt     (2, objeto.getEstado().getId());
            pstm.setBoolean (3, objeto.getStatus());
            pstm.setInt     (4, objeto.getId());
            pstm.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);        
    }

    @Override
    public void Delete(Cidade objeto){
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "DELETE FROM cidade WHERE id=?";        
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getId());
            pstm.executeUpdate();            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);
    }
}
