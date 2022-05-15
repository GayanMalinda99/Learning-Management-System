package com.example.mynotes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context ;
    List<String> allEnrolledCourses;

    public CourseAdapter(Context ct , List<String> courses){
        context = ct;
        allEnrolledCourses = courses ;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context) ;
        View view = inflater.inflate(R.layout.course_list_item, parent, false) ;
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.textView.setText(allEnrolledCourses.get(position));
    }

    @Override
    public int getItemCount() {
        return allEnrolledCourses.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;
        ImageButton imageButton ;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.course_text) ;
            imageButton = itemView.findViewById(R.id.course_delete_button) ;

        }
    }
}
