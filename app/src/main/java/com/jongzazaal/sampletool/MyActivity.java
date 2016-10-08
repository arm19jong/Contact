package com.jongzazaal.sampletool;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager = new StaggeredGridLayoutManager(3,1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        //myDataset = {"ggg",""};

        List<String> places = Arrays.asList("Yo Sarandar Mild","Boontarika Pochchongdach",
                "Kumiko Matsuyama","ศกานต์ พรหมลายนาค","Pumpsama");
        ArrayList<String> ar = new ArrayList(places);

        ArrayList<Integer> pic = new ArrayList<Integer>();
        pic.add(R.drawable.yo);
        pic.add(R.drawable.tanmo);
        pic.add(R.drawable.nn);
        pic.add(R.drawable.tao);
        pic.add(R.drawable.pump);

        ArrayList<String> phone = new ArrayList<String>();
        phone.add("0000000000");
        phone.add("1111111111");
        phone.add("2222222222");
        phone.add("3333333333");
        phone.add("4444444444");

        ArrayList<String> email = new ArrayList<String>();
        email.add("yo@mail.com");
        email.add("tanmo@mail.com");
        email.add("nn@mail.com");
        email.add("tao@mail.com");
        email.add("pumpsama@mail.com");

        mAdapter = new MyAdapter(getApplicationContext(), ar, pic, phone, email);
        mRecyclerView.setAdapter(mAdapter);
        //mRecyclerView.addOnItemTouchListener(
    }

    public void startAct(Context context, String mDataset){
        Intent i = new Intent(context, Context.class);
        i.putExtra("contact_name", mDataset );
        //startActivityForResult(i, 1);
        startActivity(i);
    }


}
