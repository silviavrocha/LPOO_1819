public class Line implements Drawable {
    private int width;

    public Line(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void draw()
    {
        System.out.println("Line");
    }
}