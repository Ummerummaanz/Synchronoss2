package com.example.synchronoss2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText etContact;
    TextView tvHome;
    TextView tvAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etContact = findViewById(R.id.etContact);
        tvHome = findViewById(R.id.tvHome);
        tvAuthor = findViewById(R.id.tvAuthor);
        /*String name = getIntent().getExtras().getString("nkey");
        tvHome.setText("hello "+name);*/

    }
    public void handleClicks(View viewclick) {
       /* String name = etContact.getText().toString();
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();*/
        sendContactData();
        searchBooks();
    }



    private void sendContactData() {
        //get the data to be sent
        String contactData = etContact.getText().toString();
        //send the data to the parent activity
        Intent dIntent = new Intent();
        dIntent.putExtra("con",contactData);
        setResult(RESULT_OK,dIntent); //smell-headsup to inform the parent activity
        //close this activity
        finish();

    }

    private void searchBooks() {
        String queryString = etContact.getText().toString();
        new FetchBook(tvHome,tvAuthor).execute(queryString);
    }
}

