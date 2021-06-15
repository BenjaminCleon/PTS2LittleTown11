package equipe_11.scenario;

import equipe_11.BatimentInfo;

import java.util.ArrayList;

public class EnsemblePioche
{
	private EnsemblePioche(){}
	
	public static ArrayList<BatimentInfo> getPioche2()
	{
		ArrayList<BatimentInfo> alBat = new ArrayList<BatimentInfo>();

		alBat.add(BatimentInfo.RESIDENCE     );
		alBat.add(BatimentInfo.CATHEDRALE    );
		alBat.add(BatimentInfo.BOULANGERIE   );
		alBat.add(BatimentInfo.PRETEURSURGAGE);
		alBat.add(BatimentInfo.BAR           );
		alBat.add(BatimentInfo.EPICERIE      );
		alBat.add(BatimentInfo.CHARPENTIER   );
		alBat.add(BatimentInfo.EGLISE        );
		alBat.add(BatimentInfo.FOIRE         );
		alBat.add(BatimentInfo.LIBRAIRIE     );
		alBat.add(BatimentInfo.POISSONNIER   );
		alBat.add(BatimentInfo.RESTAURANT    );
		alBat.add(BatimentInfo.CHAMPSDEBLE   );

		return alBat;
	}

	public static ArrayList<BatimentInfo> getPioche3()
	{
		ArrayList<BatimentInfo> alBat = new ArrayList<BatimentInfo>();
		
		alBat.add(BatimentInfo.CHATEAU       );
		alBat.add(BatimentInfo.TOURDEGARDE   );
		alBat.add(BatimentInfo.CARRIERE      );
		alBat.add(BatimentInfo.ATELIER       );
		alBat.add(BatimentInfo.BRASSERIE     );
		alBat.add(BatimentInfo.ENTREPOT      );
		alBat.add(BatimentInfo.FONTAINE      );
		alBat.add(BatimentInfo.MINEDOR       );
		alBat.add(BatimentInfo.PONTON        );
		alBat.add(BatimentInfo.GRENIER       );
		alBat.add(BatimentInfo.PUITS         );
		alBat.add(BatimentInfo.STATUE        );
		alBat.add(BatimentInfo.CHAMPSDEBLE   );

		return alBat;
	}
}
