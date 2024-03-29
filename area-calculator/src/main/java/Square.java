public class Square implements Shapes {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double getArea()
    {
        return side*side;
    }

    @Override
    public void draw()
    {
        System.out.println("Square");
    }
}
