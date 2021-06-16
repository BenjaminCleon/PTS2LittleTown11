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
		super.verifierObjectif();      // Validation de l'objectif  1

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
		super.activerPreteurSurGage("BOIS", "BOIS", "POISSON", "POISSON"); // Ne fonctionne pas car déjà activé -1 pièce
		super.ajouterOuvrier(4, 'A');
		super.activerBatiment(4, 'B');
		super.activerPreteurSurGage("POISSON", "POISSON", "BOIS", "BOIS"); // Ne fonctionne pas car pas assez de ressource -1 pièce
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
		/* Score   : 20                 */ /* Score   : 10                 */ /* Score   : 6                  */
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
		/* Score   : 20                 */ /* Score   : 10                 */ /* Score   : 15                 */
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
		/* Score   : 19                 */ /* Score   : 10                 */ /* Score   : 15                 */
		/* Piece   : 4                  */ /* Piece   : 8                  */ /* Piece   : 0                  */
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
		super.verifierObjectif();  // Active l'objectfi 1 du joueur jaune
		super.changerJoueur();
		super.construireBatiment(1, "CHARPENTIER", 6, 'F');
		super.verifierObjectif();

	}
}
