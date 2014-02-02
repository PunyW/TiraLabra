package testitem;

import java.util.Random;

/**
 *
 * @author Joel
 */
public class Item {

    private final int id;

    public Item() {
        Random random = new Random();
        id = random.nextInt(100);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "" + id;
    }

}
