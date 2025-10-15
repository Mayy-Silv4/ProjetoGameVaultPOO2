package br.ulbra.controller;

import br.ulbra.DAO.JogoDAO;
import br.ulbra.Model.Jogo;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller responsável pelas operações de Jogo no sistema GameVault
 * @author SeuNome
 */
public class JogoController {

    private JogoDAO dao = new JogoDAO();

    public void salvar(Jogo j) throws SQLException {
        dao.salvar(j);
    }

    public Jogo buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    public List<Jogo> listar() throws SQLException {
        return dao.listar();
    }

    public void atualizar(Jogo j) throws SQLException {
        dao.atualizar(j);
    }

    public void remover(int id) throws SQLException {
        dao.remover(id);
    }

    /**
     * Busca jogos pelo nome (para a funcionalidade de pesquisa)
     */
    public List<Jogo> buscarPorNome(String nome) throws SQLException {
        return dao.buscarPorNome(nome);
    }

    /**
     * Busca jogos filtrando pela plataforma ou gênero
     */
    public List<Jogo> buscarPorFiltro(String plataforma, String genero) throws SQLException {
        return dao.buscarPorFiltro(plataforma, genero);
    }
}