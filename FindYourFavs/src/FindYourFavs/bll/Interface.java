/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.bll;

import FindYourFavs.be.Category;
import FindYourFavs.be.Movie;
import java.util.List;

public interface Interface {
    
    public List<Movie> getAllMovies();
    public List<Category> getAllCategories();
    public void deleteMovieById(int id);
    public void deleteCategoryById(int id);
    public void addCategory(String name);
    public void addMovie(String name, float personalrating, float imdbrating, int lastview, String filelink, String imdbbrowser);
    public List<Movie>AlertData();
    public void addNewUsrRating(int idOfMovie, String text);
    public List<Movie> getAllMoviesWithFilter(String filterText);
    public List<Movie> MoviesFromSelectedCategory(int catID);
    public void addToCatMovie(int movieId, int categoryId);
    public List<Movie> getFilteredMoviesByIMDB (String filterText);
    
}
