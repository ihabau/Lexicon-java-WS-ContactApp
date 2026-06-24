package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        TerminalUI.ContactPopulation();
        DataBase.AlphabeticSorting();
        TerminalUI.TerminalUI();

        TerminalUI.printBook();


        /*
        DataBaseLogic.getByName("bo b ");
        DataBaseLogic.getByNumber("0701234567");
        DataBaseLogic.getByMail("bob@lexicon.se");



        DataBaseLogic.getByFirstChar("b");

        DataBaseLogic.removeByName("bob");
        Print.printLeft("removed bob.");
        Print.printLeft("edit amber and beast phone and mail.");
        DataBaseLogic.editByName("amber", "0709876554", "amber@gmail.com");
        DataBaseLogic.editByName("beast", "0711111112", "beastTheGreat@gmail.com");
        DataBaseLogic.getByFirstChar("b");
        DataBaseLogic.getByFirstChar("a");
        */
    }

}
