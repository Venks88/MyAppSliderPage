package com.example.venkata.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Venkata on 2015-03-13.
 */
public class EmailSPCAPage extends Activity implements TextWatcher {

    Button btSend;
    TextView tvConfirmationNumber;
    EditText etMessage;
    EditText etEmailID;
    ImageView ivLognPage;

    //for thank you page
    ImageView ivthankyoulogo;
    TextView tvthankyoutext;
    TextView tvconfnumindicatorthankyou;
    TextView tvphonethankyou;
    TextView tvtextview3;
    TextView tvtextview4;
    TextView tvtextview5;
    Button btbacktoanimalselection;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_page);

        ivLognPage = (ImageView)findViewById(R.id.iv_loginpage);
        ivthankyoulogo = (ImageView)findViewById(R.id.iv_thankyoulogo);
        tvthankyoutext = (TextView)findViewById(R.id.tv_thankyoutext);
        tvconfnumindicatorthankyou = (TextView)findViewById(R.id.tv_confnumindicatorthankyou);
        tvphonethankyou = (TextView)findViewById(R.id.tv_phonethankyou);
        tvtextview3 = (TextView)findViewById(R.id.textView3);
        tvtextview4 = (TextView)findViewById(R.id.textView4);
        tvtextview5 = (TextView)findViewById(R.id.textView5);

        btSend = (Button) findViewById(R.id.bt_Send);
        btSend.setEnabled(false);

        tvConfirmationNumber = (TextView) findViewById(R.id.tv_ConfirmationNumber);
        tvConfirmationNumber.setVisibility(TextView.INVISIBLE);

        etMessage = (EditText) findViewById(R.id.et_message);
        etMessage.addTextChangedListener(this);
        etEmailID = (EditText) findViewById(R.id.et_Email);
        etEmailID.addTextChangedListener(this);

        //setting all invisibles for second page
        tvthankyoutext.setVisibility(EditText.INVISIBLE);
        ivthankyoulogo.setVisibility(ImageView.INVISIBLE);
        tvconfnumindicatorthankyou.setVisibility(TextView.INVISIBLE);
        tvphonethankyou.setVisibility(TextView.INVISIBLE);
        btbacktoanimalselection = (Button) findViewById(R.id.bt_backtoanimalselection);
        btbacktoanimalselection.setVisibility(Button.INVISIBLE);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {


        final Context context = this;


        String emailTextBox = etEmailID.getText().toString();
        String msgTextBox = etMessage.getText().toString();
        if (emailTextBox.length() > 0 & msgTextBox.length() > 0)
        {
            if (emailTextBox.contains("@") & emailTextBox.contains("."))
            {
                btSend.setEnabled(true);
                btSend.isClickable();

                OnClickListener listener = new OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (v.equals(btSend)) {
                            tvConfirmationNumber.setVisibility(TextView.VISIBLE);
                            TextView tvconfirmationNumber = (TextView) findViewById(R.id.tv_ConfirmationNumber);
                            tvconfirmationNumber.setText(String.valueOf(randomgenerator()));

                            btSend.setEnabled(false);
                            btSend.setVisibility((Button.INVISIBLE));
                            etMessage.setVisibility(EditText.INVISIBLE);
                            etEmailID.setVisibility(EditText.INVISIBLE);
                            ivLognPage.setVisibility(ImageView.INVISIBLE);
                            tvtextview3.setVisibility(TextView.INVISIBLE);
                            tvtextview4.setVisibility(TextView.INVISIBLE);
                            tvtextview5.setVisibility(TextView.INVISIBLE);

                            //second page for the last part
                            tvthankyoutext.setVisibility(EditText.VISIBLE);
                            ivthankyoulogo.setVisibility(ImageView.VISIBLE);
                            tvconfnumindicatorthankyou.setVisibility(TextView.VISIBLE);
                            tvphonethankyou.setVisibility(TextView.VISIBLE);
                            btbacktoanimalselection.setVisibility(Button.VISIBLE);

                        }

                        if (v.equals(btbacktoanimalselection)) {
                            Intent intent = new Intent(context, AnimalTypeChooserClass.class);
                            startActivity(intent);
                        }


                    }

                };

                btSend.setOnClickListener(listener);
                btbacktoanimalselection.setOnClickListener(listener);

            }
            else
            {
                Context contexttoast = getApplicationContext();
                CharSequence text = "PLEASE ENTER A VALID E-MAIL ID";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(contexttoast, text, duration);
                toast.show();
            }
        }

    }

    public static String randomgenerator ()
    {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String randomNumber = dateFormat.format(date);
        return randomNumber;
    }


}
