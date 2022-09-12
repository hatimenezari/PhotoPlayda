package com.hatim.photoplay.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hatim.photoplay.R
import com.hatim.photoplay.data.entities.Document

class DocumentsAdapter(private val documents: List<Document>) :
    RecyclerView.Adapter<DocumentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_document, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val document = documents[position]
        holder.flightNumber.text = document.flightNumber.toString()
        holder.link.text = document.links.toString()

    }

    override fun getItemCount(): Int {
        return documents.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val flightImage: ImageView = itemView.findViewById(R.id.document_image)
        val flightNumber: TextView = itemView.findViewById(R.id.document_flight_number)
        val link: TextView = itemView.findViewById(R.id.document_link)
    }
}