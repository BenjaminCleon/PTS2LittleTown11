package equipe_11.metier;

import java.util.Collections;

import java.util.List;
import java.util.ArrayList;

public class PiocheDeCartesObjectifs
{
	private static List<CartesObjectifs> lstCartesObjectifs = new ArrayList<CartesObjectifs>();

	public PiocheDeCartesObjectifs()
	{
		this.lstCartesObjectifs.add( new CartesObjectifs(  ) );
	}

	public CartesObjectifs piocherCarteObjectif()
	{
		return lstCartesObjectifs.remove( 0 )​;
	}

	public void melangerPioche()
	{
		Collections.shuffle( this.lstCartesObjectifs );
	}
}
