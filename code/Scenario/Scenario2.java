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

		j1 = new Joueur("Rouge", 4, 5, 3, this, this.getPioche1(), pco);
		j2 = new Joueur("Bleu" , 4, 5, 3, this, this.getPioche2(), pco);
		j3 = new Joueur("Jaune", 4, 5, 3, this, this.getPioche3(), pco);

		super.setJoueur(j1, j2, j3);

		// Vérifie le nom des joueurs
		super.setNomJoueur(0, "Manon");
		super.setNomJoueur(1, null   );

		// Le plateau 2 est fonctionnel
		super.setNumPlateau(2);


    }

	private ArrayList<CartesObjectifs> getPioche1()
	{
		ArrayList<CartesObjectifs> alCart = new ArrayList<CartesObjectifs>();

		for (int i=0;i<3;i++)alCart.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(i));

		return alCart;
	}

	private ArrayList<CartesObjectifs> getPioche2()
	{
		ArrayList<CartesObjectifs> alCart = new ArrayList<CartesObjectifs>();
	
		for (int i=3;i<6;i++)alCart.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(i));

		return alCart;
	}
	
	private ArrayList<CartesObjectifs> getPioche3()
	{
		ArrayList<CartesObjectifs> alCart = new ArrayList<CartesObjectifs>();

		for (int i=6;i<9;i++)alCart.add(PiocheDeCartesObjectifs.piocheCartesObjectifs(i));

		return alCart;
	}
}
