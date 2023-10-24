
package model.DAO;

import java.util.List;
import model.bo.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaisDAO implements InterfaceDAO<Pais> {

    @Override
    public void Create(Pais objeto) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "INSERT INTO pais(nome,name,status) VALUES(?,?,?)";        
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.setString  (2, objeto.getName());
            pstm.setBoolean (3, objeto.getStatus());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Pais> Retrieve() {
        Connection conexao = ConectionFactory.getConection();
        
        String sqlExecutar = "SELECT id,nome,name,status FROM pais ORDER BY id";  
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Pais> paises = new ArrayList();
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            while(rs.next()){
                Pais pais = new Pais();
                pais.setId      (rs.getInt("id"));
                pais.setNome    (rs.getString("nome"));
                pais.setName    (rs.getString("name"));
                pais.setStatus  (rs.getBoolean("status"));
                paises.add(pais);
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return paises;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public Pais Retrieve(int id) {
        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "SELECT id,nome,name,status FROM pais WHERE  pais.id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Pais pais = new Pais();
            while(rs.next()){
                pais.setId(rs.getInt("id"));
                pais.setNome(rs.getString("nome"));
                pais.setName(rs.getString("name"));
                pais.setStatus(rs.getBoolean("status"));
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return pais;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public void Update(Pais objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "UPDATE pais SET nome=?,name=?,status=? WHERE id=?";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString  (1, objeto.getNome());
            pstm.setString  (2, objeto.getName());
            pstm.setBoolean (3, objeto.getStatus());
            pstm.setInt     (4, objeto.getId());
            pstm.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);        
    }

    @Override
    public void Delete(Pais objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "DELETE FROM pais WHERE id = ?";        
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
