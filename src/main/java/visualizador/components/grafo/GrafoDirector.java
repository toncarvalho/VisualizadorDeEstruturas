package visualizador.components.grafo;


public class GrafoDirector {

    protected GrafoAbstractBuilder builder;

    public GrafoDirector(GrafoAbstractBuilder builder) {
        this.builder = builder;
    }


    public void buildGrafo() {

        builder.montaGrafo();

    }


    public GrafoImage get() {

        return builder.getGrafo();

    }

}
