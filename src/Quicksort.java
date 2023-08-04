import java.util.ArrayList;

public class Quicksort<T> {
    Bigger<T> bigger;

    public Quicksort(Bigger<T> bigger) {
        this.bigger = bigger;
    }

    public ArrayList<T> sort(ArrayList<T> list){
        ArrayList<T> sortedList = new ArrayList<>();
        if(list.size() <= 1){
            return list;
        }

        T center = list.get(list.size()/2);
        list.remove(list.size()/2);
        ArrayList<T> first = new ArrayList<>();
        ArrayList<T> last = new ArrayList<>();

        while (list.size()>0){
            T current = list.get(0);
            if (bigger.bigger(current,center) == center)
                first.add(current);
            else last.add(current);
            list.remove(0);
        }

        first = sort(first);
        last = sort(last);

        sortedList.addAll(first);
        sortedList.add(center);
        sortedList.addAll(last);

        return sortedList;
    }

    interface Bigger<T>{
        T bigger(T elementOne, T elementTwo);
    }
}
