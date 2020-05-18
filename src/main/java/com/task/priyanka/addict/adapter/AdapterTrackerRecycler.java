package com.task.priyanka.addict.adapter;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.task.priyanka.addict.R;
import com.task.priyanka.addict.activity.TrackerActivity;
import com.task.priyanka.addict.dialog.DialogLimitWarning;
import com.task.priyanka.addict.utils.DataProcessor;
import com.task.priyanka.addict.utils.SharedPrefController;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class AdapterTrackerRecycler extends Adapter<AdapterTrackerRecycler.MyViewHolder> {
    private Context context;
    private String[] mData;

    private String t1, t2, t3, t4, t5, t6;
    private int cc1, cc2, cc3, cc4, cc5, cc6 = 0;

    public AdapterTrackerRecycler(Context context, String[] i) {
        this.context = context;
        this.mData = i;
    }

    @NonNull
    @Override
    public AdapterTrackerRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tracker, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterTrackerRecycler.MyViewHolder holder, final int position) {

        holder.tv_addiction.setText(mData[position]);

        getAllTargets();

        if (position == 0) {
            if (t1 != null) {
                holder.tv_target.setText(context.getResources().getString(R.string.target_counter) + t1);
            } else {
                holder.tv_target.setText(context.getResources().getString(R.string.target_zero));
            }
        } else if (position == 1) {
            if (t2 != null) {
                holder.tv_target.setText(context.getResources().getString(R.string.target_counter) + t2);
            } else {
                holder.tv_target.setText(context.getResources().getString(R.string.target_zero));
            }

        } else if (position == 2) {
            if (t3 != null) {
                holder.tv_target.setText(context.getResources().getString(R.string.target_counter) + t3);
            } else {
                holder.tv_target.setText(context.getResources().getString(R.string.target_zero));
            }
        } else if (position == 3) {
            if (t4 != null) {
                holder.tv_target.setText(context.getResources().getString(R.string.target_counter) + t4);
            } else {
                holder.tv_target.setText(context.getResources().getString(R.string.target_zero));
            }
        } else if (position == 4) {
            if (t5 != null) {
                holder.tv_target.setText(context.getResources().getString(R.string.target_counter) + t5);
            } else {
                holder.tv_target.setText(context.getResources().getString(R.string.target_zero));
            }
        } else if (position == 5) {
            if (t6 != null) {
                holder.tv_target.setText(context.getResources().getString(R.string.target_counter) + t6);
            } else {
                holder.tv_target.setText(context.getResources().getString(R.string.target_zero));
            }
        }


        holder.tv_current.setText(context.getResources().getString(R.string.current_zero));


        holder.tv_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    if (t1 != null) {
                        cc1 = cc1 + 1;
                        if (cc1 > 0) {
                            DataProcessor dataProccessor = new DataProcessor(context);
                            dataProccessor.setInt(position + "key", cc1);
                            int idName = dataProccessor.getInt(position + "key");
                            holder.tv_current.setText(context.getResources().getString(R.string.current_count) + idName);

                            if (t1.equals("" + idName)) {
                                showDialogWarning();
                                showNotification();
                            }
                        }
                    } else {
                        Toast.makeText(context, context.getResources().getString(R.string.set_target), Toast.LENGTH_SHORT).show();
                    }

                } else if (position == 1) {
                    if (t2 != null) {
                        cc2 = cc2 + 1;
                        if (cc2 > 0) {
                            DataProcessor dataProccessor = new DataProcessor(context);
                            dataProccessor.setInt(position + "key", cc2);
                            int idName = dataProccessor.getInt(position + "key");
                            holder.tv_current.setText(context.getResources().getString(R.string.current_count) + idName);

                            if (t2.equals("" + idName)) {
                                showDialogWarning();
                                showNotification();
                            }
                        }
                    } else {
                        Toast.makeText(context, context.getResources().getString(R.string.set_target), Toast.LENGTH_SHORT).show();
                    }
                } else if (position == 2) {
                    if (t3 != null) {
                        cc3 = cc3 + 1;
                        if (cc3 > 0) {
                            DataProcessor dataProccessor = new DataProcessor(context);
                            dataProccessor.setInt(position + "key", cc3);
                            int idName = dataProccessor.getInt(position + "key");
                            holder.tv_current.setText(context.getResources().getString(R.string.current_count) + idName);

                            if (t3.equals("" + idName)) {
                                showDialogWarning();
                                showNotification();
                            }
                        }
                    } else {
                        Toast.makeText(context, context.getResources().getString(R.string.set_target), Toast.LENGTH_SHORT).show();
                    }
                } else if (position == 3) {
                    if (t4 != null) {
                        cc4 = cc4 + 1;
                        if (cc4 > 0) {
                            DataProcessor dataProccessor = new DataProcessor(context);
                            dataProccessor.setInt(position + "key", cc4);
                            int idName = dataProccessor.getInt(position + "key");
                            holder.tv_current.setText(context.getResources().getString(R.string.current_count) + idName);

                            if (t4.equals("" + idName)) {
                                showDialogWarning();
                                showNotification();
                            }
                        }
                    } else {
                        Toast.makeText(context, context.getResources().getString(R.string.set_target), Toast.LENGTH_SHORT).show();
                    }
                } else if (position == 4) {
                    if (t5 != null) {
                        cc5 = cc5 + 1;
                        if (cc5 > 0) {
                            DataProcessor dataProccessor = new DataProcessor(context);
                            dataProccessor.setInt(position + "key", cc5);
                            int idName = dataProccessor.getInt(position + "key");
                            holder.tv_current.setText(context.getResources().getString(R.string.current_count) + idName);

                            if (t5.equals("" + idName)) {
                                showDialogWarning();
                                showNotification();
                            }
                        }
                    } else {
                        Toast.makeText(context, context.getResources().getString(R.string.set_target), Toast.LENGTH_SHORT).show();
                    }
                } else if (position == 5) {
                    if (t6 != null) {
                        cc6 = cc6 + 1;
                        if (cc6 > 0) {
                            DataProcessor dataProccessor = new DataProcessor(context);
                            dataProccessor.setInt(position + "key", cc6);
                            int idName = dataProccessor.getInt(position + "key");
                            holder.tv_current.setText(context.getResources().getString(R.string.current_count) + idName);

                            if (t6.equals("" + idName)) {
                                showDialogWarning();
                                showNotification();
                            }
                        }
                    } else {
                        Toast.makeText(context, context.getResources().getString(R.string.set_target), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        DataProcessor dataProccessor = new DataProcessor(context);
        int idName = dataProccessor.getInt(position + "key");
        holder.tv_current.setText(context.getResources().getString(R.string.current_count) + idName);
    }

    private void showDialogWarning() {
        DialogLimitWarning dialogLimitWarning = new DialogLimitWarning(context);
        if (context != null && !((Activity) context).isFinishing()) {
            dialogLimitWarning.setCancelable(false);
            dialogLimitWarning.show();
        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_addiction, tv_current, tv_target;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_addiction = itemView.findViewById(R.id.tv_addiction);
            tv_current = itemView.findViewById(R.id.tv_current);
            tv_target = itemView.findViewById(R.id.tv_target);
        }
    }

    private void showNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_setting)
                        .setContentTitle(context.getString(R.string.warning))
                        .setContentText(context.getString(R.string.you_are_exceeding_your_limit));

        Intent notificationIntent = new Intent(context, TrackerActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(0, builder.build());
    }

    private void getAllTargets() {
        t1 = SharedPrefController.getSharedPreferencesController(context).getStringValue("One");
        t2 = SharedPrefController.getSharedPreferencesController(context).getStringValue("Two");
        t3 = SharedPrefController.getSharedPreferencesController(context).getStringValue("Three");
        t4 = SharedPrefController.getSharedPreferencesController(context).getStringValue("Four");
        t5 = SharedPrefController.getSharedPreferencesController(context).getStringValue("Five");
        t6 = SharedPrefController.getSharedPreferencesController(context).getStringValue("Six");
    }

}
