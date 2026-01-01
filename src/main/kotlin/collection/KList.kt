package collection

interface KList<out T> : KCollection<T> {
    operator fun get(index: Int): T
    fun indexOf(element: @UnsafeVariance T): Int
    fun lastIndexOf(element: @UnsafeVariance T): Int
    fun listIterator(): KListIterator<T>
    fun listIterator(index: Int): KListIterator<T>
    fun subList(fromIndex: Int, toIndex: Int): KList<T>
}

class KArrayList<T>(private vararg val elements: T) : KList<T> {

    override val size: Int = elements.size
    override fun isEmpty(): Boolean = size == 0

    override fun indexOf(element: T): Int {
        for (index in elements.indices) {
            if (elements[index] == element) return index
        }

        return -1
    }

    override fun contains(element: T): Boolean = indexOf(element) >= 0

    override fun get(index: Int): T {
        if (index !in elements.indices) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }

        return elements[index]
    }

    override fun lastIndexOf(element: T): Int {
        for (index in elements.indices.reversed()) {
            if (elements[index] == element) return index
        }

        return -1
    }

    override fun listIterator(): KListIterator<T> = KArrayListIterator(0)

    override fun listIterator(index: Int): KListIterator<T> = KArrayListIterator(index)

    override fun iterator(): KIterator<T> = listIterator()

    override fun subList(fromIndex: Int, toIndex: Int): KList<T> {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex, Size: $size")
        }
        val slice = elements.sliceArray(fromIndex until toIndex)
        return KArrayList(*slice)
    }

    override fun containsAll(elements: KCollection<T>): Boolean {
        for (e in elements) {
            if (!contains(e)) return false
        }

        return true
    }

    override fun toString(): String {
        return elements.joinToString(prefix = "[", postfix = "]", separator = ", ")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is KList<*>) return false
        if (size != other.size) return false

        val otherIterator = other.iterator()
        for (elem in elements) {
            val otherElem = otherIterator.next()
            if (elem != otherElem) return false
        }
        return true
    }

    override fun hashCode(): Int {
        var hashCode = 1
        for (e in elements) {
            hashCode = 31 * hashCode + (e?.hashCode() ?: 0)
        }
        return hashCode
    }

    private inner class KArrayListIterator(var index: Int) : KListIterator<T> {
        init {
            if (index < 0 || index > size) {
                throw IndexOutOfBoundsException("Index: $index, Size: $size")
            }
        }

        override fun hasNext(): Boolean = index < size

        override fun nextIndex(): Int = index

        override fun previousIndex(): Int = index - 1

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            return elements[index++]
        }

        override fun hasPrevious(): Boolean = index > 0

        override fun previous(): T {
            if (!hasPrevious()) throw NoSuchElementException()
            return elements[--index]
        }
    }
}
