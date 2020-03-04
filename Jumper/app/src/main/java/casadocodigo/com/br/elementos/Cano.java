package casadocodigo.com.br.elementos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import casadocodigo.com.br.R;
import casadocodigo.com.br.engine.Game;

import static android.os.Build.VERSION_CODES.O;

public class Cano {
    private static final int TAMANHO_DO_CANO = 350;
    private static final int LARGURA_DO_CANO = 200;
    private Tela tela;
    private int alturaCanoInferior;
    private int alturaCanoSuperior;
    private int posicao;
    private final Paint verde = Cores.getCorCano();
    private Bitmap bp, canoInferior, canoSuperior;

    public Cano(Tela tela, int posicao, Game context){
        this.tela = tela;
        this.posicao = posicao;
        this.alturaCanoInferior = ( tela.getAltura() - TAMANHO_DO_CANO ) - valorAleatorio();
        this.alturaCanoSuperior = O + TAMANHO_DO_CANO + valorAleatorio();
        this.bp = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaCanoInferior, false);
        this.canoSuperior = Bitmap.createScaledBitmap(bp,
                LARGURA_DO_CANO, this.alturaCanoSuperior, false);
    }


    public void desenhaNo(Canvas canvas){
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    public void desenhaCanoInferiorNo(Canvas canvas){
        canvas.drawBitmap(canoInferior, posicao, alturaCanoInferior, null);
    }

    public void desenhaCanoSuperiorNo(Canvas canvas){
        canvas.drawBitmap(canoSuperior, posicao, 0, null);;

    }

    public void move(){
        posicao -= 10;
    }

    public int valorAleatorio(){
        return (int) (Math.random() * 370);
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoVerticalCom(Passaro passaro){
        return passaro.getAltura() - passaro.getRAIO() < this.alturaCanoSuperior
                || passaro.getAltura() + passaro.getRAIO() > this.alturaCanoInferior;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.getX() < passaro.getRAIO();
    }
}
