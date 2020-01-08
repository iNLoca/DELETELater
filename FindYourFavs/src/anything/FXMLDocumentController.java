/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anything;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private MenuButton categories;
    @FXML
    private Button addmovie;
    @FXML
    private Button deletemovie;
    @FXML
    private Button addcategory;
    @FXML
    private Button deletecategory;
    @FXML
    private ListView<?> listview;
    @FXML
    private Button addrating;
    @FXML
    private Button editrating;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickaddmovie(ActionEvent event) {
    }

    @FXML
    private void clickdeletemovie(ActionEvent event) {
    }

    @FXML
    private void clickaddcategory(ActionEvent event) {
    }

    @FXML
    private void clickdeletecategory(ActionEvent event) {
    }

    @FXML
    private void clickAddRating(ActionEvent event) {
    }

    @FXML
    private void clickEditRating(ActionEvent event) {
    }
    
}
