package equipe_11.metier;

import java.util.ArrayList;

import equipe_11.metier.Batiment;
import equipe_11.metier.BatimentInfo;
import equipe_11.metier.Ouvrier ;
import equipe_11.metier.Tuile   ;
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
	private final int    NB_OBJECTIF;
	
	private Jeu jeu;
	
	/**
	 * C'est une liste des tuile posséder par le joueur
	 *
	 * @see Joueur#estPresentTuile()
	 */
	private ArrayList<Tuile>           lstTuile;
	/**
	 * C'est une liste des ouvriers du joueur
	 *
	 * @see Joueur#ajouterBatiment()
	 */
	private ArrayList<Pion>            lstOuvrier;
	/**
	 * C'est une liste des batiments du joueur
	 * 
	 * @see Joueur#getBatiments()
	 * @see Joueur#ajouterBatiment()
	 */
	private ArrayList<Pion>            lstBatiment;
	/**
	 * C'est le nombre de pieces du joueur
	 *
	 * @see Joueur#getNbPiece()
	 * @see Joueur#ajouterPiece()
	 *
	 * @see Joueur#payerJoueur()
	 * @see Joueur#consommerPiece()
	 */
	private int                        iNbPiece;
	/**
	 * C'est le score du joueur
	 * @see Joueur#getScore
	 */
	private int                        iScore;
	
	private int iNbOuvrierMax ;
	private int iNbBatimentMax;

	private Ressource        rBle;
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
	
	public Joueur( String sCouleur, int nbOuvrier, int nbBatiment, int nbObjectif, int iNbOuvrierMax, int iNbBatimentMax )
	{
		this.NB_OUVRIER   = nbOuvrier;
		this.NB_BATIMENT  = nbBatiment;
		this.NB_OBJECTIF  = nbObjectif;
		this.SCOULEUR     = sCouleur;

		this.iNbPiece     = 3;
		this.iScore       = 0;
		
		this.iNbOuvrierMax  = iNbOuvrierMax ;
		this.iNbBatimentMax = iNbBatimentMax;
		
		this.lstTuile     = new ArrayList<Tuile>();
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
	public void ajouterRessource(int iVal, String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { this.rBle   .ajouterRessource( iVal ); }
			case "EAU"    -> { this.rEau   .ajouterRessource( iVal ); }
			case "BOIS"   -> { this.rBois  .ajouterRessource( iVal ); }
			case "PIERRE" -> { this.rPierre.ajouterRessource( iVal ); }
		}
		
	}
	/**
	 * Diminue le nombre de ressource du joueur dont la somme et
	 * le nom sont passer en parametre
	 * @param iVal
	 *	nombre de ressource a consommer
	 * @param sType
	 * 	nom de la ressource a décrémenter
	 */
	public void consommerRessource(int iVal, String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { this.rBle   .consommerRessource( iVal ); }
			case "EAU"    -> { this.rEau   .consommerRessource( iVal ); }
			case "BOIS"   -> { this.rBois  .consommerRessource( iVal ); }
			case "PIERRE" -> { this.rPierre.consommerRessource( iVal ); }
		}
	}
	/**
	 * Diminue le nombre de piece dont la somme est
	 * passer en parametre
	 * @param nbPiece
	 *	nombre de piece a utiliser
	 */
	public void consommerPiece (int nbPiece ) 
	{ 
		this.iNbPiece-= nbPiece;
	}
	/**
	 * Augment le score dont la quantite est
	 * passer en parametre
	 * @param score
	 *	nombre de points a utiliser
	 */
	public void augmenterScore (int score)   
	{
		if(score > 0) this.iScore+= score;
	}
	/**
	 * Diminue le score dont la quantite est
	 * passer en parametre
	 * @param score
	 *	nombre de points a utiliser
	 */
	public void diminuerScore (int score) //Un score peut être négatif
	{ 
		if(score > 0) this.iScore-= score; 
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
	 * Regarde si la tuile passer en paramètre est présente
	 * dans les tuile posséder par le joueur
	 * @param tuile
	 *	tuile a verifier
	 */
	public boolean estPresentTuile(Tuile tuile){ return this.lstTuile.contains(tuile); }
	
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
	public void ajouterBatiment(BatimentInfo bt, int iLig, char cCol)
	{
		this.lstBatiment.add(new Batiment(iLig, cCol, this.SCOULEUR, bt.name()));
		this.lstOuvrier .add(new Ouvrier(this.SCOULEUR, iLig, cCol));
		
		this.iScore += bt.getPtConstru();
	}

	/**
	 * Retourne l'ensemble des batiments
	 * @return
	 *     L'ensemble des batiments du Joueur
	 */
	public Batiment[] getBatiments()
	{
		return this.lstBatiment.toArray(new Batiment[this.lstBatiment.size()]);
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
	public void ajouterOuvrier(int iLig, char cCol, Pion pOuv )
	{
		this.lstOuvrier.add(pOuv);
	}

	/**
	 * Nourri les ouvriers et retourne si les ouvriers on été nourrir
	 * ou non et pourquoi
	 * @param nbEau
	 *	quantité d'eau au consommer
	 * @param nbBle
	 *	quantité de blé au consommer
	 * @param nbPiece
	 *	quantité de piece au consommer
	 * @return
	 *      Si les ouvriers on été nourrir ou non et pourquoi
	 */
	public String nourrirOuvriers ( int nbEau, int nbBle, int nbPiece )
	{
		int nbOuvrierNourri = 0;

		//Si le nombre de ressource est juste ou inferieur
		if ( nbEau+nbBle+nbPiece/3 <= this.NB_OUVRIER )
			for ( Pion o : this.lstOuvrier)
			{
				if (nbEau > 0 )
				{
					//o.nourrir(this.rEau);
					nbEau--;
					nbOuvrierNourri++;
				    return "eau consomme";
				}
				else
					if (nbBle > 0)
					{
						//o.nourrir(this.rBle);
						nbBle--;
						nbOuvrierNourri++;
						return "ble consomme";
					}
					else
						if (nbPiece > 2)
						{
							if( this.rEau.getQteEau() > 0 ) //Si reste eau dans la pioche
							{
								nbPiece-=3;
								this.iNbPiece-=3;
								this.ajouterRessource(1, "eau");
								//o.nourrir(rEau);
								nbOuvrierNourri++;
								return "Piece consomme";
							}
							else
							{
								if( this.rBle.getQteBle() > 0) //Si reste ble dans la pioche
								{
									nbPiece-=3;
									this.ajouterRessource(1, "ble");
									//o.nourrir(rBle);
									nbOuvrierNourri++;
									return "Piece consomme";
								}
								else return "ble et eau vide";
							}
						}	
				//Si toute les ressources envoyer ont été consommer
				if ( nbEau+nbBle+nbPiece/3 == 0 )
				{
					while( nbOuvrierNourri<this.lstOuvrier.size() )
					{
						this.diminuerScore(3);
						nbOuvrierNourri++;
					}
				}
			}

		//Si ne passe pas par les autre conditions il n'y a trop de ressources
		return "Trop de ressources";
    }

	public String nourrirOuvrier()
	{
		int nbOuvrierNourri = 0;

		if( this.rBle.getQteBle() + this.rEau.getQteEau() <= iNbOuvrierMax )
		{
			nbOuvrierNourri = this.rBle.getQteBle() + this.rEau.getQteEau();
			
			this.rBle.consommerRessource( this.rBle.getQteBle() );
			this.rEau.consommerRessource( this.rEau.getQteEau() );

			while ( nbOuvrierNourri < this.iNbOuvrierMax )
			{
				if ( this.iNbPiece >= 3 )
				{
					this.nbPiece -= 3;
					nbOuvrierNourri++;
				}
				else
				{
					this.iScore -= 3;
					nbOuvrierNourri++;
				}
			}
		}
		else
		{
			if ( this.rBle.getQteBle() == 0)
			{
				this.rEau.consommerRessource( iNbOuvrierMax );
				nbOuvrierNourri = iNbOuvrierMax;
			}

			if ( this.rBle.getQteEau() == 0)
			{
				this.rBle.consommerRessource( iNbOuvrierMax );
				nbOuvrierNourri = iNbOuvrierMax;
			}
		}

		return "Ouvriers Nourri.";	
	}

	public String nourrirOuvriers ( int nbEau, int nbBle, int nbPiece )
	{
		int nbOuvrierNourri = 0;
		
		if ( nbEau + nbBle + nbPiece/3 > this.iNbOuvrierMax )
			return "trop de ressources proposé";
		else
		{
			if ( nbBle > this.rBle.getQteBle() )
				return "le joueur n'a pas assez de ressources d'eau";
			
			if ( nbEau > this.rEau.getQteEau() )
				return "le joueur n'a pas assez de ressources de blé";
			
			if ( nbPiece > this.iNbPiece )
				return "le joueur n'a pas assez de pièces";
			


			if ( this.rBle.getQteBle() == 0)
			{
				this.rEau.consommerRessource( iNbOuvrierMax );
				nbOuvrierNourri = iNbOuvrierMax;
			}

			if ( this.rBle.getQteEau() == 0)
			{
				this.rBle.consommerRessource( iNbOuvrierMax );
				nbOuvrierNourri = iNbOuvrierMax;
			}
		}
	}
}
