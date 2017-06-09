package com.klinker.android.twitter_l.utils;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.StringRes;

import com.klinker.android.twitter_l.R;

@TargetApi(Build.VERSION_CODES.O)
public class NotificationChannelUtil {

    private static final String INTERACTIONS_CHANNEL = "general-channel";
    private static final String BACKGROUND_REFRESH_CHANNEL = "general-channel";
    private static final String TWEETING_NOTIFICATION_CHANNEL = "tweeting-channel";
    private static final String FAILED_TWEETS_CHANNEL = "failed-tweets-channel";
    private static final String SENDING_SCHEDULED_MESSAGE_CHANNEL = "sending-scheduled-message-channel";
    private static final String MEDIA_DOWNLOAD_CHANNEL = "media-download-channel";
    private static final String WIDGET_REFRESH_CHANNEL = "widget-refresh-channel";

    public static void createNotificationChannels(Context context) {
        if (!Utils.isAndroidO()) {
            return;
        }

        createChannel(context, INTERACTIONS_CHANNEL, R.string.interactions_channel, NotificationManager.IMPORTANCE_HIGH);
        createChannel(context, BACKGROUND_REFRESH_CHANNEL, R.string.background_refresh_channel, NotificationManager.IMPORTANCE_DEFAULT);
        createChannel(context, TWEETING_NOTIFICATION_CHANNEL, R.string.tweeting_notifications_channel, NotificationManager.IMPORTANCE_LOW);
        createChannel(context, FAILED_TWEETS_CHANNEL, R.string.tweet_failure_channel, NotificationManager.IMPORTANCE_HIGH);
        createChannel(context, SENDING_SCHEDULED_MESSAGE_CHANNEL, R.string.scheduled_messages_channel, NotificationManager.IMPORTANCE_MIN);
        createChannel(context, MEDIA_DOWNLOAD_CHANNEL, R.string.media_downloads_channel, NotificationManager.IMPORTANCE_MIN);
        createChannel(context, WIDGET_REFRESH_CHANNEL, R.string.widget_refresh_channel, NotificationManager.IMPORTANCE_MIN);
    }

    private static void createChannel(Context context, String channelId, @StringRes int title, int priority) {
        final NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel testChannel = new NotificationChannel(channelId, context.getString(title), priority);
        manager.createNotificationChannel(testChannel);
    }
}