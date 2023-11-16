package Controller;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Model.PIR;

public class ImportCommand implements Command {
    private ArrayList<PIR> PIRs;
    private String fileName;
    private String format = "yyyy-MM-dd HH:mm";
    SimpleDateFormat formatter;

    public ImportCommand(ArrayList<PIR> PIRs, String fileName) {
        this.PIRs = PIRs;
        this.fileName = fileName;
        formatter = new SimpleDateFormat(format);
    }

    public void execute() {
        try {
            File importFile = new File(fileName);
            Scanner scan = new Scanner(importFile);
            Command command;
            String buf;
            String type;
            //only 3 dataBuf for now, add some more if new type of record have more than 3 data
            String dataBuf1;
            String dataBuf2;
            String dataBuf3;
            while(scan.hasNextLine()){
                if ((scan.nextLine()).equals("Create")) {
                    type = scan.nextLine();
                    System.out.println(type);
                    switch (type) {
                        case "Event": //3 data
                            dataBuf1 = scan.nextLine();
                            dataBuf2 = scan.nextLine();
                            dataBuf3 = scan.nextLine();
                            command = new CreateEvent(PIRs, dataBuf1, formatter.parse(dataBuf2), formatter.parse(dataBuf3));
                            command.execute();
                            break;
                        
                        case "Contact": //3 data
                            dataBuf1 = scan.nextLine();
                            dataBuf2 = scan.nextLine();
                            dataBuf3 = scan.nextLine();
                            command = new CreateContact(PIRs, dataBuf1, dataBuf2, Integer.parseInt(dataBuf3));
                            command.execute();
                            break;

                        case "Task": //2 data
                            dataBuf1 = scan.nextLine();
                            dataBuf2 = scan.nextLine();
                            command = new CreateTask(PIRs, dataBuf1, formatter.parse(dataBuf2));
                            command.execute();
                            break;

                        case "TextNote": //1 data
                            dataBuf1 = scan.nextLine();
                            command = new CreateTextNote(PIRs, dataBuf1);
                            command.execute();
                            break;

                        default:
                            break;
                    }
                    System.out.println("1 item been created");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
