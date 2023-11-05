/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import views.MainApp;

/**
 *
 * @author blais
 */

//Dans cette classe nous specifions tout le code necessaire pour la connexion avec la base de donnée.
//NB: certains valeur dependent de votre ordinateur, par exemple le port sql, le mot de passe pour l'accès
//à votre base de donnée MySQL..., verifier d'abord, ces informations avant d'implémenter le code.

public class DB_Connection {
    public void DB_Connection(){
        
    }
    
    public Connection con;
    public PreparedStatement pst;
    public ResultSet rs;
    public String localhost = "jdbc:mysql://localhost/";
    public String db_name = "bd_sf_securite";
    public String db_user = "root";
    public String db_password = "";

    public void connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(localhost+db_name, db_user, db_password);
            Statement st = (Statement) con.createStatement();
            System.out.println("Good connection");
        } catch (Exception e) {
            System.out.println("Connexion échoué");
            e.printStackTrace();
        }
    }
    
}
