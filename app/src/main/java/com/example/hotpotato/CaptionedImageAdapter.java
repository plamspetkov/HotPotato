package com.example.hotpotato;

import android.net.sip.SipSession;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;

class CaptionedImageAdapter extends
        RecyclerView.Adapter<CaptionedImageAdapter.ViewHolder> {

    private String[] caption;
    private int[] imageIds;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Define the view to be used for each data item
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CaptionedImageAdapter(String[] caption, int[] imageIds) {
        this.caption = caption;
        this.imageIds = imageIds;
    }

    @Override
    public int getItemCount() {
        return caption.length;
    }

    //Method which will be used by the activities and the fragments to register as a listener
    public void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public CaptionedImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(caption[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(caption[position]);

        //Adding listener to the card view
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}
