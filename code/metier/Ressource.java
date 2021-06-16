package equipe_11.metier;

import equipe_11.metier.utilitaire.AltInt;

/** Cette classe permet de donner les informations générales sur les différentes
  * Resource disponible.
  *
  * @author Equipe 11
  */
public class Ressource
{
	/*-----------*/
	/* Attributs */
	/*-----------*/

	/**
	 * Nombre de pieces maximales dans l'inventaire
	 */
	private static final int INB_PIECE_MAX     = 40;

	/**
	 * Nombre de ressources maximales dans l'inventaire par ressource
	 */
	private static final int INB_RESSOURCE_MAX = 15;

	/**
	 * C'est la quantité de Pieces disponible dans le stock
	 * 
	 * @see Ressource#getRessourceByType( String)
	 * @see Ressource#getQteBle()
	 * @see Ressource#toString ()
	 */
	private static AltInt iQtePieceStock = new AltInt( Ressource.INB_PIECE_MAX );

	/**
	 * C'est la quantité de Blés disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#getQteBle()
	 * @see Ressource#toString()
	 */
	private static AltInt iQteBleStock    = new AltInt( Ressource.INB_RESSOURCE_MAX );

	/**
	 * C'est la quantité de Bois disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#getQteBois()
	 * @see Ressource#toString()
	 */
	private static AltInt iQteBoisStock   = new AltInt( Ressource.INB_RESSOURCE_MAX );

	/**
	 * C'est la quantité de poissons disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#getQtePoisson()
	 * @see Ressource#toString()
	 */
	private static AltInt iQtePoissonStock    = new AltInt( Ressource.INB_RESSOURCE_MAX );
	
	/**
	 * C'est la quantité de Pierres disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#getQtePierre()
	 * @see Ressource#toString()
	 */
	private static AltInt iQtePierreStock = new AltInt( Ressource.INB_RESSOURCE_MAX );	

	/**
	 * C'est le nom de la ressource.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 * @see Ressource#Ressource( String, boolean bEstMangeable )
	 * @see Ressource#Ressource( String )
	 * @see Ressource#consommerRessource( int, String  )
	 * @see Ressource#ajouterRessource( int, String )
	 * @see Ressource#getType()
	 * @see Ressource#setQte(int iNb )
	 * @see Ressource#toString()
	 */
	private String  sType;

	/**
	 * C'est la quantité de ressource.
	 *
	 * @see Ressource#Ressource( String, boolean bEstMangeable )
	 * @see Ressource#Ressource( String )
	 * @see Ressource#consommerRessourceStock( int, String  )
	 * @see Ressource#consommerRessource( int, String  )
	 * @see Ressource#ajouterRessourceStock( int, String )
	 * @see Ressource#ajouterRessource( int, String )
	 * @see Ressource#setQte(int iNb )
	 */
	private int iQte;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	/**
	 * Constructeur de Ressource.
	 *
	 * @param sType
	 *          Nom de la nouvelle Ressource.
	 */
	public Ressource( String sType )
	{
		this.sType         = sType.toUpperCase();
		this.iQte          = 0;
	}

