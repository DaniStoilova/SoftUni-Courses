package PolymorphismLab.Shapes.Shapes;

import java.util.function.DoublePredicate;

public abstract class Shape {
    //o	perimeter: Double
    //o	area: Double
    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();

}
