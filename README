# Dijkstra

In addition please include a detailed README.txt file which 
indicates exactly 
what files you are submitting, what problem they solve, 
and how to compile and run them.

Name: Brian Yang
UNI: by2289


The files included in this submission are:

written.txt
Dijkstra.java
BinaryHeap.java
Display.java, Edge.java, Vertex.java
citypairs.txt, cityxy.txt
graph.ml
README.txt



The following files are used

Dijkstra.java
BinaryHeap.java
Display.java, Edge.java, Vertex.java
citypairs.txt, cityxy.txt
graph.ml


To run the program, compile all of the .java files listed
above. The main is in Display.java Thus, you would
compile with javac:

javac *.java

Then run TestKBest.java:

java Display.java

I modified a few methods in Display.java:


1. computeEuclideanDistance - this just returned the euclidean distance
			      given two (x,y) coordinates.
			      We used the simple formula of
			      sqrt((x_2-x_1)^2+(y_2-y_1)^2)

2. computeAllEuclideanDistances - this method computed all the distances 
                                  for each of the edges in the graph.
                                  We iterate through each vertex in vertexNames.
				  For each vertex, we iterate through its
				  list of adjacent vertices (edges)
				  and calculate the distance between the two
				  vertices by calling computeEuclideanDistance

3. doDijkstra - this method uses a min heap to do Dijkstra's algorithm.
                First, we iterate through all the vertices in vertexNames,
		setting each vertex's distance to positive infinity and 
		known to false. If the vertex is the starting vertex, we 
		set the distance of the starting vertex to 0. Then, we add
		each vertex to a min heap ordered based on the distance
		attribute.
		To ensure we can choose a new starting point during the run
		of our algorithm, we also set the starting vertex's prev to
		null. 
		While the min heap isn't empty, we deleteMin() to get the
		shortest distance unknown vertex v from the starting vertex.
		We set that vertex's known to true.
		Then, we traverse through its list of adjacent vertices.
		For each adjacent vertex, if it is not known, and if the 
		cost of getting to that vertex from the starting vertex
		(calculated by adding the distance attribute of v to the
		distance between v and the adjacent vertex), then we update
		the adjacent vertex's distance attribute to the shorter
		distance to get from the starting to that vertex. Then, we
		decrease that vertex's key in the min heap, and set the
		vertex's prev attribute to v.

4. getDijkstraPath - This method gets a list of edges that represents the 
		     shortest path from a starting vertex s to a ending
		     vertex t. We first call doDijkstra(s) to calculate the
		     shortest paths from s to every other vertex in the graph.
		     Then, starting from vertex t, we traverse t's prev vertex's
		     list of adjacent vertices to find the edge between t's 
		     previous vertex and t. Once found, we add that edge to a
		     list. We repeatedly add to the front of the list, so when
		     when method is over, the list will contain the edges sorted
    		     from starting at s and going to t.



In the BinaryHeap class, I made some modifications as well. First,
to facilitate the decreaseKey method, we have an array of keys
that we will use instead of the array of values (Vertices). Every time we
traverse the heap, we will parallel traverse both key and value arrays.

For the added method decreaseKey, we find the hole where that vertex is
by storing a hash map whose keys are the vertices and values are the
indices of the corresponding vertices. This allows us to find the index 
of the vertex we need to operate on. After that, we do a percolate up on 
both arrays, using the keyArray values to manipulate where the hole goes.
Besides that, the percolate up algorithm is the same as that given in the 
insert method.


