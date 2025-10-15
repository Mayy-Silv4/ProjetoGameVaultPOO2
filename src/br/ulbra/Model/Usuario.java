
package br.ulbra.Model;

import static sun.security.jgss.GSSUtil.login;

public class Usuario {
  private int id;
public String nome;
private String email;
private String senha;
private String Login;

    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    public int getId(int id) {
        return id;
    }

    public String getNome(String nome) {
        return nome;
    }

    public String getEmail(String email) {
        return email;
    }

    public String getSenha(String Senha) {
        return senha;
    }
    public String getLogin(String login){
    return login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }

    public boolean getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
