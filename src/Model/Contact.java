package Model;

public class Contact extends PIR {
    private String name;
    private String address;
    private int mobileNumber;

    public Contact(String name, String address, int mobileNumber){//constructor of contact
        this.ID = ++counter;
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.type = "Contact";
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    public int getMobileNumber(){
        return this.mobileNumber;
    }

    public void setMobileNumber(int newMobileNumber){
        this.mobileNumber = newMobileNumber;
    }

    public String getString(){
        return ID + "| " + type + "| name: " + name + "| address: " + address + "| mobile number: " + mobileNumber;
    }

    public String getExportData() {
        String buf = type + "\n" + name + "\n" + address + "\n" + mobileNumber + "\n";
        return buf;
    }
}
