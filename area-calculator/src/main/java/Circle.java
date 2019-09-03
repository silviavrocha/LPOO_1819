public class Circle implements Shapes {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getArea()
    {
        return Math.pow(radius,2)*Math.PI;
    }
    @Override
    public void draw()
    {
        System.out.println("Circle");
    }
}
