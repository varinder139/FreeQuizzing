package com.varinder.freequizzing;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {

    private List<categoryModle> categoryModleList;

    public CategoryAdaptor(List<categoryModle> categoryModleList) {
        this.categoryModleList = categoryModleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String image = categoryModleList.get(position).getUrl();
        String mainTitle = categoryModleList.get(position).getName();
        int    getSets = categoryModleList.get(position).getSets();

        holder.setData(image, mainTitle, getSets);
    }

    @Override
    public int getItemCount() {
        return categoryModleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView imageView;
        private TextView title;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.title);


        }

        private void setData(String url, final String title, int sets){
            Glide.with(itemView.getContext()).load(url).into(imageView);
            this.title.setText(title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), SetsActivity.class);
                    intent.putExtra("title", title);
                    intent.putExtra("sets", sets);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
