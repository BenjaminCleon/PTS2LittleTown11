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
            case "Avoir 2 fois plus de nourriture que d'ouvrier" -> 
                {
                    if(this.joueur.getRessource("eau")+this.joueur.getRessource("ble") >= this.joueur.getNbOuvrier()*2)
                    {
                        return true;
                    } 
                }
            default -> { return false; }
        }
    }
}