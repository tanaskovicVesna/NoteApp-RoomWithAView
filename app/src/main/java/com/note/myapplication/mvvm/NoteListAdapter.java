package com.note.myapplication.mvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.notice.myapplication.R;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private final LayoutInflater mInflater;

     private List<Notice> mNotices; // Cached copy of words


    public NoteListAdapter(Context context,List<Notice> mNotices) {
        mInflater = LayoutInflater.from(context);
        this.mNotices = mNotices;
    }

    public NoteListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView noteItemView;

        private NoteViewHolder(View itemView) {
            super(itemView);
            noteItemView = itemView.findViewById(R.id.textView);
        }
    }




    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (mNotices != null) {
            Notice current = mNotices.get(position);
            holder.noteItemView.setText(current.getNote());
        } else {
            // Covers the case of data not being ready yet.
            holder.noteItemView.setText("No Note");
        }
    }

     void setNotes(List<Notice> notices) {
        mNotices = notices;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mNote has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mNotices != null)
            return mNotices.size();
        else return 0;
    }



}
