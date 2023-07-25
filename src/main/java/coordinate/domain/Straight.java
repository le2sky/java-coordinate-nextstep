package coordinate.domain;

class Straight implements Figure {

    private final Point from;
    private final Point into;

    private Straight(final Point from, final Point into) {
        checkPoints(from, into);

        this.from = from;
        this.into = into;
    }

    public static Straight of(final Point from, final Point into) {
        return new Straight(from, into);
    }

    private void checkPoints(final Point from, final Point into) {
        if (from == null || into == null) {
            throw new IllegalArgumentException("존재하는 좌표값을 입력해주세요.");
        }
    }

    @Override
    public double measure() {
        return from.calculateDistanceWith(into);
    }
}
