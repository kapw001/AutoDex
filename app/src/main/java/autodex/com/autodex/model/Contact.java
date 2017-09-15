package autodex.com.autodex.model;

import android.net.Uri;

/**
 * Created by Alexandr Timoshenko <thick.tav@gmail.com> on 11/13/15.
 */
public class Contact {
    private String mName;
    private Uri uri;
    private int imgId;

    public boolean is_favourite() {
        return is_favourite;
    }

    public void setIs_favourite(boolean is_favourite) {
        this.is_favourite = is_favourite;
    }

    private boolean is_favourite = true;

    public Contact(String mName, int imgId, String number) {
        this.mName = mName;
        this.imgId = imgId;
        this.number = number;
    }

    private String number;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Contact(String pName, Uri uri) {
        mName = pName;
        this.uri = uri;
    }

    public String getName() {
        return mName;
    }

    public void setName(String pName) {
        mName = pName;
    }
}
