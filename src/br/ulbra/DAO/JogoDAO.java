/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.Jogo;
import br.ulbra.Model.Usuario;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO extends AbstractDAO {

    public void salvar(Jogo j) throws SQLException {
        String sql = "INSERT INTO produto (titulo,genero, plataforma , nota, comentario, iddousu) VALUES (?, ?, ?)";
        try (Connection con = (Connection) getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, j.getTitulo());
            ps.setString(2, j.getGenero());
            ps.setString(3, j.getPlataforma());
            ps.setDouble(4, j.getNota());
            ps.setString(5, j.getComentario());
            ps.setInt(6, (int) j.getUsuario());

            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Falha ao inserir produto.");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    j.setId(rs.getInt(1));
                }
            }
        }
    }

    public Jogo buscarPorId(int id) throws SQLException {
        String sql = "SELECT j.id, j.titulo, j.genero, j.plataforma, j.nota, j.comentario, u.id as u_id, u.nome as u_nome, u.email, u.senha "
                + "FROM jogo j INNER JOIN usuario u ON j.iddousu= u.id WHERE j.id = ?";
        try (Connection con = (Connection) getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario(
                            rs.getInt("u_id"),
                            rs.getString("u_nome"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                    return new Jogo(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("genero"),
                            rs.getString("plataforma"),
                            rs.getDouble("nota"),
                            rs.getString("comentario"),
                            u
                    );
                }
            }
        }
        return null;
    }

    public List<Jogo> listar() throws SQLException {
        String sql = "SELECT j.id, j.titulo, j.genero, j.plataforma, j.nota, j.comentario, u.id as u_id, u.nome as u_nome, u.email, u "
                + "FROM jogo j INNER JOIN usuario u ON j.iddousu = u.id ORDER BY j.titulo";
        List<Jogo> lista = new ArrayList<>();

        try (Connection con = (Connection) getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("u_id"),
                        rs.getString("u_nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                Jogo j = new Jogo(
                        rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("genero"),
                            rs.getString("plataforma"),
                            rs.getDouble("nota"),
                            rs.getString("comentario"),
                        u
                );
                lista.add(j);
            }
        }
        return lista;
    }

    public void atualizar(Jogo j) throws SQLException {
        String sql = "UPDATE produto SET nome = ?, preco = ?, id_fornecedor = ? WHERE id = ?";
        try (Connection con = (Connection) getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, j.getTitulo());
            ps.setString(2, j.getGenero());
            ps.setString(3, j.getPlataforma());
            ps.setDouble(4, j.getNota());
            ps.setString(5, j.getComentario());
            ps.setInt(6, (int) j.getUsuario());

            ps.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection con = (Connection) getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Jogo> buscarPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Jogo> buscarPorFiltro(String plataforma, String genero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//    private Connection getConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}