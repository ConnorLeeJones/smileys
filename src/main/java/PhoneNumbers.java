import java.util.*;

public class PhoneNumbers {
    private HashMap<Character, List<Character>> possibleLetters = new HashMap<>();
    private TreeSet<String> results = new TreeSet<>();


    public PhoneNumbers() {
        this.setUpMap();
    }


    private TreeSet<String> convert(String phoneNumber) {
        char[] phoneArr = phoneNumber.toCharArray();
        StringBuilder builder = new StringBuilder();

        int count = 0;

        while (count < 4) {
            for (int index = 0; index < phoneNumber.length() - 1; index++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < index; j++) {
                        builder.append(this.possibleLetters.get(phoneArr[j]).get(count));
                    }
                    builder.append(this.possibleLetters.get(phoneArr[index]).get(i));
                    for (int k = index + 1; k < phoneNumber.length(); k++) {
                        builder.append(this.possibleLetters.get(phoneArr[k]).get(count));
                    }
                    results.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
            count++;
        }
        return results;
    }


    private void setUpMap() {
        this.possibleLetters.put('0', new ArrayList<>(Arrays.asList('0', '0', '0', '0')));
        this.possibleLetters.put('1', new ArrayList<>(Arrays.asList('1', '1', '1', '1')));
        this.possibleLetters.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c', 'c')));
        this.possibleLetters.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f', 'f')));
        this.possibleLetters.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i', 'i')));
        this.possibleLetters.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l', 'l')));
        this.possibleLetters.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o', 'o')));
        this.possibleLetters.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        this.possibleLetters.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v', 'v')));
        this.possibleLetters.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
    }


    public static void main(String[] args) {
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        TreeSet<String> treeResult = phoneNumbers.convert("4155239");
        ArrayList<String> finalResult = new ArrayList<>(treeResult);
        System.out.println( String.join(",", finalResult));
    }
}
