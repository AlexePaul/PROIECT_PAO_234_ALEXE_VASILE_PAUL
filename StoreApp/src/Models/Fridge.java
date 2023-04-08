package Models;

public class Fridge extends Product{

    private int size; //this will represent the actual size in liters of the fridge
    private int width;
    private int height;

    private int depth;

    @Override
    public String getProductType() {
        return "Fridge";
    }

    public Fridge(int productId, int price, String name, int size, int width, int height,
                  int depth) {
        super(productId, price, name);
        this.size = size;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
