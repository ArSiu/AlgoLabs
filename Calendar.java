import java.util.ArrayList;

public class Calendar{
    private ArrayList<Tuple> tupleArr;
    private ArrayList<Tuple> mergeRange;

    public void setTupleArr(ArrayList<Tuple> tupleArr) {
        this.tupleArr = tupleArr;
    }

    public void setMergeRange(ArrayList<Tuple> mergeRange) {
        this.mergeRange = mergeRange;
    }

    public ArrayList<Tuple> getMergeRange() {
        return mergeRange;
    }

    public Calendar(){}

    public Calendar(String[] args) {
        tupleArr = new ArrayList<>();
        makeIntArrOfString(args[0]);
        mergeRanges();
    }

    private void makeIntArrOfString(String input) {
        ArrayList<Integer> ranges = new ArrayList<>();
        String[] arrTemp = input.split("[\\(+,+\\)]");
        try {
            for (String end:arrTemp) {
                if(!end.equals("")){
                    ranges.add(Integer.parseInt(end));
                }
            }
            if(ranges.size() % 2 != 0){
                throw new NumberFormatException();
            }
            for (int i = 0; i < ranges.size(); i+=2) {
                tupleArr.add(new Tuple(ranges.get(i), ranges.get(i+1)));
            }
            System.out.println("Input Ranges: ");
            printTupleArr(tupleArr);

        } catch (NumberFormatException e){
            System.out.println("invalid input");
            System.exit(0);
        }
    }

    public void mergeRanges() {
        mergeRange = new ArrayList<>();

        tupleArr.sort((o1, o2) -> o1.getStart()-o2.getStart());

        Tuple first = tupleArr.get(0);
        int start = first.getStart();
        int end = first.getEnd();

        for (int i = 1; i < tupleArr.size(); i++) {
            Tuple current = tupleArr.get(i);
            if(current.getStart() <= end) {
                end = Math.max(current.getEnd(), end);
            } else {
                mergeRange.add(new Tuple(start, end));
                start = current.getStart();
                end = current.getEnd();
            }

        }
        mergeRange.add(new Tuple(start, end));
        System.out.println("Merge Ranges: ");
        printTupleArr(mergeRange);
    }

    private void printTupleArr(ArrayList<Tuple> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" (" + list.get(i).getStart() + "," + list.get(i).getEnd() + ") ");
        }
        System.out.println();
    }
}

class Tuple {
    private final int start;
    private final int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Tuple(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar(args);
    }
}
