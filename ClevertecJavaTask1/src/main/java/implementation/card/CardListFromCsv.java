package implementation.card;

import constants.Constants;
import exceptions.NotFoundException;
import beans.DiscountCard;
import implementation.interfaces.ICardStore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static constants.Constants.PATH_FILES;

public class CardListFromCsv implements ICardStore {

    private String fileName;

    public CardListFromCsv(String fileName) {
        this.fileName = PATH_FILES + fileName + Constants.CSV;
    }

    private List<DiscountCard> parseCardListFromCsv() {
        List<DiscountCard> discountCards = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("file " + fileName + "not found");
            System.exit(0);
        }
        while (scanner.hasNext()) {
            String[] csvLine = scanner.nextLine().split(Constants.REGEX_CSV);
            discountCards.add(new DiscountCard(csvLine[0], Integer.parseInt(csvLine[1])));
        }
        return discountCards;
    }

    @Override
    public DiscountCard getCardDiscountByName(String name) throws NotFoundException {
        return getCardDiscountByNameFromData(name, parseCardListFromCsv());
    }

}
