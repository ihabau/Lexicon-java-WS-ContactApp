package se.lexicon;

import java.util.ArrayList;

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

        // 2. Retrieve the specific object matching the name
        DataBase individualContact = DataBase.getContactByNumber(number);

        // 3. Extract and use the individual data elements
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

        // 2. Retrieve the specific object matching the name
        DataBase individualContact = DataBase.getContactByMail(mail);

        // 3. Extract and use the individual data elements
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
                // testing print
                String contactName =  contact.getName();
                String contactPhone = contact.getPhoneNumber();
                String contactEmail = contact.getMail();

                Print.printLeft("Extracted Name: " + contactName);
                //Print.printLeft("Extracted Phone: " + contactPhone);
                //Print.printLeft("Extracted Email: " + contactEmail);
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

}