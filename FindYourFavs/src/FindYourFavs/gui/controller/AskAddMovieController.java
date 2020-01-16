/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import FindYourFavs.be.Category;
import FindYourFavs.be.Movie;
import FindYourFavs.bll.Manager;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.List;

/**
 * FXML Controller class
 */
public class AskAddMovieController implements Initializable {
    Manager manager = new Manager();
        MoviePlayerController mpc;
        float userrating;
        List<Movie> movieLst;
         ObservableList<Category>catLst;
        boolean add=true;

    @FXML
    private Button cancelmovie;
    @FXML
    private Button addmoviebtn;
    @FXML
    private AnchorPane askaddmovie;
    private ChoiceBox<String> choiceboxcat;
    @FXML
    private JFXTextField addfilelink;
    @FXML
    private TextField tittle;
    @FXML
    private TextField usrrating;
    @FXML
    private TextField imdbrating;
    @FXML
    private TextField lastviewd;
    private ChoiceBox<String> choiceboxcat2;
    private ChoiceBox<String> choiceboxcat3;
    @FXML
    private Button choosemovie;
    @FXML
    private TextField imdblink;
    @FXML
    private TableColumn<Category, String> addmmoviecat;
    @FXML
    private TableView<Category> catView;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        catLst = FXCollections.observableArrayList(manager.getAllCategories());
        addmmoviecat.setCellValueFactory(new PropertyValueFactory<>("name"));
        catView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        catView.setItems(catLst);
        
    }

    @FXML
    private void clickAddMoviebtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        
        if(usrrating.getText().isEmpty() || parseFloat(usrrating.getText())<0 || parseFloat(usrrating.getText())>10) {
            userrating=0;
        }
        else{
        userrating = parseFloat(usrrating.getText()) ;
        }
         movieLst = manager.getAllMovies();
        
        for (Movie movie : movieLst) {
            if(movie.getName().toLowerCase().equals(tittle.getText().toLowerCase())) {
                add=false;
            }
        }


       if (add) {
            manager.addMovie(tittle.getText(), userrating, parseFloat(imdbrating.getText()), parseInt(lastviewd.getText()), addfilelink.getText(),imdblink.getText());
            mpc.refresh();
             movieLst = manager.getAllMovies();      
            for (Movie movie : movieLst) {
               if(movie.getName().toLowerCase().equals(tittle.getText().toLowerCase())){
                   catLst= catView.getSelectionModel().getSelectedItems();
                   for (Category category : catLst) {
                    manager.addToCatMovie(movie.getId(), category.getId()); 
                       
                   }
                    
                                                                                       }
            }
                     }

        stage.close();
    }

    @FXML
    private void clickCancelMovieButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }

    
     public void setMoviePlayerController(MoviePlayerController mpc){
    this.mpc=mpc;
    }

    @FXML
    private void clickChooseMovieButton(ActionEvent event) {        
 
        FileChooser fileChooser = new FileChooser();
    
        FileChooser.ExtensionFilter exFilterAll = new FileChooser.ExtensionFilter("Filter Files", "*.mp4", "*.mpeg4");
        
        fileChooser.getExtensionFilters().addAll(exFilterAll);

        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(null);
        if(file!=null){
            addfilelink.setText(file.getAbsolutePath());
        } 
       
    }
   

    @FXML
    private void clickIMDBLink(ActionEvent event) {
        
        
        
    }

}
