package edu.mobidev.g301.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String EXTRAS_FRUIT = "fruit";
    ListView lvFruits;
    ArrayList<String> arrayFruits;
    ArrayAdapter adapterFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFruits = (ListView) findViewById(R.id.lv_fruits);
        {
            arrayFruits = new ArrayList<>();
            arrayFruits.add("Apple");
            arrayFruits.add("Banana");
            arrayFruits.add("Currant");
            arrayFruits.add("Durian");
            arrayFruits.add("E");
            arrayFruits.add("Fig");
            arrayFruits.add("G");
            arrayFruits.add("H");
            arrayFruits.add("Indian Mango");
            arrayFruits.add("J");
            arrayFruits.add("K");
            arrayFruits.add("L");
        }
        adapterFruits = new ArrayAdapter(getBaseContext(),
                R.layout.list_item, arrayFruits);

        lvFruits.setAdapter(adapterFruits);
        lvFruits.setOnItemClickListener(onFruitSelect);
        lvFruits.setOnItemLongClickListener(onFruitLongSelect);
    }

    AdapterView.OnItemClickListener onFruitSelect = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
            String fruit = (String) parent.getItemAtPosition(position);
            Intent i = new Intent();
            i.setClass(getBaseContext(),FruitActivity.class);
            i.putExtra(EXTRAS_FRUIT, fruit);
            startActivity(i);
        }
    };

    AdapterView.OnItemLongClickListener onFruitLongSelect = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            arrayFruits.remove(position);
            adapterFruits.notifyDataSetChanged();
            return true;
        }
    };


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
