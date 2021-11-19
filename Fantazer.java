import java.util.ArrayList;
import java.util.List;

public class Fantazer {

    public static void main(String[] args) {
        Fantazer fantazer = new Fantazer();
        int a = fantazer.findMinBin(args[0], Integer.parseInt(args[1]));
        System.out.println(a);
    }

    public int findMinBin(String binary, int number) {
        List<Integer> part = new ArrayList<>();
        for (int i = 0; i < binary.length() + 1; i++) {
            part.add(i, binary.length() + 1);
        }
        part.set(0, 0);

        for (int currentIndex = 1; currentIndex <= binary.length(); currentIndex++) {
            if (binary.charAt(currentIndex - 1) == '0') {
                continue;
            }
            for (int lastIndex = 0; lastIndex < currentIndex; lastIndex++) {
                if (binary.charAt(lastIndex) == '0') {
                    continue;
                }
                String current = binary.substring(lastIndex, currentIndex);
                if (!isPowerOfNumber(Long.parseLong(current, 2), number)) {
                    continue;
                }
                part.set(currentIndex, Math.min(part.get(currentIndex), part.get(lastIndex) + 1));
            }
        }
        if (part.get(binary.length()) < binary.length() + 1) {
            return part.get(binary.length());
        }
        return -1;
    }

    public boolean isPowerOfNumber(Long numToCheck, int number) {
        if (numToCheck == 0) {
            return false;
        }
        Long power = Math.round((Math.log(numToCheck) / Math.log(number)));
        power = Math.round(Math.pow(number, power));
        return power.equals(numToCheck);
    }

}
