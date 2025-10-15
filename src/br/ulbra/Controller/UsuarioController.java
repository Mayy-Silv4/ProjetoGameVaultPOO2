package br.ulbra.controller;

import br.ulbra.DAO.UsuarioDAO;
import br.ulbra.Model.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller responsável pelas operações de Usuário no sistema GameVault
 * (cadastro, login e administração de usuários)
 * @author SeuNome
 */
public class UsuarioController {

    private UsuarioDAO dao = new UsuarioDAO();

   public void salvar(Usuario u) throws SQLException {
        if ((u.getEmail())) {
            throw new SQLException("E-mail já cadastrado! Escolha outro ou faça login.");
        }
        dao.salvar(u);
    }

    public Usuario buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    public List<Usuario> listar() throws SQLException {
        return dao.listar();
    }

    public void atualizar(Usuario u) throws SQLException {
        dao.atualizar(u);
    }

    public void remover(int id) throws SQLException {
        dao.remover(id);
    }

    /**
     * Autentica um usuário (para login no sistema GameVault)
     */
    public Usuario autenticar(String login, String senha) throws SQLException {
        if (login == null || login.trim().isEmpty()) {
            throw new SQLException("Login é obrigatório!");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new SQLException("Senha é obrigatória!");
        }
        return dao.autenticar(login.trim(), senha);
    }

    /**
     * Verifica se existe ao menos um usuário cadastrado (para setup inicial)
     */
    public boolean existeUsuarios() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
