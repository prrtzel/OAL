/*
Takes in an initial hashtable with no values and builds it with
linear and quadratic insert methods
 */
public class OAL {
    String[] hashTable;
    boolean noCollisions = true;
    int numOfItemsWOCollisions = 0;
    int numOfCollisions = 0;

    public OAL(String[] hashTable) {
        this.hashTable = hashTable;
    }

    public void linearInsert(int hashCode, String str) {
        noCollisions = true;
        while (hashTable[hashCode] != null) {
            noCollisions = false;
            numOfCollisions++;

            hashCode++;
        }

        hashTable[hashCode] = str;

        if (noCollisions) {
            numOfItemsWOCollisions++;
        }
    }

    public void quadraticInsert(int hashCode, String str) {
        noCollisions = true;
        int value = 1;
        while (hashTable[hashCode] != null) {
            noCollisions = false;
            numOfCollisions++;

            hashCode = hashCode + (value * value);
            value++;

            if (hashCode >= hashTable.length ||
                hashCode < 0) {
                hashCode = Math.abs(hashCode % hashTable.length);
                System.out.println(hashCode);
            }
        }

        hashTable[hashCode] = str;

        if (noCollisions) {
            numOfItemsWOCollisions++;
        }
    }
}
