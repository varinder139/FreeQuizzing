package com.varinder.freequizzing;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdaptor extends BaseAdapter {

    private int sets = 0;
    private String category;

    public GridAdaptor(int sets, String category) {

        this.sets = sets;
        this.category = category;
    }

    @Override
    public int getCount() {
        return sets;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertview, final ViewGroup viewGroup) {
        View view;

        if (convertview == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.set_item, viewGroup, false);
        }else {
            view = convertview;
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent questionIntent = new Intent(viewGroup.getContext(), QuestionsActivity.class);
                questionIntent.putExtra("category", category);
                questionIntent.putExtra("setNo", i+1);
                viewGroup.getContext().startActivity(questionIntent);
            }
        });

        ((TextView)view.findViewById(R.id.textView)).setText(String.valueOf(i+1));

        return view;
    }
}
