import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is a order system for a pizza restaurant. Hand in assignment.
 */

public class Main {

    public static void main(String[] args) {
        printMenu(); //This method print the menu to console
        int pizzaReturn = userInputOrder();// This variable holds the return value from userInputOrder()
        double sizeReturn = pizzaSize(); //This variable holds the return value from pizzaSize()
        int toppingsReturn = toppings(); //This ask the user if they want toppings and return an int value.
        double priceReturn = priceCalculator(pizzaReturn, sizeReturn, toppingsReturn);//This variable holds the priceCalculator return value.
        receipt(priceReturn, sizeReturn, pizzaReturn, toppingsReturn); // This method print the receipt.

    }

    /**
     * This method prints the menu to console
     */
    public static void printMenu() {
        //below is a small greeting and the menu card.
        System.out.println("Hej og velkommen til det bedste pizzaria i byen");
        System.out.println("Vores menukort er som følger herunder:");
        System.out.println("1: Pizza Margherita: Tomat, ost, DKK 45,-");
        System.out.println("2: Pizza Vesuvio: Tomat, ost og kalkuntopping, DKK 50,-");
        System.out.println("3: Pizza Capricciosa: Tomat, ost, kalkuntopping og champignon, DKK 55,-");
        System.out.println("4: Pizza Hawaii: Tomat, ost, kalkuntopping, champignon og kalve bacon, DKK 59,-");
        System.out.println("5: Pizza Capone: Tomat, ost, oksekød, champignon og løg, DKK 59,-");
        System.out.println("6: Pizza Italiano: Tomat, ost, oksekød, løg og kalve bacon, DKK 59,-");
        System.out.println("7: Pizza Luciano: Tomat, ost, oksekød, peberfrugt og cocktailpølser, DKK 59,-");
        System.out.println("8: Pizza Europa: Tomat, ost, kylling, løg, kalve bacon og peberfrugt, DKK 65,-");
        System.out.println("9: Pizza Pepperoni: Tomat, ost, pepperoni og løg, DKK 55,-");
        System.out.println("10: Pizza Quattro Stagioni: Tomat, ost, kalkuntopping, champignon, løg og rejer, DKK 60,-");

    }

    /**
     * UserInputOrder() method ask the customer what pizza they would like from the menu. With input validation.
     * Returns an int with a number from 1 - 10.
     *
     * @return
     */

     public static int userInputOrder() {
         Scanner in = new Scanner(System.in);
         int pizzaOrderNo = 0;

         do {
             System.out.print("Hvilken pizza kunne du tænke dig? Skriv et nummer fra 1 - 10");
             while (!in.hasNextInt()) {
                 System.out.println("Jeg beklager men den pizza har vi desværre ikke, skriv et tal fra 1 - 10: ");
                 in.next();
             }
             pizzaOrderNo = in.nextInt();
         } while (pizzaOrderNo > 10 || pizzaOrderNo < 1);


         System.out.println("Tusind tak, jeg har noteret at du har bestilt en nummer: " + pizzaOrderNo);

         return pizzaOrderNo;
    }

    /**
     * pizzaSize() method ask the customer what size pizza they would like and return a double with percentage.
     * @return
     */

    public static double pizzaSize() {
        Scanner in = new Scanner(System.in);
        double size = 0; // This variable will be updated with the price percentage of different pizza sizes.

        do {
            System.out.println("Hvilken størrelse pizza kunne du tænke dig?");
            System.out.println("Skriv 1 for børnestørrelse: 25% billigere end standard størrelsen");
            System.out.println("Skriv 2 for standard pizza");
            System.out.println("skriv 3 for familiestørrelse: 50% dyrere end standard størrelsen");
            while (!in.hasNextDouble()) {
                System.out.println("Jeg beklager men den størrelse har vi desværre ikke, skriv et tal fra 1 - 3: ");
                in.next();
            }
            size = in.nextDouble();
        } while (size > 3 || size < 1);

        // This if statement below check what size has been ordered and print it to the console and update the size variable.
        if (size == 1) {
            System.out.println("Børnestørrelse et godt valg");
            size = 0.75;
        } else if (size == 2) {
            System.out.println("Standard størrelse et godt valg");
            size = 1.00;
        } else if (size == 3) {
            System.out.println("Familiepizza et godt valg ");
            size = 1.50;
        }

        return size;
    }

