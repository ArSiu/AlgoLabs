public class RabinKarp {
    private final int asciiChars = 256;
    private final int prime = Integer.MAX_VALUE;
    private String text;
    private String pattern;
    private int lenOfPattern;
    private int lenOfText;
    private int hashOfPattern;
    private int hashOfText;
    private int valueOfHashFunc;

    public static void main(String[] args) {
        RabinKarp r = new RabinKarp();
        r.search("ejrwkejrwkeqjrowjerowjerwo213erow123pejrwoeqrk","erow");
    }

    public void search(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        lenOfText = text.length();
        lenOfPattern = pattern.length();
        hashOfText = 0;
        hashOfPattern = 0;
        valueOfHashFunc = 1;

        hashFunc();
        findHashes();

        for (int i = 0; i <= lenOfText - lenOfPattern; i++) {
            if (hashOfPattern == hashOfText) {
                int amountOfElem;
                for (amountOfElem = 0; amountOfElem < lenOfPattern; amountOfElem++) {
                    if (text.charAt(i + amountOfElem) != pattern.charAt(amountOfElem))
                        break;
                }
                if (amountOfElem == lenOfPattern) {
                    System.out.println("Pattern match - index: " + i);
                }
            }

            if (i < lenOfText - lenOfPattern) {
                hashOfText = (asciiChars * (hashOfText - text.charAt(i) * valueOfHashFunc) + text.charAt(i + lenOfPattern)) % prime;
                if (hashOfText < 0) {
                    hashOfText = (hashOfText + prime);
                }
            }
        }

    }

    private void findHashes() {
        for (int i = 0; i < lenOfPattern; i++) {
            hashOfPattern = (asciiChars * hashOfPattern + pattern.charAt(i)) % prime;
            hashOfText = (asciiChars * hashOfText + text.charAt(i)) % prime;
        }
    }

    private void hashFunc() {
        valueOfHashFunc = ((int) Math.pow(asciiChars,lenOfPattern - 1)) % prime;
    }
}
