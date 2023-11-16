package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Model.PIR;

public class ExportCommand implements Command {
    private ArrayList<PIR> PIRs;
    private String fileName;
    private Path path;

    public ExportCommand(ArrayList<PIR> PIRs, String fileName) {
        this.PIRs = PIRs;
        this.fileName = fileName;
    }

    public void execute(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String buf;
            for(int i = 0;i < PIRs.size();i++){
                writer.write("Create\n");
                buf = PIRs.get(i).getExportData();
                writer.write(buf);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("---ExportCommand---" + e.getMessage());
        }
    }
}
