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
        switch ( sObjectif )
        {
            case "Avoir 0 piece" -> { if(joueur.getNbPiece() == 0) { return true; } }
            default -> { return false; }
        }
    }
}