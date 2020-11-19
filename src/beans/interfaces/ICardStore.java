package beans.interfaces;

import beans.card.CardDiscount;

public interface ICardStore {
    CardDiscount getCardDiscountByName(String name);
}
