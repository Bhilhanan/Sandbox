package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AdjacencyList{

	Map<Vertex,ArrayList<Edge>> adjacencyList=new HashMap<>();
	
	public Map<Vertex, ArrayList<Edge>> populateAdjacencyList(List<Edge> edges) {
		for(Edge edge:edges){
			ArrayList<Edge> newList;
			Vertex source = edge.getSource();
			if(adjacencyList.containsKey(source)){
				newList = adjacencyList.get(source);
				newList.add(edge);
				adjacencyList.put(source,newList);
				continue;
			}
			newList=new ArrayList<>();
			newList.add(edge);
			adjacencyList.put(source,newList);
		}
		return adjacencyList;
	}

	public void printGraph() {
		for(Entry<Vertex, ArrayList<Edge>> entry:adjacencyList.entrySet()){
			System.out.println(entry.getKey().getName()+" "+entry.getValue());
		}
	}
}