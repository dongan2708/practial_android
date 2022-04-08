package com.example.practial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practial.database.AppDatabase;
import com.example.practial.entity.Product;

public class MainActivity extends AppCompatActivity {
    Button btnSubmitForm;
    EditText editText1, editText2;
    Context ctx;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        ctx = this;
        initData();
        initListener();
    }

    public void initData(){
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        btnSubmitForm = (Button) findViewById(R.id.buttonSubmitForm);
    }

    private void initListener() {
        btnSubmitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et1 = editText1.getText().toString();
                String et2 = editText2.getText().toString();
                try {
                    Product product = new Product();
                    product.name = et1;
                    product.quantity = Integer.parseInt(et2);
                    db.productDao().insertProduct(product);
                    CharSequence charSequence = "Successfully !";
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                    ctx.startActivity(new Intent(ctx, MainActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}