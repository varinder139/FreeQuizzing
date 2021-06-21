package com.varinder.freequizzing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.varinder.freequizzing.QuestionsActivity.FILE_NAME;
import static com.varinder.freequizzing.QuestionsActivity.KEY_NAME;

public class BookmarkActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private List<QuestionModel> bookmarksList;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bookmark");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rv_bookmark);
        sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();

        getBookMark();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);


        BookmarkAdaptor bookmarkAdaptor = new BookmarkAdaptor(bookmarksList);
        recyclerView.setAdapter(bookmarkAdaptor);

    }

    @Override
    protected void onPause() {
        super.onPause();
        storeBookmark();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getBookMark(){
        String json = sharedPreferences.getString(KEY_NAME, "");
        Type type = new TypeToken<List<QuestionModel>>(){}.getType();
        bookmarksList = gson.fromJson(json, type);

        if (bookmarksList == null){
            bookmarksList = new ArrayList<>();
        }
    }

    private void storeBookmark(){
        String json = gson.toJson(bookmarksList);
        editor.putString(KEY_NAME, json);
        editor.commit();
    }


}