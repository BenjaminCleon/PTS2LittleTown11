  
package equipe_11.metier;

import java.util.Collections;

import java.util.List;

import equipe_11.metier.CartesObjectifs;

import java.util.ArrayList;

public class PiocheDeCartesObjectifs
{
	private static ArrayList<CartesObjectifs> lstCartesObjectifs = new ArrayList<CartesObjectifs>();

	public PiocheDeCartesObjectifs()
	{
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 3, "Avoir plus de Batiments que d'Ouvriers." ) );                                    // 1
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 3, "Avoir au moins 2 fois plus de cubes Nourriture que d'Ouvriers." ) );             // 2
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 2, "Construire 1 Batiment qui produit et/ou consomme de l'eau." ) );                 // 3
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 3, "Construire 2 Batiments qui produisent et/ou consomment des pieces." ) );         // 4
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 2, "Construire 1 Batiment qui produit et/ou consomme du bois ou de la pierre." ) );  // 5 
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 2, "Construire un Batiment dont le cout est d'au moins 3 pierres." ) );              // 6
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 3, "Avoir 0 pieces." ) );                                                            // 7
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 3, "Avoir au moins 6 pieces" ) );                                                    // 8
		PiocheDeCartesObjectifs.lstCartesObjectifs.add( new CartesObjectifs( 2, "Construire 1 Batiment dont le cout est d'au moins 3 bois a la constuction." ) ); // 9
	}

	public CartesObjectifs piocherCarteObjectif( Joueur j )
	{
		CartesObjectifs cTmp = PiocheDeCartesObjectifs.lstCartesObjectifs.get( 0 );
		cTmp.setJoueur( j );
		PiocheDeCartesObjectifs.lstCartesObjectifs.remove(0);
		return cTmp;
	}

	public static CartesObjectifs piocheCartesObjectifs(int i)
	{
		return PiocheDeCartesObjectifs.lstCartesObjectifs.get(i);
	}

	public void melangerPioche()
	{
		Collections.shuffle( PiocheDeCartesObjectifs.lstCartesObjectifs );
	}
}