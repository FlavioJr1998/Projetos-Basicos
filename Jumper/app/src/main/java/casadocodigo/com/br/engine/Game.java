package casadocodigo.com.br.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

import java.util.ListIterator;

import casadocodigo.com.br.R;
import casadocodigo.com.br.elementos.Cano;
import casadocodigo.com.br.elementos.Canos;
import casadocodigo.com.br.elementos.GameOver;
import casadocodigo.com.br.elementos.Passaro;
import casadocodigo.com.br.elementos.Pontuacao;
import casadocodigo.com.br.elementos.Tela;

public class Game extends SurfaceView implements Runnable, OnTouchListener {
    private boolean estaExecutando = true;
    private Passaro passaro;
    private Canos canos;
    private Pontuacao pontuacao;
    private GameOver gameOver;
    private SurfaceHolder holder  = getHolder();
    private Bitmap background =  BitmapFactory.decodeResource(getResources(),
            R.drawable.background) ; //PEGANDO A IMAGEM DO BACKGROUND

    public Game(Context context, Tela tela) {
        super(context);
        inicializaElementos(tela);
        setOnTouchListener(this);
        new Thread(this).start();
    }

    @Override
    public void run() {

            while (estaExecutando) {

                if (!holder.getSurface().isValid())
                    continue;
                if (new VerificadorDeColisao(passaro, canos).temColisao())
                    estaExecutando = false;

                Canvas canvas = holder.lockCanvas();
                canvas.drawBitmap(background, 0, 0, null); //DESENHANDO O BACKGROUND
                passaro.desenhaNo(canvas);
                passaro.cair();
                canos.desenhaNo(canvas);
                canos.move(this);
                pontuacao.desenhaNo(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
            Canvas canvas = holder.lockCanvas();
            gameOver.desenhaNo(canvas);
            holder.unlockCanvasAndPost(canvas);

            System.out.println("!!!!!!!!!1PASSOU1");
           // restart(passaro, pontuacao, canos);
           
        }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
       passaro.pular();
       return  false;
    }

    public void cancela(){
        this.estaExecutando = false;
    }

    public  void inicia(){
        this.estaExecutando = true;
    }

    public void restart(Passaro passaro, Pontuacao pontuacao, Canos canos){
        pontuacao.setPontos(0);
        passaro.setAltura(100);
        estaExecutando = true;
        canos.setPOSICAO_INICIAL(200);

        int i = 0;
        while ( canos.getCanos().iterator().hasNext() ) {
            System.out.println("PASSANDO: "+ i + canos.getCanos().iterator().hasNext());
            if(!canos.getCanos().isEmpty()) {
                System.out.println(canos.getCanos().isEmpty());

            }
            i++;
        }

        canos.iniciaCanos(this);
    }

    public void inicializaElementos(Tela tela){
        this.pontuacao = new Pontuacao();
        this.passaro = new Passaro(tela, this);
        this.canos = new Canos(tela, pontuacao, this);
        this.gameOver = new GameOver(tela);
        this.background = BitmapFactory.decodeResource(getResources(),
                R.drawable.background);
    }

}
