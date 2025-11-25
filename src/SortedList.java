import java.util.ArrayList;

public class SortedList {

    private ArrayList<String> list = new ArrayList<>();

    public void add(String value) {
        if (list.isEmpty()) {
            list.add(value);
            return;
        }

        int pos = binarySearchInsert(value);
        list.add(pos, value);
    }

    public int binarySearchInsert(String value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = value.compareToIgnoreCase(list.get(mid));

            if (cmp == 0)
                return mid;

            if (cmp < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public int search(String value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = value.compareToIgnoreCase(list.get(mid));

            if (cmp == 0)
                return mid;
            if (cmp < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }

    public String toString() {
        return list.toString();
    }

    public ArrayList<String> getList() {
        return list;
    }
}
