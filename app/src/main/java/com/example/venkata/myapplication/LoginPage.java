package com.example.venkata.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by Venkata on 2015-03-13.
 */
public class LoginPage extends Activity
{

    Button button_fr;
    Button button_en;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        addListenerOnButton();

    }


    public void addListenerOnButton() {

        final Context context = this;

        button_en = (Button) findViewById(R.id.bt_english);
        button_fr = (Button) findViewById(R.id.bt_french);

        //Swapping between the different pages on login (i.e.) swapping between FRENCH and ENGLISH.
        //SOURCE: http://stackoverflow.com/questions/16469355/if-one-button-press-does-something-other-buttons-pressed-should-do-something-el
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(button_en)) {
                    Intent intent = new Intent(context, AnimalTypeChooserClass.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(context, AnimalTypeChooserClass.class);
                    startActivity(intent);
                }
            }
        };

        button_en.setOnClickListener(listener);
        button_fr.setOnClickListener(listener);


    }
}
