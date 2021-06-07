package littletown.metier;

public class Batiment extends Tuile
{
	// Attributs
	private String sType;

	// Méthodes
	public Batiment( String sType )
	{
		this.sType = sType;
	}

	public String toString()
	{
		return "Batiment de type : " + this.sType;
	}	
}
