package com.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Driver {

	private List<Vertex> nodes;
	private List<Edge> edges;

	public static void main(String args[]) {
		new Driver().execute();
	}

	public void execute() {
		// TODO Auto-generated method stub
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();

		// Define Floor access
		nodes.add(new Vertex("0", "RECEPTION"));
		nodes.add(new Vertex("1", "LIFT"));

		// Define floors
		nodes.add(new Vertex("2", "1F"));

		// nodes.add(new Vertex("", "3F"));

		// define 1ST floor layout
		nodes.add(new Vertex("3", "1F-LOBY"));
		nodes.add(new Vertex("4", "1F-PUBLIC-AREA"));
		nodes.add(new Vertex("5", "1F-PANTRY"));

		// set lift cost as 0'
		addLane("RECEPTION", 0, 1, 10, "Go Straight and turn right after 200m");
		addLane("LIFT", 1, 0, 10, "Take the Lift");

		addLane("LIFT", 1, 2, 1, "Take the lift to 1st floor");

		addLane("1F", 2, 1, 1, "Take the lift from 1st floor");

		// Adding first floor cost
		addLane("1F", 2, 3, 10, "Continue ahead for 100m");
		addLane("1F-LOBY", 3, 4, 10, "Continue ahead for 100m");
		addLane("1F-PUBLIC-AREA", 4, 5, 10, "Continue ahead for 100m");

		addLane("1F-PANTRY", 5, 4, 10, "Continue ahead for 100m");
		addLane("1F-PUBLIC-AREA", 4, 3, 10, "Continue ahead for 100m");
		addLane("1F-LOBY", 3, 2, 10, "Continue ahead for 100m");

		// Second Floor
		nodes.add(new Vertex("6", "2F"));
		nodes.add(new Vertex("7", "2F-LOBY"));
		nodes.add(new Vertex("8", "2F-PUBLIC-AREA"));
		nodes.add(new Vertex("9", "2F-PANTRY"));

		addLane("LIFT", 1, 6, 1, "Take the lift to 2nd Floor");
		addLane("2F", 6, 1, 1, "Take the lift");
		addLane("2F", 6, 7, 10, "Continue ahead for 100m");
		addLane("2F-LOBY", 7, 8, 10, "Continue ahead for 100m");
		addLane("2F-PUBLIC-AREA", 8, 9, 10, "Continue ahead for 100m");

		addLane("2F-PANTRY", 9, 8, 10, "Continue ahead for 100m");
		addLane("2F-PUBLIC-AREA", 8, 7, 10, "Continue ahead for 100m");
		addLane("2F-LOBY", 7, 6, 10, "Continue ahead for 100m");

		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

		dijkstra.execute(nodes.get(9));
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(5));

		for (Vertex vertex : path) {
			System.out.println(vertex + " [" + edges.get(Integer.parseInt(vertex.getId())).getDirections() + "]");
		}
		System.out.print("[You have arrived]");

	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration, String route) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration, route);
		edges.add(lane);
	}

}
