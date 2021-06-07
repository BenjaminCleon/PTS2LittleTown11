//package code.metier;

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

	public int getPierreRec(){ return this.iPierreRec; }
	public int getEauRec   (){ return this.iEauRec   ; }
	public int getBleRec   (){ return this.iBleRec   ; }
	public int getBoisRec  (){ return this.iBoisRec  ; }

	public int getPierreReq(){ return this.iPierreReq; }
	public int getEauReq   (){ return this.iEauReq   ; }
	public int getBleReq   (){ return this.iBleReq   ; }
	public int getBoisReq  (){ return this.iBoisReq  ; }

	public int getPtConstru(){ return this.iPtConstru; }
	public int getPtRec    (){ return this.iPtRec    ; }

	public int getPcReq    (){ return this.iPceReq   ; }
	public int getPcRec    (){ return this.iPceRec   ; }
}
