package casadocodigo.com.br.elementos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import casadocodigo.com.br.R;
import casadocodigo.com.br.engine.Game;

public class Passaro {
    private final int X = 100;
    private final int RAIO = 50;
    private int altura;
    private static final Paint vermelho = Cores.getCorDoPassaro();
    private Tela tela;
    private Bitmap bp;

    public Passaro(Tela tela, Game context) {
        this.altura = 100;
        this.tela = tela;

        this.bp = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.passaro);
        this.bp = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2 ,
                false);
    }


    public void desenhaNo(Canvas canvas) {
        canvas.drawBitmap(bp, X-RAIO, altura-RAIO, null);
    }

    public void cair() {
        boolean chegouNoChao = RAIO + altura > tela.getAltura();

        if (!chegouNoChao)
            setAltura((getAltura() + 25));
    }

    public void pular() {
        if (altura > RAIO) {
            setAltura((getAltura() - 100));
        }
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getRAIO() {
        return RAIO;
    }

    public int getX() {
        return X;
    }
}