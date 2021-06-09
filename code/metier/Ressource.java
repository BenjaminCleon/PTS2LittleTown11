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
	 * @see Ressource#toString()
	 */
	private static AltInt iQteBle    = new AltInt( 15 );
	
	/**
	 * C'est la quantite de Bois disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 */
	private static AltInt iQteBois   = new AltInt( 15 );
	
	/**
	 * C'est la quantite d'Eau disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 */
	private static AltInt iQteEau    = new AltInt( 15 );
	
	/**
	 * C'est la quantite de Pierre disponible dans le stock.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 */
	private static AltInt iQtePierre = new AltInt( 15 );	

	/**
	 * C'est le nom de la ressource.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 * @see Ressource#Ressource( String, boolean bEstMangeable )
	 * @see Ressource#Ressource( String )
	 * @see Ressource#getRessourceByType( String  )
	 * @see Ressource#consommerRessource( int, String  )
	 * @see Ressource#ajouterRessource( int, String )
	 * @see Ressource#getType()
	 * @see Ressource#toString()
	 */
	private String  sType;

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
			case "BLE"    -> { return Ressource.iQteBle;    }
			case "BOIS"   -> { return Ressource.iQteBois;   }
			case "EAU"    -> { return Ressource.iQteEau;    }
			case "PIERRE" -> { return Ressource.iQtePierre; }
			default -> { return null; }		
		}
	}

	/**
	 * Consomme une quantiter d'une ressource passer en parametre.
	 *
	 * @param iConso
	 *          nombre de ressource à consommer
	 * 
	 * @param sType
	 *          nom de la ressource à consommer
	 */
	public boolean consommerRessource( int iConso )
	{
		AltInt tmp = this.getRessourceByType( this.sType );

		if ( iConso < 1 || iConso > tmp.getEntier() )return false;

		tmp.setEntier( tmp.getEntier() - iConso );
		return true;	
	}

	/**
	 * Ajoute une quantiter à une ressource passer en parametre.
	 *
	 * @param iConso
	 *          nombre de ressource à ajoute
	 * 
	 * @param sType
	 *          nom de la ressource à ajoute
	 */
	public boolean ajouterRessource( int iConso )
	{
		AltInt iTmp = this.getRessourceByType( this.sType );

		if ( iConso < 1 || iTmp.getEntier() + iConso > 15 )return false;

		iTmp.setEntier( iTmp.getEntier() + iConso );
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
	public static int getQteBle(){ return Ressource.iQteBle.getEntier(); }
	
	/**
	 * Retourne le nombre de bois dans le stock.
	 *
	 * @see  Ressource#toString()
	 */
	public static int getQteBois(){ return Ressource.iQteBois.getEntier(); }
	
	/**
	 * Retourne le nombre d'Eau dans le stock.
	 *
	 * @see  Ressource#toString()
	 */
	public static int getQteEau(){ return Ressource.iQteEau.getEntier(); }
	
	/**
	 * Retourne le nombre de Pierre dans le stock.
	 *
	 * @see  Ressource#toString()
	 */
	public static int getQtePierre(){ return Ressource.iQtePierre.getEntier(); }
	
	/**
	 * Retourne le nombre de ressource disponible dans le stock pour cette ressource.
	 */
	public int getQteRessource(){ return this.iQte; }

	/**
	 * Permet d'ajouter iNb ressource
	 * @param
	 *     Le nombre de ressource que l'on rajoute pour cette ressource
	 */
	public boolean setQte(int iNb )
	{
		AltInt aTmp = this.getRessourceByType(this.sType);
		if ( aTmp.getEntier() + iNb < 0 || aTmp.getEntier() - iNb > 15 )return false;

		this.iQte = iNb;
		// if ( iNb > 0 )aTmp.setEntier(-iNb);
	
		return true;
	}

	/**
	 * Retourne en String le nom de la ressource et le quantiter restant dans le stock.
	 */
	public String  toString()
	{
		String sRet = "";

		switch( sType )
		{
			case "BLE"    ->  sRet += String.format( "%-6s", "Ble"   ) + " : " + String.format( "%2d", Ressource.iQteBle   .getEntier() );
			case "BOIS"   ->  sRet += String.format( "%-6s", "Bois"  ) + " : " + String.format( "%2d", Ressource.iQteBois  .getEntier() );
			case "EAU"    ->  sRet += String.format( "%-6s", "Eau"   ) + " : " + String.format( "%2d", Ressource.iQteEau   .getEntier() );
			case "PIERRE" ->  sRet += String.format( "%-6s", "Pierre") + " : " + String.format( "%2d", Ressource.iQtePierre.getEntier() );
		}		

		return sRet;
	}
}

