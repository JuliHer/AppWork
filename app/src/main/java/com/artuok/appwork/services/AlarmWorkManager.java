package com.artuok.appwork.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmWorkManager extends BroadcastReceiver {
    public static final String ACTION_NOTIFY = "NOTIFY";
    public static final String ACTION_TIME_TO_DO_HOMEWORK = "HOMEWORK";
    public static final String ACTION_POSTPONE = "POSTPONE";
    public static final String ACTION_DISMISS = "DISMISS";
    public static final String ACTION_EVENT = "EVENT";
    public static final String ACTION_TOMORROW_EVENTS = "TEVENTS";
    public static final String ACTION_TOMORROW_SUBJECTS = "TSUBJECTS";

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, NotificationService.class);
        if (intent.getAction() != null) {
            switch (intent.getAction()) {
                case ACTION_NOTIFY:
                    intent1.setAction(ACTION_NOTIFY);
                    intent1.putExtra("title", intent.getStringExtra("title"));
                    intent1.putExtra("desc", intent.getStringExtra("desc"));

                    context.startForegroundService(intent1);
                    break;
                case ACTION_TIME_TO_DO_HOMEWORK:
                    intent1.setAction(ACTION_TIME_TO_DO_HOMEWORK);
                    intent1.putExtra("time", intent.getLongExtra("time", 0));
                    intent1.putExtra("alarm", intent.getIntExtra("alarm", 0));
                    context.startForegroundService(intent1);
                    break;
                case ACTION_DISMISS:
                    intent1.setAction(ACTION_DISMISS);
                    context.startForegroundService(intent1);
                    break;
                case ACTION_POSTPONE:
                    intent1.setAction(ACTION_POSTPONE);
                    intent1.putExtra("time", intent.getLongExtra("time", 0));
                    intent1.putExtra("alarm", 1);
                    context.startForegroundService(intent1);
                    break;
                case ACTION_EVENT:
                    intent1.setAction(ACTION_EVENT);
                    intent1.putExtra("name", intent.getStringExtra("name"));
                    intent1.putExtra("time", intent.getLongExtra("time", 0));
                    intent1.putExtra("duration", intent.getLongExtra("duration", 0));
                    context.startForegroundService(intent1);
                    break;
                case ACTION_TOMORROW_EVENTS:
                    intent1.setAction(ACTION_TOMORROW_EVENTS);
                    context.startForegroundService(intent1);
                    break;
                case ACTION_TOMORROW_SUBJECTS:
                    intent1.setAction(ACTION_TOMORROW_SUBJECTS);
                    context.startForegroundService(intent1);
                    break;
            }
        }
    }
}
