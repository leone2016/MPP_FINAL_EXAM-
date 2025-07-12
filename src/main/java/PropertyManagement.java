import java.util.*;
import java.util.function.*;
class Property {
    private final String id;
    private final int bedrooms;
    private final double baseRent;
    private final double monthlyFees;

    public Property(String id, int bedrooms, double baseRent, double monthlyFees) {
        this.id = id;
        this.bedrooms = bedrooms;
        this.baseRent = baseRent;
        this.monthlyFees = monthlyFees;
    }

    public String getId() {
        return id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public double getBaseRent() {
        return baseRent;
    }

    public double getMonthlyFees() {
        return monthlyFees;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", bedrooms=" + bedrooms +
                ", baseRent=" + baseRent +
                ", monthlyFees=" + monthlyFees +
                '}';
    }
}
public class PropertyManagement {
    public static void main(String[] args) {
        //a
        Function<String, String> addressUpperCase = address -> address.toUpperCase();
        String rawAddress = "1000 n 4th MIU";
        System.out.println("Address in UuperCase: " + addressUpperCase.apply(rawAddress));

        //b
        BiFunction<Double, Double, Double> calculateRent = (baseRent, monthlyFees) -> baseRent + monthlyFees;
        double rent = calculateRent.apply(850.0, 100.0);
        System.out.println("total rent: $" + rent);

        //c
        List<Property> properties = Arrays.asList(
                new Property("PROP77", 2, 1000, 100),
                new Property("PROP78", 3, 1200, 200),
                new Property("PROP79", 1, 900, 50)
        );
        Comparator<Property> sortedByBedRoom = (p1, p2) -> Integer.compare(p2.getBedrooms(), p1.getBedrooms());
        List<Property> sortedProps = properties.stream()
                        .sorted(sortedByBedRoom).toList();
        System.out.println("sorted by beedrooms: " + sortedProps);
        //d
        BiFunction<String, String, String> fullName = (first, last) -> first + " " + last;
        System.out.println("owner name: " + fullName.apply("Leo", "Medina"));


        //e
        BiFunction<String, Integer, String> generateRequestId = (propertyId, requestNumber) -> propertyId + "-" + requestNumber;
        System.out.println("maintenance request id: " + generateRequestId.apply("PROP77", 21));

    }
}
