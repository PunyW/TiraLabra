package testitem;

import java.util.Comparator;

/**
 *
 * @author Joel
 */
public class MyComparator implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return item1.getId() - item2.getId();
    }

}
