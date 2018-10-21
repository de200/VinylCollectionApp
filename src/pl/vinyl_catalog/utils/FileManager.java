package pl.vinyl_catalog.utils;

import pl.vinyl_catalog.data.Catalog;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;

public class FileManager {
    public static final String FILE_NAME = "catalog.obj";

    public void writeCatalogToFile(Catalog catalog) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(catalog);
        } catch (FileNotFoundException e) {
            System.err.println("File " + FILE_NAME + " not found!");
        } catch (IOException e) {
            System.err.println("Error while saving data to file " + FILE_NAME);
        }
    }

    public Catalog readCatalogFromFile() throws FileSystemNotFoundException, IOException, ClassNotFoundException {
        Catalog catalog = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            catalog = (Catalog) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File " + FILE_NAME + " not found!");
            throw e;
        } catch (IOException e) {
            System.err.println("Incorrect file format!");
            throw e;
        }
         return catalog;
    }
}

