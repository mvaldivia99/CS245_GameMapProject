import java.util.Iterator;

public interface Application {

    boolean isOK(Position pos);

    void markAsPossible(Position pos);

    boolean isGoal(Position pos);

    void markAsDeadEnd(Position pos);

    String toString();

    Iterator<Position> iterator (Position pos);
}
