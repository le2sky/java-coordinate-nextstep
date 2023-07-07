package rentcompany;

class Avante extends Car {

    private final int tripDistance;

    public Avante(final int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    double getDistancePerLiter() {
        return 15;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return "Avante";
    }
}
