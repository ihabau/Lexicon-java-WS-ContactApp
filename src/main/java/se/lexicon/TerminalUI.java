package se.lexicon;
import java.util.*;

public class TerminalUI {



    public static void TerminalUI() {

        while ( true ) {
        Print.printCenter("Contact book");
        Print.printLeft("1: Search by name.");
        Print.printLeft("2: Search by number.");
        Print.printLeft("3: Search by mail.");
        Print.printLeft("4: Search by first letter.");
        Print.printLeft("5: Edit contact.");
        Print.printLeft("6: Add contact.");
        Print.printLeft("7: Remove contact.");
        Print.printLeft("8: Show all contacts.");
        Print.printLeft("9: Exit.");
        Print.printDevider();
            String choice = DataBaseLogic.inputScanner();

            switch (choice) {
                case "1" -> pullByname();
                case "2" -> pullByNumber();
                case "3" -> pullByMail();
                case "4" -> pullByCharacter();
                case "5" -> editContact();
                case "6" -> addContact();
                case "7" -> removeContact();
                case "8" -> DataBaseLogic.printBook();
                case "9" -> {
                    Print.printLeft("Goodbye");
                    MainLoop.isRunning = false;
                    return;
                }
                default -> {
                    Print.printLeft("Invalid choice. Please select options 1-8.");
                    continue;
                }
            }
            Print.printLeft("Press Enter to go back to menu!");
            DataBaseLogic.inputScanner();
        }

    }

    public static String pullByname() {

        Print.printLeft("Enter name!");
        String choice = DataBaseLogic.inputScanner();
        DataBaseLogic.getByName(choice);
        return choice;
    }

    public static void pullByNumber() {

        Print.printLeft("Enter phone number!");
        String choice = DataBaseLogic.inputScanner();
        DataBaseLogic.getByNumber(choice);
    }

    public static void pullByMail() {

        Print.printLeft("Enter mail address!");
        String choice = DataBaseLogic.inputScanner();
        DataBaseLogic.getByMail(choice);
    }

    public static void pullByCharacter() {

        Print.printLeft("Enter first letter!");
        String choice = DataBaseLogic.inputScanner();
        DataBaseLogic.getByFirstChar(choice);
        pullByname();
    }

    public static void editContact() {
        Print.printLeft("edit name!");
        String name = pullByname(); // change to String res to get original name
        Print.printLeft("1: Edit name.");
        Print.printLeft("2: Edit number.");
        Print.printLeft("3: Edit mail.");
        Print.printLeft("4: Edit all three.");
        Print.printLeft("5: Exit.");

        String choice = DataBaseLogic.inputScanner();

        switch (choice) {

            case "1" -> {
                Print.printLeft("Enter new name");
                String newName = DataBaseLogic.inputScanner();
                DataBaseLogic.editByName(name, newName, null, null);
            }
            case "2" -> {
                Print.printLeft("Enter new phone number.");
                String newNumber = DataBaseLogic.inputScanner();
                DataBaseLogic.editByName(name, null, newNumber, null);
            }
            case "3" -> {
                Print.printLeft("Enter new mail address.");
                String newMail = DataBaseLogic.inputScanner();
                DataBaseLogic.editByName(name, null, null, newMail);
            }
            case "4" -> {
                Print.printLeft("Enter new name");
                String newName = DataBaseLogic.inputScanner();

                Print.printLeft("Enter new phone number.");
                String newNumber = DataBaseLogic.inputScanner();

                Print.printLeft("Enter new mail address.");
                String newMail = DataBaseLogic.inputScanner();
                DataBaseLogic.editByName(name, newName, newNumber, newMail);
            }
            case "5" -> {
                onReturn();
            }
            default -> Print.printLeft("Invalid choice select option 1-5.");
        }
    }

    public static void addContact() {

        Print.printCenter("Add new contact");
        while (true) {

            Print.printLeft("Enter name.");
            String name = DataBaseLogic.inputScanner();

            Print.printLeft("Enter number.");
            String number = DataBaseLogic.inputScanner();

            Print.printLeft("Enter mail address.");
            String mail = DataBaseLogic.inputScanner();

            boolean res = DataBase.addContact(name, number, mail);

            if (!res) {

                Print.printLeft("Try again? Y/N");
                String res2 = DataBaseLogic.inputScanner();

                if (res2.equalsIgnoreCase("y")) {
                    continue;
                }
            }

            onReturn();
            return;
        }
    }

    public static void removeContact() {
        Print.printLeft("Enter name to be reomved.");
        String name = pullByname();
        Print.printLeft("Delete contact: " + name + "? Y/N");

        while (true) {
            String choice = DataBaseLogic.inputScanner().toUpperCase();
            switch (choice) {
                case "Y" -> {
                    DataBaseLogic.removeByName(name);
                    return;
                }
                case "N" -> {
                    onReturn();
                    return;
                }
                default -> {
                    Print.printLeft("Wrong input try again.");
                    continue;
                }
            }
        }
    }


    public static void onReturn() {
        Print.printCenter("Returning to main screen.");
        return;
    }


    public static void ContactPopulation() {

        // test contacts
        DataBase.addContact("bob", "0701234567", "bob@lexicon.se");
        DataBase.addContact("Susane", "0701234567", "bob@lexicon.se");
        DataBase.addContact("Anna", "0701234567", "bob@lexicon.se");
        DataBase.addContact("bo", "0701234567", "bob@lexicon.se");
        DataBase.addContact("beast", "0701234567", "bob@lexicon.se");
        DataBase.addContact("amber", "0701234567", "bob@lexicon.se");
        DataBase.addContact("charlie", "0701234567", "bob@lexicon.se");
    }

}
