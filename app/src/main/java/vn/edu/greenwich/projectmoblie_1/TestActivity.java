package vn.edu.greenwich.projectmoblie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class TestActivity extends AppCompatActivity {

    EditText etName, etAddress, etBedrooms, etPrice, etReporter, etNote;
    AutoCompleteTextView autocompleteTxtTest, autoFutureTxtTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etName = findViewById(R.id.et_name_test);
        etAddress = findViewById(R.id.et_address_test);
        etBedrooms = findViewById(R.id.et_bedrooms_test);
        etPrice = findViewById(R.id.et_price_test);
        etReporter = findViewById(R.id.et_reporter_test);
        etNote = findViewById(R.id.et_note_test);
        autocompleteTxtTest = findViewById(R.id.auto_complete_txt_test);
        autoFutureTxtTest = findViewById(R.id.auto_future_txt_test);



        String name ="";
        String address ="";
        String bedrooms ="";
        String price ="";
        String reporter ="";
        String note ="";
        String type="";
        String furniture ="";

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            name = bundle.getString("name");
            address = bundle.getString("bedrooms");
            type = bundle.getString("type");
            furniture = bundle.getString("furniture");
            bedrooms = bundle.getString("bedrooms");
            price = bundle.getString("price");
            reporter = bundle.getString("reporter");
            note = bundle.getString("note");
        }
        etName.setText(name);
        etAddress.setText(address);
        etBedrooms.setText(bedrooms);
        etPrice.setText(price);
        etReporter.setText(reporter);
        etNote.setText(note);
        autoFutureTxtTest.setText(furniture);
        autocompleteTxtTest.setText(type);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}