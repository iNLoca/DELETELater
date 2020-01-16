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
import java.io.FileFilter;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.EventObject;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.List;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 */
public class AskAddMovieController implements Initializable {
    Manager manager = new Manager();
        MoviePlayerController mpc;
        int userrating;
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
        
        
        
        /*
        //choiceboxcat.getItems(categoriesView.setItems(categoryLst));

        //getItems returns the ObservableList object which u can add items to. 
        
        choiceboxcat.getItems().add("Action");
        choiceboxcat.getItems().add("Animation");
        choiceboxcat.getItems().add("Comedy");
        choiceboxcat.getItems().add("Crime");
        choiceboxcat.getItems().add("Drama");
        choiceboxcat.getItems().add("Film-Noir");
        choiceboxcat.getItems().add("Horror");
        choiceboxcat.getItems().add("Thriller");
        choiceboxcat.getItems().add("War");
        choiceboxcat.getItems().add("Western");
        choiceboxcat.getItems().add("Categories");

        //Set value 
        
        choiceboxcat.setValue("Action");
        choiceboxcat.setValue("Comedy");
        choiceboxcat.setValue("Crime");
        choiceboxcat.setValue("Drama");
        choiceboxcat.setValue("Film-Noir");
        choiceboxcat.setValue("Horror");
        choiceboxcat.setValue("Thriller");
        choiceboxcat.setValue("War");
        choiceboxcat.setValue("Western");
        choiceboxcat.setValue("Categories");

        
        
        choiceboxcat2.getItems().add("Action");
        choiceboxcat2.getItems().add("Animation");
        choiceboxcat2.getItems().add("Comedy");
        choiceboxcat2.getItems().add("Crime");
        choiceboxcat2.getItems().add("Drama");
        choiceboxcat2.getItems().add("Film-Noir");
        choiceboxcat2.getItems().add("Horror");
        choiceboxcat2.getItems().add("Thriller");
        choiceboxcat2.getItems().add("War");
        choiceboxcat2.getItems().add("Western");
        choiceboxcat2.getItems().add("Categories");

        //Set value 
        
        choiceboxcat2.setValue("Action");
        choiceboxcat2.setValue("Comedy");
        choiceboxcat2.setValue("Crime");
        choiceboxcat2.setValue("Drama");
        choiceboxcat2.setValue("Film-Noir");
        choiceboxcat2.setValue("Horror");
        choiceboxcat2.setValue("Thriller");
        choiceboxcat2.setValue("War");
        choiceboxcat2.setValue("Western");
        choiceboxcat2.setValue("Categories");
        
        
        
        choiceboxcat3.getItems().add("Action");
        choiceboxcat3.getItems().add("Animation");
        choiceboxcat3.getItems().add("Comedy");
        choiceboxcat3.getItems().add("Crime");
        choiceboxcat3.getItems().add("Drama");
        choiceboxcat3.getItems().add("Film-Noir");
        choiceboxcat3.getItems().add("Horror");
        choiceboxcat3.getItems().add("Thriller");
        choiceboxcat3.getItems().add("War");
        choiceboxcat3.getItems().add("Western");
        choiceboxcat3.getItems().add("Categories");

        //Set value 
        
        choiceboxcat3.setValue("Action");
        choiceboxcat3.setValue("Comedy");
        choiceboxcat3.setValue("Crime");
        choiceboxcat3.setValue("Drama");
        choiceboxcat3.setValue("Film-Noir");
        choiceboxcat3.setValue("Horror");
        choiceboxcat3.setValue("Thriller");
        choiceboxcat3.setValue("War");
        choiceboxcat3.setValue("Western");
        choiceboxcat3.setValue("Categories");

        */

    }

    @FXML
    private void clickAddMoviebtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        
        if(usrrating.getText().isEmpty() || parseInt(usrrating.getText())<0 || parseInt(usrrating.getText())>10) {
            userrating=0;
        }
        else{
        userrating = parseInt(usrrating.getText()) ;
        }
         movieLst = manager.getAllMovies();
        
        for (Movie movie : movieLst) {
            if(movie.getName().toLowerCase().equals(tittle.getText().toLowerCase())) {
                add=false;
            }
        }


       if (add) {
            manager.addMovie(tittle.getText(), userrating, parseInt(imdbrating.getText()), parseInt(lastviewd.getText()), addfilelink.getText());
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
