
import java.awt.Dialog;
import java.awt.HeadlessException;
import java.beans.Statement;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        setResizable(false);
        this.setVisible(new MinhaConta()==null ? true : !new MinhaConta().isVisible());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CheckMat - 0.1 Alpha");
        setBackground(new java.awt.Color(153, 153, 153));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 203, 203));
        setMaximumSize(new java.awt.Dimension(265, 203));
        setMinimumSize(new java.awt.Dimension(264, 202));

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Recuperar Senha");

        jButton3.setText("Criar Conta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome de usuário");

        jLabel3.setText("Senha");
        jLabel3.setMaximumSize(new java.awt.Dimension(78, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(78, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(78, 14));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("CheckMat - 0.1 - Alpha");

        jButton4.setText("Sobre");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    this.setVisible(false);
    new CriarConta().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextField1.getText()=="" || new String(jPasswordField1.getPassword())=="")
        {
            JOptionPane.showMessageDialog(rootPane,"Dados incorretos.","Login - Checkmat",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {

                Connection conn;
                //SingletonSessao.Connect("sql9145693","sql9145693","e78ZJ8Bjx1");
                SingletonSessao.Connect("checkmat","root","");
                java.sql.Statement stmt = SingletonSessao.getConn().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT usuario,senha,isLoggedIn FROM `user` where usuario='"+jTextField1.getText() + "' and senha='"+new String(jPasswordField1.getPassword())+"'");
                    
                    if((rs.next()==true))
                    {
                        if(Integer.parseInt(rs.getString("isLoggedIn"))==0)
                        {
                        SingletonSessao.setUsuario(jTextField1.getText());
                        SingletonSessao.setSenha(new String(jPasswordField1.getPassword()));

                        stmt.execute("UPDATE user SET isLoggedIn=true WHERE usuario='" + jTextField1.getText() + "'");    
                        this.setVisible(false);
                        new TelaUsuario().setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(rootPane,"Já existe uma sessão aberta para este usuário...\nEsta atividade foi reportada ao administrador...","Login - Checkmat",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane,"Dados incorretos.","Login - Checkmat",JOptionPane.ERROR_MESSAGE);
                    }

            } catch (SQLException | NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(rootPane,"Ocorreu um erro do sistema:\n" + e.getMessage(),"Login - Checkmat",JOptionPane.ERROR_MESSAGE);
                System.err.println("Exceção");
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(rootPane,
            "[Nome da Empresa] + [Nome do Programa]\n"
            +"\nVersão 666 (Compilação 171)\n"
            +"© 2016 [Nome da Empresa]. Todos os direitos reservados.\n\n"
            +"O software, sua interface de usuário e base de dados são\n"
            + "protegidas por marca registrada e outros direitos de\n"
            + "propriedade intelectual existentes ou pendentes no Brasil\n"
            + "e outros países.\n\n\n"
            + "Este produto está licenciado sob os \"Termos de licença para\n"
            + "Software [Nome da Empresa]\" para: \n\n" + System.getProperty("user.name"), "Sobre", WIDTH);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    
    public static void main(String args[]) {
        SingletonSessao.Reset();
        TelaUsuario telaUsuario = new TelaUsuario();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
