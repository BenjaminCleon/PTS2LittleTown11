package equipe_11;

import java.util.ArrayList;

/**
 * Cette enum contient tous les batiments du jeu 
 * 
 * @author Equipe 11
 */

public enum BatimentInfo
{
	/**
	 * // Ble
	 * blRqC : ble requis        à la construction
	 * blRqA : ble requis        à l'activation
	 * blRc  : ble en recompense à l'activation
	 * 
	 * // Bois
	 * boRqC : bois requis        à la construction
	 * boRqA : bois requis        à l'activation
	 * boRc  : bois en recompense à l'activation
	 * 
	 * // Poisson
	 * poRqC  : poisson requis        à la construction
	 * poRqA  : poisson requis        à l'activation
	 * poRc   : poisson en recompense à l'activation
	 * 
	 * // Pierre
	 * pRqC  : pierre requis        à la construction
	 * pRqA  : pierre requis        à l'activation
	 * pRc   : pierre en recompense à l'activation
	 * 
	 * // Piece
	 * pcRqC : piece  requis        à la construction
	 * pcRqA : piece  requis        à l'activation
	 * pcRc  : piece  en recompense à l'activation	
	 * 
	 * // Point
	 * ptCtr : point  reçu          à la construction
	 * ptRc  : point  en recompense à l'activation
	 * 
	 * // Catégorie
	 * Catégorie du batiment, précise si il y a gain ou échange ou 
	 *           si c'est des ressources.
	 */
	//                  Ble        Bois       Poisson      Pierre      Piece      Point   Catégorie
	//                R  R  R     R  R  R     R  R  R     R  R  R     R  R  R     P  P
	//                q  q  c     q  q  c     q  q  c     q  q  c     q  q  c     t  t
	//                C  A        C  A        C  A        C  A        C  A        C  A
	PIERRE          ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0,   "RESSOURCE"   ),
	BOIS            ( 0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0,   "RESSOURCE"   ),
	POISSON         ( 0, 0, 0,    0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0, 0,    0, 0,   "RESSOURCE"   ),
	BAR             ( 2, 0, 0,    0, 0, 0,    0, 0, 0,    2, 0, 0,    0, 0, 0,    7, 3,   "GAIN"        ),
	CHAMPSDEBLE     ( 0, 0, 1,    1, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    3, 0,   "GAIN"        ),
	LIBRAIRIE       ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 0, 3,    8, 0,   "GAIN"        ),
	MINEDOR         ( 0, 0, 0,    1, 0, 0,    0, 0, 0,    1, 0, 0,    0, 0, 2,    4, 0,   "GAIN"        ),
	PONTON          ( 0, 0, 0,    3, 0, 0,    0, 0, 2,    0, 0, 0,    0, 0, 0,    5, 0,   "GAIN"        ),
	PUITS           ( 0, 0, 0,    1, 0, 0,    0, 0, 0,    1, 0, 0,    0, 0, 0,    4, 2,   "GAIN"        ),
	STATUE          ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 0, 0,   10, 0,   "GAIN"        ),
	ATELIER         ( 0, 0, 0,    0, 2, 0,    0, 0, 0,    2, 0, 0,    0, 0, 0,    5, 3,   "ECHANGE"     ),
	BOULANGERIE     ( 0, 1, 0,    2, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 4,    4, 0,   "ECHANGE"     ),
	BRASSERIE       ( 0, 1, 0,    2, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 3,   "ECHANGE"     ),
	CARRIERE        ( 0, 0, 0,    3, 0, 0,    0, 0, 0,    0, 0, 2,    0, 2, 0,    5, 0,   "ECHANGE"     ),
	CHARPENTIER     ( 0, 0, 0,    2, 0, 3,    0, 0, 0,    0, 0, 0,    0, 1, 0,    4, 0,   "ECHANGE"     ),
	EPICERIE        ( 0, 0, 1,    2, 0, 0,    0, 0, 1,    0, 0, 0,    0, 1, 0,    4, 0,   "ECHANGE"     ),
	ENTREPOT        ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 2, 0,    0, 0, 0,    8, 5,   "ECHANGE"     ),
	EGLISE          ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 3, 0,    8, 5,   "ECHANGE"     ),
	FOIRE           ( 0, 1, 0,    4, 1, 0,    0, 1, 0,    0, 1, 0,    0, 0, 0,    6, 7,   "ECHANGE"     ),
	FONTAINE        ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    2, 0, 0,    0, 1, 0,    5, 3,   "ECHANGE"     ),
	GRENIER         ( 0, 2, 0,    4, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    6, 5,   "ECHANGE"     ),
	POISSONNIER     ( 0, 0, 0,    1, 0, 0,    0, 1, 0,    1, 0, 0,    0, 0, 3,    4, 0,   "ECHANGE"     ),
	RESTAURANT      ( 0, 1, 0,    2, 0, 0,    0, 1, 0,    2, 0, 0,    0, 0, 0,    7, 4,   "ECHANGE"     ),
	PRETEURSURGAGE  ( 0, 0, 0,    3, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    5, 0,   "PRETSURGAGE" ),
	CATHEDRALE      ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    6, 0, 0,    0, 0, 0,   11, 0,   "SPECIAL"     ),
	RESIDENCE       ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    6, 0, 0,    2, 0,   "SPECIAL"     ),
	CHATEAU         ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    6, 0, 0,    0, 0, 0,    0, 0,   "SPECIAL"     ),
	TOURDEGARDE     ( 0, 0, 0,    3, 0, 0,    0, 0, 0,    3, 0, 0,    0, 0, 0,    0, 0,   "SPECIAL"     );

	private int iPoissonReq, iBleReq, iBoisReq, iPierreReq, iPceReq;
	private int iPoissonReA, iBleReA, iBoisReA, iPierreReA, iPceReA;
	private int iPoissonRec, iBleRec, iBoisRec, iPierreRec, iPceRec;
	private int iPtConstru, iPtRec;
	private String sCategorie;

	/**
	 * Constructeur d'un batiment prenant en paramètre des entiers
	 *
	 * @param iPoissonReq
	 *           Quantité de poisson requise pour la construction.
	 * @param iPoissonReA
	 *           Quantité de poisson nécessaire pour activation.
	 * @param iPoissonRec
	 *           Quantité de poisson en récompense après activation.
	 *
	 * @param iBleReq
	 *           Quantité de ble requise pour la construction.
	 * @param BleReA
	 *           Quantité de ble nécessaire pour activation.
	 * @param iBleRec
	 *           Quantité de ble en récompense après activation.
	 *
	 * @param iBoisReq
	 *           Quantité de bois requise pour la construction.
	 * @param iBoisReA
	 *           Quantité de bois nécessaire pour activation.
	 * @param iBoisRec
	 *           Quantité de bois en récompense après activation.
	 *
	 * @param iPierreReq
	 *           Quantité de pierre requise pour la construction.
	 * @param iPierreReA
	 *           Quantité de pierre nécessaire pour activation.
	 * @param iPierreRec
	 *           Quantité de pierre en récompense après activation.
	 *
	 * @param iPceReq
	 *           Quantité de piece requise pour la construction.
	 * @param iPceReA
	 *           Quantité de piece nécessaire pour activation.
	 * @param iPceRec
	 *           Quantité de piece en récompense après activation.
	 *
	 * @param iPtConstru
	 *           Quantité de Point en récompense après construction.
	 * @param iPtRec
	 *           Quantité de Point en récompense après activation.
	 * @param sCategorie
	 *           Catégorie du batiment, précise si il y a gain ou échange ou 
	 *           si c'est des ressources.
	 */
	BatimentInfo(
		     int iBleReq    , int iBleReA    , int iBleRec    ,
		     int iBoisReq   , int iBoisReA   , int iBoisRec   ,
	         int iPoissonReq, int iPoissonReA, int iPoissonRec,
	         int iPierreReq , int iPierreReA , int iPierreRec ,
	         int iPceReq    , int iPceReA    , int iPceRec    ,
	         int iPtConstru , int iPtRec     , String sCategorie
	        )
	{
		this.iPoissonReq    = iPoissonReq;
		this.iPoissonReA    = iPoissonReA;
		this.iPoissonRec    = iPoissonRec;

		this.iBleReq    = iBleReq;
		this.iBleReA    = iBleReA;
		this.iBleRec    = iBleRec;

		this.iBoisReq   = iBoisReq;
		this.iBoisReA   = iBoisReA;
		this.iBoisRec   = iBoisRec;

		this.iPierreReq = iPierreReq;
		this.iPierreReA = iPierreReA;
		this.iPierreRec = iPierreRec;

		this.iPceReA    = iPceReA;
		this.iPceReq    = iPceReq;
		this.iPceRec    = iPceRec;

		this.iPtConstru = iPtConstru;
		this.iPtRec     = iPtRec;

		this.sCategorie = sCategorie;
	}

	/**
	 * Accesseur sur la pierre en récompense pour l'activation
	 * @return un entier correspond à la quantité de pierre
	 */
	public int getPierreRec(){ return this.iPierreRec; }

	/**
	 * Accesseur sur le poisson en récompense pour l'activation
	 * @return un entier correspond à la quantité de poisson
	 */
	public int getPoissonRec   (){ return this.iPoissonRec   ; }

	/**
	 * Accesseur sur le ble en récompense pour l'activation
	 * @return un entier correspond à la quantité de ble
	 */
	public int getBleRec   (){ return this.iBleRec   ; }

	/**
	 * Accesseur sur le bois en récompense pour l'activation
	 * @return un entier correspond à la quantité de bois
	 */
	public int getBoisRec  (){ return this.iBoisRec  ; }

	/**
	 * Accesseur sur la pierre requise pour la construction
	 * @return un entier correspond à la quantité de pierre
	 */
	public int getPierreReq(){ return this.iPierreReq; }

	/**
	 * Accesseur sur le poisson requis pour la construction
	 * @return un entier correspond à la quantité de poisson
	 * 
	 */
	public int getPoissonReq(){ return this.iPoissonReq   ; }

	/**
	 * Accesseur sur le ble requise pour la construction
	 * @return un entier correspond à la quantité de ble
	 */
	public int getBleReq   (){ return this.iBleReq   ; }

	/**
	 * Accesseur sur le bois requise pour la construction
	 * @return un entier correspond à la quantité de bois
	 */
	public int getBoisReq  (){ return this.iBoisReq  ; }

	/**
	 * Accesseur sur les points obtenues après construction
	 * @return un entier correspond aux points obtenues
	 */
	public int getPtConstru(){ return this.iPtConstru; }

	/**
	 * Accesseur sur les points obtenues après activation
	 * @return un entier correspond aux points obtenues
	 */
	public int getPtRec    (){ return this.iPtRec    ; }

	/**
	 * Accesseur sur les pièces requises pour activation
	 * @return un entier correspond aux pièces requises
	 */
	public int getPcReq     (){ return this.iPceReq   ; }

	/**
	 * Accesseur sur les pièces obtenues en récompenses après activation
	 * @return un entier correspond aux pièces obtenues
	 */
	public int getPcRec     (){ return this.iPceRec   ; }
	
	/**
	 * Accesseur sur le ble nécessaire pour activation.
	 * @return un entier correspond à la quantité de ble
	 */
	public int getBleReA    (){ return this.iBleReA  ; }
	
	/**
	 * Accesseur sur le bois nécessaire pour activation.
	 * @return un entier correspond à la quantité de bois
	 */
	public int getBoisReA   (){ return this.iBoisReA  ; }
	
	/**
	 * Accesseur sur le poisson nécessaire pour activation.
	 * @return un entier correspond à la quantité de poisson
	 */
	public int getPoissonReA(){ return this.iPoissonReA  ; }
	
	/**
	 * Accesseur sur la pierre nécessaire pour activation.
	 * @return un entier correspond à la quantité de pierre
	 */
	public int getPierreReA  (){ return this.iPierreReA  ; }
	
	/**
	 * Accesseur sur les pieces nécessaire pour activation.
	 * @return un entier correspond à la quantité de piece
	 */
	public int getPcReA  (){ return this.iPceReA  ; }

	/**
	 * 
	 * Dit si le batiment est une ressource ou non
	 * @return true si le batiment est une ressource
	 */
	public boolean estRessource(){ return this.sCategorie.equals("RESSOURCE"); }

	/**
	 * 
	 * Dit si le batiment est un gain ou non
	 * @return true si le batiment fait gagner quelque chose sans contrepartie
	 */
	public boolean estGain(){ return this.sCategorie.equals("GAIN"); }

	/**
	 * 
	 * Dit si le batiment est un échange ou non
	 * @return true si le batiment fait gagner quelque chose en échange d'une autre
	 */
	public boolean estEchange(){ return this.sCategorie.equals("ECHANGE"); }

	/**
	 * 
	 * Dit si le batiment est un préteur sur gage ou non
	 * @return true si le batiment correspond au préteur sur gage
	 */
	public boolean estPreteurSurGage(){ return this.sCategorie.equals("PRETSURGAGE"); }

	/**
	 * 
	 * Dit si le batiment est un spécial ou non
	 * @return true si le batiment est spécial (cathédrale, résidence, château, tour de garde)
	 */
	public boolean estSpecial(){ return this.sCategorie.equals("SPECIAL"); }

	/**
	 * Retourne la quantité de ressource nécéssaire à l'activation dont le nom est passé en paramètre
	 *
	 * @return
	 *		la quantité ressource reçu après activation
	 */
	public int getRea(String sType)
	{
		int iVal = 0;

		switch ( sType )
		{
			case "BLE"    -> iVal = this.getBleReA    ();
			case "PIERRE" -> iVal = this.getPierreReA ();
			case "BOIS"   -> iVal = this.getBoisReA   ();
			case "POISSON"-> iVal = this.getPoissonReA();
			case "PIECE"  -> iVal = this.getPcReA     ();
		}

		return iVal;
	}
	
	/**
	 * Retourne la quantité de ressource reçu à l'activation dont le nom est passé en
	 * paramètre
	 *
	 * @return
	 *		la quantité ressource reçu après activation
	 */
	public int getRec(String sType)
	{
		int iVal = 0;

		switch ( sType )
		{
			case "BLE"    -> iVal = this.getBleRec    (); 
			case "PIERRE" -> iVal = this.getPierreRec (); 
			case "BOIS"   -> iVal = this.getBoisRec   (); 
			case "POISSON"-> iVal = this.getPoissonRec();
			case "PIECE"  -> iVal = this.getPcRec     ();
		}

		return iVal;
	}

	/**
	 * Retourne la quantité de ressource nécéssaire à la construction dont le nom est passé en
	 * paramètre
	 *
	 * @return
	 *		la quantité de ressource nécéssaire à la construction
	 */
	public int getReq(String sType)
	{
		int iVal = 0;

		switch ( sType )
		{
			case "BLE"    -> iVal = this.getBleReq    ();
			case "PIERRE" -> iVal = this.getPierreReq ();
			case "BOIS"   -> iVal = this.getBoisReq   ();
			case "POISSON"-> iVal = this.getPoissonReq();
			case "PIECE"  -> iVal = this.getPcReq     ();
		}

		return iVal;
	}
	/**
	 * Retourne la liste des informations des batiments
	 *
	 * @return
	 *		la liste des informations des batiments
	 */
	public static ArrayList<BatimentInfo> getLstBat()
	{
		ArrayList<BatimentInfo> alBat = new ArrayList<BatimentInfo>();
		for ( BatimentInfo b : BatimentInfo.values() )alBat.add(b);
		
		return alBat;
	}

	/**
	 * Permet de chercher un batiment depuis une chaine
	 * @param
	 *       Le type du batiment
	 * @return
	 *		les informations sur le batiment recherché
	 */
	public static BatimentInfo rechercherBatiment(String sBat)
	{
		for ( BatimentInfo bt : BatimentInfo.values() )
			if ( bt.name().equals(sBat)) return bt;

		return null;
	}
	/**
	 * Retourne une string avec toute les informations sur l'activation des batiments
	 *
	 * @return
	 *		une string avec toute les informations sur l'activation des batiments
	 */
	public String toStringInfoActivation()
	{
		String sRet = "";

		sRet += this.name() + " :\n";
		sRet += "+-------------------+---------+------+-----+-------+-------+\n";
		sRet += "|            PIERRE | POISSON | BOIS | BLÉ | PIECE | SCORE |\n";
		sRet += "+-------------------+---------+------+-----+-------+-------+\n";
		sRet += "|Requis     :" +
		        String.format("%7d", this.iPierreReA) + "|" + 
				String.format("%9d", this.iPoissonReA   ) + "|" +
				String.format("%6d", this.iBoisReA  ) + "|" +
				String.format("%5d", this.iBleReA   ) + "|" +
				String.format("%7d", this.iPceReA   ) + "|      0|\n";
		sRet += "+-------------------+---------+------+-----+-------+-------+\n";
		sRet += "|Recompense :" +
		        String.format("%7d", this.iPierreRec) + "|" + 
		        String.format("%9d", this.iPoissonRec   ) + "|" +
		        String.format("%6d", this.iBoisRec  ) + "|" +
		        String.format("%5d", this.iBleRec   ) + "|" +
		        String.format("%7d", this.iPceRec   ) + "|" +
				String.format("%7d", this.iPtRec    ) + "|\n";
		sRet += "+-------------------+---------+------+-----+-------+-------+\n";
		
		return sRet;
	}

	/**
	 * Retourne une string avec toute les informations sur la construction des batiments
	 *
	 * @return
	 *		une string avec toute les informations sur la construction des batiments
	 */
	public String toStringInfoConstruction()
	{
		String sRet = "";
	
		sRet += this.name() + " :\n";
		sRet += "+--------+---------+------+-----+-------+-------+\n";
		sRet += "| PIERRE | POISSON | BOIS | BLÉ | PIECE | SCORE |\n";
		sRet += "+--------+---------+------+-----+-------+-------+\n";
		sRet += String.format("| %7d", this.iPierreReq) + "|" + 
				String.format("%9d", this.iPoissonReq   ) + "|" +
				String.format("%6d", this.iBoisReq  ) + "|" +
				String.format("%5d", this.iBleReq   ) + "|" +
				String.format("%7d", this.iPceReq   ) + "|" +
				String.format("%7d", this.iPtConstru) + "|\n";
		sRet += "+--------+---------+------+-----+-------+-------+\n";

		return sRet;
	}
}
