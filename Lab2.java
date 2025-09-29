import java.util.Random;
import java.util.Scanner;
public class Lab2{
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter Service Code (P/L/T/C):");
        String Code= input.nextLine().toUpperCase();
        double metricValue = 0; 
        int roundedMetric = 0;  
        double bmi = 0;
        String category="";
        String summary = "";

        switch (Code){
            case "P":
                System.out.println("Go to: Pharmacy");
                break;
            case "L":
                System.out.println("Go to: Lab Desk");
                break;
            case "T":
                System.out.println("Go to: Triage Desk");
                System.out.println("Select health metric: 1=BMI, 2=Dosage, 3=Trig helper");
                int Metric= input.nextInt();
                switch (Metric) {
                    case 1:
                        System.out.print("Enter weight (kg): ");
                        double weight = input.nextDouble();
                        System.out.print("Enter height (m): ");
                        double height = input.nextDouble();
                        bmi = weight / Math.pow(height, 2);
                        metricValue = Math.round(bmi * 10) / 10.0;
                        roundedMetric = (int) Math.round(bmi);
                        
                        bmi = weight / Math.pow(height, 2);
                        metricValue = Math.round(bmi * 10) / 10.0; // round to 1 decimal
                        roundedMetric = (int) Math.round(bmi);


                        if (bmi < 18.5) {
                            category = "Underweight";
                            System.out.println("Underweight");
                        }
                        else if (bmi < 25.0) {
                            category = "Normal";
                            System.out.println("Normal");
                        }
                        else if (bmi < 30.0) {
                            category = "Overweight";
                            System.out.println("Overweight");
                        }
                        else {
                            category = "Obese";
                            System.out.println("Obese");
                        }
                       
                        System.out.println("BMI: " + metricValue + " Category: " + category);
                        break;
                        
                        
                    case 2:
                        System.out.print("Enter required dosage (mg): ");
                        double dosage = input.nextDouble();
                        double tablets = Math.ceil(dosage / 250.0);
                        metricValue = tablets;
                        roundedMetric = (int) tablets;
                        System.out.println("Tablets: " + (int) tablets);
                    break;

                    case 3:
                        System.out.print("Enter angle in degrees: ");
                        double degrees = input.nextDouble();
                        double radians = Math.toRadians(degrees);

                        double sin = Math.round(Math.sin(radians) * 1000) / 1000.0;
                        double cos = Math.round(Math.cos(radians) * 1000) / 1000.0;

                        System.out.println("sin(" + degrees + ") = " + sin);
                        System.out.println("cos(" + degrees + ") = " + cos);

                        metricValue = sin; // store sin for display code
                        roundedMetric = (int) Math.round(sin * 100);
                    break;

                    default:
                        System.out.println("Invalid metric option.");
                        break;
                }
                break;
            case "C":
                System.out.println("Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
                break;
        }

        Random rand = new Random();
        char randomChar = (char) ('A' + rand.nextInt(26)); 
        StringBuilder idBuilder = new StringBuilder();
        idBuilder.append(randomChar);
        for (int i = 0; i < 4; i++) {
            int digit = rand.nextInt(7) + 3; 
            idBuilder.append(digit);
        }
        String id = idBuilder.toString();
        System.out.println("Generated ID: " + id);

        if (id.length() != 5) {
            System.out.println("Invalid length");
            return;
        }
        if (!Character.isLetter(id.charAt(0))) {
            System.out.println("Invalid: first char must be a letter");
            return;
        }
        for (int i = 1; i < 5; i++) {
            if (!Character.isDigit(id.charAt(i))) {
                System.out.println("Invalid: last 4 must be digits");
                return;
            }
        }
        System.out.println("ID OK");

        System.out.print("Enter your first name: ");
        String firstName = input.next();
        char base = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char) ('A' + (base - 'A' + 2) % 26); 

        String lastTwo = id.substring(id.length() - 2);
        String displayCode = shifted + lastTwo + "-" + roundedMetric;
        System.out.println("Display Code: " + displayCode);


        switch (Code) {
            case "P":
                summary = "PHARMACY | ID=" + id + " | Code=" + displayCode;
                break;
            case "L":
                summary = "LAB | ID=" + id + " | Code=" + displayCode;
                break;
            case "T":
                summary = "TRIAGE | ID=" + id + " | BMI=" + bmi + " | Code=" + displayCode;
                break;
            case "C":
                summary = "COUNSELING | ID=" + id + " | Code=" + displayCode;
                break;
        }
        System.out.println(summary);
       
    }
}
