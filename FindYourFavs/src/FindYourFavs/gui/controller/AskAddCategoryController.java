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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class AskAddCategoryController implements Initializable {

    //Crates a new instance for the manager and an MoviePlayerController not initialized
    private Manager manager = new Manager();
    private MoviePlayerController mpc;

    @FXML
    private AnchorPane addcategory;
    @FXML
    private Button cancelcatbtn;
    @FXML
    private Button addcatbtn;
    @FXML
    private TextField addcategoryfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    //Method that closes the window if the cancel button is pressed
    @FXML
    private void clickCancelCategorybtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }
    //Method that adds the category by using the existing method for this in the manager class, calls the refresh method from the MoviePlayerController class and then closes the window
    @FXML
    private void clickAddCategorybtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        manager.addCategory(addcategoryfield.getText());
        mpc.refresh();
        stage.close();
    }
    
    //Method that sets the instance of the MoviePlayerController if called in its own class when opening the askAddCategory window
    public void setMoviePlayerController(MoviePlayerController mpc) {
        this.mpc = mpc;
    }
}
