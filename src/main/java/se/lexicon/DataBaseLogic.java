package se.lexicon;

import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseLogic {

    public static DataBase getByName(String name) {

        // 2. Retrieve the specific object matching the name
        DataBase individualContact = DataBase.getContactByName(name);

        // 3. Extract and use the individual data elements
        if (individualContact != null) {
            String contactName = individualContact.getName();
            String contactPhone = individualContact.getPhoneNumber();
            String contactEmail = individualContact.getMail();

            Print.printLeft("Extracted Name: " + contactName);
            Print.printLeft("Extracted Phone: " + contactPhone);
            Print.printLeft("Extracted Email: " + contactEmail);
            return individualContact;
        } else {
            Print.printLeft("That contact does not exist in the book.");
            return null;
        }
    }
    public static void getByNumber(String number) {

        DataBase individualContact = DataBase.getContactByNumber(number);

        if (individualContact != null) {
            String contactName = individualContact.getName();
            String contactPhone = individualContact.getPhoneNumber();
            String contactEmail = individualContact.getMail();

            Print.printLeft("Extracted Name: " + contactName);
            Print.printLeft("Extracted Phone: " + contactPhone);
            Print.printLeft("Extracted Email: " + contactEmail);
        } else {
            Print.printLeft("That contact does not exist in the book.");
        }
    }
    public static void getByMail(String mail) {

        DataBase individualContact = DataBase.getContactByMail(mail);

        if (individualContact != null) {
            String contactName = individualContact.getName();
            String contactPhone = individualContact.getPhoneNumber();
            String contactEmail = individualContact.getMail();

            Print.printLeft("Extracted Name: " + contactName);
            Print.printLeft("Extracted Phone: " + contactPhone);
            Print.printLeft("Extracted Email: " + contactEmail);
        } else {
            Print.printLeft("That contact does not exist in the book.");
        }
    }

    public static void getByFirstChar(String ch) {

        // 2. Retrieve the specific object matching the name
        ArrayList<DataBase> individualContact = DataBase.getContactByFirstLetter(ch);

        // 3. Extract and use the individual data elements
        individualContact.forEach(contact -> {

            if (contact != null) {
                String contactName =  contact.getName();

                Print.printLeft("Extracted Name: " + contactName);
            } else {
                Print.printLeft("That contact does not exist in the book.");
            }
        });
    }

    public static void  removeByName (String name) {

        DataBase.book.removeIf( contact ->  contact.getName().equalsIgnoreCase(name) );
    }

    public static void editByName(String name, String newName, String number, String mail) {

       // rethink this part
        DataBase contact = getByName(name);

        String contactName =  contact.getName();
        String contactPhone = contact.getPhoneNumber();
        String contactEmail = contact.getMail();

        if (newName != null || !newName.isEmpty() ) {
            contactName = newName;
        }
        if (newName != null || !number.isEmpty()) {
            contactPhone = number;
        }
        if (newName != null || !mail.isEmpty() ) {
            contactEmail = mail;
        }

        DataBaseLogic.removeByName(name);
        DataBase.addContact(contactName, contactPhone, contactEmail);
        DataBase.AlphabeticSorting();
    }

    public static void printBook() {

        DataBase.book.forEach(contact -> Print.printLeft(contact.getName()));
        Print.printLeft("Press Enter to go back to main menu.");
        inputScanner();
    }

    public static String inputScanner() {

        Scanner input = new Scanner(System.in);
        String res = input.nextLine();
        return res;
    }
}