package com.example.oau_barter.modules

import android.net.Uri

data class PostItemModel (
   val profileName:String,
   val description:String,
   val tags:List<String>,
   val profilePic:Uri?,
   val itemImageList:List<Uri?>,
   val price:String
        )
