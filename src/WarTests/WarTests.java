package WarTests;
import classes.*;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarTests {
    Battle battle=new Battle();

    @Test
    public void rankTest(){
        Soldier soldier=new Soldier("Żołnierz 1",Ranks.Serial,5,5);
        soldier.updateRank(soldier);
        assertEquals(Ranks.Capral,soldier.getRanks());
    }
    @Test
    public void experienceTest(){
        Soldier soldier=new Soldier("Żołnierz 1",Ranks.Serial,5,5);
        soldier.updateRank(soldier);
        assertEquals(1,soldier.getExperience());
    }
    @Test
    public void armyManeuverCostTest(){
        List<Soldier> soldierList = new ArrayList<Soldier>();
        Soldier soldier=new Soldier("Żołnierz 1",Ranks.Serial,4,4);
        Soldier soldier2=new Soldier("Żołnierz 2",Ranks.Serial,3,3);
        Soldier soldier3=new Soldier("Żołnierz 3",Ranks.Capral,2,4);

        soldierList.add(soldier);
        soldierList.add(soldier2);
        soldierList.add(soldier3);
        General general=new General("Armia 1",1000,soldierList,battle);

        general.armyManeuver(general);
        assertEquals(996,general.getCoins());
        assertEquals(12,general.getTotalForceArmy());
    }
    @Test
    public void soldierExperienceUpdate(){
        List<Soldier> soldierList = new ArrayList<Soldier>();
        Soldier soldier=new Soldier("Żołnierz 1",Ranks.Serial,4,5);
        soldierList.add(soldier);

        General general=new General("Armia 1",1000,soldierList,battle);
        general.armyManeuver(general);

        soldier.updateRank(soldier);

        assertEquals(1,soldier.getExperience());
        assertEquals(Ranks.Capral,soldier.getRanks());
    }

    @Test
    public void soldierExperienceUpdateFive(){
        List<Soldier> soldierList = new ArrayList<Soldier>();
        Soldier soldier=new Soldier("Żołnierz 1",Ranks.Capral,6,12);
        soldierList.add(soldier);

        General general=new General("Armia 1",1000,soldierList,battle);

        for (int i = 0; i < 5; i++){
            general.armyManeuver(general);
            soldier.updateRank(soldier);
        }

        assertEquals(2,soldier.getExperience());
        assertEquals(Ranks.Capitan,soldier.getRanks());
    }

    @Test
    public void buyNewSoldier(){
        List<Soldier> soldierList1 = new ArrayList<Soldier>();
        Soldier soldier1 = new Soldier("Żołnierz 1",Ranks.Serial, 4, 4);

        soldierList1.add(soldier1);

        General general=new General("Armia 1",1000,soldierList1,battle);
        general.buySoldier(general,Ranks.Capral);

        assertEquals("[ranks=Serial," +
                " experience=4," +
                " force=4," +
                " ranks=Capral," +
                " experience=1," +
                " force=2]",soldierList1.toString());
    }

    @Test
    public void testMoneyAfterShopping(){
        List<Soldier> soldierList1 = new ArrayList<Soldier>();
        General general=new General("Armia 1",1000,soldierList1,battle);
        general.buySoldier(general,Ranks.Capral);

        assertEquals(980,general.getCoins());
    }

    @Test
    public void testMoneyAfterShoppingAllSoldier(){
        List<Soldier> soldierList1 = new ArrayList<Soldier>();
        General general=new General("Armia 1",1000,soldierList1,battle);
        general.buySoldier(general,Ranks.Capral);
        general.buySoldier(general,Ranks.Serial);
        general.buySoldier(general,Ranks.Major);
        general.buySoldier(general,Ranks.Capitan);

        assertEquals(900,general.getCoins());
    }

    @Test
    public void testForceArmy(){
        List<Soldier> soldierList1 = new ArrayList<Soldier>();
        General general=new General("Armia 1",1000,soldierList1,battle);
        Soldier soldier1 = new Soldier("Żołnierz 1",Ranks.Serial, 4, 4);
        soldierList1.add(soldier1);
        general.buySoldier(general,Ranks.Capral);
        general.buySoldier(general,Ranks.Serial);
        general.buySoldier(general,Ranks.Major);
        general.buySoldier(general,Ranks.Major);

        assertEquals(15,general.getTotalForceArmy());
    }

    @Test
    public void testChangeOfForce(){
        Soldier soldier1 = new Soldier("Żołnierz 1",Ranks.Serial, 3, 3);
        Soldier soldier2 = new Soldier("Żołnierz 2",Ranks.Serial, 3, 3);
        Soldier soldier3 = new Soldier("Żołnierz 3",Ranks.Capral, 2, 4);

        Soldier soldier4 = new Soldier("Żołnierz 4",Ranks.Serial, 3, 4);
        Soldier soldier5 = new Soldier("Żołnierz 5",Ranks.Serial, 3, 3);
        Soldier soldier6 = new Soldier("Żołnierz 6",Ranks.Capitan, 2, 6);

        List<Soldier> soldierList1 = new ArrayList<>();
        List<Soldier> soldierList2 = new ArrayList<>();

        soldierList1.add(soldier1);
        soldierList1.add(soldier2);
        soldierList1.add(soldier3);

        soldierList2.add(soldier4);
        soldierList2.add(soldier5);
        soldierList2.add(soldier6);

        General general1=new General("Armia 1",1000,soldierList1,battle);
        General general2=new General("Armia 2",1000,soldierList2,battle);
        general1.attackOtherGeneral(general1,general2);
        assertEquals(6,general1.getTotalForceArmy());
        assertEquals(17,general2.getTotalForceArmy());
    }

    @Test
    public void testGetMoneyAfterWar(){
        Soldier soldier1 = new Soldier("Żołnierz 1",Ranks.Serial, 3, 3);
        Soldier soldier2 = new Soldier("Żołnierz 2",Ranks.Serial, 3, 3);
        Soldier soldier3 = new Soldier("Żołnierz 3",Ranks.Capral, 2, 4);

        Soldier soldier4 = new Soldier("Żołnierz 4",Ranks.Serial, 3, 4);
        Soldier soldier5 = new Soldier("Żołnierz 5",Ranks.Serial, 3, 3);
        Soldier soldier6 = new Soldier("Żołnierz 6",Ranks.Capitan, 2, 6);

        List<Soldier> soldierList1 = new ArrayList<>();
        List<Soldier> soldierList2 = new ArrayList<>();

        soldierList1.add(soldier1);
        soldierList1.add(soldier2);
        soldierList1.add(soldier3);

        soldierList2.add(soldier4);
        soldierList2.add(soldier5);
        soldierList2.add(soldier6);

        General general1=new General("Armia 1",1000,soldierList1,battle);
        General general2=new General("Armia 2",1000,soldierList2,battle);
        general1.attackOtherGeneral(general1,general2);

        assertEquals(1100,general2.getCoins());
    }
    @Test
    public void mixElementsFromListAndDeleteOne(){
        Soldier soldier1 = new Soldier("Żołnierz 1",Ranks.Serial, 3, 3);
        Soldier soldier2 = new Soldier("Żołnierz 2",Ranks.Serial, 3, 3);
        Soldier soldier3 = new Soldier("Żołnierz 3",Ranks.Capral, 2, 4);

        Soldier soldier4 = new Soldier("Żołnierz 4",Ranks.Serial, 3, 3);
        Soldier soldier5 = new Soldier("Żołnierz 5",Ranks.Serial, 3, 3);
        Soldier soldier6 = new Soldier("Żołnierz 6",Ranks.Capral, 2, 4);

        List<Soldier> soldierList1 = new ArrayList<>();
        List<Soldier> soldierList2 = new ArrayList<>();

        soldierList1.add(soldier1);
        soldierList1.add(soldier2);
        soldierList1.add(soldier3);

        soldierList2.add(soldier4);
        soldierList2.add(soldier5);
        soldierList2.add(soldier6);

        General general1=new General("Armia 1",1000,soldierList1,battle);
        General general2=new General("Armia 2",1000,soldierList2,battle);
        general1.attackOtherGeneral(general1,general2);

        assertEquals(2,general2.getSoldierList().size());

    }
    @Test
    public void removeIfExperienceAfterBattleIsZero(){
        Soldier soldier1 = new Soldier("Żołnierz 1",Ranks.Serial, 3, 3);
        Soldier soldier2 = new Soldier("Żołnierz 2",Ranks.Serial, 3, 3);

        Soldier soldier4 = new Soldier("Żołnierz 3",Ranks.Serial, 3, 3);
        Soldier soldier3 = new Soldier("Żołnierz 4",Ranks.Serial, 1, 1);

        List<Soldier> soldierList1 = new ArrayList<>();
        List<Soldier> soldierList2 = new ArrayList<>();

        soldierList1.add(soldier1);
        soldierList1.add(soldier2);
        soldierList2.add(soldier3);
        soldierList2.add(soldier4);

        General general1=new General("Armia 1",1000,soldierList1,battle);
        General general2=new General("Armia 2",1000,soldierList2,battle);
        general1.attackOtherGeneral(general1,general2);

        assertEquals(
                "[ranks=Serial," +
                        " experience=2," +
                        " force=2]" ,general2.getSoldierList().toString());

    }



}