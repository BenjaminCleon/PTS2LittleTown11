package equipe_11.metier;

public class CartesObjectifs
{
    private int    iScore;
    private String sObjectif;
    private Joueur joueur;

    public CartesObjectifs ( int iScore, String sObjectif, Joueur joueur )
    {
        this.iScore    = iScore;
        this.sObjectif = sObjectif;
        this.joueur    = joueur;
    }

    public boolean bAccompli ()
    {


        return false;
    }
}