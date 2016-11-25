package com.example.andrzej.listazadan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrzej on 25.11.2016.
 */

public class TodoListFragment extends Fragment {

    @BindView(R.id.todo_list)
    protected RecyclerView mTodoList;

    private TodoItemAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todolist, container, false);
        ButterKnife.bind(this, view);

        mTodoList.setLayoutManager(new LinearLayoutManager(getContext()));

        TodoItemsRepository itemsRepository = new SqlTodoItemsRepository(getContext());

        mAdapter = new TodoItemAdapter();
        mAdapter.setData(itemsRepository.getTodoList());
        mTodoList.setAdapter(mAdapter);
        return view;
    }


}
