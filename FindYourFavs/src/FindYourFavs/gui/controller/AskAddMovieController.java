/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import FindYourFavs.be.Category;
import FindYourFavs.be.Movie;
import FindYourFavs.bll.Manager;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.EventObject;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class AskAddMovieController implements Initializable {
    Manager manager = new Manager();
        MoviePlayerController mpc;
        int userrating;
       List<Movie> movieLst;
       boolean add=true;

    @FXML
    private Button cancelmovie;
    @FXML
    private Button addmoviebtn;
    @FXML
    private AnchorPane askaddmovie;
    @FXML
    private ChoiceBox<String> choiceboxcat;
    @FXML
    private JFXTextField addfilelink;
    @FXML
    private TextField tittle;
    @FXML
    private TextField usrrating;
    @FXML
    private TextField imdbrating;
    @FXML
    private TextField lastviewd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        

        //getItems returns the ObservableList object which u can add items to. 
        choiceboxcat.getItems().add("Categories");
        choiceboxcat.getItems().add("Action");
        choiceboxcat.getItems().add("Animation");
        choiceboxcat.getItems().add("Comedy");
        choiceboxcat.getItems().add("Crime");
        choiceboxcat.getItems().add("Drama");
        choiceboxcat.getItems().add("Film-Noir");
        choiceboxcat.getItems().add("Horror");
        choiceboxcat.getItems().add("Thriller");
        choiceboxcat.getItems().add("War");
        choiceboxcat.getItems().add("Western");

        //Set value 
        choiceboxcat.setValue("Categories");
        choiceboxcat.setValue("Action");
        choiceboxcat.setValue("Comedy");
        choiceboxcat.setValue("Crime");
        choiceboxcat.setValue("Drama");
        choiceboxcat.setValue("Film-Noir");
        choiceboxcat.setValue("Horror");
        choiceboxcat.setValue("Thriller");
        choiceboxcat.setValue("War");
        choiceboxcat.setValue("Western");

    }

    @FXML
    private void clickAddMoviebtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        
        
        //
        
        if(usrrating.getText().isEmpty()){
            userrating=0;
        }
        else{
        userrating = parseInt(usrrating.getText()) ;
        }
        movieLst = manager.getAllMovies();
        
        for (Movie movie : movieLst) {
            if(movie.getName().equals(tittle.getText())) {
                add=false;
            }
        }
        if(add) manager.addMovie(tittle.getText(), userrating, parseInt(imdbrating.getText()), parseInt(lastviewd.getText()));
        mpc.refresh();
        stage.close();
    }

    @FXML
    private void clickCancelMovieButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickshowCategories(MouseEvent event) {
        //choiceboxcat.getAccessibleText();   
    }
    
     public void setMoviePlayerController(MoviePlayerController mpc){
    this.mpc=mpc;
    }

}
