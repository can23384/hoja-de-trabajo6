import java.io.IOException;

public interface CardCollectionOperations {
    void readCardsFromFile(String fileName) throws IOException;
    void addCard(String cardName);
    String getCardType(String cardName);
    void displayUserCollection();
    void displaySortedUserCollection();
    void displayAllCards();
    void displaySortedAllCards();
}