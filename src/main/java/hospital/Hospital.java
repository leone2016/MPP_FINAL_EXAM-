package hospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Medication {
    private final String name;

    public Medication(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Painkiller extends Medication {
    public Painkiller(String name) {
        super(name);
    }
}

class Antibiotic extends Medication {
    public Antibiotic(String name) {
        super(name);
    }
}

public class Hospital {

    private static List<Painkiller> painkillers = new ArrayList<>();
    public static void printMedicationName(List<? extends Medication> medication){
        medication.forEach(System.out::println);
    }
    public static void addPainkiller(List<? super Painkiller> painkill) {
        painkill.add(new Painkiller("Ibuprofen"));
        painkill.add(new Painkiller("Acetaminophen"));
        painkill.add(new Painkiller("Aspirin"));
    }
    public static void main(String[] args) {
        List<Medication> medications = Arrays.asList(
                new Medication("Saline"),
                new Medication("Vitamine C")
        );
        painkillers =  Arrays.asList(
                new Painkiller("Ibuprofen"),
                new Painkiller("ASpirin")
        );
        List<Antibiotic> antibiotics =  Arrays.asList(
                new Antibiotic("Amoxicillin")
        );

        printMedicationName(medications);
        printMedicationName(painkillers);
        printMedicationName(antibiotics);
        List<Painkiller> painkillers2 = new ArrayList<>();

        addPainkiller(painkillers2);

        System.out.println("Painkillers added");
        printMedicationName(painkillers2);


    }
}
