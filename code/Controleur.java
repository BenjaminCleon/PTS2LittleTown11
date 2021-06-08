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

		System.out.println(this.jeu.construireBatiment(1, "bar", 4, 2));
		System.out.println(this.jeu.construireBatiment(1, "bar", 4, 0));

	}

	public static void main(String[] args)
	{
		new Controleur();
	}
}