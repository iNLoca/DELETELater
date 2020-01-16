/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.bll;

import FindYourFavs.be.Category;
import FindYourFavs.be.Movie;
import FindYourFavs.dal.DAOCatMovie;
import FindYourFavs.dal.DAOCategory;
import FindYourFavs.dal.DAOMovie;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Interface {

    public static Manager myManager = new Manager();

    DAOCategory DAOC = new DAOCategory();
    DAOMovie DAOM = new DAOMovie();    
    DAOCatMovie DAOCM = new DAOCatMovie();
    List<Category> categoryList = new ArrayList();
    List<Movie> movieList = new ArrayList();

    @Override
    public List<Movie> getAllMovies() {
        movieList = DAOM.getAllMovies();
        return movieList;
    }

    @Override
    public List<Category> getAllCategories() {
        categoryList = DAOC.getAllCategories();
        return categoryList;
    }

    @Override
    public void deleteMovieById(int id) {
        DAOM.deleteMovieById(id);
    }

    @Override
    public void deleteCategoryById(int id) {
        DAOC.deleteCategoryById(id);
    }

    @Override
    public void addCategory(String name) {
        DAOC.addCategory(name);
    }

    @Override
    public void addMovie(String name, float personalrating, float imdbrating, int lastview, String filelink, String imdbbrowser) {
        DAOM.addMovie(name, personalrating, imdbrating, lastview, filelink, imdbbrowser);
    }

    @Override
    public List<Movie> AlertData() {
        return DAOM.AlertData();
    }

    @Override
    public void addNewUsrRating(int idOfMovie, String text) {
        DAOM.addNewUsrRating(idOfMovie, text);
    }

    @Override
    public List<Movie> getAllMoviesWithFilter(String filterText) {
        return DAOM.getAllMoviesWithFilter(filterText);
    }

    @Override
    public List<Movie> MoviesFromSelectedCategory(int catID) {
        return DAOCM.DisplayOnlyMoviesInCategory(catID);
    }

    @Override
    public void addToCatMovie(int movieId, int categoryId) {
        DAOCM.addToCatMovie(movieId, categoryId);
    }

    @Override
    public List<Movie> getFilteredMoviesByIMDB(String filterText) {
        return DAOM.getFilteredMoviesByIMDB(filterText);
    }

}
