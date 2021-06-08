package equipe_11.metier;

import equipe_11.metier.Pion;

public class Ouvrier extends Pion
{
    private boolean bNourri = false; //en début de parti et en début de manche l'ouvrier n'est pas nourri

    public Ouvrier( String sCouleur, int iLig, char cCol )
    {
        super ( iLig, cCol, sCouleur );
    }
}