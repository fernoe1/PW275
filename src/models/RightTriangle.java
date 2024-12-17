package models;

public class RightTriangle {
    private int base;
    private int height;
    private double hypotenuse;

    public RightTriangle(int base, int height, double hypotenuse) {
        this.base = base;
        this.height = height;
        this.hypotenuse = hypotenuse;
    }

    public double perimeter() {

        return base + height + hypotenuse;
    }

    public double area() {

        return 0.5 * base * height;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHypotenuse(double hypotenuse) {
        this.hypotenuse = hypotenuse;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }
}
