import java.util.Iterator;
import java.util.Map;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// 
// Decompiled by Procyon v0.5.36
// 

public class CsvReader implements IcsvReader
{
    private HashMap<String, Integer> mp;
    private ArrayList<Animal> Animalinstances;
    private Filing filer;
    private String csvPath;
    private String filePath;
    private String[] labels;
    
    public CsvReader(final String cp, final String fp) throws IOException {
        this.labels = new String[] { "Type", "Noun", "Scientific Noun", "MinSize", "MaxSize", "Size", "Color", "Country", "Natural Habitat", "Shape of Beek", "Color of Feather", "Min length", "Max length", "length of WingSpan" };
        this.Animalinstances = new ArrayList<Animal>();
        this.filer = new Filing(fp, cp);
        this.csvPath = cp;
        this.filePath = fp;
        this.mp = new HashMap<String, Integer>();
    }
    
    @Override
    public void LoadAndReadCsv() {
        try {
            this.filer.ReadFromCsv();
        }
        catch (IOException ex) {
            Logger.getLogger(CsvReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean ValidateCsv() {
        boolean status = true;
        try {
            System.out.println("Validating CSV . . . ");
            final BufferedReader br = new BufferedReader(new FileReader(this.csvPath));
            String line = "";
            while ((line = br.readLine()) != null) {
                final String[] emp = line.split(",");
                if (emp[1].equals(emp[2])) {
                    status = false;
                    throw new Exception("Invalid CSV Noun shouldn't be equal to Scientific Noun");
                }
                if (emp[0].equals("Mammal")) {
                    if (Double.valueOf(emp[3]) < 2.0 || Double.valueOf(emp[4]) > 3000.0) {
                        status = false;
                        throw new Exception("Invalid Mammal Size ");
                    }
                    continue;
                }
                else if (emp[0].equals("Fish")) {
                    if (Double.valueOf(emp[3]) < 0.7 || Double.valueOf(emp[4]) > 1265.0) {
                        status = false;
                        throw new Exception("Invalid Fish Size");
                    }
                    continue;
                }
                else if (emp[0].equals("Reptile")) {
                    if (Double.valueOf(emp[3]) < 0.14 || Double.valueOf(emp[4]) > 600.0) {
                        status = false;
                        throw new Exception("Invalid Reptile Size");
                    }
                    continue;
                }
                else {
                    if (emp[0].equals("Bird") && (Double.valueOf(emp[3]) < 5.0 || Double.valueOf(emp[4]) > 210.0)) {
                        status = false;
                        throw new Exception("Invalid Bird Size");
                    }
                    continue;
                }
            }
            System.out.println("Valid CSV");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        }
        return status;
    }
    
    @Override
    public void QuerySearch(final String query) {
        System.out.println("Query : " + query);
        System.out.println("*** Query Result ***");
        if (query.endsWith("swim")) {
            System.out.println("Yes it matches");
        }
        boolean found = false;
        System.out.println(query);
        if (query.toLowerCase().endsWith(" swim")) {
            System.out.println("swim query");
            try {
                final BufferedReader br = new BufferedReader(new FileReader(this.csvPath));
                final String[] tok = query.split(" ");
                String line = "";
                while ((line = br.readLine()) != null) {
                    if (line.contains("marine") || line.contains("Marine")) {
                        final String[] emp = line.split(",");
                        for (int i = 0; i < emp.length; ++i) {
                            System.out.println(this.labels[i] + " : " + emp[i]);
                            found = true;
                        }
                        if (!this.mp.keySet().contains(emp[1])) {
                            this.mp.put(emp[1], 0);
                        }
                        System.out.println("----------------------------------------------------------------------------");
                    }
                }
                br.close();
                return;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
        }
        if (query.toLowerCase().endsWith("walk")) {
            try {
                final BufferedReader br = new BufferedReader(new FileReader(this.csvPath));
                final String[] tok = query.split(" ");
                String line = "";
                while ((line = br.readLine()) != null) {
                    if (line.contains("Mammal") || line.contains("mammal")) {
                        if (line.contains("Marine")) {
                            continue;
                        }
                        final String[] emp = line.split(",");
                        for (int i = 0; i < emp.length; ++i) {
                            System.out.println(this.labels[i] + " : " + emp[i]);
                            found = true;
                        }
                        if (!this.mp.keySet().contains(emp[1])) {
                            this.mp.put(emp[1], 0);
                        }
                        System.out.println("----------------------------------------------------------------------------");
                    }
                }
                br.close();
                return;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
        }
        if (query.toLowerCase().endsWith("fly")) {
            try {
                final BufferedReader br = new BufferedReader(new FileReader(this.csvPath));
                final String[] tok = query.split(" ");
                String line = "";
                while ((line = br.readLine()) != null) {
                    if (line.contains("bird") || line.contains("Bird")) {
                        final String[] emp = line.split(",");
                        for (int i = 0; i < emp.length; ++i) {
                            System.out.println(this.labels[i] + " : " + emp[i]);
                            found = true;
                        }
                        if (!this.mp.keySet().contains(emp[1])) {
                            this.mp.put(emp[1], 0);
                        }
                        System.out.println("----------------------------------------------------------------------------");
                    }
                }
                br.close();
                return;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
        }
        try {
            this.filer.WriteToFile("\n Query  #  " + query + "\nResult : \n");
        }
        catch (IOException ex2) {
            Logger.getLogger(CsvReader.class.getName()).log(Level.SEVERE, null, ex2);
        }
        try {
            final BufferedReader br = new BufferedReader(new FileReader(this.csvPath));
            final String[] tok = query.split(" ");
            String line = "";
            boolean flag = true;
            while ((line = br.readLine()) != null) {
                for (int j = 0; j < tok.length; ++j) {
                    if (!line.toLowerCase().contains(tok[j].toLowerCase())) {
                        flag = false;
                    }
                }
                if (flag) {
                    final String[] emp2 = line.split(",");
                    for (int k = 0; k < emp2.length; ++k) {
                        System.out.println(this.labels[k] + " : " + emp2[k]);
                        found = true;
                        this.filer.WriteToFile(this.labels[k] + " : " + emp2[k] + "\n");
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    if (!this.mp.keySet().contains(emp2[1])) {
                        this.mp.put(emp2[1], 0);
                    }
                }
                flag = true;
            }
            if (!found) {
                System.out.println("Record not Found");
            }
        }
        catch (Exception ex) {
            System.out.println();
        }
    }
    
    @Override
    public void FileReader() {
        try {
            this.filer.ReadFromFile();
        }
        catch (IOException ex) {
            Logger.getLogger(CsvReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void NounCounter() {
        try {
            final BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            String line = "";
            while ((line = br.readLine()) != null) {
                for (final String k : this.mp.keySet()) {
                    if (line.contains(k)) {
                        this.mp.put(k, this.mp.get(k) + 1);
                    }
                }
            }
        }
        catch (Exception ex) {}
        System.out.println("****Noun Counter Summary****");
        for (final Map.Entry<String, Integer> entry : this.mp.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        for (final Map.Entry<String, Integer> entry2 : this.mp.entrySet()) {
            final double s = entry2.getValue() / (double)this.mp.size();
            System.out.println("Average of " + entry2.getKey() + " = " + String.format("%.4f", s));
        }
    }
    
    @Override
    public void InstantiateAnimals() {
        try {
            final BufferedReader br = new BufferedReader(new FileReader(this.csvPath));
            String line = "";
            int c = 0;
            while ((line = br.readLine()) != null) {
                if (++c == 1) {
                    continue;
                }
                final String[] emp = line.split(",");
                if (emp[11].equals("Null")) {
                    emp[11] = "0";
                }
                if (emp[12].equals("Null")) {
                    emp[12] = "0";
                }
                this.Animalinstances.add(new Animal(emp[0], emp[1], emp[2], Double.valueOf(emp[3]), Double.valueOf(emp[4]), Double.valueOf(emp[5]), emp[6], emp[7], emp[8], emp[9], emp[10], Double.valueOf(emp[11]), Double.valueOf(emp[12])));
            }
            System.out.println("Initialized Animal Instances ");
            for (int i = 0; i < this.Animalinstances.size(); ++i) {
                this.Animalinstances.get(i).displayData();
                System.out.println("----------------------------------------------------------------------------");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
