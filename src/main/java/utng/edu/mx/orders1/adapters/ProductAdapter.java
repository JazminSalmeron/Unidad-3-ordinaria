package utng.edu.mx.orders1.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.List;

import utng.edu.mx.orders1.R;
import utng.edu.mx.orders1.model.Product;

/**
 * Created by Danie on 2/23/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter <ProductAdapter.ProductViewHolder>
        implements View.OnClickListener {

    List<Product> products;
    View.OnClickListener listener;
    //Constructor
    public ProductAdapter(List<Product> products){
        this.products=products;
    }
    //getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //se inflael cardview al reciclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ProductViewHolder holder=new ProductViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ProductViewHolder holder, int position) {
        holder.tvProductName.setText(products.get(position).getName());
        holder.tvProductPrice.setText(String.valueOf(products.get(position).getPrice()));
        holder.tvProductStock.setText(String.valueOf(products.get(position).getStock()));
        holder.iv_Product.setImageResource(R.mipmap.ic_launcher);
        holder.setListener(this);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public static class ProductViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cvProduct;
        TextView tvProductName;
        TextView tvProductPrice;
        TextView tvProductStock;
        ImageView iv_Product;
        ImageButton btEditProduct;
        ImageButton btDeleteProduct;
        View.OnClickListener listener;




        public ProductViewHolder(View itemView) {
            super(itemView);
            cvProduct=(CardView)itemView.findViewById(R.id.cv_product);
            iv_Product=(ImageView)itemView.findViewById(R.id.iv_product);
            tvProductName=(TextView)itemView.findViewById(R.id.tv_product_name);
            tvProductPrice=(TextView)itemView.findViewById(R.id.tv_product_price);
            tvProductStock=(TextView)itemView.findViewById(R.id.tv_product_stock);
            btEditProduct=(ImageButton) itemView.findViewById(R.id.bt_edit_product);
            btDeleteProduct=(ImageButton) itemView.findViewById(R.id.bt_delete_product);
            btEditProduct.setOnClickListener(this);
            btDeleteProduct.setOnClickListener(this);


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
