
package model.DAO;

import java.util.List;
import model.bo.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BairroDAO implements InterfaceDAO<Bairro> {

    @Override
    public void Create(Bairro objeto) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "INSERT INTO bairro(nome,cidadeId,status) VALUES(?,?,?)";        
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.setInt     (2, objeto.getCidade().getId());
            pstm.setBoolean (3, objeto.getStatus());
            pstm.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Bairro> Retrieve() {
        Connection conexao = ConectionFactory.getConection();
        String sqlExecutar = "SELECT id,nome,cidadeId,status FROM bairro ORDER BY nome";  
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Bairro> bairros = new ArrayList();
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            while(rs.next()){
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id"));
                bairro.setNome(rs.getString("nome"));
                CidadeDAO cidadeDAO = new CidadeDAO();
                bairro.setCidade(cidadeDAO.Retrieve(rs.getInt("cidadeId")));
                bairro.setStatus(rs.getBoolean("status"));
                bairros.add(bairro);
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return bairros;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public Bairro Retrieve(int id) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "SELECT id,nome,cidadeId,status FROM bairro WHERE bairro.id=?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Bairro bairro = new Bairro();
            while(rs.next()){
                bairro.setId(rs.getInt("id"));
                bairro.setNome(rs.getString("nome"));
                CidadeDAO cidadeDAO = new CidadeDAO();
                bairro.setCidade(cidadeDAO.Retrieve(rs.getInt("cidadeId")));
                bairro.setStatus(rs.getBoolean("status"));
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return bairro;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }   
    }

    @Override
    public void Update(Bairro objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "UPDATE bairro SET nome=?,cidadeId=?,status=?  WHERE id=?";        
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setInt(2, objeto.getCidade().getId());
            pstm.setBoolean(3, objeto.getStatus());
            pstm.setInt(4, objeto.getId());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);        
    }

    @Override
    public void Delete(Bairro objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "DELETE FROM bairro WHERE id = ?";        
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
