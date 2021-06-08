package littletown.metier;

public class Ouvrier extends Pion
{
    private Jeu jeu;
    private boolean estNourri = false;

    public Ouvrier( String sType, String sCouleur, Point point, Jeu jeu )
    {
        super(sType, sCouleur, point);
        this.jeu = jeu;
    }

    public boolean activer()
    {
        int posX = point.getX();
        int posY = point.getY();
        String[][] plateau = jeu.getPlateau();

        for( int lig = posY - 1; lig <= posY + 1; lig++ )
        {
            for( int col = posX - 1 ; col <= posX + 1; col++ )
            {
                if (!(plateau[lig][col].equals(super.getType() )) )
                {
                    
                }
            }
        }
    }

    public void nourrir( Ressource res )
    {
        this.setNourri( res.getEstMangeable() && res.consommerRessource(1) )
    }

    public void setNourri( boolean estNourri ) { this.estNourri = estNourri; }
}