package com.example.belajar;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImplementasiSQLite extends AppCompatActivity {

    ListView listView1;
    String[] daftar;

    protected Cursor cursor;
    DataHelper dbcenter;
    public static ImplementasiSQLite ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implementasi_sqlite);

        Button btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent inte = new Intent(ImplementasiSQLite.this, BuatBiodata.class);
                startActivity(inte);
            }
        });

        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata", null);
        daftar = new String[cursor.getCount()];

        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();

            listView1 = (ListView) findViewById(R.id.listView1);

            listView1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));

            listView1.setSelected(true);

            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                    final String selection = daftar[i];
                    final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata",
                            "Hapus Biodata"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(ImplementasiSQLite.this);
                    builder.setTitle("Pilihan");
                    builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i) {
                                case 0:
                                    Intent j = new Intent(getApplicationContext(),
                                            LihatBiodata.class);
                                    j.putExtra("nama", selection);
                                    startActivity(j);
                                    break;
                                case 1:
                                    Intent jn = new Intent(getApplicationContext(),
                                            UpdateBiodata.class);
                                    jn.putExtra("nama", selection);
                                    startActivity(jn);
                                    break;
                                case 2:
                                    SQLiteDatabase db = dbcenter.getWritableDatabase();
                                    db.execSQL("delete from biodata where nama = '" + selection + "'");
                                    RefreshList();
                                    break;
                            }
                        }
                    });
                    builder.create().show();
                }
            });
        }
        ((ArrayAdapter) listView1.getAdapter()).notifyDataSetChanged();
    }
}