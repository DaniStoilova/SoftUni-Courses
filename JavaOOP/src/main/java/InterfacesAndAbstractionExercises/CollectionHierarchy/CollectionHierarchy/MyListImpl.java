package InterfacesAndAbstractionExercises.CollectionHierarchy.CollectionHierarchy;

public class MyListImpl extends Collection implements MyList{
    @Override
    public String remove() {

        return getItems().remove(0);
    }

    @Override
    public int add(String element) {
        getItems().add(0,element);
        return 0;
    }

    @Override
    public int getUsed() {
        return getItems().size();
    }
}
