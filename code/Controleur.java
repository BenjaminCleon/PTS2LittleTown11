package littletown.ihm;

import littletown.metier.*;

public class Controleur
{
	Plateau metier;

	public Controleur()
	{
		this.metier = new Plateau( 2 );
	}


	public static void main(String[] args)
	{
		new Controleur();
	}
}