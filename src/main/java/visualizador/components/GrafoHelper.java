package visualizador.components;

import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import visualizador.DirecaoGrafo;
import visualizador.components.grafo.GrafoBuilder;
import visualizador.components.grafo.GrafoDirector;
import visualizador.components.grafo.GrafoImage;

import java.util.ArrayList;
import java.util.List;


public class GrafoHelper {


    private List<GrafoImage> grafosList = new ArrayList<>();


    private static final double ESPACAMENTO = 35;

    private final Bounds limites;


    public GrafoHelper(Bounds limites) {
        this.limites = limites;
    }


    public Bounds addGrafo(DirecaoGrafo direcao, Pane box, Bounds bounds) {

        GrafoDirector director = new GrafoDirector(new GrafoBuilder());

        if (bounds == null) {
            bounds = limites;
        }

        director.buildGrafo();

        GrafoImage novo = director.get();
        box.getChildren().add(novo);

        switch (direcao) {
            case ABAIXO: {
                novo.layoutYProperty().set(bounds.getMaxY() + ESPACAMENTO);
                break;
            }
            case ACIMA: {
                novo.layoutYProperty().set(bounds.getMaxY() - ESPACAMENTO);
                break;
            }
            case ESQUERDA: {
                novo.layoutXProperty().set(bounds.getMaxX() - ESPACAMENTO);
                break;
            }
            case DIREITA: {
                novo.layoutXProperty().set(bounds.getMaxX() + ESPACAMENTO);
                break;
            }
            default: {
                break;
            }

        }

        if (novo.getBoundsInParent().intersects(bounds)) {
            System.out.println(" houve colisão!!!");
        } else {
            System.out.println(" NÃO houve colisão!!!");
        }


        this.grafosList.add(novo);

        return novo.getBoundsInParent();
    }

    public List<GrafoImage> getGrafosList() {
        return grafosList;
    }
}
