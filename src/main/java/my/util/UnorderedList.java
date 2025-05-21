package my.util;

import java.util.ArrayList;

public class UnorderedList<T> extends ArrayList<T> {

    @Override
    public T remove(int index){
        int lastIndex = size() - 1;
        if (index < 0 || lastIndex < index) {
            return null;
        }
        T removed = get(index);
        if (index != lastIndex) {
            set(index, get(lastIndex));
        }
        super.remove(lastIndex);
        return removed;
    }
}
