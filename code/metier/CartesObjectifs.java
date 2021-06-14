package equipe_11.metier;

import java.util.ArrayList;

import equipe_11.BatimentInfo;

public class CartesObjectifs
{
    private static int nbCarteObjectif;
    private        int iIdentifiant;

    private int    iScore;
    private String sObjectif;
    private Joueur joueur;

    private boolean bEstAccompli;

    public CartesObjectifs ( int iScore, String sObjectif )
    {
        this.iIdentifiant = ++CartesObjectifs.nbCarteObjectif;

        this.iScore    = iScore;
        this.sObjectif = sObjectif;
        this.joueur    = null;

        this.bEstAccompli = false;
    }

    public boolean objAccompli()
    {
        System.out.println( "CartesObj-EstAccompli : " + this.bEstAccompli );
        if ( !this.bEstAccompli ) 
        {
            System.out.println( "CartesObj-Identifiant : " + this.iIdentifiant );
            switch( this.iIdentifiant )
            {
                case  1 ->{ this.verrifierConditionCarte1(); }
                case  2 ->{ this.verrifierConditionCarte2(); }
                case  3 ->{ this.verrifierConditionCarte3(); }
                case  4 ->{ this.verrifierConditionCarte4(); }
                case  5 ->{ this.verrifierConditionCarte5(); }
                case  6 ->{ this.verrifierConditionCarte6(); }
                case  7 ->{ this.verrifierConditionCarte7(); }
                case  8 ->{ this.verrifierConditionCarte8(); }
                case  9 ->{ this.verrifierConditionCarte9(); }
            }
        }

        return false;
    }

    public int    getScore()   { return this.iScore;    }
    public String getObjectif(){ return this.sObjectif; }
    public Joueur getJoueur()  { return this.joueur;    }

    private boolean verrifierConditionCarte1()
    {
        // Avoir plus de Batiments que d'Ouvriers.
        if( this.joueur.getBatiments().length > this.joueur.getNbOuvrier() )
        {
            this.bEstAccompli = true;
            return true;
        }

        return false;
    }

    private boolean verrifierConditionCarte2()
    {
        // Avoir au moins 2 fois plus de cubes Nourriture que d'Ouvriers.
        int blePlusEau = this.joueur.getQteRessource("BLE") + this.joueur.getQteRessource("EAU");
        if( blePlusEau >= ( this.joueur.getNbOuvrier()*2 ) )
        {
            this.bEstAccompli = true;
            return true;
        }
        return false;
    }

    private boolean verrifierConditionCarte3()
    {
        // Construire 1 Batiment qui produit et/ou consomme de l'eau.
        ArrayList<BatimentInfo> batInfo      = this.joueur.getJeu().getLstBat();
        Pion[]                  tabBatJoueur = this.joueur.getBatiments();

        for( BatimentInfo b : batInfo )
            for( int cpt = 0; cpt < tabBatJoueur.length; cpt++ )
                if( b.name().equals( tabBatJoueur[cpt].getNom() ) )
                    if( b.getPoissonReA() >= 1 || b.getPoissonRec() >= 1 )
                    {
                        this.bEstAccompli = true;
                        return true;
                    }

        return false;
    }

    private boolean verrifierConditionCarte4()
    {
        // Construire 2 Batiments qui produisent et/ou consomment des pieces.
        ArrayList<BatimentInfo> batInfo      = this.joueur.getJeu().getLstBat();
        Pion[]                  tabBatJoueur = this.joueur.getBatiments();

        int nbBatPiece = 0;
        for( BatimentInfo b : batInfo )
            for( int cpt = 0; cpt < tabBatJoueur.length; cpt++ )
                if( b.name().equals( tabBatJoueur[cpt].getNom() ) )
                    if( b.getPcReA() >= 1 || b.getPcRec() >= 1 )
                    {
                        nbBatPiece++;
                        if( nbBatPiece >= 2 )
                        {
                            this.bEstAccompli = true;
                            return true;
                        }
                    }

        return false;
    }

    private boolean verrifierConditionCarte5()
    {
        // Construire 1 Batiment qui produit et/ou consomme du bois ou de la pierre.
        ArrayList<BatimentInfo> batInfo      = this.joueur.getJeu().getLstBat();
        Pion[]                  tabBatJoueur = this.joueur.getBatiments();

        for( BatimentInfo b : batInfo )
            for( int cpt = 0; cpt < tabBatJoueur.length; cpt++ )
                if( b.name().equals( tabBatJoueur[cpt].getNom() ) )
                    if( b.getPierreReA() >= 1 || b.getPierreRec() >= 1 || b.getBoisReA() >= 1 || b.getBoisRec() >= 1 )
                    {
                        this.bEstAccompli = true;
                        return true;
                    }

        return false;
    }

    private boolean verrifierConditionCarte6()
    {
        // Construire un Batiment dont le cout est d'au moins 3 pierres.
        ArrayList<BatimentInfo> batInfo      = this.joueur.getJeu().getLstBat();
        Pion[]                  tabBatJoueur = this.joueur.getBatiments();

        for( BatimentInfo b : batInfo )
            for( int cpt = 0; cpt < tabBatJoueur.length; cpt++ )
                if( b.name().equals( tabBatJoueur[cpt].getNom() ) )
                    if( b.getPierreReq() >= 3 )
                    {
                        this.bEstAccompli = true;
                        return true;
                    }

        return false;
    }

    private boolean verrifierConditionCarte7()
    {
        // Avoir 0 pieces.
        if( this.joueur.getQteRessource("PIECE") == 0 )
        {
            this.bEstAccompli = true;
            return true;
        }

        return false;
    }

    private boolean verrifierConditionCarte8()
    {
        // Avoir au moins 6 pieces.
        if( this.joueur.getQteRessource("PIECE") >= 6 )
        {
            this.bEstAccompli = true;
            return true;
        }

        return false;
    }

    private boolean verrifierConditionCarte9()
    {
        // Construire un Batiment dont le cout est d'au moins 3 pierres.
        ArrayList<BatimentInfo> batInfo      = this.joueur.getJeu().getLstBat();
        Pion[]                  tabBatJoueur = this.joueur.getBatiments();

         for( BatimentInfo b : batInfo )
            for( int cpt = 0; cpt < tabBatJoueur.length; cpt++ )
                if( b.name().equals( tabBatJoueur[cpt].getNom() ) )
                    if( b.getBoisReq() >= 3 )
                    {
                        this.bEstAccompli = true;
                        return true;
                    }

        return false;
    }

    public void setJoueur( Joueur j ){ this.joueur = j; }

    public String toString()
    {
        String sRet = "";

        sRet += "\nScore : " + this.iScore + "\n" + "Objectif : " + this.sObjectif;

        return sRet;
    }
}
