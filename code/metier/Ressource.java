package littletown.metier;


/** Cette classe permet de donner les informations générales sur les différentes
  * Resource disponible.
  *
  * @author Equipe 11
  */
public class Ressource extends Tuile
{
	/*-----------*/
	/* Attributs */
	/*-----------*/

	/**
	 * C'est la quantite de Ble disponible dans le stock.
	 * Ici, le préfixe is correspond à "int" selon la notation hongroise.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 */
	private static AltInt iQteBle    = new AltInt( 15 );
	
	/**
	 * C'est la quantite de Bois disponible dans le stock.
	 * Ici, le préfixe is correspond à "int" selon la notation hongroise.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 */
	private static AltInt iQteBois   = new AltInt( 15 );
	
	/**
	 * C'est la quantite d'Eau disponible dans le stock.
	 * Ici, le préfixe is correspond à "int" selon la notation hongroise.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 */
	private static AltInt iQteEau    = new AltInt( 15 );
	
	/**
	 * C'est la quantite de Pierre disponible dans le stock.
	 * Ici, le préfixe is correspond à "int" selon la notation hongroise.
	 *
	 * @see Ressource#getRessourceByType( String )
	 * @see Ressource#toString()
	 */
	private static AltInt iQtePierre = new AltInt( 15 );	

	/**
	 * C'est le nom de la ressource.
	 * Ici, le préfixe is correspond à "String" selon la notation hongroise.
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
	
	/**
	 * Esque cette ressource peut etre utiliser pour nourire les ouvriers.
	 * Ici, le préfixe is correspond à "boolean" selon la notation hongroise.
	 *
	 * @see Ressource#getEstMangeable()
	 */
	private boolean bEstMangeable;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	/**
	 * Constructeur de Ressources
	 *
	 * @param sType
	 *          Titre de la nouvelle Ressource.
	 * @param bEstMangeable
	 *          definie si cette ressource peut etre utiliser pour nourire les ouvriers.
	 * 
	 * @see 
	 * @see 
	 * @see 
	 * @see 
	 * @see 
	 * @see 
	 */
	public Ressource( String sType, boolean bEstMangeable )
	{
		super( "Ressource" );
		this.sType         = sType.toUpperCase();
		this.bEstMangeable = bEstMangeable;
	}

	/**
	 * Constructeur par recopie de Ressources
	 * bEstMangeable est rendu false par default
	 *
	 * @param sType
	 *          Titre de la nouvelle Ressource.
	 * 
	 * 
	 * @see 
	 * @see 
	 * @see 
	 * @see 
	 * @see 
	 * @see 
	 */
	public Ressource( String sType )
	{
		this( sType, false );
	}

	/**
	 * retourne le Bon type pour AltInt
	 *
	 * @param sType
	 *          nom de la ressource à rechercher
	 * 
	 * @see 
	 */
	private AltInt getRessourceByType( String sType )
	{
		switch ( sType.toUpperCase() )
		{
			case "BLE"    -> { return Ressource.iQteBle;    }
			case "BOIS"   -> { return Ressource.iQteBois;   }
			case "EAU"    -> { return Ressource.iQteEau;    }
			case "PIERRE" -> { return Ressource.iQtePierre; }
			default       -> { return null;                 }
		}
	}

	/**
	 * consomme une quantiter d'une ressource passer en parametre
	 *
	 * @param iConso
	 *          nombre de ressource à consommer
	 * 
	 * @param sType
	 *          nom de la ressource à consommer
	 * 
	 * @see 
	 */
	public boolean consommerRessource( int iConso, String sType )
	{
		AltInt tmp = this.getRessourceByType( sType );

		if ( iConso < 1 || iConso > tmp.getEntier() )return false;

		tmp.setEntier( tmp.getEntier() - iConso );
		return true;	
	}

	/**
	 * ajoute une quantiter à une ressource passer en parametre
	 *
	 * @param iConso
	 *          nombre de ressource à ajoute
	 * 
	 * @param sType
	 *          nom de la ressource à ajoute
	 * 
	 * @see 
	 */
	public boolean ajouterRessource( int iConso, String sType )
	{
		AltInt iTmp = this.getRessourceByType( sType );

		if ( iConso < 1 || iTmp.getEntier() + iConso > 15 )return false;

		iTmp.setEntier( iTmp.getEntier() + iConso );

		return true;	
	}

	/**
	 * retourne le nom de la ressource
	 *
	 * @see 
	 */
	public String  getType()        { return this.sType;         }
	
	/**
	 * retourne si la ressource peut etre utiliser pour nourire les ouvriers.
	 *
	 * @see 
	 */
	public boolean getEstMangeable(){ return this.bEstMangeable; }
	
	/**
	 * retourne le nombre de ble dans le stock
	 *
	 * @see 
	 */
	public int     getQteBle(){ return this.iQteBle; }
	
	/**
	 * retourne le nombre de bois dans le stock
	 *
	 * @see 
	 */
	public int     getQteBois(){ return this.iQteBois; }
	
	/**
	 * retourne le nombre d'Eau dans le stock
	 *
	 * @see 
	 */
	public int     getQteEau(){ return this.iQteEau; }
	
	/**
	 * retourne le nombre de Pierre dans le stock
	 *
	 * @see 
	 */
	public int     getQtePierre(){ return this.iQtePierre; }


	/**
	 * Retourne en String le nom de la ressource et le quantiter restant dans le stock.
	 * 
	 * @see 
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

