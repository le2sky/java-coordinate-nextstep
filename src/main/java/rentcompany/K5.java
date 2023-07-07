package rentcompany;

class K5 implements Car {

    private final int tripDistance;
    private final ChargePolicy chargePolicy;

    public K5(final int tripDistance, final ChargePolicy chargePolicy) {
        this.tripDistance = tripDistance;
        this.chargePolicy = chargePolicy;
    }

    @Override
    public double getDistancePerLiter() {
        return 13;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "K5";
    }

    @Override
    public double getChargeQuantity() {
        return chargePolicy.getChargeQuantity(getTripDistance(), getDistancePerLiter());
    }
}
