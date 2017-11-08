/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edsonrczarneski.dal;

import java.sql.*;

/**
 *
 * @author Edson Ricardo Czarneski
 */
public class ModuloConexao {

    //Método responsável por estabelecer conexao com BD
    public static Connection conector() {
        java.sql.Connection conexao = null;
        //Importanto driver JDBC
        String driver = "com.mysql.jdbc.Driver";
        //Informacoes sobre o BD
        String url = "jdbc:mysql://localhost:3306/escola";
        String user = "root";
        String password = "";
        //Estabelecendo conexao BD
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
    }

}
