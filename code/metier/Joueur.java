package equipe_11.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import equipe_11.BatimentInfo;
import equipe_11.metier.Jeu;

/** Cette classe permet de modifier et d'obtenir les diverses informations
  * liées aux joueurs
  *
  * @author Equipe 11
  */

public class Joueur
{
	/**
	 * C'est la couleur du joueur
	 *
	 * @see Joueur#ajouterBatiment()
	 * @see Joueur#getCouleur()
	 */
	private final String SCOULEUR;
	private final int    NB_OUVRIER;
	private final int    NB_BATIMENT;
	/**
	 * C'est le nombre d'objectif du joueur
	 *
	 */
	private final int NB_OBJECTIF;
	
	private Jeu jeu;
	
	/**
	 *C'est le nom du joueur
	 * @see Joueur#getNomJoueur()
	 */
	private String sNomJoueur;
	
	/**
	 *C'est le numero du joueur
	 * @see Joueur#getNumero()
	 */
	private int sNumJoueur;
	
	/**
	 * C'est une liste des ouvriers du joueur
	 *
	 * @see Joueur#ajouterBatiment()
	 */
	private ArrayList<Pion> alOuvrier;

	/**
	 * C'est une liste des batiments du joueur
	 * 
	 * @see Joueur#getNbBatiment()
	 * @see Joueur#getBatiments()
	 * @see Joueur#ajouterBatiment()
	 */
	private ArrayList<Pion> alBatiment;


	/**
	 * C'est le score du joueur
	 * @see Joueur#getScore
	 */
	private int iScore;

	private Ressource rBle;
	/**
	 * Ce sont les ressource de bois du joueur
	 *
	 * @see getQteRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rPoisson;
	/**
	 * Ce sont les ressources de bois du joueur
	 *
	 * @see getQteRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rBois;
	/**
	 * Ce sont les ressources de pierre du joueur
	 *
	 * @see getQteRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rPierre;

	/**
	 * Ce sont les ressources de pièces du joueur
	 * @see getQteRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rPiece ;

	/**
	 * Liste des batiments que le joueur peux activer après avoir jouer un ouvrier
	 * Ne prend pas en compte les batiments ou l'activation n'engendre aucune perte
	 */
	private ArrayList<BatimentInfo> alBatimentListeTmp;

	/**
	 * Si tous les ouvriers sont nourris
	 */
	private boolean bNourri;

	/**
	 * Constructeur de joueur
	 * @param sCouleur
	 *       Couleur du joueur
	 * @param nbOuvrier
	 *       Nombre d'ouvrier pour le joueur
	 * @param nbBatiment
	 *       Nombre de batiment pour le joueur
	 * @param nbObjectif 
	 *       Nombre de cartes objectifs pour le joueur
	 */
	public Joueur( String sCouleur, int nbOuvrier, int nbBatiment, int nbObjectif)
	{
		this.NB_OUVRIER   = nbOuvrier;
		this.NB_BATIMENT  = nbBatiment;
		this.NB_OBJECTIF  = nbObjectif;
		this.SCOULEUR     = sCouleur;

		this.iScore       = 0;

		this.bNourri = false;
	
		this.alOuvrier   = new ArrayList<Pion> ();
		this.alBatiment  = new ArrayList<Pion> ();

		this.alBatimentListeTmp = new ArrayList<BatimentInfo>();
		
		this.rBle         = new Ressource("ble"     );
		this.rPoisson     = new Ressource("poisson" );
		this.rBois        = new Ressource("bois"    ); 
		this.rPierre      = new Ressource("pierre"  );
		this.rPiece       = new Ressource("piece"   );
		this.rPiece.setQteJoueur(3);
	}

	public void initPiece(){ this.rPiece.setQteJoueur(3); }
	
	public void setNourri( boolean estNourri )
	{
		this.bNourri = estNourri;
	}

	public void setNumJoueur(int iNumJoueur)
	{
		this.sNumJoueur = iNumJoueur;
	}
	
	public void setNomJoueur(String sNomJoueur)
	{
		if ( sNomJoueur == null || sNomJoueur.equals("") )this.sNomJoueur = this.SCOULEUR;
		else                                              this.sNomJoueur = sNomJoueur   ;
	}
	
	/**
	 * retourne la couleur du joueur
	 * @return 
	 *	la couleur du joueur
	 */
	public String getCouleur () { return this.SCOULEUR; }
	
	/**
	 * retourne le nombre de point du joueur
	 * @return 
	 *	le nombre de point du joueur
	 */
    public int    getScore   () { return this.iScore  ; }
	
	/**
	 * retourne le nombre de Batiment possédé par le joueur
	 * @return 
	 * le nombre de batiment possédé par le joueur
	 */
    public int getNbBatiment() { return this.alBatiment.size();}
	
