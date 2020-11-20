package com.nek.android_movieviewer
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nek.testmovies.Movie

class MovieAdapter(val data: List<Movie> ): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(val v: TextView) : RecyclerView.ViewHolder(v)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = TextView(parent.context)
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.v.text = item.name
        holder.v.setOnClickListener{
            val intent: Intent = Intent(holder.v.context, MainActivity::class.java)
            intent.putExtra("MovieID", item.name)
            holder.v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = data.size
}
