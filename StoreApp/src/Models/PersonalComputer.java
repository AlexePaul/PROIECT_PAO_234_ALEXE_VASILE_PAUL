package Models;

public class PersonalComputer extends Product{

    private int Ram; //will be stored in Gb
    private int Storage; //will be stored in Gb
    private String CPU;
    private String GPU;
    private String PSU;

    @Override
    public String getProductType() {
        return "PersonalComputer";
    }

    public PersonalComputer(int productId, int price, String name, int ram, int storage, String CPU, String GPU, String PSU) {
        super(productId, price, name);
        Ram = ram;
        Storage = storage;
        this.CPU = CPU;
        this.GPU = GPU;
        this.PSU = PSU;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    public int getStorage() {
        return Storage;
    }

    public void setStorage(int storage) {
        Storage = storage;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getPSU() {
        return PSU;
    }

    public void setPSU(String PSU) {
        this.PSU = PSU;
    }
}
