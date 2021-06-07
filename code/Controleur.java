package littletown;

import littletown.metier.*;

public class Controleur
{
	Plateau metier;
	Console ihm;

	public Controleur()
	{
		this.metier = new Plateau( 2 );
	}

	public static void main(String[] args)
	{
		new Controleur();
	}
}