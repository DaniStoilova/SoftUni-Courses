package PolymorphismLab.Shapes.Shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0,2.5);
        Circle circle = new Circle(3.0);


        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
    }
}
