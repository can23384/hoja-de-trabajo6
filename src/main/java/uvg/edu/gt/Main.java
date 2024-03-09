import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccionar la implementación de MAP que usará su programa:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int choice = scanner.nextInt();
        String mapType;
        switch (choice) {
            case 1:
                mapType = "HashMap";
                break;
            case 2:
                mapType = "TreeMap";
                break;
            case 3:
                mapType = "LinkedHashMap";
                break;
            default:
                System.out.println("Opcion no existente, se usara el HashMap.");
                mapType = "HashMap";
            
        }

        Map<String, String> allCards = MapFactory.createMap(mapType);
        CardCollection cardCollection = new CardCollection(allCards);

        try {
            cardCollection.readCardsFromFile("cards_desc.txt");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        while (true) {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Agregar una carta a la colección del usuario.");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo.");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes.");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
            System.out.println("7. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la carta para agregarla a la colección:");
                    scanner.nextLine();
                    String card = scanner.nextLine();
                    cardCollection.addCard(card);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la carta para obtener el tipo:");
                    scanner.nextLine();
                    String cardToCheck = scanner.nextLine();
                    System.out.println("Nombre :" + cardToCheck + " Tipo: " + cardCollection.getCardType(cardToCheck));
                    break;
                case 3:
                    cardCollection.displayUserCollection();
                    break;
                case 4:
                    cardCollection.displaySortedUserCollection();
                    break;
                case 5:
                    cardCollection.displayAllCards();
                    break;
                case 6:
                    cardCollection.displaySortedAllCards();
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Esa opcion no existe.");
            }
        }
    }
}