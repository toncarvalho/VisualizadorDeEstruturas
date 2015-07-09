package visualizador.components.aresta;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * Created by ton on 09/07/15.
 */
public class Arrow {

    public static Polygon createUMLArrow() {
        Polygon polygon = new Polygon(new double[]{
                7.5, 0,
                15, 15,
                7.51, 15,
                7.51, 40,
                7.49, 40,
                7.49, 15,
                0, 15
        });
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        return polygon;
    }
}
