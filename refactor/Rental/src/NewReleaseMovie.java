public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String _title, int _priceCode) {
        super(_title, _priceCode);
    }

    public double getThisAmount(int daysRented) {
        // determine amounts for each line
        double thisAmount = 0;
        thisAmount += daysRented * 3;
        return thisAmount;
    }

    public int getRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        else
            return 1;
    }
}
