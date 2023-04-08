package Models;

import Utils.Resolution;

public class Monitor extends Product{

    private Resolution Res;
    private int RefreshRate;
    private int Size;
    @Override
    public String getProductType() {
        return "Monitor";
    }

    public Monitor(int productId, int price, String name, Resolution res, int refreshRate,
                   int size) {
        super(productId, price, name);
        Res = res;
        RefreshRate = refreshRate;
        Size = size;
    }

    public Monitor(int productId, int price, String name, int pixelHeight, int pixelWidth,
                   int refreshRate, int size) {
        super(productId, price, name);
        Res = new Resolution(pixelHeight, pixelWidth);
        RefreshRate = refreshRate;
        Size = size;
    }

    public Resolution getRes() {
        return Res;
    }

    public void setRes(Resolution res) {
        Res = res;
    }

    public int getRefreshRate() {
        return RefreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        RefreshRate = refreshRate;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }
}
