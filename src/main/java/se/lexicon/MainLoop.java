package se.lexicon;

public class MainLoop {

    public static boolean isRunning = true;

    public static void MainLoop() {

        while(isRunning) {


            TerminalUI.ContactPopulation();
            DataBase.AlphabeticSorting();
            TerminalUI.TerminalUI();

        }

    }


}
