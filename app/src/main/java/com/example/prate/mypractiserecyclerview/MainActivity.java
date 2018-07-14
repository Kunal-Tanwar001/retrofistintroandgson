package com.example.prate.mypractiserecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
ListView listView;
ProgressBar progressBar;
FloatingActionButton fb;
ArrayList<String> items;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fb=  findViewById(R.id.fab);
       listView=findViewById(R.id.listView);
       progressBar=findViewById(R.id.progressBar);
        items=new ArrayList<>();
         adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);

       listView.setAdapter(adapter);



    }

       public void fetchData(final View view){


           Retrofit retrofit=new Retrofit.Builder().baseUrl("https://www.codingninjas.in/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();

           courseapi api=retrofit.create(courseapi.class);
           Call<CourseResponse> call=api.getcoursename();
           listView.setVisibility(view.GONE);
           progressBar.setVisibility(view.VISIBLE);

           call.enqueue(new Callback<CourseResponse>() {
               @Override
               public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                   Log.d("Mainactivity","chala kya");
                   CourseResponse courseResponse=response.body();

            ArrayList<course>cp=courseResponse.getData().courses;
                   items.clear();
            for(int i=0;i<cp.size();i++){
                items.add(cp.get(i).coursename);

            }
          listView.setVisibility(view.VISIBLE);
            progressBar.setVisibility(view.GONE);
               }

               @Override
               public void onFailure(Call<CourseResponse> call, Throwable t) {

                   listView.setVisibility(view.VISIBLE);
                   progressBar.setVisibility(view.GONE);
                   Toast.makeText(getBaseContext(),"bhosdike nhi chala hahhahahahhahahahahhahahahah",Toast.LENGTH_SHORT);

               }
           });

       }

}
