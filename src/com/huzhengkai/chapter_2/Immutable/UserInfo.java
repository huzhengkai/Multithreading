package com.huzhengkai.chapter_2.Immutable;

/**
 * Created by root on 2017/12/14.
 */
public class UserInfo
{
    private final StringBuffer info;
    public UserInfo(String name,String address)
    {
        this.info = new StringBuffer("<info name=\""+name+"\"address=\""+address+"\"/>");
    }
    public StringBuffer getInfo()
    {
        return info;
    }
    @Override
    public String toString()
    {
        return "UserInfo{" +
                "info=" + info +
                '}';
    }
}
