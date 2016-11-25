package com.example.andrzej.listazadan;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrzej on 25.11.2016.
 */

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.TodoViewHolder> {

    private List<TodoTask> mData = Collections.emptyList();

    public void setData(List<TodoTask> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rowView = inflater.inflate(R.layout.row_todoitem, parent, false);
        return new TodoViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        TodoTask task = mData.get(position);

        //ustawienie paska priorytetu
        if (task.isPriority()){
            holder.mStripe.setBackgroundColor(Color.RED);
        } else {
            holder.mStripe.setBackgroundColor(Color.TRANSPARENT);
        }
        //lub za pomocą operatora warunkowego
        // holder.mStripe.setBackgroundColor(task.isPriority() ? Color.RED : Color.TRANSPARENT);

        //ustawienie checkboxa DONE
        holder.mDone.setChecked(task.isDone());

        //ustawienie tytułu zadania
        holder.mTitle.setText(task.getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stripe)
        View mStripe;
        @BindView(R.id.done)
        CheckBox mDone;
        @BindView(R.id.task_title)
        TextView mTitle;

        public TodoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
