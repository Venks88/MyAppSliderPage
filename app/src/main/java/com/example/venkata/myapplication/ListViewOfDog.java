package com.example.venkata.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class ListViewOfDog extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView listview = (ListView) findViewById(R.id.LVlistview);
        String[] values = new String[] { "Dog1", "Dog2", "Dog3",
                "Dog4", "Dog5", "Dog6", "Dog7", "Dog8",
                "Dog9", "Dog10", "Dog11", "Dog12", "Dog13",
                "Dog14", "Dog15", "Dog16", "Dog17", "Dog18",
                "Dog19", "Dog20", "Dog21", "Dog22", "Dog23" };

        String[] DescriptionValues = new String[] {
                "This delightful, but common creature is a type of invertebrate. It's about the size of a squid, has four winged arms, four legs and a short, muscular tail.",
                "They have a thick, armored skin which is usually either dark blue, light red, light gold or gold or a combination of these colors.",
                "They live in quiet areas and are quite common. They're omnivores and their small, narrow mouths and short tongue are ideal for eating fish.",
                "They're crepuscular and rely on their sense of smell and extra sense to get around. They do have small, slanted eyes, but their sight is not impressive.",
                "They have huge noses and tiny, almost hidden ears. Their heads are relatively small in comparison to their bodies.",
                "They make sounds ranging from fairly low pitched to fairly high pitched and have a large range of sounds they make to indicate discoveries, dangers and otherwise communicate with each other.",
                "These creatures are quite timid, but they're very territorial. They mate four times a year and they mate with just 1 partner for life. Which, with their incredibly long lifespans, is only normal.",
                "This lovely and rare creature is a type of bird. It's about the size of an eagle, has two enormous wings, four small, clawed legs and a short, powerful tail.",
                "They have a thin, rough skin covered in small, thin feathers, which is usually either black, dark pink, yellow, light red or light purple or a combination of these colors.",
                "They live in hot areas and are relatively rare. They're omnivores and their beaks and wide tongue are ideal for eating fruits.",
                "They're crepuscular and rely on their taste buds and sense of smell to get around. They do have small, round eyes, but their sight is lacking.",
                "They have short, sharp beaks and virtually no visible ears. Their heads are large and long in comparison to their bodies.",
                "They make sounds ranging from high pitched to fairly high pitched and have a extremely limited range of sounds they make to indicate discoveries, dangers and otherwise communicate with each other.",
                "These creatures are quite nervous, but they have no real territory and wish to avoid conflicts. They mate once every three years and they mate with one or two partners throughout life. Which, with their long lifepans, isn't too surprising.",
                "This funny, but common creature is a type of reptile. It's about the size of an alligator, has six legs and a short, strong tail.",
                "They have a soft, smooth skin covered in thick, strong scales, which is usually either dark grey or light grey or a combination of these colors.",
                "They live in rainy areas and are rare. They're carnivores and their large, wide mouths, their teeth and long tongue are ideal for eating smaller creatures.",
                "They're crepuscular and rely on their sight and sense of smell to get around. They do have pretty much no visible ears, but their hearing is underdeveloped.",
                "They have narrow noses and odd, but interesting eyes. Their heads are large and wide in comparison to their bodies.",
                "They make sounds ranging from low pitched to relatively low pitched and have a very limited range of sounds they make to indicate discoveries, dangers and otherwise communicate with each other.",
                "These creatures are timid and they tend to let their territory be taken be stronger creatures. They mate four times a year and they mate with a select few partners throughout life. Which, with their unfortunately short lifespans, isn't too surprising.",
                "They have tiny noses and pretty much no visible ears. Their heads are long and narrow in comparison to their bodies.",
                "They have narrow noses and large, slanted eyes. Their heads are large and wide in comparison to their bodies." };



        int[] imagesForDisplay = {R.drawable.dog1, R.drawable.dog2,
                R.drawable.dog3,R.drawable.dog4,R.drawable.dog5,
                R.drawable.dog6,R.drawable.dog7,R.drawable.dog8,
                R.drawable.dog9,R.drawable.dog10,R.drawable.dog11,
                R.drawable.dog12,R.drawable.dog13,R.drawable.dog14,
                R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,
                R.drawable.dog4,R.drawable.dog5,R.drawable.dog6,
                R.drawable.dog7,R.drawable.dog8,R.drawable.dog9};


        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        //for the description
        final ArrayList<String> listdesc = new ArrayList<String>();
        for (int i = 0; i < DescriptionValues.length; ++i) {
            listdesc.add(DescriptionValues[i]);
        }

        //for images to display [to change into int]
        final ArrayList<Integer> listimg = new ArrayList<Integer>();
        for (int i = 0; i < imagesForDisplay.length; ++i) {
            listimg.add(imagesForDisplay[i]);

        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Bundle bundle = new Bundle();

                bundle.putString("param1", list.get(position));

                bundle.putString("param2", listdesc.get(position));

                bundle.putString("param3", String.valueOf(listimg.get(position)));

                Intent intent = new Intent(ListViewOfDog.this, AnimalDogDisplayPage.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }


        });


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
