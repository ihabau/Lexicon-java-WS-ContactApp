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


    private static boolean isPopulated = false;

    public static void ContactPopulation() {
        if (isPopulated) return;
        isPopulated = true;

        String[][] contacts = {
            // A - 4 contacts
            {"Alice",      "0701000001", "alice@gmail.com"},
            {"Adrian",     "0701000002", "adrian@yahoo.com"},
            {"Amelia",     "0701000003", "amelia@outlook.com"},
            {"Arthur",     "0701000004", "arthur@protonmail.com"},
            // B - 4 contacts
            {"Benjamin",   "0701000005", "benjamin@gmail.com"},
            {"Brooke",     "0701000006", "brooke@yahoo.com"},
            {"Blake",      "0701000007", "blake@icloud.com"},
            {"Bianca",     "0701000008", "bianca@lexicon.se"},
            // C - 4 contacts
            {"Charlotte",  "0701000009", "charlotte@gmail.com"},
            {"Caleb",      "0701000010", "caleb@yahoo.com"},
            {"Chloe",      "0701000011", "chloe@outlook.com"},
            {"Carter",     "0701000012", "carter@aol.com"},
            // D - 4 contacts
            {"David",      "0701000013", "david@gmail.com"},
            {"Diana",      "0701000014", "diana@yahoo.com"},
            {"Derek",      "0701000015", "derek@protonmail.com"},
            {"Daisy",      "0701000016", "daisy@lexicon.se"},
            // E - 3 contacts
            {"Emma",       "0701000017", "emma@gmail.com"},
            {"Ethan",      "0701000018", "ethan@yahoo.com"},
            {"Eva",        "0701000019", "eva@outlook.com"},
            // F - 3 contacts
            {"Fiona",      "0701000020", "fiona@gmail.com"},
            {"Felix",      "0701000021", "felix@yahoo.com"},
            {"Faith",      "0701000022", "faith@icloud.com"},
            // G - 4 contacts
            {"George",     "0701000023", "george@gmail.com"},
            {"Grace",      "0701000024", "grace@yahoo.com"},
            {"Gavin",      "0701000025", "gavin@outlook.com"},
            {"Gemma",      "0701000026", "gemma@aol.com"},
            // H - 4 contacts
            {"Henry",      "0701000027", "henry@gmail.com"},
            {"Hannah",     "0701000028", "hannah@yahoo.com"},
            {"Hugo",       "0701000029", "hugo@protonmail.com"},
            {"Hailey",     "0701000030", "hailey@lexicon.se"},
            // I - 3 contacts
            {"Isaac",      "0701000031", "isaac@gmail.com"},
            {"Iris",       "0701000032", "iris@yahoo.com"},
            {"Ivan",       "0701000033", "ivan@outlook.com"},
            // J - 4 contacts
            {"Julia",      "0701000034", "julia@gmail.com"},
            {"Jason",      "0701000035", "jason@yahoo.com"},
            {"Jade",       "0701000036", "jade@icloud.com"},
            {"Jasper",     "0701000037", "jasper@lexicon.se"},
            // K - 3 contacts
            {"Kevin",      "0701000038", "kevin@gmail.com"},
            {"Kim",        "0701000039", "kim@yahoo.com"},
            {"Kai",        "0701000040", "kai@outlook.com"},
            // L - 4 contacts
            {"Lily",       "0701000041", "lily@gmail.com"},
            {"Liam",       "0701000042", "liam@yahoo.com"},
            {"Luna",       "0701000043", "luna@protonmail.com"},
            {"Logan",      "0701000044", "logan@aol.com"},
            // M - 4 contacts
            {"Mia",        "0701000045", "mia@gmail.com"},
            {"Mason",      "0701000046", "mason@yahoo.com"},
            {"Maya",       "0701000047", "maya@outlook.com"},
            {"Morgan",     "0701000048", "morgan@lexicon.se"},
            // N - 3 contacts
            {"Noah",       "0701000049", "noah@gmail.com"},
            {"Nora",       "0701000050", "nora@yahoo.com"},
            {"Nathan",     "0701000051", "nathan@icloud.com"},
            // O - 3 contacts
            {"Olivia",     "0701000052", "olivia@gmail.com"},
            {"Oscar",      "0701000053", "oscar@yahoo.com"},
            {"Owen",       "0701000054", "owen@outlook.com"},
            // P - 3 contacts
            {"Peter",      "0701000055", "peter@gmail.com"},
            {"Piper",      "0701000056", "piper@yahoo.com"},
            {"Paige",      "0701000057", "paige@protonmail.com"},
            // Q - 3 contacts
            {"Quinn",      "0701000058", "quinn@gmail.com"},
            {"Quincy",     "0701000059", "quincy@yahoo.com"},
            {"Queen",      "0701000060", "queen@aol.com"},
            // R - 4 contacts
            {"Ryan",       "0701000061", "ryan@gmail.com"},
            {"Rachel",     "0701000062", "rachel@yahoo.com"},
            {"Riley",      "0701000063", "riley@outlook.com"},
            {"Ruby",       "0701000064", "ruby@lexicon.se"},
            // S - 4 contacts
            {"Samuel",     "0701000065", "samuel@gmail.com"},
            {"Sarah",      "0701000066", "sarah@yahoo.com"},
            {"Simon",      "0701000067", "simon@icloud.com"},
            {"Savannah",   "0701000068", "savannah@lexicon.se"},
            // T - 4 contacts
            {"Thomas",     "0701000069", "thomas@gmail.com"},
            {"Taylor",     "0701000070", "taylor@yahoo.com"},
            {"Tiffany",    "0701000071", "tiffany@outlook.com"},
            {"Theo",       "0701000072", "theo@protonmail.com"},
            // U - 3 contacts
            {"Uma",        "0701000073", "uma@gmail.com"},
            {"Uriah",      "0701000074", "uriah@yahoo.com"},
            {"Ulysses",    "0701000075", "ulysses@aol.com"},
            // V - 3 contacts
            {"Victor",     "0701000076", "victor@gmail.com"},
            {"Vanessa",    "0701000077", "vanessa@yahoo.com"},
            {"Vance",      "0701000078", "vance@outlook.com"},
            // W - 3 contacts
            {"Wendy",      "0701000079", "wendy@gmail.com"},
            {"William",    "0701000080", "william@yahoo.com"},
            {"Willow",     "0701000081", "willow@icloud.com"},
            // X - 3 contacts
            {"Xavier",     "0701000082", "xavier@gmail.com"},
            {"Xena",       "0701000083", "xena@yahoo.com"},
            {"Xander",     "0701000084", "xander@outlook.com"},
            // Y - 3 contacts
            {"Yara",       "0701000085", "yara@gmail.com"},
            {"Yosef",      "0701000086", "yosef@yahoo.com"},
            {"Yvonne",     "0701000087", "yvonne@protonmail.com"},
            // Z - 3 contacts
            {"Zach",       "0701000088", "zach@gmail.com"},
            {"Zoe",        "0701000089", "zoe@yahoo.com"},
            {"Zane",        "0701000090", "zane@outlook.com"}
        };

        for (String[] c : contacts) {
            DataBase.addContact(c[0], c[1], c[2]);
        }
    }

}
