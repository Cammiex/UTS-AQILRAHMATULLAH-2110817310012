import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewuts.*

class Adapter  : RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        val textDesc: TextView = itemView.findViewById(R.id.textDesc)
        val imageContent: ImageView = itemView.findViewById(R.id.imageContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.textTitle.text = currentItem.itemsTitle
        holder.textDesc.text = currentItem.itemsDescription
        holder.imageContent.setImageResource(currentItem.itemsImages)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("itemsTitle", currentItem.itemsTitle)
            intent.putExtra("itemsDescription", currentItem.itemsDescription)
            intent.putExtra("itemsImages", currentItem.itemsImages)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}