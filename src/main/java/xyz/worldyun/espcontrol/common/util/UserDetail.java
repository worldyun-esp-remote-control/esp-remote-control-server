package xyz.worldyun.espcontrol.common.util;


import xyz.worldyun.espcontrol.entity.User;

public class UserDetail {
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {
        //ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
        @Override
        protected Object initialValue() {
            return null;
        }
    };

    public static void setUserDetail(User user){
        UserDetail.threadLocal.set(user);
    }

    public static void removeUserDetail(){
        UserDetail.threadLocal.remove();
    }

    public static User getUserDetail(){
        return (User) UserDetail.threadLocal.get();
    }
}
