    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.bll.util;

import FindYourFavs.be.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mac
 */

//This filter searches for name, but we need it to search for specific IMDBRating which is an int dum dum dum... + category
public class SearchMovies {
    
    public static List<Movie>searchMovies(List<Movie>movieLst,String filter){
      
        filter=filter.toLowerCase();
        List<Movie>filteredMovies = new ArrayList();
        
        for(Movie m: movieLst){
         if(filter.length() <= m.getName().length() && filter.equals(m.getName().toLowerCase().substring(0, filter.length())))
            {
           filteredMovies.addAll(movieLst);
            }
 
        }
        return filteredMovies;
    
    
    
        

    } 
}
