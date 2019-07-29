package com.example.brobotapp.Adapter;


import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.brobotapp.ToDoActivity;
import com.example.brobotapp.Model.ToDo;
import com.example.brobotapp.R;


class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener
{
    ItemClickListener itemClickListener;
    TextView item_title, item_description;

    public ListItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

        item_title = itemView.findViewById(R.id.item_title);
        item_description = itemView.findViewById(R.id.item_description);
    }

    public void setItemClickListener (ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick (View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);

    }

    @Override
    public void onCreateContextMenu (ContextMenu contextMenu, View
            view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle("Select the action");
        contextMenu.add(0, 0, getAdapterPosition(), "DELETE");

    }

}

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    ToDoActivity toDoActivity;
    List<ToDo> todoList;

    public ListItemAdapter(ToDoActivity toDoActivity, List<ToDo> toDoList) {
        this.toDoActivity = toDoActivity;
        this.todoList = toDoList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(toDoActivity.getBaseContext());
        View view = inflater.inflate(R.layout.activity_list_item,parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

        holder.item_title.setText(todoList.get(position).getTitle());
        holder.item_description.setText(todoList.get(position).getDescription());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                toDoActivity.title.setText(todoList.get(position).getTitle());
                toDoActivity.description.setText(todoList.get(position).getDescription());

                toDoActivity.isUpdate=true;
                toDoActivity.idUpdate = todoList.get(position).getId();
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}

