package littletown.metier;

public class Tuile extends Pion
{
    // Attributs
    private String  sType;

    // Méthodes
    public Tuile( String sType )
    {
        this.sType = sType;
    }    

    public String toString()
    {
        return "Tuile de type : " + this.sType;
    }
}
