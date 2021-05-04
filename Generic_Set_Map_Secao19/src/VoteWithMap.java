import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class VoteWithMap {
    public static void main(String[] args) {
        String path = "C:\\Users\\Jose\\Desktop\\aulas_gubee\\Generic_Set_Map_Secao19\\src\\voteInput.txt";
        Map<String, Integer> mapVar = new TreeMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while(line != null) {
                String vote[] = line.split(",");
                vote[1] = vote[1].trim();
                if (mapVar.containsKey(vote[0])) {
                    mapVar.put(vote[0], Integer.valueOf(vote[1]) + mapVar.get(vote[0]));
                } else {
                    mapVar.put(vote[0], Integer.valueOf(vote[1]));
                }
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("ERROR---------ERROR\n"+e+"ERROR---------ERROR\n");
        }
        for (String key: mapVar.keySet()) {
            System.out.println("Key: " + key + " Votes: " + mapVar.get(key));
        }
    }

}
