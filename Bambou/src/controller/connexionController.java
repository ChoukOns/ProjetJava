package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class connexionController {
	



		
	@FXML
    private Button connexion_btn;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPassword;
    @FXML
    void openHome() {
    	String nom = userName.getText();
        String pass = userPassword.getText();
        if (nom.equals("ons") && pass.equals("mayssa")) {
            System.out.println("connecter avec succees!");
            //VBox.getScene().getWindow().hide();
            Stage acceuil= new Stage();
            try{
            	fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
            	Scene scene= new Scene(fxml);
            	acceuil.setScene(scene);
            	acceuil.show();
            }catch (IOException e)
            {
            	e.printStackTrace();
            }
        } else {
            System.out.println("login ou Passowrd incorrecte!");
        }

    }
	   
	    private Parent fxml;
	    

	    
	   
	}


