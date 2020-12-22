package classes;

import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

class General2txt extends Battle
{

    public static void main(final String[] args) throws IOException {
        Battle battle=new Battle();
        File f = new File("C:/Users/Błażej/Desktop/grywojenne/src/zapisgenerala/general2.txt");
        if (!f.exists()) {
            System.out.println("Plik " + f.getName() + " nie został odnaleziony.");
            return;
        }

        final BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(battle.getGeneral2().getArmyName());
        bw.newLine();
        bw.write("Ilość monet: "+battle.getGeneral2().getCoins());
        bw.newLine();
        bw.write("Ilość żołnierzy: "+battle.getGeneral2().getSoldierList().size());
        bw.newLine();
        for(Soldier s:battle.getGeneral2().getSoldierList()){
            bw.write("-"+s.getName()+" "+s.toString());
            bw.newLine();
        }
        bw.newLine();
        bw.write("Łączna siła armi: "+battle.getGeneral2().getTotalForceArmy()+"\n");
        bw.close();

        String linia;

        File plik = new File("C:/Users/Błażej/Desktop/grywojenne/src/zapisgenerala/general2.txt");
        FileReader fileReader = new FileReader(plik);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        while((linia = bufferReader.readLine()) != null) {
            System.out.println(linia);
        }
        fileReader.close();
    }
}
