package com.example.belajar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecycleView extends AppCompatActivity {

    private RecyclerView benuaRecyclerView;
    private ListView negaraListView;

    private HashMap<String, List<String>> benuaNegaraMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        benuaRecyclerView = findViewById(R.id.benuaRecyclerView);
        negaraListView = findViewById(R.id.negaraListView);

        // Initialize data
        benuaNegaraMap = new HashMap<>();

        // Asia
        benuaNegaraMap.put("Asia", new ArrayList<String>() {{
            add("Afghanistan");
            add("Armenia");
            add("Azerbaijan");
            add("Bahrain");
            add("Bangladesh");
            add("Bhutan");
            add("Brunei");
            add("Cambodia");
            add("China");
            add("Cyprus");
            add("Georgia");
            add("India");
            add("Indonesia");
            add("Iran");
            add("Iraq");
            add("Israel");
            add("Japan");
            add("Jordan");
            add("Kazakhstan");
            add("Kuwait");
            add("Kyrgyzstan");
            add("Laos");
            add("Lebanon");
            add("Malaysia");
            add("Maldives");
            add("Mongolia");
            add("Myanmar");
            add("Nepal");
            add("North Korea");
            add("Oman");
            add("Pakistan");
            add("Palestine");
            add("Philippines");
            add("Qatar");
            add("Saudi Arabia");
            add("Singapore");
            add("South Korea");
            add("Sri Lanka");
            add("Syria");
            add("Tajikistan");
            add("Thailand");
            add("Timor-Leste");
            add("Turkey");
            add("Turkmenistan");
            add("UAE");
            add("Uzbekistan");
            add("Vietnam");
            add("Yemen");
        }});

        // Afrika
        benuaNegaraMap.put("Afrika", new ArrayList<String>() {{
            add("Algeria");
            add("Angola");
            add("Benin");
            add("Botswana");
            add("Burkina Faso");
            add("Burundi");
            add("Cape Verde");
            add("Cameroon");
            add("Central African Republic");
            add("Chad");
            add("Comoros");
            add("Democratic Republic of the Congo");
            add("Djibouti");
            add("Egypt");
            add("Equatorial Guinea");
            add("Eritrea");
            add("Eswatini");
            add("Ethiopia");
            add("Gabon");
            add("Gambia");
            add("Ghana");
            add("Guinea");
            add("Guinea-Bissau");
            add("Ivory Coast");
            add("Kenya");
            add("Lesotho");
            add("Liberia");
            add("Libya");
            add("Madagascar");
            add("Malawi");
            add("Mali");
            add("Mauritania");
            add("Mauritius");
            add("Morocco");
            add("Mozambique");
            add("Namibia");
            add("Niger");
            add("Nigeria");
            add("Republic of the Congo");
            add("Rwanda");
            add("São Tomé and Príncipe");
            add("Senegal");
            add("Seychelles");
            add("Sierra Leone");
            add("Somalia");
            add("South Africa");
            add("South Sudan");
            add("Sudan");
            add("Tanzania");
            add("Togo");
            add("Tunisia");
            add("Uganda");
            add("Zambia");
            add("Zimbabwe");
        }});

        // Eropa
        benuaNegaraMap.put("Eropa", new ArrayList<String>() {{
            add("Albania");
            add("Andorra");
            add("Austria");
            add("Belarus");
            add("Belgium");
            add("Bosnia and Herzegovina");
            add("Bulgaria");
            add("Croatia");
            add("Cyprus");
            add("Czech Republic");
            add("Denmark");
            add("Estonia");
            add("Finland");
            add("France");
            add("Germany");
            add("Greece");
            add("Hungary");
            add("Iceland");
            add("Ireland");
            add("Italy");
            add("Kosovo");
            add("Latvia");
            add("Liechtenstein");
            add("Lithuania");
            add("Luxembourg");
            add("Malta");
            add("Moldova");
            add("Monaco");
            add("Montenegro");
            add("Netherlands");
            add("North Macedonia");
            add("Norway");
            add("Poland");
            add("Portugal");
            add("Romania");
            add("Russia");
            add("San Marino");
            add("Serbia");
            add("Slovakia");
            add("Slovenia");
            add("Spain");
            add("Sweden");
            add("Switzerland");
            add("Ukraine");
            add("United Kingdom");
            add("Vatican City");
        }});

        // Amerika Utara
        benuaNegaraMap.put("Amerika Utara", new ArrayList<String>() {{
            add("Antigua and Barbuda");
            add("Bahamas");
            add("Barbados");
            add("Belize");
            add("Canada");
            add("Costa Rica");
            add("Cuba");
            add("Dominica");
            add("Dominican Republic");
            add("El Salvador");
            add("Grenada");
            add("Guatemala");
            add("Haiti");
            add("Honduras");
            add("Jamaica");
            add("Mexico");
            add("Nicaragua");
            add("Panama");
            add("Saint Kitts and Nevis");
            add("Saint Lucia");
            add("Saint Vincent and the Grenadines");
            add("Trinidad and Tobago");
            add("United States");
        }});

        // Amerika Selatan
        benuaNegaraMap.put("Amerika Selatan", new ArrayList<String>() {{
            add("Argentina");
            add("Bolivia");
            add("Brazil");
            add("Chile");
            add("Colombia");
            add("Ecuador");
            add("Guyana");
            add("Paraguay");
            add("Peru");
            add("Suriname");
            add("Uruguay");
            add("Venezuela");
        }});


        List<String> benuaList = new ArrayList<>(benuaNegaraMap.keySet());

        // Set RecyclerView adapter for continents
        BenuaAdapter adapter = new BenuaAdapter(benuaList, new BenuaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String benua) {
                // When a continent is clicked, update the country list
                List<String> negaraList = benuaNegaraMap.get(benua);
                ArrayAdapter<String> negaraAdapter = new ArrayAdapter<>(RecycleView.this, android.R.layout.simple_list_item_1, negaraList);
                negaraListView.setAdapter(negaraAdapter);
            }
        });
        benuaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        benuaRecyclerView.setAdapter(adapter);
    }
}
