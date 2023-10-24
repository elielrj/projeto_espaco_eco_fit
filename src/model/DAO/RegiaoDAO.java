
package model.DAO;

import java.util.List;
import model.bo.Regiao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RegiaoDAO implements InterfaceDAO<Regiao> {

    @Override
    public void Create(Regiao objeto) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "INSERT INTO regiao(nome) VALUES(?)";        
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Regiao> Retrieve() {
        Connection conexao = ConectionFactory.getConection();
        String sqlExecutar = "SELECT id,nome FROM regiao ORDER BY nome";  
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Regiao> regioes = new ArrayList();
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            while(rs.next()){
                Regiao regiao = new Regiao();
                regiao.setId      (rs.getInt("id"));
                regiao.setNome    (rs.getString("nome"));
                regioes.add(regiao);
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return regioes;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public Regiao Retrieve(int id) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "SELECT id,nome FROM regiao WHERE  regiao.id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Regiao regiao = new Regiao();
            while(rs.next()){
                regiao.setId(rs.getInt("id"));
                regiao.setNome(rs.getString("nome"));
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return regiao;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public void Update(Regiao objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "UPDATE regiao SET nome=? WHERE id=?";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.setInt     (1, objeto.getId());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);        
    }

    @Override
    public void Delete(Regiao objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "DELETE FROM regiao WHERE id=?";        
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
