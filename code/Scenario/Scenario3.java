package equipe_11.scenario;

import equipe_11.metier.Jeu;

public class Scenario3 extends Jeu
{
	public Scenario3()
	{
		super();

		/*---------------------------*/
		/*  Tests du début de partie */
		/*---------------------------*/

		// Vérifie le nombre de joueur
		super.setJoueur(1); // Ne fonctionne pas
		super.setJoueur(5); // Ne fonctionne pas
		super.setJoueur(2);

		// Vérifie le nom des joueurs
		super.setNomJoueur(0, "BenjaminMathis");
		super.setNomJoueur(1, "");

		// Vérifie le numéro du plateau
		super.setNumPlateau(0); // Ne fonctionne pas
		super.setNumPlateau(3); // Ne fonctionne pas
		super.setNumPlateau(1); // Plateau 1 fonctionnel

		/*---------------------------*/
		/*  Tests du début de partie */
		/*---------------------------*/
		super.ajouterOuvrier()

	}
}
