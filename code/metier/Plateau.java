public class Plateau 
{
    // Attributs
    private int       iNombreJoueur;
    private Tuile[][] oPlateau; // 6lig, 9col

    // Méthodes
    public Plateau( int iNombreJoueur )
    {
        this.oPlateau = new Tuile[6][9];
        this.iNombreJoueur = iNombreJoueur;
    }
}
