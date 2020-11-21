package implementation.interfaces;

import exceptions.NotFoundException;
import beans.DiscountCard;

import java.util.List;

public interface ICardStore {

    DiscountCard getCardDiscountByName(String name) throws NotFoundException;

    default DiscountCard getCardDiscountByNameFromData(String name, List<DiscountCard> discountCards) throws NotFoundException {
        for (DiscountCard discountCard : discountCards) {
            if (discountCard.getCardNumber().equals(name)) {
                return discountCard;
            }
        }
        throw new NotFoundException();
    }
}
