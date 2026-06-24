package se.lexicon;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataBase {

    private String name;
    private String phoneNumber;
    private String email;


    public static ArrayList<DataBase> book = new ArrayList<>();

    public DataBase(String name, String phoneNumber, String email) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public static void addContact(String name, String number, String email) {

        boolean alreadyExists = book.stream().anyMatch(contact -> contact.getName().equalsIgnoreCase(name));
        if (alreadyExists) {
            Print.printLeft("Contact already exist.");
        } else {

            DataBase newContact = new DataBase(name, number, email);
            book.add(newContact);
        }
    }

    // 1. ADD A STATIC SEARCH METHOD
    public static DataBase getContactByName(String targetName) {
        for (DataBase contact : book) {
            if (contact.getName().equalsIgnoreCase(targetName)) {
                return contact; // Returns the specific matching object template
            }
        }
        return null; // Returns null if the name isn't in the book
    }

    public static DataBase getContactByNumber(String targetName) {
        for (DataBase contact : book) {
            if (contact.getPhoneNumber().equalsIgnoreCase(targetName)) {
                return contact; // Returns the specific matching object template
            }
        }
        return null; // Returns null if the name isn't in the book
    }

    public static DataBase getContactByMail(String targetName) {
        for (DataBase contact : book) {
            if (contact.getMail().equalsIgnoreCase(targetName)) {
                return contact; // Returns the specific matching object template
            }
        }
        return null; // Returns null if the name isn't in the book
    }

    // get by first letter

    public static ArrayList<DataBase> getContactByFirstLetter(String targetName) {

        ArrayList<DataBase> matches = new ArrayList<>();

        if (targetName == null || targetName.isEmpty()) {
            return matches;
        }

        for (DataBase contact : book) {

            if ( String.valueOf(contact.getName().charAt(0)).equalsIgnoreCase(targetName) ) {
                matches.add(contact);
            }
        }
        if (matches.isEmpty()) {

            Print.printLeft("No matches");
        }
        return matches;


    }




    // 2. ADD GETTER METHODS (So other classes can read individual variables)
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return email;
    }

}
