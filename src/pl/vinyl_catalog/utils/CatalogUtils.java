package pl.vinyl_catalog.utils;

import pl.vinyl_catalog.data.Catalog;
import pl.vinyl_catalog.data.Vinyl;
import pl.vinyl_catalog.data.VinylUser;


import java.util.*;


public class CatalogUtils {

    public static void printVinyls(Catalog catalog) {
        List<Vinyl> vinyls = new ArrayList<>();
        vinyls.addAll(catalog.getVinyls().values());
        Collections.sort(vinyls, new Catalog.AlphabeticalComparator());
        int countVinyls = 0;
        for (Vinyl vinyl : vinyls) {
            if (vinyl instanceof Vinyl) {
                System.out.println(vinyl);
                countVinyls++;
            }
        }
        if(countVinyls==0){
            System.out.println("No vinyls in catalog");
        }
    }

    public static void printUsers(Catalog catalog){
        List<VinylUser> users = new ArrayList<>();
        users.addAll(catalog.getUsers().values());
        Collections.sort(users, new Comparator<VinylUser>(){
            @Override
            public int compare(VinylUser o1, VinylUser o2){
                return o1.getLastName().compareTo(o2.getLastName());
            }
                });

        for(VinylUser user : users){
            System.out.println(user);
        }
    }
}
