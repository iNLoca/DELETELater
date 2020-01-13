/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

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

    Manager manager = new Manager();
    private MoviePlayerController mpc = new MoviePlayerController();
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //   PrintedRating =Integer.toString(mpc.getSelectedPersonalRating());
        //  CurrRat.setText(PrintedRating);
    }

    @FXML
    private void clickEditRatingbtn(ActionEvent event) {
        

        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
         getNewUsrRating();
        stage.close();
    }

    @FXML
    private void clickCancelRatingbtn(ActionEvent event) {

        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }
    
    private void getNewUsrRating() {
        manager.addNewUsrRating(mpc.returnNameOfMovie(), newRatingBox.getText());
    }

}
