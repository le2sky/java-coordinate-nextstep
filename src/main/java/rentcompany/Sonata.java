package rentcompany;

class Sonata extends Car {

    private final int tripDistance;

    public Sonata(final int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return 10;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return "Sonata";
    }
}
