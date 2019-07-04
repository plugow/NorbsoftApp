package com.plugow.norbsoftapp.data.local


class YTSearchList(
    val items: List<YTItem>
)

class YTItem(
    val snippet:Snippet
)

class Snippet(
    val title:String,
    val description:String,
    val thumbnails:Thumbnail
)

class Thumbnail(
    val medium:MediumThumbnail
)

class MediumThumbnail(
    val url:String
)