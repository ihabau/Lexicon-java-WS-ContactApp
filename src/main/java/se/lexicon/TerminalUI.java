package se.lexicon;
import java.util.*;

public class TerminalUI {



    public static void TerminalUI() {

        Print.centerCalc("Contact book");
        Print.printLeft("1: Search by name.");
        Print.printLeft("2: Search by number.");
        Print.printLeft("3: Search by mail.");
        Print.printLeft("4: Search by first letter.");
        Print.printLeft("5: Edit contact.");
        Print.printDevider();
        String choice = inputScanner();

        if ( choice.equalsIgnoreCase("1")) {
            pullByname();
        }

        if ( choice.equalsIgnoreCase("2")) {
            pullByNumber();
        }

        if ( choice.equalsIgnoreCase("3")) {
            pullByMail();

        }

        if ( choice.equalsIgnoreCase("4")) {
            pullByCharacter();
        }

        if (choice.equalsIgnoreCase("5")) {
            editContact();

        }



    }

    public static String pullByname() {


        Print.printLeft("Enter name!");
        String choice = inputScanner();
        DataBaseLogic.getByName(choice);
        return choice;

    }

    public static void pullByNumber() {

        Print.printLeft("Enter phone number!");
        String choice = inputScanner();
        DataBaseLogic.getByNumber(choice);
    }

    public static void pullByMail() {

        Print.printLeft("Enter mail address!");
        String choice = inputScanner();
        DataBaseLogic.getByMail(choice);
    }

    public static void pullByCharacter() {

        Print.printLeft("Enter first letter!");
        String choice = inputScanner();
        DataBaseLogic.getByFirstChar(choice);
        Print.printLeft("Enter name!");
        pullByname();

    }

    public static void editContact() {
        Print.printLeft("edit name!");
        String name = pullByname(); // change to String res to get original name
        Print.printLeft("1: Edit name.");
        Print.printLeft("2: Edit number.");
        Print.printLeft("3: Edit mail.");
        Print.printLeft("4: Edit all three.");

        String res = inputScanner();

        if (res.equalsIgnoreCase("1")) {
            Print.printLeft("Enter new name");
            String newName = inputScanner();
            DataBaseLogic.editByName(name, newName, null, null);

        }

        if (res.equalsIgnoreCase("2")) {

            Print.printLeft("Enter new phone number.");
            String newNumber = inputScanner();
            DataBaseLogic.editByName(name, null, newNumber, null);
        }

        if (res.equalsIgnoreCase("3")) {

            Print.printLeft("Enter new mail address.");
            String newMail = inputScanner();
            DataBaseLogic.editByName(name, null, null, newMail);
        }

        if (res.equalsIgnoreCase("4")) {

            Print.printLeft("Enter new name");
            String newName = inputScanner();

            Print.printLeft("Enter new phone number.");
            String newNumber = inputScanner();

            Print.printLeft("Enter new mail address.");
            String newMail = inputScanner();
            DataBaseLogic.editByName(name, newName, newNumber, newMail);
        }

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

    public static String inputScanner() {

        Scanner input = new Scanner(System.in);
        String res = input.next();
        return res;


    }

    public static void printBook() {

        DataBase.book.forEach(contact -> Print.printLeft(contact.getName()));

    }



}
