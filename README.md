# Visitor Pattern - SDP Assignment 6

This assignment demonstrates the **Visitor Pattern** using digital cameras. The project separates camera information and maintenance operations from the camera classes themselves.

The system contains two types of digital cameras: BasicCamera and ProfessionalCamera. Each camera can accept different visitors that perform operations without changing the camera classes.

For example, CameraInfoVisitor displays camera specifications, while CameraMaintenanceVisitor provides maintenance recommendations for each camera type.

## Visitor Pattern Structure

- `ICamera` - Element interface that declares the `accept()` method.
- `BasicCamera` - Concrete Element representing a basic digital camera.
- `ProfessionalCamera` - Concrete Element representing a professional digital camera.
- `ICameraVisitor` - Visitor interface that declares a visit method for each camera type.
- `CameraInfoVisitor` - Concrete Visitor that displays camera information.
- `CameraMaintenanceVisitor` - Concrete Visitor that provides camera maintenance recommendations.
- `Main` - Client that creates cameras, stores them in a collection, and applies visitors.

## How the Visitor Pattern Works

The Visitor Pattern allows new operations to be added to existing objects without modifying their classes.

Each camera implements the `accept()` method and passes itself to the appropriate visitor method.

For example, in BasicCamera:

```java
@Override
public void accept(ICameraVisitor visitor) {
    visitor.visitBasicCamera(this);
}
```

In ProfessionalCamera:

```java
@Override
public void accept(ICameraVisitor visitor) {
    visitor.visitProfessionalCamera(this);
}
```

This mechanism is called **Double Dispatch**. It allows the correct visitor method to be selected based on the concrete camera type and the visitor implementation.

The client can apply different visitors to the same camera objects:

```java
ICameraVisitor infoVisitor = new CameraInfoVisitor();
ICameraVisitor maintenanceVisitor = new CameraMaintenanceVisitor();

for (int i = 0; i < cameras.size(); i++) {
    cameras.get(i).accept(infoVisitor);
}

for (int i = 0; i < cameras.size(); i++) {
    cameras.get(i).accept(maintenanceVisitor);
}
```

The camera classes do not need to know how these operations are implemented.

## Clean Code Principles

### 1. Meaningful Names

Classes and methods have clear names that describe their responsibilities.

For example:

- `BasicCamera` and `ProfessionalCamera` represent camera types.
- `CameraInfoVisitor` displays camera specifications.
- `CameraMaintenanceVisitor` provides maintenance recommendations.
- `accept()` allows an element to receive a visitor.

These names make the code easier to read and understand.

### 2. Single Responsibility Principle (SRP)

Each class has one main responsibility.

- Camera classes store camera properties.
- CameraInfoVisitor handles camera information.
- CameraMaintenanceVisitor handles maintenance recommendations.

For example, CameraInfoVisitor contains only information-related operations:

```java
@Override
public void visitBasicCamera(BasicCamera camera) {
    System.out.println("Basic Camera Information:");
    System.out.println("Brand: " + camera.getBrand());
    System.out.println("Model: " + camera.getModel());
    System.out.println("Megapixels: " + camera.getMegapixels());
}
```

This separates camera data from additional operations and makes the code easier to maintain.

### 3. Open/Closed Principle (OCP)

The system is open for extension but closed for modification.

New operations can be added by creating new Visitor classes without changing BasicCamera or ProfessionalCamera.

For example, a new CameraPriceVisitor could calculate camera prices by implementing ICameraVisitor.

The existing camera classes would remain unchanged.

### 4. Encapsulation

Camera properties are declared as private fields.

Visitors access only the necessary information through public getter methods.

For example:

```java
private String brand;
private String model;
private int megapixels;

public String getBrand() {
    return brand;
}
```

This protects the internal state of camera objects while allowing visitors to use the information they need.

### 5. Polymorphism Instead of Type Checking

The project uses Double Dispatch instead of `instanceof`, `if-else`, or `switch` statements to determine camera types.

Each camera calls the appropriate visitor method through its `accept()` implementation.

For example:

```java
visitor.visitBasicCamera(this);
```

This avoids manual type checking and makes the code easier to extend and maintain.

## Conclusion

The Visitor Pattern allows different operations to be performed on digital cameras without modifying their classes.

In this project, CameraInfoVisitor and CameraMaintenanceVisitor demonstrate how separate operations can work with the same camera objects through Double Dispatch.

The implementation follows Clean Code principles such as Meaningful Names, Single Responsibility, Open/Closed Principle, Encapsulation, and Polymorphism.

This makes the system easier to maintain and allows new operations to be added without changing the existing camera structure.