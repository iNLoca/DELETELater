/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import FindYourFavs.be.Category;
import FindYourFavs.bll.Manager;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class AskAddCategoryController implements Initializable {
    
    Manager manager = new Manager();
    MoviePlayerController mpc;
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

    @FXML
    private void clickCancelCategorybtn(ActionEvent event) {
        Stage stage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickAddCategorybtn(ActionEvent event) {
        Stage stage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();        
        manager.addCategory(addcategoryfield.getText());
        mpc.refresh();
        stage.close();
    }
    public void setMoviePlayerController(MoviePlayerController mpc){
    this.mpc=mpc;
    }
}
