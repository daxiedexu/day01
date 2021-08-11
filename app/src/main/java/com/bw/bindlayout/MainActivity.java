package com.bw.bindlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bw.bindlayout.databinding.ActivityMainBinding;
import com.bw.bindlayout.entity.Boy;
import com.bw.bindlayout.entity.UserBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView actMainRecycler;
    private ActivityMainBinding dataBinding;
    private UserBean userBean;
    private Boy boy;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        List<UserBean> userBeans = new ArrayList<>();
        userBeans.add(new UserBean("zhang","123456"));
        userBeans.add(new UserBean("zhang","123456"));
        userBeans.add(new UserBean("zhang","123456"));
        userBeans.add(new UserBean("zhang","123456"));
        userBeans.add(new UserBean("zhang","123456"));
        actMainRecycler = (RecyclerView) findViewById(R.id.act_main_recycler);
        actMainRecycler.setAdapter(new ListAdapter(userBeans));
        actMainRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        dataBinding.setUsername("hello word!");
        dataBinding.setNumber(1024);
        dataBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "哎呦不错哦~", Toast.LENGTH_SHORT).show();
            }
        });
        //设置用户实体类数据
        userBean = new UserBean();
        dataBinding.setUserBean(userBean);
        userBean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.name){
                    Log.i(TAG, "onPropertyChanged: 监听到username属性发生变化");
                }else if (propertyId == BR.password){
                    Log.i(TAG, "onPropertyChanged: 监听到password属性发生变化");
                }
            }
        });
        //设置男生实体类数据
        boy = new Boy();
        dataBinding.setBoyBean(boy);
        boy.name.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.i(TAG, "onPropertyChanged: 监听到Boy.name属性发生变化");
            }
        });
        //Map使用
        ObservableMap<String,Object> map = new ObservableArrayMap<>();
        map.put("name","java");
        dataBinding.setMap(map);
        //List
        ObservableList<String> list = new ObservableArrayList<>();
        list.add("zhang");
        list.add("hai");
        list.add("xu");
        dataBinding.setList(list);
    }
}