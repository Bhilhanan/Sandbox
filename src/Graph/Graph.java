package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph extends AdjacencyList {
	private final List<Vertex> vertexes;
	private final List<Edge> edges;
	private List<Vertex> topologicalOrder = new ArrayList<>();
	private Map<Vertex, ArrayList<Edge>> adjList;
	private Set<Vertex> visited;
	private Set<Vertex> unvisited;

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
		adjList = populateAdjacencyList(edges);
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public int getInDegree(Vertex vertex, List<Edge> edgeList) {
		if (vertex == null) {
			return 0;
		}
		int count = 0;
		for (Edge edge : edgeList) {
			if (edge.getDestination().getId().equals(vertex.getId())) {
				count++;
			}
		}
		return count;
	}

	public int getInDegree(Vertex v) {
		return getInDegree(v, edges);
	}

	public List<Vertex> getTopologicalOrder() {
		Stack<Vertex> stack = new Stack<>();
		List<Edge> clonedEdges = getClone();
		for (Vertex v : getVertexes()) {
			if (getInDegree(v, clonedEdges) == 0) {
				stack.push(v);
			}
		}
		while (!stack.isEmpty()) {
			Vertex v = stack.pop();
			processNode(v);
			for (Edge e : edges) {
				if (e.getSource().equals(v)) {
					clonedEdges.remove(e);
					if (getInDegree(e.getDestination(), clonedEdges) == 0) {
						stack.push(e.getDestination());
					}
				}
			}
		}
		return topologicalOrder;
	}

	// O(V^2+E)
	private ArrayList<Vertex> mstFrom() {
		visited = new HashSet<>();
		unvisited = new HashSet<>(vertexes);

		while (!unvisited.isEmpty() && doesVertexWithMinCostExists(Integer.MAX_VALUE)) {
			Vertex vertexWithMinCostToReach = findVertexWithMinCostToReach(unvisited);
			// Edge (vertexWithMinCostToReach.parent -> vertexWithMinCostToReach) will be part of MST

			assert vertexWithMinCostToReach != null;

			unvisited.remove(vertexWithMinCostToReach);
			visited.add(vertexWithMinCostToReach);

			if (adjList.get(vertexWithMinCostToReach) == null) {
				continue;
			}
			// O(E)
			for (Edge e : adjList.get(vertexWithMinCostToReach)) {
				if (unvisited.contains(e.getDestination()) && e.getWeight() < e.getDestination().minCostEdgeToReach) {
					e.getDestination().minCostEdgeToReach = e.getWeight();
					e.getDestination().parent = vertexWithMinCostToReach;
				}
			}
		}
		return new ArrayList<>(visited);

	}

	// O(V)
	private boolean doesVertexWithMinCostExists(Integer maxValue) {
		for (Vertex v : unvisited) {
			if (v.minCostEdgeToReach < maxValue) {
				return true;
			}
		}
		return false;
	}

	// O(V)
	private Vertex findVertexWithMinCostToReach(Set<Vertex> unvisited) {
		Vertex minCostVertex = new Vertex(null, null);
		minCostVertex.minCostEdgeToReach = Integer.MAX_VALUE;
		for (Vertex v : unvisited) {
			if (minCostVertex.minCostEdgeToReach > v.minCostEdgeToReach) {
				minCostVertex = v;
			}

		}
		return minCostVertex;
	}

	// O(E)
	private boolean edgesExists(ArrayList<Vertex> visited, ArrayList<Vertex> unvisited) {
		for (Edge e : edges) {
			if (visited.contains(e.getSource()) && unvisited.contains(e.getDestination())) {
				return true;
			}
		}
		return false;
	}

	private List<Edge> getClone() {
		List<Edge> clone = new ArrayList<>();
		clone.addAll(edges);
		return clone;
	}

	private void processNode(Vertex v) {
		topologicalOrder.add(v);
	}

	public boolean isStronglyConnected() {
		unvisited = adjList.keySet();
		for (Vertex v : vertexes) {
			visited = new HashSet<>();
			dfs(v);
			if (visited.size() != vertexes.size()) {
				System.out.println("Not strongly connected from=" + v.getId());
				return false;
			}
		}
		return true;
	}

	private Set<Vertex> dfsMain() {
		for (Vertex v : vertexes) {
			if (visited.contains(v)) {
				continue;
			}
			dfs(v);
		}
		return visited;
	}

	private void dfs(Vertex vertex) {
		if (visited.contains(vertex)) {
			return;
		}
		visited.add(vertex);
		ArrayList<Edge> connectedVertexes = adjList.get(vertex);
		if (!(connectedVertexes == null)) {
			for (Edge e : connectedVertexes) {
				dfs(e.getDestination());
			}
		}
		dfsProcessVertex(vertex);
	}

	private void dfsProcessVertex(Vertex v) {
		System.out.println(v.getId());
	}

	public boolean isWeaklyConnected() {
		visited = new HashSet<>();
		return dfsMain().size() == vertexes.size();
	}

	public int getOutDegree(Vertex vertex) {
		return adjList.get(vertex).size();
	}

	public ArrayList<Vertex> mstForest(Vertex vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Vertex> mstFromVertex(Vertex vertex) {
		for (Vertex v : vertexes) {
			v.parent = null;
			v.minCostEdgeToReach = Integer.MAX_VALUE;

			if (v.equals(vertex)) {
				v.minCostEdgeToReach = 0;
			}
		}
		return mstFrom();
	}
}