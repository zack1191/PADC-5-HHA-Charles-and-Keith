package com.hha.heinhtetaung.charlesandkeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.charlesandkeith.R;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.delegate.ItemDelegate;
import com.hha.heinhtetaung.charlesandkeith.viewholders.ItemViewHolder;

/**
 * Created by E5 on 6/28/2018.
 */

public class ItemAdapter extends BaseRecyclerAdapter<ItemViewHolder, NewProductVO> {

    private ItemDelegate mItemDelegate;

    public ItemAdapter(Context context, ItemDelegate itemDelegate) {
        super(context);
        mItemDelegate = itemDelegate;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewShoe = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shoe, parent, false);
        return new ItemViewHolder(viewShoe, mItemDelegate);
    }

}
