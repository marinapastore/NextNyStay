package com.marinapcintra.nystay.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.marinapcintra.nystay.R;
import com.marinapcintra.nystay.adapter.HotelAdapter;
import com.marinapcintra.nystay.database.AppDatabase;
import com.marinapcintra.nystay.database.entity.Hotel;
import com.marinapcintra.nystay.models.ClientChoicesModel;
import com.marinapcintra.nystay.service.HotelService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String HOTEL_DATABASE_CREATED = "is_database_created";
    public static final String IS_DATABASE_CREATED_CORRECTLY = "is_database_created_correctly";

    private AppDatabase mAppDatabase;
    private List<Hotel> mListHotel;

    private CheckBox coffeeCheckbox;
    private CheckBox museumCheckbox;
    private CheckBox barsCheckbox;
    private CheckBox landmarksCheckbox;
    private CheckBox foodCheckbox;
    private TextInputEditText priceInputText;
    private RatingBar rating;
    private CheckBox bronxCheckbox;
    private CheckBox brooklynCheckbox;
    private CheckBox manhatthanCheckbox;

    private ClientChoicesModel clientChoicesModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pegando instância do banco de dados
        mAppDatabase = AppDatabase.getAppDatabase(this);

        coffeeCheckbox = findViewById(R.id.coffee_checkBox);
        museumCheckbox = findViewById(R.id.museum_checkBox);
        barsCheckbox = findViewById(R.id.museum_checkBox);
        landmarksCheckbox = findViewById(R.id.landscapes_checkBox);
        foodCheckbox = findViewById(R.id.food_checkBox);
        priceInputText = findViewById(R.id.test);
        rating = findViewById(R.id.ratingBar);
        rating.getNumStars();
        bronxCheckbox = findViewById(R.id.bronx_checkBox);
        brooklynCheckbox = findViewById(R.id.brooklyn_checkBox);
        manhatthanCheckbox = findViewById(R.id.manhathan_checkBox);



        priceInputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getId() == priceInputText.getId())
                {
                    priceInputText.setCursorVisible(true);
                }
            }
        });

        //TODO: na primeira execução, é preciso ler o arquivo csv e salvar as informações no banco
        //de dados.
        //verificando se o banco de dados com os barrios e parques já foi criado
        SharedPreferences sharedPreferences = getSharedPreferences(HOTEL_DATABASE_CREATED, MODE_PRIVATE);
        boolean isDatabaseCreated = sharedPreferences.getBoolean(IS_DATABASE_CREATED_CORRECTLY, false);


        if (!isDatabaseCreated) {
            HotelService hotelService = new HotelService(this,sharedPreferences);
            hotelService.createDatabaseTable();
        }

        //TODO: ler dados da tabela bairro e passá-los para o Adapter populando a listview
        mListHotel = mAppDatabase.hotelDao().getAll();

        for(int i = 0; i<10 ; i++){
            Log.d("HOTEL_LIST",mListHotel.get(i).getHotel_name());
        }


    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }


    public void implicitCall(View view){
        Intent intent = new Intent(this, ImplicityActivity.class);


        clientChoicesModel = new ClientChoicesModel(coffeeCheckbox.isChecked(),museumCheckbox.isChecked(),foodCheckbox.isChecked(),
                                                    barsCheckbox.isChecked(),landmarksCheckbox.isChecked(),Double.parseDouble(priceInputText.getText().toString()),
                                                    rating.getRating(),bronxCheckbox.isChecked(),brooklynCheckbox.isChecked(),manhatthanCheckbox.isChecked());
        intent.putExtra("clientChoicesModel", clientChoicesModel);
        startActivity(intent);
    }
}
