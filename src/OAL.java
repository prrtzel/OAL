/*
Takes in an initial hashtable with no values and builds it with
linear and quadratic insert methods
 */
public class OAL {
    String[] hashTable;
    public OAL(String[] hashTable) {
        this.hashTable = hashTable;
    }
    public void linearInsert(int hashCode, String str) {
        while (hashTable[hashCode] != null) {
            hashCode++;
        }
        hashTable[hashCode] = str;
    }
    public void quadraticInsert(int hashCode, String str) {
        int value = 1;
        while (hashTable[hashCode] != null) {
            hashCode = hashCode + (value * value);
            value++;
        }
        hashTable[hashCode] = str;
    }
}
