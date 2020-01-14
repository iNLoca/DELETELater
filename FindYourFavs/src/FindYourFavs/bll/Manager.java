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

public class Manager {  
    public static Manager myManager = new Manager(); 

    DAL dal = new DAL();
    public List<Category> categoryList = new ArrayList();
    public List<Movie> movieList = new ArrayList();
    public List<Movie> ratings = new ArrayList();

    public void addMovie(int id, String name, int personalRating, int IMDBRating, String fileLink, int lastView) {
        dal.addMovie(id, name, personalRating, IMDBRating, fileLink, lastView);
    }

    public void addCategory(int id, String name) {
        dal.addCategory(id, name);
    }

    public List<Movie> getAllMovies() {
        movieList = dal.getAllMovies();
        return movieList;
    }
    
    public List<Category> getAllCategories() {
        categoryList = dal.getAllCategories();
        return categoryList;
    }    
    
    public void deleteMovieById(int id){
        dal.deleteMovieById(id);
    }
    
    public void deleteCategoryById(int id){
        dal.deleteCategoryById(id);
    }
    
    public void createCategory(){
        
    }

    public void addCategory(String name) {
        dal.addCategory(name);
    }
    
    public void addMovie(String name, int personalrating, int imdbrating, int lastview){
        dal.addMovie(name, personalrating, imdbrating, lastview);
    }
    
    public List<Movie>AlertData(){
       return dal.AlertData();
    }

    public void addNewUsrRating(int idOfMovie, String text) {
         dal.addNewUsrRating(idOfMovie,text);
    }

    public List<Movie> getAllMoviesWithFilter(String filterText) {
        
        return dal.getAllSongsWithFilter(filterText);
        
        
    }



   
}
