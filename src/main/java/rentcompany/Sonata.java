package rentcompany;

class Sonata implements Car {

    private final int tripDistance;
    private final ChargePolicy chargePolicy;

    public Sonata(final int tripDistance, final ChargePolicy chargePolicy) {
        this.tripDistance = tripDistance;
        this.chargePolicy = chargePolicy;
    }

    @Override
    public double getDistancePerLiter() {
        return 10;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "Sonata";
    }

    @Override
    public double getChargeQuantity() {
        return chargePolicy.getChargeQuantity(getTripDistance(), getDistancePerLiter());
    }
}
