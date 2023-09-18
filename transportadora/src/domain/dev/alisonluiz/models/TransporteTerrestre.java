package domain.dev.alisonluiz.models;

import domain.dev.alisonluiz.Transportadora;

public class TransporteTerrestre extends Transportadora {

    @Override
    public double calculaFrete(int altura, int largura) {
        return 0.2 * (altura / (double)largura);
    }
}
