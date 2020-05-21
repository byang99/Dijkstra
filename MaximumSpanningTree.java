public class MaximumSpanningTree
{
    /*
    void dijkstra( Vertex s )
    {
        for each Vertex v
        {
            v.dist = INFINITY;
            v.known = false;
        }
        s.dist = 0;
        while( there is an unknown distance vertex )
        {
            Vertex v = smallest unknown distance vertex;
            v.known = true;
            for each Vertex w adjacent to v
            if( !w.known )
            {
                DistType cvw = cost of edge from v to w;
                if( cvw < w.dist )
                {
                    // Update w
                    decrease( w.dist to v.dist + cvw );
                    w.path = v;
                }
            }
        }
     }
     */
    /*
    ArrayList<Edge> kruskal( List<Edge> edges, int numVertices )
    {
        DisjSets ds = new DisjSets( numVertices );
        PriorityQueue<Edge> pq = new PriorityQueue<>( edges );
        List<Edge> mst = new ArrayList<>( );
        while( mst.size( ) != numVertices - 1 )
        {
            Edge e = pq.deleteMin( ); // Edge e = (u, v)
            SetType uset = ds.find( e.getu( ) );
            SetType vset = ds.find( e.getv( ) );
            if( uset != vset )
            {
                // Accept the edge
                mst.add( e );
                ds.union( uset, vset );
            }
        }
        return mst;
    }
    */
}
