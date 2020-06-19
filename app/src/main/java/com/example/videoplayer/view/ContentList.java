package com.example.videoplayer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.videoplayer.R;
import com.example.videoplayer.adapter.Adapter;
import com.example.videoplayer.model.GET;
import com.example.videoplayer.viewmodel.CustomViewModel;

import java.util.List;

public class ContentList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_list);

        recyclerView = findViewById(R.id.RecyclerId);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        CustomViewModel customViewModel = new ViewModelProvider(this).get(CustomViewModel.class);

        customViewModel.getPost().observe(this, new Observer<List<GET>>() {
            @Override
            public void onChanged(List<GET> gets) {
                if (gets.isEmpty()){
                    Toast.makeText(ContentList.this,"ERROR",Toast.LENGTH_LONG).show();
                }

                adapter = new Adapter(ContentList.this,gets);
                adapter.notifyDataSetChanged();
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }
        });



    }
}
