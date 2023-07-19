val intent = Intent(this,clickme::class.java) //to open another activity

val intent = Intent().apply{        //to create url
    action = Intent.ACTION_VIEW
    data = Uri.parse("Link")
}

// -> -> Recycler View


var viewManager = LinearLayoutManager(this) //initailize linear layout manager for recycler view in kotlin

//creating adapter -> to feed all data to list  //Here Textview
class MyAdapter(private val myDataset: Array<String>) :

    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        class MyViewHolder(val textView: TextView) :

            RecyclerView.ViewHolder(textView)
            // Create new views (invoked by the layout manager)
            override fun onCreateViewHolder(parent: ViewGroup,
            viewType: Int): MyAdapter.MyViewHolder {
            // create a new view
            val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false) as TextView
            return MyViewHolder(textView)
            }
            // Replace the contents of a view
            // (invoked by the layout manager)
            override fun onBindViewHolder(holder: MyViewHolder,
            position: Int) {
            //get element from your dataset at this position
            //replace the contents of the view with that element
            holder.textView.text = myDataset[position]
            }
            // Return the size of your dataset
            // (invoked by the layout manager)
            override fun getItemCount() = myDataset.size
}


/*Whenever the list changes, the adapter needs to be notified using the
“notifyDatasetChanged()” function so as to reflect the changes in the list as the adapter isn’t
smart enough to reflect those changes on its own.*/


//creating custom adapter for list to reflect the items
class CustomAdapter: ListAdapter<User, CustomAdapter.ItemViewholder>
(DiffCallback()) {
        override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int): ItemViewholder {
        //can be same as before
        }
        override fun onBindViewHolder
        (holder: CustomAdapter.ItemViewholder, position: Int) {
        //can be same as before
        }
        class ItemViewholder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        //can be same as before
        }
        }
        class DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User?,
        newItem: User?): Boolean {
        return oldItem?.id == newItem?.id
        }
        override fun areContentsTheSame(oldItem: User?,
        newItem: User?): Boolean {
        return oldItem == newItem
 }
}


//The objects of RecyclerViews can be created using the following code segment:  

    viewManager = LinearLayoutManager(this)
    viewAdapter = MyAdapter(myDataset)
    recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
    .apply {
    setHasFixedSize(true)
    layoutManager = viewManager
    adapter = viewAdapter
}