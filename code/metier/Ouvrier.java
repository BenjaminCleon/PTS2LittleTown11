package equipe_11.metier;

import equipe_11.metier.Pion;

public class Ouvrier extends Pion
{
    private boolean bNourri = false; //en début de parti et en début de manche l'ouvrier n'est pas nourri

    public Ouvrier( String sCouleur, int iLig, char cCol )
    {
        super ( iLig, cCol, sCouleur );
    }

    //On vérifie si la ressource est mangeable puis on consomme après pour ne pas consommer sans manger la ressource
    public void nourrir( Ressource res )
    {
        this.setNourri( res.getEstMangeable() && res.consommerRessource(1) );
    }

    public void setNourri( boolean bNourri ) { this.bNourri = bNourri; }
}