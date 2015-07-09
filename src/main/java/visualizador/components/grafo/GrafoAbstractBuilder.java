package visualizador.components.grafo;


public abstract class GrafoAbstractBuilder {

    protected GrafoImage grafoImage;


    public GrafoAbstractBuilder() {
        this.grafoImage = new GrafoImage();
    }

    public abstract void montaGrafo();


    public GrafoImage getGrafo() {
        return grafoImage;
    }
}
