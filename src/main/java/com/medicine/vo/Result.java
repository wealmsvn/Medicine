package com.medicine.vo;

import lombok.Data;

@Data
public class Result<T> {
<<<<<<< HEAD
    private int code;
    private  T entity;

    public static  Result success(Object entity){
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setEntity(entity);
        return result;
    }
=======
   private int code;
   private T  entity;

   public static  Result<Object> success(Object entity){
       Result<Object> result = new Result<>();
       result.setCode(200);
       result.setEntity(entity);
       return result;
   }
>>>>>>> github/master

    public static  Result<Object> error(Object entity){
        Result<Object> result = new Result<>();
        result.setCode(400);
<<<<<<< HEAD
        result.setEntity(entity);
=======
        result.setEntity(null);
>>>>>>> github/master
        return result;
    }

}
<<<<<<< HEAD

=======
>>>>>>> github/master
