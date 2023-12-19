package com.example.pruebapedro

import android.os.Parcel
import android.os.Parcelable

class Book(
    private var title: String?,
    private var pages:Int?,
    private var author:String?,
    private var year:Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        pages?.let { parcel.writeInt(it) }
        parcel.writeString(author)
        year?.let { parcel.writeInt(it) }
    }

    override fun toString(): String {
        return "Title: $title, Pages: $pages, Author: $author, Year: $year"
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
    fun getAuthor() : String? {
        return author
    }
    fun getPages() :Int?{
        return pages
    }
    fun getTitle() : String? {
        return title
    }
    fun getYear() :Int?{
        return year
    }



}