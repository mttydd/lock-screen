package com.ns;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class LockWidgetProvider extends AppWidgetProvider
{
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
	{
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++)
		{
			int appWidgetId = appWidgetIds[i];
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.lock_widget);
			Intent intentClick = new Intent(context, LockScreenActivity.class);
			PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentClick, 0);
			remoteViews.setOnClickPendingIntent(R.id.imageView1, pendingIntent);
			appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
		}
	}
}
