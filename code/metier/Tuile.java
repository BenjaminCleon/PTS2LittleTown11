package equipe_11.metier;

public class Tuile
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
        return "Tuile de type : " + this.sType + "\n";
    }
}
