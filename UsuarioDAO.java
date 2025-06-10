package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();

    public void cadastrarContato(UsuarioDTO objusuariodto) throws ClassNotFoundException {
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
            JOptionPane.showMessageDialog(null, "usuarioDAO Inserir" + erro);
        }

    }

    public ArrayList<UsuarioDTO> PesquisarContato() throws ClassNotFoundException {
        String sql = "select * from contatos";
        conn = new conexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO objusuarioDTO = new UsuarioDTO();
                objusuarioDTO.setTelefone(rs.getString("telefone"));
                objusuarioDTO.setNome(rs.getString("nome"));
                objusuarioDTO.setEmail(rs.getString("email"));

                lista.add(objusuarioDTO);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Pesquisar" + erro);
        }
        return lista;
    }

    public void alterarContato(UsuarioDTO objusuariodto) throws ClassNotFoundException {
        String sql = "update contatos set nome = ?, email = ? where telefone = ?";
        
        conn = new conexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome());
            pstm.setString(2, objusuariodto.getEmail());
            pstm.setString(3, objusuariodto.getTelefone());


            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuarioDAO Alterar" + erro);
        }
    }
    
    public void ExcluirContato(UsuarioDTO objusuariodto) throws ClassNotFoundException {
        String sql = "DELETE FROM contatos WHERE telefone = ?";
    
           
        conn = new conexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getTelefone());


            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuarioDAO Excluir" + erro);
        }
}
    
}
