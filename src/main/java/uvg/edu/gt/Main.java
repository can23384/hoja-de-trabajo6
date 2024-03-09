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
                    long startTime = System.nanoTime();
                    cardCollection.addCard(card);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la carta para obtener el tipo:");
                    scanner.nextLine();
                    String cardToCheck = scanner.nextLine();
                    long startTime2 = System.nanoTime();
                    System.out.println("Nombre :" + cardToCheck + " Tipo: " + cardCollection.getCardType(cardToCheck));
                    long endTime2 = System.nanoTime();
                    long duration2 = endTime2 - startTime2;
                    System.out.println("Tiempo de ejecución: " + duration2 + " nanosegundos");
                    break;
                case 3:
                    long startTime3 = System.nanoTime();
                    cardCollection.displayUserCollection();
                    long endTime3 = System.nanoTime();
                    long duration3 = endTime3 - startTime3;
                    System.out.println("Tiempo de ejecución: " + duration3 + " nanosegundos");
                    break;
                case 4:
                    long startTime4 = System.nanoTime();
                    cardCollection.displaySortedUserCollection();
                    long endTime4 = System.nanoTime();
                    long duration4 = endTime4 - startTime4;
                    System.out.println("Tiempo de ejecución: " + duration4 + " nanosegundos");
                    break;
                case 5:
                    long startTime5 = System.nanoTime();
                    cardCollection.displayAllCards();
                    long endTime5 = System.nanoTime();
                    long duration5 = endTime5 - startTime5;
                    System.out.println("Tiempo de ejecución: " + duration5 + " nanosegundos");
                    break;
                case 6:
                    long startTime6 = System.nanoTime();
                    cardCollection.displaySortedAllCards();
                    long endTime6 = System.nanoTime();
                    long duration6 = endTime6 - startTime6;
                    System.out.println("Tiempo de ejecución: " + duration6 + " nanosegundos");
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