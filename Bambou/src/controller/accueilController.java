package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Bambou;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


import connexion.Connexion;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.IntegerStringConverter;


public class accueilController implements Initializable{


	@FXML
	private TextField tfCouleur;
	@FXML
	private TextField tfTaille;
	@FXML
	private TextField tfType;
	@FXML
	private TextField tfId;
	@FXML
	private TextField taillePlante;


	@FXML
	private Hyperlink geants;
	@FXML
	private Hyperlink noirs;
	@FXML
	private Hyperlink nains;
	@FXML
	private Hyperlink chaumeRouge;
	@FXML
	private Hyperlink dores;

	   
	   @FXML
	   private Button add;
	   
	   @FXML
	   private Button addbtn;
	   
	   @FXML
	   private Button editbtn;
	   
	   @FXML
	   private Button calculbtn;
	   
	   @FXML
	   private Button remove;
	   @FXML
	   private Button calcul;
	   
	   
	   @FXML
	   private Button edit;
	   @FXML
	   private TableView <Bambou> table;
	   @FXML
	   private TableColumn <Bambou, String> typeCol;
	   @FXML
	   private TableColumn <Bambou, String> couleurCol;
	   @FXML
	   private TableColumn <Bambou, Integer> tailleCol;


	   @FXML
	   private TableColumn <Bambou, Integer> IdCol;

		private ObservableList<Bambou> bambouList;
	

