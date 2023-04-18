import com.example.devvoca.Util.ObservableArrayListCallback

class ObservableArrayList<T>(var onItemAddedCallback:(T) -> Unit,var onItemListAddedCallback:(Collection<T>) -> Unit) : ArrayList<T>() {

    override fun add(element: T): Boolean {
        val result = super.add(element)
        if(result)
        {
            onItemAddedCallback
        }
        return result
    }

    override fun addAll(elements: Collection<T>): Boolean {
        val result = super.addAll(elements)
        if(result)
        {
            onItemListAddedCallback
        }
        return result
    }

    override fun remove(element: T): Boolean {
        return super.remove(element)
    }

    override fun set(index: Int, element: T): T {
        return super.set(index, element)
    }

}