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

    //Creation of variales for this class
    private Manager manager = new Manager();
    private MoviePlayerController mpc;
    private float userrating;
    private List<Movie> movieLst;
    private ObservableList<Category> catLst;
    //the boolean add is used to decide if the movie should be added or not
    private boolean add = true;

    @FXML
    private Button cancelmovie;
    @FXML
    private Button addmoviebtn;
    @FXML
    private AnchorPane askaddmovie;
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
        //The existing categories are displayed on the Categories table
        catLst = FXCollections.observableArrayList(manager.getAllCategories());
        addmmoviecat.setCellValueFactory(new PropertyValueFactory<>("name"));
        //The selectionMode is set to Multiple so that when pressing Ctrl + Click multiple categories can be selected and assigned to the new movie
        catView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        catView.setItems(catLst);
    }

    //Method that confirms the addMovie and adds the movie with its properties to the database, also closes the window
    @FXML
    private void clickAddMoviebtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();

    //used to ensure that the userrating has a default value if the recieved by the user is either empty or out of bounds
        if (usrrating.getText().isEmpty() || parseFloat(usrrating.getText()) < 0 || parseFloat(usrrating.getText()) > 10) {
            userrating = 0;
        } else {
            userrating = parseFloat(usrrating.getText());
        }
    //used to ensure that the name recieved by the user does not match any of the already existing movies 
        movieLst = manager.getAllMovies();
        for (Movie movie : movieLst) {
            if (movie.getName().toLowerCase().equals(tittle.getText().toLowerCase())) {
                add = false;
            }
        }
    //if the movie is to be added, then it is added with all the recieved fields from the user
        if (add) {
            manager.addMovie(tittle.getText(), userrating, parseFloat(imdbrating.getText()), parseInt(lastviewd.getText()), addfilelink.getText(), imdblink.getText());
    //A refresh is executed so that the new movie is also included in the Movie table
            mpc.refresh();
            movieLst = manager.getAllMovies();
    //for each used to find again the movie that has just been added to the Movie table and the movies database
            for (Movie movie : movieLst) {
                if (movie.getName().toLowerCase().equals(tittle.getText().toLowerCase())) {
    //When the movie just added its found, the selected categories (it can be multiple, so a for each is used again) 
    //from the catView are also added to the movie with the manager method for this.
                    catLst = catView.getSelectionModel().getSelectedItems();
                    for (Category category : catLst) {
                        manager.addToCatMovie(movie.getId(), category.getId());
                    }
                }
            }
        }

        stage.close();
    }

    //Method that cancels the addMovie process and closes the window
    @FXML
    private void clickCancelMovieButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
        stage.close();
    }

     //Method that sets the instance of the MoviePlayerController if called in its own class when opening the askAddMovie window
    public void setMoviePlayerController(MoviePlayerController mpc) {
        this.mpc = mpc;
    }

    //Method for adding the FileLink to the new movie, it also ensures that the termination of these files is either mp4 or mpeg4
    @FXML
    private void clickChooseMovieButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter exFilterAll = new FileChooser.ExtensionFilter("Filter Files", "*.mp4", "*.mpeg4");

        fileChooser.getExtensionFilters().addAll(exFilterAll);

        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            addfilelink.setText(file.getAbsolutePath());
        }
    }
}
