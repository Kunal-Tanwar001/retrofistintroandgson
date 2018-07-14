package com.example.prate.mypractiserecyclerview;

public class CourseResponse {
    String message;
    int status;
    String update;
   private CourseArrayList data;

   public CourseResponse(int status,String update,CourseArrayList data){
       this.status=status;
       this.update=update;
       this.data=data;
   }
public CourseArrayList getData(){
       return data;

}

}
