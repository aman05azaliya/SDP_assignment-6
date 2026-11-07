public class CameraInfoVisitor implements ICameraVisitor{
    @Override
    public void visitBasicCamera(BasicCamera camera) {
        System.out.println("Basic Camera Information:");
        System.out.println("Brand: " + camera.getBrand());
        System.out.println("Model: " + camera.getModel());
        System.out.println("Megapixels: " + camera.getMegapixels());
    }

    @Override
    public void visitProfessionalCamera(ProfessionalCamera camera) {
        System.out.println("Professional Camera Information:");
        System.out.println("Brand: " + camera.getBrand());
        System.out.println("Model: " + camera.getModel());
        System.out.println("Megapixels: " + camera.getMegapixels());
        System.out.println("Lens: " + camera.getLensType());
    }
}
