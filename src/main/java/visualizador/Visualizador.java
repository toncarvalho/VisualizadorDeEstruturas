package visualizador;

import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import visualizador.components.GrafoHelper;
import visualizador.components.grafo.GrafoImage;

import java.util.List;


public class Visualizador extends Application {


    private GrafoHelper grafos;
    private Bounds limites;


    @Override
    public void start(Stage primaryStage) throws Exception {

        ScrollPane scrollPane = new ScrollPane();


        AnchorPane box = new AnchorPane();
        scrollPane.setContent(box);

        box.paddingProperty().setValue(new Insets(20));
        box.setPrefSize(800, 600);


        addGrafo(DirecaoGrafo.ABAIXO, 0, box);

        addGrafo(DirecaoGrafo.DIREITA, 0, box);


        primaryStage.setScene(new Scene(scrollPane));
        primaryStage.show();

    }

    private void addGrafo(DirecaoGrafo direcao, int quantidade, Pane box) {

        /**
         * Canvas deve ser alocado por baixo das figuras que representam o grafo, para que não atrapalhe o click. e
         * Nesta abordagem estamos utilizando um objeto canvas somente,  desenhando todas as arestas sobre ele, portanto
         * o seu tamanho deve ser maior que a imagem de todo o grafo.
         */
        Canvas canvas = new Canvas(750, 550);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        box.getChildren().add(canvas);

        limites = new BoundingBox(0, 0, 00, 00);

        grafos = new GrafoHelper(limites);


        for (int i = 0; i <= quantidade; i++) {
            limites = grafos.addGrafo(direcao, box, limites);
            System.out.println(" adicionando figura: " + i + " em coordenadas: " + limites);
        }

        if (direcao.equals(DirecaoGrafo.DIREITA)) {
            //determinar largura da linha. o largura da linha é metade da largura de uma figura portanto segue
            desenhaArestasAosLados(grafos.getGrafosList(), gc);
        } else if (direcao.equals(DirecaoGrafo.ABAIXO)) {
            desenhaArestasAbaixo(grafos.getGrafosList(), gc);
        }

    }
        //determinando onde deve ser desenhada a linha para representar a aresta.
        posicaoY = limites.getHeight() / 2;

    private void desenhaArestasAbaixo(List<GrafoImage> grafosList, GraphicsContext gc) {

        Double posicaoX = 15.0;
        //determinando onde deve ser desenhada a linha para representar a aresta.
        posicaoX = limites.getWidth() / 2;

        final int iteracoes = grafosList.size() - 1;

        System.out.println(" iteracoes: " + iteracoes);
        for (int i = 0; i <= (iteracoes); i++) {
            GrafoImage figura = grafosList.get(i);
            System.out.println(" figura: " + i);
            int proximo = (i + 1);
            if (proximo <= iteracoes) {
                GrafoImage figura2 = grafosList.get(proximo);

                double y1, y2;
                y1 = figura.getBaselineOffset();
                y2 = figura2.getLayoutY();

                //drawLines(gc, y1, posicaoX, y2, posicaoX);
                drawLines(gc, posicaoX, y1, posicaoX, y2);
            }
        }


    }

    private void desenhaArestasAosLados(List<GrafoImage> grafosList, GraphicsContext gc) {
        Double posicaoY = 15.0;
        //determinando onde deve ser desenhada a linha para representar a aresta.
        posicaoY = limites.getHeight() / 2;
        final int iteracoes = grafosList.size() - 1;
        System.out.println(" iteracoes: " + iteracoes);
        for (int i = 0; i <= (iteracoes); i++) {
            GrafoImage figura = grafosList.get(i);
            System.out.println(" figura: " + i);
            int proximo = (i + 1);
            if (proximo <= iteracoes) {
                GrafoImage figura2 = grafosList.get(proximo);
                double x1, x2;
                x1 = figura.getBoundsInParent().getMaxX();
                x2 = figura2.getBoundsInParent().getMinX();
                drawLines(gc, x1, posicaoY, x2, posicaoY);
            }
        }

    }

    private void drawLines(final GraphicsContext gc, final double... coordenadas) {

        gc.setStroke(Color.RED);

        gc.setLineWidth(2);

        gc.strokeLine(coordenadas[0], coordenadas[1], coordenadas[2], coordenadas[3]);

        System.out.println(" adicionando aresta com coordenadas: " + coordenadas[0] + " " + coordenadas[1] + " " + coordenadas[2] + " " + coordenadas[3]);


    }
}





