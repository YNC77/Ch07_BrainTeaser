package com.example.ync.ch07_brainteaser;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar; // Android 5.x
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
            implements AdapterView.OnItemClickListener {
    //questions
    String[] questArr = {"1. A is the father of B. But B is not the son of A. How’s that possible? ", "2. What goes up and down, but still remains in the same place?"};
    //answers
    String[] ansArr = {"B is the daughter","Stairs! "};

    //Toast-immediately show part1
    Toast ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayAdapter setting
        ArrayAdapter<String> temp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, questArr);
        ListView lv = (ListView) findViewById(R.id.lvQ);
        //connect ListView and temp-questArr
        lv.setAdapter(temp);
        lv.setOnItemClickListener(this);

        //Toast-immediately show part2
        ans = Toast.makeText(this,"",Toast.LENGTH_SHORT);


        //AlertDialog Type1-outer class
        DialogFragment newFragment = new MyDialog();
        newFragment.show(getSupportFragmentManager(), "missiles");

        //AlertDialog Type2-inner class
        //DialogFragment newFragment2 = new md();
        //newFragment2.show(getSupportFragmentManager(), "missiles");

        //AlertDialog Type3
        /*AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        //bdr.setTitle("Welcome!");
        bdr.setMessage("Let's play!");
        bdr.setIcon(android.R.drawable.presence_away);
        //AlertDialog-Button, set Listener
        bdr.setPositiveButton("Puzzle time!", null);
        bdr.setNegativeButton("Close this app", null);
        bdr.show();*/

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast-normal
        //Toast.makeText(this,ansArr[position],Toast.LENGTH_SHORT).show();

        //Toast-immediately show part3
        ans.setText("Answer:"+ansArr[position]);
        ans.show();

        //Snackbar
        //Snackbar.make(findViewById(R.id.layout), ansArr[position],Snackbar.LENGTH_SHORT).show();

    }

   /* AlertDialog Type2-inner class
   public static class md extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            //为了样式统一和兼容性，可以使用 V7 包下的 AlertDialog.Builder
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // 设置主题的构造方法
            // AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomDialog);
            builder.setTitle("注意：")
                    .setMessage("是否退出应用？")
                    .setPositiveButton("确定", null)
                    .setNegativeButton("取消", null)
                    .setCancelable(false);
            //builder.show(); // 不能在这里使用 show() 方法
            return builder.create();
        }
    }*/
}

