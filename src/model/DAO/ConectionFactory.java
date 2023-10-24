
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConectionFactory {

        private static final String driver = "com.mysql.jdbc.Driver";
        
        private static final String banco = "jdbc:mysql://localhost:3306/senhoritaluxo";//jdbc:mysql://localhost:3306/espacoecofit?useTimezone=true&serverTimezone=UTC
        private static final String usuario = "root";
        private static final String senha = "root";
      
        
        public static Connection getConection() {
            
            try{

                return DriverManager.getConnection(banco + "?verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false"
                    + "&USER=" + usuario + "&password=" + senha + "&serverTimezone=UTC" );
                
            }
            catch(SQLException ex){
   
                ex.printStackTrace();
                    return null;
            }
        }

        public static void closeConnection(Connection conexao){
            
            try{
                conexao.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        public static void closeConnection(Connection conexao, PreparedStatement pstm){
            try{
                pstm.close();
                conexao.close();
                
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        public static void closeConnection(Connection conexao, PreparedStatement pstm, ResultSet rst){
            
            try{
                pstm.close();
                conexao.close();
                conexao.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
}
 
