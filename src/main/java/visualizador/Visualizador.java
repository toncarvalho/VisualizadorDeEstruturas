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

        Double posicaoY = 15.0;
        AnchorPane box = new AnchorPane();
        box.paddingProperty().setValue(new Insets(20));
        box.setPrefSize(800, 600);

        Canvas canvas = new Canvas(750, 550);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        box.getChildren().add(canvas);

        limites = new BoundingBox(0, 0, 00, 00);

        grafos = new GrafoHelper(limites);


        for (int i = 0; i <= 5; i++) {
            limites = grafos.addGrafo(DirecaoGrafo.DIREITA, box, limites);
            System.out.println(" adicionando figura: " + i + " em coordenadas: " + limites);
        }
        //determinar largura da linha. o largura da linha é metade da largura de uma figura portanto segue


        //determinando onde deve ser desenhada a linha para representar a aresta.
        posicaoY = limites.getHeight() / 2;

        final int iteracoes = grafos.getGrafosList().size() - 1;


        System.out.println(" iteracoes: " + iteracoes);
        for (int i = 0; i <= (iteracoes); i++) {

            GrafoImage figura = grafos.getGrafosList().get(i);
            System.out.println(" figura: " + i);
            int proximo = (i + 1);

            if (proximo <= iteracoes) {

                GrafoImage figura2 = grafos.getGrafosList().get(proximo);

                double x1, x2;
                x1 = figura.getBoundsInParent().getMaxX();
                x2 = figura2.getBoundsInParent().getMinX();

                drawLines(gc, x1, posicaoY, x2, posicaoY);
            }

        }

        primaryStage.setScene(new Scene(box));
        primaryStage.show();

    }

    private void drawLines(final GraphicsContext gc, final double... coordenadas) {

        gc.setStroke(Color.RED);

        gc.setLineWidth(2);

        gc.strokeLine(coordenadas[0], coordenadas[1], coordenadas[2], coordenadas[3]);

        System.out.println(" adicionando aresta com coordenadas: " + coordenadas[0] + " " + coordenadas[1] + " " + coordenadas[2] + " " + coordenadas[3]);


    }
}




