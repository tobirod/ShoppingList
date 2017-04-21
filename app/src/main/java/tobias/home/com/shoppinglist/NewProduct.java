package tobias.home.com.shoppinglist;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class NewProduct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPref = NewProduct.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                EditText qtyextract = (EditText)findViewById(R.id.quantityinput);
                String qty = qtyextract.getText().toString();

                EditText productextract = (EditText)findViewById(R.id.productinput);
                String product = productextract.getText().toString();

                String listitem = qty + " " + unit + " " + product;

//                editor.putString(getString(R.string.saved_high_score), listitem);
//                editor.commit();

                NewProduct.this.finish();
            }
        });

        spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(NewProduct.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public String unit;


    private Spinner spinner;
    private static final String[]paths = {"pieces", "liter", "kilograms"};



    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                unit = "pcs";
                break;
            case 1:
                unit = "l";
                break;
            case 2:
                unit = "kg";
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
