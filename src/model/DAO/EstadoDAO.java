
package model.DAO;

import java.util.List;
import model.bo.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EstadoDAO implements InterfaceDAO<Estado> {

    @Override
    public void Create(Estado objeto) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "INSERT INTO estado(nome,sigla,paisId,regiaoId,status) VALUES(?,?,?,?,?)";        
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.setString  (2, objeto.getSigla());
            pstm.setInt (3, objeto.getPais().getId());
            pstm.setInt (4, objeto.getRegiao().getId());
            pstm.setBoolean (5, objeto.getStatus());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Estado> Retrieve() {
        Connection conexao = ConectionFactory.getConection();
        String sqlExecutar = "SELECT id,nome,sigla,paisId,regiaoId,status FROM estado ORDER BY nome";  
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Estado> estados = new ArrayList();
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Estado estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                
                PaisDAO paisDAO = new PaisDAO();
                estado.setPais(paisDAO.Retrieve(rs.getInt("paisId")));
                
                RegiaoDAO regiaoDAO = new RegiaoDAO();
                estado.setRegiao(regiaoDAO.Retrieve(rs.getInt("regiaoId")));
                
                estado.setStatus(rs.getBoolean("status"));
                
                estados.add(estado);
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return estados;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public Estado Retrieve(int id) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "SELECT id,nome,sigla,paisId,regiaoId,status FROM estado WHERE  estado.id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Estado estado = new Estado();
            while(rs.next()){
                estado.setId    (rs.getInt("id"));
                estado.setNome  (rs.getString("nome"));
                estado.setSigla (rs.getString("sigla"));
                
                PaisDAO paisDAO = new PaisDAO();
                estado.setPais  (paisDAO.Retrieve(rs.getInt("paisId")));
                
                RegiaoDAO regiaoDAO = new RegiaoDAO();
                estado.setRegiao(regiaoDAO.Retrieve(rs.getInt("regiaoId")));
                
                estado.setStatus(rs.getBoolean("status"));
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return estado;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public void Update(Estado objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "UPDATE estado SET nome=?,sigla=?,paisId=?,regiaoId=?,status=? WHERE id=?";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.setString  (2, objeto.getSigla());
            pstm.setInt     (3, objeto.getPais().getId());
            pstm.setInt     (4, objeto.getRegiao().getId());
            pstm.setBoolean (5, objeto.getStatus());
            pstm.setInt     (6, objeto.getId());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);        
    }

    @Override
    public void Delete(Estado objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "DELETE FROM estado WHERE id=?";        
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
