/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import FindYourFavs.be.Movie;
import FindYourFavs.bll.Manager;
import static java.lang.Float.parseFloat;
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
 */

public class EditRatingController implements Initializable {
    
    //Creation of variales for this class
    private Movie movie;
    private Manager manager= new Manager();
    private MoviePlayerController mpc;
    private String PrintedRating;
    
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
  
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //Method that executes the EditRating process. it also ensures that the rating recieved by the user is inside the allowed bounds, if not, the default value 0 is set
    @FXML
    private void clickEditRatingbtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        if (parseFloat(newRatingBox.getText()) >= 0 && parseFloat(newRatingBox.getText()) <= 10) {
            manager.addNewUsrRating(movie.getId(), newRatingBox.getText());
        } else {
            manager.addNewUsrRating(movie.getId(), "0");
        }

        stage.close();
        mpc.refresh();
    }

    //Method that cancels the Edit Rating process and closes the window
    @FXML
    private void clickCancelRatingbtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }

    //Method that sets the movie and gets its personal rating to display it
    public void setMovie(Movie movie) {
        this.movie = movie;
        PrintedRating = Float.toString(movie.getPersonalRating());
        CurrRat.setText(PrintedRating);
    }

    //Method that sets the instance of the MoviePlayerController if called in its own class when opening the EditRating window
    public void setMoviePlayerController(MoviePlayerController mpc) {
        this.mpc = mpc;
    }

}
