//package littletown.metier;


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
	 * C'est la quantite disponible de Ble
	 * Ici, le préfixe is correspond à "int" "static" selon la notation hongroise.
	 *
	 * @see Ouvrage#creerOuvrage( String, String, String, String, String, Integer )
	 * @see Ouvrage#Ouvrage( String, String, String, String, String, Integer )
	 */
	private static AltInt iQteBle    = new AltInt( 15 );
	private static AltInt iQteBois   = new AltInt( 15 );
	private static AltInt iQteEau    = new AltInt( 15 );
	private static AltInt iQtePierre = new AltInt( 15 );	

	private int iQteRessource;

	private String  sType;
	private boolean bEstMangeable;

	public Ressource( String sType, boolean bEstMangeable )
	{
		super( "Ressource" );
		this.sType         = sType.toUpperCase();
		this.bEstMangeable = bEstMangeable;
	}

	public Ressource( String sType )
	{
		this( sType, false );
	}

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

	public boolean consommerRessource( int iConso, String sType )
	{
		AltInt tmp = this.getRessourceByType( sType );

		if ( iConso < 1 || iConso > tmp.getEntier() )return false;

		tmp.setEntier( tmp.getEntier() - iConso );
		return true;	
	}

	public boolean ajouterRessource( int iConso, String sType )
	{
		AltInt iTmp = this.getRessourceByType( sType );

		if ( iConso < 1 || iTmp.getEntier() + iConso > 15 )return false;

		iTmp.setEntier( iTmp.getEntier() + iConso );

		return true;	
	}

	public String  getType()        { return this.sType;         }
	public boolean getEstMangeable(){ return this.bEstMangeable; }
	public int     getQteRessource(){ return this.iQteRessource; }

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
