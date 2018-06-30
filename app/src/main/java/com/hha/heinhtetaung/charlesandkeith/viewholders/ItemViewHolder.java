package com.hha.heinhtetaung.charlesandkeith.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.charlesandkeith.R;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.delegate.ItemDelegate;

import butterknife.BindView;

/**
 * Created by E5 on 6/28/2018.
 */

public class ItemViewHolder extends BaseViewHolder<NewProductVO> {

    @BindView(R.id.iv_item)
    ImageView ivItem;

    @BindView(R.id.tv_item_name_detail)
    TextView tvItemName;

    private ItemDelegate mItemDelegate;
    private NewProductVO mNewProductVO;

    public ItemViewHolder(View itemView, ItemDelegate itemDelegate) {
        super(itemView);
        mItemDelegate = itemDelegate;
    }

    @Override
    public void onClick(View view) {
        mItemDelegate.onTapItem();
    }

    @Override
    public void setData(NewProductVO data) {
        mNewProductVO = data;

        if (data.getProductImage() != null) {
            Glide.with(ivItem.getContext())
                    .load(data.getProductImage())
                    .into(ivItem);
        }

        tvItemName.setText(data.getProductTitle());

    }
}
