/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import views.MainApp;
import java.sql.PreparedStatement;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


/**
 *
 * @author blais
 */
public class LoginController 
{
    public void LoginContoller()
    {
        //Le constructeur
    }
    
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
    
    //Cette fonction permet la creation d'un compte utilisateur
    public static boolean confirmation_create = false;
    public void create_new_user_account()
    {
        try {
            connexion();
            String sql = "INSERT INTO users(code, nom, prenom, email, mot_de_passe, created_At)" + "VALUES(?,?,?,?,?, now())";
            pst = (PreparedStatement) ((java.sql.Connection) con).prepareStatement(sql);
            pst.setString(1, pass_secret);
            pst.setString(2, nom_user);
            pst.setString(3, prenom_user);
            pst.setString(4, email_user);
            pst.setString(5, password_user);
            confirmation_create = true;
            pst.executeUpdate();
            pst.close();
            
        } catch (Exception e2) 
        {
            confirmation_create = false;
            e2.printStackTrace();
        }
        System.out.println("Confirm : "+confirmation_create);
    }
    
    /*Methode permettant d'authentifier l'utilisateur, c'est à dire verifier si son email et mot de passe sont vrais.*/
    
    //Ici à travers les getters je get la valeurs de l'email et mot de passe entrée par l'utilisateur depuis le fichier MainApp.java
    

    public String email_login = MainApp.getEmail();
    public String password_login = MainApp.getPassword();
    public static boolean confirmation;

    public void authentification() {
    try {
        connexion();
        pst = (PreparedStatement) con.prepareStatement("SELECT mot_de_passe, code FROM users WHERE email = ?");
        pst.setString(1, email_login);
        rs = pst.executeQuery();

        if (rs.next()) 
        {
            String storedEncryptedPassword = rs.getString("mot_de_passe");
            String storedSecretKey = rs.getString("code");


            SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(storedSecretKey), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] storedDecryptedPasswordBytes = cipher.doFinal(Base64.getDecoder().decode(storedEncryptedPassword));
            String storedDecryptedPassword = new String(storedDecryptedPasswordBytes);

            if(password_login.equals(storedDecryptedPassword) == true) {
                // Le mot de passe est correct, autoriser la connexion
                confirmation = true;
            } else {
                confirmation = false;
            }
        } 
        else 
        {
            //JOptionPane.showMessageDialog(null, "Compte inexistant!");
            confirmation = false;
        }
        } catch (Exception e) {
            System.out.println("Erreur!!! Connexion échouée");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur!\n" + e);
        }
    }

    
}
