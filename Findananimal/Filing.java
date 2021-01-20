import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

// 
// Decompiled by Procyon v0.5.36
// 

public class Filing
{
    private FileWriter fw;
    private FileReader fr;
    private BufferedReader br;
    private BufferedWriter bw;
    private String filePath;
    private String csvPath;
    
    public Filing(final String path, final String csv) throws IOException {
        this.filePath = path;
        this.csvPath = csv;
        this.fw = new FileWriter(this.filePath, true);
        this.fr = new FileReader(this.filePath);
        this.bw = new BufferedWriter(this.fw);
        this.br = new BufferedReader(this.fr);
    }
    
    public Filing(final String path) throws IOException {
        this.filePath = path;
        this.fw = new FileWriter(this.filePath, true);
        this.fr = new FileReader(this.filePath);
        this.bw = new BufferedWriter(this.fw);
        this.br = new BufferedReader(this.fr);
    }
    
    public void ReadFromFile() throws IOException {
        System.out.println("Output Of FindAnAnimalLog File ");
        String l = "";
        while ((l = this.br.readLine()) != null) {
            System.out.println(l);
        }
    }
    
    public void ReadFromCsv() throws IOException {
        final BufferedReader br = new BufferedReader(new FileReader(this.csvPath));
        System.out.println(" CSV ");
        String l = "";
        while ((l = br.readLine()) != null) {
            final String[] emp = l.split(",");
            for (int i = 0; i < emp.length; ++i) {
                System.out.print(emp[i] + "\t\t\t\t\t\t\t\t");
            }
            System.out.println();
        }
    }
    
    public void WriteToFile(final String data) throws IOException {
        this.bw.write(data);
        this.bw.flush();
    }
}
