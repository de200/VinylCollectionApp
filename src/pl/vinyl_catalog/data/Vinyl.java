package pl.vinyl_catalog.data;

import java.io.Serializable;
import java.util.Objects;

public class Vinyl implements Serializable, Comparable<Vinyl> {
    private static final long serialVersionUID = 3122382048462315770L;

    private String artist;
    private String albumName;
    private String genre;
    private String format;
    private String releaseType;
    private int yearOfRelease;
    private String label;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(String releaseType) {
        this.releaseType = releaseType;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Vinyl(String artist, String albumName, String genre, String format, String releaseType, int yearOfRelease, String label) {
        setArtist(artist);
        setAlbumName(albumName);
        setGenre(genre);
        setFormat(format);
        setReleaseType(releaseType);
        setYearOfRelease(yearOfRelease);
        setLabel(label);
    }

    public Vinyl(Vinyl vinyl) {
        this(vinyl.getArtist(), vinyl.getAlbumName(), vinyl.getGenre(), vinyl.getFormat(), vinyl.getReleaseType(), vinyl.getYearOfRelease(), vinyl.getLabel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vinyl)) return false;
        Vinyl vinyl = (Vinyl) o;
        return getYearOfRelease() == vinyl.getYearOfRelease() &&
                Objects.equals(getArtist(), vinyl.getArtist()) &&
                Objects.equals(getAlbumName(), vinyl.getAlbumName()) &&
                Objects.equals(getGenre(), vinyl.getGenre()) &&
                Objects.equals(getFormat(), vinyl.getFormat()) &&
                Objects.equals(getReleaseType(), vinyl.getReleaseType()) &&
                Objects.equals(getLabel(), vinyl.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtist(), getAlbumName(), getGenre(), getFormat(), getReleaseType(), getYearOfRelease(), getLabel());
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append("Artist: ");
        print.append(getArtist());
        print.append("\nAlbum name: ");
        print.append(getAlbumName());
        print.append("\nGenre: ");
        print.append(getGenre());
        print.append("\nFormat: ");
        print.append(getFormat());
        print.append("\nType of release: ");
        print.append(getReleaseType());
        print.append("\nYear of release: ");
        print.append(getYearOfRelease());
        print.append("\nLabel: ");
        print.append(getLabel());
        print.append("\n");

        return print.toString();
    }

    @Override
    public int compareTo(Vinyl o) {
        int albumCompare = albumName.compareTo(o.getAlbumName());
        if(albumCompare !=0){
            return albumCompare;
        }
        return artist.compareTo(o.getArtist());
    }
}
