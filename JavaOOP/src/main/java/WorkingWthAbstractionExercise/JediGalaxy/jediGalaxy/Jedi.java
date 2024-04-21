package WorkingWthAbstractionExercise.JediGalaxy.jediGalaxy;

public class Jedi {
    private int row;
    private int col;

    public Jedi(int[] positions){
        this.row = positions[0];
        this.col = positions[1];
    }
    public   int move(Field field) {
        int stars = 0;
        while (row >= 0 && col < field.getColLength()) {
            if (field.isInBounds(row,col)) {
                stars += field.getValue(row,col);
            }

            col++;
            row--;
        }
        return stars;
    }
}
