/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

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
    private ChoiceBox<?> choiceboxcat;
    @FXML
    private JFXTextField addfilelink;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          /*
        // Create ChoiceBox
        ChoiceBox<String>choiceBox = new ChoiceBox<>();
        
        //getItems returns the ObservableList object which u can add items to. 
        choiceBox.getItems().add("Action");
        choiceBox.getItems().add("Animation");
        choiceBox.getItems().addAll("Bat","Box","lol");
        
        //Set value 
        choiceBox.setValue("Action");
        choiceBox.setValue("Animation");
        
      */
        
       
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
    
}
