package visualizador;

import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import visualizador.components.grafo.GrafoBuilder;
import visualizador.components.grafo.GrafoDirector;
import visualizador.components.grafo.GrafoImage;


public class Visualizador extends Application {


    private static final double ESPACAMENTO = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {


        AnchorPane box = new AnchorPane();

        box.setPrefSize(800, 600);

        Bounds coordenadas = new BoundingBox(0, 0, 41, 61);


        for (int i = 0; i <= 6; i++) {


            coordenadas = addGrafo(DirecaoGrafo.ABAIXO, box, coordenadas);


            System.out.println(" adicionando figura: " + i + " em coordenadas: " + coordenadas);
        }


        primaryStage.setScene(new Scene(box));


        primaryStage.show();


    }

    private Bounds addGrafo(DirecaoGrafo direcao, Pane box, Bounds coordenadas) {

        GrafoDirector director = new GrafoDirector(new GrafoBuilder());

        director.buildGrafo();

        GrafoImage novo = director.get();

        box.getChildren().add(novo);


        switch (direcao) {
            case ABAIXO: {

                novo.layoutYProperty().set(coordenadas.getMaxY() + ESPACAMENTO);

                break;
            }
            case ACIMA: {

                novo.layoutYProperty().set(coordenadas.getMaxY() - ESPACAMENTO);

                break;
            }
            case ESQUERDA: {

                novo.layoutXProperty().set(coordenadas.getMaxX() - ESPACAMENTO);

                break;
            }
            case DIREITA: {

                novo.layoutXProperty().set(coordenadas.getMaxX() + ESPACAMENTO);

                break;
            }
            default: {
                break;
            }

        }

        if (novo.getBoundsInParent().intersects(coordenadas)) {
            System.out.println(" houve colisão!!!");
        } else {
            System.out.println(" NÃO houve colisão!!!");
        }


        return novo.getBoundsInParent();
    }
}
