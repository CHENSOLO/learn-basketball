package com.example.administrator.ball_ball;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

@SuppressLint("ValidFragment")
public class VideoplayFragment extends Fragment implements AdapterView.OnItemClickListener {
    private FragmentManager fManager;
    private ArrayList<Data> datas;
    private ListView list_news;


    public VideoplayFragment(FragmentManager fManager, ArrayList<Data> datas) {
        this.fManager = fManager;
        this.datas = datas ;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_newlist,container,false);
        list_news = view.findViewById(R.id.list_news);

     MyAdapter myAdapter = new MyAdapter(datas,getActivity());

     list_news.setAdapter(myAdapter);
     list_news.setOnItemClickListener(this);
     return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Log.i("LOG", "onItemClick");
        Intent intent = new Intent();
        intent.setClass(getActivity(),Video_play.class);
        Log.i("LOG", datas.get(position).getTags());
         intent.putExtra("cc",datas.get(position).getTags());
        startActivity(intent);
    }
}
