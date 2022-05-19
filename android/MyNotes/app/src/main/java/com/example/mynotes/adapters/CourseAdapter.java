package com.example.mynotes.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.AllCources;
import com.example.mynotes.CourseActivity;
import com.example.mynotes.R;
import com.example.mynotes.dto.CourseEnrollementDto;
import com.example.mynotes.model.Course;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context ;
    List<CourseEnrollementDto> allEnrolledCourses;
    private RecycleViewClickListner itemClickListner ;

    public CourseAdapter(Context ct , List<CourseEnrollementDto> courses, RecycleViewClickListner listner){
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
        holder.textView.setText(allEnrolledCourses.get(position).course_name);
    }

    @Override
    public int getItemCount() {
        return allEnrolledCourses.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView ;
        ImageButton imageButton ;
        int id = 3 ;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.course_text) ;
            imageButton = itemView.findViewById(R.id.course_delete_button) ;
           itemView.setOnClickListener(this);
           itemView.findViewById(R.id.course_delete_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(Integer.toString(id), textView.getText().toString()) ;

                    String courseName = textView.getText().toString() ;
                    int position = -1 ;
                    for(int i = 0 ; allEnrolledCourses.size() > i ; i++){
                        if(courseName==allEnrolledCourses.get(i).course_name){
                            position = i ;
                        }
                    }

                    Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
                    final CoursesApi dropCourseApi = retrofit.create(CoursesApi.class) ;

                    Call<CourseEnrollementDto> call =
                            dropCourseApi.dropCourse(allEnrolledCourses.get(position)) ;
                    call.enqueue(new Callback<CourseEnrollementDto>() {
                        @Override
                        public void onResponse(Call<CourseEnrollementDto> call, Response<CourseEnrollementDto> response) {
                            Log.i("Messege", "done") ;
                        }

                        @Override
                        public void onFailure(Call<CourseEnrollementDto> call, Throwable t) {
                            Log.i("Error", t.toString()) ;
                        }
                    });

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

/*Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
                    final CoursesApi deleteCourseApi = retrofit.create(CoursesApi.class) ;
                    Call<Response> call = deleteCourseApi.dropCourse(
                            allEnrolledCourses.get(position)
                    ) ;
                    call.enqueue(new Callback<Response>() {
                        @Override
                        public void onResponse(Call<Response> call, Response<Response> response) {
                            Log.i("messege", "Success") ;
                        }

                        @Override
                        public void onFailure(Call<Response> call, Throwable t) {
                            Log.i("Messege", "Error") ;
                        }
                    });*/