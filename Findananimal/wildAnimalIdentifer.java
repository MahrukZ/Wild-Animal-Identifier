import java.io.IOException;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.5.36
// 

public class wildAnimalIdentifer
{
    public static void main(final String[] args) throws IOException {
        final CsvReader r = new CsvReader(args[0], args[1]);
        final Scanner s = new Scanner(System.in);
        int choice = -2;
        while (choice != -1) {
            System.out.println("\t\t***WELCOME TO WILD ANIMAL IDENTIFIER SYSTEM***\t\t");
            System.out.println("To Search Query                         Press 1");
            System.out.println("To Validate CSV File                    Press 2");
            System.out.println("To Print AnimalLog                      Press 3");
            System.out.println("To Print CSV File                       Press 4");
            System.out.println("To Instantiate Animal Class             Press 5");
            System.out.println("To Count Occured Nouns and Average      Press 6");
            System.out.println("To Exit                                 Press -1");
            System.out.println("Please Enter Your Choice");
            choice = s.nextInt();
            switch (choice) {
                case 1: {
                    final Scanner scan = new Scanner(System.in);
                    System.out.println("Please Enter Your Query. . . ?");
                    final String query = scan.nextLine();
                    r.QuerySearch(query);
                    continue;
                }
                case 2: {
                    r.ValidateCsv();
                    continue;
                }
                case 3: {
                    r.FileReader();
                    continue;
                }
                case 4: {
                    r.LoadAndReadCsv();
                    continue;
                }
                case 5: {
                    if (r.ValidateCsv()) {
                        System.out.println("Can't Initialize Objects,as Csv is not valid");
                        r.InstantiateAnimals();
                        continue;
                    }
                    continue;
                }
                case 6: {
                    r.NounCounter();
                    continue;
                }
                default: {
                    if (choice != -1) {
                        System.out.println("Invalid Choice");
                        continue;
                    }
                    continue;
                }
            }
        }
    }
}
