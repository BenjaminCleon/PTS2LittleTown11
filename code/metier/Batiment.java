package littletown.metier;

public class Batiment extends Tuile
{
	// Attributs
	private String sType;

	private String[][] tabConstruction =
    { {  "0",         "pierre", "bois", "ble", "eau", "exp", },
      { "bar",         "0",     "2",    "2",   "0",  "5",   },
      { "boulangerie", "0",     "2",    "0",  "0",  "4",   },
      { "champs",      "0",     "1",    "0",  "0",  "3",   },
      { "statue",      "4",      "0",   "0",  "0",  "10"   }};

	// Méthodes
	public Batiment( String sType )
	{
		super("batiment");
		this.sType = sType;
	}

	public Integer parcourirTableau( String sRessource )
	{
		for(int i = 0; i < this.tabConstruction.length - 1; i++)
		{
			if(this.tabConstruction[i][0].equals(this.sType))
			{
				if(sRessource.equals("eau"))
					return Integer.parseInt(this.tabConstruction[i][4]);
				
				if(sRessource.equals("bois"))
					return Integer.parseInt(this.tabConstruction[i][2]);

				if(sRessource.equals("pierre"))
					return Integer.parseInt(this.tabConstruction[i][1]);

				if(sRessource.equals("ble"))
					return Integer.parseInt(this.tabConstruction[i][3]);

				if(sRessource.equals("exp"))
					return Integer.parseInt(this.tabConstruction[i][5]);
			}
		}

		return 0;
	}

	public String toString()
	{
		String sRet;
		sRet =  super.toString();
		sRet += "Batiment de type : " + this.sType + "\n";
		sRet += " Eau : " + this.parcourirTableau( "eau" ) + "\n";
		sRet += " Ble : " + this.parcourirTableau( "ble" ) + "\n";
		sRet += " pierre : " + this.parcourirTableau( "pierre" ) + "\n";
		sRet += " exp : " + this.parcourirTableau( "exp" ) + "\n";
		sRet += " Bois : " + this.parcourirTableau( "bois" ) + "\n";

		return sRet;
	}	
}
