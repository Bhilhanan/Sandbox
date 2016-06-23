package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class Graph extends AdjacencyList{
	private final List<Vertex> vertexes;
	private final List<Edge> edges;
	private List<Vertex> topologicalOrder=new ArrayList<>();
	private Map<Vertex, ArrayList<Vertex>> adjList;
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
	
	public int getInDegree(Vertex vertex,List<Edge> edgeList) {
		if(vertex==null){
			return 0;
		}
		int count=0;
		for(Edge edge:edgeList){
			if(edge.getDestination().getId().equals(vertex.getId())){
				count++;
			}
		}
		return count;
	}
	
	public int getInDegree(Vertex v){
		return getInDegree(v,edges);
	}

	public List<Vertex> getTopologicalOrder() {
		Stack<Vertex> stack=new Stack<>();
		List<Edge> clonedEdges = getClone();
		for(Vertex v:getVertexes()){
			if(getInDegree(v,clonedEdges)==0){
				stack.push(v);
			}
		}
		while(!stack.isEmpty()){
			Vertex v=stack.pop();
			processNode(v);
			for(Edge e:edges){
				if(e.getSource().equals(v)){
					clonedEdges.remove(e);
					if(getInDegree(e.getDestination(),clonedEdges)==0){
						stack.push(e.getDestination());
					}
				}
			}
		}
		return topologicalOrder;
	}

	public Map<Vertex, Vertex> mstFromVertex(Vertex v) {
		ArrayList<Vertex> visited = new ArrayList<>();
		ArrayList<Vertex> unvisited = new ArrayList<>(vertexes);
		unvisited.remove(v);
		visited.add(v);
		Map<Vertex/*child*/,Vertex/*parent*/> mstEdges=new HashMap<>();
		mstEdges.put(v,null);
		while(!unvisited.isEmpty() && edgesExists(visited,unvisited)){
			Edge minWeightEdge = findMinWeightEdge(visited,unvisited);
			assert minWeightEdge!=null;
			mstEdges.put(minWeightEdge.getDestination(), minWeightEdge.getSource());
			unvisited.remove(minWeightEdge.getDestination());
			visited.add(minWeightEdge.getDestination());
		}
		return mstEdges;
		
	}

	private Edge findMinWeightEdge(ArrayList<Vertex> visited, ArrayList<Vertex> unvisited) {
		Edge minEdge=new Edge(null, null, null, Integer.MAX_VALUE);
		for(Edge e:edges){
			if(visited.contains(e.getSource()) && unvisited.contains(e.getDestination())){
				if(minEdge.getWeight()>e.getWeight()){
					minEdge=e;
				}
			}
		}
		return minEdge;
	}

	//O(E)
	private boolean edgesExists(ArrayList<Vertex> visited, ArrayList<Vertex> unvisited) {
		for(Edge e:edges){
			if(visited.contains(e.getSource()) && unvisited.contains(e.getDestination())){
				return true;
			}
		}
		return false;
	}

	private List<Edge> getClone() {
		List<Edge> clone=new ArrayList<>();
		clone.addAll(edges);
		return clone;
	}

	private void processNode( Vertex v) {
		topologicalOrder.add(v);
	}

	public boolean isStronglyConnected() {
		unvisited = adjList.keySet();
		for(Vertex v:vertexes){
			visited = new HashSet<>();
			dfs(v);
			if(visited.size()!=vertexes.size()){
				System.out.println("Not strongly connected from="+v.getId());
				return false;
			}
		}
		return true;
	}

	private Set<Vertex> dfsMain() {
		for(Vertex v:vertexes){
			if(visited.contains(v)){
				continue;
			}
			dfs(v);
		}
		return visited;
	}

	private void dfs(Vertex vertex) {
		if(visited.contains(vertex)){
			return;
		}
		visited.add(vertex);
		ArrayList<Vertex> connectedVertexes = adjList.get(vertex);
		if(!(connectedVertexes==null)){
			for(Vertex v:connectedVertexes){
				dfs(v);
			}
		}
		dfsProcessVertex(vertex);
	}

	private void dfsProcessVertex(Vertex v) {
		System.out.println(v.getId());
	}

	public boolean isWeaklyConnected() {
		visited = new HashSet<>();
		return dfsMain().size()==vertexes.size();
	}

	public int getOutDegree(Vertex vertex) {
		return adjList.get(vertex).size();
	}
}