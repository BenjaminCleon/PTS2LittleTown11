package equipe_11.metier;

import equipe_11.metier.utilitaire.Couleur;

public class Pion
{
    private int  iLig;
    private char cCol;

    private String sCoul;
    private String sNom ;
    
    public Pion(int iLig, char cCol, String sCoul, String sNom)
    {
        this.iLig = iLig;
        this.cCol = cCol;

        this.sCoul = sCoul;
        this.sNom  = sNom ;
    }

    public String getCoul(){ return this.sCoul; }
    public String getNom (){ return this.sNom ; }
    
    public void   setNom ( String sNom ){ this.sNom = sNom; }

    public String toString()
    {
        return this.sNom;
    }
}
