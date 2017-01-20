package com.jayfeng.lesscode.core.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.core.app.model.LessItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<LessItem> list;
    ListView listView;
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = ViewLess.$(this, R.id.listview);

        initData();

        adapter = AdapterLess.$base(this, list, R.layout.activity_main_list_item,
                new AdapterLess.CallBack<LessItem>() {
                    @Override
                    public View getView(int position, View convertView, AdapterLess.ViewHolder holder, LessItem lessItem) {
                        TextView nameView = holder.$view(convertView, R.id.name);
                        nameView.setText(lessItem.getName());
                        return convertView;
                    }
                });
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClassName(MainActivity.this, "com.jayfeng.lesscode.core.app." + list.get(position).getClassName());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();

        LessItem lessItem = new LessItem();
        lessItem.setName("AdapterLess.$base的使用");
        lessItem.setClassName("BaseAdapterActivity");
        list.add(lessItem);

        lessItem = new LessItem();
        lessItem.setName("AdapterLess.$pager的使用");
        lessItem.setClassName("PagerAdapterActivity");
        list.add(lessItem);

        lessItem = new LessItem();
        lessItem.setName("AdapterLess.$recycler的使用");
        lessItem.setClassName("RecyclerAdapterActivity");
        list.add(lessItem);
    }
}
