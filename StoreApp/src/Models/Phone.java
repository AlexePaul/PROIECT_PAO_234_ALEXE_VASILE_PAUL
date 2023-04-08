package Models;

import Utils.Resolution;

public class Phone extends Product {
    private String CPU;
    private Resolution ScreenResolution;
    private int ScreenRefreshRate;

    private int Storage; //will be stored in Gb

    private String Color;

    @Override
    public String getProductType() {
        return "Phone";
    }

    public Phone(int productId, int price, String name, String CPU, Resolution screenResolution,
                 int screenRefreshRate, int storage, String color) {
        super(productId, price, name);
        this.CPU = CPU;
        ScreenResolution = screenResolution;
        ScreenRefreshRate = screenRefreshRate;
        Storage = storage;
        Color = color;
    }

    public Phone(int productId, int price, String name, String CPU, int screenHeight,
                 int screenWidth, int screenRefreshRate, int storage, String color) {
        super(productId, price, name);
        this.CPU = CPU;
        ScreenResolution = new Resolution(screenHeight, screenWidth);
        ScreenRefreshRate = screenRefreshRate;
        Storage = storage;
        Color = color;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public Resolution getScreenResolution() {
        return ScreenResolution;
    }

    public void setScreenResolution(Resolution screenResolution) {
        ScreenResolution = screenResolution;
    }

    public int getScreenRefreshRate() {
        return ScreenRefreshRate;
    }

    public void setScreenRefreshRate(int screenRefreshRate) {
        ScreenRefreshRate = screenRefreshRate;
    }
}
