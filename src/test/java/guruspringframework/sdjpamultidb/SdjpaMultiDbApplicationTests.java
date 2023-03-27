package guruspringframework.sdjpamultidb;

import guruspringframework.sdjpamultidb.domain.creditcard.CreditCard;
import guruspringframework.sdjpamultidb.services.CreditCardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SdjpaMultiDbApplicationTests {

    @Autowired
    CreditCardService creditCardService;

    @Test
    void testSaveAndGetCreditCard() {
        CreditCard cc = CreditCard.builder()
                .firstName("Dani")
                .lateName("Setiawan")
                .zipCode("12345")
                .creditCardNumber("1234567890123456")
                .cvv("123")
                .expirationDate("12/20")
                .build();

        CreditCard savedCC = creditCardService.saveCreditCard(cc);

        Assertions.assertNotNull(savedCC);
        Assertions.assertNotNull(savedCC.getId());
        Assertions.assertNotNull(savedCC.getCreditCardNumber());
    }

    @Test
    void contextLoads() {
    }

}
