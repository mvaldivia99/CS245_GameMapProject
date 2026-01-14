public class Controller {
    public static void main(String[] args) {
        byte grid[][] = {{1, 0, 0, 0},
                         {1, 1, 1, 0},
                         {0, 0, 1, 1}};

        Position start = new Position(0, 0);
        Position finish = new Position(3, 3);
        Maze game = new Maze(grid, start, finish);

        game.markAsPossible(start);
        BackTrack backTrack = new BackTrack(game);

        if (game.isGoal(start) || backTrack.tryToReachGoal(start)){
            System.out.println("Game completed");
        } else {
            System.out.println("Game incomplete; no possible path");
        }

    }
}
