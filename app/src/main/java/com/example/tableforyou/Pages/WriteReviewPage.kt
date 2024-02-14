package com.example.tableforyou.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tableforyou.Camera.CameraActivity
import com.example.tableforyou.Data.MyData
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Data.RestorantList
import com.example.tableforyou.Elements.ReviewStarsClickable
import com.example.tableforyou.Elements.UpBarRev
import com.example.tableforyou.MainActivity


@Composable
fun WriteReviewPage(
    onBackClickedRev: (String) -> Unit = {},
    //restorant: Restorant,
    openCamera: () -> Unit,
    wrpId: String? = RestorantList.list.first().name,
    addImage:()->Unit
){
    val restorant = remember(wrpId) { RestorantList.getRestorant(wrpId) }
        WriteReviewBox(onBackClickedRev = onBackClickedRev, restorant, openCamera,addImage)
}

var photoTaken by  mutableStateOf(false)
var imageAdded by  mutableStateOf(false)
@Composable
fun WriteReviewBox(
    onBackClickedRev: (String) -> Unit = {},
    restorant: Restorant,
    openCamera: () -> Unit,
    addImage: () -> Unit
    ) {
    var text by remember { mutableStateOf("") }
    var vote by remember { mutableStateOf(0) }
    var rev by remember { mutableStateOf(false) }


    Column(modifier = Modifier.fillMaxSize()) {

        UpBarRev(titolo = "Write your review", back = true, onBackClickedRev = onBackClickedRev, restorant)
        vote=ReviewStarsClickable()
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(vertical = 30.dp),
            value = text,
            onValueChange = { text = it },
            label = { Text("Write your experience with us") }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            TextButton(onClick = openCamera) {
                Text("Take a photo")

            }
            TextButton(onClick = addImage) {
                Text("Take Image from gallery")
            }
            TextButton(
                onClick = { rev=true },
                enabled = if( vote == 0 ){false} else {true}
                ) {

                Text("Confirm")
            }

            if(rev){
                var i = CameraActivity().getPhotorev()
                if(photoTaken) i = CameraActivity().getPhotorev()
                else if (imageAdded) i = MainActivity().getImagerev()
                //completeReview(img = i  , note = text, vote = vote, user = Users.list[0])
                MyData().postReview(text,vote,restorant)
            }


        }
        if(photoTaken) {
            Image(
                painter = rememberAsyncImagePainter(CameraActivity().getPhotorev()),
                contentDescription = "img",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }
        if(imageAdded) {
            Image(
                painter = rememberAsyncImagePainter(MainActivity().getImagerev()),
                contentDescription = "img",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }
    }
}