    /**
     * toppings() methods ask the user if they want any toppings and return an int with the value.
     * @return
     */

    public static int toppings() {
        Scanner in = new Scanner(System.in);
        int customerToppings = 5; // This variable holds the price of toppings. 5 DKK.

        do {
            System.out.println("Kunne du tænke dig ekstra toppings? Det koster DKK 5,- ekstra: ");
            System.out.println("Skriv 1 for bacon");
            System.out.println("Skriv 2 for dressing");
            System.out.println("skriv 3 for ekstra hvidløg");
            System.out.println("Skriv 4 hvis du ikke ønsker ekstra toppings");
            while (!in.hasNextDouble()) {
                System.out.println("Jeg beklager men den topping har vi desværre ikke, skriv et tal fra 1 - 4: ");
                in.next();
            }
            customerToppings = in.nextInt();
        } while (customerToppings > 4 || customerToppings < 0);

        // This if statement checks if a user has ordered extra toppings and update the customerTopping variable.
        if (customerToppings == 4) {
            customerToppings = 0;
        } else if (customerToppings > 0 && customerToppings <= 4) {
            customerToppings = 5;
        }
        return customerToppings;
    }


    /**
     * priceCalculator() method takes 3 parameters and returns the price as a double.
     * @param pizzaOrderNo
     * @param size
     * @return
     */
    public static double priceCalculator(int pizzaOrderNo , double size, int customerTopping) {

        //Below are the pizza prices for the standard size:
        int pizza1 = 45; //Pizza Margherita: Tomat, ost, DKK 45.
        int pizza2 = 50; //Pizza Vesuvio: Tomat, ost og kalkuntopping, DKK 50.
        int pizza3 = 55; //Pizza Capricciosa: Tomat, ost, kalkuntopping og champignon, DKK 55.
        int pizza4 = 59; //Pizza Hawaii: Tomat, ost, kalkuntopping, champignon og kalve bacon, DKK 59.
        int pizza5 = 59; //Pizza Capone: Tomat, ost, oksekød, champignon og løg, DKK 59.
        int pizza6 = 59; //Pizza Italiano: Tomat, ost, oksekød, løg og kalve bacon, DKK 59.
        int pizza7 = 59; //Pizza Luciano: Tomat, ost, oksekød, peberfrugt og cocktailpølser, DKK 59.
        int pizza8 = 65; //Pizza Europa: Tomat, ost, kylling, løg, kalve bacon og peberfrugt, DKK 65.
        int pizza9 = 55; //Pizza Pepperoni: Tomat, ost, pepperoni og løg, DKK 55.
        int pizza10 = 60; //Pizza Quattro Stagioni: Tomat, ost, kalkuntopping, champignon, løg og rejer, DKK 60.

        double pizzaPrice = 0; //This variable is used to hold the pizza price.

        // This switch statements is used to check what pizza is ordered and update pizzaPrice with the right price.
        switch (pizzaOrderNo) {
            case 1:
                pizzaPrice = pizza1;
                break;
            case 2:
                pizzaPrice = pizza2;
                break;
            case 3:
                pizzaPrice = pizza3;
                break;
            case 4:
                pizzaPrice = pizza4;
                break;
            case 5:
                pizzaPrice = pizza5;
                break;
            case 6:
                pizzaPrice = pizza6;
                break;
            case 7:
                pizzaPrice = pizza7;
                break;
            case 8:
                pizzaPrice = pizza8;
                break;
            case 9:
                pizzaPrice = pizza9;
                break;
            case 10:
                pizzaPrice = pizza10;
                break;
        }

        double priceCalc = pizzaPrice * size + customerTopping; // priceCalc calculated the sum of pizza + size + toppings.

        return priceCalc; //Return the total price as a double.
    }

