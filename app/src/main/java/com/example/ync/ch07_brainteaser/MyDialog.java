package com.example.ync.ch07_brainteaser;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by YNC on 2017/5/17.
 */

public class MyDialog extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //为了样式统一和兼容性，可以使用 V7 包下的 AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // 设置主题的构造方法
        // AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomDialog);
        builder.setTitle("Welcome!")
                .setMessage("Let's play!")
                .setPositiveButton("Puzzle time!", null)
                .setNegativeButton("Close this app", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                })
                .setCancelable(false);
        //builder.show(); // 不能在这里使用 show() 方法
        return builder.create();
    }

}
