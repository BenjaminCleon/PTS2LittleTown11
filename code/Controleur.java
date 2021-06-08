package littletown;

import littletown.ihm.Console;
import littletown.metier.Jeu;

public class Controleur
{
	Console ihm;
	Jeu     jeu;

	public Controleur()
	{
		this.jeu = new Jeu();

		this.jeu.construireBatiment(1, "bar");
	}

	public static void main(String[] args)
	{
		new Controleur();
	}
}