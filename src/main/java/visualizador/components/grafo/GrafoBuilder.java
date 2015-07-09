package visualizador.components.grafo;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class GrafoBuilder extends GrafoAbstractBuilder {
    @Override
    public void montaGrafo() {

        this.grafoImage.fillProperty().setValue(Color.LIGHTBLUE);


        this.grafoImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Coordenadas: ");
                System.out.println("X : " + grafoImage.getX());
                System.out.println("LayoutX : " + grafoImage.getLayoutX());
                System.out.println("Y : " + grafoImage.getY());
                System.out.println("LayoutY : " + grafoImage.getLayoutY());
                System.out.println();

                System.out.println(" ScaleX: " + grafoImage.getScaleX() + " ScaleY: " + grafoImage.getScaleY() + " ScaleZ: " + grafoImage.getScaleZ());

                System.out.println();

                System.out.println(" BaselineOffset: " + grafoImage.getBaselineOffset());

                System.out.println(" BoundsInLocal: " + grafoImage.getBoundsInLocal());

                System.out.println(" BoundsInParent: " + grafoImage.getBoundsInParent());

                System.out.println(" LayoutBounds: " + grafoImage.getLayoutBounds());

            }
        });


    }
}
