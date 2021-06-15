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

		alCart1.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(4, j1));
		alCart1.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(6, j1));
		alCart1.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(7, j1));

		alCart2.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(3, j2));
		alCart2.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(8, j2));
		alCart2.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(9, j2));

		alCart3.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(1, j3));
		alCart3.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(2, j3));
		alCart3.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(5, j3));

		j1.setCartesObjectif(alCart1);
		j2.setCartesObjectif(alCart2);
		j3.setCartesObjectif(alCart3);

		super.setJoueur(j1, j2, j3);

		// Vérifie le nom des joueurs
		super.setNomJoueur(0, "Manon");
		super.setNomJoueur(1, null   );

		// Le plateau 2 est fonctionnel
		super.setNumPlateau(2);


    }
}
