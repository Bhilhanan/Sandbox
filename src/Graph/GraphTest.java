package Graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private ArrayList<Vertex> nodes;
	private ArrayList<Edge> edges;
	private Graph graph;

	@Before
	public void testExcute() {
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 11; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			nodes.add(location);
		}

		addLane("Edge_0", 0, 1, 85);
		addLane("Edge_1", 0, 2, 217);
		addLane("Edge_2", 0, 4, 173);
		addLane("Edge_3", 2, 6, 186);
		addLane("Edge_4", 2, 7, 103);
		addLane("Edge_5", 3, 7, 183);
		addLane("Edge_6", 5, 8, 250);
		addLane("Edge_7", 8, 9, 84);
		addLane("Edge_8", 7, 9, 167);
		addLane("Edge_9", 4, 9, 502);
		addLane("Edge_10", 9, 10, 40);
		addLane("Edge_11", 1, 10, 600);
//		addLane("Edge_12", 6, 5, 600);
//		addLane("Edge_12", 6, 3, 600);

		graph = new Graph(nodes, edges);
	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		edges.add(lane);
	}

	@Test
	public void testInDegree() {
		assertEquals(3, graph.getInDegree(new Vertex("Node_9", "Node_9")));
	}
	
	@Test
	public void testOutDegree(){
		assertEquals(3, graph.getOutDegree(new Vertex("Node_0", "Node_0")));
	}

	@Test
	public void testTopologicalOrder() {
		List<Vertex> topologicalOrder = graph.getTopologicalOrder();
		System.out.println(topologicalOrder);
	}

	@Test
	public void testMinimumSpanningTree() {
		Map<Vertex, Vertex> mstEdges = graph.mstFromVertex(new Vertex("Node_0", "Node_0"));
		for (Entry<Vertex, Vertex> entry : mstEdges.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	
	@Test
	public void testIsStronglyConnected(){
		assertFalse(graph.isStronglyConnected());
	}
	
	@Test
	public void testIsWeaklyConnected(){
		assertTrue(graph.isWeaklyConnected());
	}
}