package equipe_11.scenario;

import equipe_11.metier.Jeu;

public class Scenario1 extends Jeu
{
	/*------------------------------------*/
	/* Cette classe n'a pas pour objectif */
	/* de vérifier le validation des      */
	/* cartes objectifs                   */
	
	public Scenario1()
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
		super.ajouterOuvrier(0, 'A'); // Ne fonctionne pas (en dehors du plateau)
		super.ajouterOuvrier(7, 'A'); // Ne fonctionne pas (en dehors du plateau)
		super.ajouterOuvrier(1, '@'); // Ne fonctionne pas (en dehors du plateau)
		super.ajouterOuvrier(1, 'J'); // Ne fonctionne pas (en dehors du plateau)

		super.ajouterOuvrier(5, 'F'); // Fonctionne
		// Ouvrier/Batiment restant: 4/7            5/7
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 0                  */ /* Score   : 0                  */
		/* Piece   : 3                  */ /* Piece   : 3                  */
		/* Bois    : 1                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 2                  */ /* Poisson : 0                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/

		super.changerJoueur();
		super.ajouterOuvrier(5, 'E'); // Fonctionne
		super.changerJoueur();
		// Ouvrier/Batiment restant: 4/7            4/7
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 0                  */ /* Score   : 0                  */
		/* Piece   : 3                  */ /* Piece   : 3                  */
		/* Bois    : 1                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 2                  */ /* Poisson : 2                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/

		super.construireBatiment(1, "CHAMPSDEBLE", 0, 'A' ); // Ne fonctionne pas (en dehors du plateau)
		super.construireBatiment(1, "CHAMPSDEBLE", 7, 'A' ); // Ne fonctionne pas (en dehors du plateau)
		super.construireBatiment(1, "CHAMPSDEBLE", 1, '@' ); // Ne fonctionne pas (en dehors du plateau)
		super.construireBatiment(1, "CHAMPSDEBLE", 1, 'J' ); // Ne fonctionne pas (en dehors du plateau)

		// Nombre de champs de blé: 5 
		super.construireBatiment(1, "CHAMPSDEBLE", 1, 'B' ); // Fonctionne
		// Nombre de champs de blé: 4

		// Changement de joueur automatique car on a construit un batiment
		// Ouvrier/Batiment restant: 3/6            4/7
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 3                  */ /* Score   : 0                  */
		/* Piece   : 3                  */ /* Piece   : 3                  */
		/* Bois    : 0                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 2                  */ /* Poisson : 2                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/

		super.construireBatiment(2, "CHAMPSDEBLE", 2, 'B'); // Ne fonctionne pas (pas assez de ressource)
		// Vérifie les échanges de pièces
		super.echangerPieceContreRessource("NIMPORTEQUOI"); // Ne fonctionne pas (ressource demandé inexistante)
		super.echangerPieceContreRessource("BOIS"        ); // Fonctionne
		super.echangerPieceContreRessource("BLE"         ); // Ne fonctionne pas (plus assez de pièce)

		// Nombre de champs de blé: 4
		super.construireBatiment(2, "CHAMPSDEBLE", 1, 'B'); // Ne fonctionne pas car il y a déjà un batiment
		super.construireBatiment(2, "CHAMPSDEBLE", 5, 'E'); // Ne fonctionne pas car il y a déjà un ouvrier
		super.construireBatiment(2, "CHAMPSDEBLE", 1, 'A'); // Ne fonctionne pas car il y a déjà une ressource
		super.construireBatiment(2, "CHAMPSDEBLE", 3, 'B'); // Fonctionne car on à récupérer du bois
		// Nombre de champs de blé: 3

		// Ouvrier/Batiment restant: 3/6            3/6
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 3                  */ /* Score   : 3                  */
		/* Piece   : 3                  */ /* Piece   : 0                  */
		/* Bois    : 0                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 2                  */ /* Poisson : 2                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier(2, 'D');   // Fonctionne
		super.changerJoueur();

		// Ouvrier/Batiment restant: 2/6            3/6
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 3                  */ /* Score   : 3                  */
		/* Piece   : 3                  */ /* Piece   : 0                  */
		/* Bois    : 1                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 2                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier (2, 'C'); // Fonctionne (récupère pierre/bois)
		super.activerBatiment(1, 'B'); // Ne fonctionne pas(pas assez de pièce)
		super.activerBatiment(1, 'G'); // Ne fonctionne pas(pas de batiment)
		super.activerBatiment(1, 'A'); // Ne fonctionne pas (c'est une ressource)
		super.activerBatiment(3, 'B'); // Fonctionne (pas besoin de pièce)
		super.changerJoueur();
		
		// Ouvrier/Batiment restant: 2/6            2/6
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 3                  */ /* Score   : 3                  */
		/* Piece   : 3                  */ /* Piece   : 0                  */
		/* Bois    : 1                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 1                  */
		/* Poisson : 2                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 1                  */
		/*------------------------------*/ /*------------------------------*/

		super.construireBatiment(1, "CHAMPSDEBLE", 3, 'D'); // Fonctionne
		// Ouvrier/Batiment restant: 1/6            2/6
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 6                  */ /* Score   : 3                  */
		/* Piece   : 3                  */ /* Piece   : 0                  */
		/* Bois    : 0                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 1                  */
		/* Poisson : 2                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 1                  */
		/*------------------------------*/ /*------------------------------*/
		super.ajouterOuvrier (4, 'B'); // On récupère du bois et du poisson
		super.activerBatiment(3, 'B');
		super.changerJoueur();

		// Ouvrier/Batiment restant: 1/6            1/6
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 6                  */ /* Score   : 3                  */
		/* Piece   : 3                  */ /* Piece   : 0                  */
		/* Bois    : 0                  */ /* Bois    : 2                  */
		/* Ble     : 0                  */ /* Ble     : 2                  */
		/* Poisson : 2                  */ /* Poisson : 3                  */
		/* Pierre  : 1                  */ /* Pierre  : 1                  */
		/*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier (2, 'B');
		super.activerBatiment(1, 'B'); // On récupère un de blé
		super.activerBatiment(3, 'D'); // Ne fonctionne pas car n'est pas autour de l'ouvrier
		super.activerBatiment(3, 'B'); // On récupère un de blé mais on paye l'autre joueur
		super.changerJoueur();
		
		// Ouvrier/Batiment restant: 0/6            1/6
		/*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */
		/* Score   : 6                  */ /* Score   : 3                  */
		/* Piece   : 2                  */ /* Piece   : 1                  */
		/* Bois    : 1                  */ /* Bois    : 2                  */
		/* Ble     : 2                  */ /* Ble     : 2                  */
		/* Poisson : 3                  */ /* Poisson : 3                  */
		/* Pierre  : 2                  */ /* Pierre  : 1                  */
		/*------------------------------*/ /*------------------------------*/

		// Il reste à placer le dernier ouvrier et à nourrir
		// On utilisera ce scénario pour démontrer le fonctionnement de nourrir ouvrier
	}
}
