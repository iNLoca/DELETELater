/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui;

import FindYourFavs.be.Category;
import FindYourFavs.be.Movie;
import FindYourFavs.bll.Manager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author mac
 */
public class FXMLDocumentController implements Initializable {
    
    Movie movie = new Movie();
    Category category = new Category();
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
  /*private void removeMovie(ActionEvent event) {
        movie = 
    }
    
    private void removeCategory(ActionEvent event) {
        category = 
    }
   */ 
}
