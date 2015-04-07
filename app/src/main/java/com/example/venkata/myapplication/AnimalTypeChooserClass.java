package com.example.venkata.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Venkata on 2015-03-13.
 */
public class AnimalTypeChooserClass extends Activity
{

    Button bt_catchooser;
    Button bt_dogchooser;
    Button bt_exoticchooser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_type_chooser);
        addListenerOnButton();

    }

    public void addListenerOnButton() {

        final Context context = this;

        bt_catchooser = (Button) findViewById(R.id.bt_catchooser);
        bt_dogchooser = (Button) findViewById(R.id.bt_dogchooser);
        bt_exoticchooser = (Button) findViewById(R.id.bt_exoticchooser);

        //Swapping between the different pages on login (i.e.) swapping between FRENCH and ENGLISH.
        //SOURCE: http://stackoverflow.com/questions/16469355/if-one-button-press-does-something-other-buttons-pressed-should-do-something-el
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(bt_catchooser)) {
                    Intent intent = new Intent(context, ListViewOfCat.class);
                    startActivity(intent);
                } else if(v.equals(bt_dogchooser)){
                    Intent intent = new Intent(context, ListViewOfDog.class);
                    startActivity(intent);
                }else
                {
                    Intent intent = new Intent(context, ListViewOfExotic.class); //to add exotic animals class
                    startActivity(intent);
                }
            }
        };

        bt_catchooser.setOnClickListener(listener);
        bt_dogchooser.setOnClickListener(listener);
        bt_exoticchooser.setOnClickListener(listener);


    }
}