	/**
	 * retourne le nombre de ressource de la ressource en parametre
	 * @param sType
	 *	nom de la ressource
	 * @return 
	 *	le nombre de ressource de la ressource en parametre
	 */
	
	public int getQteRessource(String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { return this.rBle    .getQteRessource(); }
			case "POISSON"-> { return this.rPoisson.getQteRessource(); }
			case "BOIS"   -> { return this.rBois   .getQteRessource(); }
			case "PIERRE" -> { return this.rPierre .getQteRessource(); }
			case "PIECE"  -> { return this.rPiece  .getQteRessource(); }
		}
		
		return 0;
	}

	/**
	 * retourne la ressource en parametre
	 * @param sType
	 *	nom de la ressource
	 * @return 
	 *	la ressource en parametre
	 */
	
	public Ressource getRessource(String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { return this.rBle;    }
			case "POISSON"-> { return this.rPoisson;}
			case "BOIS"   -> { return this.rBois;   }
			case "PIERRE" -> { return this.rPierre; }
			case "PIECE"  -> { return this.rPiece ; }
		}
		
		return null;
	}
	
	/**
	 * Augmente le nombre de ressource du joueur dont la somme et
	 * le nom sont passés en parametre
	 * @param iVal
	 *	nombre de ressource a ajouter
	 * @param sType
	 * 	nom de la ressource a incrementer
	 */
	public boolean gererRessource(int iVal, String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { return this.rBle    .setQteJoueur( iVal ); }
			case "POISSON"-> { return this.rPoisson.setQteJoueur( iVal ); }
			case "BOIS"   -> { return this.rBois   .setQteJoueur( iVal ); }
			case "PIERRE" -> { return this.rPierre .setQteJoueur( iVal ); }
			case "PIECE"  -> { return this.rPiece  .setQteJoueur( iVal ); }
			default       -> { return false; }
		}
	}

	/**
	 * Augmente ou diminue le score en fonction de la quantite
	 * passée en parametre
	 * @param score
	 *	nombre de points a utiliser
	 */
	public void setScore( int score )
	{
		this.iScore += score;
	}

	/**
	 * Paye un joueur passé en parametre de 1 piece
	 * @param Joueur
	 *	joueurs a payer
	 */
	public void payerJoueur( Joueur joueur )
	{
		if ( this.getQteRessource("PIECE") > 0 )
		{
			joueur.gererRessource(1, "PIECE");
			this  .gererRessource(-1, "PIECE");
		}
	}
	
	/**
	 * Regarde si l'objectif passé en paramètre est complété
	 * @param oObjectif
	 *	objectif a vérifier
	 */
	public boolean verifierObjectif( CartesObjectifs oObjectif )
	{
		return false;
	}

	/**
	 * Précise si les ouvriers du joueur sont nourris
	 * @return
	 *     True si tous les ouvriers sont nourris
	 */
	public boolean estNourri(){ return this.bNourri; }


	/**
	 * Permet d'associer un batiment à un joueur
	 * @param bTmp
	 *        Batiment à ajouter dans la liste pour le joueur
	 * @param pTmp
	 *        Pion à ajouter dans la liste des batiments
	 */
	public void ajouterBatiment(Pion pTmp, BatimentInfo bTmp)
	{
		this.alBatiment.add(pTmp);
		this.alOuvrier .add(new Pion(pTmp.getLig(), pTmp.getCol(), pTmp.getCoul(), "OUVRIER"));
		
		this.iScore += bTmp.getPtConstru();
	}

	/**
	 * Retourne l'ensemble des batiments
	 * @return
	 *     L'ensemble des batiments du Joueur
	 */
	public Pion[] getBatiments()
	{
		return this.alBatiment.toArray(new Pion[this.alBatiment.size()]);
	}

	/**
	 * Retourne le nombre d'ouvrier du joueur
	 * @return
	 *      Le nombre d'ouvrier du joueur
	 */
	public int getNbOuvrier(){ return this.alOuvrier.size(); }
	
	/**
	 * Permet d'ajouter un ouvrier au joueur
	 */
	public void ajouterOuvrier(Pion pOuv)
	{
		this.alOuvrier.add(pOuv);
	}

	public boolean nourrirOuvrier()
	{
		int nbOuvrierNourri = 0;

		if( this.rBle.getQteRessource() + this.rPoisson.getQteRessource() + this.rPiece.getQteRessource()/3 <= NB_OUVRIER )
		{
			nbOuvrierNourri = this.rBle.getQteRessource() + this.rPoisson.getQteRessource();
			
			this.rBle.consommerRessource( this.rBle.getQteRessource() );
			this.rPoisson.consommerRessource( this.rPoisson.getQteRessource() );

			while ( nbOuvrierNourri < this.NB_OUVRIER )
			{
				if ( !this.gererRessource(-3, "String") )this.iScore -= 3;
				nbOuvrierNourri++;
			}
			this.bNourri = true;
			return true;
		}

		return false;
	}

	public String nourrirOuvrier ( int iNbPoisson, int iNbBle, int iNbPiece )
	{
		String sRet = "";

		if ( iNbPoisson + iNbBle + iNbPiece/3 > this.NB_OUVRIER )
			sRet = "Vous proposé trop de ressources";

		if ( iNbPoisson + iNbBle + iNbPiece/3 < this.NB_OUVRIER )
			sRet = "Vous ne proposé pas assez de ressources";

		if ( iNbBle > this.rBle.getQteRessource() )
			sRet =  "Vous n'avez pas assez de ressources de blé";
		
		if ( iNbPoisson > this.rPoisson.getQteRessource() )
			sRet = "Vous n'avez pas assez de ressources de poisson";

		if ( iNbPiece > this.rPiece.getQteRessource() )
			sRet = "Vous n'avez pas assez de pièces";
		
		if ( iNbPiece/3 > Ressource.getQteBle() + Ressource.getQtePoisson())
			sRet = "Plus assez de ressource dans l'inventaire pour vos pièces";

		if ( ! sRet.isEmpty() )return sRet;

		this.rPoisson.consommerRessource(iNbPoisson);
		this.rBle.consommerRessource(iNbBle);
		this.gererRessource(-iNbPiece, "PIECE");

		this.bNourri = true;

		return "Ouvrier nourri avec succès";
	}

	public void ajouterBatimentAListeTmp(BatimentInfo bTmp)
	{
		this.alBatimentListeTmp.add(bTmp);
	}

	public void retirerBatimentAListeTmp(BatimentInfo bTmp)
	{
		this.alBatimentListeTmp.remove(bTmp);
	}

	public ArrayList<BatimentInfo> getLstBatimentAutourOuvrier()
	{
		return this.alBatimentListeTmp;
	}

	public void clearLstBatimentAutourOuvrier()
	{
		this.alBatimentListeTmp.clear();
	}

	public void resetJoueur()
	{
		this.bNourri = false;
		this.alOuvrier.clear();
	}

	public int classementJoueurs()
	{
		
		Joueur[] classement = new Joueur[jeu.getJoueurs().length];

		ArrayList<Integer> alInt = new ArrayList<Integer>();

		for ( int cpt = 0; cpt < classement.length; cpt++)
			alInt.add(jeu.getJoueurs()[cpt].getScore());

		Collections.sort(alInt);

		for ( Integer score : alInt)
			if ( this.iScore == score )
				return alInt.indexOf(score);

		return 0;
	}

	public boolean ajouterRessourcePossible( int iQte, String sRessource )
	{
		switch ( sRessource.toUpperCase() )
		{
			case "BLE"    : { return this.rBle    .ajouterRessourcePossible( iQte ); }
			case "POISSON": { return this.rPoisson.ajouterRessourcePossible( iQte ); }
			case "BOIS"   : { return this.rBois   .ajouterRessourcePossible( iQte ); }
			case "PIERRE" : { return this.rPierre .ajouterRessourcePossible( iQte ); }
		}
		return false;
	}

	public boolean consommerRessourcePossible( int iQte, String sRessource )
	{
		switch ( sRessource.toUpperCase() )
		{
			case "BLE"    -> { return this.rBle    .consommerRessourcePossible( iQte ); }
			case "POISSON"-> { return this.rPoisson.consommerRessourcePossible( iQte ); }
			case "BOIS"   -> { return this.rBois   .consommerRessourcePossible( iQte ); }
			case "PIERRE" -> { return this.rPierre .consommerRessourcePossible( iQte ); }
		}
		return false;
	}

	/**
	 * toString par défaut de la classe joueur
	 * @return
	 *      Toutes les données d'un joueur
	 */
	public String toString()
	{
		String sRet = "";
		sRet += "+---------------------------\n";
		sRet += String.format("|%-27s", "Espace " + this.SCOULEUR + "("+
		        String.format("%-13.13s",this.sNomJoueur)+")") + "\n";
		sRet += String.format("|%-27s", "Score  : " + this.iScore                   ) + "\n";
		sRet += String.format("|%-27s", "Piece  : " + this.rPiece  .getQteRessource()                 ) + "\n";
		sRet += String.format("|%-27s", "Bois   : " + this.rBois   .getQteRessource()) + "\n";
		sRet += String.format("|%-27s", "Ble    : " + this.rBle    .getQteRessource()) + "\n";
		sRet += String.format("|%-27s", "Poisson: " + this.rPoisson.getQteRessource()) + "\n";
		sRet += String.format("|%-27s", "Pierre : " + this.rPierre .getQteRessource()) + "\n";
		sRet += "+---------------------------\n";

		return sRet;
	}
}
