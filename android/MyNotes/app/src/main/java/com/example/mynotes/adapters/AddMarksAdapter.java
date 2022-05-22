package com.example.mynotes.adapters;

import android.content.Context;
import android.util.Log;
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
import com.example.mynotes.model.Marks;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddMarksAdapter extends RecyclerView.Adapter<AddMarksAdapter.AddMarksViewHolder> {
    private Context context ;
    private List<AppUser> students ;
    String courseCode ;

    public AddMarksAdapter(Context context, List<AppUser> students, String courseCode){
        this.context = context ;
        this.students = students ;
        this.courseCode = courseCode ;
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
        EditText marksEditText ;
        ImageButton addButton ;

        public AddMarksViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.student_id) ;
            marksEditText = itemView.findViewById(R.id.marks_input) ;
            addButton = itemView.findViewById(R.id.add_marks_button) ;

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Long marks = new Long(Integer.parseInt(marksEditText.getText().toString())) ;

                    int position = -1 ;

                    //Getting the position
                    for(int i = 0; i < students.size(); i++){
                        if(textView.getText().toString() == students.get(i).getStudentId()){
                            position = i ;
                        }
                    }

                    //Creating a marks object
                    Marks studentMarks = new Marks() ;
                    studentMarks.id = position ;
                    studentMarks.course_code = courseCode ;
                    studentMarks.student_id = new Long(textView.getText().toString()) ;
                    studentMarks.marks = marks ;

                    //Creating retrofit instance to send data
                    Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
                    final CoursesApi api =  retrofit.create(CoursesApi.class) ;

                    //Create post request to post marks
                    Call<Marks> call = api.saveMarks(studentMarks) ;
                    call.enqueue(new Callback<Marks>() {
                        @Override
                        public void onResponse(Call<Marks> call, Response<Marks> response) {
                            Log.i("Messege", "done") ;
                        }

                        @Override
                        public void onFailure(Call<Marks> call, Throwable t) {
                            Log.i("Error", t.toString()) ;
                        }
                    });
                }
            });
        }
    }
}
