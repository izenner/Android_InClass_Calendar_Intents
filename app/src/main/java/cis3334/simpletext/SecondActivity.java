package cis3334.simpletext;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	String eventNum;		// number of the event from mainActivity
	TextView tvTitle, tvSum, tvLoc, tvDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);
		
		tvTitle = (TextView) findViewById(R.id.txtTitle);
		tvSum = (TextView) findViewById(R.id.txtSummary);
		tvLoc = (TextView) findViewById(R.id.txtLocation);
		tvDate = (TextView) findViewById(R.id.txtDate);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    eventNum = extras.getString("eventNum");
		}
		
		if (eventNum.equals("1")) {
			tvTitle.setText("Black Violin");
			tvSum.setText("Voted one of the Top 5 New Bands at SXSW in 2013, Black Violin is an American hip hop duo from Florida comprised of  two classically trained string instrumentalists, Kev Marcus and Wil B. Kev Marcus plays the violin and Wil B. plays the viola. Black Violin clinched the Showtime at the Apollo 2005 Legend title.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("TUESDAY, FEBRUARY 24, 2015");
		}
		if (eventNum.equals("2")) {
			tvTitle.setText("Click Clack Moo");
			tvSum.setText("\"Cows that type? Hens on strike! Whoever heard of such a thing!\" Farmer Brown cries.\n" +
                    "When his granddaughter Jenny comes for a visit, Farmer Brown declared the farm a \"tech-free zone.\" He confiscates her laptop in the cold barn along with the shivering cows who use her computer to type messages requesting blankets.\n" +
                    "\"No way,\" replies Farmer Brown. \"No blankets!\"\n" +
                    "So the cows go on strike and the chickens join them in solidarity. No blankets: no milk, no eggs!\n" +
                    "Will Farmer Brown give in to the animals' demands? Will Jenny get her computer back? Find out in a hilariously \"mooooo-ving\" new musical about negotiation and compromise, based on the Caldecott Honor Book by Doreen Cronin and Betsy Lewin.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("THURSDAY, FEBRUARY 26, 2015");
		}
		if (eventNum.equals("3")) {
			tvTitle.setText("Thistle and Shamrocks");
			tvSum.setText("Presented by the Duluth Scottish Heritage Association. An evening of Scottish and Irish music and dance.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("FRIDAY, March 6, 2015");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout_second, menu);
		return true;
	}
	
	public void onClickSendText (View v) {
		
		if (eventNum.equals("1")) {
		
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Black Violin");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			GregorianCalendar begDate = new GregorianCalendar(2015, 1, 24, 7, 30);
			GregorianCalendar endDate = new GregorianCalendar(2015, 1, 24, 9, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					begDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("2")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Click Clack Moo");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
            GregorianCalendar begDate = new GregorianCalendar(2015, 1, 26, 12, 30);
            GregorianCalendar endDate = new GregorianCalendar(2015, 1, 26, 1, 30);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    begDate.getTimeInMillis());
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("3")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Thistle and Shamrocks");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			Calendar beginTime = Calendar.getInstance();
			beginTime.set(2015, 2, 6, 7, 00);
			Calendar endTime = Calendar.getInstance();
			endTime.set(2015, 2, 6, 8, 00);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					beginTime.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endTime.getTimeInMillis());
			startActivity(calIntent);

		}
		

	}
	

}
