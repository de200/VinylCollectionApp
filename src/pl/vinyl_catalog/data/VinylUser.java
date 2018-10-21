package pl.vinyl_catalog.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VinylUser extends User {

    private static final long serialVersionUID = 4299529514259100169L;

    private List<Vinyl> vinylHistory;
    private List<Vinyl> borrowedVinyls;

    public List<Vinyl> getVinylHistory() {
        return vinylHistory;
    }

    public List<Vinyl> getBorrowedVinyls() {
        return borrowedVinyls;
    }

    public VinylUser(String firstName, String lastName){
        super(firstName, lastName);
        vinylHistory = new ArrayList<>();
        borrowedVinyls = new ArrayList<>();
    }

    private void addVinylToHistory(Vinyl vinyl){
        vinylHistory.add(vinyl);
    }

    public void borrowVinyl(Vinyl vinyl){
        borrowedVinyls.add(vinyl);
    }

    public boolean returnVinyl(Vinyl vinyl) {
        boolean result = false;
        if(borrowedVinyls.remove(vinyl)){
            result = true;
            addVinylToHistory(vinyl);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VinylUser)) return false;
        if (!super.equals(o)) return false;
        VinylUser vinylUser = (VinylUser) o;
        return Objects.equals(getVinylHistory(), vinylUser.getVinylHistory()) &&
                Objects.equals(getBorrowedVinyls(), vinylUser.getBorrowedVinyls());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVinylHistory(), getBorrowedVinyls());
    }
}
