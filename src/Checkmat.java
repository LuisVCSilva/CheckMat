
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
public class Checkmat {
   public static void main (String args[]) {
           SingletonSessao.Reset();
        TelaUsuario telaUsuario = new TelaUsuario();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
   
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() { 
                if(SingletonSessao.getConn()!=null)
                {
                SingletonSessao.Logout();
                    try {
                        SingletonSessao.DesconectaBD();
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
        });
   } 
}
