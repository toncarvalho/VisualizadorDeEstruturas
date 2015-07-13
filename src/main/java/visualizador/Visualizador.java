package visualizador;

import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import visualizador.components.GrafoHelper;
import visualizador.components.grafo.GrafoImage;


public class Visualizador extends Application {

    private GrafoHelper grafos;
    private Bounds limites;


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane box = new AnchorPane();
        box.paddingProperty().setValue(new Insets(20));
        box.setPrefSize(800, 600);

        Canvas canvas = new Canvas(700, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        box.getChildren().add(canvas);

        limites = new BoundingBox(0, 0, 00, 00);

        grafos = new GrafoHelper(limites);

        for (int i = 0; i <= 5; i++) {
            limites = grafos.addGrafo(DirecaoGrafo.DIREITA, box, limites);
            System.out.println(" adicionando figura: " + i + " em coordenadas: " + limites);
        }
        //determinar largura da linha. o largura da linha é metade da largura de uma figura portanto segue

        final int iteracoes = grafos.getGrafosList().size() - 1;


        System.out.println(" iteracoes: " + iteracoes);
        for (int i = 0; i <= (iteracoes); i++) {

            GrafoImage figura = grafos.getGrafosList().get(i);
            System.out.println(" figura: " + i);

            /**
             * @param x1 the X coordinate of the starting point of the line.
             * @param y1 the Y coordinate of the starting point of the line.
             * @param x2 the X coordinate of the ending point of the line.
             * @param y2 the Y coordinate of the ending point of the line.
             */


            int proximo = (i + 1);

            if (proximo <= iteracoes) {


                GrafoImage figura2 = grafos.getGrafosList().get(proximo);

                double x1, x2;
                x1 = figura.getBoundsInParent().getMaxX();
                x2 = figura2.getBoundsInParent().getMinX();


                drawLines(gc, x1, 15, x2, 15);
            }


        }


        primaryStage.setScene(new Scene(box));
        primaryStage.show();

    }

    private void drawLines(final GraphicsContext gc, final double... coordenadas) {

        //gc.setFill(Color.GREEN);

        gc.setStroke(Color.RED);

        gc.setLineWidth(2);

        System.out.println(" adicionando aresta com coordenadas: " + coordenadas[0] + " " + coordenadas[1] + " " + coordenadas[2] + " " + coordenadas[3]);

        gc.strokeLine(coordenadas[0], coordenadas[1], coordenadas[2], coordenadas[3]);

        /*gc.fillText("----", coordenadas[0], coordenadas[3]);*/
        //gc.fillRect(coordenadas[0], coordenadas[3], 150, 50);


    }
}




