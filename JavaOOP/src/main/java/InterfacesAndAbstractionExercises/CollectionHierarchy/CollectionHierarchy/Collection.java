package InterfacesAndAbstractionExercises.CollectionHierarchy.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private int maxSize = 100;
    private List<String> items;

    public Collection() {
        maxSize = 100;
        items = new ArrayList<>();
    }

    public List<String> getItems() {
        return items;
    }
}
