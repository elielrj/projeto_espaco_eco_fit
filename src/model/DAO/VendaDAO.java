
package model.DAO;

import java.util.List;
import model.bo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class VendaDAO implements InterfaceDAO<Venda>{

    @Override
    public void Create(Venda objeto) {
        
        Connection conexao = ConectionFactory.getConection();     
        
        String sqlExecutar = "INSERT INTO venda(data,hora,dataDeVencimento,observacao,valorDeDesconto,valorTotal,alunoId,personalId) VALUES(?,?,?,?,?,?,?,?)";    
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getData());
            pstm.setString(2, objeto.getHora());
            pstm.setString(3, objeto.getDataDeVencimento());
            pstm.setString(4, objeto.getObservacao());
            pstm.setFloat(5, objeto.getValorDoDesconto());
            pstm.setFloat(6, objeto.getValorTotal());
            pstm.setInt(7, objeto.getAluno().getId());
            pstm.setInt(8, objeto.getPersonal().getId());
            
            pstm.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        ConectionFactory.closeConnection(conexao, pstm);
    }
    

    @Override
    public List<Venda> Retrieve() {

        Connection conexao = ConectionFactory.getConection();
        
        String sqlExecutar = "SELECT data,hora,dataDeVencimento,observacao,valorDeDesconto,valorTotal,alunoId,personalId FROM venda";
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        List<Venda> vendas = new ArrayList();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            
            
            while(rs.next()){
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setData(rs.getString("data"));
                venda.setHora(rs.getString("hora")); 
                venda.setDataDeVencimento(rs.getString("dataDeVencimento"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setValorDoDesconto(rs.getFloat("valorDeDesconto"));
                venda.setValorTotal(rs.getFloat("valorTotal"));
                
                AlunoDAO alunoDAO = new AlunoDAO();
                venda.setAluno(alunoDAO.Retrieve(rs.getInt("alunoId")));
                
                PersonalDAO personalDAO = new PersonalDAO();
                venda.setPersonal(personalDAO.Retrieve(rs.getInt("personalId")));
                
                vendas.add(venda);
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return vendas;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public Venda Retrieve(int id) {
        Connection conexao = ConectionFactory.getConection();
        
        String sqlExecutar = "SELECT id,data,hora,valorDeDescontoNegociado, valorDeAcrescimo,valorRecebido, observacao,vendaId FROM venda WHERE venda.id=?";
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
 
        
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1,id);
            rs = pstm.executeQuery();
            
            Venda venda = new Venda();
            
            while(rs.next()){
                venda.setId(rs.getInt("id"));
                venda.setData(rs.getString("data"));
                venda.setHora(rs.getString("hora")); 
                venda.setDataDeVencimento(rs.getString("dataDeVencimento"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setValorDoDesconto(rs.getFloat("valorDeDesconto"));
                venda.setValorTotal(rs.getFloat("valorTotal"));
                
                AlunoDAO alunoDAO = new AlunoDAO();
                venda.setAluno(alunoDAO.Retrieve(rs.getInt("alunoId")));
                
                PersonalDAO personalDAO = new PersonalDAO();
                venda.setPersonal(personalDAO.Retrieve(rs.getInt("personalId")));
                
                
            }
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return venda;
        }catch(Exception ex){
            ConectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public void Update(Venda objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "UPDATE venda SET data = ?, hora = ?, dataDeVencimento= ?,observacao = ?, valorDoDesconto = ?, valorTotal =?, alunoId = ?, personalId = ? WHERE id=?"; 
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, objeto.getData());
            pstm.setString(2, objeto.getHora());
            pstm.setString(3, objeto.getDataDeVencimento());
            pstm.setString(4, objeto.getObservacao());
            pstm.setDouble(5, objeto.getValorDoDesconto());
            pstm.setDouble(6, objeto.getValorTotal());
            pstm.setInt(7, objeto.getAluno().getId());
            pstm.setInt(8, objeto.getPersonal().getId());
            pstm.setInt(9, objeto.getId());
            pstm.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        ConectionFactory.closeConnection(conexao, pstm); 
    }

    @Override
    public void Delete(Venda objeto) {
        Connection conexao = ConectionFactory.getConection();        
        String sqlExecutar = "DELETE FROM venda WHERE id = ?";        
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
