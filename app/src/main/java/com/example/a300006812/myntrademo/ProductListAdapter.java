package com.example.a300006812.myntrademo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a300006812.myntrademo.model.SearchProduct;
import com.example.a300006812.myntrademo.model.SearchResults;

import java.util.List;


/**
 * Created by 300006812 on 7/19/17.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ItemViewHolder> {

    private  List<SearchProduct> products_list;

    public ProductListAdapter(List<SearchProduct> list) {
        products_list = list;
    }

    public void addData(List<SearchProduct> list) {
        products_list.addAll(list);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {

        holder.product_name_view.setText(products_list.get(position).styleName);
        Glide.with(holder.mIvProductImage.getContext())
                .load(products_list.get(position).searchImage)
                .into(holder.mIvProductImage);

        holder.itemView.findViewById(R.id.product_layout)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(holder.itemView.getContext(), ProductScreen.class);
                        intent.putExtra("NAME", products_list.get(position).styleName);
                        intent.putExtra("IMAGE", products_list.get(position).searchImage);
                        intent.putExtra("PRICE", products_list.get(position).price);
                        holder.itemView.getContext().startActivity(intent);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return products_list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView product_name_view;
        ImageView mIvProductImage;
        public ItemViewHolder(View itemView) {
            super(itemView);
            product_name_view = (TextView) itemView.findViewById(R.id.product_name);
            mIvProductImage = (ImageView) itemView.findViewById(R.id.product_thumb);
        }
    }
}
