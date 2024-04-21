package InterfacesAndAbstractionExercises.CollectionHierarchy.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public String remove() {
        return getItems().remove(getItems().size() - 1);
    }

    @Override
    public int add(String element) {
        getItems().add(0,element);
       return 0;
    }
}
