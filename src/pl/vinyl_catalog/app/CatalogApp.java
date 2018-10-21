package pl.vinyl_catalog.app;

import pl.vinyl_catalog.data.CatalogControl;

public class CatalogApp {
    public static final String APP_NAME = "Vinyl Catalog v0.7";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        CatalogControl vinylControl = new CatalogControl();
        vinylControl.controlLoop();
    }
}
