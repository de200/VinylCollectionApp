package pl.vinyl_catalog.utils;

import pl.vinyl_catalog.data.User;
import pl.vinyl_catalog.data.Vinyl;
import pl.vinyl_catalog.data.VinylUser;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;


public class DataReader {
    private Scanner scanner;

    public DataReader() {
        scanner = new Scanner(System.in);
    }

    public void close() {
        scanner.close();
    }

    public int getInt() throws NumberFormatException {
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("Invalid number format");
        } finally {
            scanner.nextLine();
        }
        return number;
    }

    public Vinyl readAndCreateVinyl() throws InputMismatchException {
        System.out.println("Artist: ");
        String artist = scanner.nextLine();
        System.out.println("Name of album: ");
        String albumName = scanner.nextLine();
        System.out.println("Genre: ");
        String genre = scanner.nextLine();
        System.out.println("Format: ");
        String format = scanner.nextLine();
        System.out.println("Type of release: ");
        String releaseType = scanner.nextLine();
        System.out.println("Year of release:");
        int yearOfRelease = 0;
        try {
            yearOfRelease = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw e;
        }
        System.out.println("Label: ");
        String label = scanner.nextLine();

        return new Vinyl(artist, albumName, genre, format, releaseType, yearOfRelease, label);
    }

    public Vinyl findAndRemoveVinyl(Collection<Vinyl> vinyls ){
        System.out.println("Input artist name whose album you want to remove:");
        String artist = scanner.nextLine();
        System.out.println("Input album name you want to remove:");
        String albumName = scanner.nextLine();
        Vinyl vinylToReomve = null;
        for(Vinyl vinyl: vinyls){
            if(artist.equals(vinyl.getArtist()) && albumName.equals(vinyl.getAlbumName())){
                System.out.println("Album " + vinyl.getAlbumName() + " of " + vinyl.getArtist() + " has been removed from catalog");
                vinylToReomve = vinyl;
            }
        }
        if(vinylToReomve == null) {
            System.out.println("Vinyl " + artist + " " + albumName + " does not exist in catalog");
        }
        return vinylToReomve;
    }

    public VinylUser readAndCreateUser(){
        System.out.println("First name:");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();

        return new VinylUser(firstName, lastName);
    }

}

