interface BillingProcessor {

    boolean processBill(String patientId, double amount);

    default void printDetailedBill(String patientId, double amount) {
        String receipt = formatDetailedBill(patientId, amount);
        System.out.println(receipt);
    }

    private String formatDetailedBill(String patientId, double amount) {
        return String.format("Hospital Bill for Patient %s: $%.2f processed.", patientId, amount);
    }

    static boolean validateInsuranceId(String insuranceId) {
        return insuranceId != null && insuranceId.matches("^[A-Za-z0-9-_]+$");
    }

    static boolean validatePatientId(String patientId) {
        return patientId != null && patientId.matches("HSP\\d{5}");
    }
}

public class HospitalBilling implements BillingProcessor {
    @Override
    public boolean processBill(String patientId, double amount) {
        return false;
    }

    public static void main(String[] args) {
        BillingProcessor billing = new HospitalBilling();
        String pid = "HSP10234";

        if (billing.processBill(pid, 1500)) {
            billing.printDetailedBill(pid, 1500);
        } else {
            System.out.println("Billing failed.");
        }

        // test
        System.out.println("Valid Insurance? " + BillingProcessor.validateInsuranceId("ABC1234567"));
        System.out.println("Valid Patient ID? " + BillingProcessor.validatePatientId("HSP10234"));

    }
}
