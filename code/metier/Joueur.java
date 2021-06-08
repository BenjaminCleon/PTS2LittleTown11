package littletown.metier;

import java.util.ArrayList;
import littletown.metier.Pion;
import littletown.metier.CartesObjectifs;
import littletown.metier.Tuile;
import littletown.metier.Jeu;

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
	private ArrayList<CartesObjectifs> lstObjectif;
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
		
		this.lstTuile     = new ArrayList<Tuile>();
		this.lstOuvrier   = new ArrayList<Pion> ();
		this.lstBatiment  = new ArrayList<Pion> ();
		this.lstObjectif  = new ArrayList<CartesObjectifs> ();
		
		this.rBle         = new Ressource("ble",true); //est mangeable
		this.rEau         = new Ressource("eau",true); //est mangeable
		this.rBois        = new Ressource("bois"    ); 
		this.rPierre      = new Ressource("pierre"  );
		
		for(int cpt = 0; cpt<NB_OUVRIER; cpt++)
		{
			this.lstOuvrier .add(new Pion("Ouvrier" ,this.SCOULEUR, null));
			this.lstBatiment.add(new Pion("Batiment",this.SCOULEUR, null));
		}
	}
	
	public int getNbPiece (){ return this.iNbPiece; }
	
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
		
		//Verifie si un objectif a été complété
		for( CartesObjectifs objectif : this.lstObjectif )
			;
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
		
		//Verifie si un objectif a été complété
		for( CartesObjectifs objectif : this.lstObjectif )
			;
		
	}
	
	/*public void ajouterTuile( Tuile tuile )
	{
		if ( !tuile.estPosseder() )
		{
			this.lstTuile.add(new Tuile (tuile));
			this.augmenterScore(tuile.getScore());
		}
		
		//Verifie si un objectif a été complété
		for( CartesObjectifs objectif : this.tabOjectif )
			objectif.estAccompli();
	}*/
	
	public void consommerRessource(int iVal, String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { this.rBle   .consommerRessource( iVal ); }
			case "EAU"    -> { this.rEau   .consommerRessource( iVal ); }
			case "BOIS"   -> { this.rBois  .consommerRessource( iVal ); }
			case "PIERRE" -> { this.rPierre.consommerRessource( iVal ); }
		}
		
		//Verifie si un objectif a été complété
		for( CartesObjectifs objectif : this.lstObjectif )
			;
	}
	public void consommerPiece (int nbPiece ) 
	{ 
		this.iNbPiece-= nbPiece;
		
		//Verifie si un objectif a été complété
		for( CartesObjectifs objectif : this.lstObjectif )
			;
	}
	
	public void augmenterScore (int score)   
	{
		if(score > 0)
			this.iScore+= score;
		
		//Verifie si un objectif a été complété
		for( CartesObjectifs objectif : this.lstObjectif )
			;
	}
	public void diminuerScore (int score) //Un score peut être négatif
	{ 
		if(score > 0)
			this.iScore-= score; 
		
		//Verifie si un objectif a été complété
		for( CartesObjectifs objectif : this.lstObjectif )
			;
	}
	
	public void payerJoueur( Joueur joueur )
	{
		if ( this.iNbPiece > 0 )
		{
			joueur.ajouterPiece  (1);
			this  .consommerPiece(1);
		}
		
		//Verifie si un objectif a été complété
		for( CartesObjectifs objectif : this.lstObjectif )
			;
	}
	
	public boolean estPresentTuile(Tuile tuile){ return this.lstTuile.contains(tuile); }
	
	public boolean verifierObjectif( CartesObjectifs oObjectif )
	{
		return false;
	}


	public boolean construireBatiment( int iX, int iY, String sType )
	{
		return false;
	}

}
