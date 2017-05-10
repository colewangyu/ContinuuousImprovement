public class RegularMovie extends Movie {
    public RegularMovie(String _title, int _priceCode) {
        super(_title, _priceCode);
    }

    public double getThisAmount(int daysRented) {
        // determine amounts for each line
        double thisAmount = 0;
        thisAmount += 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }
}
