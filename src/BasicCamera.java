public class BasicCamera implements ICamera{
    private String brand;
    private String model;
    private int megapixels;

    public BasicCamera(String brand, String model, int megapixels) {
        this.brand = brand;
        this.model = model;
        this.megapixels = megapixels;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMegapixels() {
        return megapixels;
    }

    @Override
    public void accept(ICameraVisitor visitor) {
        visitor.visitBasicCamera(this);
    }
}
