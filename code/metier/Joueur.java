package littletown.metier;

import java.util.ArrayList;

public class Joueur
{
	private final String SCOULEUR;
	private final int    INB_OUVRIER;
	private final int    INB_BATIMENT;
	private final int    INB_OBJECTIF;
	
	private ArrayList<Tuile> lstTuile;
	private int              iNbPiece;
	private Pion[]           tabOuvrier;
	private Pion[]           tabBatiment;
	private Objectif[]       tabOjectif;
	private int              iScore;
	
	private Ressource        rBle;
	private Ressource        rEau;
	private Ressource        rBois;
	private Ressource        rPierre;
	
	public Joueur(String sCouleur, int nbOuvrier, int nbBatiment, int nbObjectif)
	{
		this.INB_OUVRIER  = nbOuvrier;
		this.INB_BATIMENT = nbBatiment;
		this.NB_OBJECTIF  = nbObjectif;
		this.SCOULEUR     = sCouleur;
		
		this.iNbPiece     = 3;
		
		this.lstTuile     = new ArrayList<Tuile>();
		this.tabOuvrier   = new Pion[NB_OUVRIER ];
		this.tabBatiment  = new Pion[NB_BATIMENT];
		this.tabOjectif   = new Objectif[NB_OBJECTIF];
		
		this.rBle         = new Ressource("ble",true); //est mangeable
		this.rEau         = new Ressource("eau",true); //est mangeable
		this.rBois        = new Ressource("bois"    ); 
		this.rPierre      = new Ressource("pierre"  );
		
		for(int cpt; cpt<NB_OUVRIER; cpt++)
		{
			tabOuvrier [cpt] = new Pion("Ouvrier", SCOULEUR, null);
			tabBatiment[cpt] = new Pion("Batiment",SCOULEUR, null);
		}
	}
	
	public int getNbPiece (){ return this.iNbPiece; }
	
	public int getRessource(String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { return this.rBle   .getQteRessource();}
			case "EAU"    -> { return this.rEau   .getQteRessource();}
			case "BOIS"   -> { return this.rBois  .getQteRessource();}
			case "PIERRE" -> { return this.rPierre.getQteRessource();}
			default       -> { return null; }
		}
		
	}
	
	public void ajouterPiece   (int nbPiece ) 
	{ 
		this.iNbPiece+= nbPiece;  
		
		//Verifie si un objectif a été complété
		for( Objectif objectif : this.tabOjectif )
			objectif.estAccompli();
	}
	
	public void ajouterRessource(int iVal, String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { this.rBle   .ajouterRessource( iVal ); }
			case "EAU"    -> { this.rEau   .ajouterRessource( iVal ); }
			case "BOIS"   -> { this.rBois  .ajouterRessource( iVal ); }
			case "PIERRE" -> { this.rPierre.ajouterRessource( iVal ); }
			default       -> { return null; }
		}
		
		//Verifie si un objectif a été complété
		for( Objectif objectif : this.tabOjectif )
			objectif.estAccompli();
		
	}
	
	public void ajouterTuile( Tuile tuile )
	{
		if ( !tuile.estPosseder() )
		{
			this.lstTuile.add(new Tuile (/*a completer*/));
			this.augmenterScore(tuile.getScore());
		}
		
		//Verifie si un objectif a été complété
		for( Objectif objectif : this.tabOjectif )
			objectif.estAccompli();
	}
	
	public void consommerRessource(int iVal, String sType)
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { this.rBle   .consommerRessource( iVal ); }
			case "EAU"    -> { this.rEau   .consommerRessource( iVal ); }
			case "BOIS"   -> { this.rBois  .consommerRessource( iVal ); }
			case "PIERRE" -> { this.rPierre.consommerRessource( iVal ); }
			default       -> { return null; }
		}
		
		//Verifie si un objectif a été complété
		for( Objectif objectif : this.tabOjectif )
			objectif.estAccompli();
	}
	public void consommerPiece (int nbPiece ) 
	{ 
		this.iNbPiece-= nbPiece; 
		
		//Verifie si un objectif a été complété
		for( Objectif objectif : this.tabOjectif )
			objectif.estAccompli();
	}
	
	public void augmenterScore (int score)   
	{
		if(score > 0)
			this.iScore+= score;
		
		//Verifie si un objectif a été complété
		for( Objectif objectif : this.tabOjectif )
			objectif.estAccompli();
	}
	public void diminuerScore (int score) //Un score peut être négatif
	{ 
		if(score > 0)
			this.iScore-= score; 
		
		//Verifie si un objectif a été complété
		for( Objectif objectif : this.tabOjectif )
			objectif.estAccompli();
	}
	
	public void payerJoueur( Joueur joueur )
	{
		if ( this.iNbPiece > 0 )
		{
			joueur.ajouterPiece  (1);
			this  .consommerPiece(1);
		}
		
		//Verifie si un objectif a été complété
		for( Objectif objectif : this.tabOjectif )
			objectif.estAccompli();
	}
	
	public boolean estPresentTuile(Tuile tuile){ this.lstTuile.contains(tuile); }
	
}
