
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */


public abstract class SingletonSessao {

    public static Object[][] getTabelaSolicitacoes() {
    return SingletonSessao.tabelaSolicitacoes;
    }
    
    public enum TipoStatus {SOLICITACAO_ABERTA,AGUARDANDO_ATENDIMENTO,RESOLVENDO_SOLICITACAO,SOLICITACAO_CONCLUIDA;
    public static String[] toStringArray () {
    String s[] = {
                    "Solicitação Aberta ",
                    "Aguardando Atendimento ",
                    "Resolvendo Solicitação ",
                    "Solicitação Concluída"
                };
    return s;
    }
    
    };
    public static enum TipoSolicitacao {
    EQUIPAMENTO_DEFEITUOSO,EQUIPAMENTO_AUSENTE,REQUISICAO_DE_EQUIPAMENTO,INSTALACAO_PREDIAL,SISTEMA_INFORMATIZADO,LIMPEZA;
    public static String[] toStringArray () {
    String s[] = {
                    "Equipamento defeituoso",
                    "Equipamento ausente",
                    "Requisição de equipamento",
                    "Instalação predial",
                    "Sistema informatizado",
                    "Limpeza"
                };
    return s;
    }
    }
    
    public static void Reset () {
    SingletonSessao.CPF = null;
    SingletonSessao.cargo = null;
    SingletonSessao.conn = null;
    SingletonSessao.email = null;
    SingletonSessao.nomeDoUsuario = null;
    SingletonSessao.senha = null;
    SingletonSessao.siape = null;
    SingletonSessao.usuario = null;
    System.gc();
    }
    
    

    public static String[] ListaLocais () throws SQLException {
    java.sql.Statement stmt = SingletonSessao.getConn().createStatement();    
    ResultSet rs = stmt.executeQuery("SELECT distinct nome,sala FROM `local`");
    int nTuplas = 0;
    
    if (rs.last()) {
    nTuplas = rs.getRow();
    rs.beforeFirst();
    }
    
    String s[] = new String[nTuplas+1];    
    for(int i=0;rs.next();i++)
    {
    String aux = rs.getString("sala");
    s[i] = rs.getString("nome") + (aux==null ? "" : " - Sala " + aux);
    }
    s[s.length-1] = "Outro local";
    return s;
    }
    
    public static String[] ListaEquipamentos (int idLocal) throws SQLException {
    String s[];
    idLocal++;
    java.sql.Statement stmt = SingletonSessao.getConn().createStatement();    
    ResultSet rs = stmt.executeQuery("SELECT distinct nome FROM `equipamento`" + (idLocal==0 ? "" : " WHERE `FK_idLocal` = " + idLocal));
    
    int nTuplas = 0;
    
    if (rs.last()) {
    nTuplas = rs.getRow();
    rs.beforeFirst();
    }
    
    
    s = new String[nTuplas+1];
    for(int i=0;rs.next();i++)
    {
    s[i] = rs.getString("nome");
    }
    s[s.length-1] = "Outro equipamento";
    return s;
    }
    
    public static int getIdUsuario () {
    return SingletonSessao.idUsuario;
    }
    
    public static String getUsuario() {
        return usuario;
    }
    
    public static void DesconectaBD () throws SQLException {
    conn.close();
    }
    
    public static Object[][] Diff_OldTable2CurTable (Object[][] tabelaAtual) {
    return null;
    }
    
    public static void setUsuario(String usuario) throws SQLException {
        SingletonSessao.usuario = usuario;
        java.sql.Statement stmt = SingletonSessao.getConn().createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT nome,idUsuario,cpf,cargo,email,siape FROM pessoa,user where FK_idPessoa=id and usuario='"+usuario+"'");
        rs.next();
        SingletonSessao.nomeDoUsuario = rs.getString("nome");
        SingletonSessao.idUsuario = Integer.parseInt(rs.getString("idUsuario"));
        SingletonSessao.CPF = rs.getString("cpf");
        SingletonSessao.cargo = rs.getString("cargo");
        SingletonSessao.email = rs.getString("email");
        SingletonSessao.siape = rs.getString("siape");
    }
   
    public static String getSenha() {
        return senha;
    }
    
    public static void setSenha(String senha) {
        SingletonSessao.senha = senha;
    }
    
    public static String getNomeDoUsuario() {
    return SingletonSessao.nomeDoUsuario;
    }
    
    
    
