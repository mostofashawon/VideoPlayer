package com.example.videoplayer.adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.telephony.mbms.DownloadRequest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.videoplayer.R;
import com.example.videoplayer.model.GET;
import com.example.videoplayer.view.ContentList;

import java.util.List;
import java.util.jar.Manifest;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<GET> list;
    private MediaController mediaController;
    private DownloadManager downloadManager;

    public Adapter(Context context, List<GET> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dummy,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final GET get = list.get(position);
        holder.textView.setText(get.getTitle());
        holder.videoView.setVideoURI(Uri.parse(get.getContentpath()));
        mediaController = new MediaController(context);


        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.videoView.setMediaController(mediaController);
                mediaController.setAnchorView(holder.videoView);
                holder.videoView.start();
            }
        });

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                    downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(get.getContentpath()));
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

            }

        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private Button button,button2;
        private VideoView videoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
            button = itemView.findViewById(R.id.Buttonid);
            button2 = itemView.findViewById(R.id.Button2);
            videoView = itemView.findViewById(R.id.videoid);
        }
    }
}
