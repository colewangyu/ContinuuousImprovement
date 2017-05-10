import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String _name) {
        this._name = _name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental rental) {
        this._rentals.addElement(rental);
    }

    /**
     * 生成报表
     *
     * @return
     */
    public String statement() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getThisAmount()) + "\n";

        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getRenterPoints()) + " renter points.";
        return result;
    }

    /**
     * 生成HTML报表
     *
     * @return
     */
    public String HTMLStatement() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getThisAmount()) + "\n";

        }
        // add footer lines
        result += "<p>Amount owed is <em>" + String.valueOf(getTotalAmount()) + "</em><p>\n";
        result += "You earned <em>" + String.valueOf(getRenterPoints()) + "</em> renter points.";
        return result;
    }


    private double getTotalAmount() {
        double totalAmount;
        Rental each;
        totalAmount = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            each = rentals.nextElement();
            totalAmount += each.getThisAmount();
        }
        return totalAmount;
    }

    private double getRenterPoints() {
        double renterPoints;
        Rental each;
        Enumeration<Rental> rentals;

        renterPoints = 0;
        rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            each = rentals.nextElement();
            renterPoints += each.getMovie().getRenterPoints(each.getDaysRented());
        }
        return renterPoints;
    }
}
