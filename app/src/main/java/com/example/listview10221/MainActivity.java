package com.example.listview10221;
//adapter概念:資料來源的處理,跟顯示畫面的清單元件是分開的
//mvc(model view control)view只是顯示資料,是adapter處理資料
//清單元件像容器
//adapter是橋梁(課本圖左是資料,透過adapter給右邊的view)
//或清單元件像飯店,data是客人,adapter是接待
//總之adapter是連接view或spinner的橋梁(例spinner是空的,塞資料給它)
//(adapter把資料傳給listview)
// 1去介面刪textview,設一個listview給id:lsitView,修margin20dp
//小補充:listview從上到下,GridView從左到右
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//2在全域設元件(清單)跟其變數名稱
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //這邊設findviewbyid
        list = findViewById(R.id.listView);

        //設string陣列(這邊或全域都可以
        String[] items = {"排骨飯","雞腿飯","咖哩飯","義大利麵","火鍋","巧克力奶茶","甜不辣"};

        // (陣列+處理資料之方法)類別+型別+變數名稱 = new 物件-陣列+資料處理,位置,樣式,字串
        ArrayAdapter<String> array = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
                  //資料類型   變數名稱                                要打android     後面simple選項才會出來    資料
                                                                                     //AdapterView
        //元件設定處理資料(處理資料變數名稱)
        list.setAdapter(array);

        //元件設監聽器(new 資料處理顯示+監聽
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //按下後顯示某某或顯示在textview上,或把資料傳給下個activity,就用setOnItemClickListener
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            //AdapterView  (list)view  現在點的項目的位置  項目的id

                //監聽後的資料(字串), +變數名稱, =(顯示(所選擇))方法(字串)
                String show = ((TextView) view).getText().toString();
                              //(36行)simple_list_item_1裡會包一個TextView
                              //(list)view要get textview要強制轉型別

//String selectedItem = parent.getItemAtPosition(position).toString();
//如果介面的listview換 GridView,然後顯示54行,就可以從左到右
//介面處右上找numColumns設定數字(顯式格式)
                //顯示之語法
                Toast.makeText(MainActivity.this, "您中午要吃" + show, Toast.LENGTH_LONG).show();
                                     //因已跳另funtion,故要+MainActivity

            }
        });
    }

    }