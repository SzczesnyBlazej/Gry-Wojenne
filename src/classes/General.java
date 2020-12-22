package classes;
import java.util.*;
import java.util.List;


public class General {
    private String armyName;
    private double coins;
    private List<Soldier> soldierList;
    private Battle battle;

    public General(String armyName, double coins, List<Soldier> soldierList, Battle battle) {
        this.armyName = armyName;
        this.coins = coins;
        this.soldierList = soldierList;
        this.battle = battle;
    }

    public String getArmyName() {
        return armyName;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public List<Soldier> getSoldierList() {
        return soldierList;
    }

    @Override
    public String toString() {
        return soldierList.toString();
    }

    public void armyManeuver(General general){
        int coinsThisGeneral=0;
        Sekretarz.armyManeuverAlert(general);
        for(Soldier soldier:soldierList){
            soldier.setExperience(soldier.getExperience()+1);
            Sekretarz.updateExperienceSoldier(soldier);
            coinsThisGeneral=coinsThisGeneral+soldier.getRanks().getValue();
            soldier.updateRank(soldier);
        }
        for(Soldier soldier:soldierList){
            soldier.setForce(soldier.getExperience()*soldier.getRanks().getValue());
        }
        this.setCoins(this.getCoins() - coinsThisGeneral) ;
    }


    public void buySoldier(General general,Ranks type) {
        Soldier soldier=new Soldier("Żołnierz X",type,1,type.getValue());
        this.coins=this.coins-(10*type.getValue());
        this.soldierList.add(soldier);
        Sekretarz.buynewsoldier(general,type);
    }

    public int getTotalForceArmy(){
        int totalForce=0;
        for (Soldier s:soldierList){
            totalForce=totalForce+s.getForce();
        }
        return totalForce;
    }

    public void attackOtherGeneral(General general1,General general2){
        int forceOfSecondGeneral=general2.getTotalForceArmy();
        int forceOfFirstGeneral=general1.getTotalForceArmy();
        List<Soldier> found = new ArrayList<>();
        if(forceOfFirstGeneral>forceOfSecondGeneral){
            Double gen1coin=general1.getCoins()+(general2.getCoins()*0.1);
            Double gen2coin=general2.getCoins()-(general2.getCoins()*0.1);
            general1.setCoins(gen1coin);
            general2.setCoins(gen2coin);
            Sekretarz.attackOtherGeneralAlert(general1,general2,gen1coin,gen2coin);
            for(Soldier s: general2.soldierList){
                s.setExperience(s.getExperience()-1);
                s.setForce(s.getExperience()*s.getRanks().getValue());
                Sekretarz.downExperienceSoldier(s);
                if(s.getExperience()==0){
                    found.add(s);
                    Sekretarz.killOneSoldier(general2);
                }

            }
            for(Soldier s:general1.soldierList){
                s.setExperience(s.getExperience()+1);
                s.updateRank(s);
                s.setForce(s.getExperience()*s.getRanks().getValue());
                Sekretarz.updateExperienceSoldier(s);
            }
        }

        if(forceOfFirstGeneral<forceOfSecondGeneral){
            Double gen2coin=general1.getCoins()+(general2.getCoins()*0.1);
            Double gen1coin=general2.getCoins()-(general2.getCoins()*0.1);
            general2.setCoins(gen2coin);
            general1.setCoins(gen1coin);
            Sekretarz.attackOtherGeneralAlert(general1,general2,gen1coin,gen2coin);
            for(Soldier s: general1.soldierList){
                s.setExperience(s.getExperience()-1);
                s.setForce(s.getExperience()*s.getRanks().getValue());
                Sekretarz.downExperienceSoldier(s);
                if(s.getExperience()==0){
                    found.add(s);
                    Sekretarz.killOneSoldier(general1);
                }

            }
            for(Soldier s:general2.soldierList){
                s.setExperience(s.getExperience()+1);
                s.updateRank(s);
                s.setForce(s.getExperience()*s.getRanks().getValue());
                Sekretarz.updateExperienceSoldier(s);
            }
        }

        general1.soldierList.removeAll(found);
        general2.soldierList.removeAll(found);

        if(forceOfFirstGeneral==forceOfSecondGeneral){
            Double gen1coin=general1.getCoins();
            Double gen2coin=general2.getCoins();
            Sekretarz.attackOtherGeneralAlert(general1,general2,gen1coin,gen2coin);
            Collections.shuffle(general1.soldierList);
            general1.soldierList.remove(0);
            Collections.shuffle(general2.soldierList);
            general2.soldierList.remove(0);
            Sekretarz.killOneSoldier(general1);
            Sekretarz.killOneSoldier(general2);
        }
    }

    public void addNewSoldier(General general,Soldier soldier){
        this.soldierList.add(soldier);
        Sekretarz.newsoldierprint(general,soldier.getName());

    }


}
