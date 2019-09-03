public class Rectangle implements Shapes {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    @Override
    public double getArea()
    {
        return width*height;
    }

    @Override
    public void draw()
    {
        System.out.println("Rectangle");
    }
}
