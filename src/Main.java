import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ICamera> cameras = new ArrayList<>();

        cameras.add(new BasicCamera("Canon", "EOS R100", 24));
        cameras.add(new ProfessionalCamera(
                "Canon", "EOS R5", 45, "RF 24-105mm"));

        ICameraVisitor infoVisitor = new CameraInfoVisitor();
        ICameraVisitor maintenanceVisitor = new CameraMaintenanceVisitor();

        System.out.println("--- CAMERA INFORMATION ---");

        for (int i = 0; i < cameras.size(); i++) {
            cameras.get(i).accept(infoVisitor);
            System.out.println();
        }

        System.out.println("--- CAMERA MAINTENANCE ---");

        for (int i = 0; i < cameras.size(); i++) {
            cameras.get(i).accept(maintenanceVisitor);
            System.out.println();
        }
    }
}
