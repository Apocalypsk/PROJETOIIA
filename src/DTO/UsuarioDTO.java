package DTO;


public class UsuarioDTO {
     private int Id_usuario;
    private String nome_usuario, senha_usuario;

    /**
     * @return the Id_usuario
     */
    public int getId_usuario() {
        return Id_usuario;
    }

    /**
     * @param Id_usuario the Id_usuario to set
     */
    public void setId_usuario(int Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    /**
     * @return the nome_usuario
     */
    public String getNome_usuario() {
        return nome_usuario;
    }

    /**
     * @param nome_usuario the nome_usuario to set
     */
    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    /**
     * @return the senha_usuario
     */
    public String getSenha_usuario() {
        return senha_usuario;
    }

    /**
     * @param senha_usuario the senha_usuario to set
     */
    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
    
}