    /**
     * receipt() method takes 3 parameters and prints the receipt to the customer.
     * @param priceCalc
     * @param size
     * @param pizzaOrderNo
     */
    public static void receipt(double priceCalc, double size, int pizzaOrderNo, int customerToppings) {
        LocalDateTime dateAndTime = LocalDateTime.now();
        String pizzaNumber = ""; //This String will be updated and contain the name of the pizza ordered.
        String pizzaSize = ""; //This String will be updated with the name of the size ordered.
        double udenMoms = priceCalc * 0.80; // This variable holds the charged amount without VAT. 0.80 is used to remove the VAT.


        DateTimeFormatter dateAndTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); //Format date and time
        DateTimeFormatter readyTime = DateTimeFormatter.ofPattern("HH:mm"); //Format pizza ready time.
        String strDateTime = dateAndTime.format(dateAndTimeFormat); //This String holds the date and time of receipt creation.
        String strPizzaReadyTime = dateAndTime.plusMinutes(15).format(readyTime); // This String holds the time the pizza is ready

        //This switch statement takes the pizzaOrderNo 1 - 10 and update the String pizzaNumber with the name of the ordered pizza.
        switch (pizzaOrderNo) {
            case 1:
                pizzaNumber = "Margherita";
                break;
            case 2:
                pizzaNumber = "Vesuvio";
                break;
            case 3:
                pizzaNumber = "Capricciosa";
                break;
            case 4:
                pizzaNumber = "Hawaii";
                break;
            case 5:
                pizzaNumber = "Capone";
                break;
            case 6:
                pizzaNumber = "Italiano";
                break;
            case 7:
                pizzaNumber = "Luciano";
                break;
            case 8:
                pizzaNumber = "Europa";
                break;
            case 9:
                pizzaNumber = "Pepperoni";
                break;
            case 10:
                pizzaNumber = "Quattro Stagioni";
                break;
        }

        //This if statement update pizzaSize String variable with the size the customer has ordered in plain text.
        if (size == 0.75) {
            pizzaSize = "Børnepizza";
        } else if (size == 1) {
            pizzaSize = "Standard pizza";
        } else if (size == 1.50) {
            pizzaSize = "Familiepizza";
        }
        //The receipt is printed to the user.

        System.out.printf("%23s", "Kvittering\n");
        System.out.printf("%24s", "Dinsen Pizza\n");
        System.out.printf("%32s", "Alsgade 38, 6400 Sønderborg\n");
        System.out.printf("%30s", "Dato: " + strDateTime); // This print the date and time of receipt creation.
        System.out.println("\n+----------------------------------+");
        System.out.println("| 1 x Pizza " + pizzaNumber + "  | " + priceCalc + " DKK |");
        System.out.println("+----------------------------------+");
        System.out.println("| Størrelse: " + pizzaSize +"         |");
        System.out.println("| Tilkøb af exstra toppings | " + customerToppings + " DKK |");
        System.out.println("+-----------------------------------+");
        System.out.println("| Nettobeløb: " + String.format("%.2f", udenMoms) + " DKK              |"); //This print the price without VAT.
        System.out.println("| Moms total, 25 %: " + String.format("%.2f", priceCalc - udenMoms) +  " DKK       |"); //This prints the VAT amount.
        System.out.println("| TOTAL: DKK " + priceCalc + ",-                 |"); //This prints the total customer price.
        System.out.println("+-----------------------------------+");
        System.out.println("|Tusind tak for besøget og på gensyn|");
        System.out.println("|    Din pizza er klar Kl: " + strPizzaReadyTime + "    |"); //This print the time the pizza is ready.
        System.out.println("+-----------------------------------+");


    }

}
