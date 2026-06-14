import java.util.Scanner;


class Consumer {
    private int id;
    private String name;
    private int unitsConsumed;

    
    public Consumer(int id, String name, int unitsConsumed) {
        this.id = id;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}


class TariffCalculator {

    public double generateBill(Consumer consumer) {
        int units = consumer.getUnitsConsumed();
        double bill = 0;

        if (units <= 100) {
            bill = units * 1.5;
        } else if (units <= 200) {
            bill = (100 * 1.5) + ((units - 100) * 2.5);
        } else if (units <= 300) {
            bill = (100 * 1.5) + (100 * 2.5) + ((units - 200) * 4.0);
        } else {
            bill = (100 * 1.5) + (100 * 2.5) + (100 * 4.0) + ((units - 300) * 6.0);
        }
        double fixedCharge = 50;
        bill += fixedCharge;

        return bill;
    }
}


public class bill {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Consumer ID: ");
        int id = sc.nextInt();

        sc.nextLine(); 

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        
        Consumer consumer = new Consumer(id, name, units);
        TariffCalculator calculator = new TariffCalculator();

        
        double totalBill = calculator.generateBill(consumer);

        
        System.out.println("\n----- Electricity Bill -----");
        System.out.println("Consumer ID: " + consumer.getId());
        System.out.println("Name: " + consumer.getName());
        System.out.println("Units Consumed: " + consumer.getUnitsConsumed());
        System.out.println("Total Electricity Bill: " + totalBill);

        
    }
}