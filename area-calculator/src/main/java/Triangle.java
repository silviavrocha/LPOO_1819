public class Triangle implements Shapes {
    private int width, height;

    public Triangle(int width, int height) {
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
        return (width*height)/2;
    }

    @Override
    public void draw()
    {
        System.out.println("Triangle");
    }
}