package equipe_11.metier;

/**
 * Cette enum contient tous les batiments du jeu 
 * 
 * @author Equipe 11
 */

public enum BatimentInfo
{
	/**
	 * // Ble
	 * blRqC : ble requi         à la construction
	 * blRqA : ble requi         à l'activation
	 * blRc  : ble en recompense à l'activation
	 * 
	 * // Bois
	 * boRqC : bois requi         à la construction
	 * boRqA : bois requi         à l'activation
	 * boRc  : bois en recompense à l'activation
	 * 
	 * // Eau
	 * eRqC  : eau requi         à la construction
	 * eRqA  : eau requi         à l'activation
	 * eRc   : eau en recompense à l'activation
	 * 
	 * // Pierre
	 * pRqC  : pierre requi         à la construction
	 * pRqA  : pierre requi         à l'activation
	 * pRc   : pierre en recompense à l'activation
	 * 
	 * // Piece
	 * pcRqC : piece  requi         à la construction
	 * pcRqA : piece  requi         à l'activation
	 * pcRc  : piece  en recompense à l'activation	
	 * 
	 * // Point
	 * ptCtr : point  reçu          à la construction
	 * ptRc  : point  en recompense à l'activation
	 * 
	 * // Ressource
	 * Si c'est une ressource ou non
	 */
	//              Ble        Bois         Eau        Pierre      Piece      Point  Ressource
	//            R  R  R     R  R  R     R  R  R     R  R  R     R  R  R     P  P
	//            q  q  c     q  q  c     q  q  c     q  q  c     q  q  c     t  t
	//            C  A        C  A        C  A        C  A        C  A        C  A
	BLE         ( 0, 0, 1,    0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0,   true  ),
	PIERRE      ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0,   true  ),
	BOIS        ( 0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0,   true  ),
	EAU         ( 0, 0, 0,    0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0, 0,    0, 0,   true  ),
	BAR         ( 2, 0, 0,    0, 0, 0,    0, 0, 0,    2, 0, 0,    0, 0, 0,    7, 3,   false ),
	CHAMPSDEBLE ( 0, 0, 1,    1, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    3, 0,   false ),
	LIBRAIRIE   ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 0, 3,    8, 0,   false ),
	MINEDOR     ( 0, 0, 0,    1, 0, 0,    0, 0, 0,    1, 0, 0,    0, 0, 2,    4, 0,   false ),
	PONTON      ( 0, 0, 0,    3, 0, 0,    0, 0, 2,    0, 0, 0,    0, 0, 0,    5, 0,   false ),
	PUIT        ( 0, 0, 0,    1, 0, 0,    0, 0, 0,    1, 0, 0,    0, 0, 0,    4, 2,   false ),
	STATUE      ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 0, 0,   10, 0,   false ),
	ATELIER     ( 0, 0, 0,    0, 2, 0,    0, 0, 0,    2, 0, 0,    0, 0, 0,    5, 3,   false ),
	BOULANGERIE ( 0, 1, 0,    2, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 4,    4, 0,   false ),
	BRASSERIE   ( 0, 1, 0,    2, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 3,   false ),
	CARRIERE    ( 0, 0, 0,    3, 0, 0,    0, 0, 0,    0, 0, 2,    0, 2, 0,    5, 0,   false ),
	CHARPENTIER ( 0, 0, 0,    2, 0, 3,    0, 0, 0,    0, 0, 0,    0, 1, 0,    4, 0,   false ),
	EPICERIE    ( 0, 0, 1,    2, 0, 0,    0, 0, 1,    0, 0, 0,    0, 1, 0,    4, 0,   false ),
	ENTREPOT    ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 2, 0,    0, 0, 0,    8, 5,   false ),
	EGLISE      ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 3, 0,    8, 5,   false ),
	FOIRE       ( 0, 1, 0,    4, 1, 0,    0, 1, 0,    0, 1, 0,    0, 0, 0,    6, 7,   false ),
	FONTAINE    ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    2, 0, 0,    0, 1, 0,    5, 3,   false ),
	GRENIER     ( 0, 2, 0,    4, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    5, 6,   false ),
	POISSONNIER ( 0, 0, 0,    1, 0, 0,    0, 1, 0,    1, 0, 0,    0, 0, 3,    4, 0,   false ),
	RESTAURANT  ( 0, 1, 0,    2, 0, 0,    0, 1, 0,    2, 0, 0,    0, 0, 0,    7, 4,   false );

	private int iEauReq, iBleReq, iBoisReq, iPierreReq, iPceReq;
	private int iEauReA, iBleReA, iBoisReA, iPierreReA, iPceReA;
	private int iEauRec, iBleRec, iBoisRec, iPierreRec, iPceRec;

	private int iPtConstru, iPtRec;
	private boolean bRessource;
	
	private int[] tabInfoBati;

	/**
	 * Constructeur d'un batiment prenant en paramètre des entiers
	 *
	 * @param iEauReq
	 *           Quantite d'eau requise pour la construction.
	 * @param iEauReA
	 *           Quantite d'eau nécessaire pour activation.
	 * @param iEauRec
	 *           Quantite d'eau en récompense après activation.
	 *
	 * @param iBleReq
	 *           Quantite de ble requise pour la construction.
	 * @param BleReA
	 *           Quantite de ble nécessaire pour activation.
	 * @param iBleRec
	 *           Quantite de ble en récompense après activation.
	 *
	 * @param iBoisReq
	 *           Quantite de bois requise pour la construction.
	 * @param iBoisReA
	 *           Quantite de bois nécessaire pour activation.
	 * @param iBoisRec
	 *           Quantite de bois en récompense après activation.
	 *
	 * @param iPierreReq
	 *           Quantite de pierre requise pour la construction.
	 * @param iPierreReA
	 *           Quantite de pierre nécessaire pour activation.
	 * @param iPierreRec
	 *           Quantite de pierre en récompense après activation.
	 *
	 * @param iPceReq
	 *           Quantite de piece requise pour la construction.
	 * @param iPceReA
	 *           Quantite de piece nécessaire pour activation.
	 * @param iPceRec
	 *           Quantite de piece en récompense après activation.
	 *
	 * @param iPtConstru
	 *           Quantite de Point en récompense après construction.
	 * @param iPtRec
	 *           Quantite de Point en récompense après activation.
	 * @param
	 *           Si c'est une ressource
	 */
	BatimentInfo(
	         int iBleReq   , int iBleReA   , int iBleRec   ,
	         int iBoisReq  , int iBoisReA  , int iBoisRec  ,
	         int iEauReq   , int iEauReA   , int iEauRec   ,
	         int iPierreReq, int iPierreReA, int iPierreRec,
	         int iPceReA   , int iPceReq   , int iPceRec   ,
	         int iPtConstru, int iPtRec    , boolean bRessource
	        )
	{
		tabInfoBati = new int[ 17 ];		
		
		this.iBleReq    = tabInfoBati[ 0] = iBleReq;
		this.iBleReA    = tabInfoBati[ 1] = iBleReA;
		this.iBleRec    = tabInfoBati[ 2] = iBleRec;

		this.iBoisReq   = tabInfoBati[ 3] = iBoisReq;
		this.iBoisReA   = tabInfoBati[ 4] = iBoisReA;
		this.iBoisRec   = tabInfoBati[ 5] = iBoisRec;
		
		this.iEauReq    = tabInfoBati[ 6] = iEauReq;
		this.iEauReA    = tabInfoBati[ 7] = iEauReA;
		this.iEauRec    = tabInfoBati[ 8] = iEauRec;

		this.iPierreReq = tabInfoBati[ 9] = iPierreReq;
		this.iPierreReA = tabInfoBati[10] = iPierreReA;
		this.iPierreRec = tabInfoBati[11] = iPierreRec;

		this.iPceReA    = tabInfoBati[12] = iPceReA;
		this.iPceReq    = tabInfoBati[13] = iPceReq;
		this.iPceRec    = tabInfoBati[14] = iPceRec;

		this.iPtConstru = tabInfoBati[15] = iPtConstru;
		this.iPtRec     = tabInfoBati[16] = iPtRec;

		this.bRessource = bRessource;
	}

	/**
	 * Accesseur sur la pierre en récompense pour l'activation
	 * @return un entier correspond à la quantité de pierre
	 */
	public int getPierreRec(){ return this.iPierreRec; }

	/**
	 * Accesseur sur l'eau en récompense pour l'activation
	 * @return un entier correspond à la quantité d'eau
	 */
	public int getEauRec   (){ return this.iEauRec   ; }

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
	 * Accesseur sur l'eau requise pour la construction
	 * @return un entier correspond à la quantité d'eau
	 */
	public int getEauReq   (){ return this.iEauReq   ; }

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
	public int getPcReq    (){ return this.iPceReq   ; }

	/**
	 * Accesseur sur les pièces obtenues en récompenses après activation
	 * @return un entier correspond aux pièces obtenues
	 */
	public int getPcRec    (){ return this.iPceRec   ; }
	
	/**
	 * Accesseur sur le ble nécessaire pour activation.
	 * @return un entier correspond à la quantité de ble
	 */
	public int getBleReA  (){ return this.iBleReA  ; }
	
	/**
	 * Accesseur sur le bois nécessaire pour activation.
	 * @return un entier correspond à la quantité de bois
	 */
	public int getBoisReA  (){ return this.iBoisReA  ; }
	
	/**
	 * Accesseur sur l'eau nécessaire pour activation.
	 * @return un entier correspond à la quantité d'eau
	 */
	public int getEauReA  (){ return this.iEauReA  ; }
	
	/**
	 * Accesseur sur la pierre nécessaire pour activation.
	 * @return un entier correspond à la quantité de pierre
	 */
	public int getPierreReA  (){ return this.iPierreReA  ; }
	
	/**
	 * Accesseur sur les pieces nécessaire pour activation.
	 * @return un entier correspond à la quantité de piece
	 */
	public int getPieceReA  (){ return this.iPceReA  ; }

	/**
	 * 
	 * Dit si le batiment est une ressource ou non
	 * @return true si le batiment est une ressource
	 */
	public boolean estRessource(){ return this.bRessource; }

	/**
	 * Permet de chercher un batiment depuis une chaine
	 * @param
	 *       Le type du batiment
	 */
	public static BatimentInfo rechercherBatiment(String sBat)
	{
		for ( BatimentInfo bt : BatimentInfo.values() )
			if ( bt.name().equals(sBat)) return bt;

		return null;
	}
