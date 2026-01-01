package collection

interface KIterator<out T> {
    operator fun next(): T
    operator fun hasNext(): Boolean
}

interface KListIterator<out T> : KIterator<T> {
    fun hasPrevious(): Boolean
    fun previous(): T
    fun nextIndex(): Int
    fun previousIndex(): Int
}

interface KIterable<out T> {
    operator fun iterator(): KIterator<T>
}

interface KCollection<out T> : KIterable<T> {
    val size: Int
    fun isEmpty(): Boolean
    operator fun contains(element: @UnsafeVariance T): Boolean
    fun containsAll(elements: KCollection<@UnsafeVariance T>): Boolean
}
