import java.util.Iterator;

public class BackTrack {
    protected Application app;

    public BackTrack(Application app) {
        this.app = app;
    }

    boolean tryToReachGoal(Position pos){
        Iterator<Position> itr = app.iterator(pos);

        while (itr.hasNext()){
            pos = itr.next();

            if (app.isOK(pos)){
                app.markAsPossible(pos);

                if (app.isGoal(pos) || tryToReachGoal(pos)) return true;

                app.markAsDeadEnd(pos);
            }
        }

        return false;
    }
}
