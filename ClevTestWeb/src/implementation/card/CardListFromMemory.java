package implementation.card;

import exceptions.NotFoundException;
import beans.DiscountCard;
import implementation.interfaces.ICardStore;

import java.util.ArrayList;
import java.util.List;

public class CardListFromMemory implements ICardStore {

    private List<DiscountCard> discountCards;

    public CardListFromMemory() {
        discountCards = new ArrayList<>();
        discountCards.add(new DiscountCard("1234", 11));
        discountCards.add(new DiscountCard("234534", 5));
        discountCards.add(new DiscountCard("11111", 11));
        discountCards.add(new DiscountCard("412", 4));
        discountCards.add(new DiscountCard("546475", 23));
        discountCards.add(new DiscountCard("12315", 5));
    }

    @Override
    public DiscountCard getCardDiscountByName(String name) throws NotFoundException {
        return getCardDiscountByNameFromData(name, discountCards);
    }
}