	@FXML
	void goToGiantBambooPage()
	{
	
		try {
			 Stage acceuil= new Stage();
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/interfaces/Bgeants.fxml"));
			Scene scene= new Scene(root);
			acceuil.setScene(scene);
			acceuil.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	void goToBlackBambooPage()
	{
		try {
			Stage acceuil= new Stage();
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/interfaces/Noirs.fxml"));
			Scene scene= new Scene(root);
			acceuil.setScene(scene);
			acceuil.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	void goToDwarfBambooPage()
	{
		try {
			Stage acceuil= new Stage();
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/interfaces/Nains.fxml"));
			Scene scene= new Scene(root);
			acceuil.setScene(scene);
			acceuil.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	void goToRedStemBambooPage()
	{
		try {
			Stage acceuil= new Stage();
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/interfaces/ChaumeRouge.fxml"));
			Scene scene= new Scene(root);
			acceuil.setScene(scene);
			acceuil.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	void goToGoldenBambooPage()
	{
		try {
			Stage acceuil= new Stage();
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("/interfaces/Dores.fxml"));
			Scene scene= new Scene(root);
			acceuil.setScene(scene);
			acceuil.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void goAjouter()
	{
		try {
			Stage acceuil= new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/interfaces/addBambou.fxml"));
			Scene scene= new Scene(root);
			acceuil.setScene(scene);
			acceuil.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void goModifier()
	{
		try {
			Stage acceuil= new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/interfaces/editerBambou.fxml"));
			Scene scene= new Scene(root);
			acceuil.setScene(scene);
			acceuil.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	void goCalcul()
	{
		try {
			Stage acceuil= new Stage();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/interfaces/calcul.fxml"));
			Scene scene= new Scene(root);
			acceuil.setScene(scene);
			acceuil.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		ObservableList<String> list = 
//				FXCollections.observableArrayList("Geants","Noirs","Nains","ChaumeRouge","Dores");

   
        //bambouList = FXCollections.observableArrayList(findAll());
		IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
		couleurCol.setCellValueFactory(new PropertyValueFactory<>("couleur"));
		tailleCol.setCellValueFactory(new PropertyValueFactory<>("taille"));

		table.setEditable(true);
		couleurCol.setCellFactory(TextFieldTableCell.forTableColumn());
		typeCol.setCellFactory(TextFieldTableCell.forTableColumn());
		tailleCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	
		
	}
	
	
	@FXML
	private void deleteFn(ActionEvent event) {
		Bambou selectedBambou = table.getSelectionModel().getSelectedItem();
		if (selectedBambou != null) {
			if (delete(selectedBambou)) {
				bambouList.remove(selectedBambou);
				clear();

			} else {
				System.out.println("erreur");
			}
		}
	}
	
	@FXML
	private void updateFn(ActionEvent event) {

		Bambou selectedBambou = table.getSelectionModel().getSelectedItem();

		if (selectedBambou != null) {
	        String type = tfType.getText();
	        String couleur = tfCouleur.getText();
	        int taille = Integer.parseInt(tfTaille.getText());
			selectedBambou.setType(type);
			selectedBambou.setCouleur(couleur);
			selectedBambou.setTaille(taille);

			if (update(selectedBambou)) {
				table.refresh();
				clear();
			} else {
				System.out.println("erreur");
			}
		}
	}
	

	 public boolean create(Bambou b) {
		    try {
		        String query = "INSERT INTO bambou (type, couleur, taille) VALUES (?, ?, ?)";
		        Connection connection = Connexion.getCn();
		        PreparedStatement statement = connection.prepareStatement(query);
		        statement.setString(1, b.getType());
		        statement.setString(2, b.getCouleur());
		        statement.setInt(3, b.getTaille());


		        if (statement.executeUpdate() == 1) {
		            return true;
		        }
		    } catch (SQLException ex) {
		        System.out.println("Erreur SQL: " + ex);
		    }
		    return false;
		}

		
		public boolean delete(Bambou bambou) {
			String query = "DELETE FROM bambou WHERE id = ?";
			try {
				PreparedStatement statement = Connexion.getCn().prepareStatement(query);
				statement.setInt(1, bambou.getId());
				int rowsDeleted = statement.executeUpdate();
				return rowsDeleted > 0;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		
		public boolean update(Bambou bambou) {
			String query = "UPDATE bambou SET type = ?, couleur = ?, taille = ? WHERE id = ?";
			try {
				PreparedStatement statement = Connexion.getCn().prepareStatement(query);
				statement.setString(1, bambou.getType());
				statement.setString(2, bambou.getCouleur());
				statement.setInt(3, bambou.getTaille());
				statement.setInt(5, bambou.getId());
				int rowsUpdated = statement.executeUpdate();
				return rowsUpdated > 0;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		
		public List<Bambou> findAll() {
		    String query = "SELECT * FROM bambou";
		    List<Bambou> bambous = new ArrayList<>();
		    try {
		        PreparedStatement statement = Connexion.getCn().prepareStatement(query);
		        ResultSet resultSet = statement.executeQuery();
		        while (resultSet.next()) {
		            int id = resultSet.getInt("id");
		            String type = resultSet.getString("type");
		            String couleur = resultSet.getString("couleur");
		            int taille = resultSet.getInt("taille");
		            bambous.add(new Bambou(id ,type, couleur, taille));
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return bambous;
		}
		


		@FXML
		void addFn(ActionEvent event) {
		    Window owner = add.getScene().getWindow();
		    if (create(new Bambou(Integer.parseInt(tfId.getText()),tfType.getText(), tfCouleur.getText(), Integer.parseInt(tfTaille.getText())))) {
		        Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Success");
		        alert.setHeaderText(null);
		        alert.setContentText("Bambou added successfully!");
		        alert.initOwner(owner);
		        alert.show();
		        bambouList.add(new Bambou(Integer.parseInt(tfId.getText()) , tfType.getText(), tfCouleur.getText(), Integer.parseInt(tfTaille.getText())));
		        clear();
		    }
		}



		void clear() {

			tfType.clear();
			tfCouleur.getText();
			tfTaille.clear();
		}
		


	 @FXML 
	 public void remove() { int selectedIndex =
	  table.getSelectionModel().getSelectedIndex(); if (selectedIndex >= 0) {
	 table.getItems().remove(selectedIndex); } }

	 
	 public double calculerCroissancePlante(int taillePlante) {
		    double tauxCroissance;

		    if (taillePlante < 10) {
		        tauxCroissance = 0.5;
		    } else if (taillePlante < 20) {
		        tauxCroissance = 0.3;
		    } else {
		        tauxCroissance = 0.1;
		    }

		    double croissance = taillePlante * tauxCroissance;
		    return croissance;
		}


		   
		 

		}

	 
	 
	
	

