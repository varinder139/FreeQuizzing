package com.varinder.freequizzing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookmarkAdaptor extends RecyclerView.Adapter<BookmarkAdaptor.Viewholder> {

    private List<QuestionModel> list;

    public BookmarkAdaptor(List<QuestionModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(list.get(position).getQuestion(), list.get(position).getAnswer(), position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView question, answer;
        private ImageView deleteBtn;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            question =  itemView.findViewById(R.id.questions);
            answer =  itemView.findViewById(R.id.answer);
            deleteBtn =  itemView.findViewById(R.id.deletebtn);
        }

        private void setData(String question, String answer, int position){
            this.question.setText(question);
            this.answer.setText(answer);

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.remove(position);
                    notifyItemRemoved(position);
                }
            });

        }
    }
}
