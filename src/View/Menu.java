package View;
import java.io.*;

//this view module ask for user input
public class Menu {
    private InputStreamReader is;
    private BufferedReader br;
    String mainMenu = "Personal Information Manager (PIM)-Menu" + "\n" + "Please enter command: [ Create | Modify | Delete | Export | Import | Print | Search ]";
    String listMenu = "Display module - Please enter [ All ] or the record ID for specific PIR";
    String deleteMenu = "Delete module - Please enter the record ID to delete specific PIR";
    String modifyMenu = "Modify module - Please enter the record ID to modify specific PIR";
    String serachMenu = "Search module - Please enter the criteria you want to use to search for personal information records (PIRs): \n[ date | text | type ] ";
    

    public Menu(){
        is = new InputStreamReader(System.in);
		br = new BufferedReader(is); //for reading hte input from user
    }

    public String displayMainMenu() throws Exception {
        Boolean doPrint = true;
        while (true) {
            try {
                while(doPrint){ //print Command Panel while true
                    System.out.println(mainMenu);
                    doPrint = false; 
                }
                String option = br.readLine(); //get user input

                switch (option) {
                    case "Create":
                    case "Modify":
                    case "Delete":
                    case "Export":
                    case "Import":
                    case "Print":
                    case "Search":
                        return option;
                
                    default:
                        System.out.println("Invaild input: " + option);
                        break;
                }

            } catch (Exception e) {
                System.out.println("*** occur in displayMainMenu ***" + e.getMessage());
            }
            System.out.println();
            doPrint = true;
        }
    }

    public String displayCreateMenu() throws Exception {
        System.out.println("Enter record tpye[ Event | Contact | Task | TextNote ]: ");
        String type = br.readLine();
        return type;
    } 

    public String[] createEvent() throws Exception {
        String[] userInputs = new String[3];
        System.out.println("Enter description for Event: ");
        userInputs[0] = br.readLine();

        System.out.println("Enter starting times for Event(YYYY-MM-DD HH:MM): ");
        userInputs[1] = br.readLine();

        System.out.println("Enter alarms for Event(YYYY-MM-DD HH:MM): ");
        userInputs[2] = br.readLine();

        System.out.println("[ 1:" + userInputs[0] + " 2:" + userInputs[1] + " 3:" + userInputs[2] + " ]");
        return userInputs;
    }

    public String displayListMenu() throws Exception{
        System.out.println(listMenu);
        String input = br.readLine();
        //check for input
        return input;
    }

    public String displayDeleteMenu() throws Exception{
        System.out.println(deleteMenu);
        String input = br.readLine();
        //check for input
        return input;
    }

    public String displayModifyMenu() throws Exception{
        System.out.println(modifyMenu);
        String input = br.readLine();
        //check for input
        return input;
    }

    public String displaySearchMenu() throws Exception{
        System.out.println(serachMenu);
        String input = br.readLine();
        return input;
    }

    public String askType() throws Exception{
        System.out.println("Please enter the type: [ Event | Contact | Task | TextNote ]");
        String input = br.readLine();
        return input;
    }

    public String askText() throws Exception{
        System.out.println("Please enter the text: ");
        String input = br.readLine();
        return input;
    }

    public String askDate() throws Exception{
        System.out.println("Please enter the date: ");
        String input = br.readLine();
        return input;
    }

    public String askLogicConnector() throws Exception {
        System.out.println("Please enter the logic connector: [ && | || ]");
        String input = br.readLine();
        return input;
    }

    public boolean askNegationIndicator() throws Exception {
        System.out.println("Is the criteria with NegationIndicator(NOT): [ Y | N ]");
        String input = br.readLine();
        if(input.equals("Y")){
            return true;
        }else{
            return false;
        }
    }

    public String askDateLogic() throws Exception {
        System.out.println("Please enter the date logic: [ < | > | = ]");
        String input = br.readLine();
        return input;
    }

    public boolean askSearchAgain() throws Exception {
        System.out.println("Do you want to search with more criteria: [ Y | N ]");
        String input = br.readLine();
        if(input.equals("Y")){
            return true;
        }else{
            return false;
        }
    }

}
