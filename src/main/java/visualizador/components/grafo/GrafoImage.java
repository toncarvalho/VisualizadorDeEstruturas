package visualizador.components.grafo;


import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GrafoImage extends Rectangle implements Cloneable {

    public GrafoImage() {
        super(40d, 60d, Color.BLUE);
     //   strokeProperty().setValue(Color.BLUE);
        cursorProperty().setValue(Cursor.HAND);
        focusTraversableProperty().setValue(false);
        setArcHeight(25);
        setArcWidth(25);

    }

    @Override
    public GrafoImage clone() throws CloneNotSupportedException {
        return new GrafoImage();
    }
}
