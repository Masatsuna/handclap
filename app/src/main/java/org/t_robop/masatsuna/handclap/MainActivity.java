package org.t_robop.masatsuna.handclap;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;    //SoundPool型の変数
    int soundId;            //音声ファイルをロードしたものを格納

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //soundPoolのインスタンスを生成
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        //new SoundPool(ロードするファイル数, ストリームタイプ（STREAM_MUSICは音楽音）,サンプリングレートのクオリティ(デフォルトは０));

        //音声ファイルをロード
        soundId = soundPool.load(this, R.raw.clapping_short2, 1);
        //sound.load(コンテキスト,ファイルのID,デフォルトは１);
    }

    //インスタンスを解放（終了後もメモリを使用し続けるのを防ぐため）
    @Override
    protected void onPause() {  //onPauseはActivityがバックグラウンドに移動するときに呼び出される。
        super.onPause();
        //ロードしたファイルをアンロード
        soundPool.unload(soundId);

        //生成したインスタンスを解放
        soundPool.release();
    }

    //ImageButtonが押されたときの処理内容
    public void onClick (View view) {
        //ロードした音声ファイルを再生
        soundPool.play(soundId, 1, 1, 0, 0, 1.0F);
        //soundPool.play(ロードしたファイルの変数名, 左の音量,右の音量,デフォルトは０,-1で無限ループ,0で１回再生,再生速度)
    }
}
