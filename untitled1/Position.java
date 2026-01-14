public class Position {
    int row, col;

    public Position(){
        row = 0;
        col = 0;
    }

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){ return this.row; }
    public int getCol() { return this.col; }
}
