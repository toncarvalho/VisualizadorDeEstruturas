package visualizador;

import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import visualizador.components.grafo.GrafoBuilder;
import visualizador.components.grafo.GrafoDirector;
import visualizador.components.grafo.GrafoImage;


public class Visualizador extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {


        AnchorPane box = new AnchorPane();

        box.getChildren().add(new Label("Teste"));
        box.setPrefSize(800, 600);


        Bounds coordenadas = null;

        coordenadas = addGrafo(DirecaoGrafo.DIREITA, box, coordenadas);

        for (int i = 0; i <= 3; i++) {


            double x = coordenadas.getMaxX();
            double y = coordenadas.getMaxX();

            double altura = coordenadas.getHeight();
            double largura = coordenadas.getWidth();

            double novoX = x + altura / 2;


            Bounds novas = new BoundingBox(x, y, novoX, y);

            coordenadas = addGrafo(DirecaoGrafo.DIREITA, box, novas);

            System.out.println(" adicionando figura: " + i + " em coordenadas: " + coordenadas);
        }


        primaryStage.setScene(new Scene(box));


        primaryStage.show();


    }

    private Bounds addGrafo(DirecaoGrafo direcao, Pane box, Bounds coordenadas) {

        GrafoDirector director = new GrafoDirector(new GrafoBuilder());
        director.buildGrafo();
        GrafoImage novo = director.get();


        switch (direcao) {
            case ABAIXO: {
                box.getChildren().add(novo);
                if (coordenadas != null) {
                    novo.translateYProperty().setValue(coordenadas.getMaxY());
                }
                break;
            }
            case ACIMA: {
                box.getChildren().add(novo);
                if (coordenadas != null) {
                    novo.translateYProperty().setValue(-coordenadas.getMaxY());
                }
                break;
            }
            case ESQUERDA: {
                box.getChildren().add(novo);
                if (coordenadas != null) {
                    novo.translateXProperty().setValue(-coordenadas.getMaxX());
                }
                break;
            }
            case DIREITA: {

                box.getChildren().add(novo);
                if (coordenadas != null) {
                    novo.translateXProperty().setValue(coordenadas.getMaxX());
                }
                break;
            }
            default: {
                break;
            }

        }


        if (novo.getLayoutBounds().intersects(coordenadas)) {
            System.out.println(" houve colisão!!!");
        } else {
            System.out.println(" NÃO houve colisão!!!");
        }

        return novo.getLayoutBounds();
    }
}
