public class ProfessionalCamera implements ICamera{
    private String brand;
    private String model;
    private int megapixels;
    private String lensType;

    public ProfessionalCamera(String brand, String model,
                              int megapixels, String lensType) {
        this.brand = brand;
        this.model = model;
        this.megapixels = megapixels;
        this.lensType = lensType;
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

    public String getLensType() {
        return lensType;
    }

    @Override
    public void accept(ICameraVisitor visitor) {
        visitor.visitProfessionalCamera(this);
    }
}
