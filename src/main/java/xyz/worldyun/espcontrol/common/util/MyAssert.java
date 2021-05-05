package xyz.worldyun.espcontrol.common.util;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import xyz.worldyun.espcontrol.common.base.ResultCodeEnum;
import xyz.worldyun.espcontrol.common.exception.MyException;

public class MyAssert extends Assert {

    public static void notNull(@Nullable Object object, ResultCodeEnum resultCodeEnum) {
        if (object == null) {
            throw new MyException(resultCodeEnum);
        }
    }

    public static void notNull(@Nullable Object object, String message) {
        if (object == null) {
            throw new MyException(message);
        }
    }

    public static void notNull(@Nullable Object object,Integer errorCode, String message) {
        if (object == null) {
            throw new MyException(errorCode, message);
        }
    }

    public static void isNull(@Nullable Object object, String message) {
        if (object != null) {
            throw new MyException(message);
        }
    }

    public static void isNull(@Nullable Object object, Integer errorCode, String message) {
        if (object != null) {
            throw new MyException(errorCode, message);
        }
    }

    public static void isNull(@Nullable Object object, ResultCodeEnum resultCodeEnum) {
        if (object != null) {
            throw new MyException(resultCodeEnum);
        }
    }
}
