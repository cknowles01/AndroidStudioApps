import android.adservices.topics.Topic
import android.os.ext.SdkExtensions
import androidx.annotation.RequiresExtension
import com.example.gridapp.R

object DataSource {
    @RequiresExtension(extension = SdkExtensions.AD_SERVICES, version = 4)
    val topics = listOf(
        Topic(R.string.architecture.toLong(), 58, R.drawable.the_scream),
        Topic(R.string.crafts.toLong(), 121, R.drawable.the_scream),
        Topic(R.string.business.toLong(), 78, R.drawable.the_scream),
        Topic(R.string.culinary.toLong(), 118, R.drawable.the_scream),
        Topic(R.string.design.toLong(), 423, R.drawable.the_scream),
        Topic(R.string.fashion.toLong(), 92, R.drawable.the_scream),
        Topic(R.string.film.toLong(), 165, R.drawable.the_scream),
        Topic(R.string.gaming.toLong(), 164, R.drawable.the_scream),
        Topic(R.string.drawing.toLong(), 326, R.drawable.the_scream),
        Topic(R.string.lifestyle.toLong(), 305, R.drawable.the_scream),
        Topic(R.string.music.toLong(), 212, R.drawable.the_scream),
        Topic(R.string.painting.toLong(), 172, R.drawable.the_scream),
        Topic(R.string.photography.toLong(), 321, R.drawable.the_scream),
        Topic(R.string.tech.toLong(), 118, R.drawable.the_scream)
    )
}