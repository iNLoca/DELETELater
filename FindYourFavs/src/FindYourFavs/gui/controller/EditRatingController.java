/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import FindYourFavs.be.Movie;
import FindYourFavs.bll.Manager;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class EditRatingController implements Initializable {

     Manager manager;
  MoviePlayerController mpc;
    private String PrintedRating;
    int rat;
    @FXML
    private AnchorPane EditRating;
    @FXML
    private Button editbtn;
    @FXML
    private Button cancelratingbtn;

    @FXML
    private TextField newRatingBox;

    @FXML
    private Label CurrRat;
    private Movie movie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
           
    }

    @FXML
    private void clickEditRatingbtn(ActionEvent event) {
        

        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        Manager.myManager.addNewUsrRating(movie.getId(), newRatingBox.getText());
        
        stage.close();
        mpc.refresh();
        
    }

    @FXML
    private void clickCancelRatingbtn(ActionEvent event) {

        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }
    
    private void getNewUsrRating() {
   
    }



  
    public void setMovie(Movie movie) {
        this.movie=movie;
        PrintedRating =Integer.toString(movie.getPersonalRating());
          CurrRat.setText(PrintedRating);
          
    }
     public void setMoviePlayerController(MoviePlayerController mpc){
    this.mpc=mpc;
    }

}
