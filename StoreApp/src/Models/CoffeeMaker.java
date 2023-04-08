package Models;
@SuppressWarnings("unused")
public class CoffeeMaker extends Product{

    private int WaterTankSize;

    @Override
    public String getProductType() {
        return "Coffee Maker";
    }

    public CoffeeMaker(int productId, int price, String name, int waterTankSize) {
        super(productId, price, name);
        WaterTankSize = waterTankSize;
    }

    public int getWaterTankSize() {
        return WaterTankSize;
    }

    public void setWaterTankSize(int waterTankSize) {
        WaterTankSize = waterTankSize;
    }
}
