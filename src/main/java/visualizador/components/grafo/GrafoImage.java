package visualizador.components.grafo;


import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GrafoImage extends Rectangle implements Cloneable {

    public GrafoImage() {
        super(80d, 120d, Color.BLUE);
        strokeProperty().setValue(Color.YELLOW);
        cursorProperty().setValue(Cursor.HAND);
        focusTraversableProperty().setValue(false);

    }

    @Override
    public GrafoImage clone() throws CloneNotSupportedException {
        return new GrafoImage();
    }
}