package casadocodigo.com.br.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import casadocodigo.com.br.R;

public class Som {
    private SoundPool soundPool;
    private static int PULO;

    public Som(Context context){
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        //PULO = soundPool.load(context,R.raw  1);
    }
}
