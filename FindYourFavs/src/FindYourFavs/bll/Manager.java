/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.bll;

import FindYourFavs.be.Category;
import FindYourFavs.be.Movie;
import FindYourFavs.dal.DAL;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Interface {  
    
    public static Manager myManager = new Manager(); 
    DAL dal = new DAL();
    List<Category> categoryList = new ArrayList();
    List<Movie> movieList = new ArrayList();

    @Override
    public List<Movie> getAllMovies() {
        movieList = dal.getAllMovies();
        return movieList;
    }
    
    @Override
    public List<Category> getAllCategories() {
        categoryList = dal.getAllCategories();
        return categoryList;
    }    
    
    @Override
    public void deleteMovieById(int id){
        dal.deleteMovieById(id);
    }
    
    @Override
    public void deleteCategoryById(int id){
        dal.deleteCategoryById(id);
    }

    @Override
    public void addCategory(String name) {
        dal.addCategory(name);
    }
    
    @Override
    public void addMovie(String name, float personalrating, float imdbrating, int lastview, String filelink, String imdbbrowser){
        dal.addMovie(name, personalrating, imdbrating, lastview, filelink, imdbbrowser);
    }
    
    @Override
    public List<Movie>AlertData(){
       return dal.AlertData();
    }

    @Override
    public void addNewUsrRating(int idOfMovie, String text) {
         dal.addNewUsrRating(idOfMovie,text);
    }

    @Override
    public List<Movie> getAllMoviesWithFilter(String filterText) {        
        return dal.getAllMoviesWithFilter(filterText);       
    }
    
    @Override
    public List<Movie> MoviesFromSelectedCategory(int catID){
    return dal.DisplayOnlyMoviesInCategory(catID);
    }
    
    @Override
    public void addToCatMovie(int movieId, int categoryId){
        dal.addToCatMovie(movieId, categoryId);
    }

    @Override
    public List<Movie> getFilteredMoviesByIMDB (String filterText){
        return dal.getFilteredMoviesByIMDB(filterText);
    }

}
