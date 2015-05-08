package alexanderkluev.fatebydate;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import alexanderkluev.fatebydate.R;
import com.google.android.gms.ads.*;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    private DatePicker pickerDate;
    private Button btnShowFate;

    private int year;
    private int month;
    private int day;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickerDate = (DatePicker) findViewById(R.id.datePicker);

        Calendar today = Calendar.getInstance();

        pickerDate.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH), null);

        btnShowFate = (Button) findViewById(R.id.button);

        btnShowFate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FateActivity.class);

                intent.putExtra("FATEbyDATE.fateNum", getFate());

                startActivity(intent);
            }
        });

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
