package com.example.prate.mypractiserecyclerview;

import retrofit2.Call;
import retrofit2.http.GET;

public interface courseapi {
    @GET("courses")
 Call<CourseResponse> getcoursename();


}
