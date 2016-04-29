import java.util.*;

/**
 * PriorityQueue class implemented via the binary heap.
 */
public class PriorityQueue extends AbstractCollection
        implements Queue
{

    // Data Fields
    /** The ArrayList to hold the data. */
    private List < Customer > theData;

    /** An optional reference to a Comparator object. */
    Comparator comparator = null;
    /**
     * Construct an empty PriorityQueue.
     */
    public PriorityQueue( )
    {

        comparator = null;
        theData = new ArrayList<Customer>();
    }

    /**
     * Construct an empty PriorityQueue with a specified comparator.
     */
    /*public PriorityQueue( Comparator<? super E> c )
    {

        comparator = (Comparator<E>) c;
        theData = new ArrayList<E>();
    }*/


    /**
     * Construct a PriorityQueue from another Collection.
     */
   /* public PriorityQueue( Collection<? extends E> coll )
    {
        comparator = null;

        theData = (List<E>) coll;

    }*/

    /**
     * Compares lhs and rhs using comparator if
     * provided by cmp, or the default comparator.
     */
    private int compare( Customer lhs, Customer rhs )
    {
        if( comparator == null ){

            System.out.println("Comparator is null. Default comparator is on");
            return ((Comparable)lhs).compareTo( rhs );
        }

        else
            return comparator.compare( lhs, rhs );
    }

    /**
     * Adds an item to this PriorityQueue.
     * @param x any object.
     * @return true.
     */
    public boolean add( Customer x )
    {
       /* if( currentSize + 1 == array.length )
            doubleArray( );

        // Percolate up
        int hole = ++currentSize;
        array[ 0 ] = x;

        for( ; compare( x, array[ hole / 2 ] ) < 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;*/
        if(theData.size()==0)
        {
            theData.add(x);
            return true;
        }
        else {
            for (int i = 0; i < theData.size(); i++) {
                if (x.getName().equals("Customer1")) {
                    if (theData.get(i).getName().equals("Customer1"))
                        continue;
                    theData.add(i, x);
                    return true;
                }
                if (x.getName().equals("Customer2")) {
                    if (theData.get(i).getName().equals("Customer1"))
                        continue;
                    if (theData.get(i).getName().equals("Customer2"))
                        continue;
                    theData.add(i,x);
                    return true;
                }
            }
            if(x.getName().equals("Customer3")) {
                theData.add(x);
                return true;
            }
        }
        return true;
    }

    //public boolean offer(Customer anyType) {
      //  return false;
    //}

    /**
     * Returns the number of items in this PriorityQueue.
     * @return the number of items in this PriorityQueue.
     */
    public int size( )
    {
        return theData.size();
    }

    /**
     * Make this PriorityQueue empty.
     */
    public void clear( )
    {
        theData.clear();
    }

    /**
     * Returns an iterator over the elements in this PriorityQueue.
     * The iterator does not view the elements in any particular order.
     */
    public Iterator iterator( )
    {
        return new Iterator( )
        {
            int current = 0;

            public boolean hasNext( )
            {
                return current != size( );
            }

            public Customer next( )
            {
                if( hasNext( ) )
                    return theData.get(++current);
                else
                    throw new NoSuchElementException( );
            }

            public void remove( )
            {
                throw new UnsupportedOperationException( );
            }
        };
    }

    /**
     * Returns the smallest item in the priority queue.
     * @return the smallest item.
     * @throws NoSuchElementException if empty.
     */
    public Customer element( )
    {
        if( isEmpty( ) )
            throw new NoSuchElementException( );
        return theData.get(0);
    }

    public Customer peek() {
        return null;
    }

    public boolean offer(Object o) {

        add(o);
        return true;
    }

    /**
     * Removes the smallest item in the priority queue.
     * @return the smallest item.
     * @throws NoSuchElementException if empty.
     */
    public Customer remove( )
    {
       /* E minItem = element( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;*/
        return null;
    }

    public Customer poll() {

        Customer cus=theData.get(0);
        theData.remove(0);
        return cus;
    }

}