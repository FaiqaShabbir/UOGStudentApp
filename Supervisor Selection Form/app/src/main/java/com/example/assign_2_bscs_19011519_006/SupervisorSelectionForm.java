package com.example.assign_2_bscs_19011519_006;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SupervisorSelectionForm extends AppCompatActivity {

    EditText Sname, Fname, RegNo, Synop1, Summ1, Sign1, Synop2,
    Summ2, Sign2, Synop3, Summ3, Sign3;

    Button insert, update, delete, view, edit;
    DBHelper2 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_selection_form);

        Sname = findViewById(R.id.edt_name);
        Fname = findViewById(R.id.edt_Fname);
        RegNo = findViewById(R.id.edt_reg);
        Synop1 = findViewById(R.id.edt_synop1);
        Summ1 = findViewById(R.id.edt_sum1);
        Sign1 = findViewById(R.id.edt_sign1);
        Synop2 = findViewById(R.id.edt_synop2);
        Summ2 = findViewById(R.id.edt_sum2);
        Sign2 = findViewById(R.id.edt_sign2);
        Synop3 = findViewById(R.id.edt_synop3);
        Summ3 = findViewById(R.id.edt_sum2);
        Sign3 = findViewById(R.id.edt_sign3);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btn_update);
        delete = findViewById(R.id.btn_del);
        view = findViewById(R.id.btn_view);
        edit = findViewById(R.id.btn_edit1);

        DB = new DBHelper2(this);

            }

    public void onClickInsert(View view) {
        String Stname = Sname.getText().toString();
        String Faname = Fname.getText().toString();
        String RegisNo = RegNo.getText().toString();
        String Synope1 = Synop1.getText().toString();
        String summ1 = Summ1.getText().toString();
        String sign1 = Sign1.getText().toString();
        String synop2 = Synop2.getText().toString();
        String summ2 = Summ2.getText().toString();
        String sign2 = Sign2.getText().toString();
        String synop3 = Synop3.getText().toString();
        String summ3 = Summ3.getText().toString();
        String sign3 = Sign3.getText().toString();

        Boolean checkInsertData = DB.insertUserData(Stname, Faname, RegisNo, Synope1,
                summ1, sign1, synop2, summ2, sign2, synop3, summ3, sign3);
        if (checkInsertData == true){
            Toast.makeText(SupervisorSelectionForm.this, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(SupervisorSelectionForm.this, "Data Not Inserted!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickDelete(View view) {
        String Stname = Sname.getText().toString();
        Boolean checkDeleteData = DB.deleteUserData(Stname);
        if (checkDeleteData == true){
            Toast.makeText(SupervisorSelectionForm.this, "Data Deleted Successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(SupervisorSelectionForm.this, "Unable to delete data!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickView(View view) {
        Cursor cursor = DB.viewUserData();
        if (cursor.getCount() == 0){
            Toast.makeText(SupervisorSelectionForm.this, "No Data Exists!", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()){
            buffer.append("Student Name :" + cursor.getString(0)+"\n");
            buffer.append("Father Name :" + cursor.getString(1)+"\n");
            buffer.append("Registration No :" + cursor.getString(2)+"\n");
            buffer.append("Research Topic 1 :" + cursor.getString(3)+"\n");
            buffer.append("Summary 1 :" + cursor.getString(4)+"\n");
            buffer.append("First Supervisor Signature :" + cursor.getString(5)+"\n");
            buffer.append("Research Topic 2 :" + cursor.getString(6)+"\n");
            buffer.append("Summary 2 :" + cursor.getString(7)+"\n");
            buffer.append("Second Supervisor Signature :" + cursor.getString(8)+"\n");
            buffer.append("Research Topic 3 :" + cursor.getString(9)+"\n");
            buffer.append("Summary 3 :" + cursor.getString(10)+"\n");
            buffer.append("Third Supervisor Signature :" + cursor.getString(11)+"\n\n\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(SupervisorSelectionForm.this);
        builder.setCancelable(true);
        builder.setTitle("Supervisor Selection Form");
        builder.setMessage(buffer.toString());
        builder.show();

    }

    public void onClickUpdate(View view) {
        String Stname = Sname.getText().toString();
        String Faname = Fname.getText().toString();
        String RegisNo = RegNo.getText().toString();
        String Synope1 = Synop1.getText().toString();
        String summ1 = Summ1.getText().toString();
        String sign1 = Sign1.getText().toString();
        String synop2 = Synop2.getText().toString();
        String summ2 = Summ2.getText().toString();
        String sign2 = Sign2.getText().toString();
        String synop3 = Synop3.getText().toString();
        String summ3 = Summ3.getText().toString();
        String sign3 = Sign3.getText().toString();

        Boolean checkUpdateData = DB.updateUserData(Stname, Faname, RegisNo, Synope1,
                summ1, sign1, synop2, summ2, sign2, synop3, summ3, sign3);
        if (checkUpdateData == true){
            Toast.makeText(SupervisorSelectionForm.this, "Data Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(SupervisorSelectionForm.this, "Unable to update data!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickFetchData(View view) {
        startActivity(new Intent(getApplicationContext(), FetchData.class));
    }
}