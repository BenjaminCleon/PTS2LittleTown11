package littletown.metier;

import java.awt.Point;

public class Ouvrier
{
    private Point  point;
    private String sType;
    private String sCouleur;

    private Jeu jeu;

    private boolean estNourri = false; //en début de parti et en début de manche l'ouvrier n'est pas nourri

    public Ouvrier( String sType, String sCouleur, Point point, Jeu jeu )
    {
        this.sType    = sType.toUpperCase();
        this.sCouleur = sCouleur;
        this.point = point;
        this.jeu = jeu;
    }

    public String getType()    { return this.sType;    }
    public String getCouleur() { return this.sCouleur; }

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

    //On vérifie si la ressource est mangeable puis on consomme après pour ne pas consommer sans manger la ressource
    public void nourrir( Ressource res )
    {
        this.setNourri( res.getEstMangeable() && res.consommerRessource(1) )
    }

    public void setNourri( boolean estNourri ) { this.estNourri = estNourri; }

    public boolean placer( int posX, int posY )
    {
        this.jeu.placerOuvrier( this, posX, posY );
    }
}