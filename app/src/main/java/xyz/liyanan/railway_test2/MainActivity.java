package xyz.liyanan.railway_test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.railwayInfo);
        listView.setOnItemClickListener(this);
    }

    ArrayList<String> selected = new ArrayList<>();//用于存储选中的列车号

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position,long id){
        TextView textView = (TextView) view;//被选中的View对象被转成TextView对象
        String item = textView.getText().toString();//获取选中的文字
        if(selected.contains(item))
            selected.remove(item);//如果已有选中，则把它删除
        else
            selected.add(item);//如果没有同名选项则把它加入selected中

        String message;
        if (selected.size()>0){
            message="您选择了：";
            for (String string:selected)
                message += ""+string;
        }
        else
            message = "请选择车次！";

        TextView msgText = (TextView) findViewById(R.id.msgText);
        msgText.setText(message);
    }

}
