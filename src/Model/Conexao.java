package Model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    //Constante com o endereço do Driver
    private final String driver = "com.mysql.cj.jdbc.Driver";
    // objeto conexao e statement
    private Connection conexao;
    private Statement statement;
    private ResultSet resultset;

    public void Conectar() {
        try {
            //busca pelo drive atrvés do endereço
            Class.forName(driver);     
            //Passando os parametros da conexao
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cadastro", "root", "root");
            // Executar ações no banco de dados
            statement = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } 
        catch (SQLException | ClassNotFoundException ex) {                                                                  
            JOptionPane.showMessageDialog(null,"Erro ao conectar" + ex);
        }
    }
    public void InserirSQL(String SQL){
        try {
          statement.execute(SQL);
        } catch (SQLException ex) {
            
        }
    }
    public ResultSet PesquisarSQL(String SQL){
        try {
            resultset = statement.executeQuery(SQL);
            return resultset;
        } catch (SQLException ex) {
            
             return resultset;
        }
       
    }
    public void Desconectar(){
        try {
            conexao.close();
        } catch (SQLException ex) {
        }
    }
}