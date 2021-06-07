package littletown.metier;

public class Plateau 
{
	// Attributs
	private int       iNombreJoueur;
	private Tuile[][] tabPlateau; // 6lig, 9col

	// Méthodes
	public Plateau( int iNombreJoueur )
	{
		this.tabPlateau      = new Tuile[6][9];
		this.iNombreJoueur = iNombreJoueur;

		remplirTableau();

		System.out.println(toString());
	}

	public Tuile[][] getPlateau() { return this.tabPlateau; }

	public void remplirTableau()
	{
		for(int i = 0; i < this.tabPlateau.length; i++)
		{
			for(int j = 0; j < this.tabPlateau[0].length; j++)
			{
				 this.tabPlateau[i][j] = new Ressource( "ble", true );
			}
		}
	}

	public String toString()
	{
		String sRet = "";

		for(int i = 0; i < this.tabPlateau.length; i++)
		{
			for(int j = 0; j < this.tabPlateau[0].length; j++)
			{
				 sRet += "Coord X : " + j + " Y : " + i + "\n";
				 sRet += this.tabPlateau[i][j].toString() + "\n";
			}
		}

		return sRet;
	}
}
