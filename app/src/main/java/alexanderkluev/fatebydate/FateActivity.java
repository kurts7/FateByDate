package alexanderkluev.fatebydate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.gorbin.asne.core.SocialNetwork;
import com.github.gorbin.asne.core.listener.OnPostingCompleteListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by alexander.kluev on 06.05.2015.
 */
public class FateActivity extends Activity {

    private Button btnShowMain;
    private InterstitialAd interstitial;

    final String custom_font = "fonts/trajan_ru.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fate);

        btnShowMain = (Button)findViewById(R.id.button2);
        btnShowMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FateActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        //ads 10% of the time :)
        int randomNum = 1 + (int)(Math.random()*10);

        if(randomNum == 5) {

            interstitial = new InterstitialAd(this);
            interstitial.setAdUnitId("ca-app-pub-1177132318340542/8371468917");

            AdRequest adRequesti = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("e2ae6d65c5bc0ad2")
                    .build();

            //AdRequest adRequesti = new AdRequest.Builder().build();

            interstitial.loadAd(adRequesti);

            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    // Call displayInterstitial() function
                    displayInterstitial();
                }

                public void displayInterstitial() {
                    // If Ads are loaded, show Interstitial else show nothing.
                    if (interstitial.isLoaded()) {
                        interstitial.show();
                    }
                }
            });
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        int fNum = getIntent().getExtras().getInt("FATEbyDATE.fateNum");

        final Typeface CF = Typeface.createFromAsset(getAssets(), custom_font);

        ImageView cardImage = (ImageView)findViewById(R.id.imageView);
        TextView cardText = (TextView)findViewById(R.id.purposeText);
        cardText.setTypeface(CF);
        TextView titleText = (TextView)findViewById(R.id.textView2);
        titleText.setTypeface(CF);

        String data = "";

        switch (fNum){
            case 1:
                cardImage.setImageResource(R.drawable.pic1);
                cardText.setText(R.string.mage);
                //data = String.valueOf(R.string.mage);
                titleText.setText(R.string.mage_title);
                break;
            case 2:
                cardImage.setImageResource(R.drawable.pic2);
                cardText.setText(R.string.hPriestess);
                //data = this.getString(R.string.hPriestess);
                titleText.setText(R.string.hPriestess_title);
                break;
            case 3:
                cardImage.setImageResource(R.drawable.pic3);
                cardText.setText(R.string.empress);
                //data = String.valueOf(R.string.empress);
                titleText.setText(R.string.empress_title);
                break;
            case 4:
                cardImage.setImageResource(R.drawable.pic4);
                cardText.setText(R.string.emperor);
                //data = String.valueOf(R.string.emperor);
                titleText.setText(R.string.emperor_title);
                break;
            case 5:
                cardImage.setImageResource(R.drawable.pic5);
                cardText.setText(R.string.hierophant);
                //data = String.valueOf(R.string.hierophant);
                titleText.setText(R.string.hierophant_title);
                break;
            case 6:
                cardImage.setImageResource(R.drawable.pic6);
                cardText.setText(R.string.lovers);
                //data = String.valueOf(R.string.lovers);
                titleText.setText(R.string.lovers_title);
                break;
            case 7:
                cardImage.setImageResource(R.drawable.pic7);
                cardText.setText(R.string.chariot);
                //data = String.valueOf(R.string.chariot);
                titleText.setText(R.string.chariot_title);
                break;
            case 8:
                cardImage.setImageResource(R.drawable.pic8);
                cardText.setText(R.string.justice);
                //data = String.valueOf(R.string.justice);
                titleText.setText(R.string.justice_title);
                break;
            case 9:
                cardImage.setImageResource(R.drawable.pic9);
                cardText.setText(R.string.hermit);
                //data = String.valueOf(R.string.hermit);
                titleText.setText(R.string.hermit_title);
                break;
            case 10:
                cardImage.setImageResource(R.drawable.pic10);
                cardText.setText(R.string.wFortune);
                //data = String.valueOf(R.string.wFortune);
                titleText.setText(R.string.wFortune_title);
                break;
            case 11:
                cardImage.setImageResource(R.drawable.pic11);
                cardText.setText(R.string.power);
                //data = String.valueOf(R.string.power);
                titleText.setText(R.string.power_title);
                break;
            case 12:
                cardImage.setImageResource(R.drawable.pic12);
                cardText.setText(R.string.hanged);
                //data = String.valueOf(R.string.hanged);
                titleText.setText(R.string.hanged_title);
                break;
            case 13:
                cardImage.setImageResource(R.drawable.pic13);
                cardText.setText(R.string.death);
                //data = String.valueOf(R.string.death);
                titleText.setText(R.string.death_title);
                break;
            case 14:
                cardImage.setImageResource(R.drawable.pic14);
                cardText.setText(R.string.moderation);
                //data = String.valueOf(R.string.moderation);
                titleText.setText(R.string.moderation_title);
                break;
            case 15:
                cardImage.setImageResource(R.drawable.pic15);
                cardText.setText(R.string.devil);
                //data = String.valueOf(R.string.devil);
                titleText.setText(R.string.devil_title);
                break;
            case 16:
                cardImage.setImageResource(R.drawable.pic16);
                cardText.setText(R.string.tower);
                //data = String.valueOf(R.string.tower);
                titleText.setText(R.string.tower_title);
                break;
            case 17:
                cardImage.setImageResource(R.drawable.pic17);
                cardText.setText(R.string.star);
                //data = String.valueOf(R.string.star);
                titleText.setText(R.string.star_title);
                break;
            case 18:
                cardImage.setImageResource(R.drawable.pic18);
                cardText.setText(R.string.moon);
                //data = String.valueOf(R.string.moon);
                titleText.setText(R.string.moon_title);
                break;
            case 19:
                cardImage.setImageResource(R.drawable.pic19);
                cardText.setText(R.string.sun);
                //data = String.valueOf(R.string.sun);
                titleText.setText(R.string.sun_title);
                break;
            case 20:
                cardImage.setImageResource(R.drawable.pic20);
                cardText.setText(R.string.court);
                //data = String.valueOf(R.string.court);
                titleText.setText(R.string.court_title);
                break;
            case 21:
                cardImage.setImageResource(R.drawable.pic21);
                cardText.setText(R.string.world);
                //data = String.valueOf(R.string.world);
                titleText.setText(R.string.world_title);
                break;
            case 22:
                cardImage.setImageResource(R.drawable.pic22);
                cardText.setText(R.string.joker);
                //data = String.valueOf(R.string.joker);
                titleText.setText(R.string.joker_title);
                break;
            default:
                cardImage.setImageResource(R.drawable.question);
                cardText.setText(R.string.unknown);
                //data = String.valueOf(R.string.unknown);
                titleText.setText(R.string.unknown_title);
                break;
        }

        SocialNetwork socialNetwork = MainFragment.mSocialNetworkManager.getSocialNetwork(networkId);

        Bundle postParams = new Bundle();
        postParams.putString(SocialNetwork.BUNDLE_LINK, link);
        socialNetwork.requestPostLink(postParams, message, postingComplete);

        Button share = (Button)findViewById(R.id.vk);
        share.setOnClickListener(shareClick);

    }

    private View.OnClickListener shareClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder ad = alertDialogInit("Would you like to post Link:", link);
            ad.setPositiveButton("Post link", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Bundle postParams = new Bundle();
                    postParams.putString(SocialNetwork.BUNDLE_LINK, link);
                    socialNetwork.requestPostLink(postParams, message, postingComplete);
                }
            });
            ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });
            ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    dialog.cancel();
                }
            });
            ad.create().show();
        }
    };

    private OnPostingCompleteListener postingComplete = new OnPostingCompleteListener() {
        @Override
        public void onPostSuccessfully(int socialNetworkID) {
            Toast.makeText(getActivity(), "Sent", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(int socialNetworkID, String requestID, String errorMessage, Object data) {
            Toast.makeText(getActivity(), "Error while sending: " + errorMessage, Toast.LENGTH_LONG).show();
        }
    };

}


