package equipe_11.scenario;

import equipe_11.metier.*;

import java.io.PrintWriter;
import java.io.IOException;

public class Scenario2 extends Jeu
{
    public Scenario2()
    {
        super();
        
		/*---------------------------*/
		/*  Tests du début de partie */
		/*---------------------------*/
		
		// Vérifie le nombre de joueur
		super.setJoueur(2);

		// Vérifie le nom des joueurs
		super.setNomJoueur(0, "Manon");
		super.setNomJoueur(1, null);

		// Le plateau 2 est fonctionnel
		super.setNumPlateau(2);
    }    
}
