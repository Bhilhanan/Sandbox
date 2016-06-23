package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AdjacencyList{

	Map<Vertex,ArrayList<Vertex>> adjacencyList=new HashMap<>();
	
	public Map<Vertex,ArrayList<Vertex>> populateAdjacencyList(List<Edge> edges) {
		for(Edge edge:edges){
			ArrayList<Vertex> newList;
			Vertex source = edge.getSource();
			if(adjacencyList.containsKey(source)){
				newList = adjacencyList.get(source);
				newList.add(edge.getDestination());
				adjacencyList.put(source,newList);
				continue;
			}
			newList=new ArrayList<>();
			newList.add(edge.getDestination());
			adjacencyList.put(source,newList);
		}
		return adjacencyList;
	}

	public void printGraph() {
		for(Entry<Vertex, ArrayList<Vertex>> entry:adjacencyList.entrySet()){
			System.out.println(entry.getKey().getName()+" "+entry.getValue());
		}
	}
}