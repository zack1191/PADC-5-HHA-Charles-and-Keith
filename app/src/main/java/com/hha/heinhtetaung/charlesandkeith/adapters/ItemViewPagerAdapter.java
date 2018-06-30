package com.hha.heinhtetaung.charlesandkeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.charlesandkeith.R;
import com.hha.heinhtetaung.charlesandkeith.data.model.ProductModel;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by E5 on 6/28/2018.
 */

public class ItemViewPagerAdapter extends PagerAdapter {

    @BindView(R.id.tv_item_name_view)
    TextView tvItemName;

    @BindView(R.id.iv_item_detail_view)
    ImageView ivItem;

    private LayoutInflater mLayoutInflater;
    private List<NewProductVO> mProductVOS;
    private NewProductVO mProduct;


    public ItemViewPagerAdapter(Context context) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        mProductVOS = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mProductVOS.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_detail_images, container, false);
        container.addView(itemView);
        ButterKnife.bind(this, itemView);

        tvItemName.setText(mProductVOS.get(position).getProductTitle());
        Glide.with(ivItem.getContext())
                .load(mProductVOS.get(position).getProductImage())
                .into(ivItem);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    public void setNewVPList(List<NewProductVO> newProductVOS) {
        this.mProductVOS = newProductVOS;
        notifyDataSetChanged();
    }

}
