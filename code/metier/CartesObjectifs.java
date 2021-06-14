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
		boolean bOk;
		if ( !this.bEstAccompli ) 
		{
			switch( this.iIdentifiant )
			{
				case  1 ->{ bOk = this.verifierConditionCarte1();System.out.println(bOk); return bOk; }
				case  2 ->{ bOk = this.verifierConditionCarte2();System.out.println(bOk); return bOk; }
				case  3 ->{ bOk = this.verifierConditionCarte3();System.out.println(bOk); return bOk; }
				case  4 ->{ bOk = this.verifierConditionCarte4();System.out.println(bOk); return bOk; }
				case  5 ->{ bOk = this.verifierConditionCarte5();System.out.println(bOk); return bOk; }
				case  6 ->{ bOk = this.verifierConditionCarte6();System.out.println(bOk); return bOk; }
				case  7 ->{ bOk = this.verifierConditionCarte7();System.out.println(bOk); return bOk; }
				case  8 ->{ bOk = this.verifierConditionCarte8();System.out.println(bOk); return bOk; }
				case  9 ->{ bOk = this.verifierConditionCarte9();System.out.println(bOk); return bOk; }
			}
		}

		return false;
	}

	public int    getScore   (){ return this.iScore;    }
	public String getObjectif(){ return this.sObjectif; }
	public Joueur getJoueur  (){ return this.joueur;    }

	private boolean verifierConditionCarte1()
	{
		// Avoir plus de Batiments que d'Ouvriers.
		if( this.joueur.getBatiments().length > this.joueur.getNbOuvrier() )
		{
			this.bEstAccompli = true;
			return true;
		}

		return false;
	}

	private boolean verifierConditionCarte2()
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

	private boolean verifierConditionCarte3()
	{
		// Construire 1 Batiment qui produit et/ou consomme de l'eau.
		ArrayList<BatimentInfo> batInfo      = BatimentInfo.getLstBat();
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

	private boolean verifierConditionCarte4()
	{
		// Construire 2 Batiments qui produisent et/ou consomment des pieces.
		ArrayList<BatimentInfo> batInfo      = BatimentInfo.getLstBat();
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

	private boolean verifierConditionCarte5()
	{
		// Construire 1 Batiment qui produit et/ou consomme du bois ou de la pierre.
		ArrayList<BatimentInfo> batInfo      = BatimentInfo.getLstBat();
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

	private boolean verifierConditionCarte6()
	{
		// Construire un Batiment dont le cout est d'au moins 3 pierres.
		ArrayList<BatimentInfo> batInfo      = BatimentInfo.getLstBat();
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

	private boolean verifierConditionCarte7()
	{
		// Avoir 0 pieces.
		if( this.joueur.getQteRessource("PIECE") == 0 )
		{
			this.bEstAccompli = true;
			return true;
		}

		return false;
	}

	private boolean verifierConditionCarte8()
	{
		// Avoir au moins 6 pieces.
		if( this.joueur.getQteRessource("PIECE") >= 6 )
		{
			this.bEstAccompli = true;
			return true;
		}

		return false;
	}

	private boolean verifierConditionCarte9()
	{
		// Construire un Batiment dont le cout est d'au moins 3 pierres.
		ArrayList<BatimentInfo> batInfo      = BatimentInfo.getLstBat();
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

		sRet += String.format("|%-100.100s|", "Objectif : " + this.sObjectif) + "Score : " + this.iScore + " |";

		return sRet;
	}
}