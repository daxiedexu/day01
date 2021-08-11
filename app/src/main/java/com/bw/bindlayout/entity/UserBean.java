package com.bw.bindlayout.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.bw.bindlayout.BR;

/**
 * @ClassName UserBean
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/10 20:15
 * @Version 1.0
 * Created 单向绑定数据并监听set方法
 * User: 张海旭
 */

public class UserBean extends BaseObservable {
    private String name;
    private String password;

    public UserBean() {
    }

    public UserBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
