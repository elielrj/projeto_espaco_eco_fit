package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Aluno;

public class AlunoDAO implements InterfaceDAO<Aluno>{

    @Override
    public void Create(Aluno objeto) {
        
        Connection conexao = ConectionFactory.getConection();
        String sqlExecutar = "INSERT INTO aluno(nome, rg, cpf, dataDeNascimento, complemento, telefone1, telefone2, email, observacao, enderecoId) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
    public List<Aluno> Retrieve() {
        Connection conexao = ConectionFactory.getConection();
        
        String sqlExecutar = "SELECT id, nome, rg, cpf, dataDeNascimento, complemento, telefone1, telefone2, email, observacao, enderecoId FROM aluno";
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            List<Aluno> alunos = new ArrayList();
            
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf")); 
                aluno.setDataDeNascimento(rs.getString("dataDeNascimento"));
                aluno.setComplemento(rs.getString("complemento"));
                aluno.setTelefone1(rs.getString("telefone1"));
                aluno.setTelefone2(rs.getString("telefone2"));
                aluno.setEmail(rs.getString("email"));
                aluno.setObservacao(rs.getString("observacao"));
                
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                aluno.setEndereco(enderecoDAO.Retrieve(rs.getInt("enderecoId")));
                
                alunos.add(aluno);
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return alunos;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
        
    }

    @Override
    public Aluno Retrieve(int id) {

        Connection conexao = ConectionFactory.getConection();       
        String sqlExecutar = "SELECT id, nome, rg, cpf, dataDeNascimento, complemento, telefone1, telefone2, email, observacao, enderecoId FROM aluno WHERE  aluno.id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);           
            rs = pstm.executeQuery();
            Aluno aluno = new Aluno();

            while(rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDataDeNascimento(rs.getString("dataDeNascimento"));
                aluno.setComplemento(rs.getString("complemento"));
                aluno.setTelefone1(rs.getString("telefone1"));
                aluno.setTelefone2(rs.getString("telefone2"));
                aluno.setEmail(rs.getString("email"));
                aluno.setObservacao(rs.getString("observacao"));
                
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                aluno.setEndereco(enderecoDAO.Retrieve(rs.getInt("enderecoId")));
                
            }
            
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return aluno;
            
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
        
    }

    @Override
    public void Update(Aluno objeto) {
        
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "UPDATE aluno SET nome = ?, rg = ?,cpf =?, dataDeNascimento = ?, complemento = ?, telefone1 = ?, telefone2 = ?, email = ?, observacao = ?, enderecoId = ? WHERE id = ?"; 
        
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
            pstm.setInt(11, objeto.getId());
            pstm.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm);        
    }

    @Override
    public void Delete(Aluno objeto) {
        
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "DELETE FROM aluno WHERE id = ?";        
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
