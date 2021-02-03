package com.koreait.websocketclient;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

@Data
public class Board implements Parcelable {
    private int board_id;
    private String title;
    private String writer;
    private String content;
    private String regdate;
    private int hit;

    public Board(){

    }

    //데이터 받을때
    protected Board(Parcel in) {
        board_id = in.readInt();
        title = in.readString();
        writer = in.readString();
        content = in.readString();
        regdate = in.readString();
        hit = in.readInt();
    }

    public static final Creator<Board> CREATOR = new Creator<Board>() {
        @Override
        public Board createFromParcel(Parcel in) {
            return new Board(in);
        }

        @Override
        public Board[] newArray(int size) {
            return new Board[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //보낼때
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(board_id);
        dest.writeString(title);
        dest.writeString(writer);
        dest.writeString(content);
        dest.writeString(regdate);
        dest.writeInt(hit);
    }
}
