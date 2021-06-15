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
        alBat.add(BatimentInfo.BOULANGERIE   );
        alBat.add(BatimentInfo.PUITS         );
        alBat.add(BatimentInfo.MINEDOR       );
        alBat.add(BatimentInfo.ENTREPOT      );
        alBat.add(BatimentInfo.POISSONNIER   );
        alBat.add(BatimentInfo.FOIRE         );
        alBat.add(BatimentInfo.RESTAURANT    );
        alBat.add(BatimentInfo.GRENIER       );
        alBat.add(BatimentInfo.CHAMPSDEBLE   );

        return alBat;
    }

    public static ArrayList<BatimentInfo> getPioche3()
    {
        ArrayList<BatimentInfo> alBat = new ArrayList<BatimentInfo>();
        

        return alBat;
    }
}
