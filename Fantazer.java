import java.util.ArrayList;
import java.util.List;

public class Fantazer {

    public static void main(String[] args) {
        Fantazer fantazer = new Fantazer();
        List<String> a = fantazer.findMinBin(args[0],Integer.parseInt(args[1]));
        System.out.println(a);
    }

    public List<String> findMinBin(String binary, int number) {
        List<String> part = new ArrayList<>();
        List<String> pows = findPowers(binary, number);
        int maxPowLength = binary.length();

        if(binary.length() > 62){
            maxPowLength = pows.get(0).length();
        }

        int lastIndex = 0;
        for (int currentIndex = maxPowLength; lastIndex < binary.length(); currentIndex--) {

            String current = binary.substring(lastIndex, currentIndex).replaceAll("^0*", "");
            if(current.equals("")){
                break;
            }
            for (String bins : pows) {
                if (current.equals(bins)) {
                    part.add(current);
                    lastIndex = currentIndex;
                    currentIndex += maxPowLength;
                    if(currentIndex > binary.length()){
                        currentIndex = binary.length()+1;
                    }
                    break;
                }
            }
        }
        return part;
    }

    private List<String> findPowers(String binary, int number) {
        List<String> pows = new ArrayList<>();
        String maxLong = Long.toBinaryString(Long.MAX_VALUE);
        String bin = "";

        for (int i = 0; bin.length() <= binary.length(); i++) {
            if (bin.equals(maxLong)) {
                break;
            }
            bin = Long.toBinaryString((long) Math.pow(number, i));
            pows.add(bin);
        }
        pows.sort((String a, String b) -> b.length() - a.length());
        return pows;
    }

}
