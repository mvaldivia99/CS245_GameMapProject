import java.util.Iterator;

public class Maze implements Application{
    public static final byte WALL = 0;
    public static final byte CORRIDOR = 1;
    public static final byte PATH = 9;
    public static final byte DEAD_END = 2;

    protected byte[][] grid;

    protected Position start, finish;


    public Maze(byte[][] user_grid, Position start, Position finish){
        grid = new byte[user_grid.length][user_grid[0].length];

        for (int i = 0; i < user_grid.length; i++){
            for (int j = 0; j < user_grid[i].length; j++){
                grid[i][j] = user_grid[i][j];
            }
        }

        this.start = start;
        this.finish = finish;
    }



    @Override
    public boolean isOK(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < grid.length &&
                pos.getCol() >= 0 && pos.getCol() < grid[0].length &&
                grid [pos.getRow()][pos.getCol()] == CORRIDOR;
    }

    @Override
    public void markAsPossible(Position pos) {
        grid [pos.getRow()][pos.getCol()] = PATH;
    }

    @Override
    public boolean isGoal(Position pos) {
        return pos.getRow() == finish.getRow() &&
                pos.getCol() == finish.getCol();
    }

    @Override
    public void markAsDeadEnd(Position pos) {
        grid [pos.getRow()][pos.getCol()] = DEAD_END;
    }

    public String toString(){
        String result = "\n";

        result += "Start: " + start.getRow() + " " + start.getCol() + "\n";
        result += "Finish: " + finish.getRow() + " " + finish.getCol() + "\n";

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                result += String.valueOf(grid[i][j]) + " ";
            }

            result += "\n";
        }


        return result;
    }

    @Override
    public Iterator<Position> iterator(Position pos) {
        return new MazeIterator(pos);
    }

    public Position getStart(){ return start; }

    public Position getFinish() { return finish; }

    public byte[][] getGrid(){
        byte[][] gridCopy = new byte[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                gridCopy[i][j] = grid[i][j];
            }
        }

        return gridCopy;
    }

    protected class MazeIterator implements Iterator<Position>{
        protected static final int MAX_MOVES = 4;

        protected int row, col, count;

        public MazeIterator(Position pos){
            row = pos.getRow();
            col = pos.getCol();
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < MAX_MOVES;
        }

        public Position next(){
            Position newPos = new Position();

            switch (count++){
                case 0:
                    newPos = new Position(row-1, col); // north
                    break;

                case 1:
                    newPos = new Position(row, col+1); // east
                    break;

                case 2:
                    newPos = new Position(row+1, col); // south
                    break;

                case 3:
                    newPos = new Position(row, col-1); // west
                    break;
            }

            return newPos;
        }

        public void remove(){
            // removal is illegal for the MazeIterator object
            throw new UnsupportedOperationException();
        }
    }
}























































































