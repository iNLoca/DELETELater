
package FindYourFavs.be;

//In this class we set up the category properties 
public class Category {
    private int id;
    private String name;
    
//Getters and Setters for Id and Name
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
    
// Empty constructor
    public Category() {   
    }
    
// Full constructor    
    public Category (int id, String name){
        this.id=id;
        this.name=name;
    }
}
