/*
Name: Brian Yang
UNI: by2289
 */


// BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//               or an array containing initial items
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 *
 * @author Mark Allen Weiss
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the binary heap.
     */
    public BinaryHeap()
    {
        this(DEFAULT_CAPACITY);
        this.itemMap = new java.util.HashMap<>();
    }

    /**
     * Construct the binary heap.
     *
     * @param capacity the capacity of the binary heap.
     */
    public BinaryHeap(int capacity)
    {
        currentSize = 0;
        array = (AnyType[]) new Comparable[capacity + 1];
        keyArray = new double[capacity + 1];
        this.itemMap = new java.util.HashMap<>();
    }
    /**
     * Construct the binary heap given an array of items.
     */
    public BinaryHeap(AnyType[] items, double[] keys)
    {
        this.itemMap = new java.util.HashMap<>();
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];
        keyArray = new double[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (AnyType item : items)
        {
            itemMap.put(item, i);
            array[i++] = item;
        }

        i = 1;
        for(double key : keys)
        {
            keyArray[i++] = key;
        }
        buildHeap();
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x, double key)
    {
        if (currentSize == array.length - 1)
        {
            enlargeArray(array.length * 2 + 1);
        }

        // Percolate up
        int hole = ++currentSize;
        for (keyArray[0] = key; key < keyArray[hole / 2]; hole /= 2)
        {
            itemMap.replace(array[hole/2], hole);
            array[hole] = array[hole / 2];
            keyArray[hole] = keyArray[hole / 2];
        }
        itemMap.put(x, hole);
        array[hole] = x;
        keyArray[hole] = key;
    }


    private void enlargeArray(int newSize)
    {
        AnyType[] old = array;
        double [] oldKeys = keyArray;
        array = (AnyType[]) new Comparable[newSize];
        keyArray = new double[newSize];
        for (int i = 0; i < old.length; i++)
        {
            array[i] = old[i];
            keyArray[i] = oldKeys[i];
            itemMap.replace(array[i], i);
        }
    }

    /**
     * Find the smallest item in the priority queue.
     *
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType findMin()
    {
        if (isEmpty())
        {
            throw new UnderflowException();
        }
        return array[1];
    }

    /**
     * Remove the smallest item from the priority queue.
     *
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType deleteMin()
    {
        if (isEmpty())
        {
            throw new UnderflowException();
        }

        AnyType minItem = findMin();
        itemMap.remove(minItem);
        array[1] = array[currentSize - 1];
        keyArray[1] = keyArray[currentSize - 1];
        currentSize--;
        percolateDown(1);

        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap()
    {
        for (int i = currentSize / 2; i > 0; i--)
        {
            percolateDown(i);
        }
    }

    /**
     * Test if the priority queue is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty()
    {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;      // Number of elements in heap
    private AnyType[] array;      // The heap array
    private double[] keyArray;         // The array of keys - parallel to the heap array
    private java.util.Map<AnyType, Integer> itemMap; // The map of vertices to their indices

    /**
     * Internal method to percolate down in the heap.
     *
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole)
    {
        int child;
        AnyType tmp = array[hole];
        double keyTmp = keyArray[hole];
        for (; hole * 2 <= currentSize; hole = child)
        {
            child = hole * 2;
            if (child != currentSize && keyArray[child + 1] < keyArray[child])
            {
                child++;
            }
            if (keyArray[child] < keyTmp)
            {
                itemMap.replace(array[child], hole);
                array[hole] = array[child];
                keyArray[hole] = keyArray[child];
            }
            else
            {
                break;
            }
        }
        array[hole] = tmp;
        keyArray[hole] = keyTmp;
        itemMap.replace(tmp, hole);
    }

    public void decreaseKey(AnyType x, double newDistance)
    {
        // Percolate up
        int hole = itemMap.get(x);
        for (keyArray[0] = newDistance; newDistance < keyArray[hole / 2]; hole /= 2)
        {
            itemMap.replace(array[hole / 2], hole);
            array[hole] = array[hole / 2];
            keyArray[hole] = keyArray[hole / 2];
        }
        array[hole] = x;
        keyArray[hole] = newDistance;
        itemMap.replace(x, hole);
    }
}
