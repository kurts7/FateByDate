package alexanderkluev.fatebydate;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Calendar;

import alexanderkluev.fatebydate.support.TextViewPlus;


public class MainActivity extends ActionBarActivity {

    private DatePicker pickerDate;
    private Button btnShowFate;
    final Context context = this;
    //final String custom_font = "fonts/xc5CYoHu.ttf";
    final String custom_font = "fonts/ex_one.ttf";

    private int year;
    private int month;
    private int day;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Typeface CF = Typeface.createFromAsset(getAssets(), custom_font);

        btnShowFate = (Button) findViewById(R.id.find_your_goal_btn);
        btnShowFate.setTypeface(CF);

        Animation flowLeft = AnimationUtils.loadAnimation(this, R.anim.flow_left);
        Animation flowRight = AnimationUtils.loadAnimation(this, R.anim.flow_right);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        fadeIn.setStartOffset(0);
        fadeOut.setStartOffset(6000);
        TextView mainTextFirstOne = (TextView)this.findViewById(R.id.mainText_first_one);
        mainTextFirstOne.setTypeface(CF);
        mainTextFirstOne.setAnimation(fadeIn);
        mainTextFirstOne.setAnimation(fadeOut);

        fadeIn.setStartOffset(2500);
        fadeOut.setStartOffset(8500);
        TextView mainTextFirstTwo = (TextView)this.findViewById(R.id.mainText_first_two);
        mainTextFirstTwo.setTypeface(CF);
        mainTextFirstTwo.setAnimation(fadeIn);
        mainTextFirstTwo.setAnimation(fadeOut);

        fadeIn.setStartOffset(5000);
        fadeOut.setStartOffset(11000);
        TextView mainTextFirstThree = (TextView)this.findViewById(R.id.mainText_first_three);
        mainTextFirstThree.setTypeface(CF);
        mainTextFirstThree.setAnimation(fadeIn);
        mainTextFirstThree.setAnimation(fadeOut);

        fadeIn.setStartOffset(7500);
        fadeOut.setStartOffset(13500);
        TextView mainTextFirstFour = (TextView)this.findViewById(R.id.mainText_first_four);
        mainTextFirstFour.setTypeface(CF);
        mainTextFirstFour.setAnimation(fadeIn);
        mainTextFirstFour.setAnimation(fadeOut);

        fadeIn.setStartOffset(15500);
        fadeOut.setStartOffset(21000);
        TextView mainTextFirstLast = (TextView)this.findViewById(R.id.mainText_first_last);
        mainTextFirstLast.setTypeface(CF);
        mainTextFirstLast.setAnimation(fadeIn);
        mainTextFirstLast.setAnimation(fadeOut);


        /*fadeIn.setStartOffset(35000);
        btnShowFate.startAnimation(fadeIn);*/

        // add button listener
        btnShowFate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(context, R.style.mydialogstyle);
                dialog.setContentView(R.layout.custom_dialog);

                ((TextViewPlus) dialog.findViewById(R.id.textView3)).setTypeface(CF);

                Button dialogButton = (Button) dialog.findViewById(R.id.show_result_btn);
                dialogButton.setTypeface(CF);

                pickerDate = (DatePicker) dialog.findViewById(R.id.datePicker);

                Calendar today = Calendar.getInstance();

                pickerDate.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                        today.get(Calendar.DAY_OF_MONTH), null);

                dialogButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity.this, FateActivity.class);

                        intent.putExtra("FATEbyDATE.fateNum", getFate());

                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        });

        //-------------------------------ADD PLACE-----------------------------------------

        AdView adView = (AdView)this.findViewById(R.id.adView);

        AdRequest adRequest =new com.google.android.gms.ads.AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("e2ae6d65c5bc0ad2").build();

        //AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int getFate()
    {
        int fateNum = 0;
        int fDay = pickerDate.getDayOfMonth();
        int fMonth = pickerDate.getMonth() + 1;
        int fYear = pickerDate.getYear();
        int fSumYear = 0;

        if (fDay > 22)
            fDay -= 22;

        String yearToStr = String.valueOf(fYear);
        for (int i=0; i<yearToStr.length(); i++)
        {
            fSumYear += Integer.valueOf(yearToStr.substring(i,i+1));
        }

        if(fSumYear > 22)
            fSumYear -= 22;

        fateNum = fDay + fMonth + fSumYear;

        if(fateNum > 22)
            fateNum -= 22;

        return fateNum;
    }


}
