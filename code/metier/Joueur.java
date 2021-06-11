package equipe_11.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import equipe_11.metier.BatimentInfo;
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
	 * C'est le nombre de pieces du joueur
	 *
	 * @see Joueur#getNbPiece()
	 * @see Joueur#ajouterPiece()
	 *
	 * @see Joueur#payerJoueur()
	 * @see Joueur#consommerPiece()
	 */
	private int iNbPiece;

	/**
	 * C'est le score du joueur
	 * @see Joueur#getScore
	 */
	private int iScore;

	private Ressource rBle;
	/**
	 * C'est les ressource de bois du joueur
	 *
	 * @see getRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rEau;
	/**
	 * C'est les ressources de bois du joueur
	 *
	 * @see getRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rBois;
	/**
	 * C'est les ressources de pierre du joueur
	 *
	 * @see getRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rPierre;

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

		this.iNbPiece     = 3;
		this.iScore       = 0;

		this.bNourri = false;
	
		this.alOuvrier   = new ArrayList<Pion> ();
		this.alBatiment  = new ArrayList<Pion> ();

		this.alBatimentListeTmp = new ArrayList<BatimentInfo>();
		
		this.rBle         = new Ressource("ble",true); //est mangeable
		this.rEau         = new Ressource("eau",true); //est mangeable
		this.rBois        = new Ressource("bois"    ); 
		this.rPierre      = new Ressource("pierre"  );
	}
	
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
		this.sNomJoueur = sNomJoueur;
	}

	/**
	 * retourne le nombre de piece du joueur
	 * @return 
	 *	le nombre de piece du joueur
	 */
	public int    getNbPiece () { return this.iNbPiece; }
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
	
	public int getRessource(String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    : { return this.rBle   .getQteRessource(); }
			case "EAU"    : { return this.rEau   .getQteRessource(); }
			case "BOIS"   : { return this.rBois  .getQteRessource(); }
			case "PIERRE" : { return this.rPierre.getQteRessource(); }
		}
		
		return 0;
	}
	
	/**
	 * Augmente le nombre de ressource du joueur dont la somme et
	 * le nom sont passés en parametre
	 * @param iVal
	 *	nombre de ressource a ajouter
	 * @param sType
	 * 	nom de la ressource a incrementer
	 */
	public void gererRessource(int iVal, String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    : { this.rBle   .setQteJoueur( iVal ); break; }
			case "EAU"    : { this.rEau   .setQteJoueur( iVal ); break; }
			case "BOIS"   : { this.rBois  .setQteJoueur( iVal ); break; }
			case "PIERRE" : { this.rPierre.setQteJoueur( iVal ); break; }
		}
	}

	/**
	 * Augmente ou Diminue le nombre de piece en fonction de la quantité
	 * passée en parametre
	 * @param nbPiece
	 *	nombre de piece a utiliser
	 */
	public boolean setPiece( int nbPiece )
	{
		if(this.iNbPiece + nbPiece >= 0)
		{
			this.iNbPiece += nbPiece;
			return true;
		}
		return false;
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
		if ( this.iNbPiece > 0 )
		{
			joueur.setPiece( 1);
			this  .setPiece(-1);
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

	public String nourrirOuvrier()
	{
		int nbOuvrierNourri = 0;

		if( this.rBle.getQteRessource() + this.rEau.getQteRessource() <= NB_OUVRIER )
		{
			nbOuvrierNourri = this.rBle.getQteRessource() + this.rEau.getQteRessource();
			
			this.rBle.consommerRessource( this.rBle.getQteRessource() );
			this.rEau.consommerRessource( this.rEau.getQteRessource() );

			while ( nbOuvrierNourri < this.NB_OUVRIER )
			{
				if ( !this.setPiece(-3) )this.iScore -= 3;
				nbOuvrierNourri++;
			}
			this.bNourri = false;
			return "Ouvriers nourris avec le peu de vos ressources.";
		}

		return "Vous pouvez nourrir vos ouvriers en choisissant vos ressources";
	}

	public String nourrirOuvrier ( int nbEau, int nbBle, int nbPiece )
	{
		// int nbOuvrierNourri = 0;
		String sRet = "";

		if ( nbEau + nbBle + nbPiece/3 > this.NB_OUVRIER )
			sRet += "trop de ressources proposées\n";

		if ( nbEau + nbBle + nbPiece/3 < this.NB_OUVRIER )
			sRet += "pas assez de ressources proposées\n";

		if ( nbBle > this.rBle.getQteRessource() )
			sRet +=  "le joueur n'a pas assez de ressources de blé\n";
		
		if ( nbEau > this.rEau.getQteRessource() )
			sRet += "le joueur n'a pas assez de ressources d'eau\n";

		if ( nbPiece > this.iNbPiece )
			sRet += "le joueur n'a pas assez de pièces\n";

		if ( ! sRet.isEmpty() )return sRet;

		// if ( this.rBle.getQteRessource() == 0 && nbEau == this.NB_OUVRIER &&
		// 		this.rEau.consommerRessource( this.NB_OUVRIER ) )
		// 	nbOuvrierNourri = this.NB_OUVRIER;
		
		// if ( this.rEau.getQteRessource() == 0 && nbBle == this.NB_OUVRIER &&
		// 		this.rBle.consommerRessource( NB_OUVRIER ) )
		// 	nbOuvrierNourri = this.NB_OUVRIER;

		// if ( nbOuvrierNourri < this.NB_OUVRIER)
		// {
			this.rEau.consommerRessource(nbEau);
			this.rBle.consommerRessource(nbBle);
			this.setPiece(-nbPiece);

			//nbOuvrierNourri = nbPiece + nbBle + nbEau;
		//}

		// while ( nbOuvrierNourri < this.NB_OUVRIER)
		// {
		// 	this.iScore -= 3;
		// 	nbOuvrierNourri++;
		// }

		this.bNourri = true;

		return "Ouvriers nourris avec succès";
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

	/**
	 * toString par défaut de la classe joueur
	 * @return
	 *      Toutes les données d'un joueur
	 */
	public String toString()
	{
		String sRet = "";

		sRet += String.format("|%-28s", "Espace joueur " + this.SCOULEUR    ) + "\n";
		sRet += String.format("|%-28s", "Score : " + this.iScore                ) + "\n";
		sRet += String.format("|%-28s", "Piece : " + this.iNbPiece              ) + "\n";
		sRet += String.format("|%-28s", "Bois  : " + this.getRessource("BOIS"  )) + "\n";
		sRet += String.format("|%-28s", "Ble   : " + this.getRessource("BLE"   )) + "\n";
		sRet += String.format("|%-28s", "Eau   : " + this.getRessource("EAU"   )) + "\n";
		sRet += String.format("|%-28s", "Pierre: " + this.getRessource("PIERRE")) + "\n";

		return sRet;
	}
}
