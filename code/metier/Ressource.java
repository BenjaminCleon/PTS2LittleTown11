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
	 * C'est la quantite de Ble disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#getQteBle()
	 * @see Ressource#toString()
	 */
	private static AltInt iQteBleStock    = new AltInt( 15 );

	/**
	 * C'est la quantite de Bois disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#getQteBois()
	 * @see Ressource#toString()
	 */
	private static AltInt iQteBoisStock   = new AltInt( 15 );

	/**
	 * C'est la quantite d'Eau disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#getQteEau()
	 * @see Ressource#toString()
	 */
	private static AltInt iQteEauStock    = new AltInt( 15 );
	
	/**
	 * C'est la quantite de Pierre disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#getQtePierre()
	 * @see Ressource#toString()
	 */
	private static AltInt iQtePierreStock = new AltInt( 15 );	

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
	 * C'est la quantiter de ressource.
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
	
	/**
	 * Esque cette ressource peut etre utiliser pour nourire les ouvriers.
	 *
	 * @see Ressource#getEstMangeable()
	 */
	private boolean bEstMangeable;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	/**
	 * Constructeur de Ressources.
	 *
	 * @param sType
	 *          Nom de la nouvelle Ressource.
	 * @param bEstMangeable
	 *          Definie si cette ressource peut etre utiliser pour nourire les ouvriers.
	 */
	public Ressource( String sType, boolean bEstMangeable )
	{
		this.sType         = sType.toUpperCase();
		this.bEstMangeable = bEstMangeable;
		this.iQte          = 0;
	}

	/**
	 * Constructeur par recopie de Ressources
	 * bEstMangeable est defini sur false par default
	 *
	 * @param sType
	 *          Nom de la nouvelle Ressource.
	 */
	public Ressource( String sType )
	{
		this( sType, false );
	}

	/**
	 * Retourne la bonne Ressource pour chaque nom.
	 *
	 * @param sType
	 *          Nom de la ressource à rechercher.
	 * 
	 * @see Ressource#consommerRessource
	 * @see Ressource#ajouterRessource
	 */
	private AltInt getRessourceByType( String sType )
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { return Ressource.iQteBleStock;    }
			case "BOIS"   -> { return Ressource.iQteBoisStock;   }
			case "EAU"    -> { return Ressource.iQteEauStock;    }
			case "PIERRE" -> { return Ressource.iQtePierreStock; }
			default -> { return null; }		
		}
	}

	/**
	 * Consomme une quantiter d'une ressource en stock passer en parametre.
	 *
	 * @param iConso
	 *          nombre de ressource à consommer
	 */
	public boolean consommerRessourceStock( int iConso )
	{
		AltInt tmp = this.getRessourceByType( this.sType );

		if ( iConso < 1 || iConso > tmp.getEntier() )return false;

		tmp.setEntier( tmp.getEntier() - iConso );
		return true;	
	}
	
	/**
	 * Consomme une quantiter d'une ressource passer en parametre.
	 *
	 * @param iConso
	 *          nombre de ressource à consommer
	 */
	public boolean consommerRessource( int iConso )
	{
		if( iConso < 1 || iConso > getQteRessource() )
			return false;
		
		this.iQte -= iConso;
		return true;
	}

	/**
	 * Ajoute une quantiter à une ressource en stock passer en parametre.
	 *
	 * @param iConso
	 *          nombre de ressource à ajoute
	 */
	public boolean ajouterRessourceStock( int iConso )
	{
		AltInt iTmp = this.getRessourceByType( this.sType );

		if ( iConso < 1 || iTmp.getEntier() + iConso > 15 )return false;

		iTmp.setEntier( iTmp.getEntier() + iConso );
		return true;	
	}
	
	/**
	 * Ajoute une quantiter à une ressource passer en parametre.
	 *
	 * @param iConso
	 *          nombre de ressource à ajoute
	 */
	public boolean ajouterRessource( int iConso )
	{
		if( iConso < 1 )
			return false;
		
		this.iQte += iConso;
		return true;
	}

	/**
	 * Retourne le nom de la ressource.
	 */
	public String  getType()        { return this.sType;         }
	
	/**
	 * Retourne si la ressource peut etre utiliser pour nourire les ouvriers.
	 */
	public boolean getEstMangeable(){ return this.bEstMangeable; }
	
	/**
	 * Retourne le nombre de ble dans le stock.
	 *
	 * @see Ressource#toString()
	 */
	public static int getQteBle(){ return Ressource.iQteBleStock.getEntier(); }
	
	/**
	 * Retourne le nombre de bois dans le stock.
	 *
	 * @see  Ressource#toString()
	 */
	public static int getQteBois(){ return Ressource.iQteBoisStock.getEntier(); }
	
	/**
	 * Retourne le nombre d'Eau dans le stock.
	 *
	 * @see  Ressource#toString()
	 */
	public static int getQteEau(){ return Ressource.iQteEauStock.getEntier(); }
	
	/**
	 * Retourne le nombre de Pierre dans le stock.
	 *
	 * @see  Ressource#toString()
	 */
	public static int getQtePierre(){ return Ressource.iQtePierreStock.getEntier(); }
	
	/**
	 * Retourne le nombre de ressource disponible dans le stock pour cette ressource.
	 */
	public int getQteRessource(){ return this.iQte; }

	/**
	 * Permet d'ajouter iNb ressource
	 * @param
	 *     Le nombre de ressource que l'on rajoute pour cette ressource
	 */
	public boolean setQteJoueur(int iNb )
	{
		AltInt aTmp = this.getRessourceByType(this.sType);
		if ( aTmp.getEntier() + iNb < 0 || aTmp.getEntier() - iNb > 15 )return false;

		this.iQte += iNb;
		aTmp.setEntier(aTmp.getEntier()-iNb);
	
		return true;
	}

	/**
	 * Retourne en String le nom de la ressource et le quantiter restant dans le stock.
	 */
	public String toString()
	{
		String sRet = "";

		switch( sType )
		{
			case "BLE"    ->  sRet += String.format( "%-6s", "Ble"   ) + " : " + String.format( "%2d", Ressource.iQteBleStock   .getEntier() );
			case "BOIS"   ->  sRet += String.format( "%-6s", "Bois"  ) + " : " + String.format( "%2d", Ressource.iQteBoisStock  .getEntier() );
			case "EAU"    ->  sRet += String.format( "%-6s", "Eau"   ) + " : " + String.format( "%2d", Ressource.iQteEauStock   .getEntier() );
			case "PIERRE" ->  sRet += String.format( "%-6s", "Pierre") + " : " + String.format( "%2d", Ressource.iQtePierreStock.getEntier() );
		}		

		return sRet;
	}
}

