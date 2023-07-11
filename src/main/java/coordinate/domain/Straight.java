package coordinate.domain;

public class Straight {

    private final double length;

    private Straight(final double length) {
        this.length = length;
    }

    public static Straight of(final double length) {
        return new Straight(length);
    }

    public double getLength() {
        return length;
    }
}
