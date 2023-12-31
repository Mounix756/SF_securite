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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.MainApp;

/**
 *
 * @author blais
 */
public class FileController 
{
    //Il s'agit du constructeur
    public void FilleController()
    {
        
    }
    
    //Methode de connexion avec la base de donnée
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
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
    
    public String nom_user = MainApp.getFirstNameUser();
    public String prenom_user = MainApp.getLastNameUser();
    public String email_user = MainApp.getEmailUser();
    public String password_user = MainApp.getPasswordCrypte();
    public String pass_secret = MainApp.getCodeUserRegister();
    
    public static boolean confirmation_create = false;

    
    
    //Fonction permettant à l'utilisateur une fois connecter d'ajouter des fichiers
    public void add_new_file()
    {
        try {
            connexion();
            String sql = "INSERT INTO files(nom_fichier,chemin, path, file_password, created_At)" + "VALUES(?,?,?,?,?, now())";
            pst = (PreparedStatement) ((java.sql.Connection) con).prepareStatement(sql);
            pst.setString(1, pass_secret);
            pst.setString(2, nom_user);
            pst.setString(3, prenom_user);
            pst.setString(4, email_user);
            pst.setString(5, password_user);
            confirmation_create = true;
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "Votre compte a été crée avec succès !");
        } catch (Exception e2) 
        {
            confirmation_create = false;
            e2.printStackTrace();
        }
    }
    
    public static DefaultTableModel table_value()
    {
        return table_model;
    }
    
    //Fonction permettant d'afficher la liste utilisateurs dans un tableau
    public static DefaultTableModel table_model;
    public void liste_des_users() 
    {
        try 
        {
            connexion();
            String[] entete = {"NOM", "PRENOM", "EMAIL"};
            String[] ligne = new String[12];

            DefaultTableModel model = new DefaultTableModel(null, entete);
            //Requête sql permettant de selectionner par ordre decroissant la liste de tous les utilisateurs.
            String sqlTable = "SELECT *  FROM users ORDER BY(created_at) DESC";

            Statement st = con.createStatement();
            rs = st.executeQuery(sqlTable);
            while (rs.next())
            {
                ligne[0] = rs.getString("nom");
                ligne[1] = rs.getString("prenom");
                ligne[2] = rs.getString("email");
                model.addRow(ligne);
            }
            table_model = model;
            //lister_users_table.setModel(model);
        } 
        catch (Exception e2) 
        {
            e2.printStackTrace();
            System.out.println("Erreur au niveau d'affichage table");
        }
    }
}