/*
	this.getSaisie()
*/
	public static String getLstBat()
	{
		String sRet = "";
		
		for ( BatimentInfo bt : BatimentInfo.values() )
			sRet += bt.name() + "\n";
		
		return sRet;
	}

	public String toString()
	{
		String sRet = "";

		String CoutConstru    = "";
		String CoutActivation = "";

		String RecompenseActivation   = "";
		String RecompenseConstruction = "";

		for( int cpt=0; cpt < this.tabInfoBati.length; cpt++ )
		{
			if( this.tabInfoBati[cpt] == 0 )
			{
				sRet += "";
			}
			else
			{
				
				switch( cpt )
				{
					case  0 -> { CoutConstru          += "  Ble    : " + this.tabInfoBati[cpt] +"\n"; }
					case  1 -> { CoutActivation       += "  Ble    : " + this.tabInfoBati[cpt] +"\n"; }
					case  2 -> { RecompenseActivation += "  Ble    : " + this.tabInfoBati[cpt] +"\n"; }
					
					case  3 -> { CoutConstru          += "  Bois   : " + this.tabInfoBati[cpt] +"\n"; }
					case  4 -> { CoutActivation       += "  Bois   : " + this.tabInfoBati[cpt] +"\n"; }
					case  5 -> { RecompenseActivation += "  Bois   : " + this.tabInfoBati[cpt] +"\n"; }
					
					case  6 -> { CoutConstru          += "  Eau    : " + this.tabInfoBati[cpt] +"\n"; }
					case  7 -> { CoutActivation       += "  Eau    : " + this.tabInfoBati[cpt] +"\n"; }
					case  8 -> { RecompenseActivation += "  Eau    : " + this.tabInfoBati[cpt] +"\n"; }
					
					case  9 -> { CoutConstru          += "  Pierre : " + this.tabInfoBati[cpt] +"\n"; }
					case 10 -> { CoutActivation       += "  Pierre : " + this.tabInfoBati[cpt] +"\n"; }
					case 11 -> { RecompenseActivation += "  Pierre : " + this.tabInfoBati[cpt] +"\n"; }
					
					case 12 -> { CoutConstru          += "  Piece  : " + this.tabInfoBati[cpt] +"\n"; }
					case 13 -> { CoutActivation       += "  Piece  : " + this.tabInfoBati[cpt] +"\n"; }
					case 14 -> { RecompenseActivation += "  Piece  : " + this.tabInfoBati[cpt] +"\n"; }
					
					case 15 -> { RecompenseConstruction += "  Point  : " + this.tabInfoBati[cpt] +"\n"; }
					case 16 -> { RecompenseActivation   += "  Point  : " + this.tabInfoBati[cpt] +"\n"; }
				}
			}
		}

		sRet += this.name() + " : "                                         + "\n" +
		        "CoutConstru : "            + "\n" + CoutConstru            + "\n" +
		        "CoutActivation : "         + "\n" + CoutActivation         + "\n" +
		        "RecompenseActivation : "   + "\n" + RecompenseActivation   + "\n" +
		        "RecompenseConstruction : " + "\n" + RecompenseConstruction          ;

		return sRet;
	}
}
