
package FindYourFavs.be;

// In this class we set up the movie properties 
public class Movie {
    
    private int id;
    private String name;
    private float personalRating;
    private float IMDBRating;
    private String fileLink;
    private int lastView;
    private String imdbbrowser;
    
// Getters and setters for all of the variables    
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
    
    //Different constructors depending on what we needed in the different instances of this class
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
    
    public Movie (String name, float personalRating, int lastView,String imdbbrowser){
        this.name=name;
        this.personalRating=personalRating;
        this.lastView=lastView;
        this.imdbbrowser = imdbbrowser;
    }

    public Movie(int id, String name, float personalRating, float IMDBRating, String fileLink, int lastView, String imdbbrowser) {
        this.id = id;
        this.name = name;
        this.personalRating = personalRating;
        this.IMDBRating = IMDBRating;
        this.fileLink = fileLink;
        this.lastView = lastView;
        this.imdbbrowser = imdbbrowser;
    }
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

    // To string Method that overrides the existing one and allows us to correctly print the Movie Object with the variales name, personalrating and lastview
    @Override
    public String toString() {
        return name + "\b with"  + "  " +  "personalRating=" + personalRating + "\n and" + " lastView= " + lastView;
    }
}
