package visualizador;

import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import visualizador.components.GrafoHelper;
import visualizador.components.grafo.GrafoImage;

import java.util.function.Consumer;


public class Visualizador extends Application {

    private GrafoHelper grafos;
    private Bounds limites;


    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane box = new AnchorPane();
        box.paddingProperty().setValue(new Insets(20));
        box.setPrefSize(800, 600);


        limites = new BoundingBox(0, 0, 00, 00);

        grafos = new GrafoHelper(limites);


        for (int i = 0; i <= 6; i++) {
            limites = grafos.addGrafo(DirecaoGrafo.DIREITA, box, limites);
            System.out.println(" adicionando figura: " + i + " em coordenadas: " + limites);
        }


        grafos.getGrafosList().forEach(new Consumer<GrafoImage>() {
            @Override
            public void accept(GrafoImage grafoImage) {
                System.out.println(" Adicionando em: " + grafoImage.getBoundsInParent());
            }
        });


        primaryStage.setScene(new Scene(box));
        primaryStage.show();

    }


}
