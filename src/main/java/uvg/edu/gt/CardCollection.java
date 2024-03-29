import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CardCollection implements CardCollectionOperations {
    private Map<String, String> allCards;
    private Map<String, Integer> userCollection;

    public CardCollection(Map<String, String> mapType) {
        this.allCards = mapType;
        this.userCollection = new HashMap<>();
    }

    public void readCardsFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            allCards.put(parts[0].trim(), parts[1].trim());
        }
        reader.close();
    }

    @Override
    public void addCard(String cardName) {
        if (allCards.containsKey(cardName)) {
            userCollection.put(cardName, userCollection.getOrDefault(cardName, 0) + 1);
            System.out.println("Carta agregada.");
        } else {
            System.out.println("Error: Carta no existe.");
        }
    }

    @Override
    public String getCardType(String cardName) {
        return allCards.getOrDefault(cardName, "Carta no encontrada");
    }

    @Override
    public void displayUserCollection() {
        System.out.println("Coleccion del usuario:");
        for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
            System.out.println(entry.getKey() + " | " + allCards.get(entry.getKey()) + " | Cantidad: " + entry.getValue());
        }
    }

    @Override
    public void displaySortedUserCollection() {
        TreeMap<String, Integer> sortedUserCollection = new TreeMap<>(userCollection);
        for (Map.Entry<String, Integer> entry : sortedUserCollection.entrySet()) {
            System.out.println(entry.getKey() + " | " + allCards.get(entry.getKey()) + " | Cantidad: " + entry.getValue());
        }
    }

    @Override
    public void displayAllCards() {
        for (Map.Entry<String, String> entry : allCards.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }

    @Override
    public void displaySortedAllCards() {
        TreeMap<String, String> sortedAllCards = new TreeMap<>(allCards);
        for (Map.Entry<String, String> entry : sortedAllCards.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
}
