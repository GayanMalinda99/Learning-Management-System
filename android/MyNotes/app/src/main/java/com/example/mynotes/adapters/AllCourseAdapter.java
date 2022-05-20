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
import com.example.mynotes.dto.CourseEnrollementDto;
import com.example.mynotes.model.Course;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AllCourseAdapter extends RecyclerView.Adapter<AllCourseAdapter.CourseViewHolder> {

    Context context ;
    List<Course> allCourses;

    public AllCourseAdapter(Context ct , List<Course> courses){
        context = ct;
       allCourses = courses ;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context) ;
        View view = inflater.inflate(R.layout.all_cources_list_item, parent, false) ;
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.textView.setText(allCourses.get(position).title);
    }

    @Override
    public int getItemCount() {
        return allCourses.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
       TextView textView ;
       ImageButton imageButton ;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView2) ;
            imageButton = itemView.findViewById(R.id.imageButton2) ;
            int id = 12 ;

            itemView.findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String courseName = textView.getText().toString() ;
                    int position = -1 ;
                    for(int i = 0 ; allCourses.size() > i; i++){
                        if(courseName == allCourses.get(i).title){
                            position = i ;
                        }
                    }

                    Log.i(Integer.toString(position) , textView.getText().toString() ) ;

                    CourseEnrollementDto couseenrolmentdata = new CourseEnrollementDto() ;
                    couseenrolmentdata.studentId = id ;
                    couseenrolmentdata.code= allCourses.get(position).code ;
                    couseenrolmentdata.course_name = allCourses.get(position).title ;
                    couseenrolmentdata.course_description = allCourses.get(position).description ;

                    Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
                    final CoursesApi addCourseApi = retrofit.create(CoursesApi.class) ;

                    Call<CourseEnrollementDto> call = addCourseApi.addCourse(couseenrolmentdata) ;
                    call.enqueue(new Callback<CourseEnrollementDto>() {
                        @Override
                        public void onResponse(Call<CourseEnrollementDto> call, Response<CourseEnrollementDto> response) {
                            Log.i("messege", "done") ;
                        }

                        @Override
                        public void onFailure(Call<CourseEnrollementDto> call, Throwable t) {
                            Log.i("Error", t.toString()) ;
                        }
                    });


                }
            });

        }
    }
}

/*Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
                    final CoursesApi addCourseApi = retrofit.create(CoursesApi.class) ;
                    Call<CourseEnrollementDto> call = addCourseApi.addCourse(allCourses.get(position)) ;
                    call.enqueue(new Callback<CourseEnrollementDto>() {
                        @Override
                        public void onResponse(Call<CourseEnrollementDto> call,
                                               Response<CourseEnrollementDto> response) {
                            Log.i("messege", "Success") ;
                        }

                        @Override
                        public void onFailure(Call<CourseEnrollementDto> call, Throwable t) {
                            Log.i("Messege", "Error") ;
                        }
                    });*/

    /*CourseEnrollementDto couseenrolmentdata = new CourseEnrollementDto() ;
                    couseenrolmentdata.studentId = id ;
                            couseenrolmentdata.code= allCourses.get(position).code ;
                            couseenrolmentdata.course_name = allCourses.get(position).title ;
                            couseenrolmentdata.course_description = allCourses.get(position).description ;

                            Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
final CoursesApi addCourseApi = retrofit.create(CoursesApi.class) ;

        Call<CourseEnrollementDto> call = addCourseApi.addCourse(couseenrolmentdata) ;
        call.enqueue(new Callback<CourseEnrollementDto>() {
@Override
public void onResponse(Call<CourseEnrollementDto> call, Response<CourseEnrollementDto> response) {
        Log.i("messege", "done") ;
        }

@Override
public void onFailure(Call<CourseEnrollementDto> call, Throwable t) {
        Log.i("Error", t.toString()) ;
        }
        });*/