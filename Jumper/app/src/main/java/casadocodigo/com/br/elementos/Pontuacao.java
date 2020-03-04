package casadocodigo.com.br.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Pontuacao {
    private int pontos = 0;
    private static final Paint BRANCO =
            Cores.getCorDaPontuacao();

    public Pontuacao(){

    }

    public void aumenta(){
        pontos++;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawText(String.valueOf(pontos), 100, 100, BRANCO);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
