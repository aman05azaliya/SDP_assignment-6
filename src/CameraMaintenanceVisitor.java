public class CameraMaintenanceVisitor implements ICameraVisitor{
    @Override
    public void visitBasicCamera(BasicCamera camera) {
        System.out.println("Maintenance for " + camera.getModel() + ":");
        System.out.println("Clean the camera lens.");
        System.out.println("Check the battery condition.");
    }

    @Override
    public void visitProfessionalCamera(ProfessionalCamera camera) {
        System.out.println("Maintenance for " + camera.getModel() + ":");
        System.out.println("Clean the camera sensor.");
        System.out.println("Inspect the interchangeable lens.");
        System.out.println("Check the firmware version.");
    }
}