	/**
	 * Retourne la bonne Ressource pour chaque nom.
	 *
	 * @param sType
	 *          Nom de la ressource à rechercher.
	 * @return
	 *		le quantité de la ressource dans le stock
	 * 
	 * @see Ressource#consommerRessource
	 * @see Ressource#ajouterRessource
	 */
	private static AltInt getRessourceByType( String sType )
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { return Ressource.iQteBleStock    ; }
			case "BOIS"   -> { return Ressource.iQteBoisStock   ; }
			case "POISSON"-> { return Ressource.iQtePoissonStock; }
			case "PIERRE" -> { return Ressource.iQtePierreStock ; }
			default       -> { return Ressource.iQtePieceStock  ; }		
		}
	}

	/**
	 * Consomme une quantité d'une ressource en stock passé en paramètre.
	 *
	 * @param iConso
	 *          nombre de ressources à consommer
	 * @return
	 *		true si la ressource a été consommé
	 */
	public static boolean consommerRessourceStock( int iConso, String sType )
	{
		AltInt tmp = Ressource.getRessourceByType( sType );

		if ( iConso < 1 || iConso > tmp.getEntier() )return false;

		tmp.setEntier( tmp.getEntier() - iConso );
		return true;	
	}

	/**
	 * Ajoute une quantité à une ressource en stock passé en paramètre.
	 *
	 * @param iConso
	 *          nombre de ressource à ajoute
	 * @return
	 *		true si la ressource a été augmenté
	 */
	public static boolean ajouterRessourceStock( int iConso, String sType )
	{
		AltInt iTmp = Ressource.getRessourceByType( sType );

		if ( iConso < 1 || iTmp.getEntier() + iConso > 15 )return false;

		iTmp.setEntier( iTmp.getEntier() + iConso );
		return true;	
	}

	/**
	 * Consomme à la ressource une quantité passé en paramètre.
	 *
	 * @param iConso
	 *		nombre de ressources à consommer
	 */
	public boolean consommerRessource( int iConso )
	{
		if( iConso < 1 || iConso > this.getQteRessource() )
			return false;
		
		this.iQte -= iConso;
		Ressource.ajouterRessourceStock(iConso, this.sType);
		return true;
	}

	/**
	 * Ajoute à une ressource une quantité passé en paramètre.
	 *
	 * @param iConso
	 *		nombre de ressources à ajouter
	 * @return
	 *		true si la ressource a été ajouté
	 */
	public boolean ajouterRessource( int iConso )
	{
		if( iConso < 1 )
			return false;
		
		this.iQte += iConso;
		Ressource.consommerRessourceStock(iConso, this.sType);
		
		return true;
	}
	/**
	 * Ajoute à une ressource du stock une quantité en paramètre
	 *
	 * @return
	 *		true si une quantité à été ajouté
	 */
	public boolean ajouterRessourcePossible( int iQte )
	{
		return ( Ressource.getRessourceByType(this.sType).getEntier() - iQte ) >= 0;
	}
	/**
	 * Supprime à une ressource du stock une quantité en paramètre
	 *
	 * @return
	 *		true si une quantité à été supprimé
	 */
	public boolean consommerRessourcePossible( int iQte )
	{
		return ( this.iQte - iQte ) >= 0;
	}

	/**
	 * Retourne le nom de la ressource.
	 *
	 * @return 
	 *		le nom de la ressource
	 */
	public String  getType()        { return this.sType;         }
	
	/**
	 * Retourne le nombre de blés dans le stock.
	 *
	 * @return
	 *		le nombre de blés dans le stock
	 * @see Ressource#toString()
	 */
	public static int getQteBle(){ return Ressource.iQteBleStock.getEntier(); }
	
	/**
	 * Retourne le nombre de bois dans le stock.
	 *
	 * @return
	 *		le nombre de bois dans le stock
	 * @see  Ressource#toString()
	 */
	public static int getQteBois(){ return Ressource.iQteBoisStock.getEntier(); }
	
	/**
	 * Retourne le nombre de poissons dans le stock.
	 *
	 * @return
	 *		le nombre de poissons dans le stock
	 * @see  Ressource#toString()
	 */
	public static int getQtePoisson(){ return Ressource.iQtePoissonStock.getEntier(); }
	
	/**
	 * Retourne le nombre de pierres dans le stock.
	 *
	 * @return
	 *		le nombre de pierres dans le stock
	 * @see  Ressource#toString()
	 */
	public static int getQtePierre(){ return Ressource.iQtePierreStock.getEntier(); }
	/**
	 * Retourne le nombre de pièces dans le stock.
	 *
	 * @return
	 *		le nombre de pièces dans le stock
	 */
	public static int getQtePiece (){ return Ressource.iQtePieceStock .getEntier(); }

	/**
	 * Retourne le nombre de ressources disponible du joueur pour cette ressource.
	 *
	 * @return
	 *		le nombre de ressources appartenant au joueur
	 */
	public int getQteRessource(){ return this.iQte; }

	/**
	 * Permet d'ajouter iNb ressource
	 * @param
	 *     Le nombre de ressources que l'on rajoute pour cette ressource
	 *
	 * @return
	 *		true si des ressources ont été ajouté
	 */
	public boolean setQteJoueur(int iNb)
	{
		AltInt aTmp = Ressource.getRessourceByType(this.sType);
		int iLimite;
		if ( this.sType.equals("PIECE") )iLimite = Ressource.INB_PIECE_MAX;
		else                             iLimite = Ressource.INB_RESSOURCE_MAX;

		if ( iNb > 0 &&  aTmp.getEntier() - iNb < 0       ||
		     iNb < 0 && (aTmp.getEntier() - iNb > iLimite || this.iQte + iNb < 0 ))return false;

		this.iQte += iNb;
		aTmp.setEntier(aTmp.getEntier()-iNb);
	
		return true;
	}

	/**
	 * Retourne en String le nom de la ressource et la quantité restant dans le stock.
	 *
	 * @return
	 *		le nom de la ressource et la quantité restant dans le stock
	 */
	public String toString()
	{
		String sRet = "";

		switch( sType )
		{
			case "BLE"    -> sRet += String.format( "%-6s", "Ble"    ) + " : " + String.format( "%2d", Ressource.iQteBleStock    .getEntier() );
			case "BOIS"   -> sRet += String.format( "%-6s", "Bois"   ) + " : " + String.format( "%2d", Ressource.iQteBoisStock   .getEntier() );
			case "POISSON"-> sRet += String.format( "%-6s", "Poisson") + " : " + String.format( "%2d", Ressource.iQtePoissonStock.getEntier() );
			case "PIERRE" -> sRet += String.format( "%-6s", "Pierre" ) + " : " + String.format( "%2d", Ressource.iQtePierreStock .getEntier() );
			case "PIECE"  -> sRet += String.format( "%-6s", "Piece"  ) + " : " + String.format( "%2d", Ressource.iQtePieceStock  .getEntier() );
		}

		return sRet;
	}
}

