package equipe_11.scenario;

import equipe_11.metier.*;
import equipe_11.BatimentInfo;
import equipe_11.scenario.*;

import java.util.ArrayList;

public class Scenario2 extends Jeu
{
	public Scenario2()
	{
		super(EnsemblePioche.getPioche2());

		// Vérifie le nombre de joueur et créer les joueurs
		Joueur j1, j2, j3;
		PiocheDeCartesObjectifs pco =  new PiocheDeCartesObjectifs();

		ArrayList<CartesObjectifs> alCart1 = new ArrayList<CartesObjectifs>();
		ArrayList<CartesObjectifs> alCart2 = new ArrayList<CartesObjectifs>();
		ArrayList<CartesObjectifs> alCart3 = new ArrayList<CartesObjectifs>();

		j1 = new Joueur("Rouge", 4, 5, 3, this, pco);
		j2 = new Joueur("Bleu" , 4, 5, 3, this, pco);
		j3 = new Joueur("Jaune", 4, 5, 3, this, pco);

		alCart1.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(3, j1));
		alCart1.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(5, j1));
		alCart1.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(6, j1));

		alCart2.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(2, j2));
		alCart2.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(7, j2));
		alCart2.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(8, j2));

		alCart3.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(0, j3));
		alCart3.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(1, j3));
		alCart3.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(4, j3));

		j1.setCartesObjectif(alCart1);
		j2.setCartesObjectif(alCart2);
		j3.setCartesObjectif(alCart3);

		super.setJoueur(j1, j2, j3);

		// Nom des joueurs
		super.setNomJoueur(0, "Manon"   );
		super.setNomJoueur(1, "Maxence" );
		super.setNomJoueur(2, "Philippe");

		// Le plateau 2 est fonctionnel
		super.setNumPlateau(2);

		// Permet de faire l'objectif "Avoir 0 pièce"
		super.ajouterOuvrier(2, 'D');                 // Récupère 2 pierre et 1 bois
		super.echangerPieceContreRessource("PIERRE");
		super.verifierObjectif();                    // Validation de l'objectif 3
		super.ajouterOuvrier(1, 'C');                // Récupère 1 pierre et 1 bois
		super.construireBatiment(1, "LIBRAIRIE", 1, 'B'); // On perd 4 pierre, on gagne 8 score
		super.verifierObjectif();                    // Validation de l'objectif 2
		super.mettreJoueurA(0);
		super.construireBatiment(1, "EPICERIE", 2, 'G'); // On perd deux bois, on gagne 4 score
		super.verifierObjectif();                   // Validation de l'objectif 1 du joueur rouge
		// Tous les objectifs du joueurs rouge sont validés

		// Ouvrier/Batiment restant: 0/6            4/6                            4/6
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 20                 */ /* Score   : 0                  */ /* Score   : 0                  */
		/* Piece   : 0                  */ /* Piece   : 3                  */ /* Piece   : 3                  */
		/* Bois    : 0                  */ /* Bois    : 0                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 0                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
	
		// A ce moment nous avons construit 2 batiments normalement,
		// nous avons passé 1 joueur et sommes donc sur le joueur jaune
		// On se replace sur le joueur bleu

		super.changerJoueur();
		super.changerJoueur();

		super.ajouterOuvrier(2, 'B');  // Récupère 
		super.activerBatiment(1, 'B'); // Nombre de pièces à 5
		super.construireBatiment(2, "PRETEURSURGAGE", 4, 'B'); // On perd 3 de bois, on gagne 5
		super.verifierObjectif();      // Validation de l'objectif 3
		super.mettreJoueurA(1);
		super.ajouterOuvrier(2, 'A'); // On récupère 2 bois
		super.ajouterOuvrier(3, 'B'); // On récupère 2 bois

		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();

		// Ouvrier/Batiment restant: 0/6            4/6                            4/6
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 20                 */ /* Score   : 7                  */ /* Score   : 0                  */
		/* Piece   : 0                  */ /* Piece   : 5                  */ /* Piece   : 3                  */
		/* Bois    : 2                  */ /* Bois    : 4                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 0                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier(5, 'B');
		super.activerBatiment(4 , 'B');
		// Le preteur sur gage est fonctionnel
		super.activerPreteurSurGage("POISSON", "POISSON", "BLE", "BLE");
		super.activerPreteurSurGage("BOIS", "BOIS", "POISSON", "POISSON"); // Ne fonctionne pas car déjà activé 
		super.ajouterOuvrier(4, 'A');
		super.activerBatiment(4, 'B');
		super.activerPreteurSurGage("POISSON", "POISSON", "BOIS", "BOIS"); // Ne fonctionne pas car pas assez de ressource
		super.activerPreteurSurGage("POISSON", "BOIS", "BLE", "BLE");      // Fonctionne
		super.ajouterOuvrier (2, 'H');
		super.activerBatiment(2, 'G'); // On récupère 1 bois et 1 poisson, on perd une piece
		super.verifierObjectif();      // Valide l'objectif 2 du joueur Jaune
		super.construireBatiment(3, "CHAMPSDEBLE", 1, 'H');

		// Ouvrier/Batiment restant: 0/6            0/6                            0/6
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 20                 */ /* Score   : 10                 */ /* Score   : 6                  */
		/* Piece   : 0                  */ /* Piece   : 7                  */ /* Piece   : 0                  */
		/* Bois    : 2                  */ /* Bois    : 4                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 5                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 3                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		j1.nourrirOuvrier(); // Renvoie true donc les ouvriers sont ici nourris
		j2.nourrirOuvrier(); // Renvoie true donc les ouvriers sont ici nourris
		j3.nourrirOuvrier(0, 4, 0); // Fonctionne

		// Ouvrier/Batiment restant: 4/6            4/6                            4/6
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 8                  */ /* Score   : 4                  */ /* Score   : 6                  */
		/* Piece   : 2                  */ /* Piece   : 1                  */ /* Piece   : 0                  */
		/* Bois    : 2                  */ /* Bois    : 4                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     :                   */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 3                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.passerManche();

		super.ajouterOuvrier (1, 'C'); // Récupère 1 de bois et 1 de pierre
		super.activerBatiment(1, 'B'); // Récupère trois pièce
		super.ajouterOuvrier (2, 'A'); // Récupère 2 de bois
		super.activerBatiment(1, 'B'); // Nous sommes à 5 pièces
		super.ajouterOuvrier (2, 'B'); // Récupère 3 de bois
		super.activerBatiment(1, 'B'); // Nous sommes à 7 pièces

		// Le poissonnier fonctionnne
		super.construireBatiment(2, "POISSONNIER", 4, 'C'); // On perd 1 bois, 1 pierre, gagne 4 score
		super.verifierObjectif(); // Validation du dernier objectif bleu, gagne 2 de score

		// Ouvrier/Batiment restant: 4/6            0/4                            4/6
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 8                  */ /* Score   : 10                 */ /* Score   : 6                  */
		/* Piece   : 0                  */ /* Piece   : 7                  */ /* Piece   : 0                  */
		/* Bois    : 2                  */ /* Bois    : 9                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 5                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 3                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
	
		super.ajouterOuvrier(3, 'B');  // Récupère 2 bois
		super.activerBatiment(4, 'B');
		super.activerPreteurSurGage("POISSON", "POISSON", "BOIS", "BOIS"); // échange 2 poisson contre deux bois 
		super.construireBatiment(3, "CHAMPSDEBLE", 2, 'I'); // perd 1 bois, gagne 3 de score
		super.changerJoueur();
		super.changerJoueur();
		super.construireBatiment(3, "CHAMPSDEBLE", 3, 'H'); // perd 1 bois, gagne 3 de score
		super.changerJoueur();
		super.changerJoueur();
		super.construireBatiment(3, "CHAMPSDEBLE", 5, 'I'); // perd 1 bois, gagne 3 de score

		// Ouvrier/Batiment restant: 4/6            0/4                            0/2
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 8                  */ /* Score   : 10                 */ /* Score   : 15                 */
		/* Piece   : 0                  */ /* Piece   : 7                  */ /* Piece   : 0                  */
		/* Bois    : 2                  */ /* Bois    : 9                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 1                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 1                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier(2, 'E');
		super.ajouterOuvrier(2, 'D');
		super.ajouterOuvrier(5, 'B');
		super.activerBatiment(4, 'B');
		super.activerPreteurSurGage("POISSON", "POISSON", "PIERRE", "PIERRE");
		super.construireBatiment   (1, "CATHEDRALE", 6, 'C'); // 11 points de score en plus, 6 pierre en moins

		j1.nourrirOuvrier();
		j2.nourrirOuvrier();
		j3.nourrirOuvrier();

		// Ouvrier/Batiment restant: 4/3            4/4                            4/2
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 11                 */ /* Score   : 4                  */ /* Score   : 9                  */
		/* Piece   : 1                  */ /* Piece   : 2                  */ /* Piece   : 0                  */
		/* Bois    : 1                  */ /* Bois    : 9                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 1                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 1                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.passerManche(); // Nous fait récupéter au passage le score obtenue grâce à la cathédrale

		super.construireBatiment(3, "CHAMPSDEBLE", 3, 'G');
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(2, 'A');
		super.verifierObjectif();     // Active l'objectif 1 du joueur jaune, 3 score
		super.ajouterOuvrier(2, 'H'); // Récupère 2 poissons, 1 bois
		
		// Récupère 4 blés
		super.activerBatiment(1, 'H');
		super.activerBatiment(2, 'I');
		super.activerBatiment(3, 'H');
		super.activerBatiment(3, 'G');

		super.construireBatiment(3, "CHARPENTIER", 6, 'F');
		super.verifierObjectif();  // Active le dernier objectif du joueur jaune, 2 de score

		// Ouvrier/Batiment restant: 4/3            4/4                            0/0
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 11                 */ /* Score   : 4                  */ /* Score   : 21                 */
		/* Piece   : 1                  */ /* Piece   : 2                  */ /* Piece   : 0                  */
		/* Bois    : 1                  */ /* Bois    : 9                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 4                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 2                  */
		/* Pierre  : 0                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier (2, 'B'); // Récupère 3 bois
		super.activerBatiment(1, 'B'); // Active la librairie, récupère trois pièce
		super.ajouterOuvrier (1, 'C'); // Récupère 1 bois, 2 pierres
		super.activerBatiment(1, 'B'); // Active la librairie, récupère trois pièce
		super.ajouterOuvrier (5, 'B'); // Récupère 2 poissons

		super.construireBatiment(1, "RESIDENCE", 3, 'F'); // Achat de la résidence, perd 6 pièce, gagne 2 score
		// Ouvrier/Batiment restant: 0/2            4/4                            3/0
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 13                 */ /* Score   : 4                  */ /* Score   : 21                 */
		/* Piece   : 1                  */ /* Piece   : 2                  */ /* Piece   : 0                  */
		/* Bois    : 5                  */ /* Bois    : 9                  */ /* Bois    : 0                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 4                  */
		/* Poisson : 2                  */ /* Poisson : 0                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 0                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.construireBatiment(2, "BOULANGERIE", 3, 'E'); // Perd 2 bois, gagne 4 de score
		super.changerJoueur(); 
		super.changerJoueur();
		super.ajouterOuvrier(2, 'D');                       // Récupère 2 pierre, 1 bois
		super.ajouterOuvrier(5, 'C');                       // Récupère 1 pierre
		super.activerBatiment(4, 'B');
		super.activerPreteurSurGage("BOIS", "BOIS", "PIERRE", "PIERRE"); // Perd 1 pièce et 2 bois, gagne 2 pierres
		super.construireBatiment(2, "EGLISE", 4, 'F');                   // Perd 4 pierre, gagne 8 score

		// Ouvrier/Batiment restant: 0/2            0/2                            0/0
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 13                 */ /* Score   : 16                 */ /* Score   : 21                 */
		/* Piece   : 1                  */ /* Piece   : 2                  */ /* Piece   : 0                  */
		/* Bois    : 5                  */ /* Bois    : 6                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 4                  */
		/* Poisson : 2                  */ /* Poisson : 0                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 1                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		// On pourrai activer la résidence mais nous le faisons pas encore dans le scénario
		// Nous le ferons en interaction avec les enseignants

		j1.nourrirOuvrier();
		j2.nourrirOuvrier();
		j3.nourrirOuvrier(0, 4, 0);

		// Ouvrier/Batiment restant: 0/2            0/2                            0/0
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 7                  */ /* Score   : 4                  */ /* Score   : 21                 */
		/* Piece   : 1                  */ /* Piece   : 2                  */ /* Piece   : 0                  */
		/* Bois    : 5                  */ /* Bois    : 6                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 1                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.passerManche(); // Plus 2 joueur rouge avec la cathédrale

		// Ouvrier/Batiment restant: 4/2            4/2                            4/0
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 9                  */ /* Score   : 4                  */ /* Score   : 21                 */
		/* Piece   : 1                  */ /* Piece   : 2                  */ /* Piece   : 0                  */
		/* Bois    : 5                  */ /* Bois    : 6                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 1                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier (1, 'C'); // Récupère 1 pierre et 1 bois
		super.activerBatiment(1, 'B'); // Récupère 3 pièces
		super.construireBatiment(1, "FOIRE", 4, 'E'); // Perd 4 bois, gagne 6 de score
		super.changerJoueur();
		super.changerJoueur();
		super.construireBatiment(1, "RESTAURANT", 2, 'E'); // Perd 2 pierre, 2 bois, gagne 6 score
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(5, 'B'); // Récupère 2 poissons
		super.activerBatiment(4, 'B');
		super.activerPreteurSurGage("BOIS", "POISSON", "PIERRE", "POISSON"); 
		super.changerJoueur();

		// Ouvrier/Batiment restant: 0/0            4/2                            4/0
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 21                 */ /* Score   : 4                  */ /* Score   : 21                 */
		/* Piece   : 3                  */ /* Piece   : 2                  */ /* Piece   : 0                  */
		/* Bois    : 5                  */ /* Bois    : 6                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 1                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier (2, 'D'); // Récupère 2 pierre, 1 bois
		super.ajouterOuvrier (4, 'H'); // Récupère 1 poisson, 1 bois
		super.activerBatiment(3, 'H'); // Récupère 1 blé, perd 1 pièce, donne 1 au jaune
		super.activerBatiment(2, 'I'); // Récupère 1 blé, perd 1 pièce, donne 1 au jaune
		super.construireBatiment(2, "BAR", 4, 'D'); // Perd 2 blé, 2 pierre, gagne 7 score
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier (3, 'C'); // Récupère 1 bois
		super.activerBatiment(4, 'D'); // Récupère 3 de score
		super.activerBatiment(4, 'C'); // Récupère 3 pièces
		super.changerJoueur();

		// Ouvrier/Batiment restant: 0/0            0/1                            4/0
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/
		/* Joueur rouge:                */ /* Joueur bleu:                 */ /* Joueur jaune:                */
		/* Score   : 21                 */ /* Score   : 14                 */ /* Score   : 21                 */
		/* Piece   : 3                  */ /* Piece   : 3                  */ /* Piece   : 2                  */
		/* Bois    : 5                  */ /* Bois    : 9                  */ /* Bois    : 1                  */
		/* Ble     : 0                  */ /* Ble     : 0                  */ /* Ble     : 0                  */
		/* Poisson : 0                  */ /* Poisson : 0                  */ /* Poisson : 2                  */
		/* Pierre  : 1                  */ /* Pierre  : 1                  */ /* Pierre  : 0                  */
		/*------------------------------*/ /*------------------------------*/ /*------------------------------*/

		super.ajouterOuvrier(2, 'H'); // 2 poissons et 1 bois 

		// Récupère 4 blés
		super.activerBatiment(1, 'H');
		super.activerBatiment(2, 'I');
		super.activerBatiment(3, 'H');
		super.activerBatiment(3, 'G');

		super.ajouterOuvrier(5, 'D');  // Récupère 1 pierre
		super.ajouterOuvrier(3, 'D');  // récupère 1 bois
		super.activerBatiment(3, 'E'); // Récupère 4 pièces, perd 1 pièce
		
		// On demandera ces action aux enseignants
		// super.ajouterOuvrier (5, 'F'); 
		// super.activerBatiment(6, 'F'); // Ne fonctionne 
		// super.activerBatiment(4, 'E'); // Récupère 7 de score, perd 1 de chaque ressource
		// super.activerBatiment(4, 'F'); // Perd 4 pièces, gagne 5 de score
		
		// Test des résidences

	}
}
