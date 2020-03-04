package casadocodigo.com.br.engine;

import casadocodigo.com.br.elementos.Canos;
import casadocodigo.com.br.elementos.Passaro;

public class VerificadorDeColisao {
    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;

    }

    public boolean temColisao(){
        return canos.temColisaoCom(passaro);
    }
}
