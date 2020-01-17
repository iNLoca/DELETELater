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
public class AskDeleteCategoryController implements Initializable {

   private MoviePlayerController mpc;

    @FXML
    private Button deletebtn;
    @FXML
    private Button cancelbtn;
    @FXML
    private AnchorPane askdeletecategory;

    /**
     * Initializes the controller class.
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //Method that executes the deletion of the category calling its method on the MoviePlayerController
    @FXML
    private void clickDeleteCategorybtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        mpc.deleteCategory();
        mpc.refresh();
        stage.close();
    }

    //Method that closes the deleteCategory window and cancels the deleting process
    @FXML
    private void clickCancelCategorybtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }
    //Method that sets the instance of the MoviePlayerController if called in its own class when opening the askDeleteCategory window
    public void setMoviePlayerController(MoviePlayerController mpc) {
        this.mpc = mpc;
    }
}
