/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import FindYourFavs.be.Category;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class AskAddMovieController implements Initializable {

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
        Stage stage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickCancelMovieButton(ActionEvent event) {        
        Stage stage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickshowCategories(MouseEvent event) {
        //choiceboxcat.getAccessibleText();
        
        
        
    }
    
}
