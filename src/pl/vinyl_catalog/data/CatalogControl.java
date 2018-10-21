package pl.vinyl_catalog.data;

import pl.vinyl_catalog.utils.CatalogUtils;
import pl.vinyl_catalog.utils.DataReader;
import pl.vinyl_catalog.utils.FileManager;

import java.io.IOException;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class CatalogControl {

    private DataReader dataReader;
    private FileManager fileManager;

    private Catalog catalog;

    public CatalogControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();
        try {
            catalog = fileManager.readCatalogFromFile();
            System.out.println("Catalog data has been loaded from file");
        } catch (ClassNotFoundException | IOException e) {
            catalog = new Catalog();
            System.out.println("New catalog database has been created ");
        }
    }

    public void printOptions() {
        System.out.println("Choose option:");
        for (Option o : Option.values()) {
            System.out.println(o);
        }
    }

    private void addVinyl() {
        Vinyl vinyl = dataReader.readAndCreateVinyl();
        catalog.addVinyl(vinyl);
    }

    private void removeVinyl() {
        Vinyl vinyl = dataReader.findAndRemoveVinyl((Collection<Vinyl>) catalog.getVinyls());
        catalog.removeVinyl(vinyl);
    }

    private void printVinyls() {
        CatalogUtils.printVinyls(catalog);
    }

    private void addUser(){
        VinylUser user = dataReader.readAndCreateUser();
        catalog.addUser(user);
    }

    private void printUsers(){
        CatalogUtils.printUsers(catalog);
    }

    private void exit() {
        fileManager.writeCatalogToFile(catalog);
    }

    public void controlLoop() {
        Option option = null;
        while (option != Option.EXIT) {
            try {
                printOptions();
                option = Option.createFromInt(dataReader.getInt());
                switch (option) {
                    case ADD_VINYL:
                        addVinyl();
                        break;
                    case PRINT_VINYLS:
                        printVinyls();
                        break;
                    case REMOVE_VINYL:
                        removeVinyl();
                        break;
                    case ADD_USER:
                        addUser();
                        break;
                    case PRINT_USERS:
                        printUsers();
                        break;
                    case EXIT:
                        exit();

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid data, album not added");
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Invalid option, try again:");
            }
        }
        dataReader.close();
    }

    private enum Option {
        EXIT(0, "Exit"),
        ADD_VINYL(1, "Add new album to catalog"),
        PRINT_VINYLS(2, "Print albums in catalog"),
        REMOVE_VINYL(3, "Remove album form catalog"),
        ADD_USER(4, "Add new user"),
        PRINT_USERS(5, "Show list of users");

        private int value;
        private String description;


        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException("No such an element exists!");
            }
            return result;
        }
    }

}
