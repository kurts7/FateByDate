package alexanderkluev.fatebydate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import alexanderkluev.fatebydate.R;

/**
 * Created by alexander.kluev on 06.05.2015.
 */
public class FateActivity extends Activity {

    private Button btnShowMain;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fate);

        // Создаём межстраничное объявление
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-1177132318340542/8371468917");
        // Создаём запрос к AdMob

        AdRequest adRequesti = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("e2ae6d65c5bc0ad2")
                .build();

        //AdRequest adRequesti = new AdRequest.Builder().build();
        // Начинаем загружать объявление
        interstitial.loadAd(adRequesti);

        btnShowMain = (Button)findViewById(R.id.button2);
        btnShowMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (interstitial.isLoaded()) {
                    interstitial.show();
                }

                Intent intent = new Intent(FateActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onStart();
        int fNum = getIntent().getExtras().getInt("FATEbyDATE.fateNum");

        ImageView cardImage = (ImageView)findViewById(R.id.imageView);
        TextView cardText = (TextView)findViewById(R.id.textView);
        TextView titleText = (TextView)findViewById(R.id.textView2);

        switch (fNum){
            case 1:
                cardImage.setImageResource(R.drawable.pic1);
                cardText.setText(R.string.mage);
                titleText.setText(R.string.mage_title);
                break;
            case 2:
                cardImage.setImageResource(R.drawable.pic2);
                cardText.setText(R.string.hPriestess);
                titleText.setText(R.string.hPriestess_title);
                break;
            case 3:
                cardImage.setImageResource(R.drawable.pic3);
                cardText.setText(R.string.empress);
                titleText.setText(R.string.empress_title);
                break;
            case 4:
                cardImage.setImageResource(R.drawable.pic4);
                cardText.setText(R.string.emperor);
                titleText.setText(R.string.emperor_title);
                break;
            case 5:
                cardImage.setImageResource(R.drawable.pic5);
                cardText.setText(R.string.hierophant);
                titleText.setText(R.string.hierophant_title);
                break;
            case 6:
                cardImage.setImageResource(R.drawable.pic6);
                cardText.setText(R.string.lovers);
                titleText.setText(R.string.lovers_title);
                break;
            case 7:
                cardImage.setImageResource(R.drawable.pic7);
                cardText.setText(R.string.chariot);
                titleText.setText(R.string.chariot_title);
                break;
            case 8:
                cardImage.setImageResource(R.drawable.pic8);
                cardText.setText(R.string.justice);
                titleText.setText(R.string.justice_title);
                break;
            case 9:
                cardImage.setImageResource(R.drawable.pic9);
                cardText.setText(R.string.hermit);
                titleText.setText(R.string.hermit_title);
                break;
            case 10:
                cardImage.setImageResource(R.drawable.pic10);
                cardText.setText(R.string.wFortune);
                titleText.setText(R.string.wFortune_title);
                break;
            case 11:
                cardImage.setImageResource(R.drawable.pic11);
                cardText.setText(R.string.power);
                titleText.setText(R.string.power_title);
                break;
            case 12:
                cardImage.setImageResource(R.drawable.pic12);
                cardText.setText(R.string.hanged);
                titleText.setText(R.string.hanged_title);
                break;
            case 13:
                cardImage.setImageResource(R.drawable.pic13);
                cardText.setText(R.string.death);
                titleText.setText(R.string.death_title);
                break;
            case 14:
                cardImage.setImageResource(R.drawable.pic14);
                cardText.setText(R.string.moderation);
                titleText.setText(R.string.moderation_title);
                break;
            case 15:
                cardImage.setImageResource(R.drawable.pic15);
                cardText.setText(R.string.devil);
                titleText.setText(R.string.devil_title);
                break;
            case 16:
                cardImage.setImageResource(R.drawable.pic16);
                cardText.setText(R.string.tower);
                titleText.setText(R.string.tower_title);
                break;
            case 17:
                cardImage.setImageResource(R.drawable.pic17);
                cardText.setText(R.string.star);
                titleText.setText(R.string.star_title);
                break;
            case 18:
                cardImage.setImageResource(R.drawable.pic18);
                cardText.setText(R.string.moon);
                titleText.setText(R.string.moon_title);
                break;
            case 19:
                cardImage.setImageResource(R.drawable.pic19);
                cardText.setText(R.string.sun);
                titleText.setText(R.string.sun_title);
                break;
            case 20:
                cardImage.setImageResource(R.drawable.pic20);
                cardText.setText(R.string.court);
                titleText.setText(R.string.court_title);
                break;
            case 21:
                cardImage.setImageResource(R.drawable.pic21);
                cardText.setText(R.string.world);
                titleText.setText(R.string.world_title);
                break;
            case 22:
                cardImage.setImageResource(R.drawable.pic22);
                cardText.setText(R.string.joker);
                titleText.setText(R.string.joker_title);
                break;
            default:
                cardImage.setImageResource(R.drawable.question);
                cardText.setText(R.string.unknown);
                titleText.setText(R.string.unknown_title);
                break;
        }

    }

}


