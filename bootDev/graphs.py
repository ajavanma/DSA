# A graph is an abstract data type that represents a set of vertices and the edges that connect those vertices.

# 	0	    1	    2	    3	    4
# 0	false	true	false	false	true
# 1	true	false	true	true	true
# 2	false	true	false	true	false
# 3	false	true	true	false	true
# 4	true	true	false	true	false


[
  [False, True, False, False, True],
  [True, False, True, True, True],
  [False, True, False, True, False],
  [False, True, True, False, True],
  [True, True, False, True, False]
]



class Graph:
    def __init__(self, num_vertices):
        # Fill the list with n lists, where n is the number of vertices in the graph
        # Each of these lists should contain n False values
        # Initialize the graph with num_vertices x num_vertices matrix filled with False
        # Each element in the inner lists represents whether there is an edge between the corresponding vertices
        #              inner loop                          # outer loop
        self.graph = [[False for _ in range(num_vertices)] for _ in range(num_vertices)]    # a list of lists


    # takes two vertices as inputs, and should add an edge to the graph by setting the corresponding cells to True
    def add_edge(self, u, v):
        # Add an edge by setting the corresponding cells to True
        self.graph[u][v] = True
        self.graph[v][u] = True  # Since it's an undirected graph

    def edge_exists(self, u, v):
        if u < 0 or u >= len(self.graph):
            return False
        if len(self.graph) == 0:
            return False
        row1 = self.graph[0]
        if v < 0 or v >= len(row1):
            return False
        return self.graph[u][v]

def main():
    g = Graph(5)  # Create a graph with 5 vertices
    g.add_edge(2, 3)  # Add edge between vertex 2 and vertex 3
    
    # Test if edge exists
    print(g.edge_exists(2, 3))  # prints True
    print(g.edge_exists(3, 2))  # prints True
    print(g.edge_exists(0, 1))  # prints False

main()














