package rentcompany;

class K5 extends Car {

    private final int tripDistance;

    public K5(final int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return 13;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return "K5";
    }
}
