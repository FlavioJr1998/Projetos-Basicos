package casadocodigo.com.br.elementos;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import casadocodigo.com.br.engine.Game;

public class Canos {
    private List<Cano> canos = new ArrayList<Cano>();
    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private int POSICAO_INICIAL = 200;
    private Tela tela;
    private final Pontuacao pontuacao;

    public Canos(Tela tela, Pontuacao pontuacao, Game context) {
        this.tela = tela;
        this.pontuacao = pontuacao;
        iniciaCanos(context);
    }

    public void desenhaNo(Canvas canvas) {
        for(Cano cano : canos){
            cano.desenhaNo(canvas);}
    }

    public void move(Game context) {
        ListIterator<Cano> iterator = canos.listIterator();
        while( iterator.hasNext() ) {
            Cano cano = iterator.next();
            cano.move();

            if(cano.saiuDaTela() ) {
                pontuacao.aumenta();
                iterator.remove();
                Cano outroCano =
                        new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.add( outroCano );
            }
        }
    }

    private int getMaximo(){
        int maximo = 0;

        for(Cano cano : canos ){
            maximo = Math.max(cano.getPosicao(), maximo );
        }
        return maximo;
    }

    public void iniciaCanos(Game context){
        for(int i=0; i < QUANTIDADE_DE_CANOS; i++) {
            POSICAO_INICIAL += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, POSICAO_INICIAL, context));
        }
    }

    public boolean temColisaoCom(Passaro passaro){
        for ( Cano cano : canos ){
            if(cano.temColisaoHorizontalCom(passaro)&& cano.temColisaoVerticalCom(passaro))
                return true;
        }

        return false;
    }

    public int getPOSICAO_INICIAL() {
        return POSICAO_INICIAL;
    }

    public void setPOSICAO_INICIAL(int POSICAO_INICIAL) {
        this.POSICAO_INICIAL = POSICAO_INICIAL;
    }

    public List<Cano> getCanos() {
        return canos;
    }

    public void setCanos(List<Cano> canos) {
        this.canos = canos;
    }
}