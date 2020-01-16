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
    private float personalRating;
    private float IMDBRating;
    private String fileLink;
    private int lastView;
    private String imdbbrowser;
    
    
    public Movie() {
       
         
   
       
    }

    public Movie(float personalRating) {
      this.personalRating=personalRating;
      
    }

    public Movie(int id, String name, float personalRating, float IMDBRating) {
        this.id=id;
        this.name=name;
        this.personalRating=personalRating;
        this.IMDBRating=IMDBRating;       
    }

    public Movie(String string) { 
         
    }

    public Movie(int id, String name, float personalRating, float IMDBRating, String imdbbrowser) {
        this.id=id;
        this.name=name;
        this.personalRating=personalRating;
        this.IMDBRating=IMDBRating;
        this.imdbbrowser=imdbbrowser;
    }



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

    public float getPersonalRating() {
        return personalRating;
    }

    public void setPersonalRating(float personalRating) {
        this.personalRating = personalRating;
    }

    public float getIMDBRating() {
        return IMDBRating;
    }

    public void setIMDBRating(float IMDBRating) {
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

    public String getImdbbrowser() {
        return imdbbrowser;
    }

    public void setImdbbrowser(String imdbbrowser) {
        this.imdbbrowser = imdbbrowser;
    }
    
      
    
    public Movie (int id, String name, float personalRating, float IMDBRating, String fileLink, int lastView){
        this.id=id;
        this.name=name;
        this.personalRating=personalRating;
        this.IMDBRating=IMDBRating;
        this.fileLink=fileLink;
        this.lastView=lastView;
       
    }
    public Movie (String name, float personalRating, float IMDBRating){
        
        this.name=name;
        this.personalRating=personalRating;
        this.IMDBRating=IMDBRating;
    }

    @Override
    public String toString() {
        return name + "\b with"  + "  " +  "personalRating=" + personalRating + "\n and" + " lastView= " + IMDBRating;
        //for some reason IMDBRating shows the year aka lastViewed data.
    }
    
    

}
