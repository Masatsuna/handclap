package org.t_robop.masatsuna.handclap;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SoundPool soundPool  = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        final int soundId = soundPool.load(this, R.raw.clapping_short2, 1);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
                                      public void onClick (View view) {
                                          soundPool.play(soundId, 1, 1, 0, 0, 1.0F);
                                      }
                                  }

        );

    }

}
