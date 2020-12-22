package classes;

import java.util.ArrayList;

public class Soldier  {
    private String name;
    private Ranks ranks;
    private int experience;
    private int force;

    public Soldier(String name,Ranks ranks, int experience, int force) {
        this.name=name;
        this.ranks = ranks;
        this.experience = experience;
        this.force = force;
    }


    @Override
    public String toString() {
        return "ranks=" + ranks +
                ", experience=" + experience +
                ", force=" + force ;
    }

    public Ranks getRanks() {
        return ranks;
    }

    public void setRanks(Ranks ranks) {
        this.ranks = ranks;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getForce() {
        force =experience*ranks.getValue();
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void updateRank(Soldier soldier){
        if(soldier.getRanks().getValue()==1){
            if(soldier.getExperience()==5*soldier.getRanks().getValue()) {
                soldier.setRanks(Ranks.Capral);
                soldier.setExperience(1);
                soldier.setForce(soldier.getExperience()*soldier.getRanks().getValue());
                Sekretarz.updateRankAlert(soldier);
            }
        }else if(soldier.getRanks().getValue()==2){
            if(soldier.experience==5*Ranks.Capral.getValue()) {
                soldier.setRanks(Ranks.Capitan);
                soldier.setExperience(1);
                soldier.setForce(soldier.getExperience()*soldier.getRanks().getValue());
                Sekretarz.updateRankAlert(soldier);


            }
        }else if(soldier.getRanks().getValue()==3) {
            if (soldier.experience == 5*Ranks.Capitan.getValue()) {
                soldier.setRanks(Ranks.Major);
                soldier.setExperience(1);
                soldier.setForce(soldier.getExperience()*soldier.getRanks().getValue());
                Sekretarz.updateRankAlert(soldier);


            }
        }
    }



}
