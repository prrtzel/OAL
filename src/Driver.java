import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws IOException {
        //----------------------------------------------------------------
        //read in dictionary.txt
        FileReader fr = new FileReader("src/dictionary.txt");
        BufferedReader br = new BufferedReader(fr);
        List<String> lines = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        String[] dictionary = new String[lines.size()];
        lines.toArray(dictionary);


        //----------------------------------------------------------------
        //main loop

        int numOfItems = lines.size();
        int tableSize = 0;
        int hashCode = 0;

        for (int load = 70; load <= 100; load++) {
            //find table size
            tableSize = numOfItems / load;
            tableSize = findNextPrime(tableSize);

            String[] hashTable = new String[tableSize];
            OAL oalLinear = new OAL(hashTable);
            OAL oalQuadratic = new OAL(hashTable);

            for (int i = 0; i < numOfItems; i++) {
                //determine hashcode
                hashCode = dictionary[i].hashCode();
                hashCode = Math.abs(hashCode % tableSize);

                //Linear insert
                oalLinear.linearInsert(hashCode, dictionary[i]);

                //Quadratic insert
                oalQuadratic.quadraticInsert(hashCode, dictionary[i]);
            }
        }


    }
    public static int findNextPrime(int value) {
        return 0;
    }
}
