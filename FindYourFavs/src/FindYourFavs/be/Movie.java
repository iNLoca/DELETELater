/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.be;

/**
 *
 * @author rtlop
 */
public class Movie {
    
    private int id;
    private String name;
    private int personalRating;
    private int IMDBRating;
    private String fileLink;
    private int lastView;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonalRating() {
        return personalRating;
    }

    public void setPersonalRating(int personalRating) {
        this.personalRating = personalRating;
    }

    public int getIMDBRating() {
        return IMDBRating;
    }

    public void setIMDBRating(int IMDBRating) {
        this.IMDBRating = IMDBRating;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public int getLastView() {
        return lastView;
    }

    public void setLastView(int lastView) {
        this.lastView = lastView;
    }
    
    
    public Movie (int id, String name, int personalRating, int IMDBRating, String fileLink, int lastView){
        this.id=id;
        this.name=name;
        this.personalRating=personalRating;
        this.IMDBRating=IMDBRating;
        this.fileLink=fileLink;
        this.lastView=lastView;
    }
}
