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
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        String id = "1" ;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.course_text) ;
            imageButton = itemView.findViewById(R.id.course_delete_button) ;
            itemView.setOnClickListener(this);
            itemView.findViewById(R.id.course_delete_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(id, textView.getText().toString()) ;
                    /*Retrofit retrofit = new RetrofitService().getRetrofit() ;
                    final CoursesApi deleteCourseApi = retrofit.create(CoursesApi.class) ;
                    Call<Response> call = deleteCourseApi.dropCourse(id, textView.getText().toString()) ;
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
