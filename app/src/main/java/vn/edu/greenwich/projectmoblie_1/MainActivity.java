package vn.edu.greenwich.projectmoblie_1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {


    EditText etName, etAddress, etBedrooms, etPrice, etReporter, etNote;
    MaterialButton btnSubmit;
    TextInputLayout til_name, til_address, til_type, til_furniture, til_bedrooms, til_price, til_reporter, til_note;
    String[] items = {"Apartment", "Penthouse", "House", "Villa"};
    String[] furniture = {"Unfurnished", "Half Furnished", "Furnished"};
    AutoCompleteTextView autocompleteTxt, autoFutureTxt;
    ArrayAdapter<String> futureAdapter;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autocompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);
        autocompleteTxt.setAdapter(adapterItems);
        autocompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        autoFutureTxt = findViewById(R.id.auto_future_txt);
        futureAdapter = new ArrayAdapter<String>(this, R.layout.list_item, furniture);
        autoFutureTxt.setAdapter(futureAdapter);
        autoFutureTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String future = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Item: " + future, Toast.LENGTH_SHORT).show();
            }
        });



        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(btnSubmit_Click);
}

    private final View.OnClickListener btnSubmit_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Boolean isValid = true;
            etName = findViewById(R.id.et_name);
            til_name = findViewById(R.id.til_name);
            etAddress = findViewById(R.id.et_address);
            til_address = findViewById(R.id.til_address);
            etBedrooms = findViewById(R.id.et_bedrooms);
            til_bedrooms = findViewById(R.id.til_bedrooms);
            etPrice = findViewById(R.id.et_price);
            til_price = findViewById(R.id.til_price);
            etReporter = findViewById(R.id.et_reporter);
            til_reporter = findViewById(R.id.til_reporter);
            etNote = findViewById(R.id.et_note);
            til_note = findViewById(R.id.til_note);
            til_type = findViewById(R.id.til_type);
            til_furniture = findViewById(R.id.til_furniture);


            String name = etName.getText().toString();
            String address = etAddress.getText().toString();
            String bedrooms = etBedrooms.getText().toString();
            String price = etPrice.getText().toString();
            String reporter = etReporter.getText().toString();
            String note = etNote.getText().toString();
            String type = autocompleteTxt.getText().toString();
            String furniture = autoFutureTxt.getText().toString();


            if (TextUtils.isEmpty(name)) {
                isValid = false;
                til_type.setError("* Type can't be blank");
            } else {
                til_type.setError("");
            }
            if (TextUtils.isEmpty(name)) {
                isValid = false;
                til_furniture.setError("* Furniture can't be blank");
            } else {
                til_furniture.setError("");
            }

            if (TextUtils.isEmpty(name)) {
                isValid = false;
                til_name.setError("* Name can't be blank");
            } else {
                til_name.setError("");
            }

            if (TextUtils.isEmpty(address)) {
                isValid = false;
                til_address.setError("* Address can't be blank");
            } else {
                til_address.setError("");
            }
            if (TextUtils.isEmpty(price)) {
                isValid = false;
                til_price.setError("* Price can't be blank");
            } else {
                til_price.setError("");
            }
            if (TextUtils.isEmpty(bedrooms)) {
                isValid = false;
                til_bedrooms.setError("* Bedrooms can't be blank");
            } else {
                til_bedrooms.setError("");
            }
            if (TextUtils.isEmpty(reporter)) {
                isValid = false;
                til_reporter.setError("* Reporter can't be blank");
            } else {
                til_reporter.setError("");
            }

            if (isValid) {

                Bundle accountInfo = new Bundle();
                accountInfo.putString("name", name);
                accountInfo.putString("address", address);
                accountInfo.putString("type", type);
                accountInfo.putString("furniture", furniture);
                accountInfo.putString("bedrooms", bedrooms);
                accountInfo.putString("price", price);
                accountInfo.putString("reporter", reporter);
                accountInfo.putString("note", note);

                // Create a new activity and start it.
                Intent testActivity = new Intent(view.getContext(), TestActivity.class);

                // 1st method to transfer data.
                testActivity.putExtras(accountInfo);


                // Start "TestActivity".
                startActivity(testActivity);
                // Terminate current activity.
//                finish();
            }
        }
    };

}