package com.example.venkata.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Venkata on 2015-02-20.
 */
public class AnimalDogDisplayPage extends Activity
{
    CheckBox cbreserve;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagetwo_main);

        btSubmit = (Button) findViewById(R.id.bt_Submit);
        btSubmit.setEnabled(false);

        Bundle bundle = this.getIntent().getExtras();
        String param1 = bundle.getString("param1");
        String param2 = bundle.getString("param2");
        String param3 = bundle.getString("param3");

        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(param1);

        TextView tv2 = (TextView) findViewById(R.id.textView);
        tv2.setText(param2);

        ImageView iv = (ImageView) findViewById(R.id.iv_Displayphoto);
        iv.setImageResource(Integer.parseInt(param3));

        cbreserve = (CheckBox) findViewById(R.id.cb_Reserve);

        cbreserve.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked) {
                    // activate the submit button.
                    btSubmit.setEnabled(true);
                    // activate the email page.
                    addListenerOnButton();
                }
                else
                {
                    //To add something in the future.
                }



            }
        });

    }

    public void addListenerOnButton() {

        final Context context = this;

        btSubmit = (Button) findViewById(R.id.bt_Submit);

        //Swapping between the different pages on login (i.e.) swapping between FRENCH and ENGLISH.
        //SOURCE: http://stackoverflow.com/questions/16469355/if-one-button-press-does-something-other-buttons-pressed-should-do-something-el
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(btSubmit)) {
                    Intent intent = new Intent(context, EmailSPCAPage.class);
                    startActivity(intent);
                }
            }
        };

        btSubmit.setOnClickListener(listener);

    }


}

