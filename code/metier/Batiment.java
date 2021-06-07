//package code.metier;

public enum Batiment
{
	BAR         ( 2, 0, 2, 0, 0, 0, 0, 0, 7, 3),
	CHAMPSDEBLE ( 0, 0, 1, 0, 0, 0, 1, 0, 3, 0);

	private int iEauReq, iBleReq, iBoisReq, iPierreReq;
	private int iEauRec, iBleRec, iBoisRec, iPierreRec;
	private int iPtConstru, iPtRec;

	Batiment(int iPierreReq, int iEauReq, int iBleReq, int iBoisReq,
			 int iPierreRec, int iEauRec, int iBleRec, int iBoisRec,
			 int iPtConstru, int iPtRec )
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

	public String toString()
	{
		return this.name() + this.getPierreReq() + "|" + this.getEauReq() + "|" + this.getBleReq() + "|" + this.getBoisReq();
	}
}
