package rentcompany;

public interface ChargePolicy {

    double getChargeQuantity(double tripDistance, double distancePerLiter);
}
