package littletown.metier;

/**
 * Cette enum contient tous les batiments du jeu 
 * 
 * @author Equipe 11
 */

public enum Batiment
{
	//          pRq eRq blRq boRq pRc eRc blRc boRc ptCtr ptRc pcRq pcRc
	BAR         ( 2,  0,   2,   0,  0,  0,   0,   0,    7,   3,   0,   0),
	CHAMPSDEBLE ( 0,  0,   1,   0,  0,  0,   1,   0,    3,   0,   0,   0),
	LIBRAIRIE   ( 4,  0,   0,   0,  0,  0,   0,   0,    8,   0,   0,   3),
	MINEDOR     ( 1,  0,   0,   1,  0,  0,   0,   0,    4,   0,   0,   2),
	PONTON      ( 0,  0,   0,   3,  0,  2,   0,   0,    5,   0,   0,   0),
	PUIT        ( 1,  0,   0,   1,  0,  0,   0,   0,    4,   2,   0,   0),
	STATUE      ( 4,  0,   0,   0,  0,  0,   0,   0,   10,   0,   0,   0);
	
	private int iEauReq, iBleReq, iBoisReq, iPierreReq;
	private int iEauRec, iBleRec, iBoisRec, iPierreRec;
	private int iPtConstru, iPtRec, iPceReq, iPceRec  ;

	/**
	 * Constructeur d'un batiment prenant en paramètre des entiers
	 * @param iPierreReq
	 *           quantite de pierre requise pour la construction
	 * @param iEauReq
	 *           quantite d'eau requise pour la construction
	 * @param iBleReq
	 *           quantite de ble requise pour la construction
	 * @param iPierreRec
	 *           quantite de pierre en récompense après activation
	 * @param iEauRec
	 *           quantite d'eau en récompense après activation
	 * @param iBleRec
	 *           quantite de ble en récompense après activation
	 * @param iBoisRec
	 *           quantite de bois en récompense après activation
	 * @param iPtConstru
	 *           quantite de points de victoire obtenu après construction
	 * @param iPtRec
	 *           quantite de points de victoire obtenu après activation
	 * @param iPceReq
	 *           quantite de piece requise pour activation
	 */
	Batiment(int iPierreReq, int iEauReq, int iBleReq, int iBoisReq,
			 int iPierreRec, int iEauRec, int iBleRec, int iBoisRec,
			 int iPtConstru, int iPtRec , int iPceReq, int iPceRec)
	{
		this.iPierreReq = iPierreReq;
		this.iEauReq    = iEauReq   ;
		this.iBleReq    = iBleReq   ;
		this.iBoisReq   = iBoisReq  ;

		this.iPierreRec = iPierreRec;
		this.iEauRec    = iEauRec   ;
		this.iBleRec    = iBleRec   ;
		this.iBoisRec   = iBoisRec  ;

		this.iPtConstru = iPtConstru;
		this.iPtRec     = iPtRec    ;

		this.iPceRec    = iPceRec;
		this.iPceReq    = iPceReq;
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
}
