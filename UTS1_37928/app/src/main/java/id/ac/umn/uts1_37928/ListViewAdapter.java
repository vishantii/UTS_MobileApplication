package id.ac.umn.uts1_37928;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.SumberList> {
    private LinkedList<SFX> mDaftarSFX;
    private LayoutInflater mInflater;
    private Context mContext;

    public ListViewAdapter(Context context, LinkedList<SFX> daftarSound){
        this.mDaftarSFX = daftarSound;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SumberList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listview, parent, false);
        return new SumberList(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SumberList holder, @SuppressLint("RecyclerView") int position) {
        SFX mSumberSound = mDaftarSFX.get(position);
        holder.titleSound.setText(mSumberSound.getTitle());
        holder.keteranganSound.setText(mSumberSound.getKeterangan());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDaftarSFX.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDaftarSFX.size();
    }

    public class SumberList extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imgSound;
        private TextView titleSound, keteranganSound;
        private Button btnDelete;
        private SFX mSumberSound;
        private int mPosisi;
        private ListViewAdapter mAdapter;;

        public SumberList(@NonNull View itemView, ListViewAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            imgSound =(ImageView) itemView.findViewById(R.id.imgSound);
            titleSound = (TextView) itemView.findViewById(R.id.titleSound);
            keteranganSound = (TextView) itemView.findViewById(R.id.keteranganSound);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mPosisi = getLayoutPosition();
            mSumberSound = mDaftarSFX.get(mPosisi);
            Intent detailIntent = new Intent(mContext, DetailList.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("SoundDetail", mSumberSound);
            detailIntent.putExtras(bundle);
            String namaSound = titleSound.getText().toString();
            detailIntent.putExtra("NamaSound", namaSound);
            mContext.startActivity(detailIntent);
        }
    }
}
