package my.util;

import java.util.ArrayList;

public class UnorderedList<T> extends ArrayList<T> {

    public T swapRemove(int index){
        int lastIndex = size() - 1;
        if (0 <= index && index <= lastIndex) {
            T removed = get(index);
            if (index != lastIndex) {
                set(index, get(lastIndex));
            }
            super.remove(lastIndex);
            return removed;
        }
        return null;
    }
}
