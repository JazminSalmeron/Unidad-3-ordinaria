package utng.edu.mx.orders1.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import utng.edu.mx.orders1.R;
import utng.edu.mx.orders1.model.Quote;

/**
 * Created by danie on 23/02/2017.
 */

public class QuoteAdapter extends RecyclerView.Adapter <QuoteAdapter.QuoteViewHolder>
        implements View.OnClickListener {

    List<Quote> quotes;
    View.OnClickListener listener;
    //Constructor
    public QuoteAdapter(List<Quote> quotes){
        this.quotes=quotes;
    }
    //getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public QuoteAdapter.QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //se inflael cardview al reciclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_quote,parent,false);
        QuoteViewHolder holder=new QuoteViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(QuoteAdapter.QuoteViewHolder holder, int position) {
        holder.tvQuoteText.setText(quotes.get(position).getText());
        holder.tvQuoteMeaning.setText(quotes.get(position).getMeaning());
        holder.iv_Quote.setImageResource(R.mipmap.ic_launcher);
        holder.setListener(this);

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public static class QuoteViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cvQuote;
        TextView tvQuoteText;
        TextView tvQuoteMeaning;
        ImageView iv_Quote;
        ImageButton btEditQuote;
        ImageButton btDeleteQuote;
        View.OnClickListener listener;




        public QuoteViewHolder(View itemView) {
            super(itemView);
            cvQuote=(CardView)itemView.findViewById(R.id.cv_quote);
            iv_Quote=(ImageView)itemView.findViewById(R.id.iv_quote);
            tvQuoteText=(TextView)itemView.findViewById(R.id.tv_quote_text);
            tvQuoteMeaning=(TextView)itemView.findViewById(R.id.tv_quote_meaning);
            btEditQuote=(ImageButton) itemView.findViewById(R.id.bt_edit_quote);
            btDeleteQuote=(ImageButton) itemView.findViewById(R.id.bt_delete_quote);
            btEditQuote.setOnClickListener(this);
            btDeleteQuote.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.onClick(v);
            }
        }

        public void setListener(View.OnClickListener listener){
            this.listener=listener;

        }
    }

}
