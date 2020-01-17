/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */

public class AskDeleteMovieController implements Initializable {

    private MoviePlayerController mpc;

    @FXML
    private Button deletemoviebtn;
    @FXML
    private Button cancelmoviebtn;
    @FXML
    private AnchorPane askdeletemovie;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    //Method that executes the deletion of the movie by calling the same method on the MoviePlayerController
    @FXML
    private void clickDeleteMoviebtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        mpc.deleteMovie();
        mpc.refresh();
        stage.close();
    }

    //Method that cancels the deletion od the movie process and closes the window
    @FXML
    private void clickCancelMoviebtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }

    //Method that sets the instance of the MoviePlayerController if called in its own class when opening the askDeleteMovie window
    public void setMoviePlayerController(MoviePlayerController mpc) {
        this.mpc = mpc;
    }

}
