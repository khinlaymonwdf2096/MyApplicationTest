package com.example.myancare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Toast;

import com.example.myancare.adapter.RecyclerViewAdapter;
import com.example.myancare.model.ItemInfo;
import com.example.myancare.viewmodel.MainActivityViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        initViewModel();


    }
    private void initRecyclerView(){
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter=new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void initViewModel(){
        MainActivityViewModel viewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);

            viewModel.getMutableLiveData().observe(this, new Observer<List<ItemInfo>>() {
                @Override
                public void onChanged(List<ItemInfo> userInfos) {
                    if(userInfos!=null){
                        recyclerViewAdapter.setData(userInfos);
                        recyclerViewAdapter.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Error in getting data. Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            viewModel.makeapiCall();


    }


}