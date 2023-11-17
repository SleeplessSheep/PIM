package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import Model.PIR;

public class ExportCommand implements Command {
    private ArrayList<PIR> PIRs;
    private String fileName;

    public ExportCommand(ArrayList<PIR> PIRs, String fileName) {
        this.PIRs = PIRs;
        this.fileName = fileName;
    }

    public void execute(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String buf;
            for(int i = 0;i < PIRs.size();i++){ //read the file line by line
                /*the format of the file will be
                Create(Command)
                Event(which is the type)
                text(data 1)
                date(data 2)
                date(data 3 which is the last data)
                Create(Command for the second item)
                ...
                */ 
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
