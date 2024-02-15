package com.example.tableforyou.Elements

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import com.example.tableforyou.Data.Review

@Composable
fun ReviewColumn(modifier: Modifier = Modifier, reviews: List<Review>){
    Reviews(reviews)
}

@Composable
fun Reviews(reviews: List<Review>){
    LazyColumn {
        items(reviews) { reviews ->
            ReviewCard(Modifier ,reviews)
        }

    }

}


@Composable
fun ReviewCard(modifier: Modifier = Modifier, review: Review) {
    var showBigReview by remember { mutableStateOf(false) }
    Spacer(modifier = Modifier.size(15.dp))
    ElevatedCard(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            //.fillMaxWidth()
            .height(110.dp)
            .border(width = 1.dp, shape = RoundedCornerShape(30.dp), color = Color.LightGray)
            .padding(all = 0.dp)
            .clickable { showBigReview = true }
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column() {
                Image(
                    painter = rememberAsyncImagePainter(model = Uri.parse(review.user.profile_img)),//painterResource(review.user.profile_img),
                    //painter = painterResource(res.logo),
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        // Set image size to 40 dp
                        .size(80.dp)
                        // Clip image to be shaped as a circle
                        .clip(CircleShape)
                        .border(
                            1.5.dp,
                            MaterialTheme.colorScheme.primary,
                            CircleShape
                        )
                )
            }

            Column() {
                Text(
                    text = review.user.name,
                    fontSize = 20.sp
                )

                Row {
                    ReviewStars(review)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = review.note,
                    fontSize = 15.sp
                )


            }

        }
    }
    if(showBigReview){
        OpenedReviewCard(
            onDismissRequest = { showBigReview = false },
            onConfirmation = { /*TODO*/ },
            //painter = painterResource(id = review.img!!),
            imageDescription = "photo",
            review = review
        )
    }
}

@Composable
fun OpenedReviewCard(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    //painter: Painter,
    imageDescription: String,
    review: Review
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp),
            //.padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column() {
                            Image(
                                painter = rememberAsyncImagePainter(model = Uri.parse(review.user.profile_img)),//painterResource(review.user.profile_img),
                                //painter = painterResource(res.logo),
                                contentDescription = "Contact profile picture",
                                modifier = Modifier
                                    // Set image size to 40 dp
                                    .size(80.dp)
                                    // Clip image to be shaped as a circle
                                    .clip(CircleShape)
                                    .border(
                                        1.5.dp,
                                        MaterialTheme.colorScheme.primary,
                                        CircleShape
                                    )
                            )
                        }

                        Column() {
                            Text(
                                text = review.user.name,
                                fontSize = 20.sp
                            )

                            Row {
                                ReviewStars(review)
                            }


                        }
                        IconButton(
                            onClick = { onDismissRequest() },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Icon(Icons.Rounded.Clear, contentDescription = "close")
                        }

                    }


                }
                LazyColumn {
                    item {
                        Text(
                            text = review.note,
                            modifier = Modifier.padding(16.dp),
                        )
                        if (review.img != null) {
                            Image(
                                //painter = rememberAsyncImagePainter(model = Uri.parse(review.img)),//painterResource(id = review.img!!),
                                painter = rememberAsyncImagePainter(model = review.img.toUri()),
                                contentDescription = imageDescription,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .height(160.dp)
                            )
                        }
                    }
                }

            }
        }
    }
}



