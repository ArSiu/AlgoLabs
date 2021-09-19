
public class Main {

    public static void main(String[] args) {
        HashTableChainType<String, Integer> a = new HashTableChainType<>();
        for (int i = 0; i < 150000; i++) {
            a.put(String.valueOf(i),i);
        }

        a.print();

        for (int i = 0; i < 150000; i++) {
            if(i % 20 == 0){
                System.out.println();
            }
            System.out.print(a.get(String.valueOf(i)) + "; ");
        }
        System.out.println();

        for (int i = 0; i < 150000; i++) {
            a.remove(String.valueOf(i));
        }
        a.print();

    }
}



