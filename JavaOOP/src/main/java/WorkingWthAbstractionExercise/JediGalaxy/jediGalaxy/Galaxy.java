package WorkingWthAbstractionExercise.JediGalaxy.jediGalaxy;

public class Galaxy {
    private Field field;
    private Jedi jedi;
    private Evil evil;

    public Galaxy(Field field,Jedi jedi) {
        this.field = field;
        this.jedi = jedi;
        this.evil = new Evil();
    }
    public int moveJedi(){
        return jedi.move(field);
    }
    public void moveEvil(int rowEvil,int colEvil){
        evil.moveEvil(rowEvil,colEvil,field);
    }




}
