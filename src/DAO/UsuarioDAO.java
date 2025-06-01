
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
        String sql = "insert into contatos (telefone, nome, email) values (?,?,?)";
        
        conn = new conexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getTelefone());
            pstm.setString(2, objusuariodto.getNome());
            pstm.setString(3, objusuariodto.getEmail());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "usuarioDAO" + erro);
        }
        

}
}
