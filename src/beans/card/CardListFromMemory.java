package beans.card;

import beans.interfaces.ICardStore;

import java.util.ArrayList;
import java.util.List;

public class CardListFromMemory implements ICardStore {

    private static List<CardDiscount> cardDiscounts = getInitialCards();

    private static List<CardDiscount> getInitialCards() {
        cardDiscounts = new ArrayList<>();
        cardDiscounts.add(new CardDiscount("1234", 10));
        cardDiscounts.add(new CardDiscount("234534", 5));
        cardDiscounts.add(new CardDiscount("11111", 11));
        cardDiscounts.add(new CardDiscount("412", 4));
        cardDiscounts.add(new CardDiscount("546475", 23));
        cardDiscounts.add(new CardDiscount("12315", 5));
        return cardDiscounts;
    }

    public CardListFromMemory() {
    }

    @Override
    public CardDiscount getCardDiscountByName(String name) {
        CardDiscount presentedCardDiscount = null;
        for (CardDiscount cardDiscount : cardDiscounts) {

            if (cardDiscount.equals(new CardDiscount(name))) {
                presentedCardDiscount = cardDiscount;
            }
        }
        return presentedCardDiscount;
    }

}
