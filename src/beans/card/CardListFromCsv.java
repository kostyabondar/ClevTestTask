package beans.card;

import beans.interfaces.ICardStore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CardListFromCsv implements ICardStore {

    private String fileName;

    public CardListFromCsv(String fileName) {
        this.fileName = "src/" + fileName + ".csv";
    }

    private ArrayList<CardDiscount> parseCardListFromCsv() {
        ArrayList<CardDiscount> cardDiscounts = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("file " + fileName + "not found");
            System.exit(0);
        }
        while (scanner.hasNext()) {
            String[] csvLine = scanner.nextLine().split(";");
            cardDiscounts.add(new CardDiscount(csvLine[0], Integer.parseInt(csvLine[1])));
        }
        return cardDiscounts;
    }

    @Override
    public CardDiscount getCardDiscountByName(String name) {
        CardDiscount presentedCardDiscount = null;
        for (CardDiscount cardDiscount : parseCardListFromCsv()) {

            if (cardDiscount.equals(new CardDiscount(name))) {
                presentedCardDiscount = cardDiscount;
            }
        }
        return presentedCardDiscount;
    }
}
