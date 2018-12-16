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

    private static final String DATABASE_NAME = "newData.db";
    private static final String LOG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;

    // TABLE NAMES
    private static final String TABLE_MUSIC = "musicsDB";
    private static final String TABLE_PLAYLIST = "playlistsDB";

    // COLUM NAMES
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_ARTIST = "artist";
    private static final String KEY_ALBUM = "album";
    private static final String KEY_ALBUM_IMAGE = "image";
    private static final String KEY_URL = "url";

    private static final String CREATE_TABLE_MUSICS = "CREATE TABLE IF NOT EXISTS " + TABLE_MUSIC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
            + KEY_ARTIST + " TEXT," + KEY_ALBUM + " TEXT,"
            + KEY_ALBUM_IMAGE + " TEXT," + KEY_URL + " TEXT" + ")";

    private static final String CREATE_TABLE_PLAYLIST = "CREATE TABLE IF NOT EXISTS " + TABLE_MUSIC
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
            + KEY_ARTIST + " TEXT," + KEY_ALBUM + " TEXT,"
            + KEY_ALBUM_IMAGE + " TEXT," + KEY_URL + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

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

        contentValues.put(KEY_TITLE, "Love Me Do");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1DV7VohknL-f5KCXY9zdFr6gRq9iIHzEB");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "From Me To You");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1SDYD2YY9kDQANdWgibHrpOOJSh5Ms86f");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "She Loves You");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1Y7RH1tq2Qh9aMZb81vuOM0Taea5CgxfU");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "I Want To Hold Your Hand");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1ULoBBxr0wK_xy07X6CChis0m7b4HD-BB");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Can't Buy Me Love");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=14atCytduQvIQ5-E2NkZryvnl0BjfH7jc");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "A Hard Day's Night");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1uNo6vXIUBs7dl3kWWE3WaKDO7xi4BFf3");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "I Feel Fine");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1MKWkFw559W7Kuj_O2AQC2tJyyo139YOE");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Eight Days A Week");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=197rvmQIXZxznFLGuQfhcZyCzvJZ1QXrN");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Ticket To Ride");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1El8dIJh1XE3yWhMx_qVcpHe1ye-hw969");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Help!");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1cAPo3QLqSH_GlzN1HrA3Jj1Q_MMw6INL");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Yesterday");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1J30V6OgHsUroyJTOCmC2It2-uNEy11Ug");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Day Tripper");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1aMA8KdWr53pcKaZe4LuEKqPkU3XQ5Htp");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "We Can Work It Out");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=14Q4PM6qSBaCMbgIChpGvXnUwI-ODXpjZ");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Paperback Writer");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1OOmeE5pPzhIIGcbbe-EY7YE-UYzhrDEK");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Yellow Submarine");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1KDotSBnUnGPowNatphAjQwyL0XSSWOTH");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Eleanor Rigby");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1aZiTsuVqvqQFMxxIrEV8iECcyh329SoA");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Penny Lane");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=119IoZP3GqtROGoHvmDn7pbZ0tWmYliZm");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "All You Need Is Love");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1za_EkTHzJ2zj45L8YQGE6HiiApPNMnfD");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Hello Goodbye");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1p7xp3OmYdJkAUJ0Cb5YhvC4jDI_vHRtx");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Lady Madonna");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1HHkQGl1SIice2sqzA_DLXKOc3EsXRECd");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Hey Jude");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=15JRuwxcUBCiRE2f0fdWnLPgpZjMpgJZb");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Get Back");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1tmZTg66var9WsJPoKzjd-97kpP6WM5xk");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "The Ballad Of John And Yoko");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1VlBg1LPZb7OMklmUancCgMi027DBcTdQ");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Something");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1FhSqLuM6C5aE3NYITWq3ZmNv8a2dIEfa");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Come Together");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1vuESC_NKn_a9XWN7alzwwWUecAcB1zdq");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Let It Be");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1Uc-dWhTytFCBRaS83GVAQpXJHPDmOkdB");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1CjpqhDmnGpw3CyBJUiEI0k4NYsehXkTE");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "CLOSER");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1TQh3Ga2Ufe_Kpf9d9alTx4IYcAskIuXN");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1lYg2Y72Dmij-BkDs0vYKKY6M-7Jf_Vpi");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "LATATA");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1TQh3Ga2Ufe_Kpf9d9alTx4IYcAskIuXN");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1WXsYmfG6eO2IbPcQaI-OMsWh0CK3vrYe");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "LIAR LIAR");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1TQh3Ga2Ufe_Kpf9d9alTx4IYcAskIuXN");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1sdRMnTJjkYrNm-HHj2XVix1RojsavClp");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "Perfect Day");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1TQh3Ga2Ufe_Kpf9d9alTx4IYcAskIuXN");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1h5eJP9h8qMqCcwUkvikn_CgzVhabEJbr");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "WINDY DAY");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1TQh3Ga2Ufe_Kpf9d9alTx4IYcAskIuXN");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1Yvvc5141H6odU_6QxTDt_L4YlRZTObq4");
        database.insert(TABLE_MUSIC, null, contentValues);

        contentValues.put(KEY_TITLE, "한 (一)");
        contentValues.put(KEY_ARTIST, "The Beatles");
        contentValues.put(KEY_ALBUM, "The Beatles 1");
        contentValues.put(KEY_ALBUM_IMAGE, "https://docs.google.com/uc?export=download&id=1TQh3Ga2Ufe_Kpf9d9alTx4IYcAskIuXN");
        contentValues.put(KEY_URL, "https://docs.google.com/uc?export=download&id=1byjVHp_6hL_g_9tNhb6yJC6NFpkMZMGs");
        database.insert(TABLE_MUSIC, null, contentValues);
    }

    public ArrayList<DataModel> getData() {
        ArrayList<DataModel> data = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_MUSIC + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;

        while (cursor.moveToNext()) {
            dataModel = new DataModel();
            dataModel.setTitle(cursor.getString(cursor.getColumnIndexOrThrow("title")));
            dataModel.setArtist(cursor.getString(cursor.getColumnIndexOrThrow("artist")));
            dataModel.setAlbum(cursor.getString(cursor.getColumnIndexOrThrow("album")));
            dataModel.setImage(cursor.getString(cursor.getColumnIndexOrThrow("image")));
            dataModel.setUrl(cursor.getString(cursor.getColumnIndexOrThrow("url")));

            Log.i("Coba", cursor.getString(cursor.getColumnIndexOrThrow("title")));
            data.add(dataModel);
        }

        return data;
    }
}
