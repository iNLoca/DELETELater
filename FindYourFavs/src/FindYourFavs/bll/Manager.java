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
    
    static List<Category> categoryList  = new ArrayList();
    static List<Movie> movieList  = new ArrayList();
    
    DAL dal = new DAL();
    
    public void addMovie (int id, String name, int personalRating, int IMDBRating, String fileLink, int lastView){
        dal.addMovie(id, name, personalRating, IMDBRating, fileLink, lastView);
    }
    
    public void addCategory(int id, String name){
        dal.addCategory(id, name);
    }
}
