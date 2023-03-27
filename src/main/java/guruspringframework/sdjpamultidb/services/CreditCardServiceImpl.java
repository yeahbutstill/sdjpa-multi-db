package guruspringframework.sdjpamultidb.services;

import guruspringframework.sdjpamultidb.domain.cardholder.CreditCardHolder;
import guruspringframework.sdjpamultidb.domain.creditcard.CreditCard;
import guruspringframework.sdjpamultidb.domain.pan.CreditCardPAN;
import guruspringframework.sdjpamultidb.repositories.cardholder.CreditCardHolderRepository;
import guruspringframework.sdjpamultidb.repositories.creditcard.CreditCardRepository;
import guruspringframework.sdjpamultidb.repositories.pan.CreditCardPANRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardHolderRepository creditCardHolderRepository;
    private final CreditCardRepository creditCardRepository;
    private final CreditCardPANRepository creditCardPANRepository;

    @Transactional
    @Override
    public CreditCard getCreditCardById(Long id) {

        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow(() -> new RuntimeException("Credit card not found"));

        CreditCardHolder creditCardHolder = creditCardHolderRepository
                .findByCreditCardId(creditCard.getId()).orElseThrow(() -> new RuntimeException("Credit card holder not found"));

        CreditCardPAN creditCardPAN = creditCardPANRepository
                .findByCreditCardId(creditCard.getId()).orElseThrow(() -> new RuntimeException("Credit card PAN not found"));

        creditCard.setFirstName(creditCardHolder.getFirstName());
        creditCard.setLateName(creditCardHolder.getLastName());
        creditCard.setZipCode(creditCard.getZipCode());
        creditCard.setCreditCardNumber(creditCardPAN.getCreditCardNumber());
        creditCard.setExpirationDate(creditCard.getExpirationDate());
        creditCard.setCvv(creditCard.getCvv());

        return creditCard;
    }

    @Transactional
    @Override
    public CreditCard saveCreditCard(CreditCard cc) {

        CreditCard savedCC = creditCardRepository.save(cc);
        savedCC.setFirstName(cc.getFirstName());
        savedCC.setLateName(cc.getLateName());
        savedCC.setZipCode(cc.getZipCode());
        savedCC.setCreditCardNumber(cc.getCreditCardNumber());
        savedCC.setCvv(cc.getCvv());
        savedCC.setExpirationDate(cc.getExpirationDate());

        creditCardHolderRepository.save(CreditCardHolder.builder()
                        .creditCardId(savedCC.getId())
                        .firstName(savedCC.getFirstName())
                        .lastName(savedCC.getLateName())
                        .zipCode(savedCC.getZipCode())
                .build());

        creditCardPANRepository.save(CreditCardPAN.builder()
                        .creditCardNumber(savedCC.getCreditCardNumber())
                        .creditCardId(savedCC.getId())
                .build());

        return savedCC;

    }
}
