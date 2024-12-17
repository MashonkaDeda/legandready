package com.example.poxor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class StaffMember(val name: String, val position: String, val imageResId: Int)

class StaffAdapter(private val staffList: List<StaffMember>) :
    RecyclerView.Adapter<StaffAdapter.StaffViewHolder>() {

    class StaffViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val staffImage: ImageView = itemView.findViewById(R.id.staffImage)
        val staffName: TextView = itemView.findViewById(R.id.staffName)
        val staffPosition: TextView = itemView.findViewById(R.id.staffPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staff, parent, false)
        return StaffViewHolder(view)
    }

    override fun onBindViewHolder(holder: StaffViewHolder, position: Int) {
        val staff = staffList[position]
        holder.staffImage.setImageResource(staff.imageResId)
        holder.staffName.text = staff.name
        holder.staffPosition.text = staff.position
    }

    override fun getItemCount(): Int = staffList.size
}
