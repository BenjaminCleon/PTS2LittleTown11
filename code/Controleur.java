package equipe_11;

import equipe_11.ihm.Console;
import equipe_11.metier.Jeu;

public class Controleur
{
	Console ihm;
	Jeu     jeu;

	public Controleur()
	{
		this.jeu = new Jeu();

		System.out.println(this.jeu.construireBatiment(1, "bar", 4, 'A'));
		System.out.println(this.jeu.construireBatiment(1, "bar", 4, 'A'));

	}

	public static void main(String[] args)
	{
		new Controleur();
	}
}