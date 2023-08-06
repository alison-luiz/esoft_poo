import domain.dev.alisonluiz.models.TransporteNautico;
import domain.dev.alisonluiz.models.TransporteTerrestre;

public class Main {
    public static void main(String[] args) {

        TransporteNautico transporteNautico = new TransporteNautico();
        TransporteTerrestre transporteTerrestre = new TransporteTerrestre();

        System.out.println(transporteNautico.calculaFrete(10, 10));

        System.out.println(transporteTerrestre.calculaFrete(10, 10));
    }
}