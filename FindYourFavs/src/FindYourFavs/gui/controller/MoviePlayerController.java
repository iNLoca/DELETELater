/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import FindYourFavs.be.Movie;
import FindYourFavs.bll.Manager;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class MoviePlayerController implements Initializable {
    Manager manager= new Manager();
    @FXML
    private Label label;
    @FXML
    private MenuButton categories;
    @FXML
    private TableView<Movie>tableview;
    @FXML
    private Button addmovie;
    @FXML
    private Button deletemovie;
    @FXML
    private Button addcategory;
    @FXML
    private Button deletecategory;
    @FXML
    private Button addrating;
    @FXML
    private Button editrating;
    @FXML
    private TableColumn<Movie, String> movietittle;
    @FXML
    private TableColumn<Movie, Integer> usrrating;
    @FXML
    private TableColumn<Movie, Integer> imdbrating;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Movie> movieLst = FXCollections.observableArrayList(manager.getAllMovies());
        movietittle.setCellValueFactory(new PropertyValueFactory<>("name"));
        usrrating.setCellValueFactory(new PropertyValueFactory<>("personalRating"));
        imdbrating.setCellValueFactory(new PropertyValueFactory<>("IMDBRating"));
        tableview.setItems(movieLst);
       
    }    

    @FXML
    private void clickActionCategory(ActionEvent event) {
    }

    @FXML
    private void clickAnimationCategory(ActionEvent event) {
    }

    @FXML
    private void clickComedyCategory(ActionEvent event) {
    }

    @FXML
    private void clickCrimeCategory(ActionEvent event) {
    }

    @FXML
    private void clickDramaCategory(ActionEvent event) {
    }

    @FXML
    private void clickFilmNoir(ActionEvent event) {
    }

    @FXML
    private void clickHorror(ActionEvent event) {
    }

    @FXML
    private void clickThriller(ActionEvent event) {
    }

    @FXML
    private void clickWar(ActionEvent event) {
    }

    @FXML
    private void clickWestern(ActionEvent event) {
    }

    @FXML
    private void clickaddmovie(ActionEvent event) {
    }

    @FXML
    private void clickdeletemovie(ActionEvent event) throws IOException {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindYourFavs/gui/view/AskDeleteMovie.fxml"));
        Parent root = loader.load();
        AskDeleteMovieController ctrl = loader.getController();
        
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    private void clickaddcategory(ActionEvent event) {
    }

    @FXML
    private void clickdeletecategory(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindYourFavs/gui/view/AskDeleteCategory.fxml"));
        Parent root = loader.load();
        AskDeleteCategoryController ctrl = loader.getController();
        
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.show();
        
        
        
    }

    @FXML
    private void clickAddRating(ActionEvent event) {
    }

    @FXML
    private void clickEditRating(ActionEvent event) {
    }

    
}
