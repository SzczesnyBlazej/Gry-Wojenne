package classes;

public class Sekretarz {
    Battle oldValue;


    public static void newsoldierprint(General general, String name){
        System.out.println(general.getArmyName()+": Został dodany nowy żołnierz: "+name);
    }

    public static void buynewsoldier(General general, Ranks type){
        System.out.println(general.getArmyName()+": Zakupiono nowego żołnierza o randze "+ type);
    }

    public static void armyManeuverAlert(General general){
        System.out.println(general.getArmyName()+ ": Wykonała manewry");
    }
    public static void attackOtherGeneralAlert(General general1, General general2, Double gen1coin, Double gen2coin){
        int gen1=general1.getTotalForceArmy();
        int gen2=general2.getTotalForceArmy();
        if(gen1>gen2){
            System.out.println("Bitwa generałów, wygrała "+general1.getArmyName());
            System.out.println(general1.getArmyName()+": Ilość monet po walce: "+gen1coin);
            System.out.println(general2.getArmyName()+": Ilość monet po walce: "+gen2coin);
        }
        if(gen1<gen2){
            System.out.println("Bitwa generałów, wygrała "+general2.getArmyName());
            System.out.println(general1.getArmyName()+": Ilość monet po walce: "+gen1coin);
            System.out.println(general2.getArmyName()+": Ilość monet po walce: "+gen2coin);
        }
        if(gen1==gen2){
            System.out.println("Bitwa generałów, bitwa zakończona remisem");
            System.out.println(general1.getArmyName()+": Ilość monet po walce: "+gen1coin);
            System.out.println(general2.getArmyName()+": Ilość monet po walce: "+gen2coin);
        }
    }
    public static void updateExperienceSoldier(Soldier soldier){
        System.out.println(soldier.getName()+" Zdobył punkt doświadczenia ");
    }

    public static void downExperienceSoldier(Soldier soldier){
        System.out.println(soldier.getName()+" Stracił punkt doświadczenia ");

    }
    public static void killOneSoldier(General general){
        System.out.println(general.getArmyName()+": Zginął jeden z żołnierzy");

    }

    public static void updateRankAlert(Soldier soldier){
        System.out.println(soldier.getName()+" Awansował na wyższy stopień");
    }


    public static void main(String[] args) {
        Battle battle=new Battle();
        System.out.println("\n **** Raport końcowy **** \n");
        System.out.println(battle.getGeneral1().getArmyName());
        System.out.println("-----------------------");
        System.out.println("Ilość monet: "+battle.getGeneral1().getCoins());
        System.out.println("Ilość żołnierzy: "+battle.getGeneral1().getSoldierList().size());
        for(Soldier s:battle.getGeneral1().getSoldierList()){
            System.out.println("-"+s.getName()+" "+s.toString());
        }
        System.out.println("Łączna siła armi: "+battle.getGeneral1().getTotalForceArmy()+"\n");

        System.out.println(battle.getGeneral2().getArmyName());
        System.out.println("-----------------------");
        System.out.println("Ilość monet: "+battle.getGeneral2().getCoins());
        System.out.println("Ilość żołnierzy: "+battle.getGeneral2().getSoldierList().size());
        for(Soldier s:battle.getGeneral2().getSoldierList()){
            System.out.println("-"+s.getName()+" "+s.toString());
        }
        System.out.println("Łączna siła armi: "+battle.getGeneral2().getTotalForceArmy());


    }
}