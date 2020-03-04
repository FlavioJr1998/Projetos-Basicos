package casadocodigo.com.br;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import casadocodigo.com.br.engine.Game;
import casadocodigo.com.br.elementos.Tela;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        Tela tela = new Tela(this);
        Game game = new Game(this, tela);
        container.addView(game);
    }



    public void onRestart(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        Tela tela = new Tela(this);
        Game game = new Game(this, tela);
        container.addView(game);
    }
/*
    protected void onResume() {
        //Game game = new Game(this);
        super.onResume();
        game.inicia();

        new Thread(game).start();
    }
*/

}
