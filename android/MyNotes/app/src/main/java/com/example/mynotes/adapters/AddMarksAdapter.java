package com.example.mynotes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.R;
import com.example.mynotes.model.AppUser;

import java.util.List;

public class AddMarksAdapter extends RecyclerView.Adapter<AddMarksAdapter.AddMarksViewHolder> {
    private Context context ;
    private List<AppUser> students ;

    public AddMarksAdapter(Context context, List<AppUser> students){
        this.context = context ;
        this.students = students ;
    }

    @NonNull
    @Override
    public AddMarksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context) ;
        View view = inflater.inflate(R.layout.marks_list_item, parent, false) ;
        return new AddMarksAdapter.AddMarksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddMarksViewHolder holder, int position) {
        holder.textView.setText(students.get(position).getStudentId());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class AddMarksViewHolder extends RecyclerView.ViewHolder{
        TextView textView ;
        EditText marks ;
        ImageButton addButton ;

        public AddMarksViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.student_id) ;
            marks = itemView.findViewById(R.id.marks_input) ;
            addButton = itemView.findViewById(R.id.add_marks_button) ;
        }
    }
}
