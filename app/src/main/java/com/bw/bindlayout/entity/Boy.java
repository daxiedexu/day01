package com.bw.bindlayout.entity;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * @ClassName Boy
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/10 20:49
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class Boy {
    //自动创建get set方法
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
    public final ObservableInt sex = new ObservableInt();

    public Boy() {
    }

    public Boy(String name,int age,int sex) {
        this.name.set(name);
        this.age.set(age);
        this.sex.set(sex);
    }
}
