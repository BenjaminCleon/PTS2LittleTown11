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
	 */
	//              Ble        Bois         Eau        Pierre      Piece      Point
	//            R  R  R     R  R  R     R  R  R     R  R  R     R  R  R     P  P
	//            q  q  c     q  q  c     q  q  c     q  q  c     q  q  c     t  t
	//            C  A        C  A        C  A        C  A        C  A        C  A
	BLE         ( 0, 0, 1,    0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0 ),
	PIERRE      ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0 ),
	BOIS        ( 0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0 ),
	EAU         ( 0, 0, 0,    0, 0, 0,    0, 0, 1,    0, 0, 0,    0, 0, 0,    0, 0 ),
	BAR         ( 2, 0, 0,    0, 0, 0,    0, 0, 0,    2, 0, 0,    0, 0, 0,    7, 3 ),
	CHAMPSDEBLE ( 0, 0, 1,    1, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    3, 0 ),
	LIBRAIRIE   ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 0, 3,    8, 0 ),
	MINEDOR     ( 0, 0, 0,    1, 0, 0,    0, 0, 0,    1, 0, 0,    0, 0, 2,    4, 0 ),
	PONTON      ( 0, 0, 0,    3, 0, 0,    0, 0, 2,    0, 0, 0,    0, 0, 0,    5, 0 ),
	PUIT        ( 0, 0, 0,    1, 0, 0,    0, 0, 0,    1, 0, 0,    0, 0, 0,    4, 2 ),
	STATUE      ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 0, 0,   10, 0 ),
	ATELIER     ( 0, 0, 0,    0, 2, 0,    0, 0, 0,    2, 0, 0,    0, 0, 0,    5, 3 ),
	BOULANGERIE ( 0, 1, 0,    2, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 4,    4, 0 ),
	BRASSERIE   ( 0, 1, 0,    2, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 3 ),
	CARRIERE    ( 0, 0, 0,    3, 0, 0,    0, 0, 0,    0, 0, 2,    0, 2, 0,    5, 0 ),
	CHARPENTIER ( 0, 0, 0,    2, 0, 3,    0, 0, 0,    0, 0, 0,    0, 1, 0,    4, 0 ),
	EPICERIE    ( 0, 0, 1,    2, 0, 0,    0, 0, 1,    0, 0, 0,    0, 1, 0,    4, 0 ),
	ENTREPOT    ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 2, 0,    0, 0, 0,    8, 5 ),
	EGLISE      ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    4, 0, 0,    0, 3, 0,    8, 5 ),
	FOIRE       ( 0, 1, 0,    4, 1, 0,    0, 1, 0,    0, 1, 0,    0, 0, 0,    6, 7 ),
	FONTAINE    ( 0, 0, 0,    0, 0, 0,    0, 0, 0,    2, 0, 0,    0, 1, 0,    5, 3 ),
	GRENIER     ( 0, 2, 0,    4, 0, 0,    0, 0, 0,    0, 0, 0,    0, 0, 0,    5, 6 ),
	POISSONNIER ( 0, 0, 0,    1, 0, 0,    0, 1, 0,    1, 0, 0,    0, 0, 3,    4, 0 ),
	RESTAURANT  ( 0, 1, 0,    2, 0, 0,    0, 1, 0,    2, 0, 0,    0, 0, 0,    7, 4 );

	private int iEauReq, iBleReq, iBoisReq, iPierreReq, iPceReq;
	private int iEauReA, iBleReA, iBoisReA, iPierreReA, iPceReA;
	private int iEauRec, iBleRec, iBoisRec, iPierreRec, iPceRec;

	private int iPtConstru, iPtRec;
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
	 */
	BatimentInfo(
	         int iEauReq   , int iEauReA   , int iEauRec   ,
	         int iBleReq   , int iBleReA   , int iBleRec   ,
	         int iBoisReq  , int iBoisReA  , int iBoisRec  ,
	         int iPierreReq, int iPierreReA, int iPierreRec,
	         int iPceReA   , int iPceReq   , int iPceRec   ,
	         int iPtConstru, int iPtRec
	        )
	{
		this.iEauReq    = iEauReq;
		this.iEauReA    = iEauReA;
		this.iEauRec    = iEauRec;

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
}
