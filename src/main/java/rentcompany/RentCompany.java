package rentcompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class RentCompany {

    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String REPORT_LINE_TEMPLATE = "%s : %.0f리터";

    private final List<Car> cars;

    private RentCompany() {
        this.cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        return cars.stream()
                .map(this::generateReportLine)
                .collect(Collectors.joining(NEWLINE)) + NEWLINE;
    }

    private String generateReportLine(Car car) {
        return String.format(REPORT_LINE_TEMPLATE, car.getName(), car.getChargeQuantity());
    }
}
