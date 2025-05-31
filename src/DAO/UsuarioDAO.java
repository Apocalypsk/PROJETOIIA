
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarContato(UsuarioDTO objusuariodto) throws ClassNotFoundException{
    conn = new conexaoDAO().conectaBD();
    
    try {
        String sql = "select * from USUARIO where nome_usuario = ? and senha_usuario = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, objusuariodto.getNome_usuario());
        pstm.setString(2, objusuariodto.getSenha_usuario());

        ResultSet rs = pstm.executeQuery();
        return rs;

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Usuariodao: " + erro);
        return null;
    }
}
}
