package classes;

import java.util.*;

public class Battle {

    List<Soldier> soldierList1 = new ArrayList<>();
    List<Soldier> soldierList2 = new ArrayList<>();
    General general1 = new General("Armia 1", 1000, soldierList1, this);
    General general2 = new General("Armia 2", 1000, soldierList2, this);

    public General getGeneral1() {
        return general1;
    }

    public General getGeneral2() {
        return general2;
    }


    public Battle() {



        Soldier soldier1 = new Soldier("Żołnierz 1",Ranks.Serial, 3, 3);
        Soldier soldier2 = new Soldier("Żołnierz 2",Ranks.Serial, 3, 3);
        Soldier soldier3 = new Soldier("Żołnierz 3",Ranks.Capral, 2, 4);

        Soldier soldier4 = new Soldier("Żołnierz 4",Ranks.Serial, 3, 3);
        Soldier soldier5 = new Soldier("Żołnierz 5",Ranks.Serial, 3, 3);
        Soldier soldier6 = new Soldier("Żołnierz 6",Ranks.Capitan, 2, 6);

        general1.addNewSoldier(general1,soldier1);
        general1.addNewSoldier(general1,soldier2);
        general1.addNewSoldier(general1,soldier3);

        general2.addNewSoldier(general2,soldier4);
        general2.addNewSoldier(general2,soldier5);
        general2.addNewSoldier(general2,soldier6);


        general1.buySoldier(general1,Ranks.Major);
        general2.buySoldier(general2,Ranks.Capitan);
        general1.armyManeuver(general1);
        general1.armyManeuver(general1);


        general1.attackOtherGeneral(general1, general2);
        general1.attackOtherGeneral(general1, general2);


    }

}