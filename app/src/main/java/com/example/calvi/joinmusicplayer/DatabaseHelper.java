package com.example.calvi.joinmusicplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaMetadataRetriever;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "data.db";
    private static final String LOG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;

    // TABLE NAMES
    private static final String TABLE_MUSIC = "musics";
    private static final String TABLE_PLAYLIST = "playlists";

    // COLUM NAMES
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_URL = "url";

    private static final String CREATE_TABLE_MUSICS = "CREATE TABLE IF NOT EXISTS " + TABLE_MUSIC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
            + KEY_URL + " TEXT" + ")";

    private static final String CREATE_TABLE_PLAYLIST = "CREATE TABLE IF NOT EXISTS " + TABLE_MUSIC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
            + KEY_URL + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.i("test", "coba clear table");

        String clearDBQuery = "DELETE FROM "+ TABLE_MUSIC;
        sqLiteDatabase.execSQL(clearDBQuery);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSIC);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYLIST);

        sqLiteDatabase.execSQL(CREATE_TABLE_MUSICS);
        sqLiteDatabase.execSQL(CREATE_TABLE_PLAYLIST);

        addData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSIC);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYLIST);

        onCreate(sqLiteDatabase);
    }

    public void addData(SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_TITLE, "01_The Beatles_Love Me Do.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/01_The%20Beatles_Love%20Me%20Do.mp3?alt=media&token=1fcdb4fa-8cc2-4ae4-8575-1a6bb49f3cb4");

        long result = database.insert(TABLE_MUSIC, null, contentValues);

        /*contentValues.put(KEY_TITLE, "02_The Beatles_From Me To You.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/02_The%20Beatles_From%20Me%20To%20You.mp3?alt=media&token=9bd6ba1f-616c-4aa3-b535-638416656d80");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "03_The Beatles_She Loves You.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/03_The%20Beatles_She%20Loves%20You.mp3?alt=media&token=98b8382e-07fa-4bc2-965e-2c6f6d22d16a");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "04_The Beatles_I Want To Hold Your Hand.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/04_The%20Beatles_I%20Want%20To%20Hold%20Your%20Hand.mp3?alt=media&token=93789a81-8842-48f5-8b34-2a52106ed258");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "05_The Beatles_Can't Buy Me Love.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/05_The%20Beatles_Can't%20Buy%20Me%20Love.mp3?alt=media&token=6da71e05-08cf-4977-879e-80f8e6c6f801");

        result = database.insert(TABLE_MUSIC, null, contentValues);*/

        /*contentValues.put(KEY_TITLE, "06_The Beatles_A Hard Day's Night.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/06_The%20Beatles_A%20Hard%20Day's%20Night.mp3?alt=media&token=27dfa5c7-e86d-4a96-bc8e-0ada14f704c2");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "07_The Beatles_I Feel Fine.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/07_The%20Beatles_I%20Feel%20Fine.mp3?alt=media&token=b94aae3d-d82c-494e-982a-9416dd1ea3c4");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "08_The Beatles_Eight Days A Week.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/08_The%20Beatles_Eight%20Days%20A%20Week.mp3?alt=media&token=584467e2-a56a-49d4-883f-e52135f73ba4");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "09_The Beatles_Ticket To Ride.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/09_The%20Beatles_Ticket%20To%20Ride.mp3?alt=media&token=2053ac70-0597-43bc-9b62-e734b33546a9");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "10_The Beatles_Help!.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/10_The%20Beatles_Help!.mp3?alt=media&token=c8fc1fe5-62d2-45e1-946a-fc3a7b43bb1d");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "11_The Beatles_Yesterday.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/11_The%20Beatles_Yesterday.mp3?alt=media&token=87bc94f6-d448-42ba-a044-ba08c50c4a2e");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "12_The Beatles_Day Tripper.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/12_The%20Beatles_Day%20Tripper.mp3?alt=media&token=173f8fcf-2294-4ffc-99f8-251203db8449");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "13_The Beatles_We Can Work It Out.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/13_The%20Beatles_We%20Can%20Work%20It%20Out.mp3?alt=media&token=de4bf63e-b04b-41d3-b402-18abf05656a4");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "14_The Beatles_Paperback Writer.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/14_The%20Beatles_Paperback%20Writer.mp3?alt=media&token=ee10ba68-0c7a-4d8c-92e4-6a5d25129f83");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "15_The Beatles_Yellow Submarine.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/15_The%20Beatles_Yellow%20Submarine.mp3?alt=media&token=95e93f8d-0baa-4e0b-a1f5-b28070d5440c");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "16_The Beatles_Eleanor Rigby.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/16_The%20Beatles_Eleanor%20Rigby.mp3?alt=media&token=7be5946b-3e1b-4ca9-b92f-fa1042ad6c17");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "17_The Beatles_Penny Lane.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/17_The%20Beatles_Penny%20Lane.mp3?alt=media&token=ad0f0128-efaa-4721-94cb-1a661cfd64e7");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "18_The Beatles_All You Need Is Love.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/18_The%20Beatles_All%20You%20Need%20Is%20Love.mp3?alt=media&token=259ff9f7-1e42-416e-857f-f8bfbbb7483b");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "19_The Beatles_Hello Goodbye.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/19_The%20Beatles_Hello%20Goodbye.mp3?alt=media&token=ee070272-db8a-453b-9eea-3473a398cf33");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "20_The Beatles_Lady Madonna.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/20_The%20Beatles_Lady%20Madonna.mp3?alt=media&token=7e386b41-8730-4de4-b490-ba1d665972ef");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "21_The Beatles_Hey Jude.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/21_The%20Beatles_Hey%20Jude.mp3?alt=media&token=589fbb05-db15-45fc-903e-78131029a98d");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "22_The Beatles_Get Back.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/22_The%20Beatles_Get%20Back.mp3?alt=media&token=e12d14fc-89f2-4a9b-bc84-ef7cbe7d8506");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "23_The Beatles_The Ballad Of John And Yoko.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/23_The%20Beatles_The%20Ballad%20Of%20John%20And%20Yoko.mp3?alt=media&token=250df2bc-47b0-4f1f-8a44-f164d4e87f1f");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "24_The Beatles_Something.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/24_The%20Beatles_Something.mp3?alt=media&token=5ea91518-3e69-4412-a227-d8de412a27fd");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "25_The Beatles_Come Together.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/25_The%20Beatles_Come%20Together.mp3?alt=media&token=dce9fe58-1484-4a6f-916a-57cb024d9fc2");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "26_The Beatles_Let It Be.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/26_The%20Beatles_Let%20It%20Be.mp3?alt=media&token=7cfd695a-55b9-4e5c-91c5-ac007a76e5b3");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "CLOSER.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/CLOSER.mp3?alt=media&token=e6934f13-0508-43ae-bc3f-b3afa70b950a");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "LATATA.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/LATATA.mp3?alt=media&token=dfee2e14-1af9-4f1c-9e12-beabdaaaa0dd");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "LIAR LIAR.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/LIAR%20LIAR.mp3?alt=media&token=7a0c00fa-0aaa-41d1-a5c9-df163dc609ab");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Perfect Day.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/Perfect%20Day.mp3?alt=media&token=767d3856-59cb-4bd3-a158-385729dcbae7");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "The Greatest Showman - A Million Dreams.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/The%20Greatest%20Showman%20-%20A%20Million%20Dreams.mp3?alt=media&token=3f617071-8029-4551-9b35-c27fd86232c3");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "The Greatest Showman - Never Enough.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/The%20Greatest%20Showman%20-%20Never%20Enough.mp3?alt=media&token=097eb249-1ed5-42fd-8fa7-afc773d16b85");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "WINDY DAY.mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/WINDY%20DAY.mp3?alt=media&token=c35c8e64-089a-458b-9d81-295ea549141f");

        result = database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "한 (一).mp3");
        contentValues.put(KEY_URL, "https://firebasestorage.googleapis.com/v0/b/joinmusic-8499b.appspot.com/o/%ED%95%9C%20(%E4%B8%80).mp3?alt=media&token=63451102-a943-480a-98cc-6eec669340d8");

        result = database.insert(TABLE_MUSIC, null, contentValues);*/
    }

    public List<DataModel> getData() {
        List<DataModel> data = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_MUSIC + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;

        while (cursor.moveToNext()) {
            dataModel = new DataModel();

            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(cursor.getString(cursor.getColumnIndexOrThrow("url")), new HashMap<String, String>());

                String title = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                String duration = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                String artist = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                String album = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);

                Log.i("test", title);

                dataModel.setTitle(title);
                dataModel.setDuration(duration);
                dataModel.setAlbum(album);
                dataModel.setArtist(artist);

                stringBuffer.append(dataModel);
                data.add(dataModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }
}
