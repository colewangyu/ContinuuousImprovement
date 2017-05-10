public class ChildMovie extends Movie {
    public ChildMovie(String _title, int _priceCode) {
        super(_title, _priceCode);
    }

    public double getThisAmount(int daysRented) {
        // determine amounts for each line
        double thisAmount = 0;
        thisAmount += 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }
}
