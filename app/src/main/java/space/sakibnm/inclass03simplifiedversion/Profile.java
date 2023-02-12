package space.sakibnm.inclass03simplifiedversion;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Profile implements Parcelable {
    private String name, email, age;
    private int avatarDrawable;

    public Profile(){

    }

    public Profile(String name, String email, String age, int avatarDrawable) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.avatarDrawable = avatarDrawable;
    }

    protected Profile(Parcel in) {
        name = in.readString();
        email = in.readString();
        age = in.readString();
        avatarDrawable = in.readInt();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(age);
        parcel.writeInt(avatarDrawable);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getAvatarDrawable() {
        return avatarDrawable;
    }

    public void setAvatarDrawable(int avatarDrawable) {
        this.avatarDrawable = avatarDrawable;
    }


}
