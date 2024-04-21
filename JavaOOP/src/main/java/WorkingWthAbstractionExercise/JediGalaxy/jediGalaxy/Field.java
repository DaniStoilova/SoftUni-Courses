package WorkingWthAbstractionExercise.JediGalaxy.jediGalaxy;

public class Field {
    private long[][] starsField;

    public Field(int row,int col) {
        this.starsField = new long[row][col];
        fillGalaxy(row,col, starsField);
    }
    private void fillGalaxy(int row, int col, long[][] galaxy) {
        long value = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                galaxy[r][c] = value++;
            }
        }
    }
    public boolean isInBounds(int row, int col ){
        return row >= 0 && col >= 0 && row < starsField.length && col < starsField[row].length;

    }
    public long getValue(int row,int col){
        return this.starsField[row][col];
    }
    public void setValue(int row,int col,int value){
            starsField[row][col] = value;
    }
    public long getColLength(){
        return starsField[1].length;
    }

}
