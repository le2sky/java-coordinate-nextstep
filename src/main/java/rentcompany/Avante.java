package rentcompany;

class Avante implements Car {

    private final int tripDistance;
    private final ChargePolicy chargePolicy;

    public Avante(final int tripDistance, final ChargePolicy chargePolicy) {
        this.tripDistance = tripDistance;
        this.chargePolicy = chargePolicy;
    }

    @Override
    public double getDistancePerLiter() {
        return 15;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "Avante";
    }

    @Override
    public double getChargeQuantity() {
        return chargePolicy.getChargeQuantity(getTripDistance(), getDistancePerLiter());
    }
}
