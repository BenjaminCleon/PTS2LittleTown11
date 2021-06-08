package equipe_11.metier;

import java.util.ArrayList;

import equipe_11.metier.Batiment;
import equipe_11.metier.BatimentInfo;
import equipe_11.metier.Ouvrier ;
import equipe_11.metier.Tuile   ;
import equipe_11.metier.Jeu     ;

public class Joueur
{
	private final String SCOULEUR;
	private final int    NB_OUVRIER;
	private final int    NB_BATIMENT;
	private final int    NB_OBJECTIF;
	
	private Jeu jeu;

	private ArrayList<Tuile>           lstTuile;
	private ArrayList<Pion>            lstOuvrier;
	private ArrayList<Pion>            lstBatiment;
	private int                        iNbPiece;
	private int                        iScore;
	
	private Ressource        rBle;
	private Ressource        rEau;
	private Ressource        rBois;
	private Ressource        rPierre;
	
	public Joueur( String sCouleur, int nbOuvrier, int nbBatiment, int nbObjectif )
	{
		this.NB_OUVRIER   = nbOuvrier;
		this.NB_BATIMENT  = nbBatiment;
		this.NB_OBJECTIF  = nbObjectif;
		this.SCOULEUR      = sCouleur;
		this.iNbPiece     = 3;
		
		this.lstTuile     = new ArrayList<Tuile>           ();
		this.lstOuvrier   = new ArrayList<Pion>         ();
		this.lstBatiment  = new ArrayList<Pion>        ();
		
		this.rBle         = new Ressource("ble",true); //est mangeable
		this.rEau         = new Ressource("eau",true); //est mangeable
		this.rBois        = new Ressource("bois"    ); 
		this.rPierre      = new Ressource("pierre"  );
	}
	
	public int    getNbPiece () { return this.iNbPiece; }
	public String getCouleur () { return this.SCOULEUR; }
    public int    getScore   () { return this.iScore+1; } // Commence à 1
	
	public Integer getRessource(String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { return this.rBle   .getQteRessource();}
			case "EAU"    -> { return this.rEau   .getQteRessource();}
			case "BOIS"   -> { return this.rBois  .getQteRessource();}
			case "PIERRE" -> { return this.rPierre.getQteRessource();}
		}
		
		return null;
	}
	
	public void ajouterPiece   (int nbPiece ) 
	{ 
		this.iNbPiece+= nbPiece;  
	}
	
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

	public void consommerPiece (int nbPiece ) 
	{ 
		this.iNbPiece-= nbPiece;
	}
	
	public void augmenterScore (int score)   
	{
		if(score > 0) this.iScore+= score;
	}
	public void diminuerScore (int score) //Un score peut être négatif
	{ 
		if(score > 0) this.iScore-= score; 
	}
	
	public void payerJoueur( Joueur joueur )
	{
		if ( this.iNbPiece > 0 )
		{
			joueur.ajouterPiece  (1);
			this  .consommerPiece(1);
		}
	}
	
	public boolean estPresentTuile(Tuile tuile){ return this.lstTuile.contains(tuile); }
	
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
	
	public String nourrirOuvriers ( int nbEau, int nbBle, int nbPiece )
	{
	int cptOuvrierNourri = 0;

		//Si le nombre de ressource est juste ou inferieur
		if ( nbEau+nbBle+nbPiece/3 <= this.NB_OUVRIER )
			for ( Pion o : this.lstOuvrier)
			{
				if (nbEau > 0 )
				{
					//o.nourrir(this.rEau);
					nbEau--;
					cptOuvrierNourri++;
				    return "eau consomme";
				}
				else
					if (nbBle > 0)
					{
						//o.nourrir(this.rBle);
						nbBle--;
						cptOuvrierNourri++;
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
								cptOuvrierNourri++;
								return "Piece consomme";
							}
							else
							{
								if( this.rBle.getQteBle() > 0) //Si reste ble dans la pioche
								{
									nbPiece-=3;
									this.ajouterRessource(1, "ble");
									//o.nourrir(rBle);
									cptOuvrierNourri++;
									return "Piece consomme";
								}
								else return "ble et eau vide";
							}
						}	
				//Si toute les ressources envoyer ont été consommer
				if ( nbEau+nbBle+nbPiece/3 == 0 )
				{
					while( cptOuvrierNourri<this.lstOuvrier.size() )
					{
						this.diminuerScore(3);
						cptOuvrierNourri++;
					}
				}
			}

		//Si ne passe pas par les autre conditions il n'y a trop de ressources
		return "Trop de ressources";
    }
}
