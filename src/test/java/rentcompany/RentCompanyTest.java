package rentcompany;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import rentcompany.policy.BasicChargePolicy;

public class RentCompanyTest {

    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    public void report() throws Exception {
        RentCompany company = RentCompany.create(); // factory method를 사용해 생성
        company.addCar(new Sonata(150, new BasicChargePolicy()));
        company.addCar(new K5(260, new BasicChargePolicy()));
        company.addCar(new Sonata(120, new BasicChargePolicy()));
        company.addCar(new Avante(300, new BasicChargePolicy()));
        company.addCar(new K5(390, new BasicChargePolicy()));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                        "K5 : 20리터" + NEWLINE +
                        "Sonata : 12리터" + NEWLINE +
                        "Avante : 20리터" + NEWLINE +
                        "K5 : 30리터" + NEWLINE
        );
    }
}
