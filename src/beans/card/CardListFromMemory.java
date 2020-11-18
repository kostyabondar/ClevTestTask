package beans.card;

import java.util.ArrayList;
import java.util.List;

public class CardListFromMemory {
    public List<CardDiscount> cardDiscounts;

    public CardListFromMemory() {

    }


    public List<CardDiscount> getCardDiscountsList() {
        cardDiscounts = new ArrayList<>();
        cardDiscounts.add(new CardDiscount("1234", 10));
        cardDiscounts.add(new CardDiscount( "234534", 5));
        cardDiscounts.add(new CardDiscount( "11111", 11));
        cardDiscounts.add(new CardDiscount( "412", 4));
        cardDiscounts.add(new CardDiscount( "546475", 23));
        cardDiscounts.add(new CardDiscount( "12315", 5));

        return cardDiscounts;
    }
}
