package utng.edu.mx.orders1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import utng.edu.mx.orders1.adapters.ProductAdapter;
import utng.edu.mx.orders1.adapters.QuoteAdapter;
import utng.edu.mx.orders1.model.Quote;
import utng.edu.mx.orders1.sqlite.DBOperations;

/**
 * Created by danie on 23/02/2017.
 */

public class QuoteActivity extends AppCompatActivity {
    private EditText etText;
    private EditText etMeaning;
    private Button btSaveQuote;
    private DBOperations operations;
    private Quote quote = new Quote();
    private RecyclerView rvQuotes;
    private List<Quote> quotes=new ArrayList<Quote>();
    private QuoteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        //iniciacion de la isntancia
        operations=DBOperations.getDBOperations(getApplicationContext());
        quote.setIdQuote("");


        initComponents();
    }
    private void initComponents(){
        rvQuotes=(RecyclerView)findViewById(R.id.rv_quote_list);
        rvQuotes.setHasFixedSize(true);
        LinearLayoutManager layoutManeger=new LinearLayoutManager(this);
        rvQuotes.setLayoutManager(layoutManeger);
        //
        getQuotes();
        adapter=new QuoteAdapter(quotes);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_delete_quote:
                        operations.deleteQuote(quotes.get(rvQuotes.getChildPosition((View)v.getParent().getParent())).getIdQuote());
                        getQuotes();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.bt_edit_quote:


                        Cursor c = operations.getQuoteById(quotes.get(
                                rvQuotes.getChildPosition(
                                        (View)v.getParent().getParent())).getIdQuote());
                        if (c!=null){
                            if (c.moveToFirst()){
                                quote = new Quote(c.getString(1),c.getString(2),c.getString(3));
                            }
                            etText.setText(quote.getText());
                            etMeaning.setText(String.valueOf(quote.getMeaning()));

                        }else{
                            Toast.makeText(getApplicationContext(),"Registro no encontrado",Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        });
        rvQuotes.setAdapter(adapter);

        etText=(EditText)findViewById(R.id.et_text);
        etMeaning=(EditText)findViewById(R.id.et_meaning);


        btSaveQuote=(Button)findViewById(R.id.bt_save_quote);

        btSaveQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!quote.getIdQuote().equals("")){
                    quote.setText(etText.getText().toString());
                    quote.setMeaning(etMeaning.getText().toString());
                    operations.updateQuote(quote);

                }else {
                    quote = new Quote("", etText.getText().toString(), etMeaning.getText().toString());
                    operations.insertQuote(quote);
                }
                getQuotes();
                clearData();
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void getQuotes(){
        Cursor c =operations.getQuotes();
        quotes.clear();
        if(c!=null){
            while (c.moveToNext()){
                quotes.add(new Quote(c.getString(1),c.getString(2),c.getString(3)));
            }
        }

    }

    private void clearData(){
        etText.setText("");
        etMeaning.setText("");
        quote=null;
        quote= new Quote();
        quote.setIdQuote("");
    }
}
