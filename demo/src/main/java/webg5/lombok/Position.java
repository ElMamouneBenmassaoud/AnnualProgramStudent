package webg5.lombok;
import lombok.Value;

@Value
public class Position {
    private final int row;
    private final int column;

    public static void main(String[] args) {
        System.out.println("test de lombok");
        Position pos1 = new Position(1,2);
        Position pos2 = new Position(1,2);

        System.out.println(pos1);
        System.out.println(pos2);
        System.out.println(pos1.equals(pos2));
        System.out.println(pos1.getRow());
    }
}
