import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private Position position;
    Element() {}
    public abstract Position getPosition();
    public abstract void setPosition(Position position);
    public abstract void draw(TextGraphics graphics);
}
