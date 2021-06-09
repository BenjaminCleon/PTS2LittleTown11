package equipe_11.metier;

import java.util.ArrayList;

import equipe_11.metier.BatimentInfo;
import equipe_11.metier.Jeu     ;

/** Cette classe permet de modifier et d'obtenir les diverses informations
  * lié aux joueurs
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
	 * C'est une liste des ouvriers du joueur
	 *
	 * @see Joueur#ajouterBatiment()
	 */
	private ArrayList<Pion> lstOuvrier;

	/**
	 * C'est une liste des batiments du joueur
	 * 
	 * @see Joueur#getBatiments()
	 * @see Joueur#ajouterBatiment()
	 */
	private ArrayList<Pion> lstBatiment;

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
	 * C'est les ressource de bois du joueur
	 *
	 * @see getRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rBois;
	/**
	 * C'est les ressource de pierre du joueur
	 *
	 * @see getRessource()
	 * @see ajouterRessource()
	 * @see consommerRessource()
	 */
	private Ressource        rPierre;
	
	public Joueur( String sCouleur, int nbOuvrier, int nbBatiment, int nbObjectif)
	{
		this.NB_OUVRIER   = nbOuvrier;
		this.NB_BATIMENT  = nbBatiment;
		this.NB_OBJECTIF  = nbObjectif;
		this.SCOULEUR     = sCouleur;

		this.iNbPiece     = 3;
		this.iScore       = 0;
	
		this.lstOuvrier   = new ArrayList<Pion> ();
		this.lstBatiment  = new ArrayList<Pion> ();
		
		this.rBle         = new Ressource("ble",true); //est mangeable
		this.rEau         = new Ressource("eau",true); //est mangeable
		this.rBois        = new Ressource("bois"    ); 
		this.rPierre      = new Ressource("pierre"  );
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
			case "BLE"    -> { return this.rBle   .getQteRessource();}
			case "EAU"    -> { return this.rEau   .getQteRessource();}
			case "BOIS"   -> { return this.rBois  .getQteRessource();}
			case "PIERRE" -> { return this.rPierre.getQteRessource();}
		}
		
		return 0;
	}
	/**
	 * Augmente le nombre de piece du joueur dont la somme est
	 * passer en parametre
	 * @param nbPiece
	 *	nombre de piece a ajouter
	 */
	public void ajouterPiece   (int nbPiece ) 
	{ 
		this.iNbPiece+= nbPiece;  
	}
	/**
	 * Augmente le nombre de ressource du joueur dont la somme et
	 * le nom sont passer en parametre
	 * @param iVal
	 *	nombre de ressource a ajouter
	 * @param sType
	 * 	nom de la ressource a incrementer
	 */
	public void gererRessource(int iVal, String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { this.rBle   .setQte( iVal ); }
			case "EAU"    -> { this.rEau   .setQte( iVal ); }
			case "BOIS"   -> { this.rBois  .setQte( iVal ); }
			case "PIERRE" -> { this.rPierre.setQte( iVal ); }
		}
	}

	/**
	 * Diminue le nombre de piece dont la somme est
	 * passer en parametre
	 * @param nbPiece
	 *	nombre de piece a utiliser
	 */
	public boolean consommerPiece (int nbPiece ) 
	{ 
		if(this.iNbPiece - nbPiece >= 0)
		{
			this.iNbPiece -= nbPiece;
			return true;
		}
		return false;
	}
	
	/**
	 * Augmente ou diminue le score en fonction de la quantite
	 * passer en parametre
	 * @param score
	 *	nombre de points a utiliser
	 */
	public void setScore( int score )
	{
		this.iScore -= score;
	}

	/**
	 * Paye un joueur passer en parametre de 1 piece
	 * @param Joueur
	 *	joueurs a payer
	 */
	public void payerJoueur( Joueur joueur )
	{
		if ( this.iNbPiece > 0 )
		{
			joueur.ajouterPiece  (1);
			this  .consommerPiece(1);
		}
	}
	
	/**
	 * Regarde si l'objectif passer en paramètre est compléter
	 * @param oObjectif
	 *	objectif a vérifier
	 */
	public boolean verifierObjectif( CartesObjectifs oObjectif )
	{
		return false;
	}


	/**
	 * Permet d'associer un batiment à un joueur
	 * @param bt
	 *        Batiment à ajouter dans la liste pour le joueur
	 */
	public void ajouterBatiment(Pion pTmp, BatimentInfo bTmp)
	{
		this.lstBatiment.add(pTmp);
		this.lstOuvrier .add(new Pion(pTmp.getLig(), pTmp.getCol(), pTmp.getCoul(), "OUVRIER"));
		
		this.iScore += bTmp.getPtConstru();
	}

	/**
	 * Retourne l'ensemble des batiments
	 * @return
	 *     L'ensemble des batiments du Joueur
	 */
	public Pion[] getBatiments()
	{
		return this.lstBatiment.toArray(new Pion[this.lstBatiment.size()]);
	}

	/**
	 * Retourne le nombre d'ouvrier du joueur
	 * @return
	 *      Le nombre d'ouvrier du joueur
	 */
	public int getNbOuvrier(){ return this.lstOuvrier.size(); }
	
	/**
	 * Permet d'ajouter un ouvrier au joueur
	 */
	public void ajouterOuvrier(Pion pOuv )
	{
		this.lstOuvrier.add(pOuv);
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
				if ( this.consommerPiece(3) )
				{
					nbOuvrierNourri++;
				}
				else
				{
					this.iScore -= 3;
					nbOuvrierNourri++;
				}
			}
			return "Ouvriers Nourri.";
		}

		return "Ouvriers non Nourri.";
	}

	public String nourrirOuvrier ( int nbEau, int nbBle, int nbPiece )
	{
		int nbOuvrierNourri = 0;
		String sRet = "";

		if ( nbEau + nbBle + nbPiece/3 > this.NB_OUVRIER )
			sRet += "trop de ressources proposé\n";
		else
		{
			if ( nbBle > this.rBle.getQteRessource() )
				sRet +=  "le joueur n'a pas assez de ressources de blé\n";
			
			if ( nbEau > this.rEau.getQteRessource() )
				sRet += "le joueur n'a pas assez de ressources d'eau\n";
			
			if ( nbPiece > this.iNbPiece )
				sRet += "le joueur n'a pas assez de pièces\n";

			if ( this.rBle.getQteRessource() == 0 && nbEeau == this.NB_OUVRIER &&
			     this.rEau.consommerRessource( this.NB_OUVRIER ) )
				nbOuvrierNourri = this.NB_OUVRIER;
			
			if ( this.rEau.getQteRessource() == 0 && nbBle == this.NB_OUVRIER &&
			     this.rBle.consommerRessource( NB_OUVRIER ) )
				nbOuvrierNourri = this.NB_OUVRIER;

			if ( nbOuvrierNourri < this.NB_OUVRIER )
			{
				this.rEau.consommerRessource(nbEau);
				this.rBle.consommerRessource(nbBle);
				this.consommerPiece(nbPiece);

				nbOuvrierNourri = nbPiece + nbBle + nbEau;
			}

			while ( nbOuvrierNourri < this.NB_OUVRIER )
			{
				this.iScore -= 3;
				nbOuvrierNourri++;
			}
		}

		return sRet;
	}
}
