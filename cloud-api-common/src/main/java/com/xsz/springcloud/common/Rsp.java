package com.xsz.springcloud.common;

import com.xsz.springcloud.entity.BaseResult;

public class Rsp {
    public static String REP_CODE="200";
    public static String REP_MSG="成功";
    public static String REP_DATA=null;

    public Rsp() {  }

    public static BaseResult succ(String msg, Object obj) {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage(msg);
        baseResult.setData(obj);
        baseResult.setCode(BaseResultCode.SUCCESS_CODE);
        return baseResult;
    }

    public static BaseResult succ(Object obj) {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage(BaseResultCode.SUCCESS_MESSAGE);
        baseResult.setData(obj);
        baseResult.setCode(BaseResultCode.SUCCESS_CODE);
        return baseResult;
    }

    public static BaseResult succ() {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage(BaseResultCode.SUCCESS_MESSAGE);
        baseResult.setData(null);
        baseResult.setCode(BaseResultCode.SUCCESS_CODE);
        return baseResult;
    }

    public static BaseResult err(String msg, Object obj) {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage(msg);
        baseResult.setData(obj);
        baseResult.setCode(BaseResultCode.ERR_CODE);
        return baseResult;
    }

    public static BaseResult err() {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage(BaseResultCode.ERR_MESSAGE);
        baseResult.setData(null);
        baseResult.setCode(BaseResultCode.ERR_CODE);
        return baseResult;
    }

    public static BaseResult fail(Object obj) {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage(BaseResultCode.FAIL_MESSAGE);
        baseResult.setData(obj);
        baseResult.setCode(BaseResultCode.FAIL_CODE);
        return baseResult;
    }

    public static BaseResult fail(String msg, Object obj) {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage(msg);
        baseResult.setData(obj);
        baseResult.setCode(BaseResultCode.FAIL_CODE);
        return baseResult;
    }

    public static BaseResult fail(String code, String msg, Object obj) {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage(msg);
        baseResult.setData(obj);
        baseResult.setCode(code);
        return baseResult;
    }

//    public static BaseResult loginAgain(String msg, Object obj) {  }
//
//    public static BaseResult authorityFail(String msg, Object obj) {  }

}
