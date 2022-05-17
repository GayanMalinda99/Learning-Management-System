package com.example.mynotes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.R;

import java.util.List;

public class LecturerCourseAdapter extends RecyclerView.Adapter<LecturerCourseAdapter.LecturerViewHolder> {

    Context context ;
    List<String> courses ;

    public LecturerCourseAdapter(Context context, List<String> courses){
        this.context= context ;
        this.courses = courses ;

    }

    @NonNull
    @Override
    public LecturerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context) ;
        View view = inflater.inflate(R.layout.lecturer_course_list_item, parent, false) ;
        return new LecturerViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull LecturerViewHolder holder, int position) {
        holder.textView.setText(courses.get(position));
    }

    @Override
    public int getItemCount() {
        return courses.size() ;
    }

    public class LecturerViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;

        public LecturerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.lecturer_list_item) ;
        }


    }
}
