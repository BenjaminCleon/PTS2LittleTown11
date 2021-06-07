public class Tuile
{
    // Attributs
    private String  sType;
    private boolean bActive;

    // Méthodes

    public Tuile( String sType )
    {
        this.sType = sType;
    }    

    public boolean isActive(){ return bActive; }
}
