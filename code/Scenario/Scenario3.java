package equipe_11.scenario;

import equipe_11.metier.*;
import equipe_11.scenario.EnsemblePioche;

public class Scenario3 extends Jeu
{
	public Scenario3()
	{
		super(EnsemblePioche.getPioche3());

		super.setJoueur(4);
		super.setNomJoueur(0, "Matheo");
		super.setNomJoueur(1, "Dorian");
		super.setNomJoueur(2, "Quentin");
		super.setNomJoueur(3, "Theo");

		super.setNumPlateau(1);

		// Faisons la statue
		super.ajouterOuvrier(2, 'I');
		super.ajouterOuvrier(2, 'H');

		super.construireBatiment(1, "STATUE", 6, 'A');

		// Faisons la carrière
		super.ajouterOuvrier(5, 'B');
		super.construireBatiment(2, "CARRIERE", 5, 'A'); // construction réussie 5 points
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(4, 'B');   // Activation résussie -2pce => +2pierre
		super.activerBatiment(5, 'A');
		super.changerJoueur();

		// Faisons la brasserie
		super.ajouterOuvrier(5, 'H');
		super.construireBatiment(3, "BRASSERIE", 6, 'H'); // réussie 4 points
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.echangerPieceContreRessource("BLE");
		super.ajouterOuvrier(5, 'I'); 
		super.activerBatiment(6, 'H');  // Activation réussi -1ble => + 3score  

		super.changerJoueur();

		super.ajouterOuvrier(2, 'C');
		super.construireBatiment(4, "MINEDOR", 2, 'D'); // construction réussie +4pt 
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(3, 'C');
		super.activerBatiment(2, 'D');      // activation réussie plus 2 pièces

		super.changerJoueur ();
		
		for ( Joueur j : super.getJoueurs())j.nourrirOuvrier();

		super.passerManche();
		
		// Faisons la fontaine
		super.ajouterOuvrier(2, 'I');
		super.construireBatiment(2, "FONTAINE", 2, 'G'); // Construction réussie => + 5
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(3, 'G');
		super.activerBatiment(2, 'G');                   // Activation => -1pc +3pt

		super.changerJoueur();
		// Faisons le ponton
		super.ajouterOuvrier(5, 'B');
		super.construireBatiment(3, "PONTON", 6, 'D'); // Construction => -3bois +5pt 
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(5, 'D');
		super.activerBatiment(6, 'D'); //=> + 2poissons

		super.changerJoueur();

		// On prépare des champs de blé
		super.ajouterOuvrier(5, 'C');
		super.construireBatiment(4, "CHAMPSDEBLE", 5, 'I');
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.construireBatiment(4, "CHAMPSDEBLE", 6, 'G');

		// Faisons le puits
		super.ajouterOuvrier(2, 'C');
		super.construireBatiment(1, "PUITS", 1, 'B'); // => -1 bois/pierre +4pt
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(2, 'A');
		super.activerBatiment(1, 'B');              // => + 2pt
		super.changerJoueur();
		
		for ( Joueur j : super.getJoueurs())j.nourrirOuvrier();
		
		super.passerManche();

		// Récupération de ressource, on construit à la prochaine manche l'atelier
		super.ajouterOuvrier(2, 'H');
		super.ajouterOuvrier(5, 'C');
		super.ajouterOuvrier(1, 'E');

		// Récupération de ressource, on construit à la prochaine manche le grenier
		super.changerJoueur();
		super.ajouterOuvrier(5, 'H');
		super.ajouterOuvrier(1, 'G');
		super.ajouterOuvrier(2, 'A');

		super.changerJoueur();

		// Récupération de ressource, on construit à la prochaine manche l'entrepot
		super.ajouterOuvrier(2, 'I');
		super.ajouterOuvrier(2, 'B');
		super.ajouterOuvrier(3, 'B');

		super.changerJoueur();

		// Récupération de ressource, on construit à la prochaine manche la tour de garde
		super.ajouterOuvrier(5, 'B');
		super.ajouterOuvrier(2, 'E');
		super.ajouterOuvrier(2, 'C');

		super.changerJoueur();

		super.passerManche();

		// Faisons le grenier
		super.ajouterOuvrier(5, 'H');
		super.activerBatiment(5, 'I');
		super.activerBatiment(6, 'G');
		super.construireBatiment(4, "GRENIER", 3, 'I');  // Perte de 4 bois +6pt
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(4, 'H');
		super.activerBatiment(3, 'I');       // Perte de 2 blé => +5pt
	
		super.changerJoueur();

		super.construireBatiment(1, "ENTREPOT", 1, 'G'); // -4 pierre +8pt
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(2, 'H');
		super.activerBatiment(1, 'G'); // On récupère 5 points et -2pierres
		super.ajouterOuvrier(2, 'A');

		super.changerJoueur();

		 // On ne récupère rien pour la construction pour le moment, on perd 3pierre et 3 bois
		super.construireBatiment(2, "TOURDEGARDE", 5, 'C');
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(3, 'H');
		super.ajouterOuvrier(1, 'E');

		super.changerJoueur();

		// Faisons l'atelier
		super.construireBatiment(3, "ATELIER", 2, 'F'); // Gagne 5score, perd deux pierre
		super.changerJoueur();
		super.changerJoueur();
		super.changerJoueur();
		super.ajouterOuvrier(2, 'E');
		super.activerBatiment(2, 'F');                  // Perd deux bois, gagne 3 score

		// Interaction avec les enseignants
		/*-------------------------------------------*/
		/* Placer un ouvrier n'importe ou exemple f5 */
		/* Nourrir le jaune et le  bleu              */
		/* Avec par exmple 3 poissons                */
		/*-------------------------------------------*/
	}
}
