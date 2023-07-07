package rentcompany.policy;

import rentcompany.ChargePolicy;

public class BasicChargePolicy implements ChargePolicy {

    @Override
    public double getChargeQuantity(final double tripDistance, final double distancePerLiter) {
        return tripDistance / distancePerLiter;
    }
}
