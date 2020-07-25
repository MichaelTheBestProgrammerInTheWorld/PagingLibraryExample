package com.michaelmagdy.paginglibraryexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.michaelmagdy.paginglibraryexample.R;
import com.michaelmagdy.paginglibraryexample.model.ApiClient;
import com.michaelmagdy.paginglibraryexample.model.ApiInterface;
import com.michaelmagdy.paginglibraryexample.model.BooksApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;
    public static final String QUERY_KEY = "queryKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.books_edt);
        textView = findViewById(R.id.books_txt);
        button = findViewById(R.id.books_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editText.getText().toString();
                if (query.isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Search box is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, BooksListActivity.class);
                    intent.putExtra(QUERY_KEY, query);
                    startActivity(intent);
                }
            }
        });
    }

    private void callApi(String query){

        Call<BooksApiResponse> call = ApiClient.getApiClient()
                .getApiInterface()
                .getProgrammingBooks( query,1);

        call.enqueue(new Callback<BooksApiResponse>() {
            @Override
            public void onResponse(Call<BooksApiResponse> call, Response<BooksApiResponse> response) {
                BooksApiResponse result = response.body();
                textView.setText(result.getBooks().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<BooksApiResponse> call, Throwable t) {

                Log.d("fail", t.getMessage());
            }
        });
    }
}
