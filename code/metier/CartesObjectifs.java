package equipe_11.metier;

import java.util.ArrayList;

import equipe_11.BatimentInfo;
/** Cette classe regroupe les différents objectifs et
  * donne les diverses informations
  *
  * @author Equipe 11
  */
public class CartesObjectifs
{
	/**
	 * Nombre de cartes objectifs, s'incrémente automatiquement
	 */
	private static int nbCarteObjectif;
	/**
	 * Identifiant de la carte objectif
	 *
	 * @see CartesObjectifs#objAccompli()
	 */
	private        int iIdentifiant;
	/**
	 * le nombre de points que rapporte l'objectif
	 *
	 * @see CartesObjectifs#getScore()
	 * @see CartesObjectifs#toString()
	 */
	private int    iScore;
	/**
	 * les conditions de validation de la carte objectif
	 *
	 * @see CartesObjectifs#getObjectif()
	 * @see CartesObjectifs#toString()
	 */
	private String sObjectif;
	/**
	 * le joueur possédant l'objectif 
	 *
	 * @see CartesObjectifs#getJoueur()
	 * @see CartesObjectifs#verifierConditionCarte1()
	 * @see CartesObjectifs#verifierConditionCarte2()
	 * @see CartesObjectifs#verifierConditionCarte3()
	 * @see CartesObjectifs#verifierConditionCarte4()
	 * @see CartesObjectifs#verifierConditionCarte5()
	 * @see CartesObjectifs#verifierConditionCarte6()
	 * @see CartesObjectifs#verifierConditionCarte7()
	 * @see CartesObjectifs#verifierConditionCarte8()
	 * @see CartesObjectifs#verifierConditionCarte9()
	 * @see CartesObjectifs#setJoueur(Joueur)
	 */
	private Joueur joueur;
	/**
	 * si l'objectif est accompli ou non
	 *
	 * @see CartesObjectifs#objAccompli()
	 * @see CartesObjectifs#verifierConditionCarte1()
	 * @see CartesObjectifs#verifierConditionCarte2()
	 * @see CartesObjectifs#verifierConditionCarte3()
	 * @see CartesObjectifs#verifierConditionCarte4()
	 * @see CartesObjectifs#verifierConditionCarte5()
	 * @see CartesObjectifs#verifierConditionCarte6()
	 * @see CartesObjectifs#verifierConditionCarte7()
	 * @see CartesObjectifs#verifierConditionCarte8()
	 * @see CartesObjectifs#verifierConditionCarte9()
	 * @see CartesObjectifs#setJoueur(Joueur)
	 */
	private boolean bEstAccompli;
	/**
	 * Constructeur de CartesObjectifs.
	 *
	 * @param iScore
	 *		Nombre de points que donnent les cartes objectifs
	 * @param sObjectif
	 *		Conditon à remplir pour valider l'objectif
	 */
	public CartesObjectifs ( int iScore, String sObjectif )
	{
		this.iIdentifiant = ++CartesObjectifs.nbCarteObjectif;

		this.iScore    = iScore;
		this.sObjectif = sObjectif;
		this.joueur    = null;

		this.bEstAccompli = false;
	}
	/**
	 * Retourne si l'objectif a été complété
	 *
	 * @return
	 *		si l'objectif a été complété
	 */
	public boolean objAccompli()
	{
		boolean bOk;
		if ( !this.bEstAccompli ) 
		{
			switch( this.iIdentifiant )
			{
				case  1 ->{ return this.verifierConditionCarte1(); }
				case  2 ->{ return this.verifierConditionCarte2(); }
				case  3 ->{ return this.verifierConditionCarte3(); }
				case  4 ->{ return this.verifierConditionCarte4(); }
				case  5 ->{ return this.verifierConditionCarte5(); }
				case  6 ->{ return this.verifierConditionCarte6(); }
				case  7 ->{ return this.verifierConditionCarte7(); }
				case  8 ->{ return this.verifierConditionCarte8(); }
				case  9 ->{ return this.verifierConditionCarte9(); }
			}
		}

		return false;
	}
	/**
	 * Retourne le nombre de points que rapporte l'objectif
	 *
	 * @return
	 *		le nombre de points que rapporte l'objectif
	 */
	public int    getScore   (){ return this.iScore;    }
	/**
	 * Retourne les conditions à remplir afin de valider les objectifs
	 *
	 * @return
	 *		les conditions à remplir afin de valider les objectifs
	 */
	public String getObjectif(){ return this.sObjectif; }
	/**
	 * Retourne le joueur possédant l'objectif
	 *
	 * @return
	 *		le joueur possédant l'objectif
	 */
	public Joueur getJoueur  (){ return this.joueur;    }
	/**
	 * Retourne si la carte objectif1 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif1 à déjà été complété
	 */
	private boolean verifierConditionCarte1()
	{
		// Avoir plus de Batiments que d'Ouvriers.
		if( this.joueur.getBatiments().length > this.joueur.getNbOuvrierMax() )
		{
			this.bEstAccompli = true;
			return true;
		}

		return false;
	}
	/**
	 * Retourne si la carte objectif2 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif2 à déjà été complété
	 */
	private boolean verifierConditionCarte2()
	{
		// Avoir au moins 2 fois plus de cubes Nourriture que d'Ouvriers.
		int blePlusPoisson = this.joueur.getQteRessource("BLE") + this.joueur.getQteRessource("POISSON");
		if( blePlusPoisson >= ( this.joueur.getNbOuvrierMax()*2 ) )
		{
			this.bEstAccompli = true;
			return true;
		}
		return false;
	}
	/**
	 * Retourne si la carte objectif3 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif3 à déjà été complété
	 */
	private boolean verifierConditionCarte3()
	{
		// Construire 1 Batiment qui produit et/ou consomme de l'Poisson.
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
	/**
	 * Retourne si la carte objectif4 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif4 à déjà été complété
	 */
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
	/**
	 * Retourne si la carte objectif5 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif5 à déjà été complété
	 */
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
	/**
	 * Retourne si la carte objectif6 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif6 à déjà été complété
	 */
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
	/**
	 * Retourne si la carte objectif7 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif7 à déjà été complété
	 */
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
	/**
	 * Retourne si la carte objectif8 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif8 à déjà été complété
	 */
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
	/**
	 * Retourne si la carte objectif9 à déjà été complété
	 *
	 * @return
	 *		si la carte objectif9 à déjà été complété
	 */
	private boolean verifierConditionCarte9()
	{
		// Construire un Batiment dont le cout est d'au moins 3 bois.
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
	/**
	 * Initialise le joueur possédant la carte objectif
	 *
	 * @param j
	 *		le joueur
	 */
	public void setJoueur( Joueur j ){ this.joueur = j; }
	/**
	 * Retourne sous forme de chaine de caractères si l'objectif a été validé
	 * @return
	 *		sous forme de chaine de caractère si l'objectif à été validé
	 */
	public String toString()
	{
		String sRet = "";
		String sValide = "";

		if ( this.bEstAccompli )sValide = "VALIDER";

		sRet += String.format("|%-100.100s", "Objectif : " + this.sObjectif ) + String.format("%7s|", sValide) + "Score : " + this.iScore + " |";

		return sRet;
	}
}
