package pl.vinyl_catalog.data;


import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Catalog implements Serializable {
    public static final long serialVersionUID = -3612701643547982298L;

    private Map<String, Vinyl> vinyls;
    private Map<String, VinylUser> users;

    public int getVinylsNumber() {
        return vinyls.size();
    }

    public Map<String, Vinyl> getVinyls() {
        return vinyls;
    }

    public Map<String, VinylUser> getUsers() {
        return users;
    }


    public Catalog() {
        vinyls = new HashMap<>();
        users = new HashMap<>();
    }

    public void addVinyl(Vinyl vinyl) {
        vinyls.put(vinyl.getAlbumName(), vinyl);
    }

    public void addUser(VinylUser user) {
        users.put(user.getLastName(), user);
    }

    public void removeVinyl(Vinyl vinyl) {
        if (vinyls.containsValue(vinyl)) {
            vinyls.remove(vinyl.getAlbumName());
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Vinyl vinyl : vinyls.values()) {
            stringBuilder.append(vinyl);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static class AlphabeticalComparator implements Comparator<Vinyl> {
        @Override
        public int compare(Vinyl o1, Vinyl o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }


    public static class DateComparator implements Comparator<Vinyl> {
        @Override
        public int compare(Vinyl o1, Vinyl o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            Integer i1 = o1.getYearOfRelease();
            Integer i2 = o2.getYearOfRelease();
            return -i1.compareTo(i2);
        }
    }
}