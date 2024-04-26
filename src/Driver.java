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
        System.out.println("File Read");
        String[] dictionary = new String[lines.size()];
        lines.toArray(dictionary);


        //----------------------------------------------------------------
        //main loop

        int numOfItems = lines.size();
        int tableSize = 0;
        int hashCode = 0;
        int totalCollisions = 0;
        int itemsWOCollisions = 0;

        for (int load = 70; load <= 100; load++) {
            System.out.println("Load: " + load);
            //find table size
            tableSize = numOfItems % load;
            tableSize = nextPrime(tableSize);

            String[] hashTable = new String[tableSize];
            OAL oalLinear = new OAL(hashTable);
            OAL oalQuadratic = new OAL(hashTable);

            for (int i = 0; i < numOfItems; i++) {
                //determine hashcode
                hashCode = dictionary[i].hashCode();
                hashCode = Math.abs(hashCode) % tableSize;

                //Linear insert
                oalLinear.linearInsert(hashCode, dictionary[i]);

                //Quadratic insert
                oalQuadratic.quadraticInsert(hashCode, dictionary[i]);
            }

            itemsWOCollisions = oalLinear.numOfItemsWOCollisions + oalQuadratic.numOfItemsWOCollisions;
            totalCollisions = oalLinear.numOfCollisions + oalQuadratic.numOfCollisions;
            System.out.println("Load value: " + load);
            System.out.println("Items inserted without collisions: " + itemsWOCollisions);
            System.out.println("Total number of Collisions: " + totalCollisions);
            System.out.println();
        }


    }
    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to find the next prime number after a given number
    public static int nextPrime(int num) {
        num++; // Start checking from the number after the input number
        while (true) {
            if (isPrime(num)) {
                return num;
            }
            num++;
        }
    }
}
