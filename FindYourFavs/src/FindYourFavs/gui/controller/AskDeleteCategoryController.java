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
 *
 * @author mac
 */
public class AskDeleteCategoryController implements Initializable {
    
    MoviePlayerController mpc;

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
        // TODO
    }    

    @FXML
    private void clickDeleteCategorybtn(ActionEvent event) {
        
        Stage stage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
        mpc.deleteCategory();
        mpc.refresh();
        stage.close();
    }

    @FXML
    private void clickCancelCategorybtn(ActionEvent event) {
        
        Stage stage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }
    
     public void setMoviePlayerController(MoviePlayerController mpc){
    this.mpc=mpc;
    }
    
}
