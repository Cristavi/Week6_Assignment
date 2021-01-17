package com.jenish.week6assignment1.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jenish.week6assignment1.R
import com.jenish.week6assignment1.models.Students

class StudentAdapter(
       val listStudents : ArrayList<Students>,
       val context: Context
) : RecyclerView.Adapter<StudentAdapter.StudentView>(){
    class StudentView(view : View) :
            RecyclerView.ViewHolder(view){
        val imgUrl : ImageView
        val tvName : TextView
        val tvAge : TextView
        val tvAddress : TextView
        val imgDelete : ImageView
        val tvGender : TextView

        init {
            imgUrl = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            imgDelete = view.findViewById(R.id.imgDel)
            tvGender = view.findViewById(R.id.tvGender)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentView {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.students, parent, false)

        return StudentView(view)
    }

    override fun getItemCount(): Int {
        return listStudents.size
    }

    override fun onBindViewHolder(holder: StudentView, position: Int) {
        val student = listStudents[position]

        holder.tvName.text = student.studentName
        holder.tvAge.text = student.age.toString()
        holder.tvAddress.text = student.address
        holder.tvGender.text = student.gender

        Glide.with(context).load(student.imgUrl).into(holder.imgUrl)

        holder.imgDelete.setOnClickListener{
            listStudents.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, listStudents.size)
        }
    }


}