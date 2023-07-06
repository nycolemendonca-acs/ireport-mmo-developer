package com.ireport.mmodev.constants;

public final class Constants {
    public static final String NOME_SISTEMA = "SISTEMA DE GERENCIAMENTO DE CLIENTE";
    public static final String MSG_SUCESSO = "Operação efetuada com sucesso.";
    public static final String MSG_ERRO = "Erro na operação, contacte o administrador do sistema.";
    public static final String MSG_NENHUM_REGISTRO = "Nenhum registro foi localizado.";
    public static final String SLG_SISTEMA = "SGC";
    public static final String className = "org.postgresql.Driver";

    static String USER_KEY; // Usuário DB
    static String KEY; // Senha Usuário DB
    static String urlConnection;

    public static String getUrlConnection() {
        if (urlConnection == null) urlConnection = "jdbc:postgresql::/localhost:5432/sgc";
        return urlConnection;
    }

    public static String getUSER_KEY() {
        if (null == USER_KEY) USER_KEY = "postgres";
        return USER_KEY;
    }

    public static String getKEY() {
        if (null == KEY) KEY = "123456";
        return KEY;
    }
}
