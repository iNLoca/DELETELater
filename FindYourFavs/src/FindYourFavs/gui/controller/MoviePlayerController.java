/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.gui.controller;

import FindYourFavs.be.Category;
import FindYourFavs.be.Movie;
import FindYourFavs.bll.Manager;
import FindYourFavs.bll.util.SearchMovies;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.EventObject;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class MoviePlayerController implements Initializable {

    Manager manager = new Manager();
    Category category;
    ObservableList<Movie> movieLst;
    ObservableList<Category> categoryLst;

    @FXML
    private Label label;
    @FXML
    private Button addmovie;
    @FXML
    private Button deletemovie;
    @FXML
    private Button addcategory;
    @FXML
    private Button deletecategory;
    @FXML
    private Button addrating;
    @FXML
    private Button editrating;
    @FXML
    private Label lblChosenCategory;
    @FXML
    private TableView<Category> categoriesView;
    @FXML
    private TableColumn<Category, String> categoriesColumn;
    @FXML
    private Button playmovie;
    @FXML
    private TextField searchbarField;
    @FXML
    private TableView<Movie> tableview;
    @FXML
    private TableColumn<Movie, String> movietittle;
    @FXML
    private TableColumn<Movie, Integer> usrrating;
    @FXML
    private TableColumn<Movie, Integer> imdbrating;

    private SelectionModel<Movie> currentListSelection;
    @FXML
    private ImageView searchButton;
    @FXML
    private Button linkbtn;
    @FXML
    private Button showall;
    @FXML
    private TextField ratinglbl;
    @FXML
    private Button searchbyratingbtn;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        

        Alert();

        refresh();
        

    }

    @FXML
    private void clickaddmovie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindYourFavs/gui/view/AskAddMovie.fxml"));
        Parent root = loader.load();
        AskAddMovieController ctrl = loader.getController();
        ctrl.setMoviePlayerController(this);
       
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clickdeletemovie(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindYourFavs/gui/view/AskDeleteMovie.fxml"));
        Parent root = loader.load();
        AskDeleteMovieController ctrl = loader.getController();
        ctrl.setMoviePlayerController(this);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void clickaddcategory(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindYourFavs/gui/view/AskAddCategory.fxml"));
        Parent root = loader.load();
        AskAddCategoryController ctrl = loader.getController();
        ctrl.setMoviePlayerController(this);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void clickdeletecategory(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindYourFavs/gui/view/AskDeleteCategory.fxml"));
        Parent root = loader.load();
        AskDeleteCategoryController ctrl = loader.getController();
        ctrl.setMoviePlayerController(this);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clickAddRating(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindYourFavs/gui/view/AddRating.fxml"));
        Parent root = loader.load();
        AddRatingController ctrler = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clickEditRating(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindYourFavs/gui/view/EditRating.fxml"));
        Parent root = loader.load();
        EditRatingController ctrl = loader.getController();
        ctrl.setMoviePlayerController(this);
        ctrl.setMovie(tableview.getSelectionModel().getSelectedItem());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    public void Alert(){
    
     manager.AlertData();
           
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("REMINDER");
        alert.setHeaderText(null);
        alert.setContentText("Remember to delete old movies! The following movies are with user rating less than 6 stars and last viewed more than 2 years ago:"
                + manager.AlertData().toString());
        
        
        
        alert.showAndWait();
    
    }

    public float get() {
        float rtng = tableview.getSelectionModel().getSelectedItem().getPersonalRating();
        return rtng;
    }

    //deletes a movie from the database       
    public void deleteMovie() {
        manager.deleteMovieById(tableview.getSelectionModel().getSelectedItem().getId());
    }

    //deletes a category from the database
    public void deleteCategory() {
        manager.deleteCategoryById(categoriesView.getSelectionModel().getSelectedItem().getId());
    }

    public String returnNameOfMovie() {
        return tableview.getSelectionModel().getSelectedItem().getName();
    }
    public Movie returnMovie(){
        return tableview.getSelectionModel().getSelectedItem();
    }

    public void refresh() {

        movieLst = FXCollections.observableArrayList(manager.getAllMovies());
        movietittle.setCellValueFactory(new PropertyValueFactory<>("name"));
        usrrating.setCellValueFactory(new PropertyValueFactory<>("personalRating"));
        imdbrating.setCellValueFactory(new PropertyValueFactory<>("IMDBRating"));
        lblChosenCategory.setText("No category chosen yet");
        tableview.setItems(movieLst);

        categoryLst = FXCollections.observableArrayList(manager.getAllCategories());
        categoriesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoriesView.setItems(categoryLst);
     
    }

    @FXML
    private void chosenCategory(MouseEvent event) {
        lblChosenCategory.setText(categoriesView.getSelectionModel().getSelectedItem().getName());
        movieLst = FXCollections.observableArrayList(manager.MoviesFromSelectedCategory(categoriesView.getSelectionModel().getSelectedItem().getId()));
        movietittle.setCellValueFactory(new PropertyValueFactory<>("name"));
        usrrating.setCellValueFactory(new PropertyValueFactory<>("personalRating"));
        imdbrating.setCellValueFactory(new PropertyValueFactory<>("IMDBRating"));
        tableview.setItems(movieLst);        
    }
    
    @FXML
    private void searchMovieBtn(MouseEvent event) {
        
        String query = searchbarField.getText();
        if(query!=null){
        movieLst = FXCollections.observableArrayList(manager.getAllMoviesWithFilter(query));
        tableview.setItems(movieLst);
        }
        else refresh();
    }

    @FXML
    private void playMovie(ActionEvent event) throws IOException {
       String currentFileLink = tableview.getSelectionModel().getSelectedItem().getFileLink();
       File movieFile = new File(currentFileLink);
       if(movieFile.exists()){
       Desktop.getDesktop().open(movieFile);
       }       
        //File movieFile = new File("src\\\\FindYourFavs\\\\Trailers\\\\Iron_Man_2_Official_Trailer_1_2010_-_Marvel_Movie_HD.mp4");
        //File movieFile = new File("/Users/mac/NetBeansProjects/FindYourFavs/FindYourFavs/src/FindYourFavs/Trailers/Iron_Man_2_Official_Trailer_1_2010_-_Marvel_Movie_HD.mp4");
    }

    @FXML
    private void clicklinkbtn(ActionEvent event) throws MalformedURLException, URISyntaxException, IOException {
        String selectedMovieBrowser = tableview.getSelectionModel().getSelectedItem().getImdbbrowser();
        Desktop.getDesktop().browse(new URL(selectedMovieBrowser).toURI());      
    }

    @FXML
    private void clickShowAllMovies(ActionEvent event) {
        refresh();
    }


    @FXML
    private void clickSearchByRatingBtn(ActionEvent event) {
        String query = ratinglbl.getText();
        if(query!=null){
        movieLst = FXCollections.observableArrayList(manager.getFilteredMoviesByIMDB(query));
        tableview.setItems(movieLst);
        }
        else refresh();        
    }
    
}
