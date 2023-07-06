package com.ireport.mmodev.dao;

import java.sql.*;

import com.ireport.mmodev.constants.Constants;
import com.ireport.mmodev.model.UF;

public class UFDao {
    Connection con = null;
    private void conectar() {
        // Desconecta primeiro
        this.desconectar();
        try {
            // Conecta com o banco
            Class.forName(Constants.className).newInstance();
            con = DriverManager.getConnection(
                    Constants.getUrlConnection(),
                    Constants.getUSER_KEY(),
                    Constants.getKEY());

        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    // Fecha a conexão
    private void desconectar() {
        if (con != null) {
            try { if (!con.isClosed()) con.close(); }
            catch (SQLException e) { System.out.println(e.getMessage()); }
        }
    }

    public Integer gerarChave() {
        Integer retorno = 1;
        StringBuffer sql = new StringBuffer("SELECT (MAX(codigo_uf)+1) AS CHAVE FROM UF");
        try {
            this.conectar();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(sql.toString());

            while (resultado.next()) {
                if (resultado.getString("CHAVE") != null) retorno = resultado.getInt("CHAVE");
            }

        }

        catch (Exception e) { System.out.println(e.getMessage() + " - " + sql.toString()); }
        finally { this.desconectar(); }

        return retorno;
    }

    public void incluir(UF uf) {
        uf.setId(this.gerarChave());
        StringBuffer sql = new StringBuffer("INSERT INTO UF(");

        try {
            sql.append("CODIGO_UF, NOME, SIGLA) VALUES (");
            if (uf.getId() != null && uf.getId() > 0) sql.append(uf.getId() + ",");
            else sql.append("null,");

            if (uf.getNome() != null && !uf.getNome().equals("")) sql.append("'" + uf.getNome().trim() + "',");
            else sql.append("null,");

            if (uf.getSigla() != null && !uf.getSigla().equals("")) sql.append("'" + uf.getSigla().trim() + "')");
            else sql.append("null)");

            // Conecta com o banco de dados
            this.conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql.toString());

        }

        catch (SQLException e) { System.out.println(e.getMessage() + " - " + sql.toString()); }
        finally { this.desconectar(); }
    }

    public void atualizar(UF uf) {
        StringBuffer sql = new StringBuffer("UPDATE SET ");


    }

}
