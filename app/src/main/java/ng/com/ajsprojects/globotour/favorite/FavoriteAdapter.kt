package ng.com.ajsprojects.globotour.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import ng.com.ajsprojects.globotour.R
import ng.com.ajsprojects.globotour.city.City

class FavoriteAdapter(val context: Context, var favoriteCityList: MutableList<City>): RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item_city, parent, false)
        return FavoriteViewHolder(itemView)
    }

    override fun onBindViewHolder(favoriteViewHolder: FavoriteViewHolder, position: Int) {
        val city = favoriteCityList[position]
        favoriteViewHolder.setData(city, position)
    }

    override fun getItemCount(): Int = favoriteCityList.size

    inner class FavoriteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var currentPosition: Int = -1
        private var currentCity: City?   = null

        private val txvCityName = itemView.findViewById<TextView>(R.id.txv_city_name)
        private val imvCityImage= itemView.findViewById<ImageView>(R.id.imv_city)
        private val imvDelete   = itemView.findViewById<ImageView>(R.id.imv_delete)
        private val imvFavorite = itemView.findViewById<ImageView>(R.id.imv_favorite)

        private val icFavoriteFilledImage = ResourcesCompat.getDrawable(context.resources,
            R.drawable.ic_favorite_filled, null)
        private val icFavoriteBorderedImage = ResourcesCompat.getDrawable(context.resources,
            R.drawable.ic_favorite_bordered, null)

        fun setData(city: City, position: Int) {

            txvCityName.text = city.name
            imvCityImage.setImageResource(city.imageId)

            if (city.isFavorite)
                imvFavorite.setImageDrawable(icFavoriteFilledImage)
            else
                imvFavorite.setImageDrawable(icFavoriteBorderedImage)

            this.currentPosition = position
            this.currentCity = city
        }

    }
}