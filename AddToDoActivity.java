package com.example.todoapp_f22;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

public class AddToDoActivity extends AppCompatActivity {

    DatePicker picker;
    EditText taskText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        Switch switch1=(Switch) findViewById(R.id.switch1);
        switch1.setChecked(false);
        picker = findViewById(R.id.datapicker);
        taskText = findViewById(R.id.task_id);
    }


    public void save_task(View view) {
            String taskDate = picker.getDayOfMonth()+"/"+picker.getMonth()+"/"+picker.getYear();
            if (!taskText.getText().toString().isEmpty()){
                ToDo newTodo = new ToDo(taskText.getText().toString(), taskDate);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("newTodo",newTodo);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        }
}