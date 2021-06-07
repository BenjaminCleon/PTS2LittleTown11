package littletown.metier;

public class Plateau 
{
    // Attributs
    private int       iNombreJoueur;
    private Tuile[][] tabPlateau; // 6lig, 9col

    // Méthodes
    public Plateau( int iNombreJoueur )
    {
        this.tabPlateau      = new Tuile[6][9];
        this.iNombreJoueur = iNombreJoueur;

        remplirPlateau();
    }

    public Tuile[][] getPlateau() { return this.tabPlateau; }

    public void remplirPlateau()
    {
        for(Tuile t : tabPlateau)
        {
            if(t == null){ t = new Ressource( "ble", true); }
        }
    }
}
