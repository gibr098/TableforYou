package com.example.tableforyou.Elements

import androidx.compose.runtime.Composable
import com.example.tableforyou.Data.Restorant
import com.example.tableforyou.Data.Review
import com.example.tableforyou.Data.User

fun computerank1(restorant: Restorant)  {
    var rank = 0
    for (review in restorant.reviews) {
        for (vote in iterator<Int> { review.vote }) {
            rank += vote
        }
    }
    restorant.rank = (rank/(restorant.reviews.lastIndex + 1))
}

fun computerank(reviews: List<Review>) : Int {
    var rank = 0
    for (review in reviews ){
        rank+=review.vote
    }
    return rank/reviews.size
}

@Composable
fun completeReview(img: Int?, note: String, vote: Int, user: User){
    val newRev = Review(user,note,vote,img)
    OpenedReviewCard(
        onDismissRequest = { /*TODO*/ },
        onConfirmation = { /*TODO*/ },
        imageDescription = "",
        review = newRev
    )
}
/*
fun addPhoto() {
// Registers a photo picker activity launcher in single-select mode.
    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        // Callback is invoked after the user selects a media item or closes the
        // photo picker.
        if (uri != null) {
            Log.d("PhotoPicker", "Selected URI: $uri")
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

// Include only one of the following calls to launch(), depending on the types
// of media that you want to let the user choose from.

// Launch the photo picker and let the user choose images and videos.
    pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))


}*/