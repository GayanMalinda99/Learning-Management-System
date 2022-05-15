package com.example.mynotes.adapters;

import android.content.Context;
import android.util.Log;
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
    private RecycleViewClickListner itemClickListner ;

    public CourseAdapter(Context ct , List<String> courses, RecycleViewClickListner listner){
        context = ct;
        allEnrolledCourses = courses ;
        itemClickListner = listner ;
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

    public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView ;
        ImageButton imageButton ;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.course_text) ;
            imageButton = itemView.findViewById(R.id.course_delete_button) ;
            itemView.setOnClickListener(this);
            itemView.findViewById(R.id.course_delete_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("Course name : ", textView.getText().toString()) ;
                }
            });
        }

        @Override
        public void onClick(View view) {
            itemClickListner.onItemClick(itemView, getAdapterPosition());
        }
    }

   public interface RecycleViewClickListner{
        void onItemClick(View view, int position) ;
   }
}
