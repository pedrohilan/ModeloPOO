package Controller;

import Model.Conexao;
import Model.MPessoa;
import java.sql.ResultSet;

public class C_Pessoa {

    MPessoa mPessoa = new MPessoa(null,0);
    Conexao conexao = new Conexao();
    ResultSet resultset;
    public void Salvar(String nome) {       
        mPessoa.setNome(nome);
        conexao.InserirSQL("INSERT INTO tb_pessoa (pes_nome) VALUES ('"+mPessoa.getNome()+"')");          
    }
    public ResultSet Pesquisar(String pesquisa){
        mPessoa.setNome(pesquisa);     
        resultset = conexao.PesquisarSQL("Select * from tb_pessoa");       
        return resultset;
    }
    public void Excluir(String nome) {
        conexao.InserirSQL("DELETE FROM tb_pessoa WHERE pes_nome = '" + nome + "';");
    }
    public void Editar(String nome){
        conexao.InserirSQL("UPDATE `tb_pessoa` SET pes_nome = '" + nome + "'");
    }
    
    public void Conectar(){
        conexao.Conectar();
    }
    public void Desconectar(){
        conexao.Desconectar();
    }
}
