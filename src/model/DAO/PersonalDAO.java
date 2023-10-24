
package model.DAO;

import java.util.List;
import model.bo.Personal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonalDAO implements InterfaceDAO<Personal>{

    @Override
    public void Create(Personal objeto) {
        
        Connection conexao = ConectionFactory.getConection();
        
        String sqlExecutar = "INSERT INTO personal(nome, rg, cpf, dataDeNascimento, complemento, telefone1, telefone2, email, observacao,  enderecoId) VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getRg());
            pstm.setString(3, objeto.getCpf());
            pstm.setString(4, objeto.getDataDeNascimento());
            pstm.setString(5, objeto.getComplemento());
            pstm.setString(6, objeto.getTelefone1());
            pstm.setString(7, objeto.getTelefone2());
            pstm.setString(8, objeto.getEmail());
            pstm.setString(9, objeto.getObservacao());
            pstm.setInt(10, objeto.getEndereco().getId());

            pstm.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        ConectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Personal> Retrieve() {
        Connection conexao = ConectionFactory.getConection();
        
        String sqlExecutar = "SELECT id,nome, rg, cpf, dataDeNascimento, complemento, telefone1, telefone2, email, observacao, enderecoId FROM personal";
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            List<Personal> personais = new ArrayList();
            
            while(rs.next()){
                Personal personal = new Personal();
                
                personal.setId(rs.getInt("id"));
                personal.setRg(rs.getString("rg"));
                personal.setCpf(rs.getString("cpf")); 
                personal.setDataDeNascimento(rs.getString("dataDeNascimento"));
                personal.setComplemento(rs.getString("complemento"));
                personal.setTelefone1(rs.getString("telefone1"));
                personal.setTelefone2(rs.getString("telefone2"));
                personal.setEmail(rs.getString("email"));
                personal.setObservacao(rs.getString("observacao"));
                
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                personal.setEndereco(enderecoDAO.Retrieve(rs.getInt("enderecoId")));
                
                personais.add(personal);
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return personais;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
        
    }

    @Override
    public Personal Retrieve(int id) {

        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "SELECT id, nome, rg, cpf, dataDeNascimento, complemento, telefone1, telefone2, email, observacao, enderecoId FROM personal WHERE  personal.id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);           
            rs = pstm.executeQuery();
            Personal personal = new Personal();

            while(rs.next()){
                personal.setId(rs.getInt("id"));
                personal.setNome(rs.getString("nome"));
                personal.setRg(rs.getString("rg"));
                personal.setCpf(rs.getString("cpf"));
                personal.setDataDeNascimento(rs.getString("dataDeNascimento"));
                personal.setComplemento(rs.getString("complemento"));
                personal.setTelefone1(rs.getString("telefone1"));
                personal.setTelefone2(rs.getString("telefone2"));
                personal.setEmail(rs.getString("email"));
                personal.setObservacao(rs.getString("observacao"));
                
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                personal.setEndereco(enderecoDAO.Retrieve(rs.getInt("enderecoId")));
            }
            
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return personal;
            
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
        
    }

    @Override
    public void Update(Personal objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "UPDATE personal SET nome =?, rg =?, cpf = ?, dataDeNascimento = ? ,complemento = ?, telefone1 = ?, telefone2 = ?, email = ?, observacao = ?, enderecoId = ?, WHERE id = ?"; 
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getId());
            pstm.setString(2, objeto.getRg());
            pstm.setString(3, objeto.getNome());
            pstm.setString(4, objeto.getCpf());
            pstm.setString(5, objeto.getDataDeNascimento());
            pstm.setString(6, objeto.getComplemento());
            pstm.setString(7, objeto.getTelefone1());
            pstm.setString(8, objeto.getTelefone2());
            pstm.setString(9, objeto.getEmail());
            pstm.setString(10, objeto.getObservacao());
            pstm.setInt(11, objeto.getEndereco().getId());
            
            pstm.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);  
    }

    @Override
    public void Delete(Personal objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "DELETE FROM personal WHERE id =?";        
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
