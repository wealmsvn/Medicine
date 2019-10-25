package com.medicine.vo;

import lombok.Data;

@Data
public class Result<T> {
   private int code;
   private T  entity;

   public static  Result<Object> success(Object entity){
       Result<Object> result = new Result<>();
       result.setCode(200);
       result.setEntity(entity);
       return result;
   }

    public static  Result<Object> error(Object entity){
        Result<Object> result = new Result<>();
        result.setCode(400);
        result.setEntity(null);
        return result;
    }

}