    public static void Logout () {
        java.sql.Statement stmt = null;
    try {
        stmt = SingletonSessao.getConn().createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        if(SingletonSessao.getUsuario()!=null && SingletonSessao.getSenha()!=null)
        {
        stmt.execute("UPDATE user SET isLoggedIn=false WHERE usuario='"+SingletonSessao.getUsuario() + "' AND senha='" + SingletonSessao.getSenha()+"'");
        new TelaLogin().setVisible(true);
        }
    } catch (SQLException ex) {
        Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    SingletonSessao.senha = null;
    }

    public static String getCPF() {
        return CPF;
    }

    public static String getCargo() {
        return cargo;
    }


    public static String getEmail() {
        return email;
    }

    public static String getSIAPE() {
        return siape;
    }
    
    public static Object [][] ConsultaSolicitacao (String condicao) throws SQLException {
        String[] descricao;
        String[] status;
        String[] dataSolicitacao;
        String[] dataAtendimento;
        
        String[] tipoSolicitacao;
        String[] localSolicitacao;
        String[] equipamentoSolicitacao;
        
        String[] idSolicitacao;
        String[] FK_idLocal;
        String[] FK_idEquipamento;
        
        String comandoConsulta = "SELECT idSolicitacao,e.idEquipamento, s.FK_idLocal,descricao,status,dataSolicitacao,dataAtendimento,tipoSolicitacao,l.nome as lNome,l.sala,e.nome as eNome FROM solicitacao as s,equipamento as e,local as l WHERE s.FK_idSolicitador = 1 AND s.FK_idEquipamento = e.idEquipamento AND s.FK_idLocal = l.idLocal";
        Object[][] s = null;
        java.sql.Statement stmt = SingletonSessao.getConn().createStatement();
        ResultSet rs = stmt.executeQuery(comandoConsulta);
        int nTuplas = 0;
        if (rs.last()) {
        nTuplas = rs.getRow();
        rs.beforeFirst();
        }
        if(nTuplas>0)
        {
            descricao = new String[nTuplas];
            status = new String[nTuplas];
            dataSolicitacao = new String[nTuplas];
            dataAtendimento = new String[nTuplas];
            
            tipoSolicitacao = new String[nTuplas];
            localSolicitacao = new String[nTuplas];
            equipamentoSolicitacao = new String[nTuplas];
            
            idSolicitacao = new String[nTuplas];
            FK_idLocal = new String[nTuplas];
            FK_idEquipamento = new String[nTuplas];
            
            s = new String[nTuplas][10];    
            for(int i=0;rs.next();i++)
            {
            
            idSolicitacao[i] = rs.getString("idSolicitacao");
            FK_idLocal[i] = rs.getString("FK_idLocal");
            FK_idEquipamento[i] = rs.getString("idEquipamento");
            
            dataSolicitacao[i] = FormataData(rs.getString("dataSolicitacao"));
            
            dataAtendimento[i] = FormataData(rs.getString("dataAtendimento"));
            
            localSolicitacao[i] = rs.getString("lNome");
            String sala = rs.getString("sala");
            if(sala!=null)
            {
            localSolicitacao[i] = localSolicitacao[i] + " - Sala " + sala;
            }
            equipamentoSolicitacao[i] = rs.getString("eNome");
            
            tipoSolicitacao[i] = TipoSolicitacao.toStringArray()[TipoSolicitacao.valueOf(rs.getString("tipoSolicitacao")).ordinal()];
            
            descricao[i] = rs.getString("descricao");
            status[i] = TipoStatus.toStringArray()[TipoStatus.valueOf(rs.getString("status")).ordinal()];
            
            Object aux[] = {
                            (Object) dataSolicitacao[i]==null ? "Não Consta" : dataSolicitacao[i],
                            (Object) localSolicitacao[i]==null ? "Não Consta" : localSolicitacao[i],
                            (Object) equipamentoSolicitacao[i]==null ? "Não Consta" : equipamentoSolicitacao[i],
                            (Object) tipoSolicitacao[i]==null ? "Não Consta" : tipoSolicitacao[i],
                            (Object) status[i]==null ? "Não Consta" : status[i],
                            (Object) dataAtendimento[i]==null ? "Não Consta" : dataAtendimento[i],
                            (Object) descricao[i]==null ? "Não Consta" : descricao[i],
                            (Object) idSolicitacao[i],
                            (Object) FK_idLocal[i],
                            (Object) FK_idEquipamento[i],
                            };
            System.arraycopy(aux,0,s[i],0,10);
            }
        }
    SingletonSessao.tabelaSolicitacoes = s;
    return s;
    }
    
    private static String FormataData (String s) {
    String dia = null,mes = null,ano = null;
    if(s!=null)
    {
    dia = s.substring(8,10);
    mes = s.substring(5,7);
    ano = s.substring(0,4);
    s = (dia+"/"+mes+"/"+ano);
    }
    return s;
    }
    
    public static String toTitleCase(String input) {
    StringBuilder titleCase = new StringBuilder();
    if(input!=null)
    {
    input = input.toLowerCase();
    boolean nextTitleCase = true;

    for (char c : input.toCharArray()) {
        if (Character.isSpaceChar(c)) {
            nextTitleCase = true;
        } else if (nextTitleCase) {
            c = Character.toTitleCase(c);
            nextTitleCase = false;
        }
        titleCase.append(c);
    }
    }
    return input==null ? "" : titleCase.toString();
    }
    
    public static Object[][] RemoveLinhaMatriz (Object[][] array, int indiceLinha) {
    int linhas = array.length;
    Object[][] aux = new Object[linhas-1][];
    int incremento = 0;
    for(int i=0;i<array.length;i++)
        if(i!=indiceLinha)
        aux[i-incremento] = array[i];
        else
        incremento = 1;
    return aux;
    }    
    
    private static Connection conn;
    private static String email;
    private static String siape;
    private static int idUsuario;
    private static String CPF;
    private static String cargo;
    private static String usuario;
    private static String senha;
    private static String nomeDoUsuario;
    private static Object[][] tabelaSolicitacoes;
    
static {
     try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalArgumentException("MySQL db driver isnot on classpath");
    }
}
    public static Connection getConn () {
    return SingletonSessao.conn;
    }
    
    public static void Connect(String db_name,String user_name,String password) throws SQLException
    {
    //conn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/"+db_name+"?user="+user_name+"&password="+password);    
    conn = DriverManager.getConnection("jdbc:mysql://localhost/"+db_name+"?user="+user_name+"&password="+password);    
    }